package interview;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//Given two strings,write a method to decide if one is a permutation of the other.
//
//    Example 1:
//    Input: s1 = "abc", s2 = "bca"
//    Output: true
//
//    Example 2:
//    Input: s1 = "abc", s2 = "bad"
//    Output: false
//
//    Note:
//    0 <= len(s1) <= 100
//    0 <= len(s2) <= 100



//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
//    示例 1：
//    输入: s1 = "abc", s2 = "bca"
//    输出: true
//
//    示例 2：
//    输入: s1 = "abc", s2 = "bad"
//    输出: false
//
//    说明：
//    0 <= len(s1) <= 100
//    0 <= len(s2) <= 100


public class CheckPermutation {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s1 = cin.nextLine().strip();
        String s2 = cin.nextLine().strip();
        cin.close();
        System.out.println(checkPermutation(s1, s2));
    }

    // Method 1: use Sorting
//    private static boolean checkPermutation(String s1, String s2) {
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        char[] chars1 = s1.toCharArray();
//        char[] chars2 = s2.toCharArray();
//        Arrays.sort(chars1);
//        Arrays.sort(chars2);
//        for (int i = 0; i < chars1.length; i++) {
//            if (chars1[i] != chars2[i]) {
//                return false;
//            }
//        }
//        return true;
//    }

    // Method 2: use HashMap
    private static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> hMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character c1 = s1.charAt(i);
            hMap.put(c1, hMap.getOrDefault(c1, 0) + 1);
            Character c2 = s2.charAt(i);
            hMap.put(c2, hMap.getOrDefault(c2, 0) - 1);
        }
        for (Integer count : hMap.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
