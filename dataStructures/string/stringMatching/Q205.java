package dataStructures.string.stringMatching;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//Given two strings s and t, determine if they are isomorphic.
//
//    Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//    
//    Example 1:
//    Input: s = "egg", t = "add"
//    Output: true
//    
//    Example 2:
//    Input: s = "foo", t = "bar"
//    Output: false
//    
//    Example 3:
//    Input: s = "paper", t = "title"
//    Output: true
//    
//    Constraints:
//    1 <= s.length <= 5 * 10^4
//    t.length == s.length
//    s and t consist of any valid ascii character.



//给定两个字符串 s 和 t ，判断它们是否是同构的。
//
//    如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
//    每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//
//    示例 1:
//    输入：s = "egg", t = "add"
//    输出：true
//
//    示例 2：
//    输入：s = "foo", t = "bar"
//    输出：false
//
//    示例 3：
//    输入：s = "paper", t = "title"
//    输出：true
//
//    提示：
//    1 <= s.length <= 5 * 10^4
//    t.length == s.length
//    s 和 t 由任意有效的 ASCII 字符组成



public class Q205 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine();
        String t = cin.nextLine();
        cin.close();
        System.out.println(isIsomorphic(s, t));
    }

    private static boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
