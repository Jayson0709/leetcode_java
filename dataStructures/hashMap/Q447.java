package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between 'i' and 'j' equals the distance between 'i' and 'k' (the order of the tuple matters).
//
//    Return the number of boomerangs.
//    
//    Example 1:
//    Input: points = [[0,0],[1,0],[2,0]]
//    Output: 2
//    Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
//    
//    Example 2:
//    Input: points = [[1,1],[2,2],[3,3]]
//    Output: 2
//    
//    Example 3:
//    Input: points = [[1,1]]
//    Output: 0
//
//    Constraints:
//    n == points.length
//    1 <= n <= 500
//    points[i].length == 2
//    -10^4 <= xi, yi <= 10^4
//    All the points are unique.



//给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组 ，其中i和j之间的距离和i和k之间的欧式距离相等（需要考虑元组的顺序）。
//
//    返回平面上所有回旋镖的数量。
//
//    示例 1：
//    输入：points = [[0,0],[1,0],[2,0]]
//    输出：2
//    解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
//
//    示例 2：
//    输入：points = [[1,1],[2,2],[3,3]]
//    输出：2
//
//    示例 3：
//    输入：points = [[1,1]]
//    输出：0
//
//    提示：
//    n ==points.length
//    1 <= n <= 500
//    points[i].length == 2
//    -10^4 <= xi, yi <= 10^4
//    所有点都 互不相同



public class Q447 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        while(true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            data.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        int[][] points = new int[data.size()][2];
        for (int i = 0; i < data.size(); i++) {
            points[i] = data.get(i);
        }
        int result = numberOfBoomerangs(points);
        System.out.println(result);
    }

    // Enumerate and use HashMap
    private static int numberOfBoomerangs(int[][] points) {
        if (points.length < 3) {
            return 0;
        }
        int result = 0;
        for (int[] p1 : points) {
            Map<Integer, Integer> hMap = new HashMap<>();
            for (int[] p2 : points) {
                int dist = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                hMap.put(dist, hMap.getOrDefault(dist, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
                int m = entry.getValue();
                result += m * (m - 1);
            }
        }
        return result;
    }
}
