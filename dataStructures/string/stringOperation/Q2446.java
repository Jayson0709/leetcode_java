package dataStructures.string.stringOperation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given two arrays of strings that represent two inclusive events that happened on the same day, event1 and event2, where:
//
//    event1 = [startTime1, endTime1] and
//    event2 = [startTime2, endTime2].
//    Event times are valid 24 hours format in the form of HH:MM.
//
//    A conflict happens when two events have some non-empty intersection (i.e., some moment is common to both events).
//
//    Return true if there is a conflict between two events. Otherwise, return false.
//
//    Example 1:
//    Input: event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
//    Output: true
//    Explanation: The two events intersect at time 2:00.
//
//    Example 2:
//    Input: event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
//    Output: true
//    Explanation: The two events intersect starting from 01:20 to 02:00.
//
//    Example 3:
//    Input: event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
//    Output: false
//    Explanation: The two events do not intersect.
//
//    Constraints:
//    event1.length == event2.length == 2.
//    event1[i].length == event2[i].length == 5
//    startTime1 <= endTime1
//    startTime2 <= endTime2
//    All the event times follow the HH:MM format.


//给你两个字符串数组 event1 和 event2 ，表示发生在同一天的两个闭区间时间段事件，其中：
//
//    event1 = [startTime1, endTime1] 且
//    event2 = [startTime2, endTime2]
//    事件的时间为有效的 24 小时制且按 HH:MM 格式给出。
//
//    当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突 。
//
//    如果两个事件之间存在冲突，返回 true ；否则，返回 false 。
//
//    示例 1：
//    输入：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
//    输出：true
//    解释：两个事件在 2:00 出现交集。
//
//    示例 2：
//    输入：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
//    输出：true
//    解释：两个事件的交集从 01:20 开始，到 02:00 结束。
//
//    示例 3：
//    输入：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
//    输出：false
//    解释：两个事件不存在交集。
//
//    提示：
//    event1.length == event2.length == 2.
//    event1[i].length == event2[i].length == 5
//    startTime1 <= endTime1
//    startTime2 <= endTime2
//    所有事件的时间都按照 HH:MM 格式给出


public class Q2446 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] event1 = cin.nextLine().strip().split(" ");
        String[] event2 = cin.nextLine().strip().split(" ");
        cin.close();
        System.out.println(haveConflict(event1, event2));
    }

    private static boolean haveConflict(String[] event1, String[] event2) {
        if (event1[1].compareTo(event2[0]) < 0 && event1[0].compareTo(event2[1]) < 0) {
            return false;
        }
        return event1[1].compareTo(event2[0]) <= 0 || event1[0].compareTo(event2[1]) <= 0;
    }
}
