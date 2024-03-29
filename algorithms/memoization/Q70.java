package algorithms.memoization;
import java.util.*;
import java.nio.charset.StandardCharsets;

//You are climbing a staircase. It takes n steps to reach the top.
//
//    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//    Example 1:
//    Input: n = 2
//    Output: 2
//    Explanation: There are two ways to climb to the top.
//    1. 1 step + 1 step
//    2. 2 steps
//
//    Example 2:
//    Input: n = 3
//    Output: 3
//    Explanation: There are three ways to climb to the top.
//    1. 1 step + 1 step + 1 step
//    2. 1 step + 2 steps
//    3. 2 steps + 1 step
//
//    Constraints:
//    1 <= n <= 45


//假设你正在爬楼梯。需要 n阶你才能到达楼顶。
//
//    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//    示例 1：
//    输入：n = 2
//    输出：2
//    解释：有两种方法可以爬到楼顶。
//    1. 1 阶 + 1 阶
//    2. 2 阶
//
//    示例 2：
//    输入：n = 3
//    输出：3
//    解释：有三种方法可以爬到楼顶。
//    1. 1 阶 + 1 阶 + 1 阶
//    2. 1 阶 + 2 阶
//    3. 2 阶 + 1 阶
//
//    提示：
//    1 <= n <= 45


public class Q70 {
    public static void main(String[] args) {
         Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
         int n = cin.nextInt();
         cin.close();

         int result = climbStairs(n);
         System.out.println(result);
    }

    // Method 1: Dynamic programming
//    private static int climbStairs(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }

    // Method 2: Memoization
    private static int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int prev1;
        int prev2 = 0;
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            prev1 = prev2;
            prev2 = curr;
            curr = prev1 + prev2;
        }
        return curr;
    }
}
