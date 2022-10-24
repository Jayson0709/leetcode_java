package dataStructures.array.simpleArray;

import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//Given an integer array nums, partition it into two (contiguous) sub-arrays left and right so that:
//
//    Every element in left is less than or equal to every element in right.
//    left and right are non-empty.
//    left has the smallest possible size.
//    Return the length of left after such a partitioning.
//
//    Test cases are generated such that partitioning exists.
//
//    Example 1:
//    Input: nums = [5,0,3,8,6]
//    Output: 3
//    Explanation: left = [5,0,3], right = [8,6]
//    
//    Example 2:
//    Input: nums = [1,1,1,0,6,12]
//    Output: 4
//    Explanation: left = [1,1,1,0], right = [6,12]
//
//    Constraints:
//    2 <= nums.length <= 10^5
//    0 <= nums[i] <= 10^6
//    There is at least one valid answer for the given input.



//给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
//
//    left 中的每个元素都小于或等于 right 中的每个元素。
//    left 和 right 都是非空的。
//    left 的长度要尽可能小。
//    在完成这样的分组后返回 left 的 长度 。
//
//    用例可以保证存在这样的划分方法。
//
//    示例 1：
//    输入：nums = [5,0,3,8,6]
//    输出：3
//    解释：left = [5,0,3]，right = [8,6]
//
//    示例 2：
//    输入：nums = [1,1,1,0,6,12]
//    输出：4
//    解释：left = [1,1,1,0]，right = [6,12]
//
//    提示：
//    2 <= nums.length <= 10^5
//    0 <= nums[i] <= 10^6
//    可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。


public class Q915 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println(partitionDisjoint(InputMethods.getInputForOneIntArray()));
        cin.close();
    }

    private static int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minRight = new int[n];
        minRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }
        int maxLeft = 0;
        for (int i = 0; i < n - 1; i++) {
            maxLeft = Math.max(maxLeft, nums[i]);
            if (maxLeft <= minRight[i + 1]) {
                return i + 1;
            }
        }
        return n - 1;
    }
}
