package algorithms.bitManipulation;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given two binary strings a and b, return their sum as a binary string.
//
//    Example 1:
//    Input: a = "11", b = "1"
//    Output: "100"
//
//    Example 2:
//    Input: a = "1010", b = "1011"
//    Output: "10101"
//
//    Constraints:
//    1 <= a.length, b.length <= 10^4
//    a and b consist only of '0' or '1' characters.
//    Each string does not contain leading zeros except for the zero itself.


//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
//    输入为 非空 字符串且只包含数字1和0。
//
//    示例1:
//    输入: a = "11", b = "1"
//    输出: "100"
//
//    示例2:
//    输入: a = "1010", b = "1011"
//    输出: "10101"
//
//    提示：
//    每个字符串仅由字符 '0' 或 '1' 组成。
//    1 <= a.length, b.length <= 10^4
//    字符串如果不是 "0" ，就都不含前导零。


public class Q67 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String a = cin.nextLine();
        String b = cin.nextLine();
        cin.close();

        String result = addBinary(a, b);
        System.out.println(result);
    }

    private static String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        StringBuilder strBuilder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }
            strBuilder.append(carry % 2);
            carry >>= 1;
        }
        String result = strBuilder.reverse().toString();
        return carry > 0 ? '1' + result : result;
    }
}
