package algorithms.math;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.
//
//    Count and return the number of maximum integers in the matrix after performing all the operations.
//
//    Example 1:
//    |0|0|0|        |1|1|0|        |2|2|1|
//    |0|0|0|   ->   |1|1|0|   ->   |2|2|1|
//    |0|0|0|        |0|0|0|        |1|1|1|
//    Input: m = 3, n = 3, ops = [[2,2],[3,3]]
//    Output: 4
//    Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
//
//    Example 2:
//    Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
//    Output: 4
//
//    Example 3:
//    Input: m = 3, n = 3, ops = []
//    Output: 9
//
//    Constraints:
//    1 <= m, n <= 4 * 10^4
//    0 <= ops.length <= 10^4
//    ops[i].length == 2
//    1 <= a_i <= m
//    1 <= b_i <= n



//给你一个 m xn 的矩阵M，初始化时所有的 0 和一个操作数组 op ，其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x < a_i 和 0 <= y < b_i 时， M[x][y] 应该加 1。
//
//    在执行完所有操作后，计算并返回矩阵中最大整数的个数。
//
//    示例 1:
//    |0|0|0|        |1|1|0|        |2|2|1|
//    |0|0|0|   ->   |1|1|0|   ->   |2|2|1|
//    |0|0|0|        |0|0|0|        |1|1|1|
//    输入: m = 3, n = 3，ops = [[2,2],[3,3]]
//    输出: 4
//    解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
//
//    示例 2:
//    输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
//    输出: 4
//
//    示例 3:
//    输入: m = 3, n = 3, ops = []
//    输出: 9
//
//    提示:
//    1 <= m, n <= 4 * 10^4
//    0 <= ops.length <= 10^4
//    ops[i].length == 2
//    1 <= a_i<= m
//    1 <= b_i<= n



public class Q598 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int m = Integer.parseInt(cin.nextLine());
        int n = Integer.parseInt(cin.nextLine());
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrayList(cin, data);
        int result = maxCount(m, n, DataConversionMethods.convertArrayListTo2DArray(data));
        System.out.println(result);
    }

    private static int maxCount(int m, int n, int[][] ops) {
        int minX = m, minY = n;
        for (int[] op : ops) {
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }
        return minX * minY;
    }


}
