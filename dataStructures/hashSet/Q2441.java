package dataStructures.hashSet;

import utils.InputMethods;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


//Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
//
//    Return the positive integer k. If there is no such integer, return -1.
//
//    Example 1:
//    Input: nums = [-1,2,-3,3]
//    Output: 3
//    Explanation: 3 is the only valid k we can find in the array.
//
//    Example 2:
//    Input: nums = [-1,10,6,7,-7,1]
//    Output: 7
//    Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
//
//    Example 3:
//    Input: nums = [-10,8,6,7,-2,-3]
//    Output: -1
//    Explanation: There is no a single valid k, we return -1.
//
//    Constraints:
//    1 <= nums.length <= 1000
//    -1000 <= nums[i] <= 1000
//    nums[i] != 0


//给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
//
//    返回正整数 k ，如果不存在这样的整数，返回 -1 。
//
//    示例 1：
//    输入：nums = [-1,2,-3,3]
//    输出：3
//    解释：3 是数组中唯一一个满足题目要求的 k 。
//
//    示例 2：
//    输入：nums = [-1,10,6,7,-7,1]
//    输出：7
//    解释：数组中存在 1 和 7 对应的负数，7 的值更大。
//
//    示例 3：
//    输入：nums = [-10,8,6,7,-2,-3]
//    输出：-1
//    解释：不存在满足题目要求的 k ，返回 -1 。
//
//    提示：
//    1 <= nums.length <= 1000
//    -1000 <= nums[i] <= 1000
//    nums[i] != 0


public class Q2441 {
    public static void main(String[] args) {
        System.out.println(findMaxK(InputMethods.getInputForOneIntArray()));
    }

    // Method 1: use HashSet
    public static int findMaxK(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int res = -1;
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int num : nums) {
            if (hashSet.contains(-num)) {
                res = Math.max(res, num);
            }
        }
        return res;
    }

    // Method 2: use sort + two pointers
//    public static int findMaxK(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0, j = nums.length - 1; i < j; j--) {
//            while (i < j && nums[i] < -nums[j]) {
//                i++;
//            }
//            if (nums[i] == -nums[j]) {
//                return nums[j];
//            }
//        }
//        return -1;
//    }
}