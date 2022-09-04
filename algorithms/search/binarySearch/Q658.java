package algorithms.search.binarySearch;

import utils.*;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
//
//    An integer 'a' is closer to x than an integer b if:
//    |a - x| < |b - x|, or
//    |a - x| == |b - x| and a < b
//
//    Example 1:
//    Input: arr = [1,2,3,4,5], k = 4, x = 3
//    Output: [1,2,3,4]
//    
//    Example 2:
//    Input: arr = [1,2,3,4,5], k = 4, x = -1
//    Output: [1,2,3,4]
//    
//    Constraints:
//    1 <= k <= arr.length
//    1 <= arr.length <= 10^4
//    arr is sorted in ascending order.
//    -10^4 <= arr[i], x <= 10^4



//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
//
//    整数 a 比整数 b 更接近 x 需要满足：
//    |a - x| < |b - x| 或者
//    |a - x| == |b - x| 且 a < b
//
//    示例 1：
//    输入：arr = [1,2,3,4,5], k = 4, x = 3
//    输出：[1,2,3,4]
//
//    示例 2：
//    输入：arr = [1,2,3,4,5], k = 4, x = -1
//    输出：[1,2,3,4]
//
//    提示：
//    1 <= k <= arr.length
//    1 <= arr.length <= 10^4
//    arr 按 升序 排列
//    -10^4 <= arr[i], x <= 10^4



public class Q658 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDArrayAndTwoInt obj = InputMethods.getInputFOrOneInt1DArrayAndTwoInt(cin);
        cin.close();
        System.out.println(findClosestElements(obj.array, obj.val1, obj.val2));
    }

    // Method 1: purely use Sorting
//    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> dataList = new ArrayList<>();
//        for (int num : arr) {
//            dataList.add(num);
//        }
//        dataList.sort((a, b) -> {
//            if (Math.abs(a - x) != Math.abs(b - x)) {
//                return Math.abs(a - x) - Math.abs(b - x);
//            } else {
//                return a - b;
//            }
//        });
//        List<Integer> ans = dataList.subList(0, k);
//        Collections.sort(ans);
//        return ans;
//    }

    // Method 2: Binary Search + Two Pointers
    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    private static int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
