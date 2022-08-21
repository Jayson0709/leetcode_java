package algorithms.twoPointers;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
//
//    Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
//
//    Example 1:
//    Input: arr = [1,0,2,3,0,4,5,0]
//    Output: [1,0,0,2,3,0,0,4]
//    Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
//
//    Example 2:
//    Input: arr = [1,2,3]
//    Output: [1,2,3]
//    Explanation: After calling your function, the input array is modified to: [1,2,3]
//
//    Constraints:
//    1 <= arr.length <= 104
//    0 <= arr[i] <= 9


//给你一个长度固定的整数数组arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
//
//    注意：请不要在超过该数组长度的位置写入元素。
//
//    要求：请对输入的数组就地进行上述修改，不要从函数返回任何东西。
//
//    示例 1：
//    输入：[1,0,2,3,0,4,5,0]
//    输出：null
//    解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
//
//    示例 2：
//    输入：[1,2,3]
//    输出：null
//    解释：调用函数后，输入的数组将被修改为：[1,2,3]
//
//    提示：
//    1 <= arr.length <= 10000
//    0 <= arr[i] <= 9


public class Q1089 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] arr = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        duplicateZeros(arr);
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0)
                System.out.print(arr[i]);
            else
                System.out.print("," + arr[i]);
        }
        System.out.print("]");
    }

    // 方法一：双指针，模拟一个栈
    private static void duplicateZeros(int[] arr) {
        int len = arr.length;
        int top = 0;
        int i = -1;
        while (top < len) {
            i++;
            if (arr[i] != 0) {
                top++;
            } else {
                top += 2;
            }
        }
        int j = len - 1;
        if (top == len + 1) {
            arr[j] = 0;
            j--;
            i--;
        }
        while (j >= 0) {
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                arr[j] = arr[i];
                j--;
            }
            i--;
        }
    }

    // 方法二，暴力解法
//    private static void duplicateZeros(int[] arr) {
//        String s = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining()).replace("0", "00");
//        for (int i = 0; i < arr.length; ++i)
//            arr[i] = s.charAt(i) - '0';
//    }
}
