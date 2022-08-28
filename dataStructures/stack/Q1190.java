package dataStructures.stack;

import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


//You are given a string s that consists of lower case English letters and brackets.
//
//    Reverse the strings in each pair of matching parentheses, starting from the innermost one.
//
//    Your result should not contain any brackets.
//
//    Example 1:
//    Input: s = "(abcd)"
//    Output: "dcba"
//
//    Example 2:
//    Input: s = "(u(love)i)"
//    Output: "iloveu"
//    Explanation: The substring "love" is reversed first, then the whole string is reversed.
//
//    Example 3:
//    Input: s = "(ed(et(oc))el)"
//    Output: "leetcode"
//    Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
//
//    Constraints:
//    1 <= s.length <= 2000
//    s only contains lower case English characters and parentheses.
//    It is guaranteed that all parentheses are balanced.



//给出一个字符串 s（仅含有小写英文字母和括号）。
//
//    请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
//
//    注意，您的结果中 不应 包含任何括号。
//
//    示例 1：
//    输入：s = "(abcd)"
//    输出："dcba"
//
//    示例 2：
//    输入：s = "(u(love)i)"
//    输出："iloveu"
//    解释：先反转子字符串 "love" ，然后反转整个字符串。
//
//    示例 3：
//    输入：s = "(ed(et(oc))el)"
//    输出："leetcode"
//    解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。
//
//    示例 4：
//    输入：s = "a(bcdefghijkl(mno)p)q"
//    输出："apmnolkjihgfedcbq"
//
//    提示：
//    0 <= s.length <= 2000
//    s 中只有小写英文字母和括号
//    题目测试用例确保所有括号都是成对出现的




public class Q1190 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(reverseParentheses(s));
    }

    // Method 1: monotonous stack
//    private static String reverseParentheses(String s) {
//        Deque<String> stack = new LinkedList<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                stack.push(sb.toString());
//                sb.setLength(0);
//            } else if (c == ')') {
//                sb.reverse();
//                sb.insert(0, stack.pop());
//            } else {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }

    // Method 2: pre-processing of parenthesis
    private static String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }
}
