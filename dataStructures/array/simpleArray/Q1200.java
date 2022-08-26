package dataStructures.array.simpleArray;

import utils.InputMethods;
import utils.OutputMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of distinct integers' arr, find all pairs of elements with the minimum absolute difference of any two elements.
//
//    Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
//        - a, b are from arr
//        - a < b
//        - 'b - a' equals to the minimum absolute difference of any two elements in arr
//
//    Example 1:
//    Input: arr = [4,2,1,3]
//    Output: [[1,2],[2,3],[3,4]]
//    Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
//
//    Example 2:
//    Input: arr = [1,3,6,10,15]
//    Output: [[1,3]]
//
//    Example 3:
//    Input: arr = [3,8,-10,23,19,-4,-14,27]
//    Output: [[-14,-10],[19,23],[23,27]]
//
//    Constraints:
//    2 <= arr.length <= 10^5
//    -10^6 <= arr[i] <= 10^6



//给你个整数数组arr，其中每个元素都 不相同。
//
//    请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
//
//    示例 1：
//    输入：arr = [4,2,1,3]
//    输出：[[1,2],[2,3],[3,4]]
//
//    示例 2：
//    输入：arr = [1,3,6,10,15]
//    输出：[[1,3]]
//
//    示例 3：
//    输入：arr = [3,8,-10,23,19,-4,-14,27]
//    输出：[[-14,-10],[19,23],[23,27]]
//
//    提示：
//    2 <= arr.length <= 10^5
//    -10^6 <= arr[i] <= 10^6


public class Q1200 {
    public static void main(String[] args) {
        List<List<Integer>> result = minimumAbsDifference(InputMethods.getInputForOneIntArray());
        System.out.println(OutputMethods.formatNestedListOutputData(result));
    }

    private static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int minAbs = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int curDiff = arr[i] - arr[i - 1];
            if (curDiff < minAbs) {
                minAbs = curDiff;
                result.clear();
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                result.add(pair);
            } else if (curDiff == minAbs) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i -1]);
                pair.add(arr[i]);
                result.add(pair);
            }
        }
        return result;
    }
}
