package string;
import java.util.*;
import java.nio.charset.*;

//Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
//
//    Find the leftmost occurrence of the substring part and remove it from s.
//    Return s after removing all occurrences of part.
//
//    A substring is a contiguous sequence of characters in a string.
//
//    Example 1:
//    Input: s = "daabcbaabcbc", part = "abc"
//    Output: "dab"
//    Explanation: The following operations are done:
//    - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
//    - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
//    - s = "dababc", remove "abc" starting at index 3, so s = "dab".
//    Now s has no occurrences of "abc".
//
//    Example 2:
//    Input: s = "axxxxyyyyb", part = "xy"
//    Output: "ab"
//    Explanation: The following operations are done:
//    - s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
//    - s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
//    - s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
//    - s = "axyb", remove "xy" starting at index 1 so s = "ab".
//    Now s has no occurrences of "xy".
//
//    Constraints:
//    1 <= s.length <= 1000
//    1 <= part.length <= 1000
//    s and part consists of lowercase English letters.


// 给你两个字符串s和part，请你对s反复执行以下操作直到 所有子字符串part都被删除：

// 找到 s中 最左边的子字符串 part，并将它从 s中删除。
// 请你返回从 s中删除所有 part子字符串以后得到的剩余字符串。

// 一个 子字符串是一个字符串中连续的字符序列。
//
// 示例 1：
// 输入：s = "daabcbaabcbc", part = "abc"
// 输出："dab"
// 解释：以下操作按顺序执行：
// - s = "daabcbaabcbc" ，删除下标从 2 开始的 "abc" ，得到 s = "dabaabcbc" 。
// - s = "dabaabcbc" ，删除下标从 4 开始的 "abc" ，得到 s = "dababc" 。
// - s = "dababc" ，删除下标从 3 开始的 "abc" ，得到 s = "dab" 。
// 此时 s 中不再含有子字符串 "abc" 。
//
// 示例 2：
// 输入：s = "axxxxyyyyb", part = "xy"
// 输出："ab"
// 解释：以下操作按顺序执行：
// - s = "axxxxyyyyb" ，删除下标从 4 开始的 "xy" ，得到 s = "axxxyyyb" 。
// - s = "axxxyyyb" ，删除下标从 3 开始的 "xy" ，得到 s = "axxyyb" 。
// - s = "axxyyb" ，删除下标从 2 开始的 "xy" ，得到 s = "axyb" 。
// - s = "axyb" ，删除下标从 1 开始的 "xy" ，得到 s = "ab" 。
// 此时 s 中不再含有子字符串 "xy" 。

// 提示：
// 1 <= s.length <= 1000
// 1 <= part.length <= 1000
// s和part只包小写英文字母。


public class Q1910 {
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String s = cin.nextLine().strip();
        String part = cin.nextLine().strip();
        cin.close();

        String result = removeOccurrences(s, part);
        System.out.println(result);
    }

    private static String removeOccurrences(String s, String part) {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(s);
        while (sBuilder.toString().contains(part)) {
            String tempString = sBuilder.toString();
            int index = tempString.indexOf(part);
            if (index != -1) {
                sBuilder.setLength(0);
                sBuilder.append(tempString, 0, index);
                sBuilder.append(tempString.substring(index + part.length()));
            }
        }
        return sBuilder.toString();
    }
}
