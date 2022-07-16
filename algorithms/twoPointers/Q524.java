package algorithms.twoPointers;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
//    
//    Example 1:
//    Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//    Output: "apple"
//    
//    Example 2:
//    Input: s = "abpcplea", dictionary = ["a","b","c"]
//    Output: "a"
//
//    Constraints:
//    1 <= s.length <= 1000
//    1 <= dictionary.length <= 1000
//    1 <= dictionary[i].length <= 1000
//    s and dictionary[i] consist of lowercase English letters.


//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
//
//    如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
//
//    示例 1：
//    输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//    输出："apple"
//
//    示例 2：
//    输入：s = "abpcplea", dictionary = ["a","b","c"]
//    输出："a"
//
//    提示：
//    1 <= s.length <= 1000
//    1 <= dictionary.length <= 1000
//    1 <= dictionary[i].length <= 1000
//    s 和 dictionary[i] 仅由小写英文字母组成



public class Q524 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String s = cin.nextLine().strip();
        String[] words = cin.nextLine().strip().split(" ");
        cin.close();
        List<String> dictionary = Arrays.stream(words).toList();
        String result = findLongestWord(s, dictionary);
        System.out.println(result);
    }

    private static String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String word : dictionary) {
            int p1 = 0, p2 = 0;
            while (p1 < word.length() && p2 < s.length()) {
                if (word.charAt(p1) == s.charAt(p2)) {
                    p1++;
                }
                p2++;
            }
            if (p1 == word.length()) {
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }
}
