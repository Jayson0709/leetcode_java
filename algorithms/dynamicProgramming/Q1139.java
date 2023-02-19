package algorithms.dynamicProgramming;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.
//
//    Example 1:
//    Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
//    Output: 9
//
//    Example 2:
//    Input: grid = [[1,1,0,0]]
//    Output: 1
//
//    Constraints:
//    1 <= grid.length <= 100
//    1 <= grid[0].length <= 100
//    grid[i][j] is 0 or 1


//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
//
//    示例 1：
//    输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//    输出：9
//
//    示例 2：
//    输入：grid = [[1,1,0,0]]
//    输出：1
//
//    提示：
//    1 <= grid.length <= 100
//    1 <= grid[0].length <= 100
//    grid[i][j] 为 0 或 1


public class Q1139 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> grid = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, grid);
        cin.close();
        System.out.println(largest1BorderedSquare(DataConversionMethods.convertIntArrArrayListTo2DArray(grid)));
    }

    private static int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];
        int maxBorder = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                    int border = Math.min(left[i][j], up[i][j]);
                    while (left[i - border + 1][j] < border || up[i][j - border + 1] < border) {
                        border--;
                    }
                    maxBorder = Math.max(maxBorder, border);
                }
            }
        }
        return maxBorder * maxBorder;
    }
}
