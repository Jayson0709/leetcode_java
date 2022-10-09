package dataStructures.hashMap;

import utils.*;

import java.nio.charset.StandardCharsets;
import java.util.*;


//You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty sub-array of arr and reverse it. You are allowed to make any number of steps.
//
//    Return true if you can make arr equal to target or false otherwise.
//
//    Example 1:
//    Input: target = [1,2,3,4], arr = [2,4,1,3]
//    Output: true
//    Explanation: You can follow the next steps to convert arr to target:
//    1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
//    2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
//    3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
//    There are multiple ways to convert arr to target, this is not the only way to do so.
//
//    Example 2:
//    Input: target = [7], arr = [7]
//    Output: true
//    Explanation: arr is equal to target without any reverses.
//
//    Example 3:
//    Input: target = [3,7,9], arr = [3,7,11]
//    Output: false
//    Explanation: arr does not have value 9 and it can never be converted to target.
//
//    Constraints:
//    target.length == arr.length
//    1 <= target.length <= 1000
//    1 <= target[i] <= 1000
//    1 <= arr[i] <= 1000



//给你两个长度相同的整数数组 target 和 arr 。每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
//
//    如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
//
//    示例 1：
//    输入：target = [1,2,3,4], arr = [2,4,1,3]
//    输出：true
//    解释：你可以按照如下步骤使 arr 变成 target：
//    1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
//    2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
//    3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
//    上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
//
//    示例 2：
//    输入：target = [7], arr = [7]
//    输出：true
//    解释：arr 不需要做任何翻转已经与 target 相等。
//
//    示例 3：
//    输入：target = [3,7,9], arr = [3,7,11]
//    输出：false
//    解释：arr 没有数字 9 ，所以无论如何也无法变成 target 。
//
//    提示：
//    target.length == arr.length
//    1 <= target.length <= 1000
//    1 <= target[i] <= 1000
//    1 <= arr[i] <= 1000




public class Q1460 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArray obj = InputMethods.getInputForTwoInt1DArray(cin);
        cin.close();
        System.out.println(canBeEqual(obj.array1, obj.array2));
    }

    // Method 1: use sort
//    private static boolean canBeEqual(int[] target, int[] arr) {
//        if (target.length != arr.length) {
//            return false;
//        }
//        Arrays.sort(target);
//        Arrays.sort(arr);
//        for (int i = 0; i < target.length; i++) {
//            if (target[i] != arr[i]) {
//                return false;
//            }
//        }
//        return true;
//    }

    // Method 2: use HashMap
    private static boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Map<Integer, Integer> targetMap = new HashMap<>();
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int num : target) {
            targetMap.put(num, targetMap.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            arrMap.put(num, arrMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : targetMap.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (!arrMap.containsKey(key) || arrMap.get(key) != value) {
                return false;
            }
        }
        return true;
    }
}
