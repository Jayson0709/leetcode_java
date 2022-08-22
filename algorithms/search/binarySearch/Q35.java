package algorithms.search.binarySearch;

import utils.InputMethods;
import utils.OneDArrayAndOneInt;

//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//    You must write an algorithm with O(log n) runtime complexity.
//
//    Example 1:
//    Input: nums = [1,3,5,6], target = 5
//    Output: 2
//
//    Example 2:
//    Input: nums = [1,3,5,6], target = 2
//    Output: 1
//
//    Example 3:
//    Input: nums = [1,3,5,6], target = 7
//    Output: 4
//
//    Constraints:
//    1 <= nums.length <= 104
//    -104 <= nums[i] <= 104
//    nums contains distinct values sorted in ascending order.
//    -104 <= target <= 104


//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//    请必须使用时间复杂度为 O(log n) 的算法。
//
//    示例 1:
//    输入: nums = [1,3,5,6], target = 5
//    输出: 2
//
//    示例2:
//    输入: nums = [1,3,5,6], target = 2
//    输出: 1
//
//    示例 3:
//    输入: nums = [1,3,5,6], target = 7
//    输出: 4
//
//    提示:
//    1 <= nums.length <= 104
//    -104 <= nums[i] <= 104
//    nums 为无重复元素的升序排列数组
//    -104 <= target <= 104


public class Q35 {
    public static void main(String[] args) {
        OneDArrayAndOneInt obj = InputMethods.getOneInt1DArrayAndOneIntInput();
        int result = searchInsert(obj.array, obj.val);
        System.out.println(result);
    }

    private static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
