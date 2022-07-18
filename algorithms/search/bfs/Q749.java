package algorithms.search.bfs;
import java.util.*;
import java.nio.charset.StandardCharsets;


//A virus is spreading rapidly, and your task is to quarantine the infected area by installing walls.
//
//    The world is modeled as an m x n binary grid isInfected, where isInfected[i][j] == 0 represents uninfected cells, and isInfected[i][j] == 1 represents cells contaminated with the virus. A wall (and only one wall) can be installed between any two 4-directionally adjacent cells, on the shared boundary.
//
//    Every night, the virus spreads to all neighboring cells in all four directions unless blocked by a wall. Resources are limited. Each day, you can install walls around only one region (i.e., the affected area (continuous block of infected cells) that threatens the most uninfected cells the following night). There will never be a tie.
//
//    Return the number of walls used to quarantine all the infected regions. If the world will become fully infected, return the number of walls used.
//
//    Example 1:
//    | |x| | | | | |x|
//    | |x| | | | | |x|
//    | | | | | | | |x|
//    | | | | | | | | |
//    Input: isInfected = [[0,1,0,0,0,0,0,1],[0,1,0,0,0,0,0,1],[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0]]
//    Output: 10
//    Explanation: There are 2 contaminated regions.
//    On the first day, add 5 walls to quarantine the viral region on the left. The board after the virus spreads is:
//    | |x| | | | |x|x|
//    | |x| | | | |x|x|
//    | | | | | | |x|x|
//    | | | | | | | |x|
//    On the second day, add 5 walls to quarantine the viral region on the right. The virus is fully contained.
//    | |x| | | | |x|x|
//    | |x| | | | |x|x|
//    | | | | | | |x|x|
//    | | | | | | | |x|
//
//    Example 2:
//    |x|x|x|        |x|x|x|
//    |x| |x|    ->  |x| |x|
//    |x|x|x|        |x|x|x|
//    Input: isInfected = [[1,1,1],[1,0,1],[1,1,1]]
//    Output: 4
//    Explanation: Even though there is only one cell saved, there are 4 walls built.
//    Notice that walls are only built on the shared boundary of two different cells.
//
//    Example 3:
//    Input: isInfected = [[1,1,1,0,0,0,0,0,0],[1,0,1,0,1,1,1,1,1],[1,1,1,0,0,0,0,0,0]]
//    Output: 13
//    Explanation: The region on the left only builds two new walls.
//
//    Constraints:
//    m ==isInfected.length
//    n ==isInfected[i].length
//    1 <= m, n <= 50
//    isInfected[i][j] is either 0 or 1.
//    There is always a contiguous viral region throughout the described process that will infect strictly more uncontaminated squares in the next round.
//
//
//
//病毒扩散得很快，现在你的任务是尽可能地通过安装防火墙来隔离病毒。
//
//    假设世界由m x n的二维矩阵isInfected组成，isInfected[i][j] == 0表示该区域未感染病毒，而 isInfected[i][j] == 1表示该区域已感染病毒。可以在任意 2 个相邻单元之间的共享边界上安装一个防火墙（并且只有一个防火墙）。
//
//    每天晚上，病毒会从被感染区域向相邻未感染区域扩散，除非被防火墙隔离。现由于资源有限，每天你只能安装一系列防火墙来隔离其中一个被病毒感染的区域（一个区域或连续的一片区域），且该感染区域对未感染区域的威胁最大且 保证唯一。
//
//    你需要努力使得最后有部分区域不被病毒感染，如果可以成功，那么返回需要使用的防火墙个数; 如果无法实现，则返回在世界被病毒全部感染时已安装的防火墙个数。
//
//    示例 1：
//    | |x| | | | | |x|
//    | |x| | | | | |x|
//    | | | | | | | |x|
//    | | | | | | | | |
//    输入: isInfected = [[0,1,0,0,0,0,0,1],[0,1,0,0,0,0,0,1],[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0]]
//    输出: 10
//    解释:一共有两块被病毒感染的区域。
//    在第一天，添加 5 墙隔离病毒区域的左侧。病毒传播后的状态是:
//    | |x| | | | |x|x|
//    | |x| | | | |x|x|
//    | | | | | | |x|x|
//    | | | | | | | |x|
//    第二天，在右侧添加 5 个墙来隔离病毒区域。此时病毒已经被完全控制住了。
//    | |x| | | | |x|x|
//    | |x| | | | |x|x|
//    | | | | | | |x|x|
//    | | | | | | | |x|
//
//    示例 2：
//    |x|x|x|        |x|x|x|
//    |x| |x|    ->  |x| |x|
//    |x|x|x|        |x|x|x|
//    输入: isInfected = [[1,1,1],[1,0,1],[1,1,1]]
//    输出: 4
//    解释: 虽然只保存了一个小区域，但却有四面墙。
//    注意，防火墙只建立在两个不同区域的共享边界上。
//
//    示例3:
//
//    输入: isInfected = [[1,1,1,0,0,0,0,0,0],[1,0,1,0,1,1,1,1,1],[1,1,1,0,0,0,0,0,0]]
//    输出: 13
//    解释: 在隔离右边感染区域后，隔离左边病毒区域只需要 2 个防火墙。
//
//    提示:
//    m ==isInfected.length
//    n ==isInfected[i].length
//    1 <= m, n <= 50
//    isInfected[i][j]is either 0 or 1
//    在整个描述的过程中，总有一个相邻的病毒区域，它将在下一轮 严格地感染更多未受污染的方块



public class Q749 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        List<int[]> data = new ArrayList<>();
        while(true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            data.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        cin.close();

        int[][] isInfected = new int[data.size()][data.get(0).length];
        for (int i = 0; i < data.size(); i++) {
            isInfected[i] = data.get(i);
        }
        int result = containVirus(isInfected);
        System.out.println(result);
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int ans = 0;
        while (true) {
            List<Set<Integer>> neighbors = new ArrayList<>();
            List<Integer> firewalls = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1) {
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.offer(new int[]{i, j});
                        Set<Integer> neighbor = new HashSet<>();
                        int firewall = 0, idx = neighbors.size() + 1;
                        isInfected[i][j] = -idx;

                        while (!queue.isEmpty()) {
                            int[] arr = queue.poll();
                            int x = arr[0], y = arr[1];
                            for (int d = 0; d < 4; ++d) {
                                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if (isInfected[nx][ny] == 1) {
                                        queue.offer(new int[]{nx, ny});
                                        isInfected[nx][ny] = -idx;
                                    } else if (isInfected[nx][ny] == 0) {
                                        ++firewall;
                                        neighbor.add(getHash(nx, ny));
                                    }
                                }
                            }
                        }
                        neighbors.add(neighbor);
                        firewalls.add(firewall);
                    }
                }
            }

            if (neighbors.isEmpty()) {
                break;
            }

            int idx = 0;
            for (int i = 1; i < neighbors.size(); ++i) {
                if (neighbors.get(i).size() > neighbors.get(idx).size()) {
                    idx = i;
                }
            }
            ans += firewalls.get(idx);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] < 0) {
                        if (isInfected[i][j] != -idx - 1) {
                            isInfected[i][j] = 1;
                        } else {
                            isInfected[i][j] = 2;
                        }
                    }
                }
            }
            for (int i = 0; i < neighbors.size(); ++i) {
                if (i != idx) {
                    for (int val : neighbors.get(i)) {
                        int x = val >> 16, y = val & ((1 << 16) - 1);
                        isInfected[x][y] = 1;
                    }
                }
            }
            if (neighbors.size() == 1) {
                break;
            }
        }
        return ans;
    }

    public static int getHash(int x, int y) {
        return (x << 16) ^ y;
    }
}
