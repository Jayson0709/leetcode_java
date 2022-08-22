package algorithms.sorting;

import utils.InputMethods;
import utils.OutputMethods;
import utils.TwoOneDArray;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

//Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
//
//    Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
//
//    Example 1:
//    Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//    Output: [2,2,2,1,4,3,3,9,6,7,19]
//
//    Example 2:
//    Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//    Output: [22,28,8,6,17,44]
//
//    Constraints:
//    1 <= arr1.length, arr2.length <= 1000
//    0 <= arr1[i], arr2[i] <= 1000
//    All the elements of arr2 are distinct.
//    Each arr2[i] is in arr1.


//给你两个数组，arr1 和arr2，arr2中的元素各不相同，arr2 中的每个元素都出现在arr1中。
//
//    对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
//
//    示例 1：
//    输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//    输出：[2,2,2,1,4,3,3,9,6,7,19]
//
//    示例 2:
//    输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//    输出：[22,28,8,6,17,44]
//
//    提示：
//    1 <= arr1.length, arr2.length <= 1000
//    0 <= arr1[i], arr2[i] <= 1000
//    arr2中的元素arr2[i]各不相同
//    arr2 中的每个元素arr2[i]都出现在arr1中


public class Q1122 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDArray obj = InputMethods.getTwoInt1DArrayInput(cin);
        cin.close();
        int[] result = relativeSortArray(obj.array1, obj.array2);
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    // Method: Counting sort
    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int num : arr1) {
            upper = Math.max(upper, num);
        }
        int[] frequency = new int[upper + 1];
        for (int num : arr1) {
            frequency[num]++;
        }
        int[] result = new int[arr1.length];
        int index = 0;
        for (int num : arr2) {
            for (int i = 0; i < frequency[num]; i++){
                result[index++] = num;
            }
            frequency[num] = 0;
        }
        for (int x = 0; x <= upper; x++) {
            for (int i = 0; i < frequency[x]; i++) {
                result[index++] = x;
            }
        }
        return result;
    }
}
