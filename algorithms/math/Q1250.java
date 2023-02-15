package algorithms.math;

import utils.InputMethods;


//Given an array nums of positive integers. Your task is to select some subset of nums, multiply each element by an integer and add all these numbers. The array is said to be good if you can obtain a sum of 1 from the array by any possible subset and multiplicand.
//
//    Return True if the array is good otherwise return False.
//
//    Example 1:
//    Input: nums = [12,5,7,23]
//    Output: true
//    Explanation: Pick numbers 5 and 7.
//    5*3 + 7*(-2) = 1
//
//    Example 2:
//    Input: nums = [29,6,10]
//    Output: true
//    Explanation: Pick numbers 29, 6 and 10.
//    29*1 + 6*(-3) + 10*(-1) = 1
//
//    Example 3:
//    Input: nums = [3,6]
//    Output: false
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^9


//给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
//
//    假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
//
//    示例 1：
//    输入：nums = [12,5,7,23]
//    输出：true
//    解释：挑选数字 5 和 7。
//    5*3 + 7*(-2) = 1
//
//    示例 2：
//    输入：nums = [29,6,10]
//    输出：true
//    解释：挑选数字 29, 6 和 10。
//    29*1 + 6*(-3) + 10*(-1) = 1
//
//    示例 3：
//    输入：nums = [3,6]
//    输出：false
//
//    提示：
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^9


public class Q1250 {
    public static void main(String[] args) {
        System.out.println(isGoodArray(InputMethods.getInputForOneIntArray()));
    }

    private static boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int num : nums) {
            divisor = gcd(divisor, num);
            if (divisor == 1) {
                break;
            }
        }
        return divisor == 1;
    }

    public static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
