package algorithms.greedyAlgorithms;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//You are given an integer num. You can swap two digits at most once to get the maximum valued number.
//
//    Return the maximum valued number you can get.
//
//    Example 1:
//    Input: num = 2736
//    Output: 7236
//    Explanation: Swap the number 2 and the number 7.
//
//    Example 2:
//    Input: num = 9973
//    Output: 9973
//    Explanation: No swap.
//
//    Constraints:
//    0 <= num <= 10^8



//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
//
//    示例 1 :
//    输入: 2736
//    输出: 7236
//    解释: 交换数字2和数字7。
//
//    示例 2 :
//    输入: 9973
//    输出: 9973
//    解释: 不需要交换。
//
//    注意:
//    给定数字的范围是[0, 10^8]



public class Q670 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int num = cin.nextInt();
        cin.close();
        System.out.println(maximumSwap(num));
    }

    // Method 1: Brute force
//    private static int maximumSwap(int num) {
//        char[] charArray = String.valueOf(num).toCharArray();
//        int n = charArray.length;
//        int maxNum = num;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                swap(charArray, i, j);
//                maxNum = Math.max(maxNum, Integer.parseInt(new String(charArray)));
//                swap(charArray, i, j);
//            }
//        }
//        return maxNum;
//    }
//
//    public static void swap(char[] charArray, int i, int j) {
//        char temp = charArray[i];
//        charArray[i] = charArray[j];
//        charArray[j] = temp;
//    }

    // Method 2: Greedy algorithm
    private static int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxIdx = n - 1;
        int idx1 = -1, idx2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (charArray[i] > charArray[maxIdx]) {
                maxIdx = i;
            } else if (charArray[i] < charArray[maxIdx]) {
                idx1 = i;
                idx2 = maxIdx;
            }
        }
        if (idx1 >= 0) {
            swap(charArray, idx1, idx2);
            return Integer.parseInt(new String(charArray));
        } else {
            return num;
        }
    }

    public static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
