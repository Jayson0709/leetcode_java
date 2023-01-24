package algorithms.math;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


//You are given an array points where points[i] = [x_i, y_i] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.
//
//    You are also given an array queries where queries[j] = [x_j, y_j, r_j] describes a circle centered at (x_j, y_j) with a radius of r_j.
//
//    For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.
//
//    Return an array answer, where answer[j] is the answer to the jth query.
//
//    Example 1:
//    Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
//    Output: [3,2,2]
//    Explanation: The points and circles are shown above.
//    queries[0] is the green circle, queries[1] is the red circle, and queries[2] is the blue circle.
//
//    Example 2:
//    Input: points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
//    Output: [2,3,2,4]
//    Explanation: The points and circles are shown above.
//    queries[0] is green, queries[1] is red, queries[2] is blue, and queries[3] is purple.
//
//    Constraints:
//    1 <= points.length <= 500
//    points[i].length == 2
//    0 <= x_i, y_i <= 500
//    1 <= queries.length <= 500
//    queries[j].length == 3
//    0 <= x_j, y_j <= 500
//    1 <= r_j <= 500
//    All coordinates are integers.
//
//    Follow up: Could you find the answer for each query in better complex_ity than O(n)?


//给你一个数组 points ，其中 points[i] = [x_i, y_i] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。
//
//    同时给你一个数组 queries ，其中 queries[j] = [x_j, y_j, r_j] ，表示一个圆心在 (x_j, y_j) 且半径为 r_j 的圆。
//
//    对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。
//
//    请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。
//
//
//
//    示例 1：
//
//
//    输入：points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
//    输出：[3,2,2]
//    解释：所有的点和圆如上图所示。
//    queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
//    示例 2：
//
//
//    输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
//    输出：[2,3,2,4]
//    解释：所有的点和圆如上图所示。
//    queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
//
//
//    提示：
//
//    1 <= points.length <= 500
//    points[i].length == 2
//    0 <= x_i, y_i <= 500
//    1 <= queries.length <= 500
//    queries[j].length == 3
//    0 <= x_j, y_j <= 500
//    1 <= r_j <= 500
//    所有的坐标都是整数。


public class Q1828 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> points = new ArrayList<>();
        List<int[]> queries = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, points);
        InputMethods.getInputForIntArrArrayList(cin, queries);
        cin.close();
        System.out.println(Arrays.toString(countPoints(
            DataConversionMethods.convertIntArrArrayListTo2DArray(points),
            DataConversionMethods.convertIntArrArrayListTo2DArray(queries))));
    }

    private static int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int cx = queries[i][0], cy = queries[i][1], cr = queries[i][2];
            for (int[] point : points) {
                int px = point[0], py = point[1];
                if ((cx - px) * (cx - px) + (cy - py) * (cy - py) <= cr * cr) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
