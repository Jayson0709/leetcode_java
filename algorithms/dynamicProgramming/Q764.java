package algorithms.dynamicProgramming;
import utils.DataConversionMethods;
import utils.InputMethods;

import java.util.*;
import java.nio.charset.StandardCharsets;

//You are given an integer n. You have an n x n binary grid (grid) with all values initially 1's except for some indices given in the array mines. The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.
//
//    Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.
//
//    An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going up, down, left, and right, and made of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1's.
//
//    Example 1:
//    Input: n = 5, mines = [[4,2]]
//    Output: 2
//    Explanation: In the above grid, the largest plus sign can only be of order 2. One of them is shown.
//
//    Example 2:
//    Input: n = 1, mines = [[0,0]]
//    Output: 0
//    Explanation: There is no plus sign, so return 0.
//
//    Constraints:
//    1 <= n <= 500
//    1 <= mines.length <= 5000
//    0 <= xi, yi < n
//    All the pairs (xi, yi) are unique.


//在一个 n x n 的矩阵grid中，除了在数组mines中给出的元素为0，其他每个元素都为1。mines[i] = [xi, yi]表示grid[xi][yi] == 0
//
//    返回 grid 中包含1的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
//
//    一个k阶由1组成的 “轴对称”加号标志 具有中心网格grid[r][c] == 1，以及4个从中心向上、向下、向左、向右延伸，长度为k-1，由1组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
//
//    示例 1：
//    输入: n = 5, mines = [[4, 2]]
//    输出: 2
//    解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
//
//    示例 2：
//    输入: n = 1, mines = [[0, 0]]
//    输出: 0
//    解释: 没有加号标志，返回 0 。
//
//    提示：
//    1 <= n <= 500
//    1 <= mines.length <= 5000
//    0 <= xi, yi< n
//    每一对(xi, yi)都 不重复


public class Q764 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = Integer.parseInt(cin.nextLine().strip());
        List<int[]> pairList = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, pairList);
        cin.close();
        int result = orderOfLargestPlusSign(n, DataConversionMethods.convertIntArrArrayListTo2DArray(pairList));
        System.out.println(result);
    }

    private static int orderOfLargestPlusSign(int n, int[][] mines) {
        // if grid[i][j] == 1,
        //      left: dp[i][j][0] = dp[i][j-1][0] + 1
        //      up: dp[i][j][1] = dp[i-1][j][1] + 1
        //      right: dp[i][j][2] = dp[i][j+1][2] + 1
        //      down: dp[i][j][3] = dp[i+1][j][3] + 1
        // if grid[i][j] == 0, dp[i][j][l] = 0, l = 0, 1, 2, 3.
        int[][][] dp = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = 1;
                }
            }
        }
        for (int[] pair : mines) {
            for (int k = 0; k < 4; k++) {
                dp[pair[0]][pair[1]][k] = 0;
            }
        }
        // Search for the left and up parts.
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j][0] == 0) {
                    continue;
                }
                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
            }
        }
        // Search for the right and down parts.
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (dp[i][j][2] == 0) {
                    continue;
                }
                dp[i][j][2] = dp[i][j + 1][2] + 1;
                dp[i][j][3] = dp[i + 1][j][3] + 1;
            }
        }
        int maxOrder = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = Math.min(Math.min(dp[i][j][0], dp[i][j][1]), Math.min(dp[i][j][2], dp[i][j][3]));
                maxOrder = Math.max(maxOrder, k);
            }
        }
        return maxOrder;
    }
}
