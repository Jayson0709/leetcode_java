package algorithms.search.bfs;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
//
//    An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
//
//    You may change 0's to 1's to connect the two islands to form one island.
//
//    Return the smallest number of 0's you must flip to connect the two islands.
//
//    Example 1:
//    Input: grid = [[0,1],[1,0]]
//    Output: 1
//
//    Example 2:
//    Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
//    Output: 2
//
//    Example 3:
//    Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//    Output: 1
//
//    Constraints:
//    n == grid.length == grid[i].length
//    2 <= n <= 100
//    grid[i][j] is either 0 or 1.
//    There are exactly two islands in grid.



//给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
//
//    岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
//
//    你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
//
//    返回必须翻转的 0 的最小数目。
//
//    示例 1：
//    输入：grid = [[0,1],[1,0]]
//    输出：1
//
//    示例 2：
//    输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
//    输出：2
//
//    示例 3：
//    输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//    输出：1
//
//    提示：
//    n == grid.length == grid[i].length
//    2 <= n <= 100
//    grid[i][j] 为 0 或 1
//    grid 中恰有两个岛



public class Q934 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        System.out.println(shortestBridge(DataConversionMethods.convertIntArrArrayListTo2DArray(data)));
    }

    private static int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        List<int[]> island = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        island.add(cell);
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dirs[k][0];
                            int ny = y + dirs[k][1];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1) {
                                queue.offer(new int[]{nx, ny});
                                grid[nx][ny] = -1;
                            }
                        }
                    }
                    for (int[] cell : island) {
                        queue.offer(cell);
                    }
                    int step = 0;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                    if (grid[nx][ny] == 0) {
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }
}
