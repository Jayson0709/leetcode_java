package algorithms.search.binarySearch;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;

//Given an m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
//
//    Example 1:
//    Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//    Output: 8
//    Explanation: There are 8 negatives number in the matrix.
//
//    Example 2:
//    Input: grid = [[3,2],[1,0]]
//    Output: 0
//
//    Constraints:
//    m == grid.length
//    n == grid[i].length
//    1 <= m, n <= 100
//    -100 <= grid[i][j] <= 100


//给你一个m* n的矩阵grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。请你统计并返回grid中 负数 的数目。
//
//    示例 1：
//    输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//    输出：8
//    解释：矩阵中共有 8 个负数。
//
//    示例 2：
//    输入：grid = [[3,2],[1,0]]
//    输出：0
//
//    提示：
//    m == grid.length
//    n == grid[i].length
//    1 <= m, n <= 100
//    -100 <= grid[i][j] <= 100


public class Q1351 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> gridList = new ArrayList<>();
        InputMethods.getInputForIntArrayList(cin, gridList);
        int result = countNegatives(DataConversionMethods.convertArrayListTo2DArray(gridList));
        System.out.println(result);
    }

    private static int countNegatives(int[][] grid) {
        int result = 0;
        for (int[] pair : grid) {
            int left = 0;
            int right = pair.length - 1;
            int position = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (pair[mid] < 0) {
                    position = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (position != -1) {
                result += pair.length - position;
            }
        }
        return result;
    }
}
