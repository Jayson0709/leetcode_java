package algorithms.dynamicProgramming;

import utils.InputMethods;

import java.util.HashSet;
import java.util.Set;


//You are given an integer array nums.
//
//    You should move each element of nums into one of the two arrays A and B such that A and B are non-empty, and average(A) == average(B).
//
//    Return true if it is possible to achieve that and false otherwise.
//
//    Note that for an array arr, average(arr) is the sum of all the elements of arr over the length of arr.
//
//    Example 1:
//    Input: nums = [1,2,3,4,5,6,7,8]
//    Output: true
//    Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have an average of 4.5.
//
//    Example 2:
//    Input: nums = [3,1]
//    Output: false
//
//    Constraints:
//    1 <= nums.length <= 30
//    0 <= nums[i] <= 10^4


//给定你一个整数数组 nums
//
//    我们要将 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和 B 数组不为空，并且 average(A) == average(B) 。
//
//    如果可以完成则返回true ， 否则返回 false  。
//
//    注意：对于数组 arr ,  average(arr) 是 arr 的所有元素除以 arr 长度的和。
//
//    示例 1:
//    输入: nums = [1,2,3,4,5,6,7,8]
//    输出: true
//    解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
//
//    示例 2:
//    输入: nums = [3,1]
//    输出: false
//
//    提示:
//    1 <= nums.length <= 30
//    0 <= nums[i] <= 10^4


public class Q805 {
    public static void main(String[] args) {
        System.out.println(splitArraySameAverage(InputMethods.getInputForOneIntArray()));
    }

    private static boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length, m = n / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        boolean isPossible = false;
        for (int i = 1; i <= m; i++) {
            if (sum * i % n == 0) {
                isPossible = true;
                break;
            }
        }
        if (!isPossible) {
            return false;
        }
        Set<Integer>[] dp = new Set[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(0);
        for (int num : nums) {
            for (int i = m; i >= 1; i--) {
                for (int x : dp[i - 1]) {
                    int curr = x + num;
                    if (curr * n == sum * i) {
                        return true;
                    }
                    dp[i].add(curr);
                }
            }
        }
        return false;
    }
}
