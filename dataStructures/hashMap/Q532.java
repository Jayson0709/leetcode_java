package dataStructures.hashMap;

import utils.InputMethods;
import utils.OneDArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
//
//    A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
//    0 <= i, j < nums.length
//    i != j
//    nums[i] - nums[j] == k
//    Notice that |val| denotes the absolute value of val.
//
//    Example 1:
//    Input: nums = [3,1,4,1,5], k = 2
//    Output: 2
//    Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
//    Although we have two 1s in the input, we should only return the number of unique pairs.
//    
//    Example 2:
//    Input: nums = [1,2,3,4,5], k = 1
//    Output: 4
//    Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
//    
//    Example 3:
//    Input: nums = [1,3,1,5,4], k = 0
//    Output: 1
//    Explanation: There is one 0-diff pair in the array, (1, 1).
//
//    Constraints:
//    1 <= nums.length <= 104
//    -107 <= nums[i] <= 107
//    0 <= k <= 107


//给你一个整数数组nums 和一个整数k，请你在数组中找出 不同的k-diff 数对，并返回不同的 k-diff 数对 的数目。
//
//    k-diff数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
//
//    0 <= i, j < nums.length
//    i != j
//    nums[i] - nums[j] == k
//    注意，|val| 表示 val 的绝对值。
//
//    示例 1：
//    输入：nums = [3, 1, 4, 1, 5], k = 2
//    输出：2
//    解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
//    尽管数组中有两个 1 ，但我们只应返回不同的数对的数量。
//
//    示例 2：
//    输入：nums = [1, 2, 3, 4, 5], k = 1
//    输出：4
//    解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5) 。
//
//    示例 3：
//    输入：nums = [1, 3, 1, 5, 4], k = 0
//    输出：1
//    解释：数组中只有一个 0-diff 数对，(1, 1) 。
//
//    提示：
//    1 <= nums.length <= 104
//    -107 <= nums[i] <= 107
//    0 <= k <= 107


public class Q532 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(findPairs(obj.array, obj.val));
    }

    private static int findPairs(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int num : nums) {
            hMap.put(num, hMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (hMap.get(num) == 0) {
                continue;
            }
            if (k == 0) {
                if (hMap.get(num) > 1) {
                    result++;
                }
            } else {
                if (hMap.getOrDefault(num + k, 0) > 0) {
                    result++;
                }
                if (hMap.getOrDefault(num - k, 0) > 0) {
                    result++;
                }
            }
            hMap.put(num, 0);
        }
        return result;
    }
}
