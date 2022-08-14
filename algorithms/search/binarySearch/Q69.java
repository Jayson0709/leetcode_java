package algorithms.search.binarySearch;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a non-negative integer x, compute and return the square root of x.
//
//    Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
//
//    Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
//    
//    Example 1:
//    Input: x = 4
//    Output: 2
//    
//    Example 2:
//    Input: x = 8
//    Output: 2
//    
//    Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
//    
//    Constraints:
//    0 <= x <= 2^31 - 1



//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
//    由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
//    注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//
//    示例 1：
//    输入：x = 4
//    输出：2
//
//    示例 2：
//    输入：x = 8
//    输出：2
//    解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
//
//    提示：
//    0 <= x <= 2^31 - 1



public class Q69 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int x = cin.nextInt();
        cin.close();
        System.out.println(mySqrt(x));
    }

    // Method 1: pocket calculator algorithm
//    private static int mySqrt(int x) {
//        if (x == 0) {
//            return 0;
//        }
//        int ans = (int) Math.exp(0.5 * Math.log(x));
//        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
//    }

    // Method 2: Newton's Method
//    private static int mySqrt(int x) {
//        if (x == 0) {
//            return 0;
//        }
//
//        double x0 = x;
//        while (true) {
//            double xi = 0.5 * (x0 + (double) x / x0);
//            if (Math.abs(x0 - xi) < 1e-7) {
//                break;
//            }
//            x0 = xi;
//        }
//        return (int) x0;
//    }

    // Method 3: binary search
    private static int mySqrt(int x) {
        int left = 0, right = x, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
