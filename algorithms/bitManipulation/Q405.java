package algorithms.bitManipulation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.
//
//    All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.
//
//    Note: You are not allowed to use any built-in library method to directly solve this problem.
//
//    Example 1:
//    Input: num = 26
//    Output: "1a"
//
//    Example 2:
//    Input: num = -1
//    Output: "ffffffff"
//
//    Constraints:
//    -2^31 <= num <= 2^31 - 1


//给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
//
//    注意:
//    十六进制中所有字母(a-f)都必须是小写。
//    十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
//    给定的数确保在32位有符号整数范围内。
//    不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
//
//    示例 1：
//    输入:
//    26
//    输出:
//    "1a"
//
//    示例 2：
//    输入:
//    -1
//    输出:
//    "ffffffff"


public class Q405 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int num = cin.nextInt();
        cin.close();
        System.out.println(toHex(num));
    }

    private static final char[] CHARS =
        { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    private static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        while (res.length() < 8) {
            res.append(CHARS[num & 0xf]);
            num >>= 4;
            if(num == 0)
                break;
        }
        return res.reverse().toString();
    }
}
