package algorithms.dynamicProgramming;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//    A subarray is a contiguous part of an array.
//
//    Example 1:
//    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//    Output: 6
//    Explanation: [4,-1,2,1] has the largest sum = 6.
//    
//    Example 2:
//    Input: nums = [1]
//    Output: 1
//    
//    Example 3:
//    Input: nums = [5,4,-1,7,8]
//    Output: 23
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    -10^4 <= nums[i] <= 10^4
//    
//    Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//    子数组 是数组中的一个连续部分。
//
//    示例 1：
//    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//    输出：6
//    解释：连续子数组[4,-1,2,1] 的和最大，为6 。
//
//    示例 2：
//    输入：nums = [1]
//    输出：1
//
//    示例 3：
//    输入：nums = [5,4,-1,7,8]
//    输出：23
//
//    提示：
//    1 <= nums.length <= 105
//    -104 <= nums[i] <= 104
//
//    进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。


public class Q53 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    private static int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
