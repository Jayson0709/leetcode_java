package algorithms.bitManipulation;

import utils.InputMethods;

import java.util.HashMap;
import java.util.Map;


//Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
//
//    You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//    Example 1:
//    Input: nums = [2,2,3,2]
//    Output: 3
//
//    Example 2:
//    Input: nums = [0,1,0,1,0,1,99]
//    Output: 99
//
//    Constraints:
//    1 <= nums.length <= 3 * 10^4
//    -2^31 <= nums[i] <= 2^31 - 1
//    Each element in nums appears exactly three times except for one element which appears once.


//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//
//    你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。
//
//    示例 1：
//    输入：nums = [2,2,3,2]
//    输出：3
//
//    示例 2：
//    输入：nums = [0,1,0,1,0,1,99]
//    输出：99
//
//    提示：
//    1 <= nums.length <= 3 * 10^4
//    -2^31 <= nums[i] <= 2^31 - 1
//    nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次


public class Q137 {
    public static void main(String[] args) {
        System.out.println(singleNumber(InputMethods.getInputForOneIntArray()));
    }

    // Method 1: use HashMap (simple approach, with high space complexity)
//    private static int singleNumber(int[] nums) {
//        Map<Integer, Integer> freq = new HashMap<>();
//        for (int num : nums) {
//            freq.put(num, freq.getOrDefault(num, 0) + 1);
//        }
//        int ans = 0;
//        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
//            int num = entry.getKey();
//            int occurrence = entry.getValue();
//            if (occurrence == 1) {
//                ans = num;
//                break;
//            }
//        }
//        return ans;
//    }

    // Method 2: bit manipulation
    private static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
