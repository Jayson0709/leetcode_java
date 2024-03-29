package algorithms.dynamicProgramming;
import java.util.*;
import java.nio.charset.StandardCharsets;


//n passengers board an airplane with exactly n seats. The first passenger has lost the ticket and picks a seat randomly. But after that, the rest of the passengers will:
//
//    Take their own seat if it is still available, and
//    Pick other seats randomly when they find their seat occupied
//    Return the probability that the nth person gets his own seat.
//
//    Example 1:
//    Input: n = 1
//    Output: 1.00000
//    Explanation: The first person can only get the first seat.
//
//    Example 2:
//    Input: n = 2
//    Output: 0.50000
//    Explanation: The second person has a probability of 0.5 to get the second seat (when first person gets the first seat).
//
//    Constraints:
//    1 <= n <= 10^5



//有 n 位乘客即将登机，飞机正好有 n 个座位。第一位乘客的票丢了，他随便选了一个座位坐下。
//
//    剩下的乘客将会：
//
//    如果他们自己的座位还空着，就坐到自己的座位上，
//
//    当他们自己的座位被占用时，随机选择其他座位
//    第 n位乘客坐在自己的座位上的概率是多少？
//
//    示例 1：
//    输入：n = 1
//    输出：1.00000
//    解释：第一个人只会坐在自己的位置上。
//
//    示例 2：
//    输入: n = 2
//    输出: 0.50000
//    解释：在第一个人选好座位坐下后，第二个人坐在自己的座位上的概率是 0.5。
//
//    提示：
//    1 <= n <= 10^5



public class Q1227 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        double result = nthPersonGetNthSeat(n);
        System.out.println(result);
    }

    private static double nthPersonGetNthSeat(int n) {
        if (n <= 2) {
            return 1.0 / n;
        }
        double prob = 0.5;
        for (int i = 3; i <= n; i++) {
            prob = (1.0 + (i - 2) * prob) / i;
        }
        return prob;
    }
}
