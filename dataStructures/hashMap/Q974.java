package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
//
//    A subarray is a contiguous part of an array.
//    
//    Example 1:
//    Input: nums = [4,5,0,-2,-3,1], k = 5
//    Output: 7
//    Explanation: There are 7 subarrays with a sum divisible by k = 5:
//    [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//    
//    Example 2:
//    Input: nums = [5], k = 9
//    Output: 0
//
//    Constraints:
//    1 <= nums.length <= 3 * 10^4
//    -10^4 <= nums[i] <= 10^4
//    2 <= k <= 10^4



//给定一个整数数组 nums和一个整数 k ，返回其中元素之和可被 k整除的（连续、非空） 子数组 的数目。
//
//    子数组 是数组的 连续 部分。
//
//    示例 1：
//    输入：nums = [4,5,0,-2,-3,1], k = 5
//    输出：7
//    解释：
//    有 7 个子数组满足其元素之和可被 k = 5 整除：
//    [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//
//    示例 2:
//    输入: nums = [5], k = 9
//    输出: 0
//
//    提示:
//    1 <= nums.length <= 3 * 10^4
//    -10^4<= nums[i] <= 10^4
//    2 <= k <= 10^4



public class Q974 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = cin.nextInt();
        cin.close();
        int result = subarraysDivByK(nums, k);
        System.out.println(result);
    }

    private static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, result = 0;
        for (int num : nums) {
            sum += num;
            // Attention to the particularity of Java modulo.
            int modulus = (sum % k + k) % k;
            int same = record.getOrDefault(modulus, 0);
            result += same;
            record.put(modulus, same + 1);
        }
        return result;
    }
}
