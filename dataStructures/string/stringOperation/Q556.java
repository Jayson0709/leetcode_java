package dataStructures.string.stringOperation;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
//
//    Note that the returned integer should fit in 32-bit integer, if there is a valid answer, but it does not fit in 32-bit integer, return -1.
//    
//    Example 1:
//    Input: n = 12
//    Output: 21
//
//    Example 2:
//    Input: n = 21
//    Output: -1
//
//    Constraints:
//    1 <= n <= 231 - 1



//给你一个正整数n ，请你找出符合条件的最小整数，其由重新排列 n中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
//
//    注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
//
//    示例 1：
//    输入：n = 12
//    输出：21
//
//    示例 2：
//    输入：n = 21
//    输出：-1
//
//    提示：
//    1 <= n <= 231 - 1


public class Q556 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(nextGreaterElement(n));
    }

    private static int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);
        long result = Long.parseLong(new String(nums));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    private static void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(char[] nums, int begin) {
        int i = begin;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
