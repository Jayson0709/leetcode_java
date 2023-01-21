package algorithms.dynamicProgramming;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//There is a donuts shop that bakes donuts in batches of batchSize. They have a rule where they must serve all the donuts of a batch before serving any donuts of the next batch. You are given an integer batchSize and an integer array groups, where groups[i] denotes that there is a group of groups[i] customers that will visit the shop. Each customer will get exactly one donut.
//
//    When a group visits the shop, all customers of the group must be served before serving any of the following groups. A group will be happy if they all get fresh donuts. That is, the first customer of the group does not receive a donut that was left over from the previous group.
//
//    You can freely rearrange the ordering of the groups. Return the maximum possible number of happy groups after rearranging the groups.
//
//    Example 1:
//    Input: batchSize = 3, groups = [1,2,3,4,5,6]
//    Output: 4
//    Explanation: You can arrange the groups as [6,2,4,5,1,3]. Then the 1st, 2nd, 4th, and 6th groups will be happy.
//
//    Example 2:
//    Input: batchSize = 4, groups = [1,3,2,5,2,2,1,6]
//    Output: 4
//
//    Constraints:
//    1 <= batchSize <= 9
//    1 <= groups.length <= 30
//    1 <= groups[i] <= 10^9


//有一个甜甜圈商店，每批次都烤 batchSize 个甜甜圈。这个店铺有个规则，就是在烤一批新的甜甜圈时，之前 所有 甜甜圈都必须已经全部销售完毕。给你一个整数 batchSize 和一个整数数组 groups ，数组中的每个整数都代表一批前来购买甜甜圈的顾客，其中 groups[i] 表示这一批顾客的人数。每一位顾客都恰好只要一个甜甜圈。
//
//    当有一批顾客来到商店时，他们所有人都必须在下一批顾客来之前购买完甜甜圈。如果一批顾客中第一位顾客得到的甜甜圈不是上一组剩下的，那么这一组人都会很开心。
//
//    你可以随意安排每批顾客到来的顺序。请你返回在此前提下，最多 有多少组人会感到开心。
//
//    示例 1：
//    输入：batchSize = 3, groups = [1,2,3,4,5,6]
//    输出：4
//    解释：你可以将这些批次的顾客顺序安排为 [6,2,4,5,1,3] 。那么第 1，2，4，6 组都会感到开心。
//
//    示例 2：
//    输入：batchSize = 4, groups = [1,3,2,5,2,2,1,6]
//    输出：4
//
//    提示：
//    1 <= batchSize <= 9
//    1 <= groups.length <= 30
//    1 <= groups[i] <= 10^9


public class Q1815 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int batchSize = Integer.parseInt(cin.nextLine().strip());
        int[] groups = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        System.out.println(maxHappyGroups(batchSize, groups));
    }

    static final int K_WIDTH = 5;
    static final int K_WIDTH_MASK = (1 << K_WIDTH) - 1;

    private static int maxHappyGroups(int batchSize, int[] groups) {
        int[] cnt = new int[batchSize];
        for (int x : groups) {
            cnt[x % batchSize]++;
        }
        long start = 0;
        for (int i = batchSize - 1; i >= 1; --i) {
            start = (start << K_WIDTH) | cnt[i];
        }
        Map<Long, Integer> memo = new HashMap<>();
        return dfs(memo, batchSize, start) + cnt[0];
    }

    public static int dfs(Map<Long, Integer> memo, int batchSize, long mask) {
        if (mask == 0) {
            return 0;
        }

        if (!memo.containsKey(mask)) {
            long total = 0;
            for (int i = 1; i < batchSize; ++i) {
                long amount = ((mask >> ((i - 1) * K_WIDTH)) & K_WIDTH_MASK);
                total += i * amount;
            }
            int best = 0;
            for (int i = 1; i < batchSize; ++i) {
                long amount = ((mask >> ((i - 1) * K_WIDTH)) & K_WIDTH_MASK);
                if (amount > 0) {
                    int result = dfs(memo, batchSize, mask - (1L << ((i - 1) * K_WIDTH)));
                    if ((total - i) % batchSize == 0) {
                        ++result;
                    }
                    best = Math.max(best, result);
                }
            }

            memo.put(mask, best);
        }
        return memo.get(mask);
    }
}
