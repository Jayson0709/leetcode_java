package algorithms.dynamicProgramming;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//You are given an m x n integer matrix mat and an integer target.
//
//    Choose one integer from each row in the matrix such that the absolute difference between target and the sum of the chosen elements is minimized.
//
//    Return the minimum absolute difference.
//
//    The absolute difference between two numbers a and b is the absolute value of a - b.
//
//    Example 1:
//    |1|2|3|
//    |4|5|6|
//    |7|8|9|
//    Input: mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
//    Output: 0
//    Explanation: One possible choice is to:
//    - Choose 1 from the first row.
//    - Choose 5 from the second row.
//    - Choose 7 from the third row.
//    The sum of the chosen elements is 13, which equals the target, so the absolute difference is 0.
//
//    Example 2:
//    |1|
//    |2|
//    |3|
//    Input: mat = [[1],[2],[3]], target = 100
//    Output: 94
//    Explanation: The best possible choice is to:
//    - Choose 1 from the first row.
//    - Choose 2 from the second row.
//    - Choose 3 from the third row.
//    The sum of the chosen elements is 6, and the absolute difference is 94.
//
//    Example 3:
//    |1|2|9|8|7|
//    Input: mat = [[1,2,9,8,7]], target = 6
//    Output: 1
//    Explanation: The best choice is to choose 7 from the first row.
//    The absolute difference is 1.
//
//    Constraints:
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n <= 70
//    1 <= mat[i][j] <= 70
//    1 <= target <= 800


//给你一个大小为 m x n 的整数矩阵 mat 和一个整数 target 。
//
//    从矩阵的 每一行 中选择一个整数，你的目标是 最小化 所有选中元素之 和 与目标值 target 的 绝对差 。
//
//    返回 最小的绝对差 。
//
//    a 和 b 两数字的 绝对差 是 a - b 的绝对值。
//
//    示例 1：
//    |1|2|3|
//    |4|5|6|
//    |7|8|9|
//    输入：mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
//    输出：0
//    解释：一种可能的最优选择方案是：
//    - 第一行选出 1
//    - 第二行选出 5
//    - 第三行选出 7
//    所选元素的和是 13 ，等于目标值，所以绝对差是 0 。
//
//    示例 2：
//    |1|
//    |2|
//    |3|
//    输入：mat = [[1],[2],[3]], target = 100
//    输出：94
//    解释：唯一一种选择方案是：
//    - 第一行选出 1
//    - 第二行选出 2
//    - 第三行选出 3
//    所选元素的和是 6 ，绝对差是 94 。
//
//    示例 3：
//    |1|2|9|8|7|
//    输入：mat = [[1,2,9,8,7]], target = 6
//    输出：1
//    解释：最优的选择方案是选出第一行的 7 。
//    绝对差是 1 。
//
//    提示：
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n <= 70
//    1 <= mat[i][j] <= 70
//    1 <= target <= 800


public class Q1981 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        int target = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        System.out.println(minimizeTheDifference(
            DataConversionMethods.convertIntArrArrayListTo2DArray(data), target));
    }

    private static int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        int dpLen = 5000;
        int[] dp = new int[dpLen];

        for (int i = 0; i < m; i++) {
            if(i == 0){
                for (int j = 0; j < n; j++) {
                    dp[mat[i][j]] = 1;
                }
            } else {
                int[] tmpDp = new int[dpLen];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < dpLen; k++) {
                        if(dp[k] == 1){
                            tmpDp[mat[i][j] + k] = 1;
                        }
                    }
                }
                dp = tmpDp;
            }
        }

        int gap = 0;
        while (true){
            if(target - gap >= 0 && dp[target - gap] == 1){
                return gap;
            } else if(target + gap <= dpLen && dp[target + gap] == 1){
                return gap;
            } else {
                gap += 1;
            }
        }
    }
}
