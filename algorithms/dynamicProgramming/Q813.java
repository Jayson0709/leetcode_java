package algorithms.dynamicProgramming;

import utils.InputMethods;
import utils.OneDIntArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given an integer array nums and an integer k. You can partition the array into at most k non-empty adjacent sub-arrays. The score of a partition is the sum of the averages of each subarray.
//
//    Note that the partition must use every integer in nums, and that the score is not necessarily an integer.
//
//    Return the maximum score you can achieve of all the possible partitions. Answers within 10-6 of the actual answer will be accepted.
//
//    Example 1:
//    Input: nums = [9,1,2,3,9], k = 3
//    Output: 20.00000
//    Explanation:
//    The best choice is to partition nums into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
//    We could have also partitioned nums into [9, 1], [2], [3, 9], for example.
//    That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
//
//    Example 2:
//    Input: nums = [1,2,3,4,5,6,7], k = 4
//    Output: 20.50000
//
//    Constraints:
//    1 <= nums.length <= 100
//    1 <= nums[i] <= 10^4
//    1 <= k <= nums.length


//给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。
//
//    注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
//
//    返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。
//
//    示例 1:
//    输入: nums = [9,1,2,3,9], k = 3
//    输出: 20.00000
//    解释:
//    nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
//    我们也可以把 nums 分成[9, 1], [2], [3, 9].
//    这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
//
//    示例 2:
//    输入: nums = [1,2,3,4,5,6,7], k = 4
//    输出: 20.50000
//
//    提示:
//    1 <= nums.length <= 100
//    1 <= nums[i] <= 10^4
//    1 <= k <= nums.length


public class Q813 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDIntArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(largestSumOfAverages(obj.array, obj.val));
    }

    private static double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[] dp = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = prefix[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = n; i >= j; i--) {
                for (int x = j - 1; x < i; x++) {
                    dp[i] = Math.max(dp[i], dp[x] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n];
    }
}
