package algorithms.windowSliding;

import utils.InputMethods;
import utils.OneDArrayAndOneInt;

//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//
//    Example 1:
//    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//    Output: 6
//    Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//
//    Example 2:
//    Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//    Output: 10
//    Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//
//    Constraints:
//    1 <= nums.length <= 105
//    nums[i] is either 0 or 1.
//    0 <= k <= nums.length

// 给定一个二进制数组nums和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
//
// 示例 1：
// 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
// 输出：6
// 解释：[1,1,1,0,0,1,1,1,1,1,1]
// 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
//
// 示例 2：
// 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
// 输出：10
// 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
//
// 提示：
// 1 <= nums.length <= 105
// nums[i]不是0就是1
// 0 <= k <= nums.length


public class Q1004 {
    public static void main (String[] args) {
        OneDArrayAndOneInt obj = InputMethods.getOneInt1DArrayAndOneIntInput();
        int result = longestOnes(obj.array, obj.val);
        System.out.println(result);
    }

    public static int longestOnes(int[] nums, int k) {
        int leftIndex = 0;
        int rightIndex = 0;
        int maxLength = 0;
        int zeros = 0;
        int arrayLength = nums.length;
        while (rightIndex < arrayLength) {
            if (nums[rightIndex] == 1) {
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
                rightIndex++;
            } else {
                zeros++;
                while (zeros > k) {
                    if (nums[leftIndex] == 0) {
                        zeros--;
                    }
                    leftIndex++;
                }
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
                rightIndex++;
            }
        }
        return maxLength;
    }
}