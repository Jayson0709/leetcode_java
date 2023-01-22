package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


//Given two strings first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
//
//    Return an array of all the words third for each occurrence of "first second third".
//
//    Example 1:
//    Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
//    Output: ["girl","student"]
//
//    Example 2:
//    Input: text = "we will we will rock you", first = "we", second = "will"
//    Output: ["we","rock"]
//
//    Constraints:
//    1 <= text.length <= 1000
//    text consists of lowercase English letters and spaces.
//    All the words in text a separated by a single space.
//    1 <= first.length, second.length <= 10
//    first and second consist of lowercase English letters.


//给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
//
//    对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
//
//    示例 1：
//    输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
//    输出：["girl","student"]
//
//    示例 2：
//    输入：text = "we will we will rock you", first = "we", second = "will"
//    输出：["we","rock"]
//
//    提示：
//    1 <= text.length <= 1000
//    text 由小写英文字母和空格组成
//    text 中的所有单词之间都由 单个空格字符 分隔
//    1 <= first.length, second.length <= 10
//    first 和 second 由小写英文字母组成


public class Q1078 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String text = cin.nextLine().strip();
        String first = cin.nextLine().strip();
        String second = cin.nextLine().strip();
        cin.close();
        System.out.println(Arrays.toString(findOccurrences(text, first, second)));
    }

    private static String[] findOccurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> wordList = new ArrayList<>();
        for (int i = 2; i < words.length; i++) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second)) {
                wordList.add(words[i]);
            }
        }
        int size = wordList.size();
        String[] res = new String[size];
        for (int i = 0; i < size; i++) {
            res[i] = wordList.get(i);
        }
        return res;
    }
}
