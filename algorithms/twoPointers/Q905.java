package algorithms.twoPointers;

import utils.InputMethods;

import java.util.Arrays;


//Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
//
//    Return any array that satisfies this condition.
//
//    Example 1:
//    Input: nums = [3,1,2,4]
//    Output: [2,4,3,1]
//    Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//
//    Example 2:
//    Input: nums = [0]
//    Output: [0]
//
//    Constraints:
//    1 <= nums.length <= 5000
//    0 <= nums[i] <= 5000



//给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
//
//    返回满足此条件的 任一数组 作为答案。
//
//    示例 1：
//    输入：nums = [3,1,2,4]
//    输出：[2,4,3,1]
//    解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
//
//    示例 2：
//    输入：nums = [0]
//    输出：[0]
//
//    提示：
//    1 <= nums.length <= 5000
//    0 <= nums[i] <= 5000



public class Q905 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(InputMethods.getInputForOneIntArray())));
    }

    private static int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[left] = num;
                left++;
            } else {
                res[right] = num;
                right--;
            }
        }
        return res;
    }
}
