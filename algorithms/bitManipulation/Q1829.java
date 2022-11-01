package algorithms.bitManipulation;

import utils.InputMethods;
import utils.OneDIntArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;



//You are given a sorted array nums of n non-negative integers and an integer maximumBit. You want to perform the following query n times:
//
//    Find a non-negative integer k < 2maximumBit such that nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k is maximized. k is the answer to the ith query.
//    Remove the last element from the current array nums.
//    Return an array answer, where answer[i] is the answer to the ith query.
//
//    Example 1:
//    Input: nums = [0,1,1,3], maximumBit = 2
//    Output: [0,3,2,3]
//    Explanation: The queries are answered as follows:
//    1st query: nums = [0,1,1,3], k = 0 since 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3.
//    2nd query: nums = [0,1,1], k = 3 since 0 XOR 1 XOR 1 XOR 3 = 3.
//    3rd query: nums = [0,1], k = 2 since 0 XOR 1 XOR 2 = 3.
//    4th query: nums = [0], k = 3 since 0 XOR 3 = 3.
//    
//    Example 2:
//    Input: nums = [2,3,4,7], maximumBit = 3
//    Output: [5,2,6,5]
//    Explanation: The queries are answered as follows:
//    1st query: nums = [2,3,4,7], k = 5 since 2 XOR 3 XOR 4 XOR 7 XOR 5 = 7.
//    2nd query: nums = [2,3,4], k = 2 since 2 XOR 3 XOR 4 XOR 2 = 7.
//    3rd query: nums = [2,3], k = 6 since 2 XOR 3 XOR 6 = 7.
//    4th query: nums = [2], k = 5 since 2 XOR 5 = 7.
//    
//    Example 3:
//    Input: nums = [0,1,2,2,5,7], maximumBit = 3
//    Output: [4,3,6,4,6,7]
//
//    Constraints:
//    nums.length == n
//    1 <= n <= 10^5
//    1 <= maximumBit <= 20
//    0 <= nums[i] < 2^maximumBit
//    nums is sorted in ascending order.



//给你一个 有序 数组 nums ，它由 n 个非负整数组成，同时给你一个整数 maximumBit 。你需要执行以下查询 n 次：
//
//    找到一个非负整数 k < 2maximumBit ，使得 nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k 的结果 最大化 。k 是第 i 个查询的答案。
//    从当前数组 nums 删除 最后 一个元素。
//    请你返回一个数组 answer ，其中 answer[i]是第 i 个查询的结果。
//
//    示例 1：
//    输入：nums = [0,1,1,3], maximumBit = 2
//    输出：[0,3,2,3]
//    解释：查询的答案如下：
//    第一个查询：nums = [0,1,1,3]，k = 0，因为 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3 。
//    第二个查询：nums = [0,1,1]，k = 3，因为 0 XOR 1 XOR 1 XOR 3 = 3 。
//    第三个查询：nums = [0,1]，k = 2，因为 0 XOR 1 XOR 2 = 3 。
//    第四个查询：nums = [0]，k = 3，因为 0 XOR 3 = 3 。
//
//    示例 2：
//    输入：nums = [2,3,4,7], maximumBit = 3
//    输出：[5,2,6,5]
//    解释：查询的答案如下：
//    第一个查询：nums = [2,3,4,7]，k = 5，因为 2 XOR 3 XOR 4 XOR 7 XOR 5 = 7。
//    第二个查询：nums = [2,3,4]，k = 2，因为 2 XOR 3 XOR 4 XOR 2 = 7 。
//    第三个查询：nums = [2,3]，k = 6，因为 2 XOR 3 XOR 6 = 7 。
//    第四个查询：nums = [2]，k = 5，因为 2 XOR 5 = 7 。
//
//    示例 3：
//    输入：nums = [0,1,2,2,5,7], maximumBit = 3
//    输出：[4,3,6,4,6,7]
//
//    提示：
//    nums.length == n
//    1 <= n <= 10^5
//    1 <= maximumBit <= 20
//    0 <= nums[i] < 2^maximumBit
//    nums 中的数字已经按 升序 排好序。


public class Q1829 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDIntArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(Arrays.toString(getMaximumXor(obj.array, obj.val)));
    }

    private static int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1 ;i < n; i++){
            prefix[i] = prefix[i - 1] ^ nums[i];
        }
        int max = 0;
        int idx = 0;
        while (maximumBit > 0){
            max = (1 << idx) | max;
            idx++;
            maximumBit--;
        }
        for(int i = n - 1; i >= 0; i--){
            ans[n - i - 1] = prefix[i] ^ max;
        }
        return ans;
    }
}
