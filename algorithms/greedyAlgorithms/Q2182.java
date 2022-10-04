package algorithms.greedyAlgorithms;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.
//
//    Return the lexicographically largest repeatLimitedString possible.
//
//    A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.
//
//    Example 1:
//    Input: s = "cczazcc", repeatLimit = 3
//    Output: "zzcccac"
//    Explanation: We use all the characters from s to construct the repeatLimitedString "zzcccac".
//    The letter 'a' appears at most 1 time in a row.
//    The letter 'c' appears at most 3 times in a row.
//    The letter 'z' appears at most 2 times in a row.
//    Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
//    The string is the lexicographically largest repeatLimitedString possible, so we return "zzcccac".
//    Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so it is not a valid repeatLimitedString.
//
//    Example 2:
//    Input: s = "aababab", repeatLimit = 2
//    Output: "bbabaa"
//    Explanation: We use only some characters from s to construct the repeatLimitedString "bbabaa".
//    The letter 'a' appears at most 2 times in a row.
//    The letter 'b' appears at most 2 times in a row.
//    Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
//    The string is the lexicographically largest repeatLimitedString possible so we return "bbabaa".
//    Note that the string "bbabaaa" is lexicographically larger but the letter 'a' appears more than 2 times in a row, so it is not a valid repeatLimitedString.
//
//    Constraints:
//    1 <= repeatLimit <= s.length <= 10^5
//    s consists of lowercase English letters.



//给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
//
//    返回 字典序最大的 repeatLimitedString 。
//
//    如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，则认为字符串 a 比字符串 b 字典序更大 。如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。
//
//    示例 1：
//    输入：s = "cczazcc", repeatLimit = 3
//    输出："zzcccac"
//    解释：使用 s 中的所有字符来构造 repeatLimitedString "zzcccac"。
//    字母 'a' 连续出现至多 1 次。
//    字母 'c' 连续出现至多 3 次。
//    字母 'z' 连续出现至多 2 次。
//    因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
//    该字符串是字典序最大的 repeatLimitedString ，所以返回 "zzcccac" 。
//    注意，尽管 "zzcccca" 字典序更大，但字母 'c' 连续出现超过 3 次，所以它不是一个有效的 repeatLimitedString 。
//
//    示例 2：
//    输入：s = "aababab", repeatLimit = 2
//    输出："bbabaa"
//    解释：
//    使用 s 中的一些字符来构造 repeatLimitedString "bbabaa"。
//    字母 'a' 连续出现至多 2 次。
//    字母 'b' 连续出现至多 2 次。
//    因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
//    该字符串是字典序最大的 repeatLimitedString ，所以返回 "bbabaa" 。
//    注意，尽管 "bbabaaa" 字典序更大，但字母 'a' 连续出现超过 2 次，所以它不是一个有效的 repeatLimitedString 。
//
//    提示：
//    1 <= repeatLimit <= s.length <= 10^5
//    s 由小写英文字母组成



public class Q2182 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        int repeatLimit = cin.nextInt();
        cin.close();
        System.out.println(repeatLimitedString(s, repeatLimit));
    }

    // Method: greedy algorithm + two pointers
    private static String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int quick = 25;
        int currCount = 0;
        StringBuilder res = new StringBuilder();
        while (true) {
            // Find the largest character every time.
            while (quick >= 0 && count[quick] == 0) {
                quick--;
            }
            // No more character is available.
            if (quick == -1) {
                break;
            }
            while (count[quick] > 0 && currCount < repeatLimit) {
                res.append((char) (quick + 'a'));
                currCount++;
                count[quick]--;
            }
            if (count[quick] != 0 && currCount == repeatLimit) {
                // Find the second-largest character, concerning the current character.
                int slow = quick - 1;
                while (slow >= 0 && count[slow] == 0) {
                    slow--;
                }
                // No more character is available.
                if (slow == -1) {
                    break;
                }
                res.append((char) (slow + 'a'));
                count[slow]--;
            }
            currCount = 0;
        }
        return res.toString();
    }
}
