package algorithms.search.bfs;
import java.util.*;
import java.nio.charset.StandardCharsets;
import utils.OutputMethods;


//Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
//
//    The distance between two adjacent cells is 1.
//
//    Example 1:
//    |0|0|0|
//    |0|1|0|
//    |0|0|0|
//    Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//    Output: [[0,0,0],[0,1,0],[0,0,0]]
//
//    Example 2:
//    |0|0|0|
//    |0|1|0|
//    |1|1|1|
//    Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//    Output: [[0,0,0],[0,1,0],[1,2,1]]
//
//    Constraints:
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n <= 10^4
//    1 <= m * n <= 10^4
//    mat[i][j] is either 0 or 1.
//    There is at least one 0 in mat.



//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//
//    两个相邻元素间的距离为 1 。
//
//    示例 1：
//    |0|0|0|
//    |0|1|0|
//    |0|0|0|
//    输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//    输出：[[0,0,0],[0,1,0],[0,0,0]]
//
//    示例 2：
//    |0|0|0|
//    |0|1|0|
//    |1|1|1|
//    输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//    输出：[[0,0,0],[0,1,0],[1,2,1]]
//
//    提示：
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n <= 10^4
//    1 <= m * n <= 10^4
//    mat[i][j] is either 0 or 1.
//    mat 中至少有一个 0 



public class Q542 {
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
        int[][] mat = new int[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            mat[i] = data.get(i);
        }
        int[][] result = updateMatrix(mat);
        OutputMethods.output2DIntArrayData(result);
    }

    // Method 1: BFS
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // Add all 0 into the initial queue
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; ++d) {
                int ni = i + directions[d][0];
                int nj = j + directions[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }
        return dist;
    }


    // Method 2: Dynamic Programming - Version 1
//    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//    public static int[][] updateMatrix(int[][] matrix) {
//        int m = matrix.length, n = matrix[0].length;
//        // initiate the dp array.
//        int[][] dist = new int[m][n];
//        for (int i = 0; i < m; ++i) {
//            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
//        }
//        // if (i, j) is 0，then the distance is 0
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (matrix[i][j] == 0) {
//                    dist[i][j] = 0;
//                }
//            }
//        }
//
//        // Only move horizontally to the left and vertically to the top
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (i - 1 >= 0) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
//                }
//                if (j - 1 >= 0) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
//                }
//            }
//        }
//
//        // Only move horizontally to the left and vertically to the bottom
//        for (int i = m - 1; i >= 0; --i) {
//            for (int j = 0; j < n; ++j) {
//                if (i + 1 < m) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
//                }
//                if (j - 1 >= 0) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
//                }
//            }
//        }
//        // Only move horizontally to the right and vertically to the top
//        for (int i = 0; i < m; ++i) {
//            for (int j = n - 1; j >= 0; --j) {
//                if (i - 1 >= 0) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
//                }
//                if (j + 1 < n) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i ][j + 1] + 1);
//                }
//            }
//        }
//
//        // Only move horizontally to the right and vertically to the bottom
//        for (int i = m - 1; i >= 0; --i) {
//            for (int j = n - 1; j >= 0; --j) {
//                if (i + 1 < m) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
//                }
//                if (j + 1 < n) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
//                }
//            }
//        }
//        return dist;
//    }

    // Method 3: Dynamic Programming - Version 2
//    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//    public static int[][] updateMatrix(int[][] matrix) {
//        int m = matrix.length, n = matrix[0].length;
//        // initiate the DP array
//        int[][] dist = new int[m][n];
//        for (int i = 0; i < m; ++i) {
//            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
//        }
//        // if (i, j) is 0，then distance is 0
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (matrix[i][j] == 0) {
//                    dist[i][j] = 0;
//                }
//            }
//        }
//        // Only move horizontally to the left and vertically to the top
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (i - 1 >= 0) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
//                }
//                if (j - 1 >= 0) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
//                }
//            }
//        }
//        // Only move horizontally to the right and vertically to the bottom
//        for (int i = m - 1; i >= 0; --i) {
//            for (int j = n - 1; j >= 0; --j) {
//                if (i + 1 < m) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
//                }
//                if (j + 1 < n) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
//                }
//            }
//        }
//        return dist;
//    }
}
