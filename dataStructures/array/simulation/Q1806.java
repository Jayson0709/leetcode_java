package dataStructures.array.simulation;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


//You are given an even integer n. You initially have a permutation perm of size n where perm[i] == i (0-indexed).
//
//    In one operation, you will create a new array arr, and for each i:
//
//    If i % 2 == 0, then arr[i] = perm[i / 2].
//    If i % 2 == 1, then arr[i] = perm[n / 2 + (i - 1) / 2].
//    You will then assign arr to perm.
//
//    Return the minimum non-zero number of operations you need to perform on perm to return the permutation to its initial value.
//
//
//
//    Example 1:
//    Input: n = 2
//    Output: 1
//    Explanation: perm = [0,1] initially.
//    After the 1st operation, perm = [0,1]
//    So it takes only 1 operation.
//
//    Example 2:
//    Input: n = 4
//    Output: 2
//    Explanation: perm = [0,1,2,3] initially.
//    After the 1st operation, perm = [0,2,1,3]
//    After the 2nd operation, perm = [0,1,2,3]
//    So it takes only 2 operations.
//
//    Example 3:
//    Input: n = 6
//    Output: 4
//
//
//    Constraints:
//    2 <= n <= 1000
//    n is even.


//给你一个偶数 n ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i（下标 从 0 开始 计数）。
//
//    一步操作中，你将创建一个新数组 arr ，对于每个 i ：
//
//    如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
//    如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
//    然后将 arr 赋值给 perm 。
//
//    要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
//
//    示例 1：
//    输入：n = 2
//    输出：1
//    解释：最初，perm = [0,1]
//    第 1 步操作后，perm = [0,1]
//    所以，仅需执行 1 步操作
//
//    示例 2：
//    输入：n = 4
//    输出：2
//    解释：最初，perm = [0,1,2,3]
//    第 1 步操作后，perm = [0,2,1,3]
//    第 2 步操作后，perm = [0,1,2,3]
//    所以，仅需执行 2 步操作
//
//    示例 3：
//    输入：n = 6
//    输出：4
//
//    提示：
//    2 <= n <= 1000
//    n 是一个偶数


public class Q1806 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(reinitializePermutation(n));
    }

    private static int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }
        int step = 0;
        do {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) != 0) {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                } else {
                    arr[i] = perm[i / 2];
                }
            }
            perm = arr;
            step++;
        } while (!Arrays.equals(perm, target));
        return step;
    }
}
