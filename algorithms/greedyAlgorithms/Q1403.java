package algorithms.greedyAlgorithms;

import utils.InputMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non-included elements in such subsequence.
//
//    If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array. 
//
//    Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.
//
//    Example 1:
//    Input: nums = [4,3,10,9,8]
//    Output: [10,9]
//    Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements is strictly greater than the sum of elements not included, however, the subsequence [10,9] has the maximum total sum of its elements. 
//    
//    Example 2:
//    Input: nums = [4,4,7,6,7]
//    Output: [7,7,6]
//    Explanation: The subsequence [7,7] has the sum of its elements equal to 14 which is not strictly greater than the sum of elements not included (14 = 4 + 4 + 6). Therefore, the subsequence [7,6,7] is the minimal satisfying the conditions. Note the subsequence has to returned in non-decreasing order.
//    
//    Example 3:
//    Input: nums = [6]
//    Output: [6]
//
//    Constraints:
//    1 <= nums.length <= 500
//    1 <= nums[i] <= 100



//给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
//
//    如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
//
//    与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
//
//    注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
//
//    示例 1：
//    输入：nums = [4,3,10,9,8]
//    输出：[10,9]
//    解释：子序列 [10,9] 和 [10,8] 是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。 
//
//    示例 2：
//    输入：nums = [4,4,7,6,7]
//    输出：[7,7,6]
//    解释：子序列 [7,7] 的和为 14 ，不严格大于剩下的其他元素之和（14 = 4 + 4 + 6）。因此，[7,6,7] 是满足题意的最小子序列。注意，元素按非递增顺序返回。
//
//    示例 3：
//    输入：nums = [6]
//    输出：[6]
//
//    提示：
//    1 <= nums.length <= 500
//    1 <= nums[i] <= 100



public class Q1403 {
    public static void main(String[] args) {
        System.out.println(minSubsequence(InputMethods.getInputForOneIntArray()));
    }

    // Version 1
//    private static List<Integer> minSubsequence(int[] nums) {
//        int n = nums.length;
//        List<Integer> res = new ArrayList<>();
//        if (n == 1) {
//            res.add(nums[0]);
//            return res;
//        }
//        Arrays.sort(nums);
//        int sum1 = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            sum1 += nums[i];
//            res.add(nums[i]);
//            int sum2 = 0;
//            for (int j = i - 1; j >= 0; j--) {
//                sum2 += nums[j];
//            }
//            if (sum1 > sum2) {
//                break;
//            }
//        }
//        return res;
//    }

    // Version 2
    private static List<Integer> minSubsequence(int[] nums) {
        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int curNum = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            curNum += nums[i];
            res.add(nums[i]);
            if (total - curNum < curNum) {
                break;
            }
        }
        return res;
    }
}
