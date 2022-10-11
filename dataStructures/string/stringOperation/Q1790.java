package dataStructures.string.stringOperation;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
//
//    Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
//
//    Example 1:
//    Input: s1 = "bank", s2 = "kanb"
//    Output: true
//    Explanation: For example, swap the first character with the last character of s2 to make "bank".
//
//    Example 2:
//    Input: s1 = "attack", s2 = "defend"
//    Output: false
//    Explanation: It is impossible to make them equal with one string swap.
//
//    Example 3:
//    Input: s1 = "kelb", s2 = "kelb"
//    Output: true
//    Explanation: The two strings are already equal, so no string swap operation is required.
//
//    Constraints:
//    1 <= s1.length, s2.length <= 100
//    s1.length == s2.length
//    s1 and s2 consist of only lowercase English letters.



//给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
//
//    如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
//
//    示例 1：
//    输入：s1 = "bank", s2 = "kanb"
//    输出：true
//    解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
//
//    示例 2：
//    输入：s1 = "attack", s2 = "defend"
//    输出：false
//    解释：一次字符串交换无法使两个字符串相等
//
//    示例 3：
//    输入：s1 = "kelb", s2 = "kelb"
//    输出：true
//    解释：两个字符串已经相等，所以不需要进行字符串交换
//
//    示例 4：
//    输入：s1 = "abcd", s2 = "dcba"
//    输出：false
//
//    提示：
//    1 <= s1.length, s2.length <= 100
//    s1.length == s2.length
//    s1 和 s2 仅由小写英文字母组成



public class Q1790 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s1 = cin.nextLine();
        String s2 = cin.nextLine();
        cin.close();
        System.out.println(areAlmostEqual(s1, s2));
    }

    private static boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (indexes.size() >= 2) {
                    return false;
                }
                indexes.add(i);
            }
        }
        if (indexes.size() == 0) {
            return true;
        }
        if (indexes.size() != 2) {
            return false;
        }
        return s1.charAt(indexes.get(0)) == s2.charAt(indexes.get(1)) && s1.charAt(indexes.get(1)) == s2.charAt(indexes.get(0));
    }
}
