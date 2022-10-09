package interview;


import utils.InputMethods;
import utils.TwoOneDIntArray;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;



//Given two squares on a two-dimensional plane, find a line that would cut these two squares in half. Assume that the top and the bottom sides of the square run parallel to the x-axis.
//
//    Each square consists of three values, the coordinate of bottom left corner [X,Y] = [square[0],square[1]], and the side length of the square 'square[2]'. The line will intersect to the two squares in four points. Return the coordinates of two intersection points [X1,Y1] and [X2,Y2] that the forming segment covers the other two intersection points in format of {X1,Y1,X2,Y2}. If X1 != X2, there should be X1 < X2, otherwise there should be Y1 <= Y2.
//
//    If there are more than one line that can cut these two squares in half, return the one that has the biggest slope (slope of a line parallel to the y-axis is considered as infinity).
//
//    Example:
//
//    Input:
//    square1 = {-1, -1, 2}
//    square2 = {0, -1, 2}
//    Output: {-1,0,2,0}
//    Explanation: y = 0 is the line that can cut these two squares in half.
//    
//    Note:
//    square.length == 3
//    square[2] > 0



//给定两个正方形及一个二维平面。请找出将这两个正方形分割成两半的一条直线。假设正方形顶边和底边与 x 轴平行。
//
//    每个正方形的数据square包含3个数值，正方形的左下顶点坐标[X,Y] = [square[0],square[1]]，以及正方形的边长square[2]。所求直线穿过两个正方形会形成4个交点，请返回4个交点形成线段的两端点坐标（两个端点即为4个交点中距离最远的2个点，这2个点所连成的线段一定会穿过另外2个交点）。2个端点坐标[X1,Y1]和[X2,Y2]的返回格式为{X1,Y1,X2,Y2}，要求若X1 != X2，需保证X1 < X2，否则需保证Y1 <= Y2。
//
//    若同时有多条直线满足要求，则选择斜率最大的一条计算并返回（与Y轴平行的直线视为斜率无穷大）。
//
//    示例：
//
//    输入：
//    square1 = {-1, -1, 2}
//    square2 = {0, -1, 2}
//    输出： {-1,0,2,0}
//    解释： 直线 y = 0 能将两个正方形同时分为等面积的两部分，返回的两线段端点为[-1,0]和[2,0]
//
//    提示：
//    square.length == 3
//    square[2] > 0



public class BisectSquares {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArray obj = InputMethods.getInputForTwoInt1DArray(cin);
        cin.close();
        System.out.println(Arrays.toString(cutSquares(obj.array1, obj.array2)));
    }

    private static double[] cutSquares(int[] square1, int[] square2) {
        double midX1 = square1[0] + square1[2] / 2.0;
        double midY1 = square1[1] + square1[2] / 2.0;
        int d1 = square1[2];
        double midX2 = square2[0] + square2[2] / 2.0;
        double midY2 = square2[1] + square2[2] / 2.0;
        int d2 = square2[2];
        double[] res = new double[4];
        if (midX1 == midX2) {
            res[0] = midX1;
            res[1] = Math.min(square1[1], square2[1]);
            res[2] = midX2;
            res[3] = Math.max(square1[1] + d1, square2[1] + d2);
        } else {
            double k = (midY2 - midY1) / (midX2 - midX1);
            double b = midY1 - k * midX1;
            if (Math.abs(k) > 1) {
                res[1] = Math.min(square1[1], square2[1]);
                res[0] = (res[1] - b) / k;
                res[3] = Math.max(square1[1] + d1, square2[1] + d2);
                res[2] = (res[3] - b) / k;
            } else {
                res[0] = Math.min(square1[0], square2[0]);
                res[1] = res[0] * k + b;
                res[2] = Math.max(square1[0] + d1, square2[0] + d2);
                res[3] = res[2] * k + b;
            }
        }
        if (res[0] > res[2]) {
            swap(res, 0, 2);
            swap(res, 1, 3);
        }
        return res;
    }

    private static void swap(double[] res, int x, int y) {
        double temp = res[x];
        res[x] = res[y];
        res[y] = temp;
    }
}
