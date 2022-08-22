package algorithms.sorting;

import utils.InputMethods;

//Given an array nums of size n, return the majority element.
//
//    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//    
//    Example 1:
//    Input: nums = [3,2,3]
//    Output: 3
//
//    Example 2:
//    Input: nums = [2,2,1,1,1,2,2]
//    Output: 2
//    
//    Constraints:
//    n == nums.length
//    1 <= n <= 5 * 104
//    -109 <= nums[i] <= 109
//    
//    Follow-up: Could you solve the problem in linear time and in O(1) space?



//给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
//
//    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//    示例1：
//    输入：nums = [3,2,3]
//    输出：3
//
//    示例2：
//    输入：nums = [2,2,1,1,1,2,2]
//    输出：2
//
//    提示：
//    n == nums.length
//    1 <= n <= 5 * 104
//    -109 <= nums[i] <= 109
//
//    进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。


public class Q169 {
    public static void main(String[] args) {
        int result = majorityElement(InputMethods.getInputForOneIntArray());
        System.out.println(result);
    }

    // Method 1: use Sorting, time complexity: O(n log n), space complexity: O(1)
//    private static int majorityElement(int[] nums) {
//        int n = nums.length;
//        int threshold = n / 2;
//        int count = 0;
//        int curNum = nums[0];
//        Arrays.sort(nums);
//        for (int num : nums) {
//            if (num == curNum) {
//                count++;
//                if (count > threshold) {
//                    return num;
//                }
//            } else {
//                count = 0;
//                curNum = num;
//                count++;
//            }
//        }
//        return -1;
//    }

    // Method 2: use HashMap, time complexity: O(n), space complexity: O(n)
//    private static int majorityElement(int[] nums) {
//        Map<Integer, Integer> hMap = new HashMap<>();
//        for (int num : nums) {
//            int val = hMap.getOrDefault(num, 0);
//            hMap.put(num, val + 1);
//        }
//        int threshold = nums.length / 2;
//        for (Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
//            if (entry.getValue() > threshold) {
//                return entry.getKey();
//            }
//        }
//        return -1;
//    }

    // Method 3: Boyer–Moore majority vote algorithm - 摩尔投票法, time complexity: O(n), space complexity: O(1)
    private static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
