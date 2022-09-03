package algorithms.windowSliding;

import utils.InputMethods;
import utils.TwoOneDArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.
//
//    On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.
//
//    When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.
//
//    The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.
//
//    Return the maximum number of customers that can be satisfied throughout the day.
//    
//    Example 1:
//    Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
//    Output: 16
//    Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
//    The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
//    
//    Example 2:
//    Input: customers = [1], grumpy = [0], minutes = 1
//    Output: 1
//
//    Constraints:
//    n == customers.length == grumpy.length
//    1 <= minutes <= n <= 2 * 10^4
//    0 <= customers[i] <= 1000
//    grumpy[i] is either 0 or 1.



//有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
//
//    在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
//
//    当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
//
//    书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
//
//    请你返回 这一天营业下来，最多有多少客户能够感到满意 。
//
//    示例 1：
//    输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
//    输出：16
//    解释：书店老板在最后 3 分钟保持冷静。
//    感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
//
//    示例 2：
//    输入：customers = [1], grumpy = [0], minutes = 1
//    输出：1
//
//    提示：
//    n == customers.length == grumpy.length
//    1 <= minutes <= n <= 2 * 10^4
//    0 <= customers[i] <= 1000
//    grumpy[i] == 0 or 1



public class Q1052 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDArrayAndOneInt obj = InputMethods.getInputForTwoInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(maxSatisfied(obj.array1, obj.array2, obj.val));
    }

    private static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }
        // Use the secret technique, to get the first possible value of increased number of customers.
        int increase = 0;
        for (int i = 0; i < minutes; i++) {
            increase += customers[i] * grumpy[i];
        }
        // To get the max increase
        int maxIncrease = increase;
        for (int i = minutes; i < n; i++) {
            increase = increase - customers[i - minutes] * grumpy[i - minutes] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return res + maxIncrease;
    }
}
