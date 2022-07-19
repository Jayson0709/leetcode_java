package dataStructures.tree.segmentTree;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.
//
//    A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).
//
//    The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.
//
//    Implement the MyCalendarTwo class:
//        MyCalendarTwo() Initializes the calendar object.
//        boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
//
//    Example 1:
//
//    Input
//    ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
//    [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
//    Output
//    [null, true, true, true, false, true, true]
//
//    Explanation
//    MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
//    myCalendarTwo.book(10, 20); // return True, The event can be booked.
//    myCalendarTwo.book(50, 60); // return True, The event can be booked.
//    myCalendarTwo.book(10, 40); // return True, The event can be double booked.
//    myCalendarTwo.book(5, 15);  // return False, The event cannot be booked, because it would result in a triple booking.
//    myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
//    myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
//
//    Constraints:
//    0 <= start < end <= 10^9
//    At most 1000 calls will be made to book.


//实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
//
//    MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数x 的范围为， start <= x < end。
//
//    当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
//
//    每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
//
//    请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
//
//    示例：
//
//    MyCalendar();
//    MyCalendar.book(10, 20); // returns true
//    MyCalendar.book(50, 60); // returns true
//    MyCalendar.book(10, 40); // returns true
//    MyCalendar.book(5, 15); // returns false
//    MyCalendar.book(5, 10); // returns true
//    MyCalendar.book(25, 55); // returns true
//    解释：
//    前两个日程安排可以添加至日历中。 第三个日程安排会导致双重预订，但可以添加至日历中。
//    第四个日程安排活动（5,15）不能添加至日历中，因为它会导致三重预订。
//    第五个日程安排（5,10）可以添加至日历中，因为它未使用已经双重预订的时间10。
//    第六个日程安排（25,55）可以添加至日历中，因为时间 [25,40] 将和第三个日程安排双重预订；
//    时间 [40,50] 将单独预订，时间 [50,55）将和第二个日程安排双重预订。
//
//    提示：
//    每个测试用例，调用MyCalendar.book函数最多不超过1000次。
//    调用函数MyCalendar.book(start, end)时，start 和end 的取值范围为[0, 10^9]。



public class Q731 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("MyCalendarTwo")) {
            MyCalendarTwo obj = new MyCalendarTwo();
            output.append("null");
            for (int i = 1; i < orders.length; i++) {
                int[] dataPair = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
                output.append(", ").append(obj.book(dataPair[0], dataPair[1]));
            }
        }
        cin.close();
        output.append("]");
        System.out.println(output);
    }
}

// Method 1: Direct iterate the list
//class MyCalendarTwo {
//    List<int[]> booked;
//    List<int[]> overlaps;
//
//    public MyCalendarTwo() {
//        booked = new ArrayList<>();
//        overlaps = new ArrayList<>();
//    }
//
//    public boolean book(int start, int end) {
//        for (int[] arr : overlaps) {
//            int left = arr[0], right = arr[1];
//            if (left < end && right > start) {
//                return false;
//            }
//        }
//        for (int[] arr : booked) {
//            int left = arr[0], right = arr[1];
//            if (left < end && right > start) {
//                overlaps.add(new int[]{Math.max(left, start), Math.min(right, end)});
//            }
//        }
//        booked.add(new int[]{start, end});
//        return true;
//    }
//}


// Method 2: Segment Tree
class MyCalendarTwo {
    Map<Integer, int[]> tree;
    public MyCalendarTwo() {
        tree = new HashMap<>();
    }

    public boolean book(int start, int end) {
        update(start, end - 1, 1, 0, 1000000000, 1);
        tree.putIfAbsent(1, new int[2]);
        if (tree.get(1)[0] > 2) {
            update(start, end - 1, -1, 0, 1000000000, 1);
            return false;
        }
        return true;
    }

    public void update(int start, int end, int val, int left, int right, int index) {
        if (start > right || end < left) {
            return;
        }
        tree.putIfAbsent(index, new int[2]);
        if (start <= left && end >= right) {
            tree.get(index)[0] += val;
            tree.get(index)[1] += val;
        } else {
            int mid = (left + right) / 2;
            update(start, end, val, left, mid, 2 * index);
            update(start, end, val, mid + 1, right, 2 * index + 1);
            tree.putIfAbsent(2 * index, new int[2]);
            tree.putIfAbsent(2 * index + 1, new int[2]);
            tree.get(index)[0] = tree.get(index)[1] + Math.max(tree.get(2 * index)[0], tree.get(2 * index + 1)[0]);
        }
    }
}