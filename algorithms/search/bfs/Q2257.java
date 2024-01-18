package algorithms.search.bfs;

import utils.DataConversionMethods;
import utils.InputMethods;
import utils.TwoIntAndOne2DArray;

import java.nio.charset.StandardCharsets;
import java.util.*;


//You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [row_i, col_i] and walls[j] = [row_j, col_j] represent the positions of the ith guard and jth wall respectively.
//
//    A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
//
//    Return the number of unoccupied cells that are not guarded.
//    
//    Example 1:
//    X means Red
//    O means Green
//    |G|W|O|X|O|O|
//    |X|G|X|X|W|O|
//    |X|X|W|G|X|X|
//    |X|X|O|X|O|O|
//    Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
//    Output: 7
//    Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
//    There are a total of 7 unguarded cells, so we return 7.
//    
//    Example 2:
//    X means Red
//    O means Green
//    |O|W|O|
//    |W|G|W|
//    |O|W|O|
//    Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
//    Output: 4
//    Explanation: The unguarded cells are shown in green in the above diagram.
//    There are a total of 4 unguarded cells, so we return 4.
//    
//    Constraints:
//    1 <= m, n <= 10^5
//    2 <= m * n <= 10^5
//    1 <= guards.length, walls.length <= 5 * 10^4
//    2 <= guards.length + walls.length <= m * n
//    guards[i].length == walls[j].length == 2
//    0 <= row_i, row_j < m
//    0 <= col_i, col_j < n
//    All the positions in guards and walls are unique.


//给你两个整数 m 和 n 表示一个下标从 0 开始的 m x n 网格图。同时给你两个二维整数数组 guards 和 walls ，其中 guards[i] = [row_i, col_i] 且 walls[j] = [row_j, col_j] ，分别表示第 i 个警卫和第 j 座墙所在的位置。
//
//    一个警卫能看到 4 个坐标轴方向（即东、南、西、北）的 所有 格子，除非他们被一座墙或者另外一个警卫 挡住 了视线。如果一个格子能被 至少 一个警卫看到，那么我们说这个格子被 保卫 了。
//
//    请你返回空格子中，有多少个格子是 没被保卫 的。
//
//    示例 1：
//    X 为红色
//    O 为绿色
//    |G|W|O|X|O|O|
//    |X|G|X|X|W|O|
//    |X|X|W|G|X|X|
//    |X|X|O|X|O|O|
//    输入：m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
//    输出：7
//    解释：上图中，被保卫和没有被保卫的格子分别用红色和绿色表示。
//    总共有 7 个没有被保卫的格子，所以我们返回 7 。
//    
//    示例 2：
//    X means Red
//    O means Green
//    |O|W|O|
//    |W|G|W|
//    |O|W|O|
//    输入：m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
//    输出：4
//    解释：上图中，没有被保卫的格子用绿色表示。
//    总共有 4 个没有被保卫的格子，所以我们返回 4 。
//    
//    提示：
//    1 <= m, n <= 10^5
//    2 <= m * n <= 10^5
//    1 <= guards.length, walls.length <= 5 * 10^4
//    2 <= guards.length + walls.length <= m * n
//    guards[i].length == walls[j].length == 2
//    0 <= row_i, row_j < m
//    0 <= col_i, col_j < n
//    guards 和 walls 中所有位置 互不相同 。


public class Q2257 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoIntAndOne2DArray obj = InputMethods.getInputForTwoIntAndOneInt2DArray(cin);
        List<int[]> wall_list = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, wall_list);
        int[][] walls = DataConversionMethods.convertIntArrArrayListTo2DArray(wall_list);
        cin.close();
        System.out.println(countUnguarded(obj.val1, obj.val2, obj.array, walls));
    }

    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    private static final int GUARD = -1;
    private static final int WALL = -2;

    private static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = GUARD;
            for (int i = 0; i < 4; i++) {
                queue.offer(new int[]{guard[0], guard[1], i});
            }
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = WALL;
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nx = poll[0] + DIRS[poll[2]][0], ny = poll[1] + DIRS[poll[2]][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] >= 0 && (grid[nx][ny] & (1 << poll[2])) == 0) {
                grid[nx][ny] |= (1 << poll[2]);
                queue.offer(new int[]{nx, ny, poll[2]});
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
