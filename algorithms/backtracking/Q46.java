package algorithms.backtracking;

import utils.InputMethods;
import utils.OutputMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
//    Example 1:
//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//    Example 2:
//    Input: nums = [0,1]
//    Output: [[0,1],[1,0]]
//
//    Example 3:
//    Input: nums = [1]
//    Output: [[1]]
//
//    Constraints:
//    1 <= nums.length <= 6
//    -10 <= nums[i] <= 10
//    All the integers of nums are unique.


//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//    示例 1：
//    输入：nums = [1,2,3]
//    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//    示例 2：
//    输入：nums = [0,1]
//    输出：[[0,1],[1,0]]
//
//    示例 3：
//    输入：nums = [1]
//    输出：[[1]]
//
//    提示：
//    1 <= nums.length <= 6
//    -10 <= nums[i] <= 10
//    nums 中的所有整数 互不相同


public class Q46 {
    public static void main(String[] args) {
        List<List<Integer>> result = permute(InputMethods.getInputForOneIntArray());
        OutputMethods.outputEmbeddedListData(result);
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // every number is used
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // change the array dynamically
            Collections.swap(output, first, i);
            // continue to the next number
            backtrack(n, output, res, first + 1);
            // take the previous number away
            Collections.swap(output, first, i);
        }
    }
}
