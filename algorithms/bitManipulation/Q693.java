package algorithms.bitManipulation;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
//
//    Example 1:
//    Input: n = 5
//    Output: true
//    Explanation: The binary representation of 5 is: 101
//
//    Example 2:
//    Input: n = 7
//    Output: false
//    Explanation: The binary representation of 7 is: 111.
//
//    Example 3:
//    Input: n = 11
//    Output: false
//    Explanation: The binary representation of 11 is: 1011.
//
//    Constraints:
//    1 <= n <= 2^31 - 1



//给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
//
//    示例 1：
//    输入：n = 5
//    输出：true
//    解释：5 的二进制表示是：101
//
//    示例 2：
//    输入：n = 7
//    输出：false
//    解释：7 的二进制表示是：111.
//
//    示例 3：
//    输入：n = 11
//    输出：false
//    解释：11 的二进制表示是：1011.
//
//    提示：
//    1 <= n <= 2^31 - 1



public class Q693 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(hasAlternatingBits(n));
    }

    // Method 1: Stimulation
//    private static boolean hasAlternatingBits(int n) {
//        int prev = 2;
//        while (n != 0) {
//            int cur = n % 2;
//            if (cur == prev) {
//                return false;
//            }
//            prev = cur;
//            n /= 2;
//        }
//        return true;
//    }


    // Method 2: Bit manipulation
    private static boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }
}
