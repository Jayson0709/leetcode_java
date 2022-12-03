package dataStructures.string.stringOperation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
//
//    An alphanumeric string is a string consisting of lowercase English letters and digits.
//
//    Example 1:
//    Input: s = "dfa12321afd"
//    Output: 2
//    Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
//
//    Example 2:
//    Input: s = "abc1111"
//    Output: -1
//    Explanation: The digits that appear in s are [1]. There is no second largest digit.
//
//    Constraints:
//    1 <= s.length <= 500
//    s consists of only lowercase English letters and/or digits.


//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
//
//    混合字符串 由小写英文字母和数字组成。
//
//    示例 1：
//    输入：s = "dfa12321afd"
//    输出：2
//    解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
//
//    示例 2：
//    输入：s = "abc1111"
//    输出：-1
//    解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
//
//    提示：
//    1 <= s.length <= 500
//    s 只包含小写英文字母和（或）数字。



public class Q1796 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(secondHighest(s));
    }

    private static int secondHighest(String s) {
        int maxNum = -1;
        int secMaxNum = -1;
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int curNum = c - '0';
                if (curNum > maxNum) {
                    secMaxNum = maxNum;
                    maxNum = curNum;
                } else if (curNum < maxNum && curNum > secMaxNum) {
                    secMaxNum = curNum;
                }
            }
        }
        return secMaxNum;
    }
}
