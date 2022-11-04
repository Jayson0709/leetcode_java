package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are standing at position 0 on an infinite number line. There is a destination at position target.
//
//    You can make some number of moves numMoves so that:
//
//    On each move, you can either go left or right.
//    During the ith move (starting from i == 1 to i == numMoves), you take i steps in the chosen direction.
//    Given the integer target, return the minimum number of moves required (i.e., the minimum numMoves) to reach the destination.
//
//    Example 1:
//    Input: target = 2
//    Output: 3
//    Explanation:
//    On the 1st move, we step from 0 to 1 (1 step).
//    On the 2nd move, we step from 1 to -1 (2 steps).
//    On the 3rd move, we step from -1 to 2 (3 steps).
//
//    Example 2:
//    Input: target = 3
//    Output: 2
//    Explanation:
//    On the 1st move, we step from 0 to 1 (1 step).
//    On the 2nd move, we step from 1 to 3 (2 steps).
//
//    Constraints:
//    -10^9 <= target <= 10^9
//    target != 0


//在一根无限长的数轴上，你站在0的位置。终点在target的位置。
//
//    你可以做一些数量的移动 numMoves :
//
//    每次你可以选择向左或向右移动。
//    第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
//    给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
//
//    示例 1:
//    输入: target = 2
//    输出: 3
//    解释:
//    第一次移动，从 0 到 1 。
//    第二次移动，从 1 到 -1 。
//    第三次移动，从 -1 到 2 。
//
//    示例 2:
//    输入: target = 3
//    输出: 2
//    解释:
//    第一次移动，从 0 到 1 。
//    第二次移动，从 1 到 3 。
//
//    提示:
//    -10^9 <= target <= 10^9
//    target != 0



public class Q754 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int target = cin.nextInt();
        cin.close();
        System.out.println(readNumber(target));
    }

    private static int readNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}
