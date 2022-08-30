package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
//
//    For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//    Example 1:
//    Input: columnNumber = 1
//    Output: "A"
//
//    Example 2:
//    Input: columnNumber = 28
//    Output: "AB"
//
//    Example 3:
//    Input: columnNumber = 701
//    Output: "ZY"
//
//    Constraints:
//    1 <= columnNumber <= 2^31 - 1



//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
//
//    例如：
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//    示例 1：
//    输入：columnNumber = 1
//    输出："A"
//
//    示例 2：
//    输入：columnNumber = 28
//    输出："AB"
//
//    示例 3：
//    输入：columnNumber = 701
//    输出："ZY"
//
//    示例 4：
//    输入：columnNumber = 2147483647
//    输出："FXSHRXW"
//
//    提示：
//    1 <= columnNumber <= 2^31 - 1



public class Q168 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int columnNumber = cin.nextInt();
        cin.close();
        System.out.println(convertToTitle(columnNumber));
    }

    // Version 1
//    private static String convertToTitle(int columnNumber) {
//        StringBuilder sb = new StringBuilder();
//        while (columnNumber > 0) {
//            int a0 = (columnNumber - 1) % 26 + 1;
//            sb.append((char)(a0 - 1 + 'A'));
//            columnNumber = (columnNumber - a0) / 26;
//        }
//        return sb.reverse().toString();
//    }

    // Version 2
    private static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
