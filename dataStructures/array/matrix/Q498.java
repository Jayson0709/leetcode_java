package dataStructures.array.matrix;
import utils.IOMethods;

import java.util.*;
import java.nio.charset.StandardCharsets;

//Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
//
//    Example 1:
//    Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
//    Output: [1,2,4,7,5,3,6,8,9]
//
//    Example 2:
//    Input: mat = [[1,2],[3,4]]
//    Output: [1,2,3,4]
//
//    Constraints:
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n <= 104
//    1 <= m * n <= 104
//    -105 <= mat[i][j] <= 105

//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
//
//    示例 1：
//
//    输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//    输出：[1,2,4,7,5,3,6,8,9]
//
//    示例 2：
//    输入：mat = [[1,2],[3,4]]
//    输出：[1,2,3,4]
//
//    提示：
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n <= 104
//    1 <= m * n <= 104
//    -105 <= mat[i][j] <= 105



public class Q498 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> dataList = new ArrayList<>();
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            dataList.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        cin.close();

        int[][] mat = new int[dataList.size()][2];
        for (int i = 0; i < dataList.size(); i++) {
            mat[i] = dataList.get(i);
        }

        int[] result = findDiagonalOrder(mat);
        System.out.println(IOMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    private static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int position = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 1) {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    result[position] = mat[x][y];
                    position++;
                    x++;
                    y--;
                }
            } else {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    result[position] = mat[x][y];
                    position++;
                    x--;
                    y++;
                }
            }
        }
        return result;
    }
}
