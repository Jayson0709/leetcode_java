package interview;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 (e.g.,"waterbottle" is a rotation of"erbottlewat"). Can you use only one call to the method that checks if one word is a substring of another?
//
//    Example 1:
//    Input: s1 = "waterbottle", s2 = "erbottlewat"
//    Output: True
//    
//    Example 2:
//    Input: s1 = "aa", s2 = "aba"
//    Output: False
//
//    Note:
//    0 <= s1.length, s2.length <= 100000


//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
//
//    示例1:
//    输入：s1 = "waterbottle", s2 = "erbottlewat"
//    输出：True
//
//    示例2:
//    输入：s1 = "aa", s2 = "aba"
//    输出：False
//
//    提示：
//    字符串长度在[0, 100000]范围内。
//
//    说明:
//    你能只调用一次检查子串的方法吗？



public class StringRotation {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s1 = cin.nextLine().strip();
        String s2 = cin.nextLine().strip();
        cin.close();
        System.out.println(isFlippedString(s1, s2));
    }

    // Method 1: simulation
//    private static boolean isFlippedString(String s1, String s2) {
//        int m = s1.length();
//        int n = s2.length();
//        if (m != n) {
//            return false;
//        }
//        if (n == 0) {
//            return true;
//        }
//        for (int i = 0; i < n; i++) {
//            boolean flag = true;
//            for (int j = 0; j < n; j++) {
//                if (s1.charAt((i + j) % n) != s2.charAt(j)) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                return true;
//            }
//        }
//        return false;
//    }

    // Method 2: search string directly
    private static boolean isFlippedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
