package algorithms.greedyAlgorithms;

import utils.InputMethods;


//You have a water dispenser that can dispense cold, warm, and hot water. Every second, you can either fill up 2 cups with different types of water, or 1 cup of any type of water.
//
//    You are given a 0-indexed integer array amount of length 3 where amount[0], amount[1], and amount[2] denote the number of cold, warm, and hot water cups you need to fill respectively. Return the minimum number of seconds needed to fill up all the cups.
//
//    Example 1:
//    Input: amount = [1,4,2]
//    Output: 4
//    Explanation: One way to fill up the cups is:
//    Second 1: Fill up a cold cup and a warm cup.
//    Second 2: Fill up a warm cup and a hot cup.
//    Second 3: Fill up a warm cup and a hot cup.
//    Second 4: Fill up a warm cup.
//    It can be proven that 4 is the minimum number of seconds needed.
//
//    Example 2:
//    Input: amount = [5,4,4]
//    Output: 7
//    Explanation: One way to fill up the cups is:
//    Second 1: Fill up a cold cup, and a hot cup.
//    Second 2: Fill up a cold cup, and a warm cup.
//    Second 3: Fill up a cold cup, and a warm cup.
//    Second 4: Fill up a warm cup, and a hot cup.
//    Second 5: Fill up a cold cup, and a hot cup.
//    Second 6: Fill up a cold cup, and a warm cup.
//    Second 7: Fill up a hot cup.
//
//    Example 3:
//    Input: amount = [5,0,0]
//    Output: 5
//    Explanation: Every second, we fill up a cold cup.
//
//    Constraints:
//    amount.length == 3
//    0 <= amount[i] <= 100


//现有一台饮水机，可以制备冷水、温水和热水。每秒钟，可以装满 2 杯 不同 类型的水或者 1 杯任意类型的水。
//
//    给你一个下标从 0 开始、长度为 3 的整数数组 amount ，其中 amount[0]、amount[1] 和 amount[2] 分别表示需要装满冷水、温水和热水的杯子数量。返回装满所有杯子所需的 最少 秒数。
//
//    示例 1：
//    输入：amount = [1,4,2]
//    输出：4
//    解释：下面给出一种方案：
//    第 1 秒：装满一杯冷水和一杯温水。
//    第 2 秒：装满一杯温水和一杯热水。
//    第 3 秒：装满一杯温水和一杯热水。
//    第 4 秒：装满一杯温水。
//    可以证明最少需要 4 秒才能装满所有杯子。
//
//    示例 2：
//    输入：amount = [5,4,4]
//    输出：7
//    解释：下面给出一种方案：
//    第 1 秒：装满一杯冷水和一杯热水。
//    第 2 秒：装满一杯冷水和一杯温水。
//    第 3 秒：装满一杯冷水和一杯温水。
//    第 4 秒：装满一杯温水和一杯热水。
//    第 5 秒：装满一杯冷水和一杯热水。
//    第 6 秒：装满一杯冷水和一杯温水。
//    第 7 秒：装满一杯热水。
//
//    示例 3：
//    输入：amount = [5,0,0]
//    输出：5
//    解释：每秒装满一杯冷水。
//
//    提示：
//    amount.length == 3
//    0 <= amount[i] <= 100

public class Q2335 {
    public static void main(String[] args) {
        System.out.println(filLCups(InputMethods.getInputForOneIntArray()));
    }

    private static int filLCups(int[] amount) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int i : amount) {
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
        }

        if (max1 >= max2 + max3) {
            return max1;
        } else {
            return (max1 + max2 + max3 + 1) >> 1;
        }
    }
}
