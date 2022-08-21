package algorithms.greedyAlgorithms;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
//
//    Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
//
//    Example 1:
//
//    Input: s = "abccccdd"
//    Output: 7
//    Explanation:
//    One longest palindrome that can be built is "dccaccd", whose length is 7.
//    Example 2:
//
//    Input: s = "a"
//    Output: 1
//    Example 3:
//
//    Input: s = "bb"
//    Output: 2
//
//    Constraints:
//
//    1 <= s.length <= 2000
//    s consists of lowercase and/or uppercase English letters only.


//给定一个包含大写字母和小写字母的字符串s返回通过这些字母构造成的 最长的回文串。
//
//    在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
//
//    示例 1:
//
//    输入:s = "abccccdd"
//    输出:7
//    解释:
//    我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
//    示例 2:
//
//    输入:s = "a"
//    输入:1
//    示例 3:
//
//    输入:s = "bb"
//    输入: 2
//
//    提示:
//
//    1 <= s.length <= 2000
//    s只能由小写和/或大写英文字母组成


public class Q409 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();

        int result = longestPalindrome(s);
        System.out.println(result);
    }

    // method 1: greedy algorithm and do not use the stack
    private static int longestPalindrome(String s) {
        int[] count = new int[128];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char curChar = s.charAt(i);
            count[curChar]++;
        }

        int result = 0;
        for (int num : count) {
            result += num / 2 * 2;
            // if an odd count number appeared once, do not consider any future odd numbers
            if (num % 2 == 1 && result % 2 == 0) {
                result++;
            }
        }
        return result;
    }

//    // method 2: directly use a stack.
//    private static int longestPalindrome(String s) {
//        List<String> charStack = new ArrayList<>();
//        int maxLength = 0;
//        for (int i = 0; i < s.length(); i++) {
//            String curChar = s.charAt(i) + "";
//            if (!charStack.contains(curChar)) {
//                charStack.add(curChar);
//            } else {
//                charStack.remove(curChar);
//                maxLength+=2;
//            }
//        }
//        if (charStack.size() >= 1) {
//            maxLength++;
//        }
//        return maxLength;
//    }
}
