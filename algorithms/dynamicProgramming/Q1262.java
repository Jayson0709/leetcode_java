package algorithms.dynamicProgramming;

import utils.InputMethods;


//Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.
//
//    Example 1:
//    Input: nums = [3,6,5,1,8]
//    Output: 18
//    Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
//
//    Example 2:
//    Input: nums = [4]
//    Output: 0
//    Explanation: Since 4 is not divisible by 3, do not pick any number.
//
//    Example 3:
//    Input: nums = [1,2,3,4,4]
//    Output: 12
//    Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
//
//    Constraints:
//    1 <= nums.length <= 4 * 10^4
//    1 <= nums[i] <= 10^4


//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
//
//    示例 1：
//    输入：nums = [3,6,5,1,8]
//    输出：18
//    解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
//
//    示例 2：
//    输入：nums = [4]
//    输出：0
//    解释：4 不能被 3 整除，所以无法选出数字，返回 0。
//
//    示例 3：
//    输入：nums = [1,2,3,4,4]
//    输出：12
//    解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
//
//    提示：
//    1 <= nums.length <= 4 * 10^4
//    1 <= nums[i] <= 10^4


public class Q1262 {
    public static void main(String[] args) {
        System.out.println(maxSumDivThree(InputMethods.getInputForOneIntArray()));
    }

    private static int maxSumDivThree(int[] nums) {
        int[] f = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            int[] g = new int[3];
            System.arraycopy(f, 0, g, 0, 3);
            for (int i = 0; i < 3; ++i) {
                g[(i + num % 3) % 3] = Math.max(g[(i + num % 3) % 3], f[i] + num);
            }
            f = g;
        }
        return f[0];
    }
}
