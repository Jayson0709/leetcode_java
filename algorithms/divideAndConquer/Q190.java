package algorithms.divideAndConquer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Reverse bits of a given 32 bits unsigned integer.
//
//    Note:
//    Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
//    In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
//    
//    Example 1:
//    Input: n = 00000010100101000001111010011100
//    Output:    964176192 (00111001011110000010100101000000)
//    Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
//
//    Example 2:
//    Input: n = 11111111111111111111111111111101
//    Output:   3221225471 (10111111111111111111111111111111)
//    Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
//    
//    Constraints:
//    The input must be a binary string of length 32
//    
//    Follow up: If this function is called many times, how would you optimize it?



//颠倒给定的 32 位无符号整数的二进制位。
//
//    提示：
//    请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
//    在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
//
//    示例 1：
//    输入：n = 00000010100101000001111010011100
//    输出：964176192 (00111001011110000010100101000000)
//    解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
//    因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
//
//    示例 2：
//    输入：n = 11111111111111111111111111111101
//    输出：3221225471 (10111111111111111111111111111111)
//    解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
//    因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
//
//    提示：
//    输入是一个长度为 32 的二进制字符串
//
//    进阶: 如果多次调用这个函数，你将如何优化你的算法？


public class Q190 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        // Due to the fact that there is no unsigned integer in Java, so we just directly input an integer to process.
        int n = cin.nextInt();
        cin.close();
        System.out.println(reverseBits(n));
    }

    // Method 1: Bit manipulation
//    private static int reverseBits(int n) {
//        int rev = 0;
//        for (int i = 0; i < 32 && n != 0; ++i) {
//            rev |= (n & 1) << (31 - i);
//            n >>>= 1;
//        }
//        return rev;
//    }

    // Method 2: Divide and Conquer
    // Ref: https://leetcode.cn/problems/reverse-bits/solution/dian-dao-er-jin-zhi-wei-by-leetcode-solu-yhxz/
    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    private static int reverseBits(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }
}
