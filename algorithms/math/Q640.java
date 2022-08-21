package algorithms.math;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Solve a given equation and return the value of 'x' in the form of a dataStructures.string "x=#value". The equation contains only '+', '-' operation, the variable 'x' and its coefficient. You should return "No solution" if there is no solution for the equation, or "Infinite solutions" if there are infinite solutions for the equation.
//
//    If there is exactly one solution for the equation, we ensure that the value of 'x' is an integer.
//
//    Example 1:
//    Input: equation = "x+5-3+x=6+x-2"
//    Output: "x=2"
//    
//    Example 2:
//    Input: equation = "x=x"
//    Output: "Infinite solutions"
//    
//    Example 3:
//    Input: equation = "2x=x"
//    Output: "x=0"
//    
//    Constraints:
//    3 <= equation.length <= 1000
//    equation has exactly one '='.
//    equation consists of integers with an absolute value in the range [0, 100] without any leading zeros, and the variable 'x'.



//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
//
//    如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
//
//    如果方程中只有一个解，要保证返回值 'x' 是一个整数。
//
//    示例 1：
//    输入: equation = "x+5-3+x=6+x-2"
//    输出: "x=2"
//
//    示例 2:
//    输入: equation = "x=x"
//    输出: "Infinite solutions"
//
//    示例 3:
//    输入: equation = "2x=x"
//    输出: "x=0"
//
//
//    提示:
//    3 <= equation.length <= 1000
//    equation 只有一个 '='.




public class Q640 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String equation = cin.nextLine().strip();
        cin.close();
        System.out.println(solveEquation(equation));
    }

    private static String solveEquation(String equation) {
        int factor = 0, val = 0;
        int index = 0, n = equation.length(), sign1 = 1; // coefficient for the left side.
        while (index < n) {
            if (equation.charAt(index) == '=') {
                sign1 = -1; // coefficient for the right side.
                index++;
                continue;
            }

            int sign2 = sign1, number = 0;
            boolean valid = false; // whether number is valid.
            if (equation.charAt(index) == '-' || equation.charAt(index) == '+') { // remove the previous operator
                sign2 = (equation.charAt(index) == '-') ? -sign1 : sign1;
                index++;
            }
            while (index < n && Character.isDigit(equation.charAt(index))) {
                number = number * 10 + (equation.charAt(index) - '0');
                index++;
                valid = true;
            }

            if (index < n && equation.charAt(index) == 'x') { // variable
                factor += valid ? sign2 * number : sign2;
                index++;
            } else { // value
                val += sign2 * number;
            }
        }

        if (factor == 0) {
            return val == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (-val / factor);
    }
}
