package math;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an integer num, return a string of its base 7 representation.
//
//    Example 1:
//    Input: num = 100
//    Output: "202"
//
//    Example 2:
//    Input: num = -7
//    Output: "-10"
//
//    Constraints:
//    -10^7 <= num <= 10^7



//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
//
//    示例 1:
//    输入: num = 100
//    输出: "202"
//
//    示例 2:
//    输入: num = -7
//    输出: "-10"
//
//    提示：
//    -10^7 <= num <= 10^7



public class Q504 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int num = cin.nextInt();
        cin.close();
        System.out.println(convertToBase7(num));
    }

    private static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuilder digits = new StringBuilder();
        while (num > 0) {
            digits.append(num % 7);
            num /= 7;
        }
        if (negative) {
            digits.append('-');
        }
        return digits.reverse().toString();
    }
}
