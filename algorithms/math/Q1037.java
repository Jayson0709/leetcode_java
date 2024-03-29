package algorithms.math;
import utils.DataConversionMethods;
import utils.InputMethods;

import java.util.*;
import java.nio.charset.StandardCharsets;

//Given an array points where points[i] = [xi, yi] represents a point on the X-Y plane, return true if these points are a boomerang.
//
//    A boomerang is a set of three points that are all distinct and not in a straight line.
//
//    Example 1:
//    Input: points = [[1,1],[2,3],[3,2]]
//    Output: true
//
//    Example 2:
//    Input: points = [[1,1],[2,2],[3,3]]
//    Output: false
//
//    Constraints:
//    points.length == 3
//    points[i].length == 2
//    0 <= xi, yi <= 100


// 给定一个数组points，其中points[i] = [xi, yi]表示 X-Y 平面上的一个点，如果这些点构成一个回旋镖则返回true。
// 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。

// 示例 1：
// 输入：points = [[1,1],[2,3],[3,2]]
// 输出：true
//
// 示例 2：
// 输入：points = [[1,1],[2,2],[3,3]]
// 输出：false
//
// 提示：
// points.length == 3
// points[i].length == 2
// 0 <= xi, yi<= 100


public class Q1037 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> dataList = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, dataList);
        cin.close();
        boolean result = isBoomerang(DataConversionMethods.convertIntArrArrayListTo2DArray(dataList));
        System.out.println(result);
    }
    
    public static boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
}
