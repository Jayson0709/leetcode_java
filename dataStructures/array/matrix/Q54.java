package dataStructures.array.matrix;
import utils.OutputMethods;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an m x n matrix, return all elements of the matrix in spiral order.
//
//    Example 1:
//    |1|2|3|
//    |4|5|6|
//    |7|8|9|
//    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    Output: [1,2,3,6,9,8,7,4,5]
//
//    Example 2:
//    |1 |2 |3 |4 |
//    |5 |6 |7 |8 |
//    |9 |10|11|12|
//    Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//
//    Constraints:
//    m == matrix.length
//    n == matrix[i].length
//    1 <= m, n <= 10
//    -100 <= matrix[i][j] <= 100


//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//    
//    示例 1：
//    |1|2|3|
//    |4|5|6|
//    |7|8|9|
//    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    输出：[1,2,3,6,9,8,7,4,5]
//    
//    示例 2：
//    |1 |2 |3 |4 |
//    |5 |6 |7 |8 |
//    |9 |10|11|12|
//    输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//    输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//    限制：
//    0 <= matrix.length <= 100
//    0 <= matrix[i].length<= 100



public class Q54 {
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
        int[][] matrix = new int[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            matrix[i] = data.get(i);
        }
        int[] result = spiralOrder(matrix);
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    // Method 1: Use four variables to limit the boundary
    private static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int n = matrix.length, m = matrix[0].length;
        int[] result = new int[n * m];
        int left = 0, top = 0, right = m - 1, bottom = n - 1;
        int index = 0;
        while (true) {
            // from left to right
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            // from up to down
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            // from right to left
            for (int i = right; i >= left; i--) {
                result[index++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            // from down to up.
            for (int i = bottom; i >= top; i--) {
                result[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return result;
    }


    // Method 2: Stimulation
//    private static int[] spiralOrder(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return new int[0];
//        }
//        int rows = matrix.length, columns = matrix[0].length;
//        boolean[][] visited = new boolean[rows][columns];
//        int[] result = new int[rows * columns];
//        int row = 0, column = 0;
//        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//        int directionIndex = 0;
//        for (int i = 0; i < rows * columns; i++) {
//            result[i] = matrix[row][column];
//            visited[row][column] = true;
//            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
//            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
//                directionIndex = (directionIndex + 1) % 4;
//            }
//            row += directions[directionIndex][0];
//            column += directions[directionIndex][1];
//        }
//        return result;
//    }
}

