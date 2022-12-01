package dataStructures.array.simpleArray;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



//You are given two integers, x and y, which represent your current location on a Cartesian grid: (x, y). You are also given an array points where each points[i] = [a_i, b_i] represents that a point exists at (a_i, b_i). A point is valid if it shares the same x-coordinate or the same y-coordinate as your location.
//
//    Return the index (0-indexed) of the valid point with the smallest Manhattan distance from your current location. If there are multiple, return the valid point with the smallest index. If there are no valid points, return -1.
//
//    The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 - x2) + abs(y1 - y2).
//
//    Example 1:
//    Input: x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
//    Output: 2
//    Explanation: Of all the points, only [3,1], [2,4] and [4,4] are valid. Of the valid points, [2,4] and [4,4] have the smallest Manhattan distance from your current location, with a distance of 1. [2,4] has the smallest index, so return 2.
//
//    Example 2:
//    Input: x = 3, y = 4, points = [[3,4]]
//    Output: 0
//    Explanation: The answer is allowed to be on the same location as your current location.
//
//    Example 3:
//    Input: x = 3, y = 4, points = [[2,3]]
//    Output: -1
//    Explanation: There are no valid points.
//
//    Constraints:
//    1 <= points.length <= 10^4
//    points[i].length == 2
//    1 <= x, y, a_i, b_i <= 10^4


//给你两个整数 x 和 y ，表示你在一个笛卡尔坐标系下的 (x, y) 处。同时，在同一个坐标系下给你一个数组 points ，其中 points[i] = [a_i, b_i] 表示在 (a_i, b_i) 处有一个点。当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的 。
//
//    请返回距离你当前位置 曼哈顿距离 最近的 有效 点的下标（下标从 0 开始）。如果有多个最近的有效点，请返回下标 最小 的一个。如果没有有效点，请返回 -1 。
//
//    两个点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 abs(x1 - x2) + abs(y1 - y2) 。
//
//    示例 1：
//    输入：x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
//    输出：2
//    解释：所有点中，[3,1]，[2,4] 和 [4,4] 是有效点。有效点中，[2,4] 和 [4,4] 距离你当前位置的曼哈顿距离最小，都为 1 。[2,4] 的下标最小，所以返回 2 。
//
//    示例 2：
//    输入：x = 3, y = 4, points = [[3,4]]
//    输出：0
//    提示：答案可以与你当前所在位置坐标相同。
//
//    示例 3：
//    输入：x = 3, y = 4, points = [[2,3]]
//    输出：-1
//    解释：没有 有效点。
//
//    提示：
//    1 <= points.length <= 10^4
//    points[i].length == 2
//    1 <= x, y, a_i, b_i <= 10^4

public class Q1779 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        int x = Integer.parseInt(cin.nextLine().strip());
        int y = Integer.parseInt(cin.nextLine().strip());
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        System.out.println(nearestValidPoint(x, y, DataConversionMethods.convertIntArrArrayListTo2DArray(data)));
    }

    private static int nearestValidPoint(int x, int y, int[][] points) {
        int n = points.length;
        int best = Integer.MAX_VALUE, bestId = -1;
        for (int i = 0; i < n; ++i) {
            int px = points[i][0], py = points[i][1];
            if (x == px) {
                int dist = Math.abs(y - py);
                if (dist < best) {
                    best = dist;
                    bestId = i;
                }
            } else if (y == py) {
                int dist = Math.abs(x - px);
                if (dist < best) {
                    best = dist;
                    bestId = i;
                }
            }
        }
        return bestId;
    }
}
