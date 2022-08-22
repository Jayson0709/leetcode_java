package dataStructures.hashSet;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a string s, return the maximum number of occurrences of any substring under the following rules:
//
//    The number of unique characters in the substring must be less than or equal to maxLetters.
//    The substring size must be between minSize and maxSize inclusive.
//
//    Example 1:
//    Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
//    Output: 2
//    Explanation: Substring "aab" has 2 occurrences in the original string.
//    It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
//    
//    Example 2:
//    Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
//    Output: 2
//    Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
//
//    Constraints:
//    1 <= s.length <= 10^5
//    1 <= maxLetters <= 26
//    1 <= minSize <= maxSize <= min(26, s.length)
//    s consists of only lowercase English letters.


//给你一个字符串s ，请你返回满足以下条件且出现次数最大的任意子串的出现次数：
//
//    子串中不同字母的数目必须小于等于 maxLetters 。
//    子串的长度必须大于等于minSize 且小于等于maxSize 。
//
//    示例 1：
//    输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
//    输出：2
//    解释：子串 "aab" 在原字符串中出现了 2 次。
//    它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
//
//    示例 2：
//    输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
//    输出：2
//    解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
//
//    示例 3：
//    输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
//    输出：3
//
//    示例 4：
//    输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
//    输出：0
//
//    提示：
//    1 <= s.length <= 10^5
//    1 <= maxLetters <= 26
//    1 <= minSize <= maxSize <= min(26, s.length)
//    s只包含小写英文字母。



public class Q1297 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        int maxLetters = cin.nextInt();
        int minSize = cin.nextInt();
        int maxSize = cin.nextInt();
        cin.close();
        int result = maxFreq(s, maxLetters, minSize, maxSize);
        System.out.println(result);
    }

    // Method 1: HashMap + Window Sliding
//    private static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
//        int n = s.length();
//        Map<String, Integer> hMap = new HashMap<>();
//        char[] chars = s.toCharArray();
//        int left = 0, right = 0;
//        int cntDiffChar = 0;
//        // To store the count of each letter in the window
//        int[] count = new int[128];
//        while (right < n) {
//            count[chars[right]]++;
//            if (count[chars[right]] == 1) {
//                cntDiffChar++;
//            }
//            right++;
//            int len = right - left;
//            while (cntDiffChar > maxLetters || len > minSize) {
//                count[chars[left]]--;
//                if (count[chars[left]] == 0) {
//                    cntDiffChar--;
//                }
//                left++;
//                len--;
//            }
//            if (cntDiffChar <= maxLetters) {
//                if (len == minSize) {
//                    String str = s.substring(left, right);
//                    hMap.put(str, hMap.getOrDefault(str, 0) + 1);
//                }
//            }
//        }
//        int result = 0;
//        for (String key : hMap.keySet()) {
//            result = Math.max(result, hMap.get(key));
//        }
//        return result;
//    }

    // Method 2: HashMap + HashSet
    private static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i + minSize > n) {
                break;
            }
            String sub = s.substring(i, i + minSize);
            if (isMatch(sub, maxLetters)) {
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
            }
        }
        int result = 0;
        for (String str: countMap.keySet()) {
            result = Math.max(result, countMap.get(str));
        }
        return result;
    }

    private static boolean isMatch(String str, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
            if (set.size() > maxLetters) {
                return false;
            }
        }
        return set.size() <= maxLetters;
    }
}
