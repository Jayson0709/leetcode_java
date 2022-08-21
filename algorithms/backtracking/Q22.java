package algorithms.backtracking;
import java.util.*;
import java.nio.charset.StandardCharsets;
import utils.*;


//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//    Example 1:
//    Input: n = 3
//    Output: ["((()))","(()())","(())()","()(())","()()()"]
//
//    Example 2:
//    Input: n = 1
//    Output: ["()"]
//    
//    Constraints:
//    1 <= n <= 8


//数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//    示例 1：
//    输入：n = 3
//    输出：["((()))","(()())","(())()","()(())","()()()"]
//
//    示例 2：
//    输入：n = 1
//    输出：["()"]
//
//    提示：
//    1 <= n <= 8


public class Q22 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        List<String> result = generateParenthesis(n);
        OutputMethods.outputListData(result);
    }

    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            result.add("()");
            return result;
        }
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public static void backtrack(List<String> result, StringBuilder curBuilder, int open, int close, int max) {
        if (curBuilder.length() == max * 2) {
            result.add(curBuilder.toString());
            return;
        }
        if (open < max) {
            curBuilder.append("(");
            backtrack(result, curBuilder, open + 1, close, max);
            curBuilder.deleteCharAt(curBuilder.length() - 1);
        }
        if (close < open) {
            curBuilder.append(")");
            backtrack(result, curBuilder, open, close + 1, max);
            curBuilder.deleteCharAt(curBuilder.length() - 1);
        }
    }
}
