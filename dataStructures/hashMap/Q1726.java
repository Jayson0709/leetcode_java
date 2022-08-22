package dataStructures.hashMap;

import utils.InputMethods;

import java.util.HashMap;
import java.util.Map;


//Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.
//
//    Example 1:
//    Input: nums = [2,3,4,6]
//    Output: 8
//    Explanation: There are 8 valid tuples:
//    (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//    (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
//
//    Example 2:
//    Input: nums = [1,2,4,5,10]
//    Output: 16
//    Explanation: There are 16 valid tuples:
//    (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//    (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//    (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
//    (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
//
//    Constraints:
//    1 <= nums.length <= 1000
//    1 <= nums[i] <= 10^4
//    All elements in nums are distinct.


//给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
//
//    示例 1：
//    输入：nums = [2,3,4,6]
//    输出：8
//    解释：存在 8 个满足题意的元组：
//    (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//    (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
//
//    示例 2：
//    输入：nums = [1,2,4,5,10]
//    输出：16
//    解释：存在 16 个满足题意的元组：
//    (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//    (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//    (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
//    (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
//
//    提示：
//    1 <= nums.length <= 1000
//    1 <= nums[i] <= 10^4
//    nums 中的所有元素 互不相同



public class Q1726 {
    public static void main(String[] args) {
        System.out.println(tupleSameProduct(InputMethods.getInputForOneIntArray()));
    }

    private static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1;j < nums.length; j++){
                int key = nums[i] * nums[j];
                hMap.put(key, hMap.getOrDefault(key,0)+1);
            }
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
            Integer val = entry.getValue();
            if(val > 1){
                ans += val * (val - 1) * 4;
            }
        }
        return ans;
    }
}
