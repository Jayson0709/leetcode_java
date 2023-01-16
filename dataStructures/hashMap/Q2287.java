package dataStructures.hashMap;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//You are given two 0-indexed strings s and target. You can take some letters from s and rearrange them to form new strings.
//
//    Return the maximum number of copies of target that can be formed by taking letters from s and rearranging them.
//
//    Example 1:
//    Input: s = "ilovecodingonleetcode", target = "code"
//    Output: 2
//    Explanation:
//    For the first copy of "code", take the letters at indices 4, 5, 6, and 7.
//    For the second copy of "code", take the letters at indices 17, 18, 19, and 20.
//    The strings that are formed are "ecod" and "code" which can both be rearranged into "code".
//    We can make at most two copies of "code", so we return 2.
//
//    Example 2:
//    Input: s = "abcba", target = "abc"
//    Output: 1
//    Explanation:
//    We can make one copy of "abc" by taking the letters at indices 0, 1, and 2.
//    We can make at most one copy of "abc", so we return 1.
//    Note that while there is an extra 'a' and 'b' at indices 3 and 4, we cannot reuse the letter 'c' at index 2, so we cannot make a second copy of "abc".
//
//    Example 3:
//    Input: s = "abbaccaddaeea", target = "aaaaa"
//    Output: 1
//    Explanation:
//    We can make one copy of "aaaaa" by taking the letters at indices 0, 3, 6, 9, and 12.
//    We can make at most one copy of "aaaaa", so we return 1.
//
//    Constraints:
//    1 <= s.length <= 100
//    1 <= target.length <= 10
//    s and target consist of lowercase English letters.


//给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
//
//    从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
//
//    示例 1：
//    输入：s = "ilovecodingonleetcode", target = "code"
//    输出：2
//    解释：
//    对于 "code" 的第 1 个副本，选取下标为 4 、5 、6 和 7 的字符。
//    对于 "code" 的第 2 个副本，选取下标为 17 、18 、19 和 20 的字符。
//    形成的字符串分别是 "ecod" 和 "code" ，都可以重排为 "code" 。
//    可以形成最多 2 个 "code" 的副本，所以返回 2 。
//
//    示例 2：
//    输入：s = "abcba", target = "abc"
//    输出：1
//    解释：
//    选取下标为 0 、1 和 2 的字符，可以形成 "abc" 的 1 个副本。
//    可以形成最多 1 个 "abc" 的副本，所以返回 1 。
//    注意，尽管下标 3 和 4 分别有额外的 'a' 和 'b' ，但不能重用下标 2 处的 'c' ，所以无法形成 "abc" 的第 2 个副本。
//
//    示例 3：
//    输入：s = "abbaccaddaeea", target = "aaaaa"
//    输出：1
//    解释：
//    选取下标为 0 、3 、6 、9 和 12 的字符，可以形成 "aaaaa" 的 1 个副本。
//    可以形成最多 1 个 "aaaaa" 的副本，所以返回 1 。
//
//    提示：
//    1 <= s.length <= 100
//    1 <= target.length <= 10
//    s 和 target 由小写英文字母组成


public class Q2287 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        String target = cin.nextLine().strip();
        cin.close();
        System.out.println(rearrangeCharacters(s, target));
    }

    private static int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sCounts = new HashMap<>();
        Map<Character, Integer> targetCounts = new HashMap<>();
        int n = s.length(), m = target.length();
        for (int i = 0; i < m; i++) {
            char c = target.charAt(i);
            targetCounts.put(c, targetCounts.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (targetCounts.containsKey(c)) {
                sCounts.put(c, sCounts.getOrDefault(c, 0) + 1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetCounts.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            int totalCount = sCounts.getOrDefault(c, 0);
            ans = Math.min(ans, totalCount / count);
            if (ans == 0) {
                return 0;
            }
        }
        return ans;
    }
}
