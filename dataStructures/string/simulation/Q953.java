package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


//In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
//
//    Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
//    
//    Example 1:
//    Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//    Output: true
//    Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
//    
//    Example 2:
//    Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//    Output: false
//    Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
//
//    Example 3:
//    Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//    Output: false
//    Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
//
//    Constraints:
//    1 <= words.length <= 100
//    1 <= words[i].length <= 20
//    order.length == 26
//    All characters in words[i] and order are English lowercase letters.



//某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
//
//    给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
//
//    示例 1：
//    输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//    输出：true
//    解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
//
//    示例 2：
//    输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//    输出：false
//    解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
//
//    示例 3：
//    输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//    输出：false
//    解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
//
//    提示：
//    1 <= words.length <= 100
//    1 <= words[i].length <= 20
//    order.length == 26
//    在 words[i] 和 order 中的所有字符都是英文小写字母。



public class Q953 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] words = cin.nextLine().strip().split(" ");
        String order = cin.nextLine().strip();
        cin.close();
        System.out.println(isAlienSorted(words, order));
    }

    // Method 1: brute force
//    private static boolean isAlienSorted(String[] words, String order) {
//        if (words.length == 1) {
//            return true;
//        }
//        for (int i = 1; i < words.length; i++) {
//            char[] word1 = words[i - 1].toCharArray();
//            char[] word2 = words[i].toCharArray();
//            int idx = 0;
//            boolean flag = false;
//            while (idx < word1.length && idx < word2.length) {
//                if (order.indexOf(word1[idx]) > order.indexOf(word2[idx])) {
//                    return false;
//                } else if (order.indexOf(word1[idx]) < order.indexOf(word2[idx])) {
//                    flag = true;
//                    break;
//                } else {
//                    idx++;
//                }
//            }
//            if (!flag) {
//                if (word1.length > word2.length) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    // Method 2: self-defined sort
    private static boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < 26; i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        String[] clone = words.clone();
        Arrays.sort(clone, (a, b)->{
            int n = a.length();
            int m = b.length();
            int i = 0;
            int j = 0;
            while (i < n && j < m) {
                int idx1 = a.charAt(i) - 'a';
                int idx2 = b.charAt(j) - 'a';
                if (idx1 != idx2) {
                    return index[idx1] - index[idx2];
                }
                i++;
                j++;
            }
            if (i < n) {
                return 1;
            }
            if (j < m) {
                return -1;
            }
            return 0;
        });
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (!clone[i].equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}
