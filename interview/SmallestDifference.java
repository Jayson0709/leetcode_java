package interview;

import utils.InputMethods;
import utils.TwoOneDIntArray;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


//Given two arrays of integers, compute the pair of values (one value in each array) with the smallest (non-negative) difference. Return the difference.
//
//    Example:
//    Input: {1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
//    Output:  3, the pair (11, 8)
//
//    Note:
//    1 <= a.length, b.length <= 100000
//    -2147483648 <= a[i], b[i] <= 2147483647
//    The result is in the range [0, 2147483647]


//给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
//
//    示例：
//    输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
//    输出：3，即数值对(11, 8)
//
//    提示：
//    1 <= a.length, b.length <= 100000
//    -2147483648 <= a[i], b[i] <= 2147483647
//    正确结果在区间 [0, 2147483647] 内


public class SmallestDifference {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArray obj = InputMethods.getInputForTwoInt1DArray(cin);
        cin.close();
        System.out.println(smallestDifference(obj.array1, obj.array2));
    }

    // Method 1: sort and two pointers
    private static int smallestDifference(int[] a, int[] b) {
        if (a.length == 1 && b.length == 1) {
            return Math.abs(a[0] - b[0]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0;
        int p2 = 0;
        long minAbs = Long.MAX_VALUE;
        while (p1 < a.length && p2 < b.length) {
            if (a[p1] == b[p2]) {
                return 0;
            }
            long curDif = a[p1] - b[p2];
            minAbs = Math.min(Math.abs(curDif), minAbs);
            if (curDif > 0) {
                p2++;
            } else {
                p1++;
            }
        }
        return (int) minAbs;
    }
}
