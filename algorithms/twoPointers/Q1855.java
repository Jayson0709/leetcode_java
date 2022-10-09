package algorithms.twoPointers;

import utils.InputMethods;
import utils.TwoOneDIntArray;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//You are given two non-increasing 0-indexed integer arrays nums1 and nums2.
//
//    A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length, is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i.
//
//    Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.
//
//    An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.
//
//    Example 1:
//
//    Input: nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
//    Output: 2
//    Explanation: The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
//    The maximum distance is 2 with pair (2,4).
//    Example 2:
//
//    Input: nums1 = [2,2,2], nums2 = [10,10,1]
//    Output: 1
//    Explanation: The valid pairs are (0,0), (0,1), and (1,1).
//    The maximum distance is 1 with pair (0,1).
//    Example 3:
//
//    Input: nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
//    Output: 2
//    Explanation: The valid pairs are (2,2), (2,3), (2,4), (3,3), and (3,4).
//    The maximum distance is 2 with pair (2,4).
//
//    Constraints:
//
//    1 <= nums1.length, nums2.length <= 105
//    1 <= nums1[i], nums2[j] <= 105
//    Both nums1 and nums2 are non-increasing.


//给你两个 非递增 的整数数组 nums1 和 nums2，数组下标均 从 0 开始 计数。
//
//    下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i 。
//
//    返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
//
//    一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。
//
//    示例 1：
//
//    输入：nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
//    输出：2
//    解释：有效下标对是 (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) 和 (4,4) 。
//    最大距离是 2 ，对应下标对 (2,4) 。
//    示例 2：
//
//    输入：nums1 = [2,2,2], nums2 = [10,10,1]
//    输出：1
//    解释：有效下标对是 (0,0), (0,1) 和 (1,1) 。
//    最大距离是 1 ，对应下标对 (0,1) 。
//    示例 3：
//
//    输入：nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
//    输出：2
//    解释：有效下标对是 (2,2), (2,3), (2,4), (3,3) 和 (3,4) 。
//    最大距离是 2 ，对应下标对 (2,4) 。
//
//    提示：
//
//    1 <= nums1.length <= 105
//    1 <= nums2.length <= 105
//    1 <= nums1[i], nums2[j] <= 105
//    nums1 和 nums2 都是 非递增 数组

public class Q1855 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArray obj = InputMethods.getInputForTwoInt1DArray(cin);
        int result = maxDistance(obj.array1, obj.array2);
        cin.close();
        System.out.println(result);
    }

    private static int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        int i = 0;
        int length1 = nums1.length;
        for (int j = 0; j < nums2.length; j++) {
            while (i < length1 && nums1[i] > nums2[j]) {
                i++;
            }
            if (i < length1) {
                maxDistance = Math.max(maxDistance, j - i);
            }
        }
        return maxDistance;
    }
}
