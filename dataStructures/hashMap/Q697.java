package dataStructures.hashMap;

import utils.InputMethods;

import java.util.*;


//Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
//
//    Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
//
//    Example 1:
//    Input: nums = [1,2,2,3,1]
//    Output: 2
//    Explanation:
//    The input array has a degree of 2 because both elements 1 and 2 appear twice.
//    Of the subarrays that have the same degree:
//    [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//    The shortest length is 2. So return 2.
//
//    Example 2:
//    Input: nums = [1,2,2,3,1,4,2]
//    Output: 6
//    Explanation:
//    The degree is 3 because the element 2 is repeated 3 times.
//    So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
//
//    Constraints:
//    nums.length will be between 1 and 50,000.
//    nums[i] will be an integer between 0 and 49,999.



//给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
//
//    你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
//
//    示例 1：
//    输入：nums = [1,2,2,3,1]
//    输出：2
//    解释：
//    输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
//    连续子数组里面拥有相同度的有如下所示：
//    [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//    最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
//
//    示例 2：
//    输入：nums = [1,2,2,3,1,4,2]
//    输出：6
//    解释：
//    数组的度是 3 ，因为元素 2 重复出现 3 次。
//    所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
//
//    提示：
//    nums.length 在 1 到 50,000 范围内。
//    nums[i] 是一个在 0 到 49,999 范围内的整数。




public class Q697 {
    public static void main(String[] args) {
        System.out.println(findShortestSubArray(InputMethods.getInputForOneIntArray()));
    }

    private static int findShortestSubArray(int[] nums) {
        int len = nums.length, maxCount = 0, minLen = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] pair = map.get(nums[i]);
            if (pair == null) {
                pair = new int[]{i, 1};
                map.put(nums[i], pair);
            } else {
                pair[1]++;
            }
            if (pair[1] > maxCount) {
                maxCount = pair[1];
                minLen = i - pair[0] + 1;
            } else if (pair[1] == maxCount) {
                minLen = Math.min(minLen, i - pair[0] + 1);
            }
        }
        return minLen;
    }
}
