package math;
import java.util.*;
import java.nio.charset.StandardCharsets;


//The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
//
//    By listing and labeling all the permutations in order, we get the following sequence for n = 3:
//        "123"
//        "132"
//        "213"
//        "231"
//        "312"
//        "321"
//
//    Given n and k, return the kth permutation sequence.
//
//    Example 1:
//    Input: n = 3, k = 3
//    Output: "213"
//
//    Example 2:
//    Input: n = 4, k = 9
//    Output: "2314"
//
//    Example 3:
//    Input: n = 3, k = 1
//    Output: "123"
//
//    Constraints:
//    1 <= n <= 9
//    1 <= k <= n!



//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
//    按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//        "123"
//        "132"
//        "213"
//        "231"
//        "312"
//        "321"
//
//    给定 n 和 k，返回第 k 个排列。
//
//    示例 1：
//    输入：n = 3, k = 3
//    输出："213"
//
//    示例 2：
//    输入：n = 4, k = 9
//    输出："2314"
//
//    示例 3：
//    输入：n = 3, k = 1
//    输出："123"
//
//    提示：
//    1 <= n <= 9
//    1 <= k <= n!



public class Q60 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        int k = cin.nextInt();
        cin.close();
        System.out.println(getPermutation(n, k));
    }

    private static String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        k--;
        StringBuilder res = new StringBuilder();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    res.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return res.toString();
    }
}
