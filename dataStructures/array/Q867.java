package dataStructures.array;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given a 2D integer array matrix, return the transpose of matrix.
//
//    The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
//
//    Example 1:
//    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    Output: [[1,4,7],[2,5,8],[3,6,9]]
//
//    Example 2:
//    Input: matrix = [[1,2,3],[4,5,6]]
//    Output: [[1,4],[2,5],[3,6]]
//
//    Constraints:
//    m == matrix.length
//    n == matrix[i].length
//    1 <= m, n <= 1000
//    1 <= m * n <= 105
//    -109 <= matrix[i][j] <= 109

//给你一个二维整数数组 matrix，返回 matrix 的 转置矩阵 。
//    矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
//
//    示例 1：
//    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    输出：[[1,4,7],[2,5,8],[3,6,9]]
//
//    示例 2：
//    输入：matrix = [[1,2,3],[4,5,6]]
//    输出：[[1,4],[2,5],[3,6]]
//
//    提示：
//    m == matrix.length
//    n == matrix[i].length
//    1 <= m, n <= 1000
//    1 <= m * n <= 105
//    -109 <= matrix[i][j] <= 109

public class Q867 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        List<int[]> matrixData = new ArrayList<>();
        while (true) {
            String data = cin.nextLine();
            if (data.length() == 0) {
                break;
            } else {
                matrixData.add(Arrays.stream(data.strip().split(" ")).mapToInt(Integer::parseInt).toArray());
            }
        }
        cin.close();
        int[][] matrix = new int[matrixData.size()][matrixData.get(0).length];
        for (int i = 0; i < matrixData.size(); i++) {
            matrix[i] = matrixData.get(i);
        }
        int[][] result = transpose(matrix);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
