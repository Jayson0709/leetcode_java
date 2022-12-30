package dataStructures.queue.priorityQueue;

import java.nio.charset.StandardCharsets;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;


//There is an exam room with n seats in a single row labeled from 0 to n - 1.
//
//    When a student enters the room, they must sit in the seat that maximizes the distance to the closest person. If there are multiple such seats, they sit in the seat with the lowest number. If no one is in the room, then the student sits at seat number 0.
//
//    Design a class that simulates the mentioned exam room.
//
//    Implement the ExamRoom class:
//
//    ExamRoom(int n) Initializes the object of the exam room with the number of the seats n.
//    int seat() Returns the label of the seat at which the next student will set.
//    void leave(int p) Indicates that the student sitting at seat p will leave the room. It is guaranteed that there will be a student sitting at seat p.
//
//    Example 1:
//    Input
//    ["ExamRoom", "seat", "seat", "seat", "seat", "leave", "seat"]
//    [[10], [], [], [], [], [4], []]
//    Output
//    [null, 0, 9, 4, 2, null, 5]
//
//    Explanation
//    ExamRoom examRoom = new ExamRoom(10);
//    examRoom.seat(); // return 0, no one is in the room, then the student sits at seat number 0.
//    examRoom.seat(); // return 9, the student sits at the last seat number 9.
//    examRoom.seat(); // return 4, the student sits at the last seat number 4.
//    examRoom.seat(); // return 2, the student sits at the last seat number 2.
//    examRoom.leave(4);
//    examRoom.seat(); // return 5, the student sits at the last seat number 5.
//
//    Constraints:
//    1 <= n <= 10^9
//    It is guaranteed that there is a student sitting at seat p.
//    At most 10^4 calls will be made to seat and leave.


//在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
//
//    当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
//
//    返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
//
//    示例：
//    输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
//    输出：[null,0,9,4,2,null,5]
//    解释：
//    ExamRoom(10) -> null
//    seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
//    seat() -> 9，学生最后坐在 9 号座位上。
//    seat() -> 4，学生最后坐在 4 号座位上。
//    seat() -> 2，学生最后坐在 2 号座位上。
//    leave(4) -> null
//    seat() -> 5，学生最后坐在 5 号座位上。
//
//    提示：
//    1 <= N <= 10^9
//    在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
//    保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。


public class Q855 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("ExamRoom")) {
            output.append("null");
            ExamRoom obj = new ExamRoom(Integer.parseInt(cin.nextLine().strip()));
            for (int i = 1; i < orders.length; i++) {
                if (orders[i].equals("seat")) {
                    output.append(", ").append(obj.seat());
                } else if (orders[i].equals("leave")) {
                    obj.leave(Integer.parseInt(cin.nextLine().strip()));
                    output.append(", null");
                }
            }
        }
        output.append("]");
        cin.close();
        System.out.println(output);
    }
}

class ExamRoom {
    int n;
    TreeSet<Integer> seats;
    PriorityQueue<int[]> pq;

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<>();
        this.pq = new PriorityQueue<>((a, b) -> {
            int d1 = a[1] - a[0], d2 = b[1] - b[0];
            return d1 / 2 < d2 / 2 || (d1 / 2 == d2 / 2 && a[0] > b[0]) ? 1 : -1;
        });
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int left = seats.first(), right = n - 1 - seats.last();
        while (seats.size() >= 2) {
            int[] p = pq.peek();
            if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) {
                int d = p[1] - p[0];
                if (d / 2 < right || d / 2 <= left) {
                    break;
                }
                pq.poll();
                pq.offer(new int[]{p[0], p[0] + d / 2});
                pq.offer(new int[]{p[0] + d / 2, p[1]});
                seats.add(p[0] + d / 2);
                return p[0] + d / 2;
            }
            pq.poll();
        }
        if (right > left) {
            pq.offer(new int[]{seats.last(), n - 1});
            seats.add(n - 1);
            return n - 1;
        } else {
            pq.offer(new int[]{0, seats.first()});
            seats.add(0);
            return 0;
        }
    }

    public void leave(int p) {
        if (p != seats.first() && p != seats.last()) {
            int prev = seats.lower(p);
            int next = seats.higher(p);
            pq.offer(new int[]{prev, next});
        }
        seats.remove(p);
    }
}