package algorithms.math;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)
//
//    (Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)
//
//    Since the answer may be large, return the answer modulo 10^9 + 7.
//
//    Example 1:
//    Input: n = 5
//    Output: 12
//    Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
//
//    Example 2:
//    Input: n = 100
//    Output: 682289015
//
//    Constraints:
//    1 <= n <= 100


//请你帮忙给从 1 到 n的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
//
//    让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
//
//    由于答案可能会很大，所以请你返回答案 模 mod10^9 + 7之后的结果即可。
//
//    示例 1：
//    输入：n = 5
//    输出：12
//    解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
//
//    示例 2：
//    输入：n = 100
//    输出：682289015
//
//    提示：
//    1 <= n <= 100


public class Q1175 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();

        int result = numPrimeArrangements(n);
        System.out.println(result);
    }

    private static int numPrimeArrangements(int n) {
        int primeNumCount = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrimeNum(i)) {
                primeNumCount++;
            }
        }
        return (int) (calculateFactorial(primeNumCount) * calculateFactorial(n - primeNumCount) % MOD);
    }

    public static boolean isPrimeNum(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long calculateFactorial(int num) {
        long res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
            res %= MOD;
        }
        return res;
    }
}
