package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
//
//    Example 1:
//    Input: num = 38
//    Output: 2
//    Explanation: The process is
//    38 --> 3 + 8 --> 11
//    11 --> 1 + 1 --> 2
//    Since 2 has only one digit, return it.
//
//    Example 2:
//    Input: num = 0
//    Output: 0
//
//    Constraints:
//    0 <= num <= 2^31 - 1
//
//    Follow up: Could you do it without any loop/recursion in O(1) runtime?


//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
//
//    示例 1:
//    输入: num = 38
//    输出: 2
//    解释: 各位相加的过程为：
//    38 --> 3 + 8 --> 11
//    11 --> 1 + 1 --> 2
//    由于 2 是一位数，所以返回 2。
//
//    示例 2:
//    输入: num = 0
//    输出: 0
//
//    提示：
//    0 <= num <= 2^31 - 1
//
//    进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？



public class Q258 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int num = cin.nextInt();
        cin.close();
        System.out.println(addDigits(num));
    }

    // Method 1: Simulation
//    private static int addDigits(int num) {
//        while (num >= 10) {
//            int sum = 0;
//            while (num > 0) {
//                sum += num % 10;
//                num /= 10;
//            }
//            num = sum;
//        }
//        return num;
//    }


    // Method 2: Math technique
    private static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
