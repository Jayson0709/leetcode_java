package dataStructures.array.simulation;

import utils.InputMethods;

import java.util.*;


//Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
//
//    Return the sorted array.
//
//    Example 1:
//    Input: nums = [1,1,2,2,2,3]
//    Output: [3,1,1,2,2,2]
//    Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
//
//    Example 2:
//    Input: nums = [2,3,1,3,2]
//    Output: [1,3,3,2,2]
//    Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
//
//    Example 3:
//    Input: nums = [-1,1,-6,4,5,-6,1,4,1]
//    Output: [5,-1,4,4,-6,-6,1,1,1]
//
//    Constraints:
//    1 <= nums.length <= 100
//    -100 <= nums[i] <= 100



//给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
//
//    请你返回排序后的数组。
//
//    示例 1：
//    输入：nums = [1,1,2,2,2,3]
//    输出：[3,1,1,2,2,2]
//    解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
//
//    示例 2：
//    输入：nums = [2,3,1,3,2]
//    输出：[1,3,3,2,2]
//    解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
//
//    示例 3：
//    输入：nums = [-1,1,-6,4,5,-6,1,4,1]
//    输出：[5,-1,4,4,-6,-6,1,1,1]
//
//    提示：
//    1 <= nums.length <= 100
//    -100 <= nums[i] <= 100


public class Q1636 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(InputMethods.getInputForOneIntArray())));
    }

    private static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int num : nums) {
            hMap.put(num, hMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> data = new ArrayList<>();
        for (int num : nums) {
            data.add(num);
        }
        data.sort((a, b) -> {
            int frequency1 = hMap.get(a), frequency2 = hMap.get(b);
            return frequency1 != frequency2 ? frequency1 - frequency2 : b - a;
        });
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = data.get(i);
        }
        return nums;
    }
}
