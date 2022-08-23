package algorithms.bitManipulation;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given an integer n and an integer start.
//
//    Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.
//
//    Return the bitwise XOR of all elements of nums.
//
//    Example 1:
//    Input: n = 5, start = 0
//    Output: 8
//    Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
//    Where "^" corresponds to bitwise XOR operator.
//
//    Example 2:
//    Input: n = 4, start = 3
//    Output: 8
//    Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.
//
//    Constraints:
//    1 <= n <= 1000
//    0 <= start <= 1000
//    n == nums.length



//给你两个整数，n 和 start 。
//
//    数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
//
//    请返回 nums 中所有元素按位异或（XOR）后得到的结果。
//
//    示例 1：
//    输入：n = 5, start = 0
//    输出：8
//    解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
//    "^" 为按位异或 XOR 运算符。
//
//    示例 2：
//    输入：n = 4, start = 3
//    输出：8
//    解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
//
//    示例 3：
//    输入：n = 1, start = 7
//    输出：7
//
//    示例 4：
//    输入：n = 10, start = 5
//    输出：2
//
//    提示：
//    1 <= n <= 1000
//    0 <= start <= 1000
//    n == nums.length



public class Q1486 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        int start = cin.nextInt();
        cin.close();
        System.out.println(xorOperation(n, start));
    }

    // Method 1: Stimulation
    private static int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res ^= (start + i * 2);
        }
        return res;
    }

    // Method 2: Pure math
//    private static int xorOperation(int n, int start) {
//        int s = start >> 1, e = n & start & 1;
//        int res = sumXor(s - 1) ^ sumXor(s + n - 1);
//        return res << 1 | e;
//    }
//
//    public static int sumXor(int x) {
//        if (x % 4 == 0) {
//            return x;
//        }
//        if (x % 4 == 1) {
//            return 1;
//        }
//        if (x % 4 == 2) {
//            return x + 1;
//        }
//        return 0;
//    }
}
