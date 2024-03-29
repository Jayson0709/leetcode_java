package algorithms.dynamicProgramming;

import utils.InputMethods;


//You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.
//
//    In the ith operation (1-indexed), you will:
//
//    Choose two elements, x and y.
//    Receive a score of i * gcd(x, y).
//    Remove x and y from nums.
//    Return the maximum score you can receive after performing n operations.
//
//    The function gcd(x, y) is the greatest common divisor of x and y.
//
//    Example 1:
//    Input: nums = [1,2]
//    Output: 1
//    Explanation: The optimal choice of operations is:
//    (1 * gcd(1, 2)) = 1
//
//    Example 2:
//    Input: nums = [3,4,6,8]
//    Output: 11
//    Explanation: The optimal choice of operations is:
//    (1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
//
//    Example 3:
//    Input: nums = [1,2,3,4,5,6]
//    Output: 14
//    Explanation: The optimal choice of operations is:
//    (1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
//
//    Constraints:
//    1 <= n <= 7
//    nums.length == 2 * n
//    1 <= nums[i] <= 10^6


//给你 nums ，它是一个大小为 2 * n 的正整数数组。你必须对这个数组执行 n 次操作。
//
//    在第 i 次操作时（操作编号从 1 开始），你需要：
//
//    选择两个元素 x 和 y 。
//    获得分数 i * gcd(x, y) 。
//    将 x 和 y 从 nums 中删除。
//    请你返回 n 次操作后你能获得的分数和最大为多少。
//
//    函数 gcd(x, y) 是 x 和 y 的最大公约数。
//
//    示例 1：
//    输入：nums = [1,2]
//    输出：1
//    解释：最优操作是：
//    (1 * gcd(1, 2)) = 1
//
//    示例 2：
//    输入：nums = [3,4,6,8]
//    输出：11
//    解释：最优操作是：
//    (1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
//
//    示例 3：
//    输入：nums = [1,2,3,4,5,6]
//    输出：14
//    解释：最优操作是：
//    (1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
//
//    提示：
//    1 <= n <= 7
//    nums.length == 2 * n
//    1 <= nums[i] <= 10^6


public class Q1799 {
    public static void main(String[] args) {
        System.out.println(maxScore(InputMethods.getInputForOneIntArray()));
    }

    private static int maxScore(int[] nums) {
        int m = nums.length;
        int[] dp = new int[1 << m];
        int[][] gcdTmp = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                gcdTmp[i][j] = gcd(nums[i], nums[j]);
            }
        }
        int all = 1 << m;
        for (int s = 1; s < all; s++) {
            int t = Integer.bitCount(s);
            if ((t & 1) != 0) {
                continue;
            }
            for (int i = 0; i < m; i++) {
                if (((s >> i) & 1) != 0) {
                    for (int j = i + 1; j < m; j++) {
                        if (((s >> j) & 1) != 0) {
                            dp[s] = Math.max(dp[s], dp[s ^ (1 << i) ^ (1 << j)] + t / 2 * gcdTmp[i][j]);
                        }
                    }
                }
            }
        }
        return dp[all - 1];
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
