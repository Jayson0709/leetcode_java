package dataStructures.array.simulation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order. Apply the following algorithm on arr:
//
//    Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
//    Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
//    Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
//    Given the integer n, return the last number that remains in arr.
//
//    Example 1:
//    Input: n = 9
//    Output: 6
//    Explanation:
//    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
//    arr = [2, 4, 6, 8]
//    arr = [2, 6]
//    arr = [6]
//
//    Example 2:
//    Input: n = 1
//    Output: 1
//
//    Constraints:
//    1 <= n <= 10^9




//列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
//
//    从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
//    重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
//    不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
//    给你整数 n ，返回 arr 最后剩下的数字。
//
//    示例 1：
//    输入：n = 9
//    输出：6
//    解释：
//    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
//    arr = [2, 4, 6, 8]
//    arr = [2, 6]
//    arr = [6]
//
//    示例 2：
//    输入：n = 1
//    输出：1
//
//    提示：
//    1 <= n <= 10^9



public class Q390 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(lastRemaining(n));
    }

    private static int lastRemaining(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) {
                a1 = a1 + step;
            } else {
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }
}
