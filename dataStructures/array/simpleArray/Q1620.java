package dataStructures.array.simpleArray;
import java.util.*;
import java.nio.charset.StandardCharsets;

//You are given an array of network towers, where towers[i] = [xi, yi, qi] denotes the ith network tower with location (xi, yi) and quality factor qi. All the coordinates are integral coordinates on the X-Y plane, and the distance between the two coordinates is the Euclidean distance.
//
//    You are also given an integer radius where a tower is reachable if the distance is less than or equal to radius. Outside that distance, the signal becomes garbled, and the tower is not reachable.
//
//    The signal quality of the ith tower at a coordinate (x, y) is calculated with the formula ⌊qi / (1 + d)⌋, where d is the distance between the tower and the coordinate. The network quality at a coordinate is the sum of the signal qualities from all the reachable towers.
//
//    Return the array [cx, cy] representing the integral coordinate (cx, cy) where the network quality is maximum. If there are multiple coordinates with the same network quality, return the lexicographically minimum non-negative coordinate.
//
//    Note:
//    A coordinate (x1, y1) is lexicographically smaller than (x2, y2) if either:
//        x1 < x2, or
//        x1 == x2 and y1 < y2.
//    ⌊val⌋ is the greatest integer less than or equal to val (the floor function).
//    
//
//    Example 1:
//    Input: towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
//    Output: [2,1]
//    Explanation: At coordinate (2, 1) the total quality is 13.
//    - Quality of 7 from (2, 1) results in ⌊7 / (1 + sqrt(0)⌋ = ⌊7⌋ = 7
//    - Quality of 5 from (1, 2) results in ⌊5 / (1 + sqrt(2)⌋ = ⌊2.07⌋ = 2
//    - Quality of 9 from (3, 1) results in ⌊9 / (1 + sqrt(1)⌋ = ⌊4.5⌋ = 4
//    No other coordinate has a higher network quality.
//
//    Example 2:
//    Input: towers = [[23,11,21]], radius = 9
//    Output: [23,11]
//    Explanation: Since there is only one tower, the network quality is highest right at the tower's location.
//
//    Example 3:
//    Input: towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2
//    Output: [1,2]
//    Explanation: Coordinate (1, 2) has the highest network quality.
//    
//
//    Constraints:
//    1 <= towers.length <= 50
//    towers[i].length == 3
//    0 <= xi, yi, qi <= 50
//    1 <= radius <= 50


//给你一个数组 towers和一个整数 radius，数组中包含一些网络信号塔，其中towers[i] = [xi, yi, qi]表示第i个网络信号塔的坐标是(xi, yi)且信号强度参数为qi。所有坐标都是在 X-Y 坐标系内的整数坐标。两个坐标之间的距离用 欧几里得距离计算。
//
//    整数radius表示一个塔 能到达的 最远距离。如果一个坐标跟塔的距离在 radius以内，那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱，所以 radius以外的距离该塔是 不能到达的。
//
//    如果第 i个塔能到达 (x, y)，那么该塔在此处的信号为⌊qi / (1 + d)⌋，其中d是塔跟此坐标的距离。一个坐标的 网络信号是所有 能到达该坐标的塔的信号强度之和。
//
//    请你返回 网络信号最大的整数坐标点。如果有多个坐标网络信号一样大，请你返回字典序最小的一个坐标。
//
//    注意：
//    坐标(x1, y1)字典序比另一个坐标(x2, y2)小：要么x1 < x2，要么x1 == x2 且y1 < y2。
//    ⌊val⌋表示小于等于val的最大整数（向下取整函数）。
//
//    示例 1：
//    输入：towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
//    输出：[2,1]
//    解释：
//    坐标 (2, 1) 信号强度之和为 13
//    - 塔 (2, 1) 强度参数为 7 ，在该点强度为 ⌊7 / (1 + sqrt(0)⌋ = ⌊7⌋ = 7
//    - 塔 (1, 2) 强度参数为 5 ，在该点强度为 ⌊5 / (1 + sqrt(2)⌋ = ⌊2.07⌋ = 2
//    - 塔 (3, 1) 强度参数为 9 ，在该点强度为 ⌊9 / (1 + sqrt(1)⌋ = ⌊4.5⌋ = 4
//    没有别的坐标有更大的信号强度。
//
//    示例 2：
//    输入：towers = [[23,11,21]], radius = 9
//    输出：[23,11]
//
//    示例 3：
//    输入：towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2
//    输出：[1,2]
//
//    示例 4：
//    输入：towers = [[2,1,9],[0,1,9]], radius = 2
//    输出：[0,1]
//    解释：坐标 (0, 1) 和坐标 (2, 1) 都是强度最大的位置，但是 (0, 1) 字典序更小。
//    
//
//    提示：
//    1 <= towers.length <= 50
//    towers[i].length == 3
//    0 <= xi, yi, qi <= 50
//    1 <= radius <= 50


public class Q1620 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> inputData = new ArrayList<>();
        while (true) {
            String curLine = cin.nextLine().strip();
            if (curLine.length() == 0) {
                break;
            } else {
                inputData.add(Arrays.stream(curLine.split(" ")).mapToInt(Integer::parseInt).toArray());
            }
        }
        int radius = 0;
        int size = inputData.size();
        int[][] towers = new int[size - 1][3];
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                radius = inputData.get(i)[0];
                break;
            }
            towers[i] = inputData.get(i);
        }
        cin.close();

        int[] result = bestCoordinate(towers, radius);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    private static int[] bestCoordinate(int[][] towers, int radius) {
        // This can be transferred into a geometry question.
        // The range for the answer is the biggest rectangle area enclosed by all towers.
        // Because the total signal value of any coordinate that is outside the area is going to
        // be less or equal to the coordinate that locates to the edges of the rectangle area.
        int[] result = new int[2];
        int maxRadius = 0;
        int top = towers[0][1];
        int bottom = towers[0][1];
        int left = towers[0][0];
        int right = towers[0][0];
        for (int[] tower : towers) {
            top = Math.max(top, tower[1]);
            bottom = Math.min(bottom, tower[1]);
            left = Math.min(left, tower[0]);
            right = Math.max(right, tower[0]);
        }

        for (int x = left; x <= right; x++) {
            for (int y = bottom; y <= top; y++) {
                int totalSignalVal = 0;
                for (int[] tower : towers) {
                    double d = calculateEuclideanDistance(x, y, tower[0], tower[1]);
                    if (Double.compare(d, radius) <= 0) {
                        totalSignalVal += Math.floor(tower[2] / (1 + d));
                    }
                }
                if (totalSignalVal > maxRadius) {
                    maxRadius = totalSignalVal;
                    result[0] = x;
                    result[1] = y;
                }
            }
        }
        return result;
    }

    private static double calculateEuclideanDistance(int x1, int y1, int x2, int y2) {
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);
        return Math.sqrt(x * x + y * y);
    }
}
