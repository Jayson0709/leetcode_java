package math;
import java.util.*;
import java.nio.charset.StandardCharsets;


//A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.
//
//    Given an integer n, return true if n is a perfect number, otherwise return false.
//
//    Example 1:
//    Input: num = 28
//    Output: true
//    Explanation: 28 = 1 + 2 + 4 + 7 + 14
//    1, 2, 4, 7, and 14 are all divisors of 28.
//    
//    Example 2:
//    Input: num = 7
//    Output: false
//
//    Constraints:
//    1 <= num <= 108


//对于一个正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
//
//    给定一个整数n，如果是完美数，返回 true；否则返回 false。
//
//    示例 1：
//    输入：num = 28
//    输出：true
//    解释：28 = 1 + 2 + 4 + 7 + 14
//    1, 2, 4, 7, 和 14 是 28 的所有正因子。
//
//    示例 2：
//    输入：num = 7
//    输出：false
//
//    提示：
//    1 <= num <= 108


public class Q507 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int num = cin.nextInt();
        cin.close();

        boolean result = checkPerfectNumber(num);
        System.out.println(result);
    }

    private static boolean checkPerfectNumber(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        int biggestDivisor = (int) Math.sqrt(num);
        int summation = 1;
        for (int i = 2; i <= biggestDivisor; i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    summation += i;
                } else {
                    summation += i;
                    summation += num/i;
                }
            }
        }
        return summation == num;
    }
}
