package dataStructures.stack;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


//Given a string s which represents an expression, evaluate this expression and return its value.
//
//    The integer division should truncate toward zero.
//
//    You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
//
//    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
//
//    Example 1:
//    Input: s = "3+2*2"
//    Output: 7
//
//    Example 2:
//    Input: s = " 3/2 "
//    Output: 1
//
//    Example 3:
//    Input: s = " 3+5 / 2 "
//    Output: 5
//
//    Constraints:
//    1 <= s.length <= 3 * 10^5
//    s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
//    s represents a valid expression.
//    All the integers in the expression are non-negative integers in the range [0, 2^31 - 1].
//    The answer is guaranteed to fit in a 32-bit integer.


//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
//    整数除法仅保留整数部分。
//
//    你可以假设给定的表达式总是有效的。所有中间结果将在 [-2^31, 2^31 - 1] 的范围内。
//
//    注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
//
//    示例 1：
//    输入：s = "3+2*2"
//    输出：7
//
//    示例 2：
//    输入：s = " 3/2 "
//    输出：1
//
//    示例 3：
//    输入：s = " 3+5 / 2 "
//    输出：5
//
//    提示：
//    1 <= s.length <= 3 * 10^5
//    s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
//    s 表示一个 有效表达式
//    表达式中的所有整数都是非负整数，且在范围 [0, 2^31 - 1] 内
//    题目数据保证答案是一个 32-bit 整数



public class Q227 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(calculate(s));
    }

    private static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
