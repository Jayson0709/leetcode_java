package algorithms.windowSliding;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given a string s of length n containing only four kinds of characters: 'Q', 'W', 'E', and 'R'.
//
//    A string is said to be balanced if each of its characters appears n / 4 times, where n is the length of the string.
//
//    Return the minimum length of the substring that can be replaced with any other string of the same length to make s balanced. If s is already balanced, return 0.
//
//    Example 1:
//    Input: s = "QWER"
//    Output: 0
//    Explanation: s is already balanced.
//
//    Example 2:
//    Input: s = "QQWE"
//    Output: 1
//    Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
//
//    Example 3:
//    Input: s = "QQQW"
//    Output: 2
//    Explanation: We can replace the first "QQ" to "ER".
//
//    Constraints:
//    n == s.length
//    4 <= n <= 10^5
//    n is a multiple of 4.
//    s contains only 'Q', 'W', 'E', and 'R'.


//有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
//
//    假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
//
//
//
//    给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
//
//    你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
//
//    请返回待替换子串的最小可能长度。
//
//    如果原字符串自身就是一个平衡字符串，则返回 0。
//
//    示例 1：
//    输入：s = "QWER"
//    输出：0
//    解释：s 已经是平衡的了。
//
//    示例 2：
//    输入：s = "QQWE"
//    输出：1
//    解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
//
//    示例 3：
//    输入：s = "QQQW"
//    输出：2
//    解释：我们可以把前面的 "QQ" 替换成 "ER"。
//
//    示例 4：
//    输入：s = "QQQQ"
//    输出：3
//    解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
//
//    提示：
//    1 <= s.length <= 10^5
//    s.length 是 4 的倍数
//    s 中只含有 'Q', 'W', 'E', 'R' 四种字符


public class Q1234 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(balancedString(s));
    }

    private static int balancedString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[idx(c)]++;
        }

        int partial = s.length() / 4;
        int res = s.length();

        if (check(cnt, partial)) {
            return 0;
        }
        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && !check(cnt, partial)) {
                cnt[idx(s.charAt(r))]--;
                r++;
            }
            if (!check(cnt, partial)) {
                break;
            }
            res = Math.min(res, r - l);
            cnt[idx(s.charAt(l))]++;
        }
        return res;
    }

    public static int idx(char c) {
        return c - 'A';
    }

    public static boolean check(int[] cnt, int partial) {
        return cnt[idx('Q')] <= partial && cnt[idx('W')] <= partial
            && cnt[idx('E')] <= partial && cnt[idx('R')] <= partial;
    }
}
