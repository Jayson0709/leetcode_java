package dataStructures.hashMap;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



//Given a pattern and a string s, find if s follows the same pattern.
//
//    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
//    
//    Example 1:
//    Input: pattern = "abba", s = "dog cat cat dog"
//    Output: true
//    
//    Example 2:
//    Input: pattern = "abba", s = "dog cat cat fish"
//    Output: false
//    
//    Example 3:
//    Input: pattern = "aaaa", s = "dog cat cat dog"
//    Output: false
//    
//    Constraints:
//    1 <= pattern.length <= 300
//    pattern contains only lower-case English letters.
//    1 <= s.length <= 3000
//    s contains only lowercase English letters and spaces ' '.
//    s does not contain any leading or trailing spaces.
//    All the words in s are separated by a single space.



//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//
//    这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
//
//    示例1:
//    输入: pattern = "abba", s = "dog cat cat dog"
//    输出: true
//
//    示例 2:
//    输入:pattern = "abba", s = "dog cat cat fish"
//    输出: false
//
//    示例 3:
//    输入: pattern = "aaaa", s = "dog cat cat dog"
//    输出: false
//
//    提示:
//    1 <= pattern.length <= 300
//    pattern 只包含小写英文字母
//    1 <= s.length <= 3000
//    s 只包含小写英文字母和 ' '
//    s 不包含 任何前导或尾随对空格
//    s 中每个单词都被 单个空格 分隔


public class Q290 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String pattern = cin.nextLine().strip();
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(wordPattern(pattern, s));
    }

    private static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int n = pattern.length();
        if (n != words.length) {
            return false;
        }
        Map<Character, String> charToStr = new HashMap<>();
        Map<String, Character> strToChar = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Character c = pattern.charAt(i);
            if (strToChar.containsKey(words[i]) && strToChar.get(words[i]) != c) {
                return false;
            }
            if (charToStr.containsKey(c) && !words[i].equals(charToStr.get(c))) {
                return false;
            }
            strToChar.put(words[i], c);
            charToStr.put(c, words[i]);
        }
        return true;
    }
}
