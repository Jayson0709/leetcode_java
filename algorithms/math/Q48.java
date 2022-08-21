package algorithms.math;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
//    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//
//    Example 1:
//    |1|2|3|      |7|4|1|
//    |4|5|6|  ->  |8|5|2|
//    |7|8|9|      |9|6|3|
//    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    Output: [[7,4,1],[8,5,2],[9,6,3]]
//
//    Example 2:
//    |5 |1 |9 |11|      |15|13|2 |5 |
//    |2 |4 |8 |10|  ->  |14|3 |4 |1 |
//    |13|3 |6 |7 |      |12|6 |8 |9 |
//    |15|14|12|16|      |16|7 |10|11|
//    Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//    Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//    Constraints:
//    n == matrix.length == matrix[i].length
//    1 <= n <= 20
//    -1000 <= matrix[i][j] <= 1000


//给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
//    你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//    示例 1：
//    |1|2|3|      |7|4|1|
//    |4|5|6|  ->  |8|5|2|
//    |7|8|9|      |9|6|3|
//    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    输出：[[7,4,1],[8,5,2],[9,6,3]]
//    示例 2：
//    |5 |1 |9 |11|      |15|13|2 |5 |
//    |2 |4 |8 |10|  ->  |14|3 |4 |1 |
//    |13|3 |6 |7 |      |12|6 |8 |9 |
//    |15|14|12|16|      |16|7 |10|11|
//    输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//    输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//    提示：
//    n == matrix.length == matrix[i].length
//    1 <= n <= 20
//    -1000 <= matrix[i][j] <= 1000


public class Q48 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            data.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        int[][] matrix = new int[data.size()][data.size()];
        for (int i = 0; i < data.size(); i++) {
            matrix[i] = data.get(i);
        }
        rotate(matrix);
        System.out.print("[");
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
                outputData(matrix[i]);
            } else {
                System.out.print(", ");
                outputData(matrix[i]);
            }
        }
        System.out.print("]");
    }

    private static void outputData(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print(array[i]);
            } else {
                System.out.print(", " + array[i]);
            }
        }
        System.out.print("]");
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        // vertical reverse
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // Diagonal reverse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
