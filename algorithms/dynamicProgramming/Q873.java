package algorithms.dynamicProgramming;
import java.util.*;
import java.nio.charset.StandardCharsets;

//A sequence x1, x2, ..., xn is Fibonacci-like if:
//
//    n >= 3
//    xi + xi+1 == xi+2 for all i + 2 <= n
//    Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.
//
//    A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].
//
//    Example 1:
//    Input: arr = [1,2,3,4,5,6,7,8]
//    Output: 5
//    Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].
//
//    Example 2:
//    Input: arr = [1,3,7,11,12,14,18]
//    Output: 3
//    Explanation: The longest subsequence that is fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].
//
//    Constraints:
//    3 <= arr.length <= 1000
//    1 <= arr[i] < arr[i + 1] <= 10^9


//如果序列X_1, X_2, ..., X_n满足下列条件，就说它是斐波那契式的：
//
//    n >= 3
//    对于所有i + 2 <= n，都有X_i + X_{i+1} = X_{i+2}
//    给定一个严格递增的正整数数组形成序列 arr，找到 arr中最长的斐波那契式的子序列的长度。如果一个不存在，返回0 。
//
//    （回想一下，子序列是从原序列 arr中派生出来的，它从 arr中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如，[3, 5, 8]是[3, 4, 5, 6, 7, 8]的一个子序列）
//
//    示例 1：
//    输入: arr = [1,2,3,4,5,6,7,8]
//    输出: 5
//    解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
//
//    示例2：
//    输入: arr = [1,3,7,11,12,14,18]
//    输出: 3
//    解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
//
//    提示：
//    3 <= arr.length <= 1000
//    1 <= arr[i] < arr[i + 1] <= 10^9


public class Q873 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] arr = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        int result = lenLongestFibSubsequence(arr);
        System.out.println(result);
    }

    private static int lenLongestFibSubsequence(int[] arr) {
        Map<Integer, Integer> indices = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            indices.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = indices.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                result = Math.max(result, dp[j][i]);
            }
        }
        return result;
    }
}
