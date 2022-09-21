package algorithms.search.dfs;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Strings s1 and s2 are k-similar (for some non-negative integer k) if we can swap the positions of two letters in s1 exactly k times so that the resulting string equals s2.
//
//    Given two anagrams s1 and s2, return the smallest k for which s1 and s2 are k-similar.
//
//    Example 1:
//    Input: s1 = "ab", s2 = "ba"
//    Output: 1
//
//    Example 2:
//    Input: s1 = "abc", s2 = "bca"
//    Output: 2
//
//    Constraints:
//    1 <= s1.length <= 20
//    s2.length == s1.length
//    s1 and s2 contain only lowercase letters from the set {'a', 'b', 'c', 'd', 'e', 'f'}.
//    s2 is an anagram of s1.



//对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。
//
//    给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。
//
//    示例 1：
//    输入：s1 = "ab", s2 = "ba"
//    输出：1
//
//    示例 2：
//    输入：s1 = "abc", s2 = "bca"
//    输出：2
//
//    提示：
//    1 <= s1.length <= 20
//    s2.length == s1.length
//    s1 和 s2  只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母
//    s2 是 s1 的一个字母异位词



public class Q854 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s1 = cin.nextLine().strip();
        String s2 = cin.nextLine().strip();
        cin.close();
        System.out.println(kSimilarity(s1, s2));
    }

    static int ans;
    private static int kSimilarity(String s1, String s2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                str1.append(s1.charAt(i));
                str2.append(s2.charAt(i));
            }
        }
        if (str1.length() == 0) {
            return 0;
        }
        ans = str1.length() - 1;
        dfs(0, 0, str1.length(), str1.toString(), str2.toString());
        return ans;
    }

    public static void dfs(int pos, int cost, int len, String str1, String str2) {
        if (cost > ans) {
            return;
        }
        while (pos < str1.length() && str1.charAt(pos) == str2.charAt(pos)) {
            pos++;
        }
        if (pos == str1.length()) {
            ans = Math.min(ans, cost);
            return;
        }

        if (cost + minSwap(str1, str2, pos) >= ans) {
            return;
        }
        for (int i = pos + 1; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(pos)) {
                String str1Next = swap(str1, i, pos);
                dfs(pos + 1, cost + 1, len, str1Next, str2);
            }
        }
    }

    public static int minSwap(String s1, String s2, int pos) {
        int tot = 0;
        for (int i = pos; i < s1.length(); i++) {
            tot += s1.charAt(i) != s2.charAt(i) ? 1 : 0;
        }
        return (tot + 1) / 2;
    }

    public static String swap(String cur, int i, int j) {
        char[] arr = cur.toCharArray();
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        return new String(arr);
    }
}
