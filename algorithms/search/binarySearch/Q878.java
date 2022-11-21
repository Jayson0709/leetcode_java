package algorithms.search.binarySearch;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//A positive integer is magical if it is divisible by either a or b.
//
//    Given the three integers n, a, and b, return the nth magical number. Since the answer may be very large, return it modulo 10^9 + 7.
//
//    Example 1:
//    Input: n = 1, a = 2, b = 3
//    Output: 2
//
//    Example 2:
//    Input: n = 4, a = 2, b = 3
//    Output: 6
//
//    Constraints:
//    1 <= n <= 10^9
//    2 <= a, b <= 4 * 10^4


//一个正整数如果能被 a 或 b 整除，那么它是神奇的。
//
//    给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10^9 + 7 取模 后的值。
//
//    示例 1：
//    输入：n = 1, a = 2, b = 3
//    输出：2
//
//    示例 2：
//    输入：n = 4, a = 2, b = 3
//    输出：6
//
//    提示：
//    1 <= n <= 10^9
//    2 <= a, b <= 4 * 10^4


public class Q878 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = Integer.parseInt(cin.nextLine().strip());
        int a =  Integer.parseInt(cin.nextLine().strip());
        int b = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        System.out.println(nthMagicalNumber(n, a, b));
    }

    static final int MOD = 1000000007;

    private static int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b);
        long r = (long) n * Math.min(a, b);
        int c = lcm(a, b);
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % MOD);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
