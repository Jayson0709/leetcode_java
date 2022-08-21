package algorithms.twoPointers;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.
//
//    An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.
//
//    A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.
//
//    For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
//
//    Example 1:
//    Input: strs = ["aba","cdc","eae"]
//    Output: 3
//
//    Example 2:
//    Input: strs = ["aaa","aaa","aa"]
//    Output: -1
//
//    Constraints:
//    2 <= strs.length <= 50
//    1 <= strs[i].length <= 10
//    strs[i] consists of lowercase English letters.


//给定字符串列表strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
//
//    特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
//
//    s的子序列可以通过删去字符串s中的某些字符实现。
//
//    例如，"abc"是 "aebdc"的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc"。"aebdc"的子序列还包括"aebdc"、 "aeb"和 ""(空字符串)。
//
//    示例 1：
//    输入: strs = ["aba","cdc","eae"]
//    输出: 3
//
//    示例 2:
//    输入: strs = ["aaa","aaa","aa"]
//    输出: -1
//
//    提示:
//    2 <= strs.length <= 50
//    1 <= strs[i].length <= 10
//    strs[i]只包含小写英文字母


public class Q522 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] strs = cin.nextLine().strip().split(" ");
        cin.close();

        int result = findLUSLength(strs);
        System.out.println(result);
    }

    private static int findLUSLength(String[] strs) {
        int result = -1;
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                result = Math.max(result, strs[i].length());
            }
        }
        return result;
    }

    private static boolean isSubsequence(String s, String t) {
        int ptrS = 0, ptrT = 0;
        while (ptrS < s.length() && ptrT < t.length()) {
            if (s.charAt(ptrS) == t.charAt(ptrT)) {
                ptrS++;
            }
            ptrT++;
        }
        return ptrS == s.length();
    }
}
