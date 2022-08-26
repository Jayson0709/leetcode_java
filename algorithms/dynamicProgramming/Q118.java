package algorithms.dynamicProgramming;

import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//             1
//           1   1
//          1  2  1
//         1  3  3  1
//        1  4  6  4  1
//
//    Example 1:
//    Input: numRows = 5
//    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//    Example 2:
//    Input: numRows = 1
//    Output: [[1]]
//
//    Constraints:
//    1 <= numRows <= 30



//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
//    在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//             1
//           1   1
//          1  2  1
//         1  3  3  1
//        1  4  6  4  1
//
//    示例 1:
//    输入: numRows = 5
//    输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//    示例 2:
//    输入: numRows = 1
//    输出: [[1]]
//
//    提示:
//    1 <= numRows <= 30



public class Q118 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int numRows = cin.nextInt();
        cin.close();
        System.out.println(OutputMethods.formatNestedListOutputData(generate(numRows)));
    }

    // Method 1: use Math formula / dynamic programming
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
