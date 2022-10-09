package algorithms.divideAndConquer;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Given a balanced parentheses string s, return the score of the string.
//
//    The score of a balanced parentheses string is based on the following rule:
//
//    "()" has score 1.
//    AB has score A + B, where A and B are balanced parentheses strings.
//    (A) has score 2 * A, where A is a balanced parentheses string.
//
//    Example 1:
//    Input: s = "()"
//    Output: 1
//
//    Example 2:
//    Input: s = "(())"
//    Output: 2
//
//    Example 3:
//    Input: s = "()()"
//    Output: 2
//
//    Constraints:
//    2 <= s.length <= 50
//    s consists of only '(' and ')'.
//    s is a balanced parentheses string.



//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
//
//    () 得 1 分。
//    AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
//    (A) 得 2 * A 分，其中 A 是平衡括号字符串。
//
//    示例 1：
//    输入： "()"
//    输出： 1
//
//    示例 2：
//    输入： "(())"
//    输出： 2
//
//    示例 3：
//    输入： "()()"
//    输出： 2
//
//    示例 4：
//    输入： "(()(()))"
//    输出： 6
//
//    提示：
//    S 是平衡括号字符串，且只含有 ( 和 ) 。
//    2 <= S.length <= 50



public class Q856 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(scoreOfParentheses(s));
    }

    // Method 1: use Stack
//    private static int scoreOfParentheses(String s) {
//        Deque<Integer> stack = new LinkedList<>();
//        stack.push(0);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(0);
//            } else {
//                Integer v = stack.pop();
//                Integer top = stack.pop() + Math.max(2 * v, 1);
//                stack.push(top);
//            }
//        }
//        if (!stack.isEmpty()) {
//            return stack.peek();
//        }
//        return -1;
//    }

    // Method 2: divide and conquer
    private static int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        }
        int bal = 0, n = s.length(), len = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (bal == 0) {
                len = i + 1;
                break;
            }
        }
        if (len == n) {
            return 2 * scoreOfParentheses(s.substring(1, n - 1));
        } else {
            return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len));
        }
    }
}
