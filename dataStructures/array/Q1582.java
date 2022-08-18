package dataStructures.array;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an m x n binary matrix mat, return the number of special positions in mat.
//
//    A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
//
//    Example 1:
//    |1|0|0|
//    |0|0|1|
//    |1|0|0|
//    Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
//    Output: 1
//    Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
//
//    Example 2:
//    |1|0|0|
//    |0|1|0|
//    |0|0|1|
//    Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
//    Output: 3
//    Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
//
//    Constraints:
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n <= 100
//    mat[i][j] is either 0 or 1.



//给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
//
//    特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
//
//    示例 1：
//    输入：mat = [[1,0,0],
//                [0,0,1],
//                [1,0,0]]
//    输出：1
//    解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
//
//    示例 2：
//    输入：mat = [[1,0,0],
//                [0,1,0],
//                [0,0,1]]
//    输出：3
//    解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
//
//    示例 3：
//    输入：mat = [[0,0,0,1],
//                [1,0,0,0],
//                [0,1,1,0],
//                [0,0,0,0]]
//    输出：2
//
//    示例 4：
//    输入：mat = [[0,0,0,0,0],
//                [1,0,0,0,0],
//                [0,1,0,0,0],
//                [0,0,1,0,0],
//                [0,0,0,1,1]]
//    输出：3
//
//    提示：
//    rows == mat.length
//    cols == mat[i].length
//    1 <= rows, cols <= 100
//    mat[i][j] 是 0 或 1



public class Q1582 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            data.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        cin.close();
        int[][] mat = new int[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            mat[i] = data.get(i);
        }
        System.out.println(numSpecial(mat));
    }

    private static int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(mat[i][j] == 1){
                    rowCount[i] ++;
                    colCount[j] ++;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
