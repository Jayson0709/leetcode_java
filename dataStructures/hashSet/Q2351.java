package dataStructures.hashSet;

import java.nio.charset.StandardCharsets;
import java.util.*;

//Given a string s consisting of lowercase English letters, return the first letter to appear twice.
//
//    Note:
//    A letter 'a' appears twice before another letter 'b' if the second occurrence of 'a' is before the second occurrence of 'b'.
//    s will contain at least one letter that appears twice.
//
//    Example 1:
//    Input: s = "abccbaacz"
//    Output: "c"
//    Explanation:
//    The letter 'a' appears on the indexes 0, 5 and 6.
//    The letter 'b' appears on the indexes 1 and 4.
//    The letter 'c' appears on the indexes 2, 3 and 7.
//    The letter 'z' appears on the index 8.
//    The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second occurrence is the smallest.
//
//    Example 2:
//    Input: s = "abcdd"
//    Output: "d"
//    Explanation:
//    The only letter that appears twice is 'd' so we return 'd'.
//
//    Constraints:
//    2 <= s.length <= 100
//    s consists of lowercase English letters.
//    s has at least one repeated letter.


//给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
//
//    注意：
//
//    如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
//    s 包含至少一个出现两次的字母。
//
//    示例 1：
//    输入：s = "abccbaacz"
//    输出："c"
//    解释：
//    字母 'a' 在下标 0 、5 和 6 处出现。
//    字母 'b' 在下标 1 和 4 处出现。
//    字母 'c' 在下标 2 、3 和 7 处出现。
//    字母 'z' 在下标 8 处出现。
//    字母 'c' 是第一个出现两次的字母，因为在所有字母中，'c' 第二次出现的下标是最小的。
//
//    示例 2：
//    输入：s = "abcdd"
//    输出："d"
//    解释：
//    只有字母 'd' 出现两次，所以返回 'd' 。
//
//    提示：
//    2 <= s.length <= 100
//    s 由小写英文字母组成
//    s 包含至少一个重复字母


public class Q2351 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(repeatedCharacter(s));
    }

    private static char repeatedCharacter(String s) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!seen.add(ch)) {
                return ch;
            }
        }
        // impossible to reach cuz the input guarantees that there will be at least one character that occurs twice.
        return ' ';
    }
}
