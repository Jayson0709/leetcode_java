package math;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//
//    Increment the large integer by one and return the resulting array of digits.
//
//    Example 1:
//    Input: digits = [1,2,3]
//    Output: [1,2,4]
//    Explanation: The array represents the integer 123.
//    Incrementing by one gives 123 + 1 = 124.
//    Thus, the result should be [1,2,4].
//
//    Example 2:
//    Input: digits = [4,3,2,1]
//    Output: [4,3,2,2]
//    Explanation: The array represents the integer 4321.
//    Incrementing by one gives 4321 + 1 = 4322.
//    Thus, the result should be [4,3,2,2].
//
//    Example 3:
//    Input: digits = [9]
//    Output: [1,0]
//    Explanation: The array represents the integer 9.
//    Incrementing by one gives 9 + 1 = 10.
//    Thus, the result should be [1,0].
//
//    Constraints:
//    1 <= digits.length <= 100
//    0 <= digits[i] <= 9
//    digits does not contain any leading 0's.


//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
//    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
//    你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//    示例 1：
//    输入：digits = [1,2,3]
//    输出：[1,2,4]
//    解释：输入数组表示数字 123。
//
//    示例 2：
//    输入：digits = [4,3,2,1]
//    输出：[4,3,2,2]
//    解释：输入数组表示数字 4321。
//
//    示例 3：
//    输入：digits = [0]
//    输出：[1]
//
//    提示：
//    1 <= digits.length <= 100
//    0 <= digits[i] <= 9



public class Q66 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] digits = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        StringBuilder output = new StringBuilder();
        int[] result = plusOne(digits);
        output.append("[");
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                output.append(result[i]);
            } else {
                output.append(", ").append(result[i]);
            }
        }
        output.append("]");
        System.out.println(output);
    }

    private static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // all digits are 9 in the array, overflow
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
