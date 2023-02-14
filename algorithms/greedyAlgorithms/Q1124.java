package algorithms.greedyAlgorithms;

import utils.InputMethods;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


//We are given hours, a list of the number of hours worked per day for a given employee.
//
//    A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
//
//    A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
//
//    Return the length of the longest well-performing interval.
//
//    Example 1:
//    Input: hours = [9,9,6,0,6,6,9]
//    Output: 3
//    Explanation: The longest well-performing interval is [9,9,6].
//
//    Example 2:
//    Input: hours = [6,6,6]
//    Output: 0
//
//    Constraints:
//    1 <= hours.length <= 10^4
//    0 <= hours[i] <= 16


//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
//
//    我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
//
//    所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
//
//    请你返回「表现良好时间段」的最大长度。
//
//    示例 1：
//    输入：hours = [9,9,6,0,6,6,9]
//    输出：3
//    解释：最长的表现良好时间段是 [9,9,6]。
//
//    示例 2：
//    输入：hours = [6,6,6]
//    输出：0
//
//    提示：
//    1 <= hours.length <= 10^4
//    0 <= hours[i] <= 16


public class Q1124 {
    public static void main(String[] args) {
        System.out.println(longestWPI(InputMethods.getInputForOneIntArray()));
    }


    // Method 1: Stack + Greedy algorithm
    private static int longestWPI(int[] hours) {
        int n = hours.length;
        int[] s = new int[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (!stack.isEmpty() && s[stack.peek()] > s[i]) {
                stack.push(i);
            }
        }

        int res = 0;
        for (int r = n; r >= 1; r--) {
            while (!stack.isEmpty() && s[stack.peek()] < s[r]) {
                res = Math.max(res, r - stack.pop());
            }
        }
        return res;
    }

    // Method 2: HashMap
//    private static int longestWPI(int[] hours) {
//        int n = hours.length;
//        Map<Integer, Integer> hashMap = new HashMap<>();
//        int s = 0, res = 0;
//        for (int i = 0; i < n; i++) {
//            s += hours[i] > 8 ? 1 : -1;
//            if (s > 0) {
//                res = Math.max(res, i + 1);
//            } else {
//                if (hashMap.containsKey(s - 1)) {
//                    res = Math.max(res, i - hashMap.get(s - 1));
//                }
//            }
//            if (!hashMap.containsKey(s)) {
//                hashMap.put(s, i);
//            }
//        }
//        return res;
//    }
}
