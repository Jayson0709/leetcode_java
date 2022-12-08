package algorithms.greedyAlgorithms;

import utils.InputMethods;

import java.util.Arrays;


//You are given a 0-indexed array nums consisting of n positive integers.
//
//    The array nums is called alternating if:
//
//    nums[i - 2] == nums[i], where 2 <= i <= n - 1.
//    nums[i - 1] != nums[i], where 1 <= i <= n - 1.
//    In one operation, you can choose an index i and change nums[i] into any positive integer.
//
//    Return the minimum number of operations required to make the array alternating.
//
//    Example 1:
//    Input: nums = [3,1,3,2,4,3]
//    Output: 3
//    Explanation:
//    One way to make the array alternating is by converting it to [3,1,3,1,3,1].
//    The number of operations required in this case is 3.
//    It can be proven that it is not possible to make the array alternating in less than 3 operations.
//
//    Example 2:
//    Input: nums = [1,2,2,2,2]
//    Output: 2
//    Explanation:
//    One way to make the array alternating is by converting it to [1,2,1,2,1].
//    The number of operations required in this case is 2.
//    Note that the array cannot be converted to [2,2,2,2,2] because in this case nums[0] == nums[1] which violates the conditions of an alternating array.
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^5


//给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。
//
//    如果满足下述条件，则数组 nums 是一个 交替数组 ：
//
//    nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
//    nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
//    在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。
//
//    返回使数组变成交替数组的 最少操作数 。
//
//    示例 1：
//    输入：nums = [3,1,3,2,4,3]
//    输出：3
//    解释：
//    使数组变成交替数组的方法之一是将该数组转换为 [3,1,3,1,3,1] 。
//    在这种情况下，操作数为 3 。
//    可以证明，操作数少于 3 的情况下，无法使数组变成交替数组。
//
//    示例 2：
//    输入：nums = [1,2,2,2,2]
//    输出：2
//    解释：
//    使数组变成交替数组的方法之一是将该数组转换为 [1,2,1,2,1].
//    在这种情况下，操作数为 2 。
//    注意，数组不能转换成 [2,2,2,2,2] 。因为在这种情况下，nums[0] == nums[1]，不满足交替数组的条件。
//
//    提示：
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^5



public class Q2170 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(InputMethods.getInputForOneIntArray()));
    }

    static int N = 100010;
    static int[] m1 = new int[N], m2 = new int[N];

    private static int minimumOperations(int[] nums) {
        int n = nums.length;
        Arrays.fill(m1, 0);
        Arrays.fill(m2, 0);
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (i % 2 == 0) {
                m1[t]++;
                if (a == 0 || m1[t] > m1[a]) {
                    b = a;
                    a = t;
                } else if (t != a && (b == 0 || m1[t] > m1[b])) {
                    b = t;
                }
            } else {
                m2[t]++;
                if (c == 0 || m2[t] > m2[c]) {
                    d = c;
                    c = t;
                } else if (t != c && (d == 0 || m2[t] > m2[d])) {
                    d = t;
                }
            }
        }
        if (a != c) {
            return n - m1[a] - m2[c];
        } else {
            return n - Math.max(m1[a] + m2[d], m1[b] + m2[c]);
        }
    }
}
