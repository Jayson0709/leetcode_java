package algorithms.dynamicProgramming;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given n points on a 1-D plane, where the ith point (from 0 to n-1) is at x = i, find the number of ways we can draw exactly k non-overlapping line segments such that each segment covers two or more points. The endpoints of each segment must have integral coordinates. The k line segments do not have to cover all n points, and they are allowed to share endpoints.
//
//    Return the number of ways we can draw k non-overlapping line segments. Since this number can be huge, return it modulo 109 + 7.
//
//    Example 1:
//    Input: n = 4, k = 2
//    Output: 5
//    Explanation: The two line segments are shown in red and blue.
//    The image above shows the 5 different ways {(0,2),(2,3)}, {(0,1),(1,3)}, {(0,1),(2,3)}, {(1,2),(2,3)}, {(0,1),(1,2)}.
//
//    Example 2:
//    Input: n = 3, k = 1
//    Output: 3
//    Explanation: The 3 ways are {(0,1)}, {(0,2)}, {(1,2)}.
//
//    Example 3:
//    Input: n = 30, k = 7
//    Output: 796297179
//    Explanation: The total number of possible ways to draw 7 line segments is 3796297200. Taking this number modulo 109 + 7 gives us 796297179.
//
//    Constraints:
//    2 <= n <= 1000
//    1 <= k <= n-1



//给你一维空间的n个点，其中第i个点（编号从0 到n-1）位于x = i处，请你找到恰好k个不重叠线段且每个线段至少覆盖两个点的方案数。线段的两个端点必须都是整数坐标。这k个线段不需要全部覆盖全部n个点，且它们的端点可以重合。
//
//    请你返回 k个不重叠线段的方案数。由于答案可能很大，请将结果对109 + 7取余 后返回。
//
//    示例 1：
//    输入：n = 4, k = 2
//    输出：5
//    解释：
//    如图所示，两个线段分别用红色和蓝色标出。
//    上图展示了 5 种不同的方案 {(0,2),(2,3)}，{(0,1),(1,3)}，{(0,1),(2,3)}，{(1,2),(2,3)}，{(0,1),(1,2)} 。
//
//    示例 2：
//    输入：n = 3, k = 1
//    输出：3
//    解释：总共有 3 种不同的方案 {(0,1)}, {(0,2)}, {(1,2)} 。
//
//    示例 3：
//    输入：n = 30, k = 7
//    输出：796297179
//    解释：画 7 条线段的总方案数为 3796297200 种。将这个数对 109 + 7 取余得到 796297179 。
//
//    示例 4：
//    输入：n = 5, k = 3
//    输出：7
//
//    示例 5：
//    输入：n = 3, k = 2
//    输出：1
//
//    提示：
//    2 <= n <= 1000
//    1 <= k <= n-1



public class Q1621 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        int k = cin.nextInt();
        cin.close();
        System.out.println(numberOfSets(n, k));
    }

    private static int numberOfSets(int n, int k) {
        int[] dp = new int[n];
        int[] sums = new int[n];
        int p = 1000000007;
        dp[0] = sums[0] = 1;
        for (int i = 0; i <= k; i++) { // i segments
            for (int j = 0; j < n; j++) {
                if (j < i) dp[j] = 0;
                else if (j == i || i == 0) dp[j] = 1;
                else dp[j] = (sums[j - 1] + dp[j - 1]) % p;
            }
            sums[0] = dp[0];
            for (int j = 1; j < n; j++) {
                sums[j] = (dp[j] + sums[j - 1]) % p;
            }
        }
        return dp[n - 1];
    }
}
