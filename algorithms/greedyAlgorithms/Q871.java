package algorithms.greedyAlgorithms;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;

//A car travels from a starting position to a destination which is target miles east of the starting position.
//
//    There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [position_i, fuel_i] indicates that the ith gas station is position_i miles east of the starting position and has fuel_i liters of gas.
//
//    The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
//
//    Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.
//
//    Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
//
//    Example 1:
//    Input: target = 1, startFuel = 1, stations = []
//    Output: 0
//    Explanation: We can reach the target without refueling.
//
//    Example 2:
//    Input: target = 100, startFuel = 1, stations = [[10,100]]
//    Output: -1
//    Explanation: We can not reach the target (or even the first gas station).
//
//    Example 3:
//    Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
//    Output: 2
//    Explanation: We start with 10 liters of fuel.
//    We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
//    Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
//    and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
//    We made 2 refueling stops along the way, so we return 2.
//
//    Constraints:
//    1 <= target, startFuel <= 109
//    0 <= stations.length <= 500
//    0 <= position_i <= position_i + 1 < target
//    1 <= fuel_i < 109


//汽车从起点出发驶向目的地，该目的地位于出发位置东面 target英里处。
//
//    沿途有加油站，每个station[i]代表一个加油站，它位于出发位置东面station[i][0]英里处，并且有station[i][1]升汽油。
//
//    假设汽车油箱的容量是无限的，其中最初有startFuel升燃料。它每行驶 1 英里就会用掉 1 升汽油。
//
//    当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
//
//    为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
//
//    注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
//
//    示例 1：
//    输入：target = 1, startFuel = 1, stations = []
//    输出：0
//    解释：我们可以在不加油的情况下到达目的地。
//
//    示例 2：
//    输入：target = 100, startFuel = 1, stations = [[10,100]]
//    输出：-1
//    解释：我们无法抵达目的地，甚至无法到达第一个加油站。
//
//    示例 3：
//    输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
//    输出：2
//    解释：
//    我们出发时有 10 升燃料。
//    我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
//    然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
//    并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
//    我们沿途在1两个加油站停靠，所以返回 2 。
//
//    提示：
//    1 <= target, startFuel, stations[i][1] <= 10^9
//    0 <= stations.length <= 500
//    0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target


public class Q871 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int target = Integer.parseInt(cin.nextLine().strip());
        int startFuel = Integer.parseInt(cin.nextLine().strip());
        List<int[]> stationsList = new ArrayList<>();
        InputMethods.getInputForIntArrayList(cin, stationsList);
        int result = minRefuelStops(target, startFuel, DataConversionMethods.convertArrayListTo2DArray(stationsList));
        System.out.println(result);
    }

    // Method 1: Dynamic programming
//    private static int minRefuelStops(int target, int startFuel, int[][] stations) {
//        int n = stations.length;
//        long[] dp = new long[n + 1];
//        dp[0] = startFuel;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j >= 0; j--) {
//                if (dp[j] >= stations[i][0]) {
//                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
//                }
//            }
//        }
//        for (int i = 0; i <= n; i++) {
//            if (dp[i] >= target) {
//                return i;
//            }
//        }
//        return -1;
//    }

    // Method 2: Greedy algorithm + Priority Queue
    private static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0, prev = 0, fuel = startFuel;
        int n = stations.length;
        for (int i = 0; i <= n; i++) {
            int curr = i < n ? stations[i][0] : target;
            fuel -= curr - prev;
            while (fuel < 0 && !pq.isEmpty()) {
                fuel += pq.poll();
                ans++;
            }
            if (fuel < 0) {
                return -1;
            }
            if (i < n) {
                pq.offer(stations[i][1]);
                prev = curr;
            }
        }
        return ans;
    }
}
