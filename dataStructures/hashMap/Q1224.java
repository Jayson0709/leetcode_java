package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an array nums of positive integers, return the longest possible length of an array prefix of nums, such that it is possible to remove exactly one element from this prefix so that every number that has appeared in it will have the same number of occurrences.
//
//    If after removing one element there are no remaining elements, it's still considered that every appeared number has the same number of ocurrences (0).
//
//    Example 1:
//    Input: nums = [2,2,1,1,5,3,3,5]
//    Output: 7
//    Explanation: For the subarray [2,2,1,1,5,3,3] of length 7, if we remove nums[4] = 5, we will get [2,2,1,1,3,3], so that each number will appear exactly twice.
//
//    Example 2:
//    Input: nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//    Output: 13
//
//    Constraints:
//    2 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^5



//给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
//
//    从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
//    如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
//
//    示例 1：
//    输入：nums = [2,2,1,1,5,3,3,5]
//    输出：7
//    解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
//
//    示例 2：
//    输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//    输出：13
//
//    提示：
//    2 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^5



public class Q1224 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        System.out.println(maxEqualFreq(nums));
    }

    // ref: https://leetcode.cn/problems/maximum-equal-frequency/solution/zui-da-xiang-deng-pin-lu-by-leetcode-sol-5y2m/
    private static int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0, maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count.getOrDefault(nums[i], 0) > 0) {
                freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
            }
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(nums[i]));
            freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);
            boolean ok = maxFreq == 1 ||
                freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freq.get(maxFreq) == 1 ||
                freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1;
            if (ok) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }
}
