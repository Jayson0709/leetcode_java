package dataStructures.string.stringOperation;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)". Then, we removed all commas, decimal points, and spaces and ended up with the string s.
//
//    For example, "(1, 3)" becomes s = "(13)" and "(2, 0.5)" becomes s = "(205)".
//    Return a list of strings representing all possibilities for what our original coordinates could have been.
//
//    Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with fewer digits. Also, a decimal point within a number never occurs without at least one digit occurring before it, so we never started with numbers like ".1".
//
//    The final answer list can be returned in any order. All coordinates in the final answer have exactly one space between them (occurring after the comma.)
//
//    Example 1:
//    Input: s = "(123)"
//    Output: ["(1, 2.3)","(1, 23)","(1.2, 3)","(12, 3)"]
//
//    Example 2:
//    Input: s = "(0123)"
//    Output: ["(0, 1.23)","(0, 12.3)","(0, 123)","(0.1, 2.3)","(0.1, 23)","(0.12, 3)"]
//    Explanation: 0.0, 00, 0001 or 00.01 are not allowed.
//
//    Example 3:
//    Input: s = "(00011)"
//    Output: ["(0, 0.011)","(0.001, 1)"]
//
//    Constraints:
//    4 <= s.length <= 12
//    s[0] == '(' and s[s.length - 1] == ')'.
//    The rest of s are digits.


//我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
//
//    原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
//
//    最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
//
//    示例 1:
//    输入: "(123)"
//    输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
//
//    示例 2:
//    输入: "(00011)"
//    输出:  ["(0.001, 1)", "(0, 0.011)"]
//    解释:
//    0.0, 00, 0001 或 00.01 是不被允许的。
//
//    示例 3:
//    输入: "(0123)"
//    输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
//
//    示例 4:
//    输入: "(100)"
//    输出: [(10, 0)]
//    解释:
//    1.0 是不被允许的。
//
//    提示:
//    4 <= S.length <= 12.
//    S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。


public class Q816 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(ambiguousCoordinates(s));
    }

    private static List<String> ambiguousCoordinates(String s) {
        int n = s.length() - 2;
        List<String> res = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int l = 1; l < n; ++l) {
            List<String> lt = getPos(s.substring(0, l));
            if (lt.isEmpty()) {
                continue;
            }
            List<String> rt = getPos(s.substring(l));
            if (rt.isEmpty()) {
                continue;
            }
            for (String i : lt) {
                for (String j : rt) {
                    res.add("(" + i + ", " + j + ")");
                }
            }
        }
        return res;
    }

    public static List<String> getPos(String s) {
        List<String> pos = new ArrayList<>();
        if (s.charAt(0) != '0' || "0".equals(s)) {
            pos.add(s);
        }
        for (int p = 1; p < s.length(); ++p) {
            if ((p != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0') {
                continue;
            }
            pos.add(s.substring(0, p) + "." + s.substring(p));
        }
        return pos;
    }
}
