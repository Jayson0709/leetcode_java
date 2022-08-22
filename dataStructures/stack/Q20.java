package dataStructures.stack;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//    An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//
//    Example 1:
//    Input: s = "()"
//    Output: true
//    
//    Example 2:
//    Input: s = "()[]{}"
//    Output: true
//    
//    Example 3:
//    Input: s = "(]"
//    Output: false
//
//    Constraints:
//    1 <= s.length <= 104
//    s consists of parentheses only '()[]{}'.


//给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
//
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//
//    示例 1：
//    输入：s = "()"
//    输出：true
//
//    示例2：
//    输入：s = "()[]{}"
//    输出：true
//
//    示例3：
//    输入：s = "(]"
//    输出：false
//
//    示例4：
//    输入：s = "([)]"
//    输出：false
//
//    示例5：
//    输入：s = "{[]}"
//    输出：true
//
//    提示：
//    1 <= s.length <= 104
//    s 仅由括号 '()[]{}' 组成


public class Q20 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        boolean result = isValid(s);
        System.out.println(result);
    }

    private static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }

        Stack<Character> stk = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stk.push(')');
            } else if (c == '[') {
                stk.push(']');
            } else if (c == '{') {
                stk.push('}');
            } else if (stk.isEmpty() || c != stk.pop()) {
                return false;
            }
        }
        return stk.isEmpty();
    }
}
