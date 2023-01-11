package dataStructures.hashMap;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//You are given a 0-indexed string num of length n consisting of digits.
//
//    Return true if for every index i in the range 0 <= i < n, the digit i occurs num[i] times in num, otherwise return false.
//
//    Example 1:
//    Input: num = "1210"
//    Output: true
//    Explanation:
//    num[0] = '1'. The digit 0 occurs once in num.
//    num[1] = '2'. The digit 1 occurs twice in num.
//    num[2] = '1'. The digit 2 occurs once in num.
//    num[3] = '0'. The digit 3 occurs zero times in num.
//    The condition holds true for every index in "1210", so return true.
//
//    Example 2:
//    Input: num = "030"
//    Output: false
//    Explanation:
//    num[0] = '0'. The digit 0 should occur zero times, but actually occurs twice in num.
//    num[1] = '3'. The digit 1 should occur three times, but actually occurs zero times in num.
//    num[2] = '0'. The digit 2 occurs zero times in num.
//    The indices 0 and 1 both violate the condition, so return false.
//
//    Constraints:
//    n == num.length
//    1 <= n <= 10
//    num consists of digits.


//给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
//
//    如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，那么请你返回 true ，否则返回 false 。
//
//    示例 1：
//    输入：num = "1210"
//    输出：true
//    解释：
//    num[0] = '1' 。数字 0 在 num 中出现了一次。
//    num[1] = '2' 。数字 1 在 num 中出现了两次。
//    num[2] = '1' 。数字 2 在 num 中出现了一次。
//    num[3] = '0' 。数字 3 在 num 中出现了零次。
//    "1210" 满足题目要求条件，所以返回 true 。
//
//    示例 2：
//    输入：num = "030"
//    输出：false
//    解释：
//    num[0] = '0' 。数字 0 应该出现 0 次，但是在 num 中出现了两次。
//    num[1] = '3' 。数字 1 应该出现 3 次，但是在 num 中出现了零次。
//    num[2] = '0' 。数字 2 在 num 中出现了 0 次。
//    下标 0 和 1 都违反了题目要求，所以返回 false 。
//
//    提示：
//    n == num.length
//    1 <= n <= 10
//    num 只包含数字。


public class Q2283 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String num = cin.nextLine().strip();
        cin.close();
        System.out.println(digitCount(num));
    }

    private static boolean digitCount(String num) {
        Map<Integer, Integer> numCount = new HashMap<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            int digit = num.charAt(i) - '0';
            numCount.put(digit, numCount.getOrDefault(digit, 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            int value = num.charAt(i) - '0';
            if (numCount.getOrDefault(i, 0) != value) {
                return false;
            }
        }
        return true;
    }
}
