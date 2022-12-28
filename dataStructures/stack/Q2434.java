package dataStructures.stack;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


//You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:
//
//    Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
//    Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
//    Return the lexicographically smallest string that can be written on the paper.
//
//    Example 1:
//    Input: s = "zza"
//    Output: "azz"
//    Explanation: Let p denote the written string.
//    Initially p="", s="zza", t="".
//    Perform first operation three times p="", s="", t="zza".
//    Perform second operation three times p="azz", s="", t="".
//
//    Example 2:
//    Input: s = "bac"
//    Output: "abc"
//    Explanation: Let p denote the written string.
//    Perform first operation twice p="", s="c", t="ba".
//    Perform second operation twice p="ab", s="c", t="".
//    Perform first operation p="ab", s="", t="c".
//    Perform second operation p="abc", s="", t="".
//
//    Example 3:
//    Input: s = "bdda"
//    Output: "addb"
//    Explanation: Let p denote the written string.
//    Initially p="", s="bdda", t="".
//    Perform first operation four times p="", s="", t="bdda".
//    Perform second operation four times p="addb", s="", t="".
//
//    Constraints:
//    1 <= s.length <= 10^5
//    s consists of only English lowercase letters.


//给你一个字符串 s 和一个机器人，机器人当前有一个空字符串 t 。执行以下操作之一，直到 s 和 t 都变成空字符串：
//
//    删除字符串 s 的 第一个 字符，并将该字符给机器人。机器人把这个字符添加到 t 的尾部。
//    删除字符串 t 的 最后一个 字符，并将该字符给机器人。机器人将该字符写到纸上。
//    请你返回纸上能写出的字典序最小的字符串。
//
//    示例 1：
//    输入：s = "zza"
//    输出："azz"
//    解释：用 p 表示写出来的字符串。
//    一开始，p="" ，s="zza" ，t="" 。
//    执行第一个操作三次，得到 p="" ，s="" ，t="zza" 。
//    执行第二个操作三次，得到 p="azz" ，s="" ，t="" 。
//
//    示例 2：
//    输入：s = "bac"
//    输出："abc"
//    解释：用 p 表示写出来的字符串。
//    执行第一个操作两次，得到 p="" ，s="c" ，t="ba" 。
//    执行第二个操作两次，得到 p="ab" ，s="c" ，t="" 。
//    执行第一个操作，得到 p="ab" ，s="" ，t="c" 。
//    执行第二个操作，得到 p="abc" ，s="" ，t="" 。
//
//    示例 3：
//    输入：s = "bdda"
//    输出："addb"
//    解释：用 p 表示写出来的字符串。
//    一开始，p="" ，s="bdda" ，t="" 。
//    执行第一个操作四次，得到 p="" ，s="" ，t="bdda" 。
//    执行第二个操作四次，得到 p="addb" ，s="" ，t="" 。
//
//    提示：
//    1 <= s.length <= 10^5
//    s 只包含小写英文字母。


public class Q2434 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(robotWithString(s));
    }

    private static String robotWithString(String s) {
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        int min = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            cnt[c - 'a']--;
            while (min < 25 && cnt[min] == 0) {
                min++;
            }
            stack.push(c);
            while (!stack.isEmpty() && stack.peek() - 'a' <= min) {
                ans.append(stack.poll());
            }
        }
        return ans.toString();
    }
}
