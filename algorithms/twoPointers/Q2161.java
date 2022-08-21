package algorithms.twoPointers;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:
//
//    Every element less than pivot appears before every element greater than pivot.
//    Every element equal to pivot appears in between the elements less than and greater than pivot.
//    The relative order of the elements less than pivot and the elements greater than pivot is maintained.
//    More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. For elements less than pivot, if i < j and nums[i] < pivot and nums[j] < pivot, then pi < pj. Similarly for elements greater than pivot, if i < j and nums[i] > pivot and nums[j] > pivot, then pi < pj.
//    Return nums after the rearrangement.
//
//    Example 1:
//    Input: nums = [9,12,5,10,14,3,10], pivot = 10
//    Output: [9,5,3,10,10,12,14]
//    Explanation:
//    The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array.
//    The elements 12 and 14 are greater than the pivot so they are on the right side of the array.
//    The relative ordering of the elements less than and greater than pivot is also maintained. [9, 5, 3] and [12, 14] are the respective orderings.
//    
//    Example 2:
//    Input: nums = [-3,4,3,2], pivot = 2
//    Output: [-3,2,4,3]
//    Explanation:
//    The element -3 is less than the pivot so it is on the left side of the array.
//    The elements 4 and 3 are greater than the pivot so they are on the right side of the array.
//    The relative ordering of the elements less than and greater than pivot is also maintained. [-3] and [4, 3] are the respective orderings.
//
//    Constraints:
//    1 <= nums.length <= 105
//    -106 <= nums[i] <= 106
//    pivot equals to an element of nums


//给你一个下标从 0开始的整数数组nums和一个整数pivot。请你将nums重新排列，使得以下条件均成立：
//
//    所有小于pivot的元素都出现在所有大于pivot的元素之前。
//    所有等于pivot的元素都出现在小于和大于 pivot的元素 中间。
//    小于 pivot的元素之间和大于 pivot的元素之间的 相对顺序不发生改变。
//    更正式的，考虑每一对pi，pj，pi是初始时位置 i元素的新位置，pj是初始时位置j元素的新位置。对于小于pivot的元素，如果i < j且nums[i] < pivot 和nums[j] < pivot都成立，那么pi < pj也成立。类似的，对于大于pivot的元素，如果i < j 且nums[i] > pivot 和nums[j] > pivot都成立，那么pi < pj。
//    请你返回重新排列 nums数组后的结果数组。
//
//    示例 1：
//    输入：nums = [9,12,5,10,14,3,10], pivot = 10
//    输出：[9,5,3,10,10,12,14]
//    解释：
//    元素 9 ，5 和 3 小于 pivot ，所以它们在数组的最左边。
//    元素 12 和 14 大于 pivot ，所以它们在数组的最右边。
//    小于 pivot 的元素的相对位置和大于 pivot 的元素的相对位置分别为 [9, 5, 3] 和 [12, 14] ，它们在结果数组中的相对顺序需要保留。
//
//    示例 2：
//    输入：nums = [-3,4,3,2], pivot = 2
//    输出：[-3,2,4,3]
//    解释：
//    元素 -3 小于 pivot ，所以在数组的最左边。
//    元素 4 和 3 大于 pivot ，所以它们在数组的最右边。
//    小于 pivot 的元素的相对位置和大于 pivot 的元素的相对位置分别为 [-3] 和 [4, 3] ，它们在结果数组中的相对顺序需要保留。
//
//    提示：
//    1 <= nums.length <= 105
//    -106 <= nums[i] <= 106
//    pivot等于nums中的一个元素。


public class Q2161 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int pivot = cin.nextInt();
        cin.close();

        int[] result = pivotArray(nums, pivot);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if (i == 0)
                System.out.print(result[i]);
            else
                System.out.print("," + result[i]);
        }
        System.out.print("]");
    }

    private static int[] pivotArray(int[] nums, int pivot) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, pivot);
        int left = 0;
        int right = length - 1;
        for (int num : nums) {
            if (num < pivot) {
                result[left] = num;
                left += 1;
            } else if (num > pivot) {
                result[right] = num;
                right -= 1;
            }
        }
        // reverse the element that are bigger than the pivot
        int x = right + 1;
        int y = length - 1;
        while (x < y) {
            int temp = result[x];
            result[x] = result[y];
            result[y] = temp;
            x += 1;
            y -= 1;
        }
        return result;
    }
}
