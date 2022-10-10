package dataStructures.string.stringMatching;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given a string array words and a string s, where words[i] and s comprise only of lowercase English letters.
//
//    Return the number of strings in words that are a prefix of s.
//
//    A prefix of a string is a substring that occurs at the beginning of the string. A substring is a contiguous sequence of characters within a string.
//    
//    Example 1:
//    Input: words = ["a","b","c","ab","bc","abc"], s = "abc"
//    Output: 3
//    Explanation:
//    The strings in words which are a prefix of s = "abc" are:
//    "a", "ab", and "abc".
//    Thus, the number of strings in words which are a prefix of s is 3.
//    
//    Example 2:
//    Input: words = ["a","a"], s = "aa"
//    Output: 2
//    Explanation:
//    Both of the strings are a prefix of s.
//    Note that the same string can occur multiple times in words, and it should be counted each time.
//    
//    Constraints:
//    1 <= words.length <= 1000
//    1 <= words[i].length, s.length <= 10
//    words[i] and s consist of lowercase English letters only.



//给你一个字符串数组 words 和一个字符串 s ，其中 words[i] 和 s 只包含 小写英文字母 。
//
//    请你返回 words 中是字符串 s 前缀 的 字符串数目 。
//
//    一个字符串的 前缀 是出现在字符串开头的子字符串。子字符串 是一个字符串中的连续一段字符序列。
//
//    示例 1：
//    输入：words = ["a","b","c","ab","bc","abc"], s = "abc"
//    输出：3
//    解释：
//    words 中是 s = "abc" 前缀的字符串为：
//    "a" ，"ab" 和 "abc" 。
//    所以 words 中是字符串 s 前缀的字符串数目为 3 。
//
//    示例 2：
//    输入：words = ["a","a"], s = "aa"
//    输出：2
//    解释：
//    两个字符串都是 s 的前缀。
//    注意，相同的字符串可能在 words 中出现多次，它们应该被计数多次。
//
//    提示：
//    1 <= words.length <= 1000
//    1 <= words[i].length, s.length <= 10
//    words[i] 和 s 只 包含小写英文字母。


public class Q2255 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] words = cin.nextLine().strip().split(" ");
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(countPrefixes(words, s));
    }

    private static int countPrefixes(String[] words, String s) {
        int res = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                res++;
            }
        }
        return res;
    }
}
