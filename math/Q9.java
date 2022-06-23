package math;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given an integer x, return true if x is palindrome integer.
//
//    An integer is a palindrome when it reads the same backward as forward.
//
//    For example, 121 is a palindrome while 123 is not.
//
//    Example 1:
//    Input: x = 121
//    Output: true
//    Explanation: 121 reads as 121 from left to right and from right to left.
//    
//    Example 2:
//    Input: x = -121
//    Output: false
//    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore, it is not a palindrome.
//    
//    Example 3:
//    Input: x = 10
//    Output: false
//    Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.
//
//    Constraints:
//    -231<= x <= 231- 1


//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
//    回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//    例如，121 是回文，而 123 不是。
//
//    示例 1：
//    输入：x = 121
//    输出：true
//
//    示例2：
//    输入：x = -121
//    输出：false
//    解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//    示例 3：
//    输入：x = 10
//    输出：false
//    解释：从右向左读, 为 01 。因此它不是一个回文数。
//    
//
//    提示：
//    -231<= x <= 231- 1


public class Q9 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int x = cin.nextInt();
        cin.close();

        boolean result = isPalindrome(x);
        System.out.println(result);
    }

    // Method 1: Use string
//    private static boolean isPalindrome(int x) {
//        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
//        return (x + "").equals(reversedStr);
//    }

    // Method 2: Use Math
    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int divisor = 1;
        while (x / divisor >= 10) {
            divisor *= 10;
        }
        while (x > 0) {
            int quotient = x / divisor;
            int remainder = x % 10;
            if (quotient != remainder) {
                return false;
            }
            x = (x % divisor) / 10;
            divisor /= 100;
        }
        return true;
    }
}
