package algorithms.dynamicProgramming;

import utils.InputMethods;

import java.util.ArrayDeque;
import java.util.Deque;



//Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
//
//    Example 1:
//    Input: arr = [3,1,2,4]
//    Output: 17
//    Explanation:
//    Sub arrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
//    Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
//    Sum is 17.
//    
//    Example 2:
//    Input: arr = [11,81,94,43,3]
//    Output: 444
//
//    Constraints:
//    1 <= arr.length <= 3 * 10^4
//    1 <= arr[i] <= 3 * 10^4



//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
//
//    由于答案可能很大，因此 返回答案模 10^9 + 7 。
//
//    示例 1：
//    输入：arr = [3,1,2,4]
//    输出：17
//    解释：
//    子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
//    最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
//
//    示例 2：
//    输入：arr = [11,81,94,43,3]
//    输出：444
//
//    提示：
//    1 <= arr.length <= 3 * 10^4
//    1 <= arr[i] <= 3 * 10^4


public class Q907 {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(InputMethods.getInputForOneIntArray()));
    }

    private static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long ans = 0;
        final int MOD = 1000000007;
        Deque<Integer> monoStack = new ArrayDeque<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && arr[monoStack.peek()] > arr[i]) {
                monoStack.pop();
            }
            int k = monoStack.isEmpty() ? (i + 1) : (i - monoStack.peek());
            dp[i] = k * arr[i] + (monoStack.isEmpty() ? 0 : dp[i - k]);
            ans = (ans + dp[i]) % MOD;
            monoStack.push(i);
        }
        return (int) ans;
    }
}