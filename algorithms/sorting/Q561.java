package algorithms.sorting;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
//        
//    Example 1:
//    Input: nums = [1,4,3,2]
//    Output: 4
//    Explanation: All possible pairings (ignoring the ordering of elements) are:
//    1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
//    2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
//    3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
//    So the maximum possible sum is 4.
//
//    Example 2:
//    Input: nums = [6,2,6,5,1,2]
//    Output: 9
//    Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
//
//    Constraints:
//    1 <= n <= 10^4
//    nums.length == 2 * n
//    -10^4 <= nums[i] <= 10^4


//给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。
//
//    返回该 最大总和 。
//
//    示例 1：
//    输入：nums = [1,4,3,2]
//    输出：4
//    解释：所有可能的分法（忽略元素顺序）为：
//    1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
//    2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
//    3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
//    所以最大总和为 4
//
//    示例 2：
//    输入：nums = [6,2,6,5,1,2]
//    输出：9
//    解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
//
//    提示：
//    1 <= n <= 10^4
//    nums.length == 2 * n
//    -10^4 <= nums[i] <= 10^4


public class Q561 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        int result = arrayPairSum(nums);
        System.out.println(result);
    }

    // Method 1: API sort
//    private static int arrayPairSum(int[] nums) {
//        Arrays.sort(nums);
//        int result = 0;
//        for (int i = 0; i < nums.length; i += 2) {
//            result += nums[i];
//        }
//        return result;
//    }

    // Method 2: Counting sort
    private static int arrayPairSum(int[] nums) {
        int[] counts = new int[20001];
        for (int num : nums) {
            counts[num + 10000]++;
        }
        int result = 0;
        int before = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            }
            if (counts[i] % 2 == 0) {
                result += ((counts[i] / 2) * (i - 10000));
            } else {
                if (before % 2 == 0) {
                    result += ((counts[i]/2 + 1) * (i - 10000));
                } else {
                    result += ((counts[i] / 2) * (i - 10000));
                }
            }
            before += counts[i];
        }
        return result;
    }
}
