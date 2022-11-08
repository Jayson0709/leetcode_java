package algorithms.twoPointers;

import utils.InputMethods;


//Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
//
//    Example 1:
//    Input: arr = [1,2,2,6,6,6,6,7,10]
//    Output: 6
//
//    Example 2:
//    Input: arr = [1,1]
//    Output: 1
//
//    Constraints:
//    1 <= arr.length <= 10^4
//    0 <= arr[i] <= 10^5


//给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
//
//    请你找到并返回这个整数
//
//    示例：
//    输入：arr = [1,2,2,6,6,6,6,7,10]
//    输出：6
//
//    提示：
//    1 <= arr.length <= 10^4
//    0 <= arr[i] <= 10^5


public class Q1287 {
    public static void main(String[] args) {
        System.out.println(findSpecialInteger(InputMethods.getInputForOneIntArray()));
    }

    private static int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int slowIdx = 0;
        int slowValue = arr[0];
        int fastIdx = 0;
        int fastValue;
        while (fastIdx < n) {
            fastValue = arr[fastIdx];
            if (fastValue != slowValue) {
                if ((fastIdx - slowIdx) * 4 > n) {
                    return slowValue;
                } else {
                    slowIdx = fastIdx;
                    slowValue = fastValue;
                }
            }
            fastIdx++;
        }

        if ((fastIdx - slowIdx) * 4 > n) {
            return slowValue;
        }
        return 0;
    }
}
