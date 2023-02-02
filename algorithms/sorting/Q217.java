package algorithms.sorting;

import utils.InputMethods;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//
//    Example 1:
//    Input: nums = [1,2,3,1]
//    Output: true
//
//    Example 2:
//    Input: nums = [1,2,3,4]
//    Output: false
//
//    Example 3:
//    Input: nums = [1,1,1,3,3,4,3,2,4,2]
//    Output: true
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    -10^9 <= nums[i] <= 10^9


//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//
//    示例 1：
//    输入：nums = [1,2,3,1]
//    输出：true
//
//    示例 2：
//    输入：nums = [1,2,3,4]
//    输出：false
//
//    示例 3：
//    输入：nums = [1,1,1,3,3,4,3,2,4,2]
//    输出：true
//
//    提示：
//    1 <= nums.length <= 10^5
//    -10^9 <= nums[i] <= 10^9


public class Q217 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(InputMethods.getInputForOneIntArray()));
    }

    // Method 1: use HashMap
//    private static boolean containsDuplicate(int[] nums) {
//        Map<Integer, Integer> mapCount = new HashMap<>();
//        for (int num : nums) {
//            mapCount.put(num, mapCount.getOrDefault(num, 0) + 1);
//        }
//        return nums.length != mapCount.size();
//    }

    // Method 2: use sort
    private static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
