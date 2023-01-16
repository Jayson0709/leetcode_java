package algorithms.math;

import utils.InputMethods;

import java.util.Arrays;


//You are given an array nums that consists of positive integers.
//
//    The GCD of a sequence of numbers is defined as the greatest integer that divides all the numbers in the sequence evenly.
//
//    For example, the GCD of the sequence [4,6,16] is 2.
//    A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
//
//    For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
//    Return the number of different GCDs among all non-empty subsequences of nums.
//
//    Example 1:
//    |Subsequences|GCD|
//    |[6]         |6  |
//    |[10]        |10 |
//    |[3]         |3  |
//    |[6, 10]     |2  |
//    |[6, 3]      |3  |
//    |[10, 3]     |1  |
//    |[6, 10, 3]  |1  |
//    Input: nums = [6,10,3]
//    Output: 5
//    Explanation: The figure shows all the non-empty subsequences and their GCDs.
//    The different GCDs are 6, 10, 3, 2, and 1.
//
//    Example 2:
//    Input: nums = [5,15,40,5,6]
//    Output: 7
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 2 * 10^5


//给你一个由正整数组成的数组 nums 。
//
//    数字序列的 最大公约数 定义为序列中所有整数的共有约数中的最大整数。
//
//    例如，序列 [4,6,16] 的最大公约数是 2 。
//    数组的一个 子序列 本质是一个序列，可以通过删除数组中的某些元素（或者不删除）得到。
//
//    例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
//    计算并返回 nums 的所有 非空 子序列中 不同 最大公约数的 数目 。
//
//    示例 1：
//    |Subsequences|GCD|
//    |[6]         |6  |
//    |[10]        |10 |
//    |[3]         |3  |
//    |[6, 10]     |2  |
//    |[6, 3]      |3  |
//    |[10, 3]     |1  |
//    |[6, 10, 3]  |1  |
//    输入：nums = [6,10,3]
//    输出：5
//    解释：上图显示了所有的非空子序列与各自的最大公约数。
//    不同的最大公约数为 6 、10 、3 、2 和 1 。
//
//    示例 2：
//    输入：nums = [5,15,40,5,6]
//    输出：7
//
//    提示：
//    1 <= nums.length <= 10^5
//    1 <= nums[i] <= 2 * 10^5


public class Q1819 {
    public static void main(String[] args) {
        System.out.println(countDifferentSubsequencesGCDs(InputMethods.getInputForOneIntArray()));
    }

    private static int countDifferentSubsequencesGCDs(int[] nums) {
        int maxVal = -1;
        if (Arrays.stream(nums).max().isPresent()) {
            maxVal = Arrays.stream(nums).max().getAsInt();
        }
        boolean[] occurred = new boolean[maxVal + 1];
        for (int num : nums) {
            occurred[num] = true;
        }
        int ans = 0;
        for (int i = 1; i <= maxVal; i++) {
            int subGcd = 0;
            for (int j = i; j <= maxVal; j += i) {
                if (occurred[j]) {
                    if (subGcd == 0) {
                        subGcd = j;
                    } else {
                        subGcd = gcd(subGcd, j);
                    }
                    if (subGcd == i) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
