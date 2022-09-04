package algorithms.sorting;

import utils.InputMethods;
import utils.OneDArrayAndOneInt;

import java.util.Arrays;

// Find the smallest K numbers given an array. (This question is on the Chinese LeetCode website)

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//    示例 1：
//
//    输入：arr = [3,2,1], k = 2
//    输出：[1,2] 或者 [2,1]
//    示例 2：
//
//    输入：arr = [0,1,2,1], k = 1
//    输出：[0]
//
//    限制：
//
//    0 <= k <= arr.length <= 10000
//    0 <= arr[i]<= 10000


public class SmallestK {
    public static void main(String[] args) {
        OneDArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt();
        System.out.println(Arrays.toString(getLeastNumbers(obj.array, obj.val)));
    }

    private static int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        arraySort(arr, 0, arr.length - 1);
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }

    private static void arraySort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = arr[low];
        int i = low;
        int j = high;
        int temp;
        while (i < j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];
        arr[i] = pivot;
        arraySort(arr, low, j - 1);
        arraySort(arr, j + 1, high);
    }
}
