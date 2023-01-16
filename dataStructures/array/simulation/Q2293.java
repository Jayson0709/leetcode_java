package dataStructures.array.simulation;

import utils.InputMethods;


//You are given a 0-indexed integer array nums whose length is a power of 2.
//
//    Apply the following algorithm on nums:
//
//    Let n be the length of nums. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n / 2.
//    For every even index i, where 0 <= i < n / 2, assign the value of newNums[i] as min(nums[2 * i], nums[2 * i + 1]).
//    For every odd index i, where 0 <= i < n / 2, assign the value of newNums[i] as max(nums[2 * i], nums[2 * i + 1]).
//    Replace the array nums with newNums.
//    Repeat the entire process starting from step 1.
//    Return the last number that remains in nums after applying the algorithm.
//
//    Example 1:
//    1     3     5     2     4     8     2     2
//      \ /         \ /         \ /         \ /
//      min         max         min         max
//       1           5           4           2
//           \   /                   \   /
//            min                     max
//             1                       4
//                       \   /
//                        min
//                         1
//    Input: nums = [1,3,5,2,4,8,2,2]
//    Output: 1
//    Explanation: The following arrays are the results of applying the algorithm repeatedly.
//    First: nums = [1,5,4,2]
//    Second: nums = [1,4]
//    Third: nums = [1]
//    1 is the last remaining number, so we return 1.
//
//    Example 2:
//    Input: nums = [3]
//    Output: 3
//    Explanation: 3 is already the last remaining number, so we return 3.
//
//    Constraints:
//    1 <= nums.length <= 1024
//    1 <= nums[i] <= 10^9
//    nums.length is a power of 2.


//给你一个下标从 0 开始的整数数组 nums ，其长度是 2 的幂。
//
//    对 nums 执行下述算法：
//
//    设 n 等于 nums 的长度，如果 n == 1 ，终止 算法过程。否则，创建 一个新的整数数组 newNums ，新数组长度为 n / 2 ，下标从 0 开始。
//    对于满足 0 <= i < n / 2 的每个 偶数 下标 i ，将 newNums[i] 赋值 为 min(nums[2 * i], nums[2 * i + 1]) 。
//    对于满足 0 <= i < n / 2 的每个 奇数 下标 i ，将 newNums[i] 赋值 为 max(nums[2 * i], nums[2 * i + 1]) 。
//    用 newNums 替换 nums 。
//    从步骤 1 开始 重复 整个过程。
//    执行算法后，返回 nums 中剩下的那个数字。
//
//    示例 1：
//    1     3     5     2     4     8     2     2
//      \ /         \ /         \ /         \ /
//      min         max         min         max
//       1           5           4           2
//           \   /                   \   /
//            min                     max
//             1                       4
//                       \   /
//                        min
//                         1
//    输入：nums = [1,3,5,2,4,8,2,2]
//    输出：1
//    解释：重复执行算法会得到下述数组。
//    第一轮：nums = [1,5,4,2]
//    第二轮：nums = [1,4]
//    第三轮：nums = [1]
//    1 是最后剩下的那个数字，返回 1 。
//
//    示例 2：
//    输入：nums = [3]
//    输出：3
//    解释：3 就是最后剩下的数字，返回 3 。
//
//    提示：
//    1 <= nums.length <= 1024
//    1 <= nums[i] <= 10^9
//    nums.length 是 2 的幂


public class Q2293 {
    public static void main(String[] args) {
        System.out.println(minMaxGame(InputMethods.getInputForOneIntArray()));
    }

    private static int minMaxGame(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] newNums = new int[n / 2];
        for (int i = 0; i < newNums.length; i++) {
            if (i % 2 == 0) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(newNums);
    }
}
