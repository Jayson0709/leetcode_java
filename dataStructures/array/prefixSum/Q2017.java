package dataStructures.array.prefixSum;
import utils.DataConversionMethods;
import utils.InputMethods;

import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. Two robots are playing a game on this matrix.
//
//    Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).
//
//    At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.
//
//    The first robot wants to minimize the number of points collected by the second robot. In contrast, the second robot wants to maximize the number of points it collects. If both robots play optimally, return the number of points collected by the second robot.
//
//    Example 1:
//    |2|5|4|    ->   |0|0|4|
//    |1|5|1|         |1|0|0|
//    (2,5,5,1)       (0,0,4,0)
//    Input: grid = [[2,5,4],[1,5,1]]
//    Output: 4
//    Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
//    The cells visited by the first robot are set to 0.
//    The second robot will collect 0 + 0 + 4 + 0 = 4 points.
//
//    Example 2:
//    |3|3|1|    ->   |0|3|1|
//    |8|5|2|         |0|0|0|
//    (3,8,5,2)       (0,3,1,0)
//    Input: grid = [[3,3,1],[8,5,2]]
//    Output: 4
//    Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
//    The cells visited by the first robot are set to 0.
//    The second robot will collect 0 + 3 + 1 + 0 = 4 points.
//
//    Example 3:
//    |3 |3 |1 |15|    ->   |0 |0 |0 |0 |
//    |8 |5 |2 |1 |         |1 |3 |3 |0 |
//    (1,3,1,15,1)          (0,1,3,3,0)
//    Input: grid = [[1,3,1,15],[1,3,3,1]]
//    Output: 7
//    Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
//    The cells visited by the first robot are set to 0.
//    The second robot will collect 0 + 1 + 3 + 3 + 0 = 7 points.
//
//    Constraints:
//    grid.length == 2
//    n == grid[r].length
//    1 <= n <= 5 * 10^4
//    1 <= grid[r][c] <= 10^5



//给你一个下标从 0 开始的二维数组 grid ，数组大小为 2 x n ，其中 grid[r][c] 表示矩阵中 (r, c) 位置上的点数。现在有两个机器人正在矩阵上参与一场游戏。
//
//    两个机器人初始位置都是 (0, 0) ，目标位置是 (1, n-1) 。每个机器人只会 向右 ((r, c) 到 (r, c + 1)) 或 向下 ((r, c) 到 (r + 1, c)) 。
//
//    游戏开始，第一个 机器人从 (0, 0) 移动到 (1, n-1) ，并收集路径上单元格的全部点数。对于路径上所有单元格 (r, c) ，途经后 grid[r][c] 会重置为 0 。然后，第二个 机器人从 (0, 0) 移动到 (1, n-1) ，同样收集路径上单元的全部点数。注意，它们的路径可能会存在相交的部分。
//
//    第一个 机器人想要打击竞争对手，使 第二个 机器人收集到的点数 最小化 。与此相对，第二个 机器人想要 最大化 自己收集到的点数。两个机器人都发挥出自己的 最佳水平 的前提下，返回 第二个 机器人收集到的 点数 。
//
//    示例 1：
//    |2|5|4|    ->   |0|0|4|
//    |1|5|1|         |1|0|0|
//    (2,5,5,1)       (0,0,4,0)
//    输入：grid = [[2,5,4],[1,5,1]]
//    输出：4
//    解释：第一个机器人的最佳路径如红色所示，第二个机器人的最佳路径如蓝色所示。
//    第一个机器人访问过的单元格将会重置为 0 。
//    第二个机器人将会收集到 0 + 0 + 4 + 0 = 4 个点。
//
//    示例 2：
//    |3|3|1|    ->   |0|3|1|
//    |8|5|2|         |0|0|0|
//    (3,8,5,2)       (0,3,1,0)
//    输入：grid = [[3,3,1],[8,5,2]]
//    输出：4
//    解释：第一个机器人的最佳路径如红色所示，第二个机器人的最佳路径如蓝色所示。
//    第一个机器人访问过的单元格将会重置为 0 。
//    第二个机器人将会收集到 0 + 3 + 1 + 0 = 4 个点。
//
//    示例 3：
//    |3 |3 |1 |15|    ->   |0 |0 |0 |0 |
//    |8 |5 |2 |1 |         |1 |3 |3 |0 |
//    (1,3,1,15,1)          (0,1,3,3,0)
//    输入：grid = [[1,3,1,15],[1,3,3,1]]
//    输出：7
//    解释：第一个机器人的最佳路径如红色所示，第二个机器人的最佳路径如蓝色所示。
//    第一个机器人访问过的单元格将会重置为 0 。
//    第二个机器人将会收集到 0 + 1 + 3 + 3 + 0 = 7 个点。
//
//    提示：
//    grid.length == 2
//    n == grid[r].length
//    1 <= n <= 5 * 10^4
//    1 <= grid[r][c] <= 10^5


public class Q2017 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        System.out.println(gridGame(DataConversionMethods.convertIntArrArrayListTo2DArray(data)));
    }

    private static long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[][] p = new long[2][n + 1];
        for (int i = 1; i <= n; i++) {
            p[0][i] = p[0][i - 1] + grid[0][i - 1];
            p[1][i] = p[1][i - 1] + grid[1][i - 1];
        }
        long res = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(p[0][n] - p[0][i], p[1][i - 1]));
        }
        return res;
    }
}
