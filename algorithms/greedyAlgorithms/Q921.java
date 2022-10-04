package algorithms.greedyAlgorithms;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//A parentheses string is valid if and only if:
//
//    It is the empty string,
//    It can be written as AB (A concatenated with B), where A and B are valid strings, or
//    It can be written as (A), where A is a valid string.
//    You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
//
//    For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
//    Return the minimum number of moves required to make s valid.
//
//    Example 1:
//    Input: s = "())"
//    Output: 1
//
//    Example 2:
//    Input: s = "((("
//    Output: 3
//
//    Constraints:
//    1 <= s.length <= 1000
//    s[i] is either '(' or ')'.



//只有满足下面几点之一，括号字符串才是有效的：
//
//    它是一个空字符串，或者
//    它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
//    它可以被写作 (A)，其中 A 是有效字符串。
//    给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
//
//    例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
//    返回 为使结果字符串 s 有效而必须添加的最少括号数。
//
//    示例 1：
//    输入：s = "())"
//    输出：1
//
//    示例 2：
//    输入：s = "((("
//    输出：3
//
//    提示：
//    1 <= s.length <= 1000
//    s 只包含 '(' 和 ')' 字符。



public class Q921 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(minAddToMakeValid(s));
    }

    // Method 1: use Stack
//    private static int minAddToMakeValid(String s) {
//        Deque<Character> stack = new LinkedList<>();
//        for (char c : s.toCharArray()) {
//            if (stack.isEmpty()) {
//                stack.push(c);
//            } else {
//                if (stack.peek() == '(' && c == ')') {
//                    stack.pop();
//                } else {
//                    stack.push(c);
//                }
//            }
//        }
//        return stack.size();
//    }

    // Method 2: greedy algorithm
    private static int minAddToMakeValid(String s) {
        int res = 0;
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    res++;
                }
            }
        }
        return res + left;
    }
}
