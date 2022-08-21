package algorithms.search.bfs;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.
//
//    You are given two arrays redEdges and blueEdges where:
//
//    redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
//    blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
//    Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.
//
//    Example 1:
//    Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
//    Output: [0,1,-1]
//
//    Example 2:
//    Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
//    Output: [0,1,-1]
//
//    Constraints:
//    1 <= n <= 100
//    0 <= redEdges.length,blueEdges.length <= 400
//    redEdges[i].length == blueEdges[j].length == 2
//    0 <= a_i, b_i, u_j, v_j < n



//在一个有向图中，节点分别标记为0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
//
//    red_edges中的每一个[i, j]对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges中的每一个[i, j]对表示从节点 i 到节点 j 的蓝色有向边。
//
//    返回长度为 n 的数组answer，其中answer[X]是从节点0到节点X的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
//
//    示例 1：
//    输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//    输出：[0,1,-1]
//
//    示例 2：
//    输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//    输出：[0,1,-1]
//
//    示例 3：
//    输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
//    输出：[0,-1,-1]
//
//    示例 4：
//    输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
//    输出：[0,1,2]
//
//    示例 5：
//    输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
//    输出：[0,1,1]
//
//    提示：
//    1 <= n <= 100
//    red_edges.length <= 400
//    blue_edges.length <= 400
//    red_edges[i].length == blue_edges[i].length == 2
//    0 <= red_edges[i][j], blue_edges[i][j] < n



public class Q1129 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = Integer.parseInt(cin.nextLine().strip());
        String[] redEdgesData = cin.nextLine().strip().split(" ");
        String[] blueEdgesData = cin.nextLine().strip().split(" ");
        cin.close();
        int[][] redEdges = new int[redEdgesData.length][];
        int[][] blueEdges = new int[blueEdgesData.length][];
        for (int i = 0; i < redEdgesData.length; i++) {
            redEdges[i] = Arrays.stream(redEdgesData[i].split(",")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < blueEdgesData.length; i++) {
            blueEdges[i] = Arrays.stream(blueEdgesData[i].split(",")).mapToInt(Integer::parseInt).toArray();
        }
        StringBuilder output = new StringBuilder();
        output.append("[");
        int[] result = shortestAlternatingPaths(n, redEdges, blueEdges);
        output.append(result[0]);
        for (int i = 1; i < result.length; i++) {
            output.append(", ").append(result[i]);
        }
        output.append("]");
        System.out.println(output);
    }

    private static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redMapEdges = new ArrayList<>();
        List<List<Integer>> blueMapEdges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            redMapEdges.add(new ArrayList<>());
            blueMapEdges.add(new ArrayList<>());
        }
        for (int[] edge : redEdges) {
            redMapEdges.get(edge[0]).add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            blueMapEdges.get(edge[0]).add(edge[1]);
        }

        int[][] opt = new int[2][n];
        Arrays.fill(opt[0], -1);
        Arrays.fill(opt[1], -1);

        opt[0][0] = opt[1][0] = 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int source = cur[0];
            // Start with a red edge
            if (cur[1] == 0) {
                List<Integer> arr = redMapEdges.get(source);
                for (int v: arr) {
                    if (opt[1][v]== -1) {
                        opt[1][v] = opt[0][source] + 1;
                        queue.offer(new int[]{v, 1});
                    }
                }
            } else {
                // Start with a blue edge
                List<Integer> arr = blueMapEdges.get(source);
                for (int v: arr) {
                    if (opt[0][v] == -1) {
                        opt[0][v] = opt[1][source] + 1;
                        queue.offer(new int[]{v, 0});
                    }
                }
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (opt[0][i] == -1 || opt[1][i] == -1) {
                result[i] = Math.max(opt[0][i], opt[1][i]);
            } else {
                result[i] = Math.min(opt[0][i], opt[1][i]);
            }
        }
        return result;
    }
}
