package algorithms.greedyAlgorithms;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//You are given an array of n pairs 'pairs' where pairs[i] = [left_i, right_i] and left_i < right_i.
//
//    A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
//
//    Return the longest chain which can be formed.
//
//    You do not need to use up all the given intervals. You can select pairs in any order.
//    
//    Example 1:
//    Input: pairs = [[1,2],[2,3],[3,4]]
//    Output: 2
//    Explanation: The longest chain is [1,2] -> [3,4].
//    
//    Example 2:
//    Input: pairs = [[1,2],[7,8],[4,5]]
//    Output: 3
//    Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
//    
//    Constraints:
//    n == pairs.length
//    1 <= n <= 1000
//    -1000 <= left_i < right_i <= 1000



//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
//
//    现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
//
//    给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
//
//    示例：
//    输入：[[1,2], [2,3], [3,4]]
//    输出：2
//    解释：最长的数对链是 [1,2] -> [3,4]
//
//    提示：
//    给出数对的个数在 [1, 1000] 范围内。



public class Q646 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        System.out.println(findLongestChain(DataConversionMethods.convertIntArrArrayListTo2DArray(data)));
    }

    // Method 1: greedy algorithm
    private static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int res = 0;
        int prev = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > prev) {
                res++;
                prev = pair[1];
            }
        }
        return res;
    }

    // Method 2: dynamic programming
//    private static int findLongestChain(int[][] pairs) {
//        int n = pairs.length;
//        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (pairs[i][0] > pairs[j][1]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        return dp[n - 1];
//    }
}
