package algorithms.dynamicProgramming;

import utils.InputMethods;


//You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element. Notice that the index of the elements may change after the removal.
//
//    For example, if nums = [6,1,7,4,1]:
//
//    Choosing to remove index 1 results in nums = [6,7,4,1].
//    Choosing to remove index 2 results in nums = [6,1,4,1].
//    Choosing to remove index 4 results in nums = [6,1,7,4].
//    An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.
//
//    Return the number of indices that you could choose such that after the removal, nums is fair.
//
//    Example 1:
//    Input: nums = [2,1,6,4]
//    Output: 1
//    Explanation:
//    Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
//    Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
//    Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
//    Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
//    There is 1 index that you can remove to make nums fair.
//
//    Example 2:
//    Input: nums = [1,1,1]
//    Output: 3
//    Explanation: You can remove any index and the remaining array is fair.
//
//    Example 3:
//    Input: nums = [1,2,3]
//    Output: 0
//    Explanation: You cannot make a fair array after removing any index.
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^4


//给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
//
//    比方说，如果 nums = [6,1,7,4,1] ，那么：
//
//    选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
//    选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
//    选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
//    如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
//
//    请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
//
//    示例 1：
//    输入：nums = [2,1,6,4]
//    输出：1
//    解释：
//    删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
//    删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
//    删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
//    删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
//    只有一种让剩余数组成为平衡数组的方案。
//
//    示例 2：
//    输入：nums = [1,1,1]
//    输出：3
//    解释：你可以删除任意元素，剩余数组都是平衡数组。
//
//    示例 3：
//    输入：nums = [1,2,3]
//    输出：0
//    解释：不管删除哪个元素，剩下数组都不是平衡数组。
//
//    提示：
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^4


public class Q1664 {
    public static void main(String[] args) {
        System.out.println(waysToMakeFair(InputMethods.getInputForOneIntArray()));
    }

    private static int waysToMakeFair(int[] nums) {
        int odd1 = 0;
        int even1 = 0;
        int odd2 = 0;
        int even2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((i & 1) != 0) {
                odd2 += nums[i];
            } else {
                even2 += nums[i];
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((i & 1) != 0) {
                odd2 -= nums[i];
            } else {
                even2 -= nums[i];
            }
            if (odd1 + even2 == odd2 + even1) {
                res++;
            }
            if ((i & 1) != 0) {
                odd1 += nums[i];
            } else {
                even1 += nums[i];
            }
        }
        return res;
    }
}
