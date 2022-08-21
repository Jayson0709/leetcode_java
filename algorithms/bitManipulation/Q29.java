package algorithms.bitManipulation;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
//
//    The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
//
//    Return the quotient after dividing dividend by divisor.
//
//    Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
//
//    Example 1:
//    Input: dividend = 10, divisor = 3
//    Output: 3
//    Explanation: 10/3 = 3.33333.. which is truncated to 3.
//    
//    Example 2:
//    Input: dividend = 7, divisor = -3
//    Output: -2
//    Explanation: 7/-3 = -2.33333.. which is truncated to -2.
//
//    Constraints:
//    -231 <= dividend, divisor <= 231 - 1
//    divisor != 0



//给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
//    返回被除数dividend除以除数divisor得到的商。
//
//    整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
//
//    示例1:
//    输入: dividend = 10, divisor = 3
//    输出: 3
//    解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
//
//    示例2:
//    输入: dividend = 7, divisor = -3
//    输出: -2
//    解释: 7/-3 = truncate(-2.33333..) = -2
//    
//
//    提示：
//    被除数和除数均为 32 位有符号整数。
//    除数不为0。
//    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231− 1]。本题中，如果除法结果溢出，则返回 231− 1。


public class Q29 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int dividend = cin.nextInt();
        int divisor = cin.nextInt();
        cin.close();

        int result = divide(dividend, divisor);
        System.out.println(result);
    }

    private static int divide(int dividend, int divisor) {
        int sign = (dividend ^ divisor) >= 0 ? 1 : -1; // check for positive or negative.
        dividend = -Math.abs(dividend); // convert to negative number
        divisor = -Math.abs(divisor);  // convert to negative number
        int result = 0;
        // Avoid overflow
        int threshold = Integer.MIN_VALUE >> 1;
        while (dividend <= divisor) {
            int temp = divisor;
            int times = 1;
            //temp >= threshold，avoid 'temp' overflow.
            while (temp >= threshold && dividend <= (temp << 1)) {
                temp <<= 1;
                times <<= 1;
            }
            dividend -= temp;
            result -= times;
        }
        // check for overflow
        if (result == Integer.MIN_VALUE && sign == 1)
            return Integer.MAX_VALUE;
        return sign < 0 ? result : -result;
    }

    // Method 2 (advanced): without using "+" and "-"
//    private static int divide(int dividend, int divisor) {
//        boolean sign = (dividend ^ divisor) >= 0; // check for positive or negative
//        dividend = dividend < 0 ? dividend : ~subtraction(dividend, 1);
//        divisor = divisor < 0 ? divisor : ~subtraction(divisor, 1);
//        int res = 0;
//        int threshold = Integer.MIN_VALUE >> 1;
//        while (dividend <= divisor) {
//            int temp = divisor;
//            int times = 1;
//            //temp >= threshold，avoid 'temp' overflow
//            while (temp >= threshold && dividend <= (temp << 1)) {
//                temp <<= 1;
//                times <<= 1;
//            }
//            dividend = subtraction(dividend, temp);
//            res = subtraction(res, times);
//        }
//        // check overflow
//        if (res == Integer.MIN_VALUE && sign)
//            return Integer.MAX_VALUE;
//        return !sign ? res : ~subtraction(res, 1);
//    }
//
//    private static int subtraction(int a, int b) {
//        if (b == 0)
//            return a;
//        int c = a & b;
//        a ^= c;
//        b ^= c;
//        return subtraction(a | b, b << 1);
//    }
}
