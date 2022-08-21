package dataStructures.array.simpleArray;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
//
//    You should rearrange the elements of nums such that the modified array follows the given conditions:
//
//    Every consecutive pair of integers have opposite signs.
//    For all integers with the same sign, the order in which they were present in nums is preserved.
//    The rearranged array begins with a positive integer.
//    Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
//
//    Example 1:
//    Input: nums = [3,1,-2,-5,2,-4]
//    Output: [3,-2,1,-5,2,-4]
//    Explanation:
//    The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
//    The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
//    Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
//
//    Example 2:
//    Input: nums = [-1,1]
//    Output: [1,-1]
//    Explanation:
//    1 is the only positive integer and -1 the only negative integer in nums.
//    So nums is rearranged to [1,-1].
//
//    Constraints:
//    2 <= nums.length <= 2 * 105
//    nums.length is even
//    1 <= |nums[i]| <= 105
//    nums consists of equal number of positive and negative integers.


//给你一个下标从 0 开始的整数数组 nums ，数组长度为 偶数 ，由数目相等的正整数和负整数组成。
//
//    你需要 重排 nums 中的元素，使修改后的数组满足下述条件：
//
//    任意连续 的两个整数 符号相反
//    对于符号相同的所有整数，保留 它们在 nums 中的 顺序 。
//    重排后数组以正整数开头。
//    重排元素满足上述条件后，返回修改后的数组。
//
//    示例 1：
//    输入：nums = [3,1,-2,-5,2,-4]
//    输出：[3,-2,1,-5,2,-4]
//    解释：
//    nums 中的正整数是 [3,1,2] ，负整数是 [-2,-5,-4] 。
//    重排的唯一可行方案是 [3,-2,1,-5,2,-4]，能满足所有条件。
//    像 [1,-2,2,-5,3,-4]、[3,1,2,-2,-5,-4]、[-2,3,-5,1,-4,2] 这样的其他方案是不正确的，因为不满足一个或者多个条件。
//
//    示例 2：
//    输入：nums = [-1,1]
//    输出：[1,-1]
//    解释：
//    1 是 nums 中唯一一个正整数，-1 是 nums 中唯一一个负整数。
//    所以 nums 重排为 [1,-1] 。
//
//    提示：
//    2 <= nums.length <= 2 * 105
//    nums.length 是 偶数
//    1 <= |nums[i]| <= 105
//    nums 由 相等 数量的正整数和负整数组成


public class Q2149 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        int[] result = rearrangeArray(nums);
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    private static int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int num : nums) {
            if (num >= 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }
        int index = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            result[index] = positives.get(i);
            index++;
            result[index] = negatives.get(i);
            index++;
        }
        return result;
    }
}
