package algorithms.math;

import utils.*;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.
//    
//    Example 1:
//    ^
//    |
//    |
//    |
//    |\
//    |_\_________>
//    Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//    Output: 2.00000
//    Explanation: The five points are shown in the above figure. The red triangle is the largest.
//
//    Example 2:
//    Input: points = [[1,0],[0,0],[0,1]]
//    Output: 0.50000
//
//    Constraints:
//    3 <= points.length <= 50
//    -50 <= xi, yi <= 50
//    All the given points are unique.




//给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
//
//    示例:
//    输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//    输出: 2
//    解释:
//    这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
//    ^
//    |
//    |
//    |
//    |\
//    |_\_________>
//
//    注意:
//    3 <= points.length <= 50.
//    不存在重复的点。
//     -50 <= points[i][j] <= 50.
//    结果误差值在 10^-6 以内都认为是正确答案。



public class Q812 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        System.out.println(largestTriangleArea(DataConversionMethods.convertIntArrArrayListTo2DArray(data)));
    }

    // Method 1: Enumeration
//    private static double largestTriangleArea(int[][] points) {
//        int n = points.length;
//        double res = 0.0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                for (int k = j + 1; k < n; k++) {
//                    res = Math.max(res, triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
//                }
//            }
//        }
//        return res;
//    }
//
//    public static double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
//        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
//    }

    // Method 2: convex hull
    // Ref: https://leetcode.cn/problems/largest-triangle-area/solution/zui-da-san-jiao-xing-mian-ji-by-leetcode-yefh/
    public static double largestTriangleArea(int[][] points) {
        int[][] convexHull = getConvexHull(points);
        int n = convexHull.length;
        double res = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1, k = i + 2; j + 1 < n; j++) {
                while (k + 1 < n) {
                    double curArea = triangleArea(convexHull[i][0], convexHull[i][1], convexHull[j][0], convexHull[j][1], convexHull[k][0], convexHull[k][1]);
                    double nextArea = triangleArea(convexHull[i][0], convexHull[i][1], convexHull[j][0], convexHull[j][1], convexHull[k + 1][0], convexHull[k + 1][1]);
                    if (curArea >= nextArea) {
                        break;
                    }
                    k++;
                }
                double area = triangleArea(convexHull[i][0], convexHull[i][1], convexHull[j][0], convexHull[j][1], convexHull[k][0], convexHull[k][1]);
                res = Math.max(res, area);
            }
        }
        return res;
    }

    public static int[][] getConvexHull(int[][] points) {
        int n = points.length;
        if (n < 4) {
            return points;
        }
        // Sort by x. If x is the same, sort by y.
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        List<int[]> hull = new ArrayList<>();
        // Find the bottom half of the convex hull
        for (int[] point : points) {
            while (hull.size() > 1 && cross(hull.get(hull.size() - 2), hull.get(hull.size() - 1), point) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(point);
        }
        int m = hull.size();
        // Find the upper part of the convex hull
        for (int i = n - 2; i >= 0; i--) {
            while (hull.size() > m && cross(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points[i]);
        }
        // hull[0] is also involved in the detection of the upper part of the convex hull,
        // so the duplicate hull[0] needs to be removed.
        hull.remove(hull.size() - 1);
        m = hull.size();
        int[][] hullArr = new int[m][];
        for (int i = 0; i < m; i++) {
            hullArr[i] = hull.get(i);
        }
        return hullArr;
    }

    public static double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }

    public static int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }
}
