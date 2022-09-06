package dataStructures.hashMap;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Let's define a function countUniqueChars(s) that returns the number of unique characters on s.
//
//    For example, calling countUniqueChars(s) if s = "LEETCODE" then "L", "T", "C", "O", "D" are the unique characters since they appear only once in s, therefore countUniqueChars(s) = 5.
//    Given a string s, return the sum of countUniqueChars(t) where t is a substring of s. The test cases are generated such that the answer fits in a 32-bit integer.
//
//    Notice that some substrings can be repeated so in this case you have to count the repeated ones too.
//    
//    Example 1:
//    Input: s = "ABC"
//    Output: 10
//    Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
//    Every substring is composed with only unique letters.
//    Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
//    
//    Example 2:
//    Input: s = "ABA"
//    Output: 8
//    Explanation: The same as example 1, except countUniqueChars("ABA") = 1.
//    
//    Example 3:
//    Input: s = "LEETCODE"
//    Output: 92
//    
//    Constraints:
//    1 <= s.length <= 10^5
//    s consists of uppercase English letters only.



//我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
//
//    例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
//
//    本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
//
//    注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
//
//    示例 1：
//    输入: s = "ABC"
//    输出: 10
//    解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
//    其中，每一个子串都由独特字符构成。
//    所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
//
//    示例 2：
//    输入: s = "ABA"
//    输出: 8
//    解释: 除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
//
//    示例 3：
//    输入：s = "LEETCODE"
//    输出：92
//
//    提示：
//    1 <= s.length <= 10^5
//    s 只包含大写英文字符



public class Q828 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(uniqueLetterString(s));
    }

    // Method 1: transform into a math problem.
//    private static int uniqueLetterString(String s) {
//        char[] letters = s.toCharArray();
//        int n = letters.length, ans = 0;
//        int[] left = new int[n], right = new int[n];
//        int[] counts = new int[26];
//        Arrays.fill(counts, -1);
//        for (int i = 0; i < n; i++) {
//            int u = letters[i] - 'A';
//            left[i] = counts[u];
//            counts[u] = i;
//        }
//        Arrays.fill(counts, n);
//        for (int i = n - 1; i >= 0; i--) {
//            int u = letters[i] - 'A';
//            right[i] = counts[u];
//            counts[u] = i;
//        }
//        for (int i = 0; i < n; i++) {
//            ans += (i - left[i]) * (right[i] - i);
//        }
//        return ans;
//    }

    // Method 2: use HashMap
    private static int uniqueLetterString(String s) {
        Map<Character, List<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!indexes.containsKey(c)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(-1);
                indexes.put(c, temp);
            }
            indexes.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : indexes.entrySet()) {
            List<Integer> list = entry.getValue();
            list.add(s.length());
            for (int i = 1; i < list.size() - 1; i++) {
                res += (list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i));
            }
        }
        return res;
    }
}
