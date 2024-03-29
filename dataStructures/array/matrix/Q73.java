package dataStructures.array.matrix;

import utils.DataConversionMethods;
import utils.InputMethods;
import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



//Given an m x n integer matrix 'matrix', if an element is 0, set its entire row and column to 0's.
//
//    You must do it in place.
//
//    Example 1:
//    |1|1|1|        |1|0|1|
//    |1|0|1|   ->   |0|0|0|
//    |1|1|1|        |1|0|1|
//    Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//    Output: [[1,0,1],[0,0,0],[1,0,1]]
//
//    Example 2:
//    |0|1|2|0|        |0|0|0|0|
//    |3|4|5|2|   ->   |0|4|5|0|
//    |1|3|1|5|        |0|3|1|0|
//    Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//    Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//    Constraints:
//    m == matrix.length
//    n == matrix[0].length
//    1 <= m, n <= 200
//    -2^31 <= matrix[i][j] <= 2^31 - 1
//
//    Follow up:
//    A straightforward solution using O(mn) space is probably a bad idea.
//    A simple improvement uses O(m + n) space, but still not the best solution.
//    Could you devise a constant space solution?



//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//
//    示例 1：
//    |1|1|1|        |1|0|1|
//    |1|0|1|   ->   |0|0|0|
//    |1|1|1|        |1|0|1|
//    输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//    输出：[[1,0,1],[0,0,0],[1,0,1]]
//
//    示例 2：
//    |0|1|2|0|        |0|0|0|0|
//    |3|4|5|2|   ->   |0|4|5|0|
//    |1|3|1|5|        |0|3|1|0|
//    输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//    输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//    提示：
//    m == matrix.length
//    n == matrix[0].length
//    1 <= m, n <= 200
//    -2^31 <= matrix[i][j] <= 2^31 - 1
//
//    进阶：
//    一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
//    一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
//    你能想出一个仅使用常量空间的解决方案吗？


public class Q73 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        int[][] matrix = DataConversionMethods.convertIntArrArrayListTo2DArray(data);
        setZeroes(matrix);
        OutputMethods.format2DIntArrayOutputData(matrix);
    }

    // Method 1: use two tags
//    private static void setZeroes(int[][] matrix) {
//        int m = matrix.length, n = matrix[0].length;
//        boolean flagCol0 = false, flagRow0 = false;
//        for (int[] ints : matrix) {
//            if (ints[0] == 0) {
//                flagCol0 = true;
//                break;
//            }
//        }
//        for (int j = 0; j < n; j++) {
//            if (matrix[0][j] == 0) {
//                flagRow0 = true;
//                break;
//            }
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    matrix[i][0] = matrix[0][j] = 0;
//                }
//            }
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        if (flagCol0) {
//            for (int i = 0; i < m; i++) {
//                matrix[i][0] = 0;
//            }
//        }
//        if (flagRow0) {
//            for (int j = 0; j < n; j++) {
//                matrix[0][j] = 0;
//            }
//        }
//    }

    // Method 2: use one tag
    private static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }
}
