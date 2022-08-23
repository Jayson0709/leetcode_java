package algorithms.windowSliding;

import utils.InputMethods;
import utils.OneDArrayAndOneInt;


//Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
//        
//    Example 1:
//    Input: nums = [10,5,2,6], k = 100
//    Output: 8
//    Explanation: The 8 subarrays that have product less than 100 are:
//    [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
//    Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
//    
//    Example 2:
//    Input: nums = [1,2,3], k = 0
//    Output: 0
//
//    Constraints:
//    1 <= nums.length <= 3 * 104
//    1 <= nums[i] <= 1000
//    0 <= k <= 106


//给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
//
//    示例 1：
//    输入：nums = [10,5,2,6], k = 100
//    输出：8
//    解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//    需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
//
//    示例 2：
//    输入：nums = [1,2,3], k = 0
//    输出：0
//
//    提示:
//    1 <= nums.length <= 3 * 104
//    1 <= nums[i] <= 1000
//    0 <= k <= 106


public class Q713 {
    public static void main(String[] args) {
        OneDArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt();
        int result = numSubarrayProductLessThanK(obj.array, obj.val);
        System.out.println(result);
    }

    private static int numSubarrayProductLessThanK (int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        int product = 1;
        int left = 0, right = 0;
        while (right < length) {
            product *= nums[right++];
            while (left < right && product >= k) {
                product /= nums[left++];
            }
            result += (right - left);
        }
        return result;
    }
}
