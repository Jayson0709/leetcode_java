package algorithms.search.binarySearch;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
//
//    A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
//    For example, "ace" is a subsequence of "abcde".
//
//    Example 1:
//    Input: s = "abcde", words = ["a","bb","acd","ace"]
//    Output: 3
//    Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
//
//    Example 2:
//    Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//    Output: 2
//
//    Constraints:
//    1 <= s.length <= 5 * 10^4
//    1 <= words.length <= 5000
//    1 <= words[i].length <= 50
//    s and words[i] consist of only lowercase English letters.


//给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
//
//    字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
//
//    例如， “ace” 是 “abcde” 的子序列。
//
//    示例 1:
//    输入: s = "abcde", words = ["a","bb","acd","ace"]
//    输出: 3
//    解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
//
//    Example 2:
//    输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//    输出: 2
//
//    提示:
//    1 <= s.length <= 5 * 10^4
//    1 <= words.length <= 5000
//    1 <= words[i].length <= 50
//    words[i]和 s 都只由小写字母组成。


public class Q792 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        String[] words = cin.nextLine().strip().split(" ");
        cin.close();
        System.out.println(numMatchingSubseq(s, words));
    }

    private static int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                --res;
                continue;
            }
            int p = -1;
            for (int i = 0; i < w.length(); ++i) {
                char c = w.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }

    public static int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}
