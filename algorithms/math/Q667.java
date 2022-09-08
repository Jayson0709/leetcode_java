package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


//Given two integers n and k, construct a list answer that contains n different positive integers ranging from 1 to n and obeys the following requirement:
//
//    Suppose this list is answer = [a1, a2, a3, ... , a_n], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |a_n-1 - a_n|] has exactly k distinct integers.
//    Return the list answer. If there are multiple valid answers, return any of them.
//
//    Example 1:
//    Input: n = 3, k = 1
//    Output: [1,2,3]
//    Explanation: The [1,2,3] has three different positive integers ranging from 1 to 3, and the [1,1] has exactly 1 distinct integer: 1
//
//    Example 2:
//    Input: n = 3, k = 2
//    Output: [1,3,2]
//    Explanation: The [1,3,2] has three different positive integers ranging from 1 to 3, and the [2,1] has exactly 2 distinct integers: 1 and 2.
//
//    Constraints:
//    1 <= k < n <= 10^4



//给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
//
//    假设该列表是 answer = [a1, a2, a3, ... , a_n] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |a_n-1 - a_n|] 中应该有且仅有 k 个不同整数。
//    返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
//
//    示例 1：
//    输入：n = 3, k = 1
//    输出：[1, 2, 3]
//    解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
//
//    示例 2：
//    输入：n = 3, k = 2
//    输出：[1, 3, 2]
//    解释：[1, 3, 2] 包含 3 个范围在 1-3 的不同整数，并且 [2, 1] 中有且仅有 2 个不同整数：1 和 2
//
//    提示：
//    1 <= k < n <= 10^4



public class Q667 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        int k = cin.nextInt();
        cin.close();
        System.out.println(Arrays.toString(constructArray(n, k)));
    }

    private static int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int index = 0;
        for (int i = 1; i < n - k; i++) {
            answer[index] = i;
            index++;
        }
        for (int i = n - k, j = n; i <= j; i++, j--) {
            answer[index] = i;
            index++;
            if (i != j) {
                answer[index] = j;
                index++;
            }
        }
        return answer;
    }
}
