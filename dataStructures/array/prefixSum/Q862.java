package dataStructures.array.prefixSum;

import utils.InputMethods;
import utils.OneDIntArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;



//Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.
//
//    A subarray is a contiguous part of an array.
//
//    Example 1:
//    Input: nums = [1], k = 1
//    Output: 1
//
//    Example 2:
//    Input: nums = [1,2], k = 4
//    Output: -1
//
//    Example 3:
//    Input: nums = [2,-1,2], k = 3
//    Output: 3
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    -10^5 <= nums[i] <= 10^5
//    1 <= k <= 10^9



//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
//
//    子数组 是数组中 连续 的一部分。
//
//    示例 1：
//    输入：nums = [1], k = 1
//    输出：1
//
//    示例 2：
//    输入：nums = [1,2], k = 4
//    输出：-1
//
//    示例 3：
//    输入：nums = [2,-1,2], k = 3
//    输出：3
//
//    提示：
//    1 <= nums.length <= 10^5
//    -10^5 <= nums[i] <= 10^5
//    1 <= k <= 10^9




public class Q862 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDIntArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(shortestSubarray(obj.array, obj.val));
    }

    private static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }
        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSumArr[i];
            while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }
}
