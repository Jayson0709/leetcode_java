package string;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a 0-indexed string expression of the form "<num1>+<num2>" where <num1> and <num2> represent positive integers.
//
//    Add a pair of parentheses to expression such that after the addition of parentheses, expression is a valid mathematical expression and evaluates to the smallest possible value. The left parenthesis must be added to the left of '+' and the right parenthesis must be added to the right of '+'.
//
//    Return expression after adding a pair of parentheses such that expression evaluates to the smallest possible value. If there are multiple answers that yield the same result, return any of them.
//
//    The input has been generated such that the original value of expression, and the value of expression after adding any pair of parentheses that meets the requirements fits within a signed 32-bit integer.
//
//    Example 1:
//    Input: expression = "247+38"
//    Output: "2(47+38)"
//    Explanation: The expression evaluates to 2 * (47 + 38) = 2 * 85 = 170.
//    Note that "2(4)7+38" is invalid because the right parenthesis must be to the right of the '+'.
//    It can be shown that 170 is the smallest possible value.
//
//    Example 2:
//    Input: expression = "12+34"
//    Output: "1(2+3)4"
//    Explanation: The expression evaluates to 1 * (2 + 3) * 4 = 1 * 5 * 4 = 20.
//
//    Example 3:
//    Input: expression = "999+999"
//    Output: "(999+999)"
//    Explanation: The expression evaluates to 999 + 999 = 1998.
//
//    Constraints:
//    3 <= expression.length <= 10
//    expression consists of digits from '1' to '9' and '+'.
//    expression starts and ends with digits.
//    expression contains exactly one '+'.
//    The original value of expression, and the value of expression after adding any pair of parentheses that meets the requirements fits within a signed 32-bit integer.


//给你一个下标从 0 开始的字符串 expression ，格式为 "<num1>+<num2>" ，其中 <num1> 和 <num2> 表示正整数。
//
//    请你向 expression 中添加一对括号，使得在添加之后， expression 仍然是一个有效的数学表达式，并且计算后可以得到 最小 可能值。左括号 必须 添加在 '+' 的左侧，而右括号必须添加在 '+' 的右侧。
//
//    返回添加一对括号后形成的表达式expression ，且满足 expression 计算得到 最小 可能值。如果存在多个答案都能产生相同结果，返回任意一个答案。
//
//    生成的输入满足：expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围。
//
//    示例 1：
//    输入：expression = "247+38"
//    输出："2(47+38)"
//    解释：表达式计算得到 2 * (47 + 38) = 2 * 85 = 170 。
//    注意 "2(4)7+38" 不是有效的结果，因为右括号必须添加在 '+' 的右侧。
//    可以证明 170 是最小可能值。
//
//    示例 2：
//    输入：expression = "12+34"
//    输出："1(2+3)4"
//    解释：表达式计算得到 1 * (2 + 3) * 4 = 1 * 5 * 4 = 20 。
//
//    示例 3：
//    输入：expression = "999+999"
//    输出："(999+999)"
//    解释：表达式计算得到 999 + 999 = 1998 。
//
//    提示：
//    3 <= expression.length <= 10
//    expression 仅由数字 '1' 到 '9' 和 '+' 组成
//    expression 由数字开始和结束
//    expression 恰好仅含有一个 '+'.
//    expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围


public class Q2332 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String expression = cin.nextLine().strip();
        cin.close();

        String result = minimizeResult(expression);
        System.out.println(result);
    }

    private static String minimizeResult(String expression) {
        int plusIndex = expression.indexOf('+');
        int min = Integer.MAX_VALUE;
        StringBuilder resultBuilder = new StringBuilder();
        int n = expression.length();
        for (int i = 0; i < plusIndex; i++) {
            for (int j = plusIndex + 1; j < n; j++) {
                String str1 = expression.substring(0, i);
                String str2 = expression.substring(i, j + 1);
                String str3 = expression.substring(j + 1);
                int curVal = calculateVal(str1, str2, str3);
                if (min > curVal) {
                    min = curVal;
                    resultBuilder.setLength(0);
                    resultBuilder.append(str1).append("(").append(str2).append(")").append(str3);
                }
            }
        }
        return resultBuilder.toString();
    }

    private static int calculateVal(String str1, String str2, String str3) {
        int[] midTwo = Arrays.stream(str2.split("\\+")).mapToInt(Integer::parseInt).toArray();
        int result = midTwo[0] + midTwo[1];
        if (!str1.isEmpty()) {
            result *= Integer.parseInt(str1);
        }
        if (!str3.isEmpty()) {
            result *= Integer.parseInt(str3);
        }
        return result;
    }
}
