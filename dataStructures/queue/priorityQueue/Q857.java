package dataStructures.queue.priorityQueue;

import utils.InputMethods;
import utils.TwoOneDIntArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;



//There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.
//
//    We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:
//
//    Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
//    Every worker in the paid group must be paid at least their minimum wage expectation.
//    Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10^(-5) of the actual answer will be accepted.
//    
//    Example 1:
//    Input: quality = [10,20,5], wage = [70,50,30], k = 2
//    Output: 105.00000
//    Explanation: We pay 70 to 0th worker and 35 to 2nd worker.
//    
//    Example 2:
//    Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
//    Output: 30.66667
//    Explanation: We pay 4 to 0th worker, 13.33333 to 2nd and 3rd workers separately.
//
//    Constraints:
//    n == quality.length == wage.length
//    1 <= k <= n <= 10^4
//    1 <= quality[i], wage[i] <= 10^4



//有 n 名工人。 给定两个数组 quality 和 wage ，其中，quality[i] 表示第 i 名工人的工作质量，其最低期望工资为 wage[i] 。
//
//    现在我们想雇佣 k 名工人组成一个工资组。在雇佣 一组 k 名工人时，我们必须按照下述规则向他们支付工资：
//
//    对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
//    工资组中的每名工人至少应当得到他们的最低期望工资。
//    给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额 。在实际答案的 10^（-5) 以内的答案将被接受。。
//
//    示例 1：
//    输入： quality = [10,20,5], wage = [70,50,30], k = 2
//    输出： 105.00000
//    解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
//
//    示例 2：
//    输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
//    输出： 30.66667
//    解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。
//
//    提示：
//    n == quality.length == wage.length
//    1 <= k <= n <= 10^4
//    1 <= quality[i], wage[i] <= 10^4



public class Q857 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArrayAndOneInt obj = InputMethods.getInputForTwoInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(mincostToHireWorkers(obj.array1, obj.array2, obj.val));
    }

    private static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] h = new Integer[n];
        for (int i = 0; i < n; i++) {
            h[i] = i;
        }
        Arrays.sort(h, (a, b) -> quality[b] * wage[a] - quality[a] * wage[b]);
        double res = 1e9;
        double totalQuality = 0.0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            totalQuality += quality[h[i]];
            pq.offer(quality[h[i]]);
        }
        for (int i = k - 1; i < n; i++) {
            int idx = h[i];
            totalQuality += quality[idx];
            pq.offer(quality[idx]);
            double totalCost = ((double) wage[idx] / quality[idx]) * totalQuality;
            res = Math.min(res, totalCost);
            Integer temp = pq.poll();
            if (temp != null) {
                totalQuality -= temp;
            }
        }
        return res;
    }
}
