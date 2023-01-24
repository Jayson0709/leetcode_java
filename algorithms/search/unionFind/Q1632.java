package algorithms.search.unionFind;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given an m x n matrix, return a new matrix answer where answer[row][col] is the rank of matrix[row][col].
//
//    The rank is an integer that represents how large an element is compared to other elements. It is calculated using the following rules:
//
//    The rank is an integer starting from 1.
//    If two elements p and q are in the same row or column, then:
//    If p < q then rank(p) < rank(q)
//    If p == q then rank(p) == rank(q)
//    If p > q then rank(p) > rank(q)
//    The rank should be as small as possible.
//    The test cases are generated so that answer is unique under the given rules.
//
//    Example 1:
//    Input: matrix = [[1,2],[3,4]]
//    Output: [[1,2],[2,3]]
//    Explanation:
//    The rank of matrix[0][0] is 1 because it is the smallest integer in its row and column.
//    The rank of matrix[0][1] is 2 because matrix[0][1] > matrix[0][0] and matrix[0][0] is rank 1.
//    The rank of matrix[1][0] is 2 because matrix[1][0] > matrix[0][0] and matrix[0][0] is rank 1.
//    The rank of matrix[1][1] is 3 because matrix[1][1] > matrix[0][1], matrix[1][1] > matrix[1][0], and both matrix[0][1] and matrix[1][0] are rank 2.
//
//    Example 2:
//    Input: matrix = [[7,7],[7,7]]
//    Output: [[1,1],[1,1]]
//
//    Example 3:
//    Input: matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]
//    Output: [[4,2,3],[1,3,4],[5,1,6],[1,3,4]]
//
//    Constraints:
//    m == matrix.length
//    n == matrix[i].length
//    1 <= m, n <= 500
//    -10^9 <= matrix[row][col] <= 10^9


//给你一个 m x n 的矩阵 matrix ，请你返回一个新的矩阵 answer ，其中 answer[row][col] 是 matrix[row][col] 的秩。
//
//    每个元素的 秩 是一个整数，表示这个元素相对于其他元素的大小关系，它按照如下规则计算：
//
//    秩是从 1 开始的一个整数。
//    如果两个元素 p 和 q 在 同一行 或者 同一列 ，那么：
//    如果 p < q ，那么 rank(p) < rank(q)
//    如果 p == q ，那么 rank(p) == rank(q)
//    如果 p > q ，那么 rank(p) > rank(q)
//    秩 需要越 小 越好。
//    题目保证按照上面规则 answer 数组是唯一的。
//
//    示例 1：
//    输入：matrix = [[1,2],[3,4]]
//    输出：[[1,2],[2,3]]
//    解释：
//    matrix[0][0] 的秩为 1 ，因为它是所在行和列的最小整数。
//    matrix[0][1] 的秩为 2 ，因为 matrix[0][1] > matrix[0][0] 且 matrix[0][0] 的秩为 1 。
//    matrix[1][0] 的秩为 2 ，因为 matrix[1][0] > matrix[0][0] 且 matrix[0][0] 的秩为 1 。
//    matrix[1][1] 的秩为 3 ，因为 matrix[1][1] > matrix[0][1]， matrix[1][1] > matrix[1][0] 且 matrix[0][1] 和 matrix[1][0] 的秩都为 2 。
//
//    示例 2：
//    输入：matrix = [[7,7],[7,7]]
//    输出：[[1,1],[1,1]]
//
//    示例 3：
//    输入：matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]
//    输出：[[4,2,3],[1,3,4],[5,1,6],[1,3,4]]
//
//    示例 4：
//    输入：matrix = [[7,3,6],[1,4,5],[9,8,2]]
//    输出：[[5,1,4],[1,2,3],[6,3,1]]
//
//    提示：
//    m == matrix.length
//    n == matrix[i].length
//    1 <= m, n <= 500
//    -10^9 <= matrix[row][col] <= 10^9


public class Q1632 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> matrix = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, matrix);
        cin.close();
        int[][] result = matrixRankTransform(DataConversionMethods.convertIntArrArrayListTo2DArray(matrix));
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    static class UnionFind {
        int m;
        int n;
        int[][][] root;
        int[][] size;

        public UnionFind(int m, int n) {
            this.m = m;
            this.n = n;
            this.root = new int[m][n][2];
            this.size = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    root[i][j][0] = i;
                    root[i][j][1] = j;
                    size[i][j] = 1;
                }
            }
        }

        public int[] find(int i, int j) {
            int[] rootArr = root[i][j];
            int ri = rootArr[0], rj = rootArr[1];
            if (ri == i && rj == j) {
                return rootArr;
            }
            return find(ri, rj);
        }

        public void union(int i1, int j1, int i2, int j2) {
            int[] rootArr1 = find(i1, j1);
            int[] rootArr2 = find(i2, j2);
            int ri1 = rootArr1[0], rj1 = rootArr1[1];
            int ri2 = rootArr2[0], rj2 = rootArr2[1];
            if (ri1 != ri2 || rj1 != rj2) {
                if (size[ri1][rj1] >= size[ri2][rj2]) {
                    root[ri2][rj2][0] = ri1;
                    root[ri2][rj2][1] = rj1;
                    size[ri1][rj1] += size[ri2][rj2];
                } else {
                    root[ri1][rj1][0] = ri2;
                    root[ri1][rj1][1] = rj2;
                    size[ri2][rj2] += size[ri1][rj1];
                }
            }
        }
    }

    private static int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        UnionFind uf = new UnionFind(m, n);
        for (int i = 0; i < m; i++) {
            Map<Integer, List<int[]>> num2indexList = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                num2indexList.putIfAbsent(num, new ArrayList<>());
                num2indexList.get(num).add(new int[]{i, j});
            }
            for (List<int[]> indexList : num2indexList.values()) {
                int[] arr1 = indexList.get(0);
                int i1 = arr1[0], j1 = arr1[1];
                for (int k = 1; k < indexList.size(); k++) {
                    int[] arr2 = indexList.get(k);
                    int i2 = arr2[0], j2 = arr2[1];
                    uf.union(i1, j1, i2, j2);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            Map<Integer, List<int[]>> num2indexList = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int num = matrix[i][j];
                num2indexList.putIfAbsent(num, new ArrayList<>());
                num2indexList.get(num).add(new int[]{i, j});
            }
            for (List<int[]> indexList : num2indexList.values()) {
                int[] arr1 = indexList.get(0);
                int i1 = arr1[0], j1 = arr1[1];
                for (int k = 1; k < indexList.size(); k++) {
                    int[] arr2 = indexList.get(k);
                    int i2 = arr2[0], j2 = arr2[1];
                    uf.union(i1, j1, i2, j2);
                }
            }
        }

        int[][] degree = new int[m][n];
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < m; i++) {
            Map<Integer, int[]> num2index = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                num2index.put(num, new int[]{i, j});
            }
            List<Integer> sortedArray = new ArrayList<>(num2index.keySet());
            Collections.sort(sortedArray);
            for (int k = 1; k < sortedArray.size(); k++) {
                int[] prev = num2index.get(sortedArray.get(k - 1));
                int[] curr = num2index.get(sortedArray.get(k));
                int i1 = prev[0], j1 = prev[1], i2 = curr[0], j2 = curr[1];
                int[] root1 = uf.find(i1, j1);
                int[] root2 = uf.find(i2, j2);
                int ri1 = root1[0], rj1 = root1[1], ri2 = root2[0], rj2 = root2[1];
                degree[ri2][rj2]++;
                adj.putIfAbsent(ri1 * n + rj1, new ArrayList<>());
                adj.get(ri1 * n + rj1).add(new int[]{ri2, rj2});
            }
        }
        for (int j = 0; j < n; j++) {
            Map<Integer, int[]> num2index = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int num = matrix[i][j];
                num2index.put(num, new int[]{i, j});
            }
            List<Integer> sortedArray = new ArrayList<>(num2index.keySet());
            Collections.sort(sortedArray);
            for (int k = 1; k < sortedArray.size(); k++) {
                int[] prev = num2index.get(sortedArray.get(k - 1));
                int[] curr = num2index.get(sortedArray.get(k));
                int i1 = prev[0], j1 = prev[1], i2 = curr[0], j2 = curr[1];
                int[] root1 = uf.find(i1, j1);
                int[] root2 = uf.find(i2, j2);
                int ri1 = root1[0], rj1 = root1[1], ri2 = root2[0], rj2 = root2[1];
                degree[ri2][rj2]++;
                adj.putIfAbsent(ri1 * n + rj1, new ArrayList<>());
                adj.get(ri1 * n + rj1).add(new int[]{ri2, rj2});
            }
        }

        Set<Integer> rootSet = new HashSet<>();
        int[][] ranks = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] rootArr = uf.find(i, j);
                int ri = rootArr[0], rj = rootArr[1];
                rootSet.add(ri * n + rj);
                ranks[ri][rj] = 1;
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int val : rootSet) {
            if (degree[val / n][val % n] == 0) {
                queue.offer(new int[]{val / n, val % n});
            }
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int i = arr[0], j = arr[1];
            for (int[] adjArr : adj.getOrDefault(i * n + j, new ArrayList<>())) {
                int ui = adjArr[0], uj = adjArr[1];
                degree[ui][uj]--;
                if (degree[ui][uj] == 0) {
                    queue.offer(new int[]{ui, uj});
                }
                ranks[ui][uj] = Math.max(ranks[ui][uj], ranks[i][j] + 1);
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] rootArr = uf.find(i, j);
                int ri = rootArr[0], rj = rootArr[1];
                res[i][j] = ranks[ri][rj];
            }
        }
        return res;
    }
}
