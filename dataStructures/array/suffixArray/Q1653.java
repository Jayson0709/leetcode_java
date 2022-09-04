package dataStructures.array.suffixArray;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given a string s consisting only of characters 'a' and 'b'.
//
//    You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
//
//    Return the minimum number of deletions needed to make s balanced.
//    
//    Example 1:
//    Input: s = "aababbab"
//    Output: 2
//    Explanation: You can either:
//    Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
//    Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
//    
//    Example 2:
//    Input: s = "bbaaaaabb"
//    Output: 2
//    Explanation: The only solution is to delete the first two characters.
//
//    Constraints:
//    1 <= s.length <= 10^5
//    s[i] is 'a' or 'b'.



//给你一个字符串 s ，它仅包含字符 'a' 和 'b'。
//
//    你可以删除 s 中任意数目的字符，使得 s 平衡 。我们称 s 平衡的 当不存在下标对 (i,j) 满足 i < j 且 s[i] = 'b' 同时 s[j]= 'a' 。
//
//    请你返回使 s 平衡 的 最少 删除次数。
//
//    示例 1：
//    输入：s = "aababbab"
//    输出：2
//    解释：你可以选择以下任意一种方案：
//    下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
//    下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
//
//    示例 2：
//    输入：s = "bbaaaaabb"
//    输出：2
//    解释：唯一的最优解是删除最前面两个字符。
//
//    提示：
//    1 <= s.length <= 10^5
//    s[i] 要么是 'a' 要么是 'b' 。


public class Q1653 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(minimumDeletions(s));
    }

    // Method 1: use the idea of Stack
//    private static int minimumDeletions(String s) {
//        char[] chars = s.toCharArray();
//        int res = 0, b = 0;
//        for (char c : chars) {
//            if (c == 'b') {
//                b++;
//            } else if (b > 0) {
//                res++;
//                b--;
//            }
//        }
//        return res;
//    }

    // Method 2: use suffix array
    private static int minimumDeletions(String s) {
        int n = s.length();
        int[] rightB = new int[n+1];
        for(int i = n - 1; i >= 0; i--){
            rightB[i] = rightB[i + 1];
            if(s.charAt(i) == 'b')
                rightB[i]++;
        }
        int maxLen = 0;
        int leftA = 0;
        for(int i = 0; i < n; i++){
            maxLen = Math.max(maxLen, leftA + rightB[i]);
            if(s.charAt(i) == 'a') {
                leftA++;
            }
        }
        maxLen = Math.max(maxLen, leftA);
        return n - maxLen;
    }
}
