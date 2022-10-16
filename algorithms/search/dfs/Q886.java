package algorithms.search.dfs;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



//We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
//
//    Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
//
//    Example 1:
//    Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
//    Output: true
//    Explanation: group1 [1,4] and group2 [2,3].
//
//    Example 2:
//    Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
//    Output: false
//
//    Example 3:
//    Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//    Output: false
//
//    Constraints:
//    1 <= n <= 2000
//    0 <= dislikes.length <= 10^4
//    dislikes[i].length == 2
//    1 <= dislikes[i][j] <= n
//    ai < bi
//    All the pairs of dislikes are unique.




//给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
//
//    给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
//
//    示例 1：
//    输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
//    输出：true
//    解释：group1 [1,4], group2 [2,3]
//
//    示例 2：
//    输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
//    输出：false
//
//    示例 3：
//    输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//    输出：false
//
//    提示：
//    1 <= n <= 2000
//    0 <= dislikes.length <= 10^4
//    dislikes[i].length == 2
//    1 <= dislikes[i][j] <= n
//    ai < bi
//    dislikes 中每一组都 不同



public class Q886 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        System.out.println(possibleBipartition(n, DataConversionMethods.convertIntArrArrayListTo2DArray(data)));
    }

    private static boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            g[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; ++i) {
            if (color[i] == 0 && !dfs(i, 1, color, g)) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(int curNode, int nowColor, int[] color, List<Integer>[] g) {
        color[curNode] = nowColor;
        for (int nextNode : g[curNode]) {
            if (color[nextNode] != 0 && color[nextNode] == color[curNode]) {
                return false;
            }
            if (color[nextNode] == 0 && !dfs(nextNode, 3 ^ nowColor, color, g)) {
                return false;
            }
        }
        return true;
    }
}
