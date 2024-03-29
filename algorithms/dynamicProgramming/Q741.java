package algorithms.dynamicProgramming;
import utils.DataConversionMethods;
import utils.InputMethods;

import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.
//    0 means the cell is empty, so you can pass through,
//    1 means the cell contains a cherry that you can pick up and pass through, or
//    -1 means the cell contains a thorn that blocks your way.
//
//    Return the maximum number of cherries you can collect by following the rules below:
//      Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
//      After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
//      When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
//      If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
//
//    Example 1:
//    |__|c_|x_|
//    |c_|__|x_|
//    |c_|c_|c_|
//    Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]]
//    Output: 5
//    Explanation: The player started at (0, 0) and went down, down, right right to reach (2, 2).
//    4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
//    Then, the player went left, up, up, left to return home, picking up one more cherry.
//    The total number of cherries picked up is 5, and this is the maximum possible.
//
//    Example 2:
//    Input: grid = [[1,1,-1],[1,-1,1],[-1,1,1]]
//    Output: 0
//
//
//    Constraints:
//        n == grid.length
//        n == grid[i].length
//        1 <= n <= 50
//        grid[i][j] is -1, 0, or 1.
//        grid[0][0] != -1
//        grid[n - 1][n - 1] != -1


//一个N x N的网格(grid)代表了一块樱桃地，每个格子由以下三种数字的一种来表示：
//        0 表示这个格子是空的，所以你可以穿过它。
//        1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
//        -1 表示这个格子里有荆棘，挡着你的路。
//    你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：
//        从位置(0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
//        当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
//        当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
//        如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
//
//    示例 1:
//
//    输入: grid =
//    [[0, 1, -1],
//    [1, 0, -1],
//    [1, 1,  1]]
//    输出: 5
//    解释：
//    玩家从（0,0）点出发，经过了向下走，向下走，向右走，向右走，到达了点(2, 2)。
//    在这趟单程中，总共摘到了4颗樱桃，矩阵变成了[[0,1,-1],[0,0,-1],[0,0,0]]。
//    接着，这名玩家向左走，向上走，向上走，向左走，返回了起始点，又摘到了1颗樱桃。
//    在旅程中，总共摘到了5颗樱桃，这是可以摘到的最大值了。
//
//    说明:
//    grid 是一个N * N 的二维数组，N的取值范围是1 <= N <= 50。
//    每一个grid[i][j] 都是集合{-1, 0, 1}其中的一个数。
//    可以保证起点grid[0][0]和终点grid[N-1][N-1]的值都不会是 -1。



public class Q741 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        int result = cherryPickup(DataConversionMethods.convertIntArrArrayListTo2DArray(data));
        System.out.println(result);
    }

    private static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[n * 2 - 1][n][n];
        for (int i = 0; i < n * 2 - 1; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(f[i][j], Integer.MIN_VALUE);
            }
        }
        f[0][0][0] = grid[0][0];
        for (int k = 1; k < n * 2 - 1; ++k) {
            for (int x1 = Math.max(k - n + 1, 0); x1 <= Math.min(k, n - 1); ++x1) {
                int y1 = k - x1;
                if (grid[x1][y1] == -1) {
                    continue;
                }
                for (int x2 = x1; x2 <= Math.min(k, n - 1); ++x2) {
                    int y2 = k - x2;
                    if (grid[x2][y2] == -1) {
                        continue;
                    }
                    int res = f[k - 1][x1][x2]; // right
                    if (x1 > 0) {
                        res = Math.max(res, f[k - 1][x1 - 1][x2]); // down, and right
                    }
                    if (x2 > 0) {
                        res = Math.max(res, f[k - 1][x1][x2 - 1]); // right, and down
                    }
                    if (x1 > 0 && x2 > 0) {
                        res = Math.max(res, f[k - 1][x1 - 1][x2 - 1]); // all down
                    }
                    res += grid[x1][y1];
                    if (x2 != x1) { // avoid for the same cherry
                        res += grid[x2][y2];
                    }
                    f[k][x1][x2] = res;
                }
            }
        }
        return Math.max(f[n * 2 - 2][n - 1][n - 1], 0);
    }
}
