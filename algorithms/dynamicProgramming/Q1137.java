package algorithms.dynamicProgramming;
import java.util.*;
import java.nio.charset.StandardCharsets;


//The Tribonacci sequence Tn is defined as follows:
//
//    T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
//    Given n, return the value of Tn.
//
//    Example 1:
//    Input: n = 4
//    Output: 4
//    Explanation:
//    T_3 = 0 + 1 + 1 = 2
//    T_4 = 1 + 1 + 2 = 4
//    
//    Example 2:
//    Input: n = 25
//    Output: 1389537
//
//    Constraints:
//    0 <= n <= 37
//    The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.


//泰波那契序列Tn定义如下：
//
//    T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
//    给你整数n，请返回第 n 个泰波那契数Tn 的值。
//
//    示例 1：
//    输入：n = 4
//    输出：4
//    解释：
//    T_3 = 0 + 1 + 1 = 2
//    T_4 = 1 + 1 + 2 = 4
//
//    示例 2：
//    输入：n = 25
//    输出：1389537
//
//    提示：
//    0 <= n <= 37
//    答案保证是一个 32 位整数，即answer <= 2^31 - 1。


public class Q1137 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();

        int result = tribonacci(n);
        System.out.println(result);
    }

    private static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1] + dp[i - 3];
        }
        return dp[n];
    }
}
