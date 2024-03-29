package algorithms.dynamicProgramming;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//
//    You have the following three operations permitted on a word:
//
//    Insert a character
//    Delete a character
//    Replace a character
//
//    Example 1:
//    Input: word1 = "horse", word2 = "ros"
//    Output: 3
//    Explanation:
//    horse -> rorse (replace 'h' with 'r')
//    rorse -> rose (remove 'r')
//    rose -> ros (remove 'e')
//    
//    Example 2:
//    Input: word1 = "intention", word2 = "execution"
//    Output: 5
//    Explanation:
//    intention -> inention (remove 't')
//    inention -> enention (replace 'i' with 'e')
//    enention -> exention (replace 'n' with 'x')
//    exention -> exection (replace 'n' with 'c')
//    exection -> execution (insert 'u')
//
//    Constraints:
//    0 <= word1.length, word2.length <= 500
//    word1 and word2 consist of lowercase English letters.


//给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
//
//    你可以对一个单词进行如下三种操作：
//    插入一个字符
//    删除一个字符
//    替换一个字符
//
//    示例1：
//    输入：word1 = "horse", word2 = "ros"
//    输出：3
//    解释：
//    horse -> rorse (将 'h' 替换为 'r')
//    rorse -> rose (删除 'r')
//    rose -> ros (删除 'e')
//
//    示例2：
//    输入：word1 = "intention", word2 = "execution"
//    输出：5
//    解释：
//    intention -> inention (删除 't')
//    inention -> enention (将 'i' 替换为 'e')
//    enention -> exention (将 'n' 替换为 'x')
//    exention -> exection (将 'n' 替换为 'c')
//    exection -> execution (插入 'u')
//
//    提示：
//    0 <= word1.length, word2.length <= 500
//    word1 和 word2 由小写英文字母组成


public class Q72 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String word1 = cin.nextLine().strip();
        String word2 = cin.nextLine().strip();
        cin.close();

        int result = minDistance(word1, word2);
        System.out.println(result);
    }

    private static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0) {
            return n + m;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, leftDown));
            }
        }
        return dp[n][m];
    }
}
