package algorithms.search.binarySearch;

import utils.InputMethods;
import utils.OneDIntArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


//给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
//
//    如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
//
//    请注意，答案不一定是 arr 中的数字。
//
//    示例 1：
//    输入：arr = [4,9,3], target = 10
//    输出：3
//    解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
//
//    示例 2：
//    输入：arr = [2,3,5], target = 10
//    输出：5
//
//    示例 3：
//    输入：arr = [60864,25176,27249,21296,20204], target = 56803
//    输出：11361
//
//    提示：
//    1 <= arr.length <= 10^4
//    1 <= arr[i], target <= 10^5


//Given an integer array arr and a target value target, return the integer value such that when we change all the integers larger than value in the given array to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.
//
//    In case of a tie, return the minimum such integer.
//
//    Notice that the answer is not necessarily a number from arr.
//
//    Example 1:
//    Input: arr = [4,9,3], target = 10
//    Output: 3
//    Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
//
//    Example 2:
//    Input: arr = [2,3,5], target = 10
//    Output: 5
//
//    Example 3:
//    Input: arr = [60864,25176,27249,21296,20204], target = 56803
//    Output: 11361
//
//    Constraints:
//    1 <= arr.length <= 10^4
//    1 <= arr[i], target <= 10^5



public class Q1300 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDIntArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(findBestValue(obj.array, obj.val));
    }

    // Method 1: Enumeration + binary search
//    private static int findBestValue(int[] arr, int target) {
//        Arrays.sort(arr);
//        int n = arr.length;
//        int[] prefix = new int[n + 1];
//        for (int i = 1; i <= n; ++i) {
//            prefix[i] = prefix[i - 1] + arr[i - 1];
//        }
//        int r = arr[n - 1];
//        int ans = 0, diff = target;
//        for (int i = 1; i <= r; ++i) {
//            int index = Arrays.binarySearch(arr, i);
//            if (index < 0) {
//                index = -index - 1;
//            }
//            int cur = prefix[index] + (n - index) * i;
//            if (Math.abs(cur - target) < diff) {
//                ans = i;
//                diff = Math.abs(cur - target);
//            }
//        }
//        return ans;
//    }

    // Method 2: Double binary search
    private static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int l = 0, r = arr[n - 1], ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int index = Arrays.binarySearch(arr, mid);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (n - index) * mid;
            if (cur <= target) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        int chooseSmall = check(arr, ans);
        int chooseBig = check(arr, ans + 1);
        return Math.abs(chooseSmall - target) <= Math.abs(chooseBig - target) ? ans : ans + 1;
    }

    public static int check(int[] arr, int x) {
        int ret = 0;
        for (int num : arr) {
            ret += Math.min(num, x);
        }
        return ret;
    }
}
