package dataStructures.string;
import java.util.*;
import java.nio.charset.*;


//You are given an array of strings words and a string pref.
//
//    Return the number of strings in words that contain pref as a prefix.
//
//    A prefix of a string s is any leading contiguous substring of s.
//
//    Example 1:
//    Input: words = ["pay","attention","practice","attend"], pref = "at"
//    Output: 2
//    Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
//
//    Example 2:
//    Input: words = ["leetcode","win","loops","success"], pref = "code"
//    Output: 0
//    Explanation: There are no strings that contain "code" as a prefix.
//
//    Constraints:
//    1 <= words.length <= 100
//    1 <= words[i].length, pref.length <= 100
//    words[i] and pref consist of lowercase English letters.


// 给你一个字符串数组 words 和一个字符串 pref 。
//
// 返回 words 中以 pref 作为 前缀 的字符串的数目。
//
// 字符串 s 的 前缀 就是 s 的任一前导连续字符串。
//
// 示例 1：
// 输入：words = ["pay","attention","practice","attend"], pref = "at"
// 输出：2
// 解释：以 "at" 作为前缀的字符串有两个，分别是："attention" 和 "attend" 。
//
// 示例 2：
// 输入：words = ["leetcode","win","loops","success"], pref = "code"
// 输出：0
// 解释：不存在以 "code" 作为前缀的字符串。
//
// 提示：
// 1 <= words.length <= 100
// 1 <= words[i].length, pref.length <= 100
// words[i] 和 pref 由小写英文字母组成


public class Q2185 {
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] words = cin.nextLine().strip().split(" ");
        String pref = cin.nextLine();
        cin.close();
        int result = prefixCount(words, pref);
        System.out.println(result);
    }

    public static int prefixCount(String[] words, String pref) {
        int result = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                result++;
            }
        }
        return result;
    }
}
