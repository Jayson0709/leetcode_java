package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
//
//    The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
//
//    Return the minimum number of operations needed to make s alternating.
//
//    Example 1:
//    Input: s = "0100"
//    Output: 1
//    Explanation: If you change the last character to '1', s will be "0101", which is alternating.
//
//    Example 2:
//    Input: s = "10"
//    Output: 0
//    Explanation: s is already alternating.
//
//    Example 3:
//    Input: s = "1111"
//    Output: 2
//    Explanation: You need two operations to reach "0101" or "1010".
//
//    Constraints:
//    1 <= s.length <= 10^4
//    s[i] is either '0' or '1'.



//给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
//
//    交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
//
//    返回使 s 变成 交替字符串 所需的 最少 操作数。
//
//    示例 1：
//    输入：s = "0100"
//    输出：1
//    解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
//
//    示例 2：
//    输入：s = "10"
//    输出：0
//    解释：s 已经是交替字符串。
//
//    示例 3：
//    输入：s = "1111"
//    输出：2
//    解释：需要 2 步操作得到 "0101" 或 "1010" 。
//
//    提示：
//    1 <= s.length <= 10^4
//    s[i] 是 '0' 或 '1'



public class Q1758 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(minOperations(s));
    }

    // Version 1: brute force
//    private static int minOperations(String s) {
//        int count1 = 0;
//        int count2 = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (i % 2 == 0 && s.charAt(i) == '1') {
//                count1++;
//            } else if (i % 2 != 0 && s.charAt(i) == '0'){
//                count1++;
//            }
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (i % 2 == 0 && s.charAt(i) == '0') {
//                count2++;
//            } else if (i % 2 != 0 && s.charAt(i) == '1'){
//                count2++;
//            }
//        }
//        return Math.min(count1, count2);
//    }

    //Version 2: improved version
    private static int minOperations(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != (char) ('0' + i % 2)) {
                cnt++;
            }
        }
        return Math.min(cnt, s.length() - cnt);
    }
}
