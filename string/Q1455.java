package string;
//Given a sentence that consists of some words separated by a single space, and a searchWord, check if searchWord is a prefix of any word in sentence.
//
//    Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
//
//    A prefix of a string s is any leading contiguous substring of s.
//
//     
//
//    Example 1:
//
//    Input: sentence = "i love eating burger", searchWord = "burg"
//    Output: 4
//    Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
//    Example 2:
//
//    Input: sentence = "this problem is an easy problem", searchWord = "pro"
//    Output: 2
//    Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2 as it's the minimal index.
//    Example 3:
//
//    Input: sentence = "i am tired", searchWord = "you"
//    Output: -1
//    Explanation: "you" is not a prefix of any word in the sentence.
//     
//
//    Constraints:
//
//    1 <= sentence.length <= 100
//    1 <= searchWord.length <= 10
//    sentence consists of lowercase English letters and spaces.
//    searchWord consists of lowercase English letters.


// 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。

// 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。

// 字符串 s 的 前缀 是 s 的任何前导连续子字符串。

//  

// 示例 1：

// 输入：sentence = "i love eating burger", searchWord = "burg"
// 输出：4
// 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
// 示例 2：

// 输入：sentence = "this problem is an easy problem", searchWord = "pro"
// 输出：2
// 解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
// 示例 3：

// 输入：sentence = "i am tired", searchWord = "you"
// 输出：-1
// 解释："you" 不是句子中任何单词的前缀。

//  

// 提示：

// 1 <= sentence.length <= 100
// 1 <= searchWord.length <= 10
// sentence 由小写英文字母和空格组成。
// searchWord 由小写英文字母组成。

import java.util.*;
import java.nio.charset.StandardCharsets;

public class Q1455 {
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String sentence = cin.nextLine().strip();
        String searchWord = cin.nextLine().strip();
        cin.close();
        int result = isPrefixOfWord(sentence, searchWord);
        System.out.println(result);
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] wordTokens = sentence.toLowerCase().split(" ");
        for (int i = 0; i < wordTokens.length; i++) {
            if (wordTokens[i].startsWith(searchWord)) {
                return i + 1;
            }
        }            
        return -1;
    }
}