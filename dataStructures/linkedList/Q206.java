package dataStructures.linkedList;

import sharedClasses.ListNode;
import utils.DataConversionMethods;
import utils.InputMethods;
import utils.OutputMethods;


//Given the head of a singly linked list, reverse the list, and return the reversed list.
//
//    Example 1:
//    1 -> 2 -> 3 -> 4 -> 5
//              |
//              V
//    5 -> 4 -> 3 -> 2 -> 1
//    Input: head = [1,2,3,4,5]
//    Output: [5,4,3,2,1]
//
//    Example 2:
//    1 -> 2
//       |
//       V
//    2 -> 1
//    Input: head = [1,2]
//    Output: [2,1]
//
//    Example 3:
//    Input: head = []
//    Output: []
//
//    Constraints:
//    The number of nodes in the list is the range [0, 5000].
//    -5000 <= Node.val <= 5000
//
//    Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?



//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//    示例 1：
//    1 -> 2 -> 3 -> 4 -> 5
//              |
//              V
//    5 -> 4 -> 3 -> 2 -> 1
//    输入：head = [1,2,3,4,5]
//    输出：[5,4,3,2,1]
//
//    示例 2：
//    1 -> 2
//       |
//       V
//    2 -> 1
//    输入：head = [1,2]
//    输出：[2,1]
//
//    示例 3：
//    输入：head = []
//    输出：[]
//
//    提示：
//    链表中节点的数目范围是 [0, 5000]
//    -5000 <= Node.val <= 5000
//
//    进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？



public class Q206 {
    public static void main(String[] args) {
        ListNode resultHead = reverseList(DataConversionMethods.convert1DArrayToLinkedList(InputMethods.getInputForOneIntArray()));
        System.out.println(OutputMethods.formatLinkedListOutputData(resultHead));
    }

    // Method 1: Recursively
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // Method 2: Iteratively
//    private static ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }
}
