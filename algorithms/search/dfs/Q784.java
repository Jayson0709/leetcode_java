package algorithms.search.dfs;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
//
//    Return a list of all possible strings we could create. Return the output in any order.
//
//    Example 1:
//    Input: s = "a1b2"
//    Output: ["a1b2","a1B2","A1b2","A1B2"]
//
//    Example 2:
//    Input: s = "3z4"
//    Output: ["3z4","3Z4"]
//
//    Constraints:
//    1 <= s.length <= 12
//    s consists of lowercase English letters, uppercase English letters, and digits.



//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
//
//    返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
//
//    示例 1：
//    输入：s = "a1b2"
//    输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//    示例 2:
//    输入: s = "3z4"
//    输出: ["3z4","3Z4"]
//
//    提示:
//    1 <= s.length <= 12
//    s 由小写英文字母、大写英文字母和数字组成


public class Q784 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(letterCasePermutation(s));
    }

    private static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        Queue<StringBuilder> queue = new ArrayDeque<>();
        queue.offer(new StringBuilder());
        while (!queue.isEmpty()) {
            StringBuilder curr = queue.peek();
            if (curr.length() == s.length()) {
                ans.add(curr.toString());
                queue.poll();
            } else {
                int pos = curr.length();
                if (Character.isLetter(s.charAt(pos))) {
                    StringBuilder next = new StringBuilder(curr);
                    next.append((char) (s.charAt(pos) ^ 32));
                    queue.offer(next);
                }
                curr.append(s.charAt(pos));
            }
        }
        return ans;
    }
}
