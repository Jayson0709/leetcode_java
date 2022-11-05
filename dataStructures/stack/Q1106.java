package dataStructures.stack;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


//A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:
//
//    't' that evaluates to true.
//    'f' that evaluates to false.
//    '!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
//    '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
//    '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
//    Given a string expression that represents a boolean expression, return the evaluation of that expression.
//
//    It is guaranteed that the given expression is valid and follows the given rules.
//
//    Example 1:
//    Input: expression = "&(|(f))"
//    Output: false
//    Explanation:
//    First, evaluate |(f) --> f. The expression is now "&(f)".
//    Then, evaluate &(f) --> f. The expression is now "f".
//    Finally, return false.
//
//    Example 2:
//    Input: expression = "|(f,f,f,t)"
//    Output: true
//    Explanation: The evaluation of (false OR false OR false OR true) is true.
//
//    Example 3:
//    Input: expression = "!(&(f,t))"
//    Output: true
//    Explanation:
//    First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
//    Then, evaluate !(f) --> NOT false --> true. We return true.
//
//    Constraints:
//    1 <= expression.length <= 2 * 10^4
//    expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f', and ','.



//给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
//
//    有效的表达式需遵循以下约定：
//
//    "t"，运算结果为 True
//    "f"，运算结果为 False
//    "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
//    "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
//    "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
//
//    示例 1：
//    输入：expression = "!(f)"
//    输出：true
//
//    示例 2：
//    输入：expression = "|(f,t)"
//    输出：true
//
//    示例 3：
//    输入：expression = "&(t,f)"
//    输出：false
//
//    示例 4：
//    输入：expression = "|(&(t,f,t),!(t))"
//    输出：false
//
//    提示：
//    1 <= expression.length <= 20000
//    expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
//    expression 是以上述形式给出的有效表达式，表示一个布尔值。


public class Q1106 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String expression = cin.nextLine().strip();
        cin.close();
        System.out.println(parseBoolExpr(expression));
    }

    private static boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ',') {
                continue;
            } else if (c != ')') {
                stack.push(c);
            } else {
                int t = 0, f = 0;
                while (stack.peek() != null && stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        t++;
                    } else {
                        f++;
                    }
                }
                stack.pop();
                char op = stack.pop();
                switch (op) {
                    case '!' -> stack.push(f == 1 ? 't' : 'f');
                    case '&' -> stack.push(f == 0 ? 't' : 'f');
                    case '|' -> stack.push(t > 0 ? 't' : 'f');
                    default -> {
                    }
                }
            }
        }
        return stack.pop() == 't';
    }
}
