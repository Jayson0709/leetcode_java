package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Given an integer rowIndex, return the rowIndex_th (0-indexed) row of the Pascal's triangle.
//
//    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//             1
//           1   1
//          1  2  1
//         1  3  3  1
//        1  4  6  4  1
//
//    Example 1:
//    Input: rowIndex = 3
//    Output: [1,3,3,1]
//
//    Example 2:
//    Input: rowIndex = 0
//    Output: [1]
//
//    Example 3:
//    Input: rowIndex = 1
//    Output: [1,1]
//
//    Constraints:
//    0 <= rowIndex <= 33
//
//    Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?



//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
//    在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//             1
//           1   1
//          1  2  1
//         1  3  3  1
//        1  4  6  4  1
//
//    示例 1:
//    输入: rowIndex = 3
//    输出: [1,3,3,1]
//
//    示例 2:
//    输入: rowIndex = 0
//    输出: [1]
//
//    示例 3:
//    输入: rowIndex = 1
//    输出: [1,1]
//
//    提示:
//    0 <= rowIndex <= 33
//
//    进阶：
//    你可以优化你的算法到 O(rowIndex) 空间复杂度吗？



public class Q119 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int rowIndex = cin.nextInt();
        cin.close();
        System.out.println(getRow(rowIndex));
    }

    // Version 1
//    private static List<Integer> getRow(int rowIndex) {
//        List<Integer> row = new ArrayList<>();
//        row.add(1);
//        for (int i = 1; i <= rowIndex; ++i) {
//            row.add(0);
//            for (int j = i; j > 0; --j) {
//                row.set(j, row.get(j) + row.get(j - 1));
//            }
//        }
//        return row;
//    }

    // Version 2
    private static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}
