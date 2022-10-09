package algorithms.search.binarySearch;

import utils.InputMethods;
import utils.OneDIntArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

//The distance of a pair of integers a and b is defined as the absolute difference between a and b.
//
//    Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.
//
//    Example 1:
//    Input: nums = [1,3,1], k = 1
//    Output: 0
//    Explanation: Here are all the pairs:
//    (1,3) -> 2
//    (1,1) -> 0
//    (3,1) -> 2
//    Then the 1st smallest distance pair is (1,1), and its distance is 0.
//
//    Example 2:
//    Input: nums = [1,1,1], k = 2
//    Output: 0
//
//    Example 3:
//    Input: nums = [1,6,1], k = 3
//    Output: 5
//
//    Constraints:
//    n == nums.length
//    2 <= n <= 104
//    0 <= nums[i] <= 106
//    1 <= k <= n * (n - 1) / 2


//数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
//
//    给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
//
//    示例 1：
//    输入：nums = [1,3,1], k = 1
//    输出：0
//    解释：数对和对应的距离如下：
//    (1,3) -> 2
//    (1,1) -> 0
//    (3,1) -> 2
//    距离第 1 小的数对是 (1,1) ，距离为 0 。
//
//    示例 2：
//    输入：nums = [1,1,1], k = 2
//    输出：0
//
//    示例 3：
//    输入：nums = [1,6,1], k = 3
//    输出：5
//
//    提示：
//    n == nums.length
//    2 <= n <= 104
//    0 <= nums[i] <= 106
//    1 <= k <= n * (n - 1) / 2


public class Q719 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDIntArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(smallestDistancePair(obj.array, obj.val));
    }

    private static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int left = 0;
        int right = nums[length - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int dist = 0;
            for (int j = 0; j < length; j++) {
                int i = binarySearch(nums, j, nums[j] - mid);
                dist += j - i;
            }
            if (dist >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int binarySearch(int[] nums, int end, int target) {
        int left = 0;
        int right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
