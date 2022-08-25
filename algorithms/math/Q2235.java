package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given two integers num1 and num2, return the sum of the two integers.
//
//    Example 1:
//    Input: num1 = 12, num2 = 5
//    Output: 17
//    Explanation: num1 is 12, num2 is 5, and their sum is 12 + 5 = 17, so 17 is returned.
//
//    Example 2:
//    Input: num1 = -10, num2 = 4
//    Output: -6
//    Explanation: num1 + num2 = -6, so -6 is returned.
//
//    Constraints:
//    -100 <= num1, num2 <= 100



//给你两个整数 num1 和 num2，返回这两个整数的和。
//
//    示例 1：
//    输入：num1 = 12, num2 = 5
//    输出：17
//    解释：num1 是 12，num2 是 5 ，它们的和是 12 + 5 = 17 ，因此返回 17 。
//
//    示例 2：
//    输入：num1 = -10, num2 = 4
//    输出：-6
//    解释：num1 + num2 = -6 ，因此返回 -6 。
//
//    提示：
//    -100 <= num1, num2 <= 100



public class Q2235 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int num1 = cin.nextInt();
        int num2 = cin.nextInt();
        cin.close();
        System.out.println(sum(num1, num2));
    }

    private static int sum(int num1, int num2) {
        return num1 + num2;
    }
}
