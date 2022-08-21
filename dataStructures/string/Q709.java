package dataStructures.string;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
//
//    Example 1:
//    Input: s = "Hello"
//    Output: "hello"
//
//    Example 2:
//    Input: s = "here"
//    Output: "here"
//
//    Example 3:
//    Input: s = "LOVELY"
//    Output: "lovely"
//
//    Constraints:
//    1 <= s.length <= 100
//    s consists of printable ASCII characters.



//给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
//
//    示例 1：
//    输入：s = "Hello"
//    输出："hello"
//
//    示例 2：
//    输入：s = "here"
//    输出："here"
//
//    示例 3：
//    输入：s = "LOVELY"
//    输出："lovely"
//
//    提示：
//    1 <= s.length <= 100
//    s 由 ASCII 字符集中的可打印字符组成



public class Q709 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(toLowerCase(s));
    }

    private static String toLowerCase(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 65 && c <= 90) {
                c |= 32;
            }
            res.append(c);
        }
        return res.toString();
    }
}
