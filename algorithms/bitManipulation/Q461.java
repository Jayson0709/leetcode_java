package algorithms.bitManipulation;
import java.util.*;
import java.nio.charset.StandardCharsets;


//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//
//    Given two integers x and y, return the Hamming distance between them.
//    
//    Example 1:
//    Input: x = 1, y = 4
//    Output: 2
//    Explanation:
//    1   (0 0 0 1)
//    4   (0 1 0 0)
//    ↑   ↑
//    The above arrows point to positions where the corresponding bits are different.
//    
//    Example 2:
//    Input: x = 3, y = 1
//    Output: 1
//
//    Constraints:
//    0 <= x, y <= 2^31 - 1



//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
//
//    给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
//
//    示例 1：
//    输入：x = 1, y = 4
//    输出：2
//    解释：
//    1   (0 0 0 1)
//    4   (0 1 0 0)
//    ↑   ↑
//    上面的箭头指出了对应二进制位不同的位置。
//
//    示例 2：
//    输入：x = 3, y = 1
//    输出：1
//
//    提示：
//    0 <= x, y <= 2^31 - 1



public class Q461 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int x = cin.nextInt();
        int y = cin.nextInt();
        cin.close();
        System.out.println(hammingDistance(x, y));
    }

    // Method 1: simple use bit shifting
    private static int hammingDistance(int x, int y) {
        int s = x ^ y, res = 0;
        while (s != 0) {
            res += s & 1;
            s >>= 1;
        }
        return res;
    }

    // Method 2: use Brian Kernighan algorithm
//    private static int hammingDistance(int x, int y) {
//        int s = x ^ y, res = 0;
//        while (s != 0) {
//            s &= s - 1;
//            res++;
//        }
//        return res;
//    }
}
