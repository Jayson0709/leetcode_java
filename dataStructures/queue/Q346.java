package dataStructures.queue;
import java.util.*;
import java.nio.charset.StandardCharsets;


// English description please reference: https://leetcode.com/problems/moving-average-from-data-stream/ or https://leetcode-cn.com/problems/moving-average-from-data-stream/


//给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
//
//    实现 MovingAverage 类：
//        MovingAverage(int size) 用窗口大小 size 初始化对象。
//        double next(int val)成员函数 next每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
//
//    示例：
//
//    输入：
//    inputs = ["MovingAverage", "next", "next", "next", "next"]
//    inputs = [[3], [1], [10], [3], [5]]
//    输出：
//    [null, 1.0, 5.5, 4.66667, 6.0]
//
//    解释：
//    MovingAverage movingAverage = new MovingAverage(3);
//    movingAverage.next(1); // 返回 1.0 = 1 / 1
//    movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
//    movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
//    movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
//
//    提示：
//    1 <= size <= 1000
//    -10^5 <= val <= 10^5
//    最多调用 next 方法 10^4 次


public class Q346 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("MovingAverage")) {
            output.append("null");
            int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
            MovingAverage obj = new MovingAverage(data[0]);
            for (int i = 1; i < orders.length; i++) {
                if (orders[i].equals("next")) {
                    output.append(", ").append(obj.next(data[i]));
                }
            }
        }
        cin.close();
        output.append("]");
        System.out.println(output);
    }
}


// Version 1: Iterate every time of the queue.
//class MovingAverage {
//
//    Deque<Integer> dataQueue;
//    int size;
//    public MovingAverage(int size) {
//        dataQueue = new ArrayDeque<>(size);
//        this.size = size;
//    }
//
//    public double next(int val) {
//        if (dataQueue.size() == size) {
//            dataQueue.pollFirst();
//        }
//        dataQueue.offer(val);
//        int curSum = 0;
//        for (int num : dataQueue) {
//            curSum += num;
//        }
//        return (double) curSum / dataQueue.size();
//    }
//}


// Version 2: use a variable to store the latest sum so that we can reduce the iteration.
class MovingAverage {

    Deque<Integer> dataQueue;
    int size;
    double sum;
    public MovingAverage(int size) {
        dataQueue = new ArrayDeque<>(size);
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        if (!dataQueue.isEmpty() && dataQueue.size() == size) {
            sum -= dataQueue.pollFirst();
        }
        dataQueue.offer(val);
        sum += val;
        return sum / dataQueue.size();
    }
}