package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given an integer array nums consisting of 2 * n integers.
//
//    You need to divide nums into n pairs such that:
//
//    Each element belongs to exactly one pair.
//    The elements present in a pair are equal.
//    Return true if nums can be divided into n pairs, otherwise return false.
//
//    Example 1:
//    Input: nums = [3,2,3,2,2,2]
//    Output: true
//    Explanation:
//    There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
//    If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.
//    
//    Example 2:
//    Input: nums = [1,2,3,4]
//    Output: false
//    Explanation:
//    There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition.
//
//    Constraints:
//    nums.length == 2 * n
//    1 <= n <= 500
//    1 <= nums[i] <= 500



//给你一个整数数组 nums ，它包含 2 * n 个整数。
//
//    你需要将 nums 划分成 n 个数对，满足：
//
//    每个元素 只属于一个 数对。
//    同一数对中的元素 相等 。
//    如果可以将 nums 划分成 n 个数对，请你返回 true ，否则返回 false 。
//
//    示例 1：
//    输入：nums = [3,2,3,2,2,2]
//    输出：true
//    解释：
//    nums 中总共有 6 个元素，所以它们应该被划分成 6 / 2 = 3 个数对。
//    nums 可以划分成 (2, 2) ，(3, 3) 和 (2, 2) ，满足所有要求。
//
//    示例 2：
//    输入：nums = [1,2,3,4]
//    输出：false
//    解释：
//    无法将 nums 划分成 4 / 2 = 2 个数对且满足所有要求。
//
//    提示：
//    nums.length == 2 * n
//    1 <= n <= 500
//    1 <= nums[i] <= 500


public class Q2206 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        System.out.println(divideArray(nums));
    }

    private static boolean divideArray(int[] nums) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int num : nums) {
            hMap.put(num, hMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
