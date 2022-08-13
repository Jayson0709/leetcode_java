package algorithms.dynamicProgramming;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//
//    Note: You can only move either down or right at any point in time.
//
//    Example 1:
//    |1|3|1|
//    |1|5|1|
//    |4|2|1|
//    Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//    Output: 7
//    Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
//
//    Example 2:
//    Input: grid = [[1,2,3],[4,5,6]]
//    Output: 12
//
//    Constraints:
//    m == grid.length
//    n == grid[i].length
//    1 <= m, n <= 200
//    0 <= grid[i][j] <= 100



//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//    说明：每次只能向下或者向右移动一步。
//
//    示例 1：
//    |1|3|1|
//    |1|5|1|
//    |4|2|1|
//    输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//    输出：7
//    解释：因为路径 1→3→1→1→1 的总和最小。
//
//    示例 2：
//    输入：grid = [[1,2,3],[4,5,6]]
//    输出：12
//
//    提示：
//    m == grid.length
//    n == grid[i].length
//    1 <= m, n <= 200
//    0 <= grid[i][j] <= 100



public class Q64 {
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
        int[][] grid = new int[data.size()][];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = data.get(i);
        }
        System.out.println(minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
