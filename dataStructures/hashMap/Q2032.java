package dataStructures.hashMap;

import utils.InputMethods;
import utils.TwoOneDIntArray;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are present in at least two out of the three arrays. You may return the values in any order.
//
//    Example 1:
//    Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
//    Output: [3,2]
//    Explanation: The values that are present in at least two arrays are:
//    - 3, in all three arrays.
//    - 2, in nums1 and nums2.
//
//    Example 2:
//    Input: nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
//    Output: [2,3,1]
//    Explanation: The values that are present in at least two arrays are:
//    - 2, in nums2 and nums3.
//    - 3, in nums1 and nums2.
//    - 1, in nums1 and nums3.
//
//    Example 3:
//    Input: nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
//    Output: []
//    Explanation: No value is present in at least two arrays.
//
//    Constraints:
//    1 <= nums1.length, nums2.length, nums3.length <= 100
//    1 <= nums1[i], nums2[j], nums3[k] <= 100


//给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
//
//    示例 1：
//    输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
//    输出：[3,2]
//    解释：至少在两个数组中出现的所有值为：
//    - 3 ，在全部三个数组中都出现过。
//    - 2 ，在数组 nums1 和 nums2 中出现过。
//
//    示例 2：
//    输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
//    输出：[2,3,1]
//    解释：至少在两个数组中出现的所有值为：
//    - 2 ，在数组 nums2 和 nums3 中出现过。
//    - 3 ，在数组 nums1 和 nums2 中出现过。
//    - 1 ，在数组 nums1 和 nums3 中出现过。
//
//    示例 3：
//    输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
//    输出：[]
//    解释：不存在至少在两个数组中出现的值。
//
//    提示：
//    1 <= nums1.length, nums2.length, nums3.length <= 100
//    1 <= nums1[i], nums2[j], nums3[k] <= 100


public class Q2032 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArray obj = InputMethods.getInputForTwoInt1DArray(cin);
        System.out.println(twoOutOfThree(obj.array1, obj.array2, InputMethods.getInputForOneIntArray()));
        cin.close();
    }

    private static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, 1);
        }
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) | 2);
        }
        for (int i : nums3) {
            map.put(i, map.getOrDefault(i, 0) | 4);
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            if ((v & (v - 1)) != 0) {
                res.add(k);
            }
        }
        return res;
    }
}
