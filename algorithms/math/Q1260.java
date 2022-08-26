package algorithms.math;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
//
//    In one shift operation:
//
//    Element at grid[i][j] moves to grid[i][j + 1].
//    Element at grid[i][n - 1] moves to grid[i + 1][0].
//    Element at grid[m- 1][n - 1] moves to grid[0][0].
//    Return the 2D grid after applying shift operation k times.
//
//    Example 1:
//    |1|2|3|          |9|1|2|
//    |4|5|6|    ->    |3|4|5|
//    |7|8|9|          |6|7|8|
//    Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//    Output: [[9,1,2],[3,4,5],[6,7,8]]
//
//    Example 2:
//    |3 |8 |1 |9 |      |13|3 |8 |1 |      |21|13|3 |8 |      |0 |21|13|3 |      |12|0 |21|13|
//    |19|7 |2 |5 |  ->  |9 |19|7 |2 |  ->  |1 |9 |19|7 |  ->  |8 |1 |9 |19|  ->  |3 |8 |1 |9 |
//    |4 |6 |11|10|      |5 |4 |6 |11|      |2 |5 |4 |6 |      |7 |2 |5 |4 |      |19|7 |2 |5 |
//    |12|0 |21|13|      |10|12|0 |21|      |11|10|12|0 |      |6 |11|10|12|      |4 |6 |11|10|
//    Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
//    Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
//
//    Example 3:
//    Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
//    Output: [[1,2,3],[4,5,6],[7,8,9]]
//
//    Constraints:
//    m ==grid.length
//    n ==grid[i].length
//    1 <= m <= 50
//    1 <= n <= 50
//    -1000 <= grid[i][j] <= 1000
//    0 <= k <= 100



//给你一个 m 行 n列的二维网格grid和一个整数k。你需要将grid迁移k次。
//
//    每次「迁移」操作将会引发下述活动：
//
//    位于 grid[i][j]的元素将会移动到grid[i][j + 1]。
//    位于grid[i][n- 1] 的元素将会移动到grid[i + 1][0]。
//    位于 grid[m- 1][n - 1]的元素将会移动到grid[0][0]。
//    请你返回k 次迁移操作后最终得到的 二维网格。
//
//    示例 1：
//    |1|2|3|          |9|1|2|
//    |4|5|6|    ->    |3|4|5|
//    |7|8|9|          |6|7|8|
//    输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//    输出：[[9,1,2],[3,4,5],[6,7,8]]
//
//    示例 2：
//    |3 |8 |1 |9 |      |13|3 |8 |1 |      |21|13|3 |8 |      |0 |21|13|3 |      |12|0 |21|13|
//    |19|7 |2 |5 |  ->  |9 |19|7 |2 |  ->  |1 |9 |19|7 |  ->  |8 |1 |9 |19|  ->  |3 |8 |1 |9 |
//    |4 |6 |11|10|      |5 |4 |6 |11|      |2 |5 |4 |6 |      |7 |2 |5 |4 |      |19|7 |2 |5 |
//    |12|0 |21|13|      |10|12|0 |21|      |11|10|12|0 |      |6 |11|10|12|      |4 |6 |11|10|
//    输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
//    输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
//
//    示例 3：
//    输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
//    输出：[[1,2,3],[4,5,6],[7,8,9]]
//
//    提示：
//    m ==grid.length
//    n ==grid[i].length
//    1 <= m <= 50
//    1 <= n <= 50
//    -1000 <= grid[i][j] <= 1000
//    0 <= k <= 100


public class Q1260 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        int k = 0;
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            int[] curData = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (curData.length > 1) {
                data.add(curData);
            } else {
                k = curData[0];
            }
        }
        cin.close();
        List<List<Integer>> result = shiftGrid(DataConversionMethods.convertIntArrArrayListTo2DArray(data), k);
        System.out.println(OutputMethods.formatNestedListOutputData(result));
    }

    private static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            result.add(row);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = (i * n + j + k) % (m * n);
                result.get(index / n).set(index % n, grid[i][j]);
            }
        }
        return result;
    }
}
