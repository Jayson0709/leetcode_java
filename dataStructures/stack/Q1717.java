package dataStructures.stack;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a string s and two integers x and y. You can perform two types of operations any number of times.
//
//    Remove substring "ab" and gain x points.
//    For example, when removing "ab" from "cabxbae" it becomes "cxbae".
//    Remove substring "ba" and gain y points.
//    For example, when removing "ba" from "cabxbae" it becomes "cabxe".
//    Return the maximum points you can gain after applying the above operations on s.
//
//    Example 1:
//    Input: s = "cdbcbbaaabab", x = 4, y = 5
//    Output: 19
//    Explanation:
//    - Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
//    - Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
//    - Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
//    - Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
//    Total score = 5 + 4 + 5 + 5 = 19.
//    
//    Example 2:
//    Input: s = "aabbaaxybbaabb", x = 5, y = 4
//    Output: 20
//
//    Constraints:
//    1 <= s.length <= 10^5
//    1 <= x, y <= 10^4
//    s consists of lowercase English letters.



//给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
//
//    删除子字符串 "ab" 并得到 x 分。
//    比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
//    删除子字符串"ba" 并得到 y 分。
//    比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
//    请返回对 s 字符串执行上面操作若干次能得到的最大得分。
//
//    示例 1：
//    输入：s = "cdbcbbaaabab", x = 4, y = 5
//    输出：19
//    解释：
//    - 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
//    - 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
//    - 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
//    - 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
//    总得分为 5 + 4 + 5 + 5 = 19 。
//
//    示例 2：
//    输入：s = "aabbaaxybbaabb", x = 5, y = 4
//    输出：20
//
//    提示：
//    1 <= s.length <= 10^5
//    1 <= x, y <= 10^4
//    s 只包含小写英文字母。



public class Q1717 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        int x = cin.nextInt();
        int y = cin.nextInt();
        cin.close();
        System.out.println(maximumGain(s, x, y));
    }

    private static int maximumGain(String s, int x, int y) {
        char[] cs = s.toCharArray();
        if (x >= y) {
            return maximumGain(cs, x, y, 'a', 'b');
        }
        return maximumGain(cs, y, x, 'b', 'a');
    }

    private static int maximumGain(char[] cs, int max, int min, char s, char p) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= cs.length; i++) {
            char c = i < cs.length ? cs[i] : 0;
            if (c != 'a' && c != 'b') {
                ans += maximumGain(stack, min, s, p);
            } else {
                if (c == p && !stack.isEmpty() && stack.peek() == s) {
                    ans += max;
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        return ans;
    }

    private static int maximumGain(Stack<Character> stack, int min, char s, char p) {
        int ans = 0;
        Stack<Character> tmp = new Stack<>();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == p && !tmp.isEmpty() && tmp.peek() == s) {
                ans += min;
                tmp.pop();
            } else {
                tmp.add(c);
            }
        }
        return ans;
    }
}
