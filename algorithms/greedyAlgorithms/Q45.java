package algorithms.greedyAlgorithms;

import utils.InputMethods;


//Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//
//    Each element in the array represents your maximum jump length at that position.
//
//    Your goal is to reach the last index in the minimum number of jumps.
//
//    You can assume that you can always reach the last index.
//
//    Example 1:
//    Input: nums = [2,3,1,1,4]
//    Output: 2
//    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//    Example 2:
//    Input: nums = [2,3,0,1,4]
//    Output: 2
//
//    Constraints:
//    1 <= nums.length <= 10^4
//    0 <= nums[i] <= 1000


//给你一个非负整数数组nums ，你最初位于数组的第一个位置。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
//    假设你总是可以到达数组的最后一个位置。
//
//    示例 1:
//    输入: nums = [2,3,1,1,4]
//    输出: 2
//    解释: 跳到最后一个位置的最小跳跃数是 2。
//        从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
//
//    示例 2:
//    输入: nums = [2,3,0,1,4]
//    输出: 2
//
//    提示:
//    1 <= nums.length <= 10^4
//    0 <= nums[i] <= 1000



public class Q45 {
    public static void main(String[] args) {
        int result = jump(InputMethods.getInputForOneIntArray());
        System.out.println(result);
    }

    private static int jump(int[] nums) {
        int n = nums.length, endPos = 0, localMax = 0, result = 0;
        for (int i = 0; i < n - 1; i++) {
            localMax = Math.max(localMax, i + nums[i]);
            if (i == endPos) {
                endPos = localMax;
                result++;
            }
        }
        return result;
    }
}
