package dataStructures.array.simpleArray;

import utils.InputMethods;
import utils.OutputMethods;

import java.util.Arrays;


//Given a zero-based permutation nums (0-indexed), build an array 'ans' of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
//
//    A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
//
//    Example 1:
//    Input: nums = [0,2,1,5,3,4]
//    Output: [0,1,2,4,5,3]
//    Explanation: The array 'ans' is built as follows:
//    ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
//    = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
//    = [0,1,2,4,5,3]
//
//    Example 2:
//    Input: nums = [5,0,1,2,3,4]
//    Output: [4,5,0,1,2,3]
//    Explanation: The array 'ans' is built as follows:
//    ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
//    = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
//    = [4,5,0,1,2,3]
//
//    Constraints:
//    1 <= nums.length <= 1000
//    0 <= nums[i] < nums.length
//    The elements in nums are distinct.
//
//    Follow-up: Can you solve it without using an extra space (i.e., O(1) memory)?



//给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。
//
//    从 0 开始的排列 nums 是一个由 0 到nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
//
//    示例 1：
//    输入：nums = [0,2,1,5,3,4]
//    输出：[0,1,2,4,5,3]
//    解释：数组 ans 构建如下：
//    ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
//    = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
//    = [0,1,2,4,5,3]
//
//    示例 2：
//    输入：nums = [5,0,1,2,3,4]
//    输出：[4,5,0,1,2,3]
//    解释：数组 ans 构建如下：
//    ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
//    = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
//    = [4,5,0,1,2,3]
//
//    提示：
//    1 <= nums.length <= 1000
//    0 <= nums[i] < nums.length
//    nums 中的元素 互不相同


public class Q1920 {
    public static void main(String[] args) {
        int[] result = buildArray(InputMethods.getInputForOneIntArray());
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    // Method 1: O(n) space complexity
//    private static int[] buildArray(int[] nums) {
//        int n = nums.length;
//        int[] result = new int[n];
//        for (int i = 0; i < n; i++) {
//            result[i] = nums[nums[i]];
//        }
//        return result;
//    }

    // Method 2: O(1) space complexity
    private static int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        for (int i = 0; i < n; i++) {
            nums[i] /= 1000;
        }
        return nums;
    }
}
