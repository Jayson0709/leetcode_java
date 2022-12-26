package algorithms.greedyAlgorithms;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given two strings word1 and word2. You want to construct a string merge in the following way: while either word1 or word2 are non-empty, choose one of the following options:
//
//    If word1 is non-empty, append the first character in word1 to merge and delete it from word1.
//    For example, if word1 = "abc" and merge = "dv", then after choosing this operation, word1 = "bc" and merge = "dva".
//    If word2 is non-empty, append the first character in word2 to merge and delete it from word2.
//    For example, if word2 = "abc" and merge = "", then after choosing this operation, word2 = "bc" and merge = "a".
//    Return the lexicographically largest merge you can construct.
//
//    A string a is lexicographically larger than a string b (of the same length) if in the first position where a and b differ, a has a character strictly larger than the corresponding character in b. For example, "abcd" is lexicographically larger than "abcc" because the first position they differ is at the fourth character, and d is greater than c.
//
//    Example 1:
//    Input: word1 = "cabaa", word2 = "bcaaa"
//    Output: "cbcabaaaaa"
//    Explanation: One way to get the lexicographically largest merge is:
//    - Take from word1: merge = "c", word1 = "abaa", word2 = "bcaaa"
//    - Take from word2: merge = "cb", word1 = "abaa", word2 = "caaa"
//    - Take from word2: merge = "cbc", word1 = "abaa", word2 = "aaa"
//    - Take from word1: merge = "cbca", word1 = "baa", word2 = "aaa"
//    - Take from word1: merge = "cbcab", word1 = "aa", word2 = "aaa"
//    - Append the remaining 5 a's from word1 and word2 at the end of merge.
//
//    Example 2:
//    Input: word1 = "abcabc", word2 = "abdcaba"
//    Output: "abdcabcabcaba"
//
//    Constraints:
//    1 <= word1.length, word2.length <= 3000
//    word1 and word2 consist only of lowercase English letters.


//给你两个字符串 word1 和 word2 。你需要按下述方式构造一个新字符串 merge ：如果 word1 或 word2 非空，选择 下面选项之一 继续操作：
//
//    如果 word1 非空，将 word1 中的第一个字符附加到 merge 的末尾，并将其从 word1 中移除。
//    例如，word1 = "abc" 且 merge = "dv" ，在执行此选项操作之后，word1 = "bc" ，同时 merge = "dva" 。
//    如果 word2 非空，将 word2 中的第一个字符附加到 merge 的末尾，并将其从 word2 中移除。
//    例如，word2 = "abc" 且 merge = "" ，在执行此选项操作之后，word2 = "bc" ，同时 merge = "a" 。
//    返回你可以构造的字典序 最大 的合并字符串 merge 。
//
//    长度相同的两个字符串 a 和 b 比较字典序大小，如果在 a 和 b 出现不同的第一个位置，a 中字符在字母表中的出现顺序位于 b 中相应字符之后，就认为字符串 a 按字典序比字符串 b 更大。例如，"abcd" 按字典序比 "abcc" 更大，因为两个字符串出现不同的第一个位置是第四个字符，而 d 在字母表中的出现顺序位于 c 之后。
//
//    示例 1：
//    输入：word1 = "cabaa", word2 = "bcaaa"
//    输出："cbcabaaaaa"
//    解释：构造字典序最大的合并字符串，可行的一种方法如下所示：
//    - 从 word1 中取第一个字符：merge = "c"，word1 = "abaa"，word2 = "bcaaa"
//    - 从 word2 中取第一个字符：merge = "cb"，word1 = "abaa"，word2 = "caaa"
//    - 从 word2 中取第一个字符：merge = "cbc"，word1 = "abaa"，word2 = "aaa"
//    - 从 word1 中取第一个字符：merge = "cbca"，word1 = "baa"，word2 = "aaa"
//    - 从 word1 中取第一个字符：merge = "cbcab"，word1 = "aa"，word2 = "aaa"
//    - 将 word1 和 word2 中剩下的 5 个 a 附加到 merge 的末尾。
//
//    示例 2：
//    输入：word1 = "abcabc", word2 = "abdcaba"
//    输出："abdcabcabcaba"
//
//    提示：
//    1 <= word1.length, word2.length <= 3000
//    word1 和 word2 仅由小写英文组成


public class Q1754 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String word1 = cin.nextLine().strip();
        String word2 = cin.nextLine().strip();
        cin.close();
        System.out.println(largestMerge(word1, word2));
    }

    private static String largestMerge(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                merge.append(word1.charAt(i));
                i++;
            } else {
                merge.append(word2.charAt(j));
                j++;
            }
        }
        return merge.toString();
    }
}
