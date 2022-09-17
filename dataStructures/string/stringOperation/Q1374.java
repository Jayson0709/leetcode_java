package dataStructures.string.stringOperation;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.
//
//    The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.
//
//    Example 1:
//    Input: n = 4
//    Output: "pppz"
//    Explanation: "pppz" is a valid string since the character 'p' occurs three times and the character 'z' occurs once. Note that there are many other valid strings such as "ohhh" and "love".
//    
//    Example 2:
//    Input: n = 2
//    Output: "xy"
//    Explanation: "xy" is a valid string since the characters 'x' and 'y' occur once. Note that there are many other valid strings such as "ag" and "ur".
//    
//    Example 3:
//    Input: n = 7
//    Output: "holasss"
//
//    Constraints:
//    1 <= n <= 500



//给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
//
//    返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
//
//    示例 1：
//    输入：n = 4
//    输出："pppz"
//    解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。
//
//    示例 2：
//    输入：n = 2
//    输出："xy"
//    解释："xy" 是一个满足题目要求的字符串，因为 'x' 和 'y' 各出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ag" 和 "ur"。
//
//    示例 3：
//    输入：n = 7
//    输出："holasss"
//
//    提示：
//    1 <= n <= 500



public class Q1374 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(generateTheString(n));
    }

    private static String generateTheString(int n) {
        StringBuilder res = new StringBuilder();
        if (n % 2 == 0) {
            res.append("a".repeat(Math.max(0, n - 1)));
            res.append("b");
        } else {
            res.append("a".repeat(n));
        }
        return res.toString();
    }
}