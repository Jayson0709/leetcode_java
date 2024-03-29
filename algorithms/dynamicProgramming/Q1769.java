package algorithms.dynamicProgramming;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


//You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
//
//    In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
//
//    Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
//
//    Each answer[i] is calculated considering the initial state of the boxes.
//
//    Example 1:
//    Input: boxes = "110"
//    Output: [1,1,3]
//    Explanation: The answer for each box is as follows:
//    1) First box: you will have to move one ball from the second box to the first box in one operation.
//    2) Second box: you will have to move one ball from the first box to the second box in one operation.
//    3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
//
//    Example 2:
//    Input: boxes = "001011"
//    Output: [11,8,5,4,3,4]
//
//    Constraints:
//    n == boxes.length
//    1 <= n <= 2000
//    boxes[i] is either '0' or '1'.


//有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
//
//    在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。
//
//    返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
//
//    每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
//
//    示例 1：
//    输入：boxes = "110"
//    输出：[1,1,3]
//    解释：每个盒子对应的最小操作数如下：
//    1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
//    2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
//    3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共计 3 步操作。
//
//    示例 2：
//
//    输入：boxes = "001011"
//    输出：[11,8,5,4,3,4]
//
//    提示：
//    n == boxes.length
//    1 <= n <= 2000
//    boxes[i] 为 '0' 或 '1'


public class Q1769 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String boxes = cin.nextLine().strip();
        cin.close();
        System.out.println(Arrays.toString(minOperations(boxes)));
    }

    // Version 1: Dynamic programming
    private static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] dp = new int[n];
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                dp[0] += i;
                right += 1;
            }
        }
        for (int j = 1; j < n; j++) {
            if (boxes.charAt(j - 1) == '1') {
                left++;
                right--;
            }
            dp[j] = dp[j - 1] + left - right;
        }
        return dp;
    }

    // Version 2: simulation - brute force
//    private static int[] minOperations(String boxes) {
//        int n = boxes.length();
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            int sm = 0;
//            for (int j = 0; j < n; j++) {
//                if (boxes.charAt(j) == '1') {
//                    sm += Math.abs(j - i);
//                }
//            }
//            res[i] = sm;
//        }
//        return res;
//    }

    // Version3 : use dp-like method
//    private static int[] minOperations(String boxes) {
//        int left = boxes.charAt(0) - '0', right = 0, operations = 0;
//        int n = boxes.length();
//        for (int i = 1; i < n; i++) {
//            if (boxes.charAt(i) == '1') {
//                right++;
//                operations += i;
//            }
//        }
//        int[] res = new int[n];
//        res[0] = operations;
//        for (int i = 1; i < n; i++) {
//            operations += left - right;
//            if (boxes.charAt(i) == '1') {
//                left++;
//                right--;
//            }
//            res[i] = operations;
//        }
//        return res;
//    }
}
