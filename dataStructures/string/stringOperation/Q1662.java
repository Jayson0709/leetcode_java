package dataStructures.string.stringOperation;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
//
//    A string is represented by an array if the array elements concatenated in order forms the string.
//
//    Example 1:
//    Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
//    Output: true
//    Explanation:
//    word1 represents string "ab" + "c" -> "abc"
//    word2 represents string "a" + "bc" -> "abc"
//    The strings are the same, so return true.
//
//    Example 2:
//    Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
//    Output: false
//
//    Example 3:
//    Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//    Output: true
//
//    Constraints:
//    1 <= word1.length, word2.length <= 103
//    1 <= word1[i].length, word2[i].length <= 103
//    1 <= sum(word1[i].length), sum(word2[i].length) <= 103
//    word1[i] and word2[i] consist of lowercase letters.



//给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
//
//    数组表示的字符串是由数组中的所有元素 按顺序 连接形成的字符串。
//
//    示例 1：
//    输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
//    输出：true
//    解释：
//    word1 表示的字符串为 "ab" + "c" -> "abc"
//    word2 表示的字符串为 "a" + "bc" -> "abc"
//    两个字符串相同，返回 true
//
//    示例 2：
//    输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
//    输出：false
//
//    示例 3：
//    输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//    输出：true
//
//    提示：
//    1 <= word1.length, word2.length <= 103
//    1 <= word1[i].length, word2[i].length <= 103
//    1 <= sum(word1[i].length), sum(word2[i].length) <= 103
//    word1[i] 和 word2[i] 由小写字母组成


public class Q1662 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] word1 = cin.nextLine().strip().split(" ");
        String[] word2 = cin.nextLine().strip().split(" ");
        cin.close();
        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    // Version 1
    private static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder strBuilder1 = new StringBuilder();
        StringBuilder strBuilder2 = new StringBuilder();
        for (String str : word1) {
            strBuilder1.append(str);
        }
        for (String str : word2) {
            strBuilder2.append(str);
        }
        return strBuilder1.toString().equals(strBuilder2.toString());
    }

    // Version 2
//    private static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//        return join(word1).equals(join(word2));
//    }
//
//    public static String join(String[] words) {
//        StringBuilder ret = new StringBuilder();
//        for (String s : words) {
//            ret.append(s);
//        }
//        return ret.toString();
//    }

    // Version 3 iterate
//    private static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//        int p1 = 0, p2 = 0, i = 0, j = 0;
//        while (p1 < word1.length && p2 < word2.length) {
//            if (word1[p1].charAt(i) != word2[p2].charAt(j)) {
//                return false;
//            }
//            i++;
//            if (i == word1[p1].length()) {
//                p1++;
//                i = 0;
//            }
//            j++;
//            if (j == word2[p2].length()) {
//                p2++;
//                j = 0;
//            }
//        }
//        return p1 == word1.length && p2 == word2.length;
//    }
}
