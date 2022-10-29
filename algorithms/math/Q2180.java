package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//Given a positive integer num, return the number of positive integers less than or equal to num whose digit sums are even.
//
//    The digit sum of a positive integer is the sum of all its digits.
//
//    Example 1:
//    Input: num = 4
//    Output: 2
//    Explanation:
//    The only integers less than or equal to 4 whose digit sums are even are 2 and 4.
//
//    Example 2:
//    Input: num = 30
//    Output: 14
//    Explanation:
//    The 14 integers less than or equal to 30 whose digit sums are even are
//    2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.
//
//    Constraints:
//    1 <= num <= 1000



//给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
//
//    正整数的 各位数字之和 是其所有位上的对应数字相加的结果。
//
//    示例 1：
//    输入：num = 4
//    输出：2
//    解释：
//    只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。
//
//    示例 2：
//    输入：num = 30
//    输出：14
//    解释：
//    只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是：
//    2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
//
//    提示：
//    1 <= num <= 1000



public class Q2180 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int num = cin.nextInt();
        cin.close();
        System.out.println(countEven(num));
    }

    private static int countEven(int num) {
        int res = 0;
        for (int i = 2; i <= num; i++) {
            if (isValidNum(i)) {
                res++;
            }
        }
        return res;
    }

    private static boolean isValidNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 2 == 0;
    }
}
