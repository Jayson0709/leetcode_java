package algorithms.math;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//A self-dividing number is a number that is divisible by every digit it contains.
//
//    For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
//    A self-dividing number is not allowed to contain the digit zero.
//
//    Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].
//
//    Example 1:
//    Input: left = 1, right = 22
//    Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
//
//    Example 2:
//    Input: left = 47, right = 85
//    Output: [48,55,66,77]
//
//    Constraints:
//    1 <= left <= right <= 10^4



//自除数是指可以被它包含的每一位数整除的数。
//
//    例如，128 是一个 自除数 ，因为128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
//    自除数 不允许包含 0 。
//
//    给定两个整数left和right ，返回一个列表，列表的元素是范围[left, right]内所有的 自除数 。
//
//    示例 1：
//    输入：left = 1, right = 22
//    输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
//
//    示例 2:
//    输入：left = 47, right = 85
//    输出：[48,55,66,77]
//
//    提示：
//    1 <= left <= right <= 10^4



public class Q728 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int left = cin.nextInt();
        int right = cin.nextInt();
        cin.close();
        List<Integer> result = selfDividingNumbers(left, right);
        System.out.println(OutputMethods.outputListData(result));
    }

    // Method 1: Use Math
    private static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isSelfDividing(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}
