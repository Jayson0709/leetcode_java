package interview;

import utils.InputMethods;

import java.util.HashSet;
import java.util.Set;


//An array contains all the integers from 0 to n, except for one number which is missing.  Write code to find the missing integer. Can you do it in O(n) time?
//
//    Note: This problem is slightly different from the original one the book.
//
//    Example 1:
//    Input: [3,0,1]
//    Output: 2
//
//    Example 2:
//    Input: [9,6,4,2,3,5,7,0,1]
//    Output: 8


//数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
//
//    注意：本题相对书上原题稍作改动
//
//    示例 1：
//    输入：[3,0,1]
//    输出：2
//
//    示例 2：
//    输入：[9,6,4,2,3,5,7,0,1]
//    输出：8


public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(InputMethods.getInputForOneIntArray()));
    }

    // Method 1: HashSet
//    private static int missingNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        int n = nums.length;
//        for (int num : nums) {
//            set.add(num);
//        }
//        int missing = -1;
//        for (int i = 0; i <= n; i++) {
//            if (!set.contains(i)) {
//                missing = i;
//                break;
//            }
//        }
//        return missing;
//    }

    // Method 2: Bit Manipulation
//    private static int missingNumber(int[] nums) {
//        int xor = 0;
//        int n = nums.length;
//        for (int num : nums) {
//            xor ^= num;
//        }
//        for (int i = 0; i <= n; i++) {
//            xor ^= i;
//        }
//        return xor;
//    }

    // Method 3: use Math
    private static int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = 0;
        for (int num : nums) {
            arrSum += num;
        }
        return total - arrSum;
    }
}
