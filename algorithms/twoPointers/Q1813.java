package algorithms.twoPointers;


import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//A sentence is a list of words that are separated by a single space with no leading or trailing spaces. For example, "Hello World", "HELLO", "hello world hello world" are all sentences. Words consist of only uppercase and lowercase English letters.
//
//    Two sentences sentence1 and sentence2 are similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal. For example, sentence1 = "Hello my name is Jane" and sentence2 = "Hello Jane" can be made equal by inserting "my name is" between "Hello" and "Jane" in sentence2.
//
//    Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.
//
//    Example 1:
//    Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
//    Output: true
//    Explanation: sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".
//
//    Example 2:
//    Input: sentence1 = "of", sentence2 = "A lot of words"
//    Output: false
//    Explanation: No single sentence can be inserted inside one of the sentences to make it equal to the other.
//
//    Example 3:
//    Input: sentence1 = "Eating right now", sentence2 = "Eating"
//    Output: true
//    Explanation: sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.
//
//    Constraints:
//    1 <= sentence1.length, sentence2.length <= 100
//    sentence1 and sentence2 consist of lowercase and uppercase English letters and spaces.
//    The words in sentence1 and sentence2 are separated by a single space.


//一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
//
//    如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
//
//    给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。
//
//    示例 1：
//    输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
//    输出：true
//    解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
//
//    示例 2：
//    输入：sentence1 = "of", sentence2 = "A lot of words"
//    输出：false
//    解释：没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
//
//    示例 3：
//    输入：sentence1 = "Eating right now", sentence2 = "Eating"
//    输出：true
//    解释：可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
//
//    示例 4：
//    输入：sentence1 = "Luky", sentence2 = "Lucccky"
//    输出：false
//
//    提示：
//    1 <= sentence1.length, sentence2.length <= 100
//    sentence1 和 sentence2 都只包含大小写英文字母和空格。
//    sentence1 和 sentence2 中的单词都只由单个空格隔开。


public class Q1813 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String sentence1 = cin.nextLine().strip();
        String sentence2 = cin.nextLine().strip();
        cin.close();
        System.out.println(areSentencesSimilar(sentence1, sentence2));
    }

    private static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0, j = 0;
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        while (j < words1.length - i && j < words2.length - i
            && words1[words1.length - j - 1].equals(words2[words2.length - j - 1])) {
            j++;
        }
        return i + j == Math.min(words1.length, words2.length);
    }
}
