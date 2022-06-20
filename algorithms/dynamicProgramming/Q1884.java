package algorithms.dynamicProgramming;
import java.util.*;
import java.nio.charset.StandardCharsets;

//You are given two identical eggs, and you have access to a building with n floors labeled from 1 to n.
//
//    You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break.
//
//    In each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.
//
//    Return the minimum number of moves that you need to determine with certainty what the value of f is.
//
//    Example 1:
//    Input: n = 2
//    Output: 2
//    Explanation: We can drop the first egg from floor 1 and the second egg from floor 2.
//    If the first egg breaks, we know that f = 0.
//    If the second egg breaks but the first egg didn't, we know that f = 1.
//    Otherwise, if both eggs survive, we know that f = 2.
//    
//    Example 2:
//    Input: n = 100
//    Output: 14
//    Explanation: One optimal strategy is:
//    - Drop the 1st egg at floor 9. If it breaks, we know f is between 0 and 8. Drop the 2nd egg starting from floor 1 and going up one at a time to find f within 8 more drops. Total drops is 1 + 8 = 9.
//    - If the 1st egg does not break, drop the 1st egg again at floor 22. If it breaks, we know f is between 9 and 21. Drop the 2nd egg starting from floor 10 and going up one at a time to find f within 12 more drops. Total drops is 2 + 12 = 14.
//    - If the 1st egg does not break again, follow a similar process dropping the 1st egg from floors 34, 45, 55, 64, 72, 79, 85, 90, 94, 97, 99, and 100.
//    Regardless of the outcome, it takes at most 14 drops to determine f.
//
//    Constraints:
//    1 <= n <= 1000


//给你 2枚相同 的鸡蛋，和一栋从第 1层到第 n 层共有 n 层楼的建筑。
//
//    已知存在楼层 f ，满足0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
//
//    每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
//
//    请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
//
//    示例 1：
//    输入：n = 2
//    输出：2
//    解释：我们可以将第一枚鸡蛋从 1 楼扔下，然后将第二枚从 2 楼扔下。
//    如果第一枚鸡蛋碎了，可知 f = 0；
//    如果第二枚鸡蛋碎了，但第一枚没碎，可知 f = 1；
//    否则，当两个鸡蛋都没碎时，可知 f = 2。
//
//    示例 2：
//    输入：n = 100
//    输出：14
//    解释：
//    一种最优的策略是：
//    - 将第一枚鸡蛋从 9 楼扔下。如果碎了，那么 f 在 0 和 8 之间。将第二枚从 1 楼扔下，然后每扔一次上一层楼，在 8 次内找到 f 。总操作次数 = 1 + 8 = 9 。
//    - 如果第一枚鸡蛋没有碎，那么再把第一枚鸡蛋从 22 层扔下。如果碎了，那么 f 在 9 和 21 之间。将第二枚鸡蛋从 10 楼扔下，然后每扔一次上一层楼，在 12 次内找到 f 。总操作次数 = 2 + 12 = 14 。
//    - 如果第一枚鸡蛋没有再次碎掉，则按照类似的方法从 34, 45, 55, 64, 72, 79, 85, 90, 94, 97, 99 和 100 楼分别扔下第一枚鸡蛋。
//    不管结果如何，最多需要扔 14 次来确定 f 。
//
//    提示：
//    1 <= n <= 1000


public class Q1884 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int n = cin.nextInt();
        cin.close();

        int result = twoEggDrop(n);
        System.out.println(result);
    }

    //Method 1: Dynamic Programming
    private static int twoEggDrop(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                int min = Math.max(j - 1, dp[i - j]);
                dp[i] = Math.min(min + 1, dp[i]);
            }
        }
        return dp[n];
    }

    // Method 2: Math -
//    private static int twoEggDrop(int n) {
//        int sum = 0;
//        int index = 0;
//        for(int i = 1; sum < n ;i++){
//            sum += i;
//            index = i;
//        }
//        return index;
//    }

    // Method 3: Math - induction
//    private static int twoEggDrop(int n) {
//        return (int) Math.ceil(Math.sqrt(n * 2 - 0.25) - 0.5);
//    }
}
