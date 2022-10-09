package dataStructures.hashSet;

import sharedClasses.ListNode;
import utils.DataConversionMethods;
import utils.InputMethods;
import utils.OneDIntArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Q141 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDIntArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        ListNode head = DataConversionMethods.convert1DArrayToLinkedList(obj.array);
        ListNode p1 = head, p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
        }
        while (obj.val > 0 && p2.next != null) {
            p2 = p2.next;
            obj.val--;
        }
        p1.next = p2;
        System.out.println(hasCycle(head));
    }

    // Method 1: use HashSet
    private static boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (!visited.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // Method 2: use Floyd's Cycle Finding algorithm
//    private static boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (slow != fast) {
//            if (fast == null || fast.next == null) {
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
//    }
}
