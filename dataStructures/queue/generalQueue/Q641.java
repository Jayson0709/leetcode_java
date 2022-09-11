package dataStructures.queue.generalQueue;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Design your implementation of the circular double-ended queue (deque).
//
//    Implement the MyCircularDeque class:
//        MyCircularDeque(int k) Initializes the deque with a maximum size of k.
//        boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
//        boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
//        boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
//        boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
//        int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
//        int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
//        boolean isEmpty() Returns true if the deque is empty, or false otherwise.
//        boolean isFull() Returns true if the deque is full, or false otherwise.
//
//    Example 1:
//
//    Input
//    ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
//    [[3], [1], [2], [3], [4], [], [], [], [4], []]
//    Output
//    [null, true, true, true, false, 2, true, true, true, 4]
//
//    Explanation
//    MyCircularDeque myCircularDeque = new MyCircularDeque(3);
//    myCircularDeque.insertLast(1);  // return True
//    myCircularDeque.insertLast(2);  // return True
//    myCircularDeque.insertFront(3); // return True
//    myCircularDeque.insertFront(4); // return False, the queue is full.
//    myCircularDeque.getRear();      // return 2
//    myCircularDeque.isFull();       // return True
//    myCircularDeque.deleteLast();   // return True
//    myCircularDeque.insertFront(4); // return True
//    myCircularDeque.getFront();     // return 4
//
//    Constraints:
//    1 <= k <= 1000
//    0 <= value <= 1000
//    At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull.



//设计实现双端队列。
//
//    实现 MyCircularDeque 类:
//        MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
//        boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
//        boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
//        boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
//        boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
//        int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
//        int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
//        boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
//        boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
//
//    示例 1：
//
//    输入
//    ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
//    [[3], [1], [2], [3], [4], [], [], [], [4], []]
//    输出
//    [null, true, true, true, false, 2, true, true, true, 4]
//
//    解释
//    MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
//    circularDeque.insertLast(1);			        // 返回 true
//    circularDeque.insertLast(2);			        // 返回 true
//    circularDeque.insertFront(3);			        // 返回 true
//    circularDeque.insertFront(4);			        // 已经满了，返回 false
//    circularDeque.getRear();  				    // 返回 2
//    circularDeque.isFull();				        // 返回 true
//    circularDeque.deleteLast();			        // 返回 true
//    circularDeque.insertFront(4);			        // 返回 true
//    circularDeque.getFront();				        // 返回 4
//
//
//    提示：
//    1 <= k <= 1000
//    0 <= value <= 1000
//    insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull  调用次数不大于 2000 次



public class Q641 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("MyCircularDeque")) {
            output.append("null");
            int k = cin.nextInt();
            MyCircularDeque obj = new MyCircularDeque(k);
            for (int i = 1; i < orders.length; i++) {
                switch (orders[i]) {
                    case "insertFront" -> {
                        int value = cin.nextInt();
                        output.append(", ").append(obj.insertFront(value));
                    }
                    case "insertLast" -> {
                        int value = cin.nextInt();
                        output.append(", ").append(obj.insertLast(value));
                    }
                    case "deleteFront" -> output.append(", ").append(obj.deleteFront());
                    case "deleteLast" -> output.append(", ").append(obj.deleteLast());
                    case "getFront" -> output.append(", ").append(obj.getFront());
                    case "getRear" -> output.append(", ").append(obj.getRear());
                    case "isEmpty" -> output.append(", ").append(obj.isEmpty());
                    case "isFull" -> output.append(", ").append(obj.isFull());
                }
            }
        }
        cin.close();
        output.append("]");
        System.out.println(output);
    }
}

// Method 1: use array
//class MyCircularDeque {
//    private final int[] elements;
//    private int rear, front;
//    private final int capacity;
//
//    public MyCircularDeque(int k) {
//        capacity = k + 1;
//        rear = front = 0;
//        elements = new int[k + 1];
//    }
//
//    public boolean insertFront(int value) {
//        if (isFull()) {
//            return false;
//        }
//        front = (front - 1 + capacity) % capacity;
//        elements[front] = value;
//        return true;
//    }
//
//    public boolean insertLast(int value) {
//        if (isFull()) {
//            return false;
//        }
//        elements[rear] = value;
//        rear = (rear + 1) % capacity;
//        return true;
//    }
//
//    public boolean deleteFront() {
//        if (isEmpty()) {
//            return false;
//        }
//        front = (front + 1) % capacity;
//        return true;
//    }
//
//    public boolean deleteLast() {
//        if (isEmpty()) {
//            return false;
//        }
//        rear = (rear - 1 + capacity) % capacity;
//        return true;
//    }
//
//    public int getFront() {
//        if (isEmpty()) {
//            return -1;
//        }
//        return elements[front];
//    }
//
//    public int getRear() {
//        if (isEmpty()) {
//            return -1;
//        }
//        return elements[(rear - 1 + capacity) % capacity];
//    }
//
//    public boolean isEmpty() {
//        return rear == front;
//    }
//
//    public boolean isFull() {
//        return (rear + 1) % capacity == front;
//    }
//}


// Method 2: use linked list
class MyCircularDeque {
    private static class DoubleLinkedListNode {
        int val;
        DoubleLinkedListNode prev, next;

        DoubleLinkedListNode(int val) {
            this.val = val;
        }
    }

    private DoubleLinkedListNode head, tail;
    private final int capacity;
    private int size;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (size == capacity) {
            return false;
        }
        DoubleLinkedListNode node = new DoubleLinkedListNode(value);
        if (size == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == capacity) {
            return false;
        }
        DoubleLinkedListNode node = new DoubleLinkedListNode(value);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
