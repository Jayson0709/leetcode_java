package dataStructures.array.simpleArray;

import utils.InputMethods;


//You are given an integer array nums of length n which represents a permutation of all the integers in the range [0, n - 1].
//
//    The number of global inversions is the number of the different pairs (i, j) where:
//
//    0 <= i < j < n
//    nums[i] > nums[j]
//    The number of local inversions is the number of indices i where:
//
//    0 <= i < n - 1
//    nums[i] > nums[i + 1]
//    Return true if the number of global inversions is equal to the number of local inversions.
//
//    Example 1:
//    Input: nums = [1,0,2]
//    Output: true
//    Explanation: There is 1 global inversion and 1 local inversion.
//
//    Example 2:
//    Input: nums = [1,2,0]
//    Output: false
//    Explanation: There are 2 global inversions and 1 local inversion.
//
//    Constraints:
//    n == nums.length
//    1 <= n <= 10^5
//    0 <= nums[i] < n
//    All the integers of nums are unique.
//    nums is a permutation of all the numbers in the range [0, n - 1].



//给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
//
//    全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
//
//    0 <= i < j < n
//    nums[i] > nums[j]
//    局部倒置 的数目等于满足下述条件的下标 i 的数目：
//
//    0 <= i < n - 1
//    nums[i] > nums[i + 1]
//    当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
//
//    示例 1：
//    输入：nums = [1,0,2]
//    输出：true
//    解释：有 1 个全局倒置，和 1 个局部倒置。
//
//    示例 2：
//    输入：nums = [1,2,0]
//    输出：false
//    解释：有 2 个全局倒置，和 1 个局部倒置。
//
//    提示：
//    n == nums.length
//    1 <= n <= 5000
//    0 <= nums[i] < n
//    nums 中的所有整数 互不相同
//    nums 是范围 [0, n - 1] 内所有数字组成的一个排列


public class Q775 {
    public static void main(String[] args) {
        System.out.println(isIdealPermutation(InputMethods.getInputForOneIntArray()));
    }

    private static boolean isIdealPermutation(int[] nums) {
        int n = nums.length, minStuff = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minStuff) {
                return false;
            }
            minStuff = Math.min(minStuff, nums[i + 1]);
        }
        return true;
    }
}
