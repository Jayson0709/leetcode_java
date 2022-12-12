package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
//
//    For example, the beauty of "abaacc" is 3 - 1 = 2.
//    Given a string s, return the sum of beauty of all of its substrings.
//
//    Example 1:
//    Input: s = "aabcb"
//    Output: 5
//    Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
//
//    Example 2:
//    Input: s = "aabcbaa"
//    Output: 17
//
//    Constraints:
//    1 <= s.length <= 500
//    s consists of only lowercase English letters.



//一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
//
//    比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
//    给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
//
//    示例 1：
//    输入：s = "aabcb"
//    输出：5
//    解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
//
//    示例 2：
//    输入：s = "aabcbaa"
//    输出：17
//
//    提示：
//    1 <= s.length <= 500
//    s 只包含小写英文字母。


public class Q1781 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(beautySum(s));
    }

    private static int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';
                count[idx]++;
                maxFreq = Math.max(maxFreq, count[idx]);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (count[k] > 0) {
                        minFreq = Math.min(minFreq, count[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }
}
