package dataStructures.queue.generalQueue;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.ListNode;

//Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
//
//    One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
//
//    Implementation the MyCircularQueue class:
//        MyCircularQueue(k) Initializes the object with the size of the queue to be k.
//        int Front() Gets the front item from the queue. If the queue is empty, return -1.
//        int Rear() Gets the last item from the queue. If the queue is empty, return -1.
//        boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
//        boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
//        boolean isEmpty() Checks whether the circular queue is empty or not.
//        boolean isFull() Checks whether the circular queue is full or not.
//        You must solve the problem without using the built-in queue data structure in your programming language. 
//
//    Example 1:
//    Input
//    ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
//    [[3], [1], [2], [3], [4], [], [], [], [4], []]
//    Output
//    [null, true, true, true, false, 3, true, true, true, 4]
//
//    Explanation
//    MyCircularQueue myCircularQueue = new MyCircularQueue(3);
//    myCircularQueue.enQueue(1); // return True
//    myCircularQueue.enQueue(2); // return True
//    myCircularQueue.enQueue(3); // return True
//    myCircularQueue.enQueue(4); // return False
//    myCircularQueue.Rear();     // return 3
//    myCircularQueue.isFull();   // return True
//    myCircularQueue.deQueue();  // return True
//    myCircularQueue.enQueue(4); // return True
//    myCircularQueue.Rear();     // return 4
//
//    Constraints:
//    1 <= k <= 1000
//    0 <= value <= 1000
//    At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.



//设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
//
//    循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
//
//    你的实现应该支持如下操作：
//        MyCircularQueue(k): 构造器，设置队列长度为 k 。
//        Front: 从队首获取元素。如果队列为空，返回 -1 。
//        Rear: 获取队尾元素。如果队列为空，返回 -1 。
//        enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
//        deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
//        isEmpty(): 检查循环队列是否为空。
//        isFull(): 检查循环队列是否已满。
//
//    示例：
//    MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//    circularQueue.enQueue(1);  // 返回 true
//    circularQueue.enQueue(2);  // 返回 true
//    circularQueue.enQueue(3);  // 返回 true
//    circularQueue.enQueue(4);  // 返回 false，队列已满
//    circularQueue.Rear();  // 返回 3
//    circularQueue.isFull();  // 返回 true
//    circularQueue.deQueue();  // 返回 true
//    circularQueue.enQueue(4);  // 返回 true
//    circularQueue.Rear();  // 返回 4
//
//    提示：
//    所有的值都在 0 至 1000 的范围内；
//    操作数将在 1 至 1000 的范围内；
//    请不要使用内置的队列库。



public class Q622 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("MyCircularQueue")) {
            int k = Integer.parseInt(cin.nextLine().strip());
            MyCircularQueue obj = new MyCircularQueue(k);
            output.append("null");
            for (int i = 1; i < orders.length; i++) {
                switch (orders[i]) {
                    case "enQueue" -> output.append(", ").append(obj.enQueue(Integer.parseInt(cin.nextLine().strip())));
                    case "deQueue" -> output.append(", ").append(obj.deQueue());
                    case "Front" -> output.append(", ").append(obj.Front());
                    case "Rear" -> output.append(", ").append(obj.Rear());
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

// Method 1: Use Array
//class MyCircularQueue {
//    private final int capacity;
//    private int front;
//    private int rear;
//    private final int[] elements;
//    public MyCircularQueue(int k) {
//        this.capacity = k + 1;
//        this.elements = new int[capacity];
//        front = rear = 0;
//    }
//
//    public boolean enQueue(int value) {
//        if (isFull()) {
//            return false;
//        }
//        elements[rear] = value;
//        rear = (rear + 1) % capacity;
//        return true;
//    }
//
//    public boolean deQueue() {
//        if (isEmpty()) {
//            return false;
//        }
//        front = (front + 1) % capacity;
//        return true;
//    }
//
//    public int Front() {
//        if (isEmpty()) {
//            return -1;
//        }
//        return elements[front];
//    }
//
//    public int Rear() {
//        if (isEmpty()) {
//            return -1;
//        }
//        return elements[(rear - 1 + capacity) % capacity];
//    }
//
//    public boolean isEmpty() {
//        return front == rear;
//    }
//
//    public boolean isFull() {
//        return ((rear + 1) % capacity) == front;
//    }
//}

// Method 2: Use LinkedList
class MyCircularQueue {
    private ListNode head;
    private ListNode tail;
    private final int capacity;
    private int size;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = head.next;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int Rear() {
        if (isEmpty()) {
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
