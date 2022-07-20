package math;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an integer number n, return the difference between the product of its digits and the sum of its digits.
//
//    Example 1:
//    Input: n = 234
//    Output: 15
//    Explanation:
//    Product of digits = 2 * 3 * 4 = 24
//    Sum of digits = 2 + 3 + 4 = 9
//    Result = 24 - 9 = 15
//    
//    Example 2:
//    Input: n = 4421
//    Output: 21
//    Explanation:
//    Product of digits = 4 * 4 * 2 * 1 = 32
//    Sum of digits = 4 + 4 + 2 + 1 = 11
//    Result = 32 - 11 = 21
//    
//    Constraints:
//    1 <= n <= 10^5


//给你一个整数n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
//
//    示例 1：
//    输入：n = 234
//    输出：15
//    解释：
//    各位数之积 = 2 * 3 * 4 = 24
//    各位数之和 = 2 + 3 + 4 = 9
//    结果 = 24 - 9 = 15
//
//    示例 2：
//    输入：n = 4421
//    输出：21
//    解释：
//    各位数之积 = 4 * 4 * 2 * 1 = 32
//    各位数之和 = 4 + 4 + 2 + 1 = 11
//    结果 = 32 - 11 = 21
//
//    提示：
//    1 <= n <= 10^5



public class Q1281 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int n = cin.nextInt();
        cin.close();

        int result = subtractProductAndSum(n);
        System.out.println(result);
    }

    private static int subtractProductAndSum(int n) {
        int sum = 0, mul = 1;
        while (n > 0) {
            int curDigit = n % 10;
            n /= 10;
            sum += curDigit;
            mul *= curDigit;
        }
        return mul - sum;
    }
}
