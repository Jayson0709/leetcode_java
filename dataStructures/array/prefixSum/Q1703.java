package dataStructures.array.prefixSum;

import utils.InputMethods;
import utils.OneDIntArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//You are given an integer array, nums, and an integer k. nums comprises of only 0's and 1's. In one move, you can choose two adjacent indices and swap their values.
//
//    Return the minimum number of moves required so that nums has k consecutive 1's.
//
//    Example 1:
//    Input: nums = [1,0,0,1,0,1], k = 2
//    Output: 1
//    Explanation: In 1 move, nums could be [1,0,0,0,1,1] and have 2 consecutive 1's.
//
//    Example 2:
//    Input: nums = [1,0,0,0,0,0,1,1], k = 3
//    Output: 5
//    Explanation: In 5 moves, the leftmost 1 can be shifted right until nums = [0,0,0,0,0,1,1,1].
//
//    Example 3:
//    Input: nums = [1,1,0,1], k = 2
//    Output: 0
//    Explanation: nums already has 2 consecutive 1's.
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    nums[i] is 0 or 1.
//    1 <= k <= sum(nums)


//给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。每一次移动，你可以选择 相邻 两个数字并将它们交换。
//
//    请你返回使 nums 中包含 k 个 连续 1 的 最少 交换次数。
//
//    示例 1：
//    输入：nums = [1,0,0,1,0,1], k = 2
//    输出：1
//    解释：在第一次操作时，nums 可以变成 [1,0,0,0,1,1] 得到连续两个 1 。
//
//    示例 2：
//    输入：nums = [1,0,0,0,0,0,1,1], k = 3
//    输出：5
//    解释：通过 5 次操作，最左边的 1 可以移到右边直到 nums 变为 [0,0,0,0,0,1,1,1] 。
//
//    示例 3：
//    输入：nums = [1,1,0,1], k = 2
//    输出：0
//    解释：nums 已经有连续 2 个 1 了。
//
//    提示：
//    1 <= nums.length <= 10^5
//    nums[i] 要么是 0 ，要么是 1 。
//    1 <= k <= sum(nums)


public class Q1703 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDIntArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(minMoves(obj.array, obj.val));
    }

    private static int minMoves(int[] nums, int k) {
        List<Integer> g = new ArrayList<>();
        List<Integer> preSum = new ArrayList<>();
        preSum.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                g.add(i - g.size());
                preSum.add(preSum.get(preSum.size() - 1) + g.get(g.size() - 1));
            }
        }
        int m = g.size(), res = Integer.MAX_VALUE;
        for (int i = 0; i <= m - k; i++) {
            int mid = i + k / 2;
            int r = g.get(mid);
            res = Math.min(res, (1 - k % 2) * r + (preSum.get(i + k) - preSum.get(mid + 1)) -
                (preSum.get(mid) - preSum.get(i)));
        }
        return res;
    }
}
