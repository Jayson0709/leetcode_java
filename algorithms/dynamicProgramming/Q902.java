package algorithms.dynamicProgramming;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//Given an array of digits which is sorted in non-decreasing order. You can write numbers using each digits[i] as many times as we want. For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.
//
//    Return the number of positive integers that can be generated that are less than or equal to a given integer n.
//    
//    Example 1:
//    Input: digits = ["1","3","5","7"], n = 100
//    Output: 20
//    Explanation:
//    The 20 numbers that can be written are:
//    1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
//    
//    Example 2:
//    Input: digits = ["1","4","9"], n = 1000000000
//    Output: 29523
//    Explanation:
//    We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
//    81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
//    2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbers.
//    In total, this is 29523 integers that can be written using the digits array.
//    
//    Example 3:
//    Input: digits = ["7"], n = 8
//    Output: 1
//
//    Constraints:
//    1 <= digits.length <= 9
//    digits[i].length == 1
//    digits[i] is a digit from '1' to '9'.
//    All the values in digits are unique.
//    'digits' is sorted in non-decreasing order.
//    1 <= n <= 10^9



//给定一个按 非递减顺序 排列的数字数组 digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果 digits = ['1','3','5']，我们可以写数字，如 '13', '551', 和 '1351315'。
//
//    返回 可以生成的小于或等于给定整数 n 的正整数的个数 。
//
//    示例 1：
//    输入：digits = ["1","3","5","7"], n = 100
//    输出：20
//    解释：
//    可写出的 20 个数字是：
//    1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
//
//    示例 2：
//    输入：digits = ["1","4","9"], n = 1000000000
//    输出：29523
//    解释：
//    我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
//    81 个四位数字，243 个五位数字，729 个六位数字，
//    2187 个七位数字，6561 个八位数字和 19683 个九位数字。
//    总共，可以使用D中的数字写出 29523 个整数。
//
//    示例 3:
//    输入：digits = ["7"], n = 8
//    输出：1
//
//    提示：
//    1 <= digits.length <= 9
//    digits[i].length == 1
//    digits[i] 是从 '1' 到 '9' 的数
//    digits 中的所有值都 不同 
//    digits 按 非递减顺序 排列
//    1 <= n <= 10^9




public class Q902 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] digits = cin.nextLine().strip().split(" ");
        int n = cin.nextInt();
        cin.close();
        System.out.println(atMostNGivenDigitSet(digits, n));
    }

    private static int atMostNGivenDigitSet(String[] digits, int n) {
        String s = Integer.toString(n);
        int m = digits.length, k = s.length();
        int[][] dp = new int[k + 1][2];
        dp[0][1] = 1;
        for (int i = 1; i <= k; i++) {
            for (String digit : digits) {
                if (digit.charAt(0) == s.charAt(i - 1)) {
                    dp[i][1] = dp[i - 1][1];
                } else if (digit.charAt(0) < s.charAt(i - 1)) {
                    dp[i][0] += dp[i - 1][1];
                } else {
                    break;
                }
            }
            if (i > 1) {
                dp[i][0] += m + dp[i - 1][0] * m;
            }
        }
        return dp[k][0] + dp[k][1];
    }
}
