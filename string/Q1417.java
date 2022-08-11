package string;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given an alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
//
//    You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.
//
//    Return the reformatted string or return an empty string if it is impossible to reformat the string.
//
//    Example 1:
//    Input: s = "a0b1c2"
//    Output: "0a1b2c"
//    Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
//
//    Example 2:
//    Input: s = "leetcode"
//    Output: ""
//    Explanation: "leetcode" has only characters, so we cannot separate them by digits.
//
//    Example 3:
//    Input: s = "1229857369"
//    Output: ""
//    Explanation: "1229857369" has only digits, so we cannot separate them by characters.
//
//    Constraints:
//    1 <= s.length <= 500
//    s consists of only lowercase English letters and/or digits.



//给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
//
//    请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
//
//    请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
//
//    示例 1：
//    输入：s = "a0b1c2"
//    输出："0a1b2c"
//    解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
//
//    示例 2：
//    输入：s = "leetcode"
//    输出：""
//    解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
//
//    示例 3：
//    输入：s = "1229857369"
//    输出：""
//    解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
//
//    示例 4：
//    输入：s = "covid2019"
//    输出："c2o0v1i9d"
//
//    示例 5：
//    输入：s = "ab123"
//    输出："1a2b3"
//
//    提示：
//    1 <= s.length <= 500
//    s 仅由小写英文字母和/或数字组成。



public class Q1417 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(reformat(s));
    }

    private static String reformat(String s) {
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                digits.append(c);
            } else if (c >= 'a' && c <= 'z') {
                letters.append(c);
            }
        }
        if (Math.abs(digits.length() - letters.length()) > 1) {
            return "";
        }
        String ans;
        if (digits.length() >= letters.length()) {
            ans = combineStrings(letters, digits);
        } else {
            ans = combineStrings(digits, letters);
        }
        return ans;
    }

    private static String combineStrings(StringBuilder sb1, StringBuilder sb2) {
        StringBuilder res = new StringBuilder();
        int n1 = sb1.length(), n2 = sb2.length();
        for (int i = 0; i < n1; i++) {
            res.append(sb2.charAt(i));
            res.append(sb1.charAt(i));
        }
        if (n2 != n1) {
            res.append(sb2.charAt(sb2.length() - 1));
        }
        return res.toString();
    }
}
