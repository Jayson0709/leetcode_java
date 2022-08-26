package algorithms.windowSliding;
import java.util.*;
import java.nio.charset.StandardCharsets;
import utils.*;


//You are given a dataStructures.string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order,and without any intervening characters.
//
//    You can return the answer in any order.
//
//    Example 1:
//    Input: s = "barfoothefoobarman", words = ["foo","bar"]
//    Output: [0,9]
//    Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
//    The output order does not matter, returning [9,0] is fine too.
//    
//    Example 2:
//    Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//    Output: []
//    Example 3:
//
//    Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//    Output: [6,9,12]
//
//    Constraints:
//    1 <= s.length <= 104
//    s consists of lower-case English letters.
//    1 <= words.length <= 5000
//    1 <= words[i].length <= 30
//    words[i]consists of lower-case English letters.


//给定一个字符串s和一些 长度相同 的单词words 。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。
//
//    注意子串要与words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑words中单词串联的顺序。
//
//    示例 1：
//    输入：s = "barfoothefoobarman", words = ["foo","bar"]
//    输出：[0,9]
//    解释：
//    从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//    输出的顺序不重要, [9,0] 也是有效答案。
//
//    示例 2：
//    输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//    输出：[]
//
//    示例 3：
//    输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//    输出：[6,9,12]
//    
//
//    提示：
//    1 <= s.length <= 104
//    s 由小写英文字母组成
//    1 <= words.length <= 5000
//    1 <= words[i].length <= 30
//    words[i]由小写英文字母组成


public class Q30 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        String[] words = cin.nextLine().strip().split(" ");
        cin.close();
        List<Integer> result = findSubstring(s, words);
        System.out.println(OutputMethods.formatListOutputData(result));
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return result;
        }
        int n = s.length();
        int wordLen = words[0].length();
        int windowSize = wordNum * wordLen;
        // Put all words into the first HashMap
        Map<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }
        // Iterate all the substrings
        for (int i = 0; i < n - windowSize + 1; i++) {
            // The second HashMap stores the current scanned word
            Map<String, Integer> hasWords = new HashMap<>();
            int num = 0;
            while (num < wordNum) {
                // Get the current word.
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (allWords.containsKey(word)) {
                    hasWords.put(word, hasWords.getOrDefault(word, 0) + 1);
                    // If the value in the second HashMap is bigger than the first one, break
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num ++;
            }
            // If all the words fit
            if (num == wordNum) {
                result.add(i);
            }
        }
        return result;
    }
}
