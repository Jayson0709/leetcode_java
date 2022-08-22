package algorithms.dynamicProgramming;

import utils.InputMethods;


//There are n rooms you need to visit, labeled from 0 to n - 1. Each day is labeled, starting from 0. You will go in and visit one room a day.
//
//    Initially on day 0, you visit room 0. The order you visit the rooms for the coming days is determined by the following rules and a given 0-indexed array nextVisit of length n:
//
//    Assuming that on a day, you visit room i,
//    if you have been in room 'i; an odd number of times (including the current visit), on the next day you will visit a room with a lower or equal room number specified by nextVisit[i] where 0 <= nextVisit[i] <= i;
//    if you have been in room 'i' an even number of times (including the current visit), on the next day you will visit room (i + 1) mod n.
//    Return the label of the first day when you have been in all the rooms. It can be shown that such a day exists. Since the answer may be very large, return it modulo 10^9 + 7.
//    
//    Example 1:
//    Input: nextVisit = [0,0]
//    Output: 2
//    Explanation:
//    - On day 0, you visit room 0. The total times you have been in room 0 is 1, which is odd.
//     On the next day you will visit room nextVisit[0] = 0
//    - On day 1, you visit room 0, The total times you have been in room 0 is 2, which is even.
//     On the next day you will visit room (0 + 1) mod 2 = 1
//    - On day 2, you visit room 1. This is the first day when you have been in all the rooms.
//    
//    Example 2:
//    Input: nextVisit = [0,0,2]
//    Output: 6
//    Explanation:
//    Your room visiting order for each day is: [0,0,1,0,0,1,2,...].
//    Day 6 is the first day when you have been in all the rooms.
//    
//    Example 3:
//    Input: nextVisit = [0,1,2,0]
//    Output: 6
//    Explanation:
//    Your room visiting order for each day is: [0,0,1,1,2,2,3,...].
//    Day 6 is the first day when you have been in all the rooms.
//
//    Constraints:
//    n == nextVisit.length
//    2 <= n <= 10^5
//    0 <= nextVisit[i] <= i



//你需要访问n 个房间，房间从 0 到 n - 1 编号。同时，每一天都有一个日期编号，从 0 开始，依天数递增。你每天都会访问一个房间。
//
//    最开始的第 0 天，你访问0 号房间。给你一个长度为 n 且 下标从 0 开始 的数组 nextVisit 。在接下来的几天中，你访问房间的 次序 将根据下面的 规则 决定：
//
//    假设某一天，你访问i 号房间。
//    如果算上本次访问，访问i 号房间的次数为 奇数 ，那么 第二天 需要访问nextVisit[i] 所指定的房间，其中 0 <= nextVisit[i] <= i 。
//    如果算上本次访问，访问i 号房间的次数为 偶数 ，那么 第二天 需要访问(i + 1) mod n 号房间。
//    请返回你访问完所有房间的第一天的日期编号。题目数据保证总是存在这样的一天。由于答案可能很大，返回对 10^9 + 7 取余后的结果。
//
//    示例 1：
//    输入：nextVisit = [0,0]
//    输出：2
//    解释：
//    - 第 0 天，你访问房间 0 。访问 0 号房间的总次数为 1 ，次数为奇数。
//     下一天你需要访问房间的编号是 nextVisit[0] = 0
//    - 第 1 天，你访问房间 0 。访问 0 号房间的总次数为 2 ，次数为偶数。
//     下一天你需要访问房间的编号是 (0 + 1) mod 2 = 1
//    - 第 2 天，你访问房间 1 。这是你第一次完成访问所有房间的那天。
//
//    示例 2：
//    输入：nextVisit = [0,0,2]
//    输出：6
//    解释：
//    你每天访问房间的次序是 [0,0,1,0,0,1,2,...] 。
//    第 6 天是你访问完所有房间的第一天。
//
//    示例 3：
//    输入：nextVisit = [0,1,2,0]
//    输出：6
//    解释：
//    你每天访问房间的次序是 [0,0,1,1,2,2,3,...] 。
//    第 6 天是你访问完所有房间的第一天。
//
//    提示：
//    n == nextVisit.length
//    2 <= n <= 10^5
//    0 <= nextVisit[i] <= i



public class Q1997 {
    public static void main(String[] args) {
        int result = firstDayBeenInALlRooms(InputMethods.getInputForOneIntArray());
        System.out.println(result);
    }

    private static int firstDayBeenInALlRooms(int[] nextVisit) {
        int n = nextVisit.length;
        long[] dp = new long[n];
        long mod = (long) 1e9 + 7;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = (mod + 2 * dp[i - 1] - dp[nextVisit[i - 1]] + 2) % mod;
        }
        return (int)((dp[n - 1] - 1 + mod) % mod);
    }
}
