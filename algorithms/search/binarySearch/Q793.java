package algorithms.search.binarySearch;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Let f(x) be the number of zeroes at the end of x!. Recall that x! = 1 * 2 * 3 * ... * x and by convention, 0! = 1.
//
//    For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has two zeroes at the end.
//    Given an integer k, return the number of non-negative integers x have the property that f(x) = k.
//
//    Example 1:
//    Input: k = 0
//    Output: 5
//    Explanation: 0!, 1!, 2!, 3!, and 4! end with k = 0 zeroes.
//
//    Example 2:
//    Input: k = 5
//    Output: 0
//    Explanation: There is no x such that x! ends in k = 5 zeroes.
//
//    Example 3:
//    Input: k = 3
//    Output: 5
//
//    Constraints:
//    0 <= k <= 10^9



// f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。
//
//    例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。
//    给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。
//
//    示例 1：
//    输入：k = 0
//    输出：5
//    解释：0!, 1!, 2!, 3!, 和 4! 均符合 k = 0 的条件。
//
//    示例 2：
//    输入：k = 5
//    输出：0
//    解释：没有匹配到这样的 x!，符合 k = 5 的条件。
//
//    示例 3:
//    输入: k = 3
//    输出: 5
//
//    提示:
//    0 <= k <= 10^9



public class Q793 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int k = cin.nextInt();
        cin.close();
        System.out.println(preimageSizeFZF(k));
    }

    private static int preimageSizeFZF(int k) {
        return (int) (help(k + 1) - help(k));
    }

    public static long help(int k) {
        long r = 5L * k;
        long l = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (zeta(mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }

    public static long zeta(long x) {
        long res = 0;
        while (x != 0) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }
}
