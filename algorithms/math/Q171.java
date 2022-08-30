package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
//
//    For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//    
//    Example 1:
//    Input: columnTitle = "A"
//    Output: 1
//    
//    Example 2:
//    Input: columnTitle = "AB"
//    Output: 28
//    
//    Example 3:
//    Input: columnTitle = "ZY"
//    Output: 701
//
//    Constraints:
//    1 <= columnTitle.length <= 7
//    columnTitle consists only of uppercase English letters.
//    columnTitle is in the range ["A", "FXSHRXW"].



//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
//
//    例如：
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//    示例 1:
//    输入: columnTitle = "A"
//    输出: 1
//
//    示例 2:
//    输入: columnTitle = "AB"
//    输出: 28
//
//    示例 3:
//    输入: columnTitle = "ZY"
//    输出: 701
//
//    提示：
//    1 <= columnTitle.length <= 7
//    columnTitle 仅由大写英文组成
//    columnTitle 在范围 ["A", "FXSHRXW"] 内



public class Q171 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String columnTitle = cin.nextLine().strip();
        cin.close();
        System.out.println(titleToNumber(columnTitle));
    }

    private static int titleToNumber(String columnTitle) {
        int res = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            res += k * multiple;
            multiple *= 26;
        }
        return res;
    }
}
