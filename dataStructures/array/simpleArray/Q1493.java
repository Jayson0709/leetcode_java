package dataStructures.array.simpleArray;

import utils.InputMethods;

import java.util.ArrayList;
import java.util.List;


//Given a binary array nums, you should delete one element from it.
//
//    Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
//
//    Example 1:
//    Input: nums = [1,1,0,1]
//    Output: 3
//    Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
//
//    Example 2:
//    Input: nums = [0,1,1,1,0,1,1,0,1]
//    Output: 5
//    Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
//
//    Example 3:
//    Input: nums = [1,1,1]
//    Output: 2
//    Explanation: You must delete one element.
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    nums[i] is either 0 or 1.


//给你一个二进制数组 nums ，你需要从中删掉一个元素。
//
//    请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
//
//    如果不存在这样的子数组，请返回 0 。
//
//    提示 1：
//    输入：nums = [1,1,0,1]
//    输出：3
//    解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
//
//    示例 2：
//    输入：nums = [0,1,1,1,0,1,1,0,1]
//    输出：5
//    解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
//
//    示例 3：
//    输入：nums = [1,1,1]
//    输出：2
//    解释：你必须要删除一个元素。
//
//    提示：
//    1 <= nums.length <= 10^5
//    nums[i] 要么是 0 要么是 1 。


public class Q1493 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(InputMethods.getInputForOneIntArray()));
    }

    // Method 1: pure Array operations
//    private static int longestSubarray(int[] nums) {
//        List<Integer> zeroIndexes = new ArrayList<>();
//        int length = nums.length;
//        for (int i = 0; i < length; i++) {
//            if (nums[i] == 0) {
//                zeroIndexes.add(i);
//            }
//        }
//        int result = 0;
//        int size = zeroIndexes.size();
//        if (size == 0 || size == 1) {
//            return length - 1;
//        }
//        for (int i = 1; i < size; i++) {
//            if (i == size - 1) {
//                result = Math.max(result, length - zeroIndexes.get(i - 1) - 2);
//            } else {
//                result = Math.max(result, zeroIndexes.get(i + 1) - zeroIndexes.get(i - 1) - 2);
//            }
//        }
//        result = Math.max(result, zeroIndexes.get(1) - 1);
//        return result;
//    }

    // Method 2: upgraded recursion usage (two pointers)
    private static int longestSubarray(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        int result = 0;
        for (int num : nums) {
            if (num == 0) {
                p1 = p0;
                p0 = 0;
            } else {
                p0++;
                p1++;
            }
            result = Math.max(result, p1);
        }
        if (result == nums.length) {
            result--;
        }
        return result;
    }
}
