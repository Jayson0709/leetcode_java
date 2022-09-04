package dataStructures.array.simpleArray;

import utils.InputMethods;
import utils.OneDArrayAndOneInt;

import java.util.Arrays;


//Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
//
//    Return the array in the form [x1,y1,x2,y2,...,xn,yn].
//
//    Example 1:
//    Input: nums = [2,5,1,3,4,7], n = 3
//    Output: [2,3,5,4,1,7]
//    Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
//
//    Example 2:
//    Input: nums = [1,2,3,4,4,3,2,1], n = 4
//    Output: [1,4,2,3,3,2,4,1]
//
//    Example 3:
//    Input: nums = [1,1,2,2], n = 2
//    Output: [1,2,1,2]
//
//    Constraints:
//    1 <= n <= 500
//    nums.length == 2n
//    1 <= nums[i] <= 10^3



//给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
//
//    请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
//
//    示例 1：
//    输入：nums = [2,5,1,3,4,7], n = 3
//    输出：[2,3,5,4,1,7]
//    解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
//
//    示例 2：
//    输入：nums = [1,2,3,4,4,3,2,1], n = 4
//    输出：[1,4,2,3,3,2,4,1]
//
//    示例 3：
//    输入：nums = [1,1,2,2], n = 2
//    输出：[1,2,1,2]
//
//    提示：
//    1 <= n <= 500
//    nums.length == 2n
//    1 <= nums[i] <= 10^3



public class Q1470 {
    public static void main(String[] args) {
        OneDArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt();
        System.out.println(Arrays.toString(shuffle(obj.array, obj.val)));
    }

    private static int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[n + i];
        }
        return res;
    }
}
