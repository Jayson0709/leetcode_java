package algorithms.windowSliding;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
//
//    Example 1:
//    Input: nums = [1,2,3,1], k = 3
//    Output: true
//    
//    Example 2:
//    Input: nums = [1,0,1,1], k = 1
//    Output: true
//    
//    Example 3:
//    Input: nums = [1,2,3,1,2,3], k = 2
//    Output: false
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    -10^9 <= nums[i] <= 10^9
//    0 <= k <= 10^5



//给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
//
//    示例1：
//    输入：nums = [1,2,3,1], k = 3
//    输出：true
//
//    示例 2：
//    输入：nums = [1,0,1,1], k = 1
//    输出：true
//
//    示例 3：
//    输入：nums = [1,2,3,1,2,3], k = 2
//    输出：false
//
//    提示：
//    1 <= nums.length <= 10^5
//    -10^9 <= nums[i] <= 10^9
//    0 <= k <= 10^5



public class Q219 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = cin.nextInt();
        cin.close();

        boolean result = containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> hSet = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) {
                hSet.remove(nums[i - k - 1]);
            }
            if (!hSet.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
