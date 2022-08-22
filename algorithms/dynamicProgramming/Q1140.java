package algorithms.dynamicProgramming;

import utils.InputMethods;

//Alice and Bob continue their games with piles of stones. There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i]. The objective of the game is to end with the most stones.
//    Alice and Bob take turns, with Alice starting first. Initially, M = 1.
//
//    On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M. Then, we setM = max(M, X).
//
//    The game continues until all the stones have been taken.
//
//    Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
//
//    Example 1:
//    Input: piles = [2,7,9,4,4]
//    Output: 10
//    Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larger.
//
//    Example 2:
//    Input: piles = [1,2,3,4,5,100]
//    Output: 104
//
//    Constraints:
//    1 <= piles.length <= 100
//    1 <= piles[i]<= 104


//爱丽丝和鲍勃继续他们的石子游戏。许多堆石子排成一行，每堆都有正整数颗石子piles[i]。游戏以谁手中的石子最多来决出胜负。
//
//    爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。
//
//    在每个玩家的回合中，该玩家可以拿走剩下的前X堆的所有石子，其中1 <= X <= 2M。然后，令M = max(M, X)。
//
//    游戏一直持续到所有石子都被拿走。
//
//    假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。
//
//    示例 1：
//    输入：piles = [2,7,9,4,4]
//    输出：10
//    解释：如果一开始Alice取了一堆，Bob取了两堆，然后Alice再取两堆。爱丽丝可以得到2 + 4 + 4 = 10堆。如果Alice一开始拿走了两堆，那么Bob可以拿走剩下的三堆。在这种情况下，Alice得到2 + 7 = 9堆。返回10，因为它更大。
//
//    示例 2:
//    输入：piles = [1,2,3,4,5,100]
//    输出：104
//
//    提示：
//    1 <= piles.length <= 100
//    1 <= piles[i]<= 104


public class Q1140 {
    public static void main(String[] args) {
        int result = stoneGameII(InputMethods.getInputForOneIntArray());
        System.out.println(result);
    }

    private static int stoneGameII(int[] piles) {
        // iterate backwards
        int arrLen = piles.length;
        int sum = 0;
        int[][] dp = new int[arrLen][arrLen + 1];
        for (int i = arrLen - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= arrLen; M++) {
                if (i + 2 * M >= arrLen) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
