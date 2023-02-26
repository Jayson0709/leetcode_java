package dataStructures.hashMap;

import utils.InputMethods;

import java.util.HashMap;
import java.util.Map;


//You are given a 0-indexed array of positive integers nums. Find the number of triplets (i, j, k) that meet the following conditions:
//
//    0 <= i < j < k < nums.length
//    nums[i], nums[j], and nums[k] are pairwise distinct.
//    In other words, nums[i] != nums[j], nums[i] != nums[k], and nums[j] != nums[k].
//    Return the number of triplets that meet the conditions.
//
//    Example 1:
//    Input: nums = [4,4,2,4,3]
//    Output: 3
//    Explanation: The following triplets meet the conditions:
//    - (0, 2, 4) because 4 != 2 != 3
//    - (1, 2, 4) because 4 != 2 != 3
//    - (2, 3, 4) because 2 != 4 != 3
//    Since there are 3 triplets, we return 3.
//    Note that (2, 0, 4) is not a valid triplet because 2 > 0.
//
//    Example 2:
//    Input: nums = [1,1,1,1,1]
//    Output: 0
//    Explanation: No triplets meet the conditions so we return 0.
//
//    Constraints:
//    3 <= nums.length <= 100
//    1 <= nums[i] <= 1000


//给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
//
//    0 <= i < j < k < nums.length
//    nums[i]、nums[j] 和 nums[k] 两两不同 。
//    换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
//    返回满足上述条件三元组的数目。
//
//    示例 1：
//    输入：nums = [4,4,2,4,3]
//    输出：3
//    解释：下面列出的三元组均满足题目条件：
//    - (0, 2, 4) 因为 4 != 2 != 3
//    - (1, 2, 4) 因为 4 != 2 != 3
//    - (2, 3, 4) 因为 2 != 4 != 3
//    共计 3 个三元组，返回 3 。
//    注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
//
//    示例 2：
//    输入：nums = [1,1,1,1,1]
//    输出：0
//    解释：不存在满足条件的三元组，所以返回 0 。
//
//    提示：
//    3 <= nums.length <= 100
//    1 <= nums[i] <= 1000


public class Q2475 {
    public static void main(String[] args) {
        System.out.println(unequalTriplets(InputMethods.getInputForOneIntArray()));
    }

    private static int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int res = 0;
        int left = 0;
        int right = nums.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            right -= cnt;
            res += left * cnt * right;
            left += cnt;
        }
        return res;
    }
}
