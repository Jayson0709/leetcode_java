package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:
//
//    If the character read is a letter, that letter is written onto the tape.
//    If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
//    Given an integer k, return the kth letter (1-indexed) in the decoded string.
//
//    Example 1:
//    Input: s = "leet2code3", k = 10
//    Output: "o"
//    Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode".
//    The 10th letter in the string is "o".
//
//    Example 2:
//    Input: s = "ha22", k = 5
//    Output: "h"
//    Explanation: The decoded string is "hahahaha".
//    The 5th letter is "h".
//
//    Example 3:
//    Input: s = "a2345678999999999999999", k = 1
//    Output: "a"
//    Explanation: The decoded string is "a" repeated 8301530446056247680 times.
//    The 1st letter is "a".
//
//    Constraints:
//    2 <= s.length <= 100
//    s consists of lowercase English letters and digits 2 through 9.
//    s starts with a letter.
//    1 <= k <= 10^9
//    It is guaranteed that k is less than or equal to the length of the decoded string.
//    The decoded string is guaranteed to have less than 2^63 letters.


//给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：
//
//    如果所读的字符是字母，则将该字母写在磁带上。
//    如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
//    现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
//
//    示例 1：
//    输入：S = "leet2code3", K = 10
//    输出："o"
//    解释：
//    解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
//    字符串中的第 10 个字母是 "o"。
//
//    示例 2：
//    输入：S = "ha22", K = 5
//    输出："h"
//    解释：
//    解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
//
//    示例 3：
//    输入：S = "a2345678999999999999999", K = 1
//    输出："a"
//    解释：
//    解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
//
//    提示：
//    2 <= S.length <= 100
//    S 只包含小写字母与数字 2 到 9 。
//    S 以字母开头。
//    1 <= K <= 10^9
//    题目保证 K 小于或等于解码字符串的长度。
//    解码后的字符串保证少于 2^63 个字母。


public class Q880 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        int k = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        System.out.println(decodeAtIndex(s, k));
    }

    // Method 1: brute force (failed)
//    private static String decodeAtIndex(String s, int k) {
//        StringBuilder decodedString = new StringBuilder();
//        StringBuilder temp;
//        for (char c : s.toCharArray()) {
//            if (Character.isDigit(c)) {
//                temp = decodedString;
//                decodedString.append(String.valueOf(temp).repeat(Math.max(0, c - '0' - 1)));
//            } else {
//                decodedString.append(c);
//            }
//        }
//        System.out.println(decodedString);
//        return String.valueOf(decodedString.charAt(k - 1));
//    }

    // Method 2: working backwards
    private static String decodeAtIndex(String s, int k) {
        long size = 0;
        int N = s.length();

        // Find size = length of the decoded string
        for (int i = 0; i < N; ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size++;
        }

        for (int i = N-1; i >= 0; --i) {
            char c = s.charAt(i);
            k %= size;
            if (k == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }
        return "";
    }
}
