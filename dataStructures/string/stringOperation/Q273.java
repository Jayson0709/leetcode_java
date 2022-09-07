package dataStructures.string.stringOperation;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an integer, output the English description of this integer.
//
//    Example 1:
//    Input: 123
//    Output: "One Hundred Twenty Three"
//
//    Example 2:
//    Input: 12345
//    Output: "Twelve Thousand Three Hundred Forty Five"
//
//    Example 3:
//    Input: 1234567
//    Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
//
//    Example 4:
//    Input: 1234567891
//    Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
//
//
//给定一个整数，打印该整数的英文描述。
//
//    示例 1:
//    输入: 123
//    输出: "One Hundred Twenty Three"
//
//    示例 2:
//    输入: 12345
//    输出: "Twelve Thousand Three Hundred Forty Five"
//
//    示例 3:
//    输入: 1234567
//    输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
//
//    示例 4:
//    输入: 1234567891
//    输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"


public class Q273 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int num = cin.nextInt();
        cin.close();
        System.out.println(numberToWords(num));
    }

    static String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] thousands = {"", "Thousand", "Million", "Billion"};

    private static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                StringBuilder curr = new StringBuilder();
                recursion(curr, curNum);
                curr.append(thousands[i]).append(" ");
                sb.append(curr);
            }
        }
        return sb.toString().trim();
    }

    private static void recursion(StringBuilder curr, int num) {
        if (num == 0) {
            return;
        } else if (num < 10) {
            curr.append(singles[num]).append(" ");
        } else if (num < 20) {
            curr.append(teens[num - 10]).append(" ");
        } else if (num < 100) {
            curr.append(tens[num / 10]).append(" ");
            recursion(curr, num % 10);
        } else {
            curr.append(singles[num / 100]).append(" Hundred ");
            recursion(curr, num % 100);
        }
    }
}
