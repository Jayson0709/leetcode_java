package algorithms.greedyAlgorithms;

import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


//Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
//
//    Example 1:
//    Input: num = "1432219", k = 3
//    Output: "1219"
//    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
//
//    Example 2:
//    Input: num = "10200", k = 1
//    Output: "200"
//    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
//
//    Example 3:
//    Input: num = "10", k = 2
//    Output: "0"
//    Explanation: Remove all the digits from the number, and it is left with nothing which is 0.
//
//    Constraints:
//    1 <= k <= num.length <= 10^5
//    num consists of only digits.
//    num does not have any leading zeros except for the zero itself.



//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
//
//    示例 1 ：
//    输入：num = "1432219", k = 3
//    输出："1219"
//    解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
//
//    示例 2 ：
//    输入：num = "10200", k = 1
//    输出："200"
//    解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
//
//    示例 3 ：
//    输入：num = "10", k = 2
//    输出："0"
//    解释：从原数字移除所有的数字，剩余为空就是 0 。
//
//    提示：
//    1 <= k <= num.length <= 10^5
//    num 仅由若干位数字（0 - 9）组成
//    除了 0 本身之外，num 不含任何前导零



public class Q402 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String num = cin.nextLine().strip();
        int k = cin.nextInt();
        cin.close();
        System.out.println(removeKDigits(num, k));
    }

    private static String removeKDigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }
        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            res.append(digit);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
