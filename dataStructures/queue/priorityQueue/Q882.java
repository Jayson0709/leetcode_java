package dataStructures.queue.priorityQueue;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//You are given an undirected graph (the "original graph") with n nodes labeled from 0 to n - 1. You decide to subdivide each edge in the graph into a chain of nodes, with the number of new nodes varying between each edge.
//
//    The graph is given as a 2D array of edges where edges[i] = [u_i, v_i, cnt_i] indicates that there is an edge between nodes u_i and v_i in the original graph, and cnt_i is the total number of new nodes that you will subdivide the edge into. Note that cnt_i == 0 means you will not subdivide the edge.
//
//    To subdivide the edge [u_i, v_i], replace it with (cnt_i + 1) new edges and cnt_i new nodes. The new nodes are x1, x2, ..., x_cnt_i, and the new edges are [u_i, x1], [x1, x2], [x2, x3], ..., [x_cnt_i-1, x_cnt_i], [x_cnt_i, v_i].
//
//    In this new graph, you want to know how many nodes are reachable from the node 0, where a node is reachable if the distance is maxMoves or less.
//
//    Given the original graph and maxMoves, return the number of nodes that are reachable from node 0 in the new graph.
//    
//    Example 1:
//    Input: edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
//    Output: 13
//    Explanation: The edge subdivisions are shown in the image above.
//    The nodes that are reachable are highlighted in yellow.
//    
//    Example 2:
//    Input: edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4
//    Output: 23
//    
//    Example 3:
//    Input: edges = [[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]], maxMoves = 17, n = 5
//    Output: 1
//    Explanation: Node 0 is disconnected from the rest of the graph, so only node 0 is reachable.
//    
//    Constraints:
//    0 <= edges.length <= min(n * (n - 1) / 2, 10^4)
//    edges[i].length == 3
//    0 <= u_i < v_i < n
//    There are no multiple edges in the graph.
//    0 <= cnt_i <= 10^4
//    0 <= maxMoves <= 10^9
//    1 <= n <= 3000


//给你一个无向图（原始图），图中有 n 个节点，编号从 0 到 n - 1 。你决定将图中的每条边 细分 为一条节点链，每条边之间的新节点数各不相同。
//
//    图用由边组成的二维数组 edges 表示，其中 edges[i] = [u_i, v_i, cnt_i] 表示原始图中节点 u_i 和 v_i 之间存在一条边，cnt_i 是将边 细分 后的新节点总数。注意，cnt_i == 0 表示边不可细分。
//
//    要 细分 边 [u_i, v_i] ，需要将其替换为 (cnt_i + 1) 条新边，和 cnt_i 个新节点。新节点为 x1, x2, ..., x_cnt_i ，新边为 [u_i, x1], [x1, x2], [x2, x3], ..., [x_cnt_i+1, x_cnt_i], [x_cnt_i, v_i] 。
//
//    现在得到一个 新的细分图 ，请你计算从节点 0 出发，可以到达多少个节点？如果节点间距离是 maxMoves 或更少，则视为 可以到达 。
//
//    给你原始图和 maxMoves ，返回 新的细分图中从节点 0 出发 可到达的节点数 。
//
//    示例 1：
//    输入：edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
//    输出：13
//    解释：边的细分情况如上图所示。
//    可以到达的节点已经用黄色标注出来。
//
//    示例 2：
//    输入：edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4
//    输出：23
//
//    示例 3：
//    输入：edges = [[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]], maxMoves = 17, n = 5
//    输出：1
//    解释：节点 0 与图的其余部分没有连通，所以只有节点 0 可以到达。
//
//    提示：
//    0 <= edges.length <= min(n * (n - 1) / 2, 10^4)
//    edges[i].length == 3
//    0 <= u_i < v_i < n
//    图中 不存在平行边
//    0 <= cnt_i <= 10^4
//    0 <= maxMoves <= 10^9
//    1 <= n <= 3000


public class Q882 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        int[][] edges = DataConversionMethods.convertIntArrArrayListTo2DArray(data);
        int maxMoves = Integer.parseInt(cin.nextLine().strip());
        int n = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        System.out.println(reachableNodes(edges, maxMoves, n));
    }

    private static int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] adList = new List[n];
        for (int i = 0; i < n; i++) {
            adList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], nodes = edge[2];
            adList[u].add(new int[]{v, nodes});
            adList[v].add(new int[]{u, nodes});
        }
        Map<Integer, Integer> used = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int reachableNodes = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty() && pq.peek()[0] <= maxMoves) {
            int[] pair = pq.poll();
            int step = pair[0], u = pair[1];
            if (!visited.add(u)) {
                continue;
            }
            reachableNodes++;
            for (int[] next : adList[u]) {
                int v = next[0], nodes = next[1];
                if (nodes + step + 1 <= maxMoves && !visited.contains(v)) {
                    pq.offer(new int[]{nodes + step + 1, v});
                }
                used.put(encode(u, v, n), Math.min(nodes, maxMoves - step));
            }
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], nodes = edge[2];
            reachableNodes += Math.min(nodes,
                used.getOrDefault(encode(u, v, n), 0) + used.getOrDefault(encode(v, u, n), 0));
        }
        return reachableNodes;
    }

    public static int encode(int u, int v, int n) {
        return u * n + v;
    }
}
