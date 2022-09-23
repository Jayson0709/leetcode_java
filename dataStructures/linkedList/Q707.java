package dataStructures.linkedList;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

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