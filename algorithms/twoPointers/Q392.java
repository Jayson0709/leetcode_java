package algorithms.twoPointers;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//
//    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
//
//    Example 1:
//    Input: s = "abc", t = "ahbgdc"
//    Output: true
//
//    Example 2:
//    Input: s = "axc", t = "ahbgdc"
//    Output: false
//
//    Constraints:
//    0 <= s.length <= 100
//    0 <= t.length <= 10^4
//    s and t consist only of lowercase English letters.
//
//    Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 10^9, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?



//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//
//    字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//
//    进阶：
//    如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
//
//    致谢：
//    特别感谢 @pbrother添加此问题并且创建所有测试用例。
//
//    示例 1：
//    输入：s = "abc", t = "ahbgdc"
//    输出：true
//
//    示例 2：
//    输入：s = "axc", t = "ahbgdc"
//    输出：false
//
//    提示：
//    0 <= s.length <= 100
//    0 <= t.length <= 10^4
//    两个字符串都只由小写字符组成。



public class Q392 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        String t = cin.nextLine().strip();
        cin.close();
        System.out.println(isSubsequence(s, t));
    }

    // Method 1: dynamic programming
//    private static boolean isSubsequence(String s, String t) {
//        int n = s.length(), m = t.length();
//        int[][] f = new int[m + 1][26];
//        for (int i = 0; i < 26; i++) {
//            f[m][i] = m;
//        }
//        for (int i = m - 1; i >= 0; i--) {
//            for (int j = 0; j < 26; j++) {
//                if (t.charAt(i) == j + 'a')
//                    f[i][j] = i;
//                else
//                    f[i][j] = f[i + 1][j];
//            }
//        }
//        int add = 0;
//        for (int i = 0; i < n; i++) {
//            if (f[add][s.charAt(i) - 'a'] == m) {
//                return false;
//            }
//            add = f[add][s.charAt(i) - 'a'] + 1;
//        }
//        return true;
//    }

    // Method 2: two pointers
    private static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
