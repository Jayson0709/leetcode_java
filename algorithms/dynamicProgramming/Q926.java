package algorithms.dynamicProgramming;
import java.util.*;
import java.nio.charset.StandardCharsets;

//A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).
//
//    You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
//
//    Return the minimum number of flips to make s monotone increasing.
//
//    Example 1:
//
//    Input: s = "00110"
//    Output: 1
//    Explanation: We flip the last digit to get 00111.
//    Example 2:
//
//    Input: s = "010110"
//    Output: 2
//    Explanation: We flip to get 011111, or alternatively 000111.
//    Example 3:
//
//    Input: s = "00011000"
//    Output: 2
//    Explanation: We flip to get 00000000.
//
//    Constraints:
//
//    1 <= s.length <= 105
//    s[i] is either '0' or '1'.


//如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
//
//    给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
//
//    返回使 s 单调递增的最小翻转次数。
//
//    示例 1：
//
//    输入：s = "00110"
//    输出：1
//    解释：翻转最后一位得到 00111.
//    示例 2：
//
//    输入：s = "010110"
//    输出：2
//    解释：翻转得到 011111，或者是 000111。
//    示例 3：
//
//    输入：s = "00011000"
//    输出：2
//    解释：翻转得到 00000000。
//
//    提示：
//
//    1 <= s.length <= 105
//    s[i] 为 '0' 或 '1'


public class Q926 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();

        int result = minFlipsMonoIncr(s);
        System.out.println(result);
    }

    private static int minFlipsMonoIncr(String s) {
        int length = s.length();
        int[][] dp = new int[length][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;
        for (int i = 1; i < length; i++) {
            dp[i][0] = dp[i - 1][0] + (s.charAt(i) == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i) == '1' ? 0 : 1);
        }
        return Math.min(dp[length - 1][0], dp[length - 1][1]);
    }
}
