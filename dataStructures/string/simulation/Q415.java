package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;




//Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
//
//    You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
//    
//    Example 1:
//    Input: num1 = "11", num2 = "123"
//    Output: "134"
//    
//    Example 2:
//    Input: num1 = "456", num2 = "77"
//    Output: "533"
//    
//    Example 3:
//    Input: num1 = "0", num2 = "0"
//    Output: "0"
//    
//    Constraints:
//    1 <= num1.length, num2.length <= 10^4
//    num1 and num2 consist of only digits.
//    num1 and num2 don't have any leading zeros except for the zero itself.



//给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
//
//    你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
//
//    示例 1：
//    输入：num1 = "11", num2 = "123"
//    输出："134"
//
//    示例 2：
//    输入：num1 = "456", num2 = "77"
//    输出："533"
//
//    示例 3：
//    输入：num1 = "0", num2 = "0"
//    输出："0"
//
//    提示：
//    1 <= num1.length, num2.length <= 10^4
//    num1 和num2 都只包含数字0-9
//    num1 和num2 都不包含任何前导零


public class Q415 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String num1 = cin.nextLine().strip();
        String num2 = cin.nextLine().strip();
        cin.close();
        System.out.println(addStrings(num1, num2));
    }

    private static String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0 || carry != 0) {
            int x = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int y = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            int result = x + y + carry;
            res.append(result % 10);
            carry = result / 10;
            idx1--;
            idx2--;
        }
        return res.reverse().toString();
    }
}
