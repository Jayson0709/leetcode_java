package algorithms.dynamicProgramming;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//There are two types of soup: type A and type B. Initially, we have n ml of each type of soup. There are four kinds of operations:
//
//    Serve 100 ml of soup A and 0 ml of soup B,
//    Serve 75 ml of soup A and 25 ml of soup B,
//    Serve 50 ml of soup A and 50 ml of soup B, and
//    Serve 25 ml of soup A and 75 ml of soup B.
//    When we serve some soup, we give it to someone, and we no longer have it. Each turn, we will choose from the four operations with an equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we will serve as much as possible. We stop once we no longer have some quantity of both types of soup.
//
//    Note that we do not have an operation where all 100 ml's of soup B are used first.
//
//    Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time. Answers within 10-5 of the actual answer will be accepted.
//
//    Example 1:
//    Input: n = 50
//    Output: 0.62500
//    Explanation: If we choose the first two operations, A will become empty first.
//    For the third operation, A and B will become empty at the same time.
//    For the fourth operation, B will become empty first.
//    So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
//
//    Example 2:
//    Input: n = 100
//    Output: 0.71875
//
//    Constraints:
//    0 <= n <= 10^9


//有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
//
//    提供 100ml 的 汤A 和 0ml 的 汤B 。
//    提供 75ml 的 汤A 和 25ml 的 汤B 。
//    提供 50ml 的 汤A 和 50ml 的 汤B 。
//    提供 25ml 的 汤A 和 75ml 的 汤B 。
//    当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为 0.25 的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
//
//    注意 不存在先分配 100 ml 汤B 的操作。
//
//    需要返回的值： 汤A 先分配完的概率 +  汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10-5 的范围内将被认为是正确的。
//
//    示例 1:
//    输入: n = 50
//    输出: 0.62500
//    解释:如果我们选择前两个操作，A 首先将变为空。
//    对于第三个操作，A 和 B 会同时变为空。
//    对于第四个操作，B 首先将变为空。
//    所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
//
//    示例 2:
//    输入: n = 100
//    输出: 0.71875
//
//
//    提示:
//    0 <= n <= 10^9


public class Q808 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(soupServings(n));
    }

    private static double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1.0;
        }
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) / 4.0;
            }
        }
        return dp[n][n];
    }
}
