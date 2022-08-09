package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//    Example 1:
//    Input: s = "anagram", t = "nagaram"
//    Output: true
//
//    Example 2:
//    Input: s = "rat", t = "car"
//    Output: false
//
//    Constraints:
//    1 <= s.length, t.length <= 5 * 104
//    s and t consist of lowercase English letters.
//
//    Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?



//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//    注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
//
//    示例 1:
//    输入: s = "anagram", t = "nagaram"
//    输出: true
//
//    示例 2:
//    输入: s = "rat", t = "car"
//    输出: false
//
//    提示:
//    1 <= s.length, t.length <= 5 * 104
//    s 和 t 仅包含小写字母
//
//    进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？



public class Q242 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        String t = cin.nextLine().strip();
        cin.close();
        System.out.println(isAnagram(s, t));
    }

    // Method 1: Use sort
//    private static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] sChars = s.toCharArray();
//        char[] tChars = t.toCharArray();
//        Arrays.sort(sChars);
//        Arrays.sort(tChars);
//        for (int i = 0; i < sChars.length; i++) {
//            if (sChars[i] != tChars[i]) {
//                return false;
//            }
//        }
//        return true;
//    }

    // Method 2: Use HashMap
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            table.put(c, table.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            table.put(c, table.getOrDefault(c, 0) - 1);
            if (table.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
