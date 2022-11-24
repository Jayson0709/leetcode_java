package dataStructures.array.simpleArray;


import utils.InputMethods;
import utils.OneDIntArrayAndTwoInt;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].
//
//    The test cases are generated so that the answer will fit in a 32-bit integer.
//
//    Example 1:
//    Input: nums = [2,1,4,3], left = 2, right = 3
//    Output: 3
//    Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
//
//    Example 2:
//    Input: nums = [2,9,2,5,6], left = 2, right = 8
//    Output: 7
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    0 <= nums[i] <= 10^9
//    0 <= left <= right <= 10^9


//给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
//
//    生成的测试用例保证结果符合 32-bit 整数范围。
//
//    示例 1：
//    输入：nums = [2,1,4,3], left = 2, right = 3
//    输出：3
//    解释：满足条件的三个子数组：[2], [2, 1], [3]
//
//    示例 2：
//    输入：nums = [2,9,2,5,6], left = 2, right = 8
//    输出：7
//
//    提示：
//    1 <= nums.length <= 10^5
//    0 <= nums[i] <= 10^9
//    0 <= left <= right <= 10^9



public class Q795 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDIntArrayAndTwoInt obj = InputMethods.getInputFOrOneInt1DArrayAndTwoInt(cin);
        cin.close();
        System.out.println(numSubarrayBoundedMax(obj.array, obj.val1, obj.val2));
    }

    // Method 1: iterate through once
//    private static int numSubarrayBoundedMax(int[] nums, int left, int right) {
//        int res = 0, last2 = -1, last1 = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= left && nums[i] <= right) {
//                last1 = i;
//            } else if (nums[i] > right) {
//                last2 = i;
//                last1 = -1;
//            }
//            if (last1 != -1) {
//                res += last1 - last2;
//            }
//        }
//        return res;
//    }

    // Method 2: count
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    public static int count(int[] nums, int lower) {
        int res = 0, cur = 0;
        for (int x : nums) {
            cur = x <= lower ? cur + 1 : 0;
            res += cur;
        }
        return res;
    }
}
