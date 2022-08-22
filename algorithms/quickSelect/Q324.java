package algorithms.quickSelect;

import utils.InputMethods;
import utils.OutputMethods;

import java.util.Arrays;
import java.util.Random;


//Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//
//    You may assume the input array always has a valid answer.
//    
//    Example 1:
//    Input: nums = [1,5,1,1,6,4]
//    Output: [1,6,1,5,1,4]
//    Explanation: [1,4,1,5,1,6] is also accepted.
//    
//    Example 2:
//    Input: nums = [1,3,2,2,3,1]
//    Output: [2,3,1,3,1,2]
//
//    Constraints:
//    1 <= nums.length <= 5 * 104
//    0 <= nums[i] <= 5000
//    It is guaranteed that there will be an answer for the given input nums.
//
//    Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?


//给你一个整数数组nums，将它重新排列成nums[0] < nums[1] > nums[2] < nums[3]...的顺序。
//
//    你可以假设所有输入数组都可以得到满足题目要求的结果。
//
//    示例 1：
//    输入：nums = [1,5,1,1,6,4]
//    输出：[1,6,1,5,1,4]
//    解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
//
//    示例 2：
//    输入：nums = [1,3,2,2,3,1]
//    输出：[2,3,1,3,1,2]
//
//    提示：
//    1 <= nums.length <= 5 * 104
//    0 <= nums[i] <= 5000
//    题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
//
//    进阶：你能用O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？


public class Q324 {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] nums = InputMethods.getInputForOneIntArray();
        wiggleSort(nums);
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
    }

    public static void wiggleSort(int[] nums) {
        int n = nums.length;
        int x = (n + 1) / 2;
        int mid = x - 1;
        int target = findKthLargest(nums, n - mid);
        for (int k = 0, i = 0, j = n - 1; k <= j; k++) {
            if (nums[k] > target) {
                while (j > k && nums[j] > target) {
                    j--;
                }
                swap(nums, k, j--);
            }
            if (nums[k] < target) {
                swap(nums, k, i++);
            }
        }
        int[] arr = nums.clone();
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public static int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public static int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

