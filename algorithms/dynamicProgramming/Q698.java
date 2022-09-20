package algorithms.dynamicProgramming;

import utils.InputMethods;
import utils.OneDArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;



//Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
//    
//    Example 1:
//    Input: nums = [4,3,2,3,5,2,1], k = 4
//    Output: true
//    Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
//    
//    Example 2:
//    Input: nums = [1,2,3,4], k = 3
//    Output: false
//    
//    Constraints:
//    1 <= k <= nums.length <= 16
//    1 <= nums[i] <= 104
//    The frequency of each element is in the range [1, 4].



//给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
//
//    示例 1：
//    输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//    输出： True
//    说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
//
//    示例 2:
//    输入: nums = [1,2,3,4], k = 3
//    输出: false
//
//    提示：
//    1 <= k <= len(nums) <= 16
//    0 < nums[i] < 10000
//    每个元素的频率在 [1,4] 范围内



public class Q698 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(canPartitionKSubsets(obj.array, obj.val));
    }

    private static boolean canPartitionKSubsets(int[] nums, int k) {
        int all = Arrays.stream(nums).sum();
        if (all % k != 0) {
            return false;
        }
        int per = all / k;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > per) {
            return false;
        }
        boolean[] dp = new boolean[1 << n];
        int[] curSum = new int[1 << n];
        dp[0] = true;
        for (int i = 0; i < 1 << n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (curSum[i] + nums[j] > per) {
                    break;
                }
                if (((i >> j) & 1) == 0) {
                    int next = i | (1 << j);
                    if (!dp[next]) {
                        curSum[next] = (curSum[i] + nums[j]) % per;
                        dp[next] = true;
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
