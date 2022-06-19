package algorithms.searching;
import java.util.*;
import java.nio.charset.StandardCharsets;

//There is a bidirectional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
//
//    You want to determine if there is a valid path that exists from vertex source to vertex destination.
//
//    Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
//
//    Example 1:
//    Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
//    Output: true
//    Explanation: There are two paths from vertex 0 to vertex 2:
//    - 0 → 1 → 2
//    - 0 → 2
//
//    Example 2:
//    Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
//    Output: false
//    Explanation: There is no path from vertex 0 to vertex 5.
//
//    Constraints:
//    1 <= n <= 2 * 105
//    0 <= edges.length <= 2 * 105
//    edges[i].length == 2
//    0 <= ui, vi <= n - 1
//    ui != vi
//    0 <= source, destination <= n - 1
//    There are no duplicate edges.
//    There are no self edges.


//有一个具有 n个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
//
//    请你确定是否存在从顶点 start 开始，到顶点 end 结束的 有效路径 。
//
//    给你数组 edges 和整数 n、start和end，如果从 start 到 end 存在 有效路径 ，则返回 true，否则返回 false 。
//
//    示例 1：
//    输入：n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
//    输出：true
//    解释：存在由顶点 0 到顶点 2 的路径:
//    - 0 → 1 → 2
//    - 0 → 2
//
//    示例 2：
//    输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
//    输出：false
//    解释：不存在由顶点 0 到顶点 5 的路径.
//
//    提示:
//    1 <= n <= 2 * 105
//    0 <= edges.length <= 2 * 105
//    edges[i].length == 2
//    0 <= ui, vi <= n - 1
//    ui != vi
//    0 <= start, end <= n - 1
//    不存在双向边
//    不存在指向顶点自身的边


public class Q1971 {

    private static int[] root;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int n = Integer.parseInt(cin.nextLine().strip());
        int[][] edges = new int[n][2];
        for (int i = 0; i < n; i++) {
            edges[i] = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int source = cin.nextInt();
        int destination = cin.nextInt();
        cin.close();

        boolean result = validPath(n, edges, source, destination);
        System.out.println(result);
    }

    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
            System.out.println(find(destination));
            if (find(source) == find(destination)) {
                return true;
            }
        }
        return find(source) == find(destination);
    }

    private static void union(int p, int q) {
        root[find(p)] = find(q);
    }

    private static int find(int n) {
        if (root[n] == n) {
            return n;
        } else {
            root[n] = find(root[n]);
            return root[n];
        }
    }
}
