package algorithms.dynamicProgramming;
import java.util.*;
import java.nio.charset.StandardCharsets;

//You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).
//
//    The triangular sum of nums is the value of the only element present in nums after the following process terminates:
//
//    Let nums comprise n elements. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n - 1.
//    For each index i, where 0 <= i <n - 1, assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
//    Replace the array nums with newNums.
//    Repeat the entire process starting from step 1.
//    Return the triangular sum of nums.
//
//    Example 1:
//    1   2   3   4   5
//      3   5   7   9
//        8   2   6
//          0   8
//            8
//    Input: nums = [1,2,3,4,5]
//    Output: 8
//    Explanation:
//    The above diagram depicts the process from which we obtain the triangular sum of the array.
//    
//    Example 2:
//    Input: nums = [5]
//    Output: 5
//    Explanation:
//    Since there is only one element in nums, the triangular sum is the value of that element itself.
//
//    Constraints:
//    1 <= nums.length <= 1000
//    0 <= nums[i] <= 9


//给你一个下标从 0开始的整数数组nums，其中nums[i]是 0到 9之间（两者都包含）的一个数字。
//
//    nums的 三角和是执行以下操作以后最后剩下元素的值：
//
//    nums初始包含n个元素。如果n == 1，终止操作。否则，创建一个新的下标从0开始的长度为 n - 1的整数数组newNums。
//    对于满足0 <= i <n - 1的下标i，newNums[i] 赋值为(nums[i] + nums[i+1]) % 10，%表示取余运算。
//    将newNums替换 数组nums。
//    从步骤 1 开始重复整个过程。
//    请你返回nums的三角和。
//
//    示例 1：
//    1   2   3   4   5
//      3   5   7   9
//        8   2   6
//          0   8
//            8
//    输入：nums = [1,2,3,4,5]
//    输出：8
//    解释：
//    上图展示了得到数组三角和的过程。
//
//    示例 2：
//    输入：nums = [5]
//    输出：5
//    解释：
//    由于 nums 中只有一个元素，数组的三角和为这个元素自己。
//
//    提示：
//    1 <= nums.length <= 1000
//    0 <= nums[i] <= 9


public class Q2221 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        int result = triangularSum(nums);
        System.out.println(result);
    }

    private static int triangularSum(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[][] dp = new int[n][n];
        dp[0] = nums;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) % 10;
            }
        }
        return dp[n -1][0];
    }
}
