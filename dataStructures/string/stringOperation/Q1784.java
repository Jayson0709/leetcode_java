package dataStructures.string.stringOperation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//Given a binary string s without leading zeros, return true if s contains at most one contiguous segment of ones. Otherwise, return false.
//
//    Example 1:
//    Input: s = "1001"
//    Output: false
//    Explanation: The ones do not form a contiguous segment.
//
//    Example 2:
//    Input: s = "110"
//    Output: true
//
//    Constraints:
//    1 <= s.length <= 100
//    s[i] is either '0' or '1'.
//    s[0] is '1'.



//给你一个二进制字符串 s ，该字符串 不含前导零 。
//
//    如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
//
//    如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true 。否则，返回 false 。
//
//    示例 1：
//    输入：s = "1001"
//    输出：false
//    解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
//
//    示例 2：
//    输入：s = "110"
//    输出：true
//
//    提示：
//    1 <= s.length <= 100
//    s[i] 为 '0' 或 '1'
//    s[0] 为 '1'


public class Q1784 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(checkOnesSegment(s));
    }

    private static boolean checkOnesSegment(String s) {
        int idx = 0;
        int n = s.length();
        boolean flag = true;
        while (idx < n && s.charAt(idx) == '1') {
            idx++;
        }
        while (idx < n) {
            if (s.charAt(idx) == '1') {
                flag = false;
                break;
            }
            idx++;
        }
        return flag;
    }
}
