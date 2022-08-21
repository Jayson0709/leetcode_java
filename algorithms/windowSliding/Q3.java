package algorithms.windowSliding;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given a dataStructures.string s, find the length of the longest substring without repeating characters.
//
//    Example 1:
//    Input: s = "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.
//
//    Example 2:
//    Input: s = "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.
//
//    Example 3:
//    Input: s = "pwwkew"
//    Output: 3
//    Explanation: The answer is "wke", with the length of 3.
//    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//    Constraints:
//    0 <= s.length <= 5 * 104
//    s consists of English letters, digits, symbols and spaces.


// 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。

// 示例1:
// 输入: s = "abcabcbb"
// 输出: 3 
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
// 示例 2:
// 输入: s = "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
// 示例 3:
// 输入: s = "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。

// 提示：
// 0 <= s.length <= 5 * 104
// s由英文字母、数字、符号和空格组成


class Q3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> charHashMap = new HashMap<>();
        int result = 0;
        int leftIndex = 0;
        for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            if (charHashMap.containsKey(s.charAt(rightIndex))) {
                leftIndex = Math.max(leftIndex, charHashMap.get(s.charAt(rightIndex)) + 1);
            }
            charHashMap.put(s.charAt(rightIndex), rightIndex);
            result = Math.max(result, rightIndex - leftIndex + 1);
        }
        return result;
    }
}