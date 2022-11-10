package dataStructures.hashSet;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


//You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
//
//    Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
//
//    Return true if a and b are alike. Otherwise, return false.
//
//    Example 1:
//    Input: s = "book"
//    Output: true
//    Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
//
//    Example 2:
//    Input: s = "textbook"
//    Output: false
//    Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
//    Notice that the vowel o is counted twice.
//
//    Constraints:
//    2 <= s.length <= 1000
//    s.length is even.
//    s consists of uppercase and lowercase letters.


//给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
//
//    两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
//
//    如果 a 和 b 相似，返回 true ；否则，返回 false 。
//
//    示例 1：
//    输入：s = "book"
//    输出：true
//    解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
//
//    示例 2：
//    输入：s = "textbook"
//    输出：false
//    解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
//    注意，元音 o 在 b 中出现两次，记为 2 个。
//
//    提示：
//    2 <= s.length <= 1000
//    s.length 是偶数
//    s 由 大写和小写 字母组成

public class Q1704 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(halveAreAlike(s));
    }

    private static boolean halveAreAlike(String s) {
        Set<Character> hSet = new HashSet<>();
        hSet.add('a');
        hSet.add('e');
        hSet.add('i');
        hSet.add('o');
        hSet.add('u');
        hSet.add('A');
        hSet.add('E');
        hSet.add('I');
        hSet.add('O');
        hSet.add('U');
        int n = s.length();
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2);
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n / 2; i++) {
            if (hSet.contains(a.charAt(i))) {
                count1++;
            }
            if (hSet.contains(b.charAt(i))) {
                count2++;
            }
        }
        return count1 == count2;
    }
}
