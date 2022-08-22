package algorithms.math;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
//
//        For each location indices[i], do both of the following:
//        
//        Increment all the cells on row ri.
//        Increment all the cells on column ci.
//        Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.
//        
//        Example 1:
//        |0   0   0|   -> |1   2   1|    ->    |1   3   1|
//        |0   0   0|      |0   1   0|          |1   3   1|
//        Input: m = 2, n = 3, indices = [[0,1],[1,1]]
//        Output: 6
//        Explanation: Initial matrix = [[0,0,0],[0,0,0]].
//        After applying first increment it becomes [[1,2,1],[0,1,0]].
//        The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
//        
//        Example 2:
//        |0   0|   ->    |0   1|    ->    |2   2|
//        |0   0|         |1   2|          |2   2|
//        Input: m = 2, n = 2, indices = [[1,1],[0,0]]
//        Output: 0
//        Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
//        
//        Constraints:
//        1 <= m, n <= 50
//        1 <= indices.length <= 100
//        0 <= ri < m
//        0 <= ci < n
//        
//        Follow up: Could you solve this in O(n + m + indices.length) time with only O(n + m) extra space?


//给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
//
//        另有一个二维索引数组indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
//
//        对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
//
//        ri 行上的所有单元格，加 1 。
//        ci 列上的所有单元格，加 1 。
//        给你 m、n 和 indices 。请你在执行完所有indices指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
//
//        示例 1：
//        |0   0   0|   -> |1   2   1|    ->    |1   3   1|
//        |0   0   0|      |0   1   0|          |1   3   1|
//        输入：m = 2, n = 3, indices = [[0,1],[1,1]]
//        输出：6
//        解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
//        第一次增量操作后得到 [[1,2,1],[0,1,0]]。
//        最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
//        示例 2：
//        |0   0|   ->    |0   1|    ->    |2   2|
//        |0   0|         |1   2|          |2   2|
//        输入：m = 2, n = 2, indices = [[1,1],[0,0]]
//        输出：0
//        解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
//
//        提示：
//        1 <= m, n <= 50
//        1 <= indices.length <= 100
//        0 <= ri < m
//        0 <= ci < n
//
//        进阶：你可以设计一个时间复杂度为 O(n + m + indices.length) 且仅用 O(n + m) 额外空间的算法来解决此问题吗？


public class Q1252 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int m = cin.nextInt();
        int n = cin.nextInt();
        List<int[]> indicesData = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, indicesData);
        cin.close();
        int result = oddCells(m, n, DataConversionMethods.convertIntArrayListTo2DArray(indicesData));
        System.out.println(result);
    }

    // Method 1: Counting the X and Y
    private static int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int oddX = 0, oddY = 0;
        for (int i = 0; i < m; i++) {
            if ((rows[i] & 1) != 0) {
                oddX++;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((cols[i] & 1) != 0) {
                oddY++;
            }
        }
        // result = x * n + y * m - 2 * x * y
        return oddX * (n - oddY) + (m - oddX) * oddY;
    }
}
