package dataStructures.tree.segmentTree;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
//
//    A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
//
//    The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.
//
//    Implement the MyCalendar class:
//        MyCalendar() Initializes the calendar object.
//        boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
//
//    Example 1:
//
//    Input
//    ["MyCalendar", "book", "book", "book"]
//    [[], [10, 20], [15, 25], [20, 30]]
//    Output
//    [null, true, false, true]
//
//    Explanation
//    MyCalendar myCalendar = new MyCalendar();
//    myCalendar.book(10, 20); // return True
//    myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
//    myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
//
//    Constraints:
//    0 <= start < end <= 109
//    At most 1000 calls will be made to book.


//实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
//
//    当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
//
//    日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数x 的范围为， start <= x < end 。
//
//    实现 MyCalendar 类：
//        MyCalendar() 初始化日历对象。
//        boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false并且不要将该日程安排添加到日历中。
//
//    示例：
//    输入：
//    ["MyCalendar", "book", "book", "book"]
//    [[], [10, 20], [15, 25], [20, 30]]
//    输出：
//    [null, true, false, true]
//
//    解释：
//    MyCalendar myCalendar = new MyCalendar();
//    myCalendar.book(10, 20); // return True
//    myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
//    myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
//
//    提示：
//    0 <= start < end <= 109
//    每个测试用例，调用 book 方法的次数最多不超过 1000 次。



public class Q729 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String[] orders = cin.nextLine().strip().split(" ");
        List<int[]> datePairList = new ArrayList<>();
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            datePairList.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        cin.close();
        System.out.print("[null");
        if (orders[0].equals("MyCalendar")) {
            MyCalendar obj = new MyCalendar();
            for (int[] datePair : datePairList) {
                boolean result = obj.book(datePair[0], datePair[1]);
                System.out.print(", " + result);
            }
            System.out.print("]");
        }
    }
}

// Method 1: use TreeSet
//class MyCalendar {
//    TreeSet<int[]> calendar;
//    public MyCalendar() {
//        calendar = new TreeSet<>((a, b) -> {
//            if (a[1] <= b[0]) {
//                return -1;
//            } else if (a[0] >= b[1]) {
//                return 1;
//            } else {
//                return 0;
//            }
//        });
//    }
//
//    public boolean book(int start, int end) {
//        int[] e = new int[]{start, end};
//        return calendar.add(e);
//    }
//}

class MyCalendar {

    Set<Integer> tree;
    Set<Integer> lazy;

    public MyCalendar() {
        tree = new HashSet<>();
        lazy = new HashSet<>();
    }

    public boolean book(int start, int end) {
        if (query(start, end - 1, 0, 1000000000, 1)) {
            return false;
        }
        update(start, end - 1, 0, 1000000000, 1);
        return true;
    }

    public boolean query(int start, int end, int l, int r, int index) {
        if (start > r || end < l) {
            return false;
        }
        if (lazy.contains(index)) {
            return true;
        }
        if (start <= l && end >= r) {
            return tree.contains(index);
        } else {
            int mid = (l + r) >> 1;
            if (end <= mid) {
                return query(start, end, l, mid, 2 * index);
            } else if (start > mid) {
                return query(start, end, mid + 1, r, 2 * index + 1);
            } else {
                return query(start, end, l, mid, 2 * index) | query(start, end, mid + 1, r, 2 * index + 1);
            }
        }
    }

    public void update(int start, int end, int l, int r, int index) {
        if (r < start || l > end) {
            return;
        }
        if (start <= l && end >= r) {
            tree.add(index);
            lazy.add(index);
        } else {
            int mid = (l + r) >> 1;
            update(start, end, l, mid, 2 * index);
            update(start, end, mid + 1, r, 2 * index + 1);
            tree.add(index);
        }
    }
}
