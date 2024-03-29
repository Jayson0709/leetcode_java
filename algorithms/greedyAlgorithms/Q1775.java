package algorithms.greedyAlgorithms;

import utils.InputMethods;
import utils.TwoOneDIntArray;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//You are given two arrays of integers nums1 and nums2, possibly of different lengths. The values in the arrays are between 1 and 6, inclusive.
//
//    In one operation, you can change any integer's value in any of the arrays to any value between 1 and 6, inclusive.
//
//    Return the minimum number of operations required to make the sum of values in nums1 equal to the sum of values in nums2. Return -1 if it is not possible to make the sum of the two arrays equal.
//
//    Example 1:
//    Input: nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//    Output: 3
//    Explanation: You can make the sums of nums1 and nums2 equal with 3 operations. All indices are 0-indexed.
//    - Change nums2[0] to 6. nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2].
//    - Change nums1[5] to 1. nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2].
//    - Change nums1[2] to 2. nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2].
//
//    Example 2:
//    Input: nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//    Output: -1
//    Explanation: There is no way to decrease the sum of nums1 or to increase the sum of nums2 to make them equal.
//
//    Example 3:
//    Input: nums1 = [6,6], nums2 = [1]
//    Output: 3
//    Explanation: You can make the sums of nums1 and nums2 equal with 3 operations. All indices are 0-indexed.
//    - Change nums1[0] to 2. nums1 = [2,6], nums2 = [1].
//    - Change nums1[1] to 2. nums1 = [2,2], nums2 = [1].
//    - Change nums2[0] to 4. nums1 = [2,2], nums2 = [4].
//
//    Constraints:
//    1 <= nums1.length, nums2.length <= 10^5
//    1 <= nums1[i], nums2[i] <= 6


//给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
//
//    每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
//
//    请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
//
//    示例 1：
//    输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//    输出：3
//    解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//    - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
//    - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
//    - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
//
//    示例 2：
//    输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//    输出：-1
//    解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
//
//    示例 3：
//    输入：nums1 = [6,6], nums2 = [1]
//    输出：3
//    解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//    - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
//    - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
//    - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
//
//    提示：
//    1 <= nums1.length, nums2.length <= 10^5
//    1 <= nums1[i], nums2[i] <= 6


public class Q1775 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArray obj = InputMethods.getInputForTwoInt1DArray(cin);
        cin.close();
        System.out.println(minOperations(obj.array1, obj.array2));
    }

    private static int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (6 * n < m || 6 * m < n) {
            return -1;
        }
        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];
        int diff = 0;
        for (int i : nums1) {
            cnt1[i]++;
            diff += i;
        }
        for (int i : nums2) {
            cnt2[i]++;
            diff -= i;
        }
        if (diff == 0) {
            return 0;
        }
        if (diff > 0) {
            return help(cnt2, cnt1, diff);
        }
        return help(cnt1, cnt2, -diff);
    }

    private static int help(int[] h1, int[] h2, int diff) {
        int[] h = new int[7];
        for (int i = 1; i < 7; ++i) {
            h[6 - i] += h1[i];
            h[i - 1] += h2[i];
        }
        int res = 0;
        for (int i = 5; i > 0 && diff > 0; i--) {
            int t = Math.min((diff + i - 1) / i, h[i]);
            res += t;
            diff -= t * i;
        }
        return res;
    }
}
