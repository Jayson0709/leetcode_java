package algorithms.search.binarySearch;
import utils.DataConversionMethods;

import java.util.*;
import java.nio.charset.StandardCharsets;

//Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
//
//    Integers in each row are sorted in ascending from left to right.
//    Integers in each column are sorted in ascending from top to bottom.
//
//    Example 1:
//    [
//    [1,   4,  7, 11, 15],
//    [2,   5,  8, 12, 19],
//    [3,   6,  9, 16, 22],
//    [10, 13, 14, 17, 24],
//    [18, 21, 23, 26, 30]
//    ]
//    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//    Output: true
//
//    Example 2:
//    [
//    [1,   4,  7, 11, 15],
//    [2,   5,  8, 12, 19],
//    [3,   6,  9, 16, 22],
//    [10, 13, 14, 17, 24],
//    [18, 21, 23, 26, 30]
//    ]
//    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
//    Output: false
//
//    Constraints:
//    m == matrix.length
//    n == matrix[i].length
//    1 <= n, m <= 300
//    -10^9 <= matrix[i][j] <= 10^9
//    All the integers in each row are sorted in ascending order.
//    All the integers in each column are sorted in ascending order.
//    -10^9 <= target <= 10^9


//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//
//    示例:
//
//    现有矩阵 matrix 如下：
//
//    [
//    [1,   4,  7, 11, 15],
//    [2,   5,  8, 12, 19],
//    [3,   6,  9, 16, 22],
//    [10, 13, 14, 17, 24],
//    [18, 21, 23, 26, 30]
//    ]
//    给定 target=5，返回true。
//
//    给定target=20，返回false。
//
//    限制：
//    0 <= n <= 1000
//    0 <= m <= 1000


public class Q240 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        int target = Integer.MIN_VALUE;
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 1) {
                target = Integer.parseInt(line);
            } else if (line.length() > 1) {
                data.add(Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray());
            } else {
                break;
            }
        }
        cin.close();
        System.out.println(findNumberIn2DArray(DataConversionMethods.convertIntArrArrayListTo2DArray(data), target));
    }

    private static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            } else if (num > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
