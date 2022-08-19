package algorithms.search.binarySearch;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a positive integer num, write a function which returns True if num is a perfect square else False.
//
//    Follow up: Do not use any built-in library function such as sqrt.
//
//    Example 1:
//    Input: num = 16
//    Output: true
//
//    Example 2:
//    Input: num = 14
//    Output: false
//
//    Constraints:
//    1 <= num <= 2^31 - 1


//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
//    进阶：不要 使用任何内置的库函数，如  sqrt 。
//
//    示例 1：
//    输入：num = 16
//    输出：true
//
//    示例 2：
//    输入：num = 14
//    输出：false
//
//    提示：
//    1 <= num <= 2^31 - 1



public class Q367 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int num = cin.nextInt();
        cin.close();
        System.out.println(isPerfectSquare(num));
    }

    private static boolean isPerfectSquare(int num) {
        int l = 0, r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long square = (long) mid * mid;
            if (square < num) {
                l = mid + 1;
            } else if (square > num) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
