package math;
//Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.
//
//    The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.
//
//     
//
//    Example 1:
//
//    Input: expression = "-1/2+1/2"
//    Output: "0/1"
//    Example 2:
//
//    Input: expression = "-1/2+1/2+1/3"
//    Output: "1/3"
//    Example 3:
//
//    Input: expression = "1/3-1/2"
//    Output: "-1/6"
//     
//
//    Constraints:
//
//    The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
//    Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
//    The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
//    The number of given fractions will be in the range [1, 10].
//    The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.


// 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 

// 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。

//  

// 示例 1:

// 输入: expression = "-1/2+1/2"
// 输出: "0/1"
//  示例 2:

// 输入: expression = "-1/2+1/2+1/3"
// 输出: "1/3"
// 示例 3:

// 输入: expression = "1/3-1/2"
// 输出: "-1/6"
//  

// 提示:

// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
// 输入的分数个数范围是 [1,10]。
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。

import java.util.*;
import java.nio.charset.*;

public class Q592 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String expression = cin.nextLine().strip();
        cin.close();
        String result = fractionAddition(expression);
        System.out.println(result);
    }

    public static String fractionAddition(String expression) {
        List<Character> sign = new ArrayList <>();
        if (expression.charAt(0) != '-')
            sign.add('+');
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-')
                sign.add(expression.charAt(i));
        }
        int prevNum = 0;
        int prevDen = 1;
        int i = 0;
        for (String sub: expression.split("(\\+)|(-)")) {
            if (sub.length() > 0) {
                String[] fraction = sub.split("/");
                int num = (Integer.parseInt(fraction[0]));
                int den = (Integer.parseInt(fraction[1]));
                int gcd = Math.abs(getGcd(den, prevDen));
                if (sign.get(i++) == '+')
                    prevNum = prevNum * den / gcd + num * prevDen / gcd;
                else
                    prevNum = prevNum * den / gcd - num * prevDen / gcd;
                prevDen = den * prevDen / gcd;
                gcd = Math.abs(getGcd(prevDen, prevNum));
                prevNum /= gcd;
                prevDen /= gcd;
            }
        }
        return prevNum + "/" + prevDen;
    }

    private static int getGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
