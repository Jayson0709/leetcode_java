package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//    P   A   H   N
//    A P L S I I G
//    Y   I   R
//    And then read line by line: "PAHNAPLSIIGYIR"
//
//    Write the code that will take a string and make this conversion given a number of rows:
//
//    string convert(string s, int numRows);
//
//    Example 1:
//    Input: s = "PAYPALISHIRING", numRows = 3
//    Output: "PAHNAPLSIIGYIR"
//
//    Example 2:
//    Input: s = "PAYPALISHIRING", numRows = 4
//    Output: "PINALSIGYAHRPI"
//    Explanation:
//    P     I    N
//    A   L S  I G
//    Y A   H R
//    P     I
//
//    Example 3:
//    Input: s = "A", numRows = 1
//    Output: "A"
//
//    Constraints:
//    1 <= s.length <= 1000
//    s consists of English letters (lower-case and upper-case), ',' and '.'.
//    1 <= numRows <= 1000


//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
//    比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//    P   A   H   N
//    A P L S I I G
//    Y   I   R
//    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
//    请你实现这个将字符串进行指定行数变换的函数：
//
//    string convert(string s, int numRows);
//
//    示例 1：
//    输入：s = "PAYPALISHIRING", numRows = 3
//    输出："PAHNAPLSIIGYIR"
//
//    示例 2：
//    输入：s = "PAYPALISHIRING", numRows = 4
//    输出："PINALSIGYAHRPI"
//    解释：
//    P     I    N
//    A   L S  I G
//    Y A   H R
//    P     I
//
//    示例 3：
//    输入：s = "A", numRows = 1
//    输出："A"
//
//    提示：
//    1 <= s.length <= 1000
//    s 由英文字母（小写和大写）、',' 和 '.' 组成
//    1 <= numRows <= 1000


public class Q6 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        int numRows = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        System.out.println(convert(s, numRows));
    }

    private static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows -1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
