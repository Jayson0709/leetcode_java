package algorithms.search.bfs;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//In an n*n grid, there is a snake that spans 2 cells and starts moving from the top left corner at (0, 0) and (0, 1). The grid has empty cells represented by zeros and blocked cells represented by ones. The snake wants to reach the lower right corner at (n-1, n-2) and (n-1, n-1).
//
//    In one move the snake can:
//
//    Move one cell to the right if there are no blocked cells there. This move keeps the horizontal/vertical position of the snake as it is.
//    Move down one cell if there are no blocked cells there. This move keeps the horizontal/vertical position of the snake as it is.
//    Rotate clockwise if it's in a horizontal position and the two cells under it are both empty. In that case the snake moves from (r, c) and (r, c+1) to (r, c) and (r+1, c).
//
//    Rotate counterclockwise if it's in a vertical position and the two cells to its right are both empty. In that case the snake moves from (r, c) and (r+1, c) to (r, c) and (r, c+1).
//
//    Return the minimum number of moves to reach the target.
//
//    If there is no way to reach the target, return -1.
//
//    Example 1:
//    Input: grid = [[0,0,0,0,0,1],
//    [1,1,0,0,1,0],
//    [0,0,0,0,1,1],
//    [0,0,1,0,1,0],
//    [0,1,1,0,0,0],
//    [0,1,1,0,0,0]]
//    Output: 11
//    Explanation:
//    One possible solution is [right, right, rotate clockwise, right, down, down, down, down, rotate counterclockwise, right, down].
//
//    Example 2:
//    Input: grid = [[0,0,1,1,1,1],
//    [0,0,0,0,1,1],
//    [1,1,0,0,0,1],
//    [1,1,1,0,0,1],
//    [1,1,1,0,0,1],
//    [1,1,1,0,0,0]]
//    Output: 9
//
//    Constraints:
//    2 <= n <= 100
//    0 <= grid[i][j] <= 1
//    It is guaranteed that the snake starts at empty cells.


//你还记得那条风靡全球的贪吃蛇吗？
//
//    我们在一个 n*n 的网格上构建了新的迷宫地图，蛇的长度为 2，也就是说它会占去两个单元格。蛇会从左上角（(0, 0) 和 (0, 1)）开始移动。我们用 0 表示空单元格，用 1 表示障碍物。蛇需要移动到迷宫的右下角（(n-1, n-2) 和 (n-1, n-1)）。
//
//    每次移动，蛇可以这样走：
//
//    如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。
//    如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。
//    如果它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度。蛇从（(r, c)、(r, c+1)）移动到 （(r, c)、(r+1, c)）。
//
//    如果它处于竖直状态并且其右面的两个单元都是空的，就逆时针旋转 90 度。蛇从（(r, c)、(r+1, c)）移动到（(r, c)、(r, c+1)）。
//
//    返回蛇抵达目的地所需的最少移动次数。
//
//    如果无法到达目的地，请返回 -1。
//
//    示例 1：
//    输入：grid = [[0,0,0,0,0,1],
//    [1,1,0,0,1,0],
//    [0,0,0,0,1,1],
//    [0,0,1,0,1,0],
//    [0,1,1,0,0,0],
//    [0,1,1,0,0,0]]
//    输出：11
//    解释：
//    一种可能的解决方案是 [右, 右, 顺时针旋转, 右, 下, 下, 下, 下, 逆时针旋转, 右, 下]。
//
//    示例 2：
//    输入：grid = [[0,0,1,1,1,1],
//    [0,0,0,0,1,1],
//    [1,1,0,0,0,1],
//    [1,1,1,0,0,1],
//    [1,1,1,0,0,1],
//    [1,1,1,0,0,0]]
//    输出：9
//
//    提示：
//    2 <= n <= 100
//    0 <= grid[i][j] <= 1
//    蛇保证从空单元格开始出发。


public class Q1210 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> grid = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, grid);
        cin.close();
        System.out.println(minimumMoves(DataConversionMethods.convertIntArrArrayListTo2DArray(grid)));
    }

    // Method 1: BFS
    private static int minimumMoves(int[][] grid) {
        int n = grid.length;
        int[][][] dist = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        dist[0][0][0] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1], status = arr[2];
            if (status == 0) {
                // move one unit to the right
                if (y + 2 < n && dist[x][y + 1][0] == -1 && grid[x][y + 2] == 0) {
                    dist[x][y + 1][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y + 1, 0});
                }
                // move one unit downwards
                if (x + 1 < n && dist[x + 1][y][0] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x + 1][y][0] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x + 1, y, 0});
                }
                // rotate 90 degrees clockwise
                if (x + 1 < n && y + 1 < n && dist[x][y][1] == -1 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][1] = dist[x][y][0] + 1;
                    queue.offer(new int[]{x, y, 1});
                }
            } else {
                // move one unit to the right
                if (y + 1 < n && dist[x][y + 1][1] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y + 1][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y + 1, 1});
                }
                // move one unit downwards
                if (x + 2 < n && dist[x + 1][y][1] == -1 && grid[x + 2][y] == 0) {
                    dist[x + 1][y][1] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x + 1, y, 1});
                }
                // rotate 90 degrees counter-clockwise
                if (x + 1 < n && y + 1 < n && dist[x][y][0] == -1 && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    dist[x][y][0] = dist[x][y][1] + 1;
                    queue.offer(new int[]{x, y, 0});
                }
            }
        }
        return dist[n - 1][n - 2][0];
    }

    // Method 2: Dynamic Programming
//    static final int INVALID = Integer.MAX_VALUE / 2;

//    private static int minimumMoves(int[][] grid) {
//        int n = grid.length;
//        int[][][] f = new int[n][n][2];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                Arrays.fill(f[i][j], INVALID);
//            }
//        }
//        f[0][0][0] = 0;
//
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                boolean canHorizontal = (j + 1 < n && grid[i][j] == 0 && grid[i][j + 1] == 0);
//                boolean canVertical = (i + 1 < n && grid[i][j] == 0 && grid[i + 1][j] == 0);
//                if (i - 1 >= 0 && canHorizontal) {
//                    f[i][j][0] = Math.min(f[i][j][0], f[i - 1][j][0] + 1);
//                }
//                if (j - 1 >= 0 && canHorizontal) {
//                    f[i][j][0] = Math.min(f[i][j][0], f[i][j - 1][0] + 1);
//                }
//                if (i - 1 >= 0 && canVertical) {
//                    f[i][j][1] = Math.min(f[i][j][1], f[i - 1][j][1] + 1);
//                }
//                if (j - 1 >= 0 && canVertical) {
//                    f[i][j][1] = Math.min(f[i][j][1], f[i][j - 1][1] + 1);
//                }
//                if (canHorizontal && canVertical && grid[i + 1][j + 1] == 0) {
//                    f[i][j][0] = Math.min(f[i][j][0], f[i][j][1] + 1);
//                    f[i][j][1] = Math.min(f[i][j][1], f[i][j][0] + 1);
//                }
//            }
//        }
//        return (f[n - 1][n - 2][0] == INVALID ? -1 : f[n - 1][n - 2][0]);
//    }
}
