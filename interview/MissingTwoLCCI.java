package interview;

import utils.InputMethods;

import java.util.Arrays;


//You are given an array with all the numbers from 1 to N appearing exactly once, except for two number that is missing. How can you find the missing number in O(N) time and 0(1) space?
//
//    You can return the missing numbers in any order.
//
//    Example 1:
//    Input: [1]
//    Output: [2,3]
//    
//    Example 2:
//    Input: [2,3]
//    Output: [1,4]
//    
//    Note:
//    nums.length <= 30000



//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
//
//    以任意顺序返回这两个数字均可。
//
//    示例 1:
//    输入: [1]
//    输出: [2,3]
//
//    示例 2:
//    输入: [2,3]
//    输出: [1,4]
//
//    提示：
//    nums.length <= 30000


public class MissingTwoLCCI {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(missingTwo(InputMethods.getInputForOneIntArray())));
    }

    // a simple Math question
    private static int[] missingTwo(int[] nums) {
        int n = nums.length + 2, curr = n * (n + 1) / 2;
        curr -= Arrays.stream(nums).sum();
        int pairSum = curr, t = curr / 2;
        curr = t * (t + 1) / 2;
        for (int num : nums) {
            if (num <= t) {
                curr -= num;
            }
        }
        return new int[]{curr, pairSum - curr};
    }
}
