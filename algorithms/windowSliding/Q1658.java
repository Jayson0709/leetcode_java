package algorithms.windowSliding;

import utils.InputMethods;
import utils.OneDArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
//
//    Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
//
//    Example 1:
//    Input: nums = [1,1,4,2,3], x = 5
//    Output: 2
//    Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
//
//    Example 2:
//    Input: nums = [5,6,7,8,9], x = 4
//    Output: -1
//
//    Example 3:
//    Input: nums = [3,2,20,1,1,3], x = 10
//    Output: 5
//    Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^4
//    1 <= x <= 10^9


//给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
//
//    如果可以将 x恰好 减到0 ，返回 最小操作数 ；否则，返回 -1 。
//
//    示例 1：
//    输入：nums = [1,1,4,2,3], x = 5
//    输出：2
//    解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
//
//    示例 2：
//    输入：nums = [5,6,7,8,9], x = 4
//    输出：-1
//
//    示例 3：
//    输入：nums = [3,2,20,1,1,3], x = 10
//    输出：5
//    解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
//
//    提示：
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^4
//    1 <= x <= 10^9


public class Q1658 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(minOperations(obj.array, obj.val));
    }

    // Method: use Window Sliding + Two Pointers
    // The question can be turned into this: find the longest continuous subarray with sum - x.
    // Use window sliding to solve
    private static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int left = 0, right = 0;
        int maxLength = -1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int curSum = 0;
        while (left < n) {
            // if the right pointer does not reach the end, keep probing to the right
            // if it is greater than sum - x, move the left pointer until it ends.
            if (right < n) {
                curSum += nums[right++];
            }
            while (curSum > sum - x && left < n) {
                curSum -= nums[left++];
            }
            if (curSum == sum - x) {
                maxLength = Math.max(maxLength, right - left);
            }
            if (right == n) {
                left++;
            }
        }
        return maxLength == -1 ? -1 : n - maxLength;
    }
}
