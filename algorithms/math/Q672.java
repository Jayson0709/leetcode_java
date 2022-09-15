package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//There is a room with n bulbs labeled from 1 to n that all are turned on initially, and four buttons on the wall. Each of the four buttons has a different functionality where:
//
//    Button 1: Flips the status of all the bulbs.
//    Button 2: Flips the status of all the bulbs with even labels (i.e., 2, 4, ...).
//    Button 3: Flips the status of all the bulbs with odd labels (i.e., 1, 3, ...).
//    Button 4: Flips the status of all the bulbs with a label j = 3k + 1 where k = 0, 1, 2, ... (i.e., 1, 4, 7, 10, ...).
//
//    You must make exactly presses button presses in total. For each press, you may pick any of the four buttons to press.
//
//    Given the two integers n and presses, return the number of different possible statuses after performing all presses button presses.
//
//    Example 1:
//    Input: n = 1, presses = 1
//    Output: 2
//    Explanation: Status can be:
//    - [off] by pressing button 1
//    - [on] by pressing button 2
//
//    Example 2:
//    Input: n = 2, presses = 1
//    Output: 3
//    Explanation: Status can be:
//    - [off, off] by pressing button 1
//    - [on, off] by pressing button 2
//    - [off, on] by pressing button 3
//
//    Example 3:
//    Input: n = 3, presses = 1
//    Output: 4
//    Explanation: Status can be:
//    - [off, off, off] by pressing button 1
//    - [off, on, off] by pressing button 2
//    - [on, off, on] by pressing button 3
//    - [off, on, on] by pressing button 4
//
//    Constraints:
//    1 <= n <= 1000
//    0 <= presses <= 1000



//房间中有 n 只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。
//
//    这 4 个开关各自都具有不同的功能，其中：
//
//    开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
//    开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...）
//    开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
//    开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
//
//    你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。
//
//    给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
//
//    示例 1：
//    输入：n = 1, presses = 1
//    输出：2
//    解释：状态可以是：
//    - 按压开关 1 ，[关]
//    - 按压开关 2 ，[开]
//
//    示例 2：
//    输入：n = 2, presses = 1
//    输出：3
//    解释：状态可以是：
//    - 按压开关 1 ，[关, 关]
//    - 按压开关 2 ，[开, 关]
//    - 按压开关 3 ，[关, 开]
//
//    示例 3：
//    输入：n = 3, presses = 1
//    输出：4
//    解释：状态可以是：
//    - 按压开关 1 ，[关, 关, 关]
//    - 按压开关 2 ，[关, 开, 关]
//    - 按压开关 3 ，[开, 关, 开]
//    - 按压开关 4 ，[关, 开, 开]
//
//    提示：
//    1 <= n <= 1000
//    0 <= presses <= 1000



public class Q672 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        int presses = cin.nextInt();
        cin.close();
        System.out.println(flipLights(n, presses));
    }

    private static int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        else if (n == 2) {
            return presses == 1 ? 3 : 4;
        }
        else {
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }
}
