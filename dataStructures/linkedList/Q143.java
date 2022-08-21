package dataStructures.linkedList;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.ListNode;
import utils.*;


//You are given the head of a singly linked-list. The list can be represented as:
//
//    L0 → L1 → … → Ln - 1 → Ln
//    Reorder the list to be on the following form:
//
//    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//    You may not modify the values in the list's nodes. Only nodes themselves may be changed.
//
//    Example 1:
//    1 -> 2 -> 3 -> 4
//           |
//           V
//    1 -> 4 -> 2 -> 3
//    Input: head = [1,2,3,4]
//    Output: [1,4,2,3]
//
//    Example 2:
//    1 -> 2 -> 3 -> 4 -> 5
//              |
//              V
//    1 -> 5 -> 2 -> 4 -> 3
//    Input: head = [1,2,3,4,5]
//    Output: [1,5,2,4,3]
//
//    Constraints:
//    The number of nodes in the list is in the range [1, 5 * 10^4].
//    1 <= Node.val <= 1000



//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
//    L0 → L1 → … → Ln - 1 → Ln
//    请将其重新排列后变为：
//
//    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//    不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//    示例 1：
//    1 -> 2 -> 3 -> 4
//           |
//           V
//    1 -> 4 -> 2 -> 3
//    输入：head = [1,2,3,4]
//    输出：[1,4,2,3]
//
//    示例 2：
//    1 -> 2 -> 3 -> 4 -> 5
//              |
//              V
//    1 -> 5 -> 2 -> 4 -> 3
//    输入：head = [1,2,3,4,5]
//    输出：[1,5,2,4,3]
//
//    提示：
//    链表的长度范围为 [1, 5 * 10^4]
//    1 <= node.val <= 1000



public class Q143 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        ListNode head = new ListNode(data[0]);
        ListNode p = head;
        for (int i = 1; i < data.length; i++) {
            ListNode temp = new ListNode(data[i]);
            p.next = temp;
            p = temp;
        }
        reorderList(head);
        System.out.println(OutputMethods.outputLinkedListData(head));
    }

    // Method 1: linear list
//    private static void reorderList(ListNode head) {
//        if (head == null) {
//            return;
//        }
//        List<ListNode> list = new ArrayList<>();
//        ListNode node = head;
//        while (node != null) {
//            list.add(node);
//            node = node.next;
//        }
//        int i = 0, j = list.size() - 1;
//        while (i < j) {
//            list.get(i).next = list.get(j);
//            i++;
//            if (i == j) {
//                break;
//            }
//            list.get(j).next = list.get(i);
//            j--;
//        }
//        list.get(i).next = null;
//    }

    // Method 2: find midpoint, reverse linked list, and merge lists.
    private static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(head, l2);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void mergeList(ListNode l1, ListNode l2) {
        ListNode l1Tmp;
        ListNode l2Tmp;
        while (l1 != null && l2 != null) {
            l1Tmp = l1.next;
            l2Tmp = l2.next;

            l1.next = l2;
            l1 = l1Tmp;

            l2.next = l1;
            l2 = l2Tmp;
        }
    }
}
