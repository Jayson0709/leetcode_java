package dataStructures.linkedList;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;



//Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
//    A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
//    If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
//
//    Implement the MyLinkedList class:
//
//    MyLinkedList() Initializes the MyLinkedList object.
//    int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
//    void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
//    void addAtTail(int val) Append a node of value val as the last element of the linked list.
//    void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
//    void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
//    
//    Example 1:
//
//    Input
//    ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
//    [[], [1], [3], [1, 2], [1], [1], [1]]
//    Output
//    [null, null, null, null, 2, null, 3]
//
//    Explanation
//    MyLinkedList myLinkedList = new MyLinkedList();
//    myLinkedList.addAtHead(1);
//    myLinkedList.addAtTail(3);
//    myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
//    myLinkedList.get(1);              // return 2
//    myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
//    myLinkedList.get(1);              // return 3
//    
//    Constraints:
//    0 <= index, val <= 1000
//    Please do not use the built-in LinkedList library.
//    At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.




//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
//
//    在链表类中实现这些功能：
//
//    get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
//    addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
//    addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
//    addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
//    deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
//
//    示例：
//    MyLinkedList linkedList = new MyLinkedList();
//    linkedList.addAtHead(1);
//    linkedList.addAtTail(3);
//    linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//    linkedList.get(1);            //返回2
//    linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//    linkedList.get(1);            //返回3
//
//    提示：
//    所有val值都在 [1, 1000] 之内。
//    操作次数将在  [1, 1000] 之内。
//    请不要使用内置的 LinkedList 库。



public class Q707 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("MyLinkedList")) {
            output.append("null");
            MyLinkedList obj = new MyLinkedList();
            for (int i = 1; i < orders.length; i++) {
                switch (orders[i]) {
                    case "get" -> output.append(", ").append(obj.get(Integer.parseInt(cin.nextLine().strip())));
                    case "addAtHead" -> {
                        output.append(", null");
                        obj.addAtHead(Integer.parseInt(cin.nextLine().strip()));
                    }
                    case "addAtTail" -> {
                        output.append(", null");
                        obj.addAtTail(Integer.parseInt(cin.nextLine().strip()));
                    }
                    case "addAtIndex" -> {
                        output.append(", null");
                        int[] pair = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
                        obj.addAtIndex(pair[0], pair[1]);
                    }
                    case "deleteAtIndex" -> {
                        output.append(", null");
                        obj.deleteAtIndex(Integer.parseInt(cin.nextLine().strip()));
                    }
                }
            }
        }
        output.append("]");
        cin.close();
        System.out.println(output);
    }
}

class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(0, index);
        size++;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}