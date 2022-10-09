package algorithms.greedyAlgorithms;

import utils.InputMethods;
import utils.TwoOneDIntArray;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


//You are given two integer arrays nums1 and nums2 both of the same length. The advantage of nums1 with respect to nums2 is the number of indices i for which nums1[i] > nums2[i].
//
//    Return any permutation of nums1 that maximizes its advantage with respect to nums2.
//    
//    Example 1:
//    Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//    Output: [2,11,7,15]
//    
//    Example 2:
//    Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//    Output: [24,32,8,12]
//
//    Constraints:
//    1 <= nums1.length <= 10^5
//    nums2.length == nums1.length
//    0 <= nums1[i], nums2[i] <= 10^9



//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
//
//    返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
//
//    示例 1：
//    输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//    输出：[2,11,7,15]
//
//    示例 2：
//    输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//    输出：[24,32,8,12]
//
//    提示：
//    1 <= nums1.length <= 10^5
//    nums2.length == nums1.length
//    0 <= nums1[i], nums2[i] <= 10^9



public class Q870 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArray obj = InputMethods.getInputForTwoInt1DArray(cin);
        cin.close();
        System.out.println(Arrays.toString(advantageCount(obj.array1, obj.array2)));
    }

    private static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, Comparator.comparingInt(i -> nums1[i]));
        Arrays.sort(idx2, Comparator.comparingInt(i -> nums2[i]));

        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                ans[idx2[left]] = nums1[idx1[i]];
                left++;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                right--;
            }
        }
        return ans;
    }
}
