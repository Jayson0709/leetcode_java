package math;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given four integers sx, sy, tx, and ty, return true if it is possible to convert the point (sx, sy) to the point (tx, ty) through some operations, or false otherwise.
//
//    The allowed operation on some point (x, y) is to convert it to either (x, x + y) or (x + y, y).
//
//
//    Example 1:
//    Input: sx = 1, sy = 1, tx = 3, ty = 5
//    Output: true
//    Explanation:
//    One series of moves that transforms the starting point to the target is:
//    (1, 1) -> (1, 2)
//    (1, 2) -> (3, 2)
//    (3, 2) -> (3, 5)
//
//    Example 2:
//    Input: sx = 1, sy = 1, tx = 2, ty = 2
//    Output: false
//
//    Example 3:
//    Input: sx = 1, sy = 1, tx = 1, ty = 1
//    Output: true
//
//    Constraints:
//    1 <= sx, sy, tx, ty <= 109


//给定四个整数sx,sy，tx和ty，如果通过一系列的转换可以从起点(sx, sy)到达终点(tx, ty)，则返回 true，否则返回false。
//
//    从点(x, y)可以转换到(x, x+y) 或者(x+y, y)。
//
//    示例 1:
//    输入: sx = 1, sy = 1, tx = 3, ty = 5
//    输出: true
//    解释:
//    可以通过以下一系列转换从起点转换到终点：
//    (1, 1) -> (1, 2)
//    (1, 2) -> (3, 2)
//    (3, 2) -> (3, 5)
//
//    示例 2:
//    输入: sx = 1, sy = 1, tx = 2, ty = 2
//    输出: false
//
//    示例 3:
//    输入: sx = 1, sy = 1, tx = 1, ty = 1
//    输出: true
//
//    提示:
//    1 <= sx, sy, tx, ty <= 109


public class Q780 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int sx = cin.nextInt();
        int sy = cin.nextInt();
        int tx = cin.nextInt();
        int ty = cin.nextInt();
        cin.close();

        boolean result = reachingPoints(sx, sy, tx, ty);
        System.out.println(result);
    }

    private static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx < ty) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }
        if (tx < sx || ty < sy) {
            return false;
        }
        return sx == tx ? (ty -sy) % tx == 0 : (tx - sx) % ty == 0;
    }
}
