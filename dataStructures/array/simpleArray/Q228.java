package dataStructures.array.simpleArray;

import utils.InputMethods;

import java.util.ArrayList;
import java.util.List;


//You are given a sorted unique integer array nums.
//
//    A range [a,b] is the set of all integers from a to b (inclusive).
//
//    Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
//
//    Each range [a,b] in the list should be output as:
//
//    "a->b" if a != b
//    "a" if a == b
//
//    Example 1:
//    Input: nums = [0,1,2,4,5,7]
//    Output: ["0->2","4->5","7"]
//    Explanation: The ranges are:
//    [0,2] --> "0->2"
//    [4,5] --> "4->5"
//    [7,7] --> "7"
//
//    Example 2:
//    Input: nums = [0,2,3,4,6,8,9]
//    Output: ["0","2->4","6","8->9"]
//    Explanation: The ranges are:
//    [0,0] --> "0"
//    [2,4] --> "2->4"
//    [6,6] --> "6"
//    [8,9] --> "8->9"
//
//    Constraints:
//    0 <= nums.length <= 20
//    -2^31 <= nums[i] <= 2^31 - 1
//    All the values of nums are unique.
//    nums is sorted in ascending order.



//给定一个  无重复元素 的  有序 整数数组 nums 。
//
//    返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表  。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
//
//    列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//    "a->b" ，如果 a != b
//    "a" ，如果 a == b
//
//    示例 1：
//    输入：nums = [0,1,2,4,5,7]
//    输出：["0->2","4->5","7"]
//    解释：区间范围是：
//    [0,2] --> "0->2"
//    [4,5] --> "4->5"
//    [7,7] --> "7"
//
//    示例 2：
//    输入：nums = [0,2,3,4,6,8,9]
//    输出：["0","2->4","6","8->9"]
//    解释：区间范围是：
//    [0,0] --> "0"
//    [2,4] --> "2->4"
//    [6,6] --> "6"
//    [8,9] --> "8->9"
//
//    提示：
//    0 <= nums.length <= 20
//    -2^31 <= nums[i] <= 2^31 - 1
//    nums 中的所有值都 互不相同
//    nums 按升序排列


public class Q228 {
    public static void main(String[] args) {
        System.out.println(summaryRanges(InputMethods.getInputForOneIntArray()));
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            res.add(temp.toString());
        }
        return res;
    }
}
