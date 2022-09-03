package algorithms.search.binarySearch;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
//
//    Given the integer n, return the number of complete rows of the staircase you will build.
//    
//    Example 1:
//    |X|
//    |X|X|
//    |X|X| |
//    Input: n = 5
//    Output: 2
//    Explanation: Because the 3rd row is incomplete, we return 2.
//    
//    Example 2:
//    |X|
//    |X|X|
//    |X|X|X|
//    |X|X| | |
//    Input: n = 8
//    Output: 3
//    Explanation: Because the 4th row is incomplete, we return 3.
//    
//    Constraints:
//    1 <= n <= 2^31 - 1



//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
//
//    给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
//
//    示例 1：
//    |X|
//    |X|X|
//    |X|X| |
//    输入：n = 5
//    输出：2
//    解释：因为第三行不完整，所以返回 2 。
//
//    示例 2：
//    |X|
//    |X|X|
//    |X|X|X|
//    |X|X| | |
//    输入：n = 8
//    输出：3
//    解释：因为第四行不完整，所以返回 3 。
//
//    提示：
//    1 <= n <= 2^31 - 1



public class Q441 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(arrangeCoins(n));
    }

    // Method 1: Math problem
//    private static int arrangeCoins(int n) {
//        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
//    }

    // Method 2: binary search
    private static int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
