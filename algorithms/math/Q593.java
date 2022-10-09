package algorithms.math;
import utils.InputMethods;
import utils.TwoOneDIntArray;

import java.util.*;
import java.nio.charset.StandardCharsets;


//Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.
//
//    The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.
//
//    A valid square has four equal sides with positive length and four equal angles (90-degree angles).
//
//    Example 1:
//    Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//    Output: true
//    
//    Example 2:
//    Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//    Output: false
//    
//    Example 3:
//    Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//    Output: true
//
//    Constraints:
//    p1.length == p2.length == p3.length == p4.length == 2
//    -10^4 <= xi, yi <= 10^4



//给定2D空间中四个点的坐标p1,p2,p3和p4，如果这四个点构成一个正方形，则返回 true 。
//
//    点的坐标pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
//
//    一个 有效的正方形 有四条等边和四个等角(90度角)。
//
//    示例 1:
//    输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//    输出: True
//
//    示例 2:
//    输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//    输出：false
//
//    示例 3:
//    输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//    输出：true
//
//    提示:
//    p1.length == p2.length == p3.length == p4.length == 2
//    -10^4<= xi, yi<= 10^4



public class Q593 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArray obj1 = InputMethods.getInputForTwoInt1DArray(cin);
        TwoOneDIntArray obj2 = InputMethods.getInputForTwoInt1DArray(cin);
        cin.close();
        System.out.println(validSquare(obj1.array1, obj1.array2, obj2.array1, obj2.array2));
    }

    private static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // randomly pick three points, they will form a right triangle
        return isRightTriangle(p1, p2, p3) && isRightTriangle(p1, p2, p4) && isRightTriangle(p1, p3, p4) && isRightTriangle(p2, p3, p4);
    }

    public static boolean isRightTriangle(int[] p1, int[]p2, int[] p3){
        int d1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int d2 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        int d3 = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
        return d1 > d2 && d2 == d3 && d2 + d3 == d1 ||
            d2 > d1 && d1 == d3 && d1 + d3 == d2 ||
            d3 > d1 && d1 == d2 && d1 + d2 == d3;
    }
}
