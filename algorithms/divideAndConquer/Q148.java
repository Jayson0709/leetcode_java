package algorithms.divideAndConquer;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given the head of a linked list, return the list after sorting it in ascending order.
//
//    Example 1:
//    4 -> 2 -> 1 -> 3
//            |
//            V
//    1 -> 2 -> 3 -> 4
//    Input: head = [4,2,1,3]
//    Output: [1,2,3,4]
//
//    Example 2:
//    -1 -> 5 -> 3 -> 4 -> 0
//               |
//               V
//    -1 -> 0 -> 3 -> 4 -> 5
//    Input: head = [-1,5,3,4,0]
//    Output: [-1,0,3,4,5]
//
//    Example 3:
//    Input: head = []
//    Output: []
//
//    Constraints:
//    The number of nodes in the list is in the range [0, 5 * 10^4].
//    -10^5 <= Node.val <= 10^5
//
//    Follow up: Can you sort the linked list in O(n log n) time and O(1) memory (i.e. constant space)?



//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//    示例 1：
//    4 -> 2 -> 1 -> 3
//            |
//            V
//    1 -> 2 -> 3 -> 4
//    输入：head = [4,2,1,3]
//    输出：[1,2,3,4]
//
//    示例 2：
//    -1 -> 5 -> 3 -> 4 -> 0
//               |
//               V
//    -1 -> 0 -> 3 -> 4 -> 5
//    输入：head = [-1,5,3,4,0]
//    输出：[-1,0,3,4,5]
//
//    示例 3：
//    输入：head = []
//    输出：[]
//
//    提示：
//    链表中节点的数目在范围 [0, 5 * 10^4] 内
//    -10^5 <= Node.val <= 10^5
//
//    进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？



public class Q148 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        ListNode head = new ListNode();
        head.val = data[0];
        ListNode p1 = head;
        for (int i = 1; i < data.length; i++) {
            ListNode temp = new ListNode(data[i]);
            p1.next = temp;
            p1 = temp;
        }
        ListNode resultHead = sortList(head);
        StringBuilder output = new StringBuilder();
        output.append("[");
        output.append(resultHead.val);
        resultHead = resultHead.next;
        while (resultHead != null) {
            output.append(", ").append(resultHead.val);
            resultHead = resultHead.next;
        }
        output.append("]");
        System.out.println(output);
    }

    // Method 1: From top to bottom
//    private static ListNode sortList(ListNode head) {
//        return sortList(head, null);
//    }
//
//    private static ListNode sortList(ListNode head, ListNode tail) {
//        if (head == null) {
//            return null;
//        }
//        if (head.next == tail) {
//            head.next = null;
//            return head;
//        }
//        ListNode slow = head, fast = head;
//        while (fast != tail) {
//            slow = slow.next;
//            fast = fast.next;
//            if (fast != tail) {
//                fast = fast.next;
//            }
//        }
//        ListNode mid = slow;
//        ListNode list1 = sortList(head, mid);
//        ListNode list2 = sortList(mid, tail);
//        return merge(list1, list2);
//    }
//
//    private static ListNode merge(ListNode head1, ListNode head2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
//        while (temp1 != null && temp2 != null) {
//            if (temp1.val <= temp2.val) {
//                temp.next = temp1;
//                temp1 = temp1.next;
//            } else {
//                temp.next = temp2;
//                temp2 = temp2.next;
//            }
//            temp = temp.next;
//        }
//        if (temp1 != null) {
//            temp.next = temp1;
//        } else if (temp2 != null) {
//            temp.next = temp2;
//        }
//        return dummyHead.next;
//    }

    // Method 2: From bottom to top
    private static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
