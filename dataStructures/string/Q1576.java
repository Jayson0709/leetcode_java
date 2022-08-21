package dataStructures.string;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a string s containing only lowercase English letters and the '?' character, convert all the '?' characters into lowercase letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.
//
//    It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.
//
//    Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints.
//
//    Example 1:
//    Input: s = "?zs"
//    Output: "azs"
//    Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".
//    
//    Example 2:
//    Input: s = "ubv?w"
//    Output: "ubvaw"
//    Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".
//
//    Constraints:
//    1 <= s.length <= 100
//    s consist of lowercase English letters and '?'.



//给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
//
//    注意：你 不能 修改非 '?' 字符。
//
//    题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
//
//    在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
//
//    示例 1：
//    输入：s = "?zs"
//    输出："azs"
//    解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
//
//    示例 2：
//    输入：s = "ubv?w"
//    输出："ubvaw"
//    解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
//
//    提示：
//    1 <= s.length<= 100
//    s 仅包含小写英文字母和 '?' 字符



public class Q1576 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine();
        cin.close();
        String result = modifyString(s);
        System.out.println(result);
    }

    private static String modifyString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '?') {
                for (char c = 0; c <= 3; c++) {
                    boolean ok = i - 1 < 0 || chars[i - 1] != c + 'a';
                    if (i + 1 < n && chars[i + 1] == c + 'a') {
                        ok = false;
                    }
                    if (ok) {
                        chars[i] = (char)(c + 'a');
                    }
                }
            }
        }
        return String.valueOf(chars);
    }
}
