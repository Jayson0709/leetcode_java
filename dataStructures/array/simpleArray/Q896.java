package dataStructures.array.simpleArray;
import java.util.*;
import java.nio.charset.StandardCharsets;


//An array is monotonic if it is either monotone increasing or monotone decreasing.
//
//    An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
//
//    Given an integer array nums, return true if the given array is monotonic, or false otherwise.
//
//    Example 1:
//    Input: nums = [1,2,2,3]
//    Output: true
//
//    Example 2:
//    Input: nums = [6,5,4,4]
//    Output: true
//
//    Example 3:
//    Input: nums = [1,3,2]
//    Output: false
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    -10^5 <= nums[i] <= 10^5


//如果数组是单调递增或单调递减的，那么它是单调 的。
//
//    如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums是单调递减的。
//
//    当给定的数组 nums是单调数组时返回 true，否则返回 false。
//
//    示例 1：
//    输入：nums = [1,2,2,3]
//    输出：true
//
//    示例 2：
//    输入：nums = [6,5,4,4]
//    输出：true
//
//    示例 3：
//    输入：nums = [1,3,2]
//    输出：false
//
//    提示：
//    1 <= nums.length <= 10^5
//    -10^5<= nums[i] <= 10^5


public class Q896 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        boolean result = isMonotonic(nums);
        System.out.println(result);
    }

    private static boolean isMonotonic(int[] nums) {
        boolean ascending = true;
        boolean descending = true;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                ascending = false;
            }
            if (nums[i] < nums[i + 1]) {
                descending = false;
            }
        }
        return ascending || descending;
    }
}
