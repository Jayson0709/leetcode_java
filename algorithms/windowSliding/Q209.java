package algorithms.windowSliding;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [nums_l, nums_l+1, ..., nums_r-1, nums_r] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
//    
//    Example 1:
//    Input: target = 7, nums = [2,3,1,2,4,3]
//    Output: 2
//    Explanation: The subarray [4,3] has the minimal length under the problem constraint.
//    
//    Example 2:
//    Input: target = 4, nums = [1,4,4]
//    Output: 1
//    
//    Example 3:
//    Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//    Output: 0
//
//    Constraints:
//    1 <= target <= 10^9
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^4
//    
//    Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).


//给定一个含有n个正整数的数组和一个正整数 target 。
//
//    找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[nums_l, nums_l+1, ..., nums_r-1, nums_r] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
//    示例 1：
//    输入：target = 7, nums = [2,3,1,2,4,3]
//    输出：2
//    解释：子数组[4,3]是该条件下的长度最小的子数组。
//
//    示例 2：
//    输入：target = 4, nums = [1,4,4]
//    输出：1
//
//    示例 3：
//    输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//    输出：0
//
//    提示：
//    1 <= target <= 10^9
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 10^5
//
//    进阶：
//    如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。



public class Q209 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int target = Integer.parseInt(cin.nextLine().strip());
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        int result = minSubArrayLen(target, nums);
        System.out.println(result);
    }

    // Method 1: Window Sliding
    private static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int localSum = 0;
        int minSize = Integer.MAX_VALUE;

        while (right < n) {
            localSum += nums[right];
            while (localSum >= target) {
                minSize = Math.min(minSize, right - left + 1);
                localSum -= nums[left];
                left++;
            }
            right++;
        }
        return minSize == Integer.MAX_VALUE? 0 : minSize;
    }

    // Method 2: prefix sum + binary search
//    private static int minSubArrayLen(int target, int[] nums) {
//        int n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        int ans = Integer.MAX_VALUE;
//        int[] sums = new int[n + 1];
//        // For convenience，let size = n + 1
//        // sums[0] = 0 indicates that the sum of the first zero element's prefix is zero.
//        // sums[1] = A[0], the prefix sum of the first one element is A[0]
//        // and so forth.
//        for (int i = 1; i <= n; i++) {
//            sums[i] = sums[i - 1] + nums[i - 1];
//        }
//        for (int i = 1; i <= n; i++) {
//            int goal = target + sums[i - 1];
//            int bound = Arrays.binarySearch(sums, goal);
//            if (bound < 0) {
//                bound = -bound - 1;
//            }
//            if (bound <= n) {
//                ans = Math.min(ans, bound - (i - 1));
//            }
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
//    }
}
