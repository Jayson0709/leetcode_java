package algorithms.sorting;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


//You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
//
//    Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
//
//    Return any permutation of s that satisfies this property.
//
//    Example 1:
//    Input: order = "cba", s = "abcd"
//    Output: "cbad"
//    Explanation:
//    "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
//    Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
//
//    Example 2:
//    Input: order = "cbafg", s = "abcd"
//    Output: "cbad"
//
//    Constraints:
//    1 <= order.length <= 26
//    1 <= s.length <= 200
//    order and s consist of lowercase English letters.
//    All the characters of order are unique.


//给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
//
//    对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
//
//    返回 满足这个性质的 s 的任意排列 。
//
//    示例 1:
//    输入: order = "cba", s = "abcd"
//    输出: "cbad"
//    解释:
//    “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
//    因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
//
//    示例 2:
//    输入: order = "cbafg", s = "abcd"
//    输出: "cbad"
//
//    提示:
//    1 <= order.length <= 26
//    1 <= s.length <= 200
//    order 和 s 由小写英文字母组成
//    order 中的所有字符都 不同


public class Q791 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String order = cin.nextLine().strip();
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(customSortString(order, s));
    }

    // Version 1: customized sorting
//    private static String customSortString(String order, String s) {
//        int[] val = new int[26];
//        for (int i = 0; i < order.length(); ++i) {
//            val[order.charAt(i) - 'a'] = i + 1;
//        }
//        Character[] arr = new Character[s.length()];
//        for (int i = 0; i < s.length(); ++i) {
//            arr[i] = s.charAt(i);
//        }
//        Arrays.sort(arr, Comparator.comparingInt(c0 -> val[c0 - 'a']));
//        StringBuilder ans = new StringBuilder();
//        for (int i = 0; i < s.length(); ++i) {
//            ans.append(arr[i]);
//        }
//        return ans.toString();
//    }

    // Version 2: counting sort
    private static String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            char ch = order.charAt(i);
            while (freq[ch - 'a'] > 0) {
                ans.append(ch);
                freq[ch - 'a']--;
            }
        }
        for (int i = 0; i < 26; ++i) {
            while (freq[i] > 0) {
                ans.append((char) (i + 'a'));
                freq[i]--;
            }
        }
        return ans.toString();
    }
}
