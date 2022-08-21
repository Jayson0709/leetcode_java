package algorithms.sorting;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an array of integers nums, sort the array in ascending order.
//
//    Example 1:
//    Input: nums = [5,2,3,1]
//    Output: [1,2,3,5]
//
//    Example 2:
//    Input: nums = [5,1,1,2,0,0]
//    Output: [0,0,1,1,2,5]
//
//    Constraints:
//    1 <= nums.length <= 5 * 10^4
//    -5 * 10^4 <= nums[i] <= 5 * 10^4



//给你一个整数数组 nums，请你将该数组升序排列。
//
//    示例 1：
//    输入：nums = [5,2,3,1]
//    输出：[1,2,3,5]
//
//    示例 2：
//    输入：nums = [5,1,1,2,0,0]
//    输出：[0,0,1,1,2,5]
//
//    提示：
//    1 <= nums.length <= 5 * 10^4
//    -5 * 10^4 <= nums[i] <= 5 * 10^4



public class Q912 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        int[] result = sortArray(nums);
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    // Version 1: Quick Sort
//    private static int[] sortArray(int[] nums) {
//        randomizedQuicksort(nums, 0, nums.length - 1);
//        return nums;
//    }
//
//    public static void randomizedQuicksort(int[] nums, int l, int r) {
//        if (l < r) {
//            int pos = randomizedPartition(nums, l, r);
//            randomizedQuicksort(nums, l, pos - 1);
//            randomizedQuicksort(nums, pos + 1, r);
//        }
//    }
//
//    public static int randomizedPartition(int[] nums, int l, int r) {
//        int i = new Random().nextInt(r - l + 1) + l; // randomly pick one pivot
//        swap(nums, r, i);
//        return partition(nums, l, r);
//    }
//
//    public static int partition(int[] nums, int l, int r) {
//        int pivot = nums[r];
//        int i = l - 1;
//        for (int j = l; j <= r - 1; ++j) {
//            if (nums[j] <= pivot) {
//                i = i + 1;
//                swap(nums, i, j);
//            }
//        }
//        swap(nums, i + 1, r);
//        return i + 1;
//    }
//
//    private static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }


    // Method 2: Heap Sort
//    private static int[] sortArray(int[] nums) {
//        heapSort(nums);
//        return nums;
//    }
//
//    public static void heapSort(int[] nums) {
//        int len = nums.length - 1;
//        buildMaxHeap(nums, len);
//        for (int i = len; i >= 1; --i) {
//            swap(nums, i, 0);
//            len -= 1;
//            maxHeapify(nums, 0, len);
//        }
//    }
//
//    public static void buildMaxHeap(int[] nums, int len) {
//        for (int i = len / 2; i >= 0; --i) {
//            maxHeapify(nums, i, len);
//        }
//    }
//
//    public static void maxHeapify(int[] nums, int i, int len) {
//        while ((i << 1) + 1 <= len) {
//            int lSon = (i << 1) + 1;
//            int rSon = (i << 1) + 2;
//            int large;
//            if (lSon <= len && nums[lSon] > nums[i]) {
//                large = lSon;
//            } else {
//                large = i;
//            }
//            if (rSon <= len && nums[rSon] > nums[large]) {
//                large = rSon;
//            }
//            if (large != i) {
//                swap(nums, i, large);
//                i = large;
//            } else {
//                break;
//            }
//        }
//    }
//
//    private static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }


    // Method 3: Merge Sort
    static int[] tmp;

    private static int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        if (r - l + 1 >= 0) System.arraycopy(tmp, 0, nums, l, r - l + 1);
    }
}
