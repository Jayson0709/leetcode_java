package algorithms.search.dfs;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
//
//    Roads are represented by connections where connections[i] = [a_i, b_i] represents a road from city a_i to city b_i.
//
//    This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
//
//    Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
//
//    It's guaranteed that each city can reach city 0 after reorder.
//
//    Example 1:
//      <-   <-
//    0 -> 1 -> 3 <- 2
//    ^
//    |_ 4 -> 5
//         <-
//    Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
//    Output: 3
//    Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
//
//    Example 2:
//    0 <- 1 -> 2 <- 3 -> 4
//           <-       <-
//    Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
//    Output: 2
//    Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
//
//    Example 3:
//    Input: n = 3, connections = [[1,0],[2,0]]
//    Output: 0
//
//    Constraints:
//    2 <= n <= 5 * 10^4
//    connections.length == n - 1
//    connections[i].length == 2
//    0 <= a_i, b_i <= n - 1
//    a_i != b_i



//n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
//
//    路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
//
//    今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
//
//    请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
//
//    题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
//
//    示例 1：
//      <-   <-
//    0 -> 1 -> 3 <- 2
//    ^
//    |_ 4 -> 5
//         <-
//    输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
//    输出：3
//    解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
//
//    示例 2：
//    0 <- 1 -> 2 <- 3 -> 4
//           <-       <-
//    输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
//    输出：2
//    解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
//
//    示例 3：
//    输入：n = 3, connections = [[1,0],[2,0]]
//    输出：0
//
//    提示：
//    2 <= n <= 5 * 10^4
//    connections.length == n-1
//    connections[i].length == 2
//    0 <= connections[i][0], connections[i][1] <= n-1
//    connections[i][0] != connections[i][1]



public class Q1466 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = Integer.parseInt(cin.nextLine().strip());
        List<int[]> edges = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, edges);
        cin.close();
        System.out.println(minReorder(n, DataConversionMethods.convertIntArrArrayListTo2DArray(edges)));
    }

    private static final Map<Integer, List<int[]>> hMap = new HashMap<>();
    private static boolean[] visited;

    private static void add(int i, int j, int direction) {
        if (!hMap.containsKey(i)) {
            hMap.put(i, new ArrayList<>());
        }
        hMap.get(i).add(new int[]{j, direction});
    }

    private static int minReorder(int n, int[][] connections) {
        for (int[] connection : connections) {
            int i = connection[0], j = connection[1];
            add(i, j, 1);
            add(j, i, 0);
        }
        visited = new boolean[n];
        return dfs(0);
    }

    private static int dfs(int node) {
        visited[node] = true;
        List<int[]> edges = hMap.get(node);
        int cnt = 0;
        for (int[] edge : edges) {
            int child = edge[0], direction = edge[1];
            if (!visited[child]) {
                cnt += direction + dfs(child);
            }
        }
        return cnt;
    }
}

