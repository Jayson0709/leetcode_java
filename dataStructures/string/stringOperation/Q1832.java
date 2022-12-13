package dataStructures.string.stringOperation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//A pangram is a sentence where every letter of the English alphabet appears at least once.
//
//    Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
//
//    Example 1:
//    Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
//    Output: true
//    Explanation: sentence contains at least one of every letter of the English alphabet.
//
//    Example 2:
//    Input: sentence = "leetcode"
//    Output: false
//
//    Constraints:
//    1 <= sentence.length <= 1000
//    sentence consists of lowercase English letters.



//全字母句 指包含英语字母表中每个字母至少一次的句子。
//
//    给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
//
//    如果是，返回 true ；否则，返回 false 。
//
//    示例 1：
//    输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
//    输出：true
//    解释：sentence 包含英语字母表中每个字母至少一次。
//
//    示例 2：
//    输入：sentence = "leetcode"
//    输出：false
//
//    提示：
//    1 <= sentence.length <= 1000
//    sentence 由小写英语字母组成


public class Q1832 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String sentence = cin.nextLine().strip();
        cin.close();
        System.out.println(checkIfPangram(sentence));
    }

    private static boolean checkIfPangram(String sentence) {
        int[] counts = new int[26];
        for (char c : sentence.toCharArray()) {
            counts[c - 'a']++;
        }
        for (int count : counts) {
            if (count == 0) {
                return false;
            }
        }
        return true;
    }
}
