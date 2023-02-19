package dataStructures.hashMap;


import utils.InputMethods;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//You are given a 0-indexed integer array nums. In one operation, you may do the following:
//
//    Choose two integers in nums that are equal.
//    Remove both integers from nums, forming a pair.
//    The operation is done on nums as many times as possible.
//
//    Return a 0-indexed integer array answer of size 2 where answer[0] is the number of pairs that are formed and answer[1] is the number of leftover integers in nums after doing the operation as many times as possible.
//
//    Example 1:
//    Input: nums = [1,3,2,1,3,2,2]
//    Output: [3,1]
//    Explanation:
//    Form a pair with nums[0] and nums[3] and remove them from nums. Now, nums = [3,2,3,2,2].
//    Form a pair with nums[0] and nums[2] and remove them from nums. Now, nums = [2,2,2].
//    Form a pair with nums[0] and nums[1] and remove them from nums. Now, nums = [2].
//    No more pairs can be formed. A total of 3 pairs have been formed, and there is 1 number leftover in nums.
//
//    Example 2:
//    Input: nums = [1,1]
//    Output: [1,0]
//    Explanation: Form a pair with nums[0] and nums[1] and remove them from nums. Now, nums = [].
//    No more pairs can be formed. A total of 1 pair has been formed, and there are 0 numbers leftover in nums.
//
//    Example 3:
//    Input: nums = [0]
//    Output: [0,1]
//    Explanation: No pairs can be formed, and there is 1 number leftover in nums.
//
//    Constraints:
//    1 <= nums.length <= 100
//    0 <= nums[i] <= 100


//给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
//
//    从 nums 选出 两个 相等的 整数
//    从 nums 中移除这两个整数，形成一个 数对
//    请你在 nums 上多次执行此操作直到无法继续执行。
//
//    返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
//
//    示例 1：
//    输入：nums = [1,3,2,1,3,2,2]
//    输出：[3,1]
//    解释：
//    nums[0] 和 nums[3] 形成一个数对，并从 nums 中移除，nums = [3,2,3,2,2] 。
//    nums[0] 和 nums[2] 形成一个数对，并从 nums 中移除，nums = [2,2,2] 。
//    nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [2] 。
//    无法形成更多数对。总共形成 3 个数对，nums 中剩下 1 个数字。
//
//    示例 2：
//    输入：nums = [1,1]
//    输出：[1,0]
//    解释：nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [] 。
//    无法形成更多数对。总共形成 1 个数对，nums 中剩下 0 个数字。
//
//    示例 3：
//    输入：nums = [0]
//    输出：[0,1]
//    解释：无法形成数对，nums 中剩下 1 个数字。
//
//    提示：
//    1 <= nums.length <= 100
//    0 <= nums[i] <= 100


public class Q2341 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfPairs(InputMethods.getInputForOneIntArray())));
    }

    private static int[] numberOfPairs(int[] nums) {
        Map<Integer, Boolean> count = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            count.put(num, !count.getOrDefault(num, false));
            if (!count.get(num)) {
                res++;
            }
        }
        return new int[]{res, nums.length - 2 * res};
    }
}
