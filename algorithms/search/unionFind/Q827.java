package algorithms.search.unionFind;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
//
//    Return the size of the largest island in grid after applying this operation.
//
//    An island is a 4-directionally connected group of 1s.
//
//    Example 1:
//    Input: grid = [[1,0],[0,1]]
//    Output: 3
//    Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
//
//    Example 2:
//    Input: grid = [[1,1],[1,0]]
//    Output: 4
//    Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
//
//    Example 3:
//    Input: grid = [[1,1],[1,1]]
//    Output: 4
//    Explanation: Can't change any 0 to 1, only one island with area = 4.
//
//    Constraints:
//    n == grid.length
//    n == grid[i].length
//    1 <= n <= 500
//    grid[i][j] is either 0 or 1.



//
//给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格  0 变成  1 。
//
//    返回执行此操作后，grid 中最大的岛屿面积是多少？
//
//    岛屿 由一组上、下、左、右四个方向相连的  1 形成。
//
//    示例 1:
//    输入: grid = [[1, 0], [0, 1]]
//    输出: 3
//    解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
//
//    示例 2:
//    输入: grid = [[1, 1], [1, 0]]
//    输出: 4
//    解释: 将一格0变成1，岛屿的面积扩大为 4。
//
//    示例 3:
//    输入: grid = [[1, 1], [1, 1]]
//    输出: 4
//    解释: 没有0可以让我们变成1，面积依然为 4。
//
//    提示：
//    n == grid.length
//    n == grid[i].length
//    1 <= n <= 500
//    grid[i][j] 为 0 或 1


public class Q827 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        System.out.println(largestIsland(DataConversionMethods.convertIntArrArrayListTo2DArray(data)));
    }

    // Method 1: use tags and merge - DFS
    // Reference: https://leetcode.cn/problems/making-a-large-island/solution/zui-da-ren-gong-dao-by-leetcode-solution-lehy/
//    static int[] d = {0, -1, 0, 1, 0};
//    private static int largestIsland(int[][] grid) {
//        int n = grid.length, res = 0;
//        int[][] tag = new int[n][n];
//        Map<Integer, Integer> area = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 1 && tag[i][j] == 0) {
//                    int t = i * n + j + 1;
//                    area.put(t, dfs(grid, i, j, tag, t));
//                    res = Math.max(res, area.get(t));
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 0) {
//                    int z = 1;
//                    Set<Integer> connected = new HashSet<>();
//                    for (int k = 0; k < 4; k++) {
//                        int x = i + d[k], y = j + d[k + 1];
//                        if (!valid(n, x, y) || tag[x][y] == 0 || connected.contains(tag[x][y])) {
//                            continue;
//                        }
//                        z += area.get(tag[x][y]);
//                        connected.add(tag[x][y]);
//                    }
//                    res = Math.max(res, z);
//                }
//            }
//        }
//        return res;
//    }
//
//    public static int dfs(int[][] grid, int x, int y, int[][] tag, int t) {
//        int n = grid.length, res = 1;
//        tag[x][y] = t;
//        for (int i = 0; i < 4; i++) {
//            int x1 = x + d[i], y1 = y + d[i + 1];
//            if (valid(n, x1, y1) && grid[x1][y1] == 1 && tag[x1][y1] == 0) {
//                res += dfs(grid, x1, y1, tag, t);
//            }
//        }
//        return res;
//    }
//
//    public static boolean valid(int n, int x, int y) {
//        return x >= 0 && x < n && y >= 0 && y < n;
//    }

    // Method 2: Union Find
    // Reference: https://leetcode.cn/problems/making-a-large-island/solution/by-ac_oier-1kmp/
    static int N = 510;
    static int[] p = new int[N * N], sz = new int[N * N];
    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    static void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return ;
        if (sz[ra] > sz[rb]) {
            union(b, a);
        } else {
            sz[rb] += sz[ra]; p[ra] = p[rb];
        }
    }

    private static int largestIsland(int[][] grid) {
        int n = grid.length;
        for (int i = 1; i <= n * n; i++) {
            p[i] = i; sz[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int[] di : dirs) {
                    int x = i + di[0], y = j + di[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                    union(i * n + j + 1, x * n + y + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, sz[find(i * n + j + 1)]);
                } else {
                    int tot = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int[] di : dirs) {
                        int x = i + di[0],y = j + di[1];
                        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                        int root = find(x * n + y + 1);
                        if (set.contains(root)) continue;
                        tot += sz[root];
                        set.add(root);
                    }
                    ans = Math.max(ans, tot);
                }
            }
        }
        return ans;
    }
}
