package dataStructures.array.simpleArray;

import utils.InputMethods;
import utils.OneDArrayAndTwoInt;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.
//
//    The bus goes along both directions i.e. clockwise and counterclockwise.
//
//    Return the shortest distance between the given start and destination stops.
//    
//    Example 1:
//    0(start)  --->  1(destination)
//    |          1    |
//    |4              |2
//    |      3        |
//    3      -->      2
//    Input: distance = [1,2,3,4], start = 0, destination = 1
//    Output: 1
//    Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
//
//    Example 2:
//    0(start)  --->  1
//    |          1    |
//    |4              |2
//    |      3        |
//    3      -->      2(destination)
//    Input: distance = [1,2,3,4], start = 0, destination = 2
//    Output: 3
//    Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
//    
//    Example 3:
//    0(start)  --->  1
//    |          1    |
//    |4              |2
//    |      3        |
//    3(dest)-->      2
//    Input: distance = [1,2,3,4], start = 0, destination = 3
//    Output: 4
//    Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
//
//    Constraints:
//    1 <= n<= 10^4
//    distance.length == n
//    0 <= start, destination < n
//    0 <= distance[i] <= 10^4



//环形公交路线上有n个站，按次序从0到n - 1进行编号。我们已知每一对相邻公交站之间的距离，distance[i]表示编号为i的车站和编号为(i + 1) % n的车站之间的距离。
//
//    环线上的公交车都可以按顺时针和逆时针的方向行驶。
//
//    返回乘客从出发点start到目的地destination之间的最短距离。
//
//    示例 1：
//    0(start)  --->  1(destination)
//    |          1    |
//    |4              |2
//    |      3        |
//    3      -->      2
//    输入：distance = [1,2,3,4], start = 0, destination = 1
//    输出：1
//    解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
//
//    示例 2：
//    0(start)  --->  1
//    |          1    |
//    |4              |2
//    |      3        |
//    3      -->      2(destination)
//    输入：distance = [1,2,3,4], start = 0, destination = 2
//    输出：3
//    解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
//
//    示例 3：
//    0(start)  --->  1
//    |          1    |
//    |4              |2
//    |      3        |
//    3(dest)-->      2
//    输入：distance = [1,2,3,4], start = 0, destination = 3
//    输出：4
//    解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
//
//    提示：
//    1 <= n<= 10^4
//    distance.length == n
//    0 <= start, destination < n
//    0 <= distance[i] <= 10^4



public class Q1184 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDArrayAndTwoInt obj = InputMethods.getOneInt1DArrayAndTwoIntInput(cin);
        cin.close();
        int result = distanceBetweenBusStops(obj.array, obj.val1, obj.val2);
        System.out.println(result);
    }

    private static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                sum1 += distance[i];
            } else {
                sum2 += distance[i];
            }
        }
        return Math.min(sum1, sum2);
    }
}
