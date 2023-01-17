package dataStructures.hashMap;

import utils.InputMethods;

import java.util.HashMap;
import java.util.Map;


//You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
//
//    0 <= i < j < nums.length
//    nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
//    Return the number of nice pairs of indices. Since that number can be too large, return it modulo 10^9 + 7.
//
//    Example 1:
//    Input: nums = [42,11,1,97]
//    Output: 2
//    Explanation: The two pairs are:
//    - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
//    - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
//
//    Example 2:
//    Input: nums = [13,10,35,24,76]
//    Output: 4
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    0 <= nums[i] <= 10^9


//给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
//
//    0 <= i < j < nums.length
//    nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
//    请你返回好下标对的数目。由于结果可能会很大，请将结果对 10^9 + 7 取余 后返回。
//
//    示例 1：
//    输入：nums = [42,11,1,97]
//    输出：2
//    解释：两个坐标对为：
//    - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
//    - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
//
//    示例 2：
//    输入：nums = [13,10,35,24,76]
//    输出：4
//
//    提示：
//    1 <= nums.length <= 10^5
//    0 <= nums[i] <= 10^9

public class Q1814 {
    public static void main(String[] args) {
        System.out.println(countNicePairs(InputMethods.getInputForOneIntArray()));
    }

    private static int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        int res = 0;
        Map<Integer, Integer> h = new HashMap<>();
        for (int i : nums) {
            int temp = i, j = 0;
            while (temp > 0) {
                j = j * 10 + temp % 10;
                temp /= 10;
            }
            res = (res + h.getOrDefault(i - j, 0)) % MOD;
            h.put(i - j, h.getOrDefault(i - j, 0) + 1);
        }
        return res;
    }
}
