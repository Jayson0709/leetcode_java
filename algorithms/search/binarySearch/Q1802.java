package algorithms.search.binarySearch;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:
//
//    nums.length == n
//    nums[i] is a positive integer where 0 <= i < n.
//    abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
//    The sum of all the elements of nums does not exceed maxSum.
//    nums[index] is maximized.
//    Return nums[index] of the constructed array.
//
//    Note that abs(x) equals x if x >= 0, and -x otherwise.
//
//    Example 1:
//    Input: n = 4, index = 2,  maxSum = 6
//    Output: 2
//    Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
//    There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].
//
//    Example 2:
//    Input: n = 6, index = 1,  maxSum = 10
//    Output: 3
//
//    Constraints:
//    1 <= n <= maxSum <= 10^9
//    0 <= index < n


//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
//
//    nums.length == n
//    nums[i] 是 正整数 ，其中 0 <= i < n
//    abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
//    nums 中所有元素之和不超过 maxSum
//    nums[index] 的值被 最大化
//    返回你所构造的数组中的 nums[index] 。
//
//    注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
//
//    示例 1：
//    输入：n = 4, index = 2,  maxSum = 6
//    输出：2
//    解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
//
//    示例 2：
//    输入：n = 6, index = 1,  maxSum = 10
//    输出：3
//
//    提示：
//    1 <= n <= maxSum <= 10^9
//    0 <= index < n


public class Q1802 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = Integer.parseInt(cin.nextLine().strip());
        int index = Integer.parseInt(cin.nextLine().strip());
        int maxSum = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        System.out.println(maxValue(n, index, maxSum));
    }

    private static int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (valid(mid, n, index, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static boolean valid(int mid, int n, int index, int maxSum) {
        int right = n - index - 1;
        return mid + cal(mid, index) + cal(mid, right) <= maxSum;
    }

    public static long cal(int big, int length) {
        if (length + 1 < big) {
            int small = big - length;
            return (long) (big - 1 + small) * length / 2;
        } else {
            int ones = length - (big - 1);
            return (long) big * (big - 1) / 2 + ones;
        }
    }
}
