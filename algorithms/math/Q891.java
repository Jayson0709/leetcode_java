package algorithms.math;

import utils.InputMethods;

import java.util.Arrays;

//The width of a sequence is the difference between the maximum and minimum elements in the sequence.
//
//    Given an array of integers nums, return the sum of the widths of all the non-empty subsequences of nums. Since the answer may be very large, return it modulo 109 + 7.
//
//    A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
//
//    Example 1:
//    Input: nums = [2,1,3]
//    Output: 6
//    Explanation: The subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
//    The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
//    The sum of these widths is 6.
//
//    Example 2:
//    Input: nums = [2]
//    Output: 0
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^5


//一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。
//
//    给你一个整数数组 nums ，返回 nums 的所有非空 子序列 的 宽度之和 。由于答案可能非常大，请返回对 109 + 7 取余 后的结果。
//
//    子序列 定义为从一个数组里删除一些（或者不删除）元素，但不改变剩下元素的顺序得到的数组。例如，[3,6,2,7] 就是数组 [0,3,1,6,2,2,7] 的一个子序列。
//
//    示例 1：
//    输入：nums = [2,1,3]
//    输出：6
//    解释：子序列为 [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3] 。
//    相应的宽度是 0, 0, 0, 1, 1, 2, 2 。
//    宽度之和是 6 。
//
//    示例 2：
//    输入：nums = [2]
//    输出：0
//
//    提示：
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^5


public class Q891 {
    public static void main(String[] args) {
        System.out.println(sumSubseqWidths(InputMethods.getInputForOneIntArray()));
    }

    private static int sumSubseqWidths(int[] nums) {
        final int MOD = 1000000007;
        Arrays.sort(nums);
        long res = 0;
        long x = nums[0], y = 2;
        for (int j = 1; j < nums.length; j++) {
            res = (res + nums[j] * (y - 1) - x) % MOD;
            x = (x * 2 + nums[j]) % MOD;
            y = y * 2 % MOD;
        }
        return (int) ((res + MOD) % MOD);
    }
}
