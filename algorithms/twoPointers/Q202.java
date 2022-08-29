package algorithms.twoPointers;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Write an algorithm to determine if a number n is happy.
//
//    A happy number is a number defined by the following process:
//
//    Starting with any positive integer, replace the number by the sum of the squares of its digits.
//    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//    Those numbers for which this process ends in 1 are happy.
//    Return true if n is a happy number, and false if not.
//
//    Example 1:
//    Input: n = 19
//    Output: true
//    Explanation:
//    1^2 + 9^2 = 82
//    8^2 + 2^2 = 68
//    6^2 + 8^2 = 100
//    1^2 + 0^2 + 0^2 = 1
//
//    Example 2:
//    Input: n = 2
//    Output: false
//
//    Constraints:
//    1 <= n <= 2^31 - 1



//编写一个算法来判断一个数 n 是不是快乐数。
//
//    「快乐数」 定义为：
//
//    对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//    然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//    如果这个过程 结果为 1，那么这个数就是快乐数。
//    如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
//
//    示例 1：
//    输入：n = 19
//    输出：true
//    解释：
//    1^2 + 9^2 = 82
//    8^2 + 2^2 = 68
//    6^2 + 8^2 = 100
//    1^2 + 0^2 + 0^2 = 1
//
//    示例 2：
//    输入：n = 2
//    输出：false
//
//    提示：
//    1 <= n <= 2^31 - 1


public class Q202 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(isHappy(n));
    }

    // Method 1: use HashSet
//    private static boolean isHappy(int n) {
//        Set<Integer> seen = new HashSet<>();
//        while (n != 1 && !seen.contains(n)) {
//            seen.add(n);
//            n = getNext(n);
//        }
//        return n == 1;
//    }
//
//    private static int getNext(int n) {
//        int totalSum = 0;
//        while (n > 0) {
//            int digit = n % 10;
//            n = n / 10;
//            totalSum += digit * digit;
//        }
//        return totalSum;
//    }

    // Method 2: two pointers
    private static boolean isHappy(int n) {
        int slowPtr = n;
        int fastPtr = getNext(n);
        while (fastPtr != 1 && slowPtr != fastPtr) {
            slowPtr = getNext(slowPtr);
            fastPtr = getNext(getNext(fastPtr));
        }
        return fastPtr == 1;
    }

    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            totalSum += digit * digit;
        }
        return totalSum;
    }
}
