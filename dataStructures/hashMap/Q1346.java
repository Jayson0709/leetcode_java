package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
//
//    More formally check if there exists two indices i and j such that :
//
//    i != j
//    0 <= i, j < arr.length
//    arr[i] == 2 * arr[j]
//
//    Example 1:
//    Input: arr = [10,2,5,3]
//    Output: true
//    Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
//    
//    Example 2:
//    Input: arr = [7,1,14,11]
//    Output: true
//    Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
//    
//    Example 3:
//    Input: arr = [3,1,7,11]
//    Output: false
//    Explanation: In this case does not exist N and M, such that N = 2 * M.
//
//    Constraints:
//    2 <= arr.length <= 500
//    -10^3 <= arr[i] <= 10^3



//给你一个整数数组arr，请你检查是否存在两个整数N 和 M，满足N是M的两倍（即，N = 2 * M）。
//
//    更正式地，检查是否存在两个下标i 和 j 满足：
//
//    i != j
//    0 <= i, j < arr.length
//    arr[i] == 2 * arr[j]
//
//    示例 1：
//    输入：arr = [10,2,5,3]
//    输出：true
//    解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
//
//    示例 2：
//    输入：arr = [7,1,14,11]
//    输出：true
//    解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
//
//    示例 3：
//    输入：arr = [3,1,7,11]
//    输出：false
//    解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
//
//    提示：
//    2 <= arr.length <= 500
//    -10^3 <= arr[i] <= 10^3



public class Q1346 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] arr = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        boolean result = checkIfExist(arr);
        System.out.println(result);
    }

    // Method 1: sorting + two pointers
//    private static boolean checkIfExist(int[] arr) {
//        Arrays.sort(arr);
//        int n = arr.length;
//        int p1 = 0, p2 = arr.length - 1;
//        for (int i = 0; i < n; i++) {
//            while (p1 < n && arr[i] * 2 > arr[p1]) {
//                p1++;
//            }
//            if (p1 != n && i != p1 && arr[i] * 2 == arr[p1]) {
//                return true;
//            }
//        }
//        for (int i = n - 1; i > -1; i--) {
//            while (p2 > -1 && arr[i] * 2 < arr[p2]) {
//                p2--;
//            }
//            if (p2 != -1 && i != p2 && arr[i] * 2 == arr[p2]) {
//                return true;
//            }
//        }
//        return false;
//    }

    // Method 2: HashSet
    private static boolean checkIfExist(int[] arr) {
        Set<Integer> hSet = new HashSet<>();
        for (int num : arr) {
            if (hSet.contains(2 * num) || (num % 2 == 0 && hSet.contains(num / 2))) {
                return true;
            }
            hSet.add(num);
        }
        return false;
    }
}
