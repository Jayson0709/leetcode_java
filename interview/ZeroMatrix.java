package interview;

import utils.DataConversionMethods;
import utils.InputMethods;
import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
//
//    Example 1:
//    Input:
//    [
//    [1,1,1],
//    [1,0,1],
//    [1,1,1]
//    ]
//    Output:
//    [
//    [1,0,1],
//    [0,0,0],
//    [1,0,1]
//    ]
//
//    Example 2:
//    Input:
//    [
//    [0,1,2,0],
//    [3,4,5,2],
//    [1,3,1,5]
//    ]
//    Output:
//    [
//    [0,0,0,0],
//    [0,4,5,0],
//    [0,3,1,0]
//    ]



//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
//
//    示例 1：
//    输入：
//    [
//    [1,1,1],
//    [1,0,1],
//    [1,1,1]
//    ]
//    输出：
//    [
//    [1,0,1],
//    [0,0,0],
//    [1,0,1]
//    ]
//
//    示例 2：
//    输入：
//    [
//    [0,1,2,0],
//    [3,4,5,2],
//    [1,3,1,5]
//    ]
//    输出：
//    [
//    [0,0,0,0],
//    [0,4,5,0],
//    [0,3,1,0]
//    ]


public class ZeroMatrix {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        int[][] matrix = DataConversionMethods.convertIntArrArrayListTo2DArray(data);
        setZeros(matrix);
        OutputMethods.format2DIntArrayOutputData(matrix);
    }

    // Method 1: use two tags
//    private static void setZeros(int[][] matrix) {
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
    private static void setZeros(int[][] matrix) {
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
