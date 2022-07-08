package algorithms.greedyAlgorithms;
import java.util.*;
import java.nio.charset.StandardCharsets;


//We have n chips, where the position of the ith chip is position[i].
//
//    We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
//
//    position[i] + 2 or position[i] - 2 with cost = 0.
//    position[i] + 1 or position[i] - 1 with cost = 1.
//    Return the minimum cost needed to move all the chips to the same position.
//    
//    Example 1:
//                                                |
//                          |                     |
//       |    |    |   ->   |    |         ->     |
//       1    2    3        1    2    3           1     2     3
//                             Cost = 0              Cost = 1
//    Input: position = [1,2,3]
//    Output: 1
//    Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
//    Second step: Move the chip at position 2 to position 1 with cost = 1.
//    Total cost is 1.
//    
//    Example 2:
//                                                           |
//                                     |                     |
//              |                      |                     |
//              |    |                 |                     |
//              |    |     ->          |    |     ->         |
//         1    2    3            1    2    3           1    2    3
//                                   Cost = 1              Cost = 2
//    Input: position = [2,2,2,3,3]
//    Output: 2
//    Explanation: We can move the two chips at position  3 to position 2. Each move has cost = 1. The total cost = 2.
//    
//    Example 3:
//    Input: position = [1,1000000000]
//    Output: 1
//    
//    Constraints:
//    1 <= position.length <= 100
//    1 <= position[i] <= 10^9


//有n个筹码。第 i 个筹码的位置是position[i]。
//
//    我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从position[i]改变为:
//
//    position[i] + 2或position[i] - 2，此时cost = 0
//    position[i] + 1或position[i] - 1，此时cost = 1
//    返回将所有筹码移动到同一位置上所需要的 最小代价 。
//
//    示例 1：
//                                                |
//                          |                     |
//       |    |    |   ->   |    |         ->     |
//       1    2    3        1    2    3           1     2     3
//                             Cost = 0              Cost = 1
//    输入：position = [1,2,3]
//    输出：1
//    解释：第一步:将位置3的筹码移动到位置1，成本为0。
//    第二步:将位置2的筹码移动到位置1，成本= 1。
//    总成本是1。
//
//    示例 2：
//                                                           |
//                                     |                     |
//              |                      |                     |
//              |    |                 |                     |
//              |    |     ->          |    |     ->         |
//         1    2    3            1    2    3           1    2    3
//                                   Cost = 1              Cost = 2
//    输入：position = [2,2,2,3,3]
//    输出：2
//    解释：我们可以把位置3的两个筹码移到位置2。每一步的成本为1。总成本= 2。
//
//    示例 3:
//    输入：position = [1,1000000000]
//    输出：1
//
//    提示：
//    1 <= chips.length <= 100
//    1 <= chips[i] <= 10^9



public class Q1217 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] position = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        int result = minCostToMoveChips(position);
        System.out.println(result);
    }

    private static int minCostToMoveChips(int[] position) {
        int oddIndexes = 0;
        int evenIndexes = 0;
        for (int j : position) {
            if (j % 2 == 0) {
                evenIndexes++;
            } else {
                oddIndexes++;
            }
        }
        return Math.min(oddIndexes, evenIndexes);
    }
}
