package dataStructures.array.simulation;

import utils.InputMethods;

import java.util.Arrays;



//You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such that all of these parts represent the same binary value.
//
//    If it is possible, return any [i, j] with i + 1 < j, such that:
//
//    arr[0], arr[1], ..., arr[i] is the first part,
//    arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
//    arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
//    All three parts have equal binary values.
//    If it is not possible, return [-1, -1].
//
//    Note that the entire part is used when considering what binary value it represents. For example, [1,1,0] represents 6 in decimal, not 3. Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.
//
//    Example 1:
//    Input: arr = [1,0,1,0,1]
//    Output: [0,3]
//
//    Example 2:
//    Input: arr = [1,1,0,1,1]
//    Output: [-1,-1]
//
//    Example 3:
//    Input: arr = [1,1,0,0,1]
//    Output: [0,2]
//
//    Constraints:
//    3 <= arr.length <= 3 * 10^4
//    arr[i] is 0 or 1



//给定一个由 0 和 1 组成的数组 arr ，将数组分成  3 个非空的部分 ，使得所有这些部分表示相同的二进制值。
//
//    如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
//
//    arr[0], arr[1], ..., arr[i] 为第一部分；
//    arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分；
//    arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。
//    这三个部分所表示的二进制值相等。
//    如果无法做到，就返回 [-1, -1]。
//
//    注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
//
//    示例 1：
//    输入：arr = [1,0,1,0,1]
//    输出：[0,3]
//
//    示例 2：
//    输入：arr = [1,1,0,1,1]
//    输出：[-1,-1]
//
//    示例 3:
//    输入：arr = [1,1,0,0,1]
//    输出：[0,2]
//
//    提示：
//    3 <= arr.length <= 3 * 10^4
//    arr[i] 是 0 或 1


public class Q927 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(threeEqualParts(InputMethods.getInputForOneIntArray())));
    }

    private static int[] threeEqualParts(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }
        int partial = sum / 3;
        int first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == partial) {
                    second = i;
                } else if (cur == 2 * partial) {
                    third = i;
                }
                cur++;
            }
        }
        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            int i = 0;
            while (third + i < arr.length) {
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
                i++;
            }
            return new int[]{first + len - 1, second + len};
        }
        return new int[]{-1, -1};
    }
}