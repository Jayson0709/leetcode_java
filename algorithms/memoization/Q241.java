package algorithms.memoization;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;

//Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
//
//    The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.
//
//    Example 1:
//    Input: expression = "2-1-1"
//    Output: [0,2]
//    Explanation:
//    ((2-1)-1) = 0
//    (2-(1-1)) = 2
//    
//    Example 2:
//    Input: expression = "2*3-4*5"
//    Output: [-34,-14,-10,-10,10]
//    Explanation:
//    (2*(3-(4*5))) = -34
//    ((2*3)-(4*5)) = -14
//    ((2*(3-4))*5) = -10
//    (2*((3-4)*5)) = -10
//    (((2*3)-4)*5) = 10
//    
//    Constraints:
//    1 <= expression.length <= 20
//    expression consists of digits and the operator '+', '-', and '*'.
//    All the integer values in the input expression are in the range [0, 99].



//给你一个由数字和运算符组成的字符串expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
//
//    生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
//
//    示例 1：
//    输入：expression = "2-1-1"
//    输出：[0,2]
//    解释：
//    ((2-1)-1) = 0
//    (2-(1-1)) = 2
//
//    示例 2：
//    输入：expression = "2*3-4*5"
//    输出：[-34,-14,-10,-10,10]
//    解释：
//    (2*(3-(4*5))) = -34
//    ((2*3)-(4*5)) = -14
//    ((2*(3-4))*5) = -10
//    (2*((3-4)*5)) = -10
//    (((2*3)-4)*5) = 10
//
//    提示：
//    1 <= expression.length <= 20
//    expression 由数字和算符 '+'、'-' 和 '*' 组成。
//    输入表达式中的所有整数值在范围 [0, 99]


public class Q241 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String expression = cin.nextLine().strip();
        cin.close();

        List<Integer> result = diffWaysToCompute(expression);
        OutputMethods.formatListOutputData(result);
    }

    // Method 1: Memoization
//    static final int ADDITION = -1;
//    static final int SUBTRACTION = -2;
//    static final int MULTIPLICATION = -3;
//
//    public static List<Integer> diffWaysToCompute(String expression) {
//        List<Integer> ops = new ArrayList<Integer>();
//        for (int i = 0; i < expression.length();) {
//            if (!Character.isDigit(expression.charAt(i))) {
//                if (expression.charAt(i) == '+') {
//                    ops.add(ADDITION);
//                } else if (expression.charAt(i) == '-') {
//                    ops.add(SUBTRACTION);
//                } else {
//                    ops.add(MULTIPLICATION);
//                }
//                i++;
//            } else {
//                int t = 0;
//                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
//                    t = t * 10 + expression.charAt(i) - '0';
//                    i++;
//                }
//                ops.add(t);
//            }
//        }
//        List<Integer>[][] dp = new List[ops.size()][ops.size()];
//        for (int i = 0; i < ops.size(); i++) {
//            for (int j = 0; j < ops.size(); j++) {
//                dp[i][j] = new ArrayList<Integer>();
//            }
//        }
//        return dfs(dp, 0, ops.size() - 1, ops);
//    }
//
//    public static List<Integer> dfs(List<Integer>[][] dp, int l, int r, List<Integer> ops) {
//        if (dp[l][r].isEmpty()) {
//            if (l == r) {
//                dp[l][r].add(ops.get(l));
//            } else {
//                for (int i = l; i < r; i += 2) {
//                    List<Integer> left = dfs(dp, l, i, ops);
//                    List<Integer> right = dfs(dp, i + 2, r, ops);
//                    for (int lv : left) {
//                        for (int rv : right) {
//                            if (ops.get(i + 1) == ADDITION) {
//                                dp[l][r].add(lv + rv);
//                            } else if (ops.get(i + 1) == SUBTRACTION) {
//                                dp[l][r].add(lv - rv);
//                            } else {
//                                dp[l][r].add(lv * rv);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return dp[l][r];
//    }

    // Method 2: Divide-and-conquer + recursion
    private static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        if (expression == null) {
            return result;
        }
        if (isDigit(expression)) {
            result.add(Integer.parseInt(expression));
            return result;
        }
        for (int i = 0; i < expression.length(); i++) {
            char curChar = expression.charAt(i);
            if (curChar == '+' || curChar == '-' || curChar == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for (int num1 : left) {
                    for (int num2: right) {
                        if (curChar == '+') {
                            result.add(num1 + num2);
                        } else if (curChar == '-') {
                            result.add(num1 - num2);
                        } else {
                            result.add(num1 * num2);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isDigit(String expression) {
        for (char curChar : expression.toCharArray()) {
            if (curChar < '0' || curChar > '9') {
                return false;
            }
        }
        return true;
    }
}
