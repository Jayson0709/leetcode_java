package algorithms.sorting;

import utils.InputMethods;

import java.util.Arrays;


//Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
//
//    Example 1:
//    Input: nums = [3,4,5,2]
//    Output: 12
//    Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
//
//    Example 2:
//    Input: nums = [1,5,4,5]
//    Output: 16
//    Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
//
//    Example 3:
//    Input: nums = [3,7]
//    Output: 12
//
//    Constraints:
//    2 <= nums.length <= 500
//    1 <= nums[i] <= 10^3



//给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
//
//    请你计算并返回该式的最大值。
//
//    示例 1：
//    输入：nums = [3,4,5,2]
//    输出：12
//    解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
//
//    示例 2：
//    输入：nums = [1,5,4,5]
//    输出：16
//    解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
//
//    示例 3：
//    输入：nums = [3,7]
//    输出：12
//
//    提示：
//    2 <= nums.length <= 500
//    1 <= nums[i] <= 10^3



public class Q1464 {
    public static void main(String[] args) {
        System.out.println(maxProduct(InputMethods.getInputForOneIntArray()));
    }

    private static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}
