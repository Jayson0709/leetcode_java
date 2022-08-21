package dataStructures.string;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a string s consisting of words and spaces, return the length of the last word in the string.
//
//    A word is a maximal substring consisting of non-space characters only.
//
//    Example 1:
//    Input: s = "Hello World"
//    Output: 5
//    Explanation: The last word is "World" with length 5.
//
//    Example 2:
//    Input: s = "   fly me   to   the moon  "
//    Output: 4
//    Explanation: The last word is "moon" with length 4.
//
//    Example 3:
//    Input: s = "luffy is still joyboy"
//    Output: 6
//    Explanation: The last word is "joyboy" with length 6.
//
//    Constraints:
//    1 <= s.length <= 10^4
//    s consists of only English letters and spaces ' '.
//    There will be at least one word in s.



//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//
//    单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
//
//    示例 1：
//    输入：s = "Hello World"
//    输出：5
//    解释：最后一个单词是“World”，长度为5。
//
//    示例 2：
//    输入：s = "   fly me   to   the moon  "
//    输出：4
//    解释：最后一个单词是“moon”，长度为4。
//
//    示例 3：
//    输入：s = "luffy is still joyboy"
//    输出：6
//    解释：最后一个单词是长度为6的“joyboy”。
//
//    提示：
//    1 <= s.length <= 10^4
//    s 仅有英文字母和空格 ' ' 组成
//    s 中至少存在一个单词



public class Q58 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine();
        cin.close();
        System.out.println(lengthOfLastWord(s));
    }

    private static int lengthOfLastWord(String s) {
        s = s.strip();
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
