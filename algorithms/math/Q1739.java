package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You have a cubic storeroom where the width, length, and height of the room are all equal to n units. You are asked to place n boxes in this room where each box is a cube of unit side length. There are however some rules to placing the boxes:
//
//    You can place the boxes anywhere on the floor.
//    If box x is placed on top of the box y, then each side of the four vertical sides of the box y must either be adjacent to another box or to a wall.
//    Given an integer n, return the minimum possible number of boxes touching the floor.
//
//    Example 1:
//    Input: n = 3
//    Output: 3
//    Explanation: The figure above is for the placement of the three boxes.
//    These boxes are placed in the corner of the room, where the corner is on the left side.
//
//    Example 2:
//    Input: n = 4
//    Output: 3
//    Explanation: The figure above is for the placement of the four boxes.
//    These boxes are placed in the corner of the room, where the corner is on the left side.
//
//    Example 3:
//    Input: n = 10
//    Output: 6
//    Explanation: The figure above is for the placement of the ten boxes.
//    These boxes are placed in the corner of the room, where the corner is on the back side.
//
//    Constraints:
//    1 <= n <= 10^9


//有一个立方体房间，其长度、宽度和高度都等于 n 个单位。请你在房间里放置 n 个盒子，每个盒子都是一个单位边长的立方体。放置规则如下：
//
//    你可以把盒子放在地板上的任何地方。
//    如果盒子 x 需要放置在盒子 y 的顶部，那么盒子 y 竖直的四个侧面都 必须 与另一个盒子或墙相邻。
//    给你一个整数 n ，返回接触地面的盒子的 最少 可能数量。
//
//    示例 1：
//    输入：n = 3
//    输出：3
//    解释：上图是 3 个盒子的摆放位置。
//    这些盒子放在房间的一角，对应左侧位置。
//
//    示例 2：
//    输入：n = 4
//    输出：3
//    解释：上图是 3 个盒子的摆放位置。
//    这些盒子放在房间的一角，对应左侧位置。
//
//    示例 3：
//    输入：n = 10
//    输出：6
//    解释：上图是 10 个盒子的摆放位置。
//    这些盒子放在房间的一角，对应后方位置。
//
//    提示：
//    1 <= n <= 10^9


public class Q1739 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(minimumBoxes(n));
    }

    private static int minimumBoxes(int n) {
        int cur = 1, i = 1, j = 1;
        while (n > cur) {
            n -= cur;
            i++;
            cur += i;
        }
        cur = 1;
        while (n > cur) {
            n -= cur;
            j++;
            cur++;
        }
        return (i - 1) * i / 2 + j;
    }
}
