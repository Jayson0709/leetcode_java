package algorithms.math;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
//
//    Example 1:
//    Input: x = 2.00000, n = 10
//    Output: 1024.00000
//    
//    Example 2:
//    Input: x = 2.10000, n = 3
//    Output: 9.26100
//    
//    Example 3:
//    Input: x = 2.00000, n = -2
//    Output: 0.25000
//    Explanation: 2-2 = 1/22 = 1/4 = 0.25
//
//    Constraints:
//    -100.0 < x < 100.0
//    (-2)^31 <= n <= (2^31)-1
//    -10^4 <= x^n <= 10^4



//实现pow(x, n)，即计算 x 的整数n 次幂函数（即，x^n ）。
//
//    示例 1：
//    输入：x = 2.00000, n = 10
//    输出：1024.00000
//
//    示例 2：
//    输入：x = 2.10000, n = 3
//    输出：9.26100
//
//    示例 3：
//    输入：x = 2.00000, n = -2
//    输出：0.25000
//    解释：2^(-2) = 1/2^2 = 1/4 = 0.25
//    
//
//    提示：
//    -100.0 < x < 100.0
//    (-2)^31 <= n <= (2^31)-1
//    (-10)^4 <= x^n <= 10^4



public class Q50 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        double x = Double.parseDouble(cin.nextLine());
        int n = Integer.parseInt(cin.nextLine());
        cin.close();

        double result = myPow(x, n);
        System.out.println(result);
    }

    private static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if ((n & 1) == 0) {
            // Check the parity
            return myPow(x * x, n / 2);
        } else {
            return (n > 0 ? x : 1.0 / x) * myPow(x * x, n / 2);
        }
    }
}
