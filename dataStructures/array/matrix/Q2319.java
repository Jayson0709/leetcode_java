package dataStructures.array.matrix;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


//A square matrix is said to be an X-Matrix if both of the following conditions hold:
//
//    All the elements in the diagonals of the matrix are non-zero.
//    All other elements are 0.
//    Given a 2D integer array grid of size n x n representing a square matrix, return true if grid is an X-Matrix. Otherwise, return false.
//
//    Example 1:
//    |2|0|0|1|
//    |0|3|1|0|
//    |0|5|2|0|
//    |4|0|0|2|
//    Input: grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
//    Output: true
//    Explanation: Refer to the diagram above.
//    An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
//    Thus, grid is an X-Matrix.
//
//    Example 2:
//    |5|7|0|
//    |0|3|1|
//    |0|5|0|
//    Input: grid = [[5,7,0],[0,3,1],[0,5,0]]
//    Output: false
//    Explanation: Refer to the diagram above.
//    An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
//    Thus, grid is not an X-Matrix.
//
//    Constraints:
//    n == grid.length == grid[i].length
//    3 <= n <= 100
//    0 <= grid[i][j] <= 10^5


//如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
//
//    矩阵对角线上的所有元素都 不是 0
//    矩阵中所有其他元素都是 0
//    给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 。
//
//    示例 1：
//    |2|0|0|1|
//    |0|3|1|0|
//    |0|5|2|0|
//    |4|0|0|2|
//    输入：grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
//    输出：true
//    解释：矩阵如上图所示。
//    X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
//    因此，grid 是一个 X 矩阵。
//
//    示例 2：
//    |5|7|0|
//    |0|3|1|
//    |0|5|0|
//    输入：grid = [[5,7,0],[0,3,1],[0,5,0]]
//    输出：false
//    解释：矩阵如上图所示。
//    X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
//    因此，grid 不是一个 X 矩阵。
//
//    提示：
//    n == grid.length == grid[i].length
//    3 <= n <= 100
//    0 <= grid[i][j] <= 10^5



public class Q2319 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        System.out.println(checkXMatrix(DataConversionMethods.convertIntArrArrayListTo2DArray(data)));
    }

    // Version 1
    private static boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        int summation = 0;
        for (int i = 0; i < n; i++) {
            if (grid[i][i] == 0) {
                return false;
            }
            summation += grid[i][i];
        }
        int x = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (grid[x][j] == 0) {
                return false;
            }
            if (x == j) {
                x++;
                continue;
            }
            summation += grid[x][j];
            x++;
        }
        int gridSum = 0;
        for (int[] row : grid) {
            gridSum += Arrays.stream(row).sum();
        }
        return gridSum == summation;
    }

    // Version 2
//    private static boolean checkXMatrix(int[][] grid) {
//        int n = grid.length;
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (i == j || (i + j) == (n - 1)) {
//                    if (grid[i][j] == 0) {
//                        return false;
//                    }
//                } else if (grid[i][j] != 0) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
