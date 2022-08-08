package algorithms.divideAndConquer;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Special binary strings are binary strings with the following two properties:
//
//    The number of 0's is equal to the number of 1's.
//    Every prefix of the binary string has at least as many 1's as 0's.
//    You are given a special binary string s.
//
//    A move consists of choosing two consecutive, non-empty, special substrings of s, and swapping them. Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.
//
//    Return lexicographically the largest resulting string possible after applying the mentioned operations on the string.
//
//    Example 1:
//    Input: s = "11011000"
//    Output: "11100100"
//    Explanation: The strings "10" [occurring at s[1]] and "1100" [at s[3]] are swapped.
//    This is lexicographically the largest string possible after some number of swaps.
//
//    Example 2:
//    Input: s = "10"
//    Output: "10"
//
//    Constraints:
//    1 <= s.length <= 50
//    s[i] is either '0' or '1'.
//    s is a special binary string.



//特殊的二进制序列是具有以下两个性质的二进制序列：
//
//    0 的数量与 1 的数量相等。
//    二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
//    给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
//
//    在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
//
//    示例 1:
//    输入: S = "11011000"
//    输出: "11100100"
//    解释:
//    将子串 "10" （在S[1]出现） 和 "1100" （在S[3]出现）进行交换。
//    这是在进行若干次操作后按字典序排列最大的结果。
//
//    说明:
//    S 的长度不超过 50。
//    S 保证为一个满足上述定义的特殊 的二进制序列。



public class Q761 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(makeLargestSpecial(s));
    }

    private static String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int cnt = 0, left = 0;
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        subs.sort(Comparator.reverseOrder());
        StringBuilder ans = new StringBuilder();
        for (String sub : subs) {
            ans.append(sub);
        }
        return ans.toString();
    }
}
