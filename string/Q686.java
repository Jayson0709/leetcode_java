package string;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.
//
//    Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
//    
//    Example 1:
//    Input: a = "abcd", b = "cdabcdab"
//    Output: 3
//    Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
//    
//    Example 2:
//    Input: a = "a", b = "aa"
//    Output: 2
//
//    Constraints:
//    1 <= a.length, b.length <= 10^4
//    a and b consist of lowercase English letters.


//给定两个字符串a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
//
//    注意：字符串 "abc"重复叠加 0 次是 ""，重复叠加 1 次是"abc"，重复叠加 2 次是"abcabc"。
//
//    示例 1：
//    输入：a = "abcd", b = "cdabcdab"
//    输出：3
//    解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
//
//    示例 2：
//    输入：a = "a", b = "aa"
//    输出：2
//
//    示例 3：
//    输入：a = "a", b = "a"
//    输出：1
//
//    示例 4：
//    输入：a = "abc", b = "wxyz"
//    输出：-1
//
//    提示：
//    1 <= a.length <= 10^4
//    1 <= b.length <= 10^4
//    a 和 b 由小写英文字母组成


public class Q686 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String a = cin.nextLine().strip();
        String b = cin.nextLine().strip();
        cin.close();

        int result = repeatedStringMatch(a, b);
        System.out.println(result);
    }

    // Method 1: Rabin-Karp algorithm
//    static final int kMod1 = 1000000007;
//    static final int kMod2 = 1337;
//
//    public static int repeatedStringMatch(String a, String b) {
//        int an = a.length(), bn = b.length();
//        int index = strStr(a, b);
//        if (index == -1) {
//            return -1;
//        }
//        if (an - index >= bn) {
//            return 1;
//        }
//        return (bn + index - an - 1) / an + 2;
//    }
//
//    public static int strStr(String haystack, String needle) {
//        int n = haystack.length(), m = needle.length();
//        if (m == 0) {
//            return 0;
//        }
//
//        int k1 = 1000000009;
//        int k2 = 1337;
//        Random random = new Random();
//        int kMod1 = random.nextInt(k1) + k1;
//        int kMod2 = random.nextInt(k2) + k2;
//
//        long hashNeedle = 0;
//        for (int i = 0; i < m; i++) {
//            char c = needle.charAt(i);
//            hashNeedle = (hashNeedle * kMod2 + c) % kMod1;
//        }
//        long hashHaystack = 0, extra = 1;
//        for (int i = 0; i < m - 1; i++) {
//            hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
//            extra = (extra * kMod2) % kMod1;
//        }
//        for (int i = m - 1; (i - m + 1) < n; i++) {
//            hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
//            if (hashHaystack == hashNeedle) {
//                return i - m + 1;
//            }
//            hashHaystack = (hashHaystack - extra * haystack.charAt((i - m + 1) % n)) % kMod1;
//            hashHaystack = (hashHaystack + kMod1) % kMod1;
//        }
//        return -1;
//    }

    // Method 2: Knuth-Morris-Pratt (KMP) algorithm
    private static int repeatedStringMatch(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i - j < n; i++) {
            // Whether b starts matching more than the first superposition of A
            while (j > 0 && haystack.charAt(i % n) != needle.charAt(j)) {
                // haystack is a string that is looped over, so we need do i % n.
                j = pi[j - 1];
            }
            if (haystack.charAt(i % n) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
