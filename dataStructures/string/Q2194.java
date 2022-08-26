package dataStructures.string;

import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//A cell (r, c) of an Excel sheet is represented as a string "<col><row>" where:
//
//    <col> denotes the column number c of the cell. It is represented by alphabetical letters.
//        For example, the 1st column is denoted by 'A', the 2nd by 'B', the 3rd by 'C', and so on.
//    <row> is the row number r of the cell. The rth row is represented by the integer r.
//
//    You are given a string s in the format "<col1><row1>:<col2><row2>", where <col1> represents the column c1, <row1> represents the row r1, <col2> represents the column c2, and <row2> represents the row r2, such that r1 <= r2 and c1 <= c2.
//
//    Return the list of cells (x, y) such that r1 <= x <= r2 and c1 <= y <= c2. The cells should be represented as strings in the format mentioned above and be sorted in non-decreasing order first by columns and then by rows.
//
//    Example 1:
//    Input: s = "K1:L2"
//    Output: ["K1","K2","L1","L2"]
//    Explanation:
//    The above diagram shows the cells which should be present in the list.
//    The red arrows denote the order in which the cells should be presented.
//
//    Example 2:
//    Input: s = "A1:F1"
//    Output: ["A1","B1","C1","D1","E1","F1"]
//    Explanation:
//    The above diagram shows the cells which should be present in the list.
//    The red arrow denotes the order in which the cells should be presented.
//
//    Constraints:
//    s.length == 5
//    'A' <= s[0] <= s[3] <= 'Z'
//    '1' <= s[1] <= s[4] <= '9'
//    s consists of uppercase English letters, digits and ':'.



//Excel 表中的一个单元格 (r, c) 会以字符串 "<col><row>" 的形式进行表示，其中：
//
//    <col> 即单元格的列号 c 。用英文字母表中的 字母 标识。
//        例如，第 1 列用 'A' 表示，第 2 列用 'B' 表示，第 3 列用 'C' 表示，以此类推。
//    <row> 即单元格的行号 r 。第 r 行就用 整数 r 标识。
//
//    给你一个格式为 "<col1><row1>:<col2><row2>" 的字符串 s ，其中 <col1> 表示 c1 列，<row1> 表示 r1 行，<col2> 表示 c2 列，<row2> 表示 r2 行，并满足 r1 <= r2 且 c1 <= c2 。
//
//    找出所有满足 r1 <= x <= r2 且 c1 <= y <= c2 的单元格，并以列表形式返回。单元格应该按前面描述的格式用 字符串 表示，并以 非递减 顺序排列（先按列排，再按行排）。
//
//    示例 1：
//        K   |   L   |
//    1|  |     - |
//    2|  |   -   |
//        V -     V
//    输入：s = "K1:L2"
//    输出：["K1","K2","L1","L2"]
//    解释：
//    上图显示了列表中应该出现的单元格。
//    红色箭头指示单元格的出现顺序。
//
//    示例 2：
//       A   B   C   D   E   F
//    1|---|---|---|---|---|---|->
//    输入：s = "A1:F1"
//    输出：["A1","B1","C1","D1","E1","F1"]
//    解释：
//    上图显示了列表中应该出现的单元格。
//    红色箭头指示单元格的出现顺序。
//
//    提示：
//    s.length == 5
//    'A' <= s[0] <= s[3] <= 'Z'
//    '1' <= s[1] <= s[4] <= '9'
//    s 由大写英文字母、数字、和 ':' 组成


public class Q2194 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(OutputMethods.formatListOutputData(cellsInRange(s)));
    }

    private static List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char i = chars[0]; i <= chars[3]; i++) {
            for (char j = chars[1]; j <= chars[4]; j++) {
                res.add(String.valueOf(i) + j);
            }
        }
        return res;
    }
}
