package dataStructures.linkedList;

import sharedClasses.ListNode;
import utils.DataConversionMethods;
import utils.InputMethods;
import utils.OutputMethods;


//Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
//
//    Example 1:
//    1 -> 1 -> 2
//         |
//         V
//       1 -> 2
//    Input: head = [1,1,2]
//    Output: [1,2]
//
//    Example 2:
//    1 -> 1 -> 2 -> 3 -> 3
//            |
//            V
//        1 -> 2 -> 3
//    Input: head = [1,1,2,3,3]
//    Output: [1,2,3]
//
//    Constraints:
//    The number of nodes in the list is in the range [0, 300].
//    -100 <= Node.val <= 100
//    The list is guaranteed to be sorted in ascending order.


//给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次。返回 已排序的链表。
//
//    示例 1：
//    1 -> 1 -> 2
//         |
//         V
//       1 -> 2
//    输入：head = [1,1,2]
//    输出：[1,2]
//
//    示例 2：
//    1 -> 1 -> 2 -> 3 -> 3
//            |
//            V
//        1 -> 2 -> 3
//    输入：head = [1,1,2,3,3]
//    输出：[1,2,3]
//
//    提示：
//    链表中节点数目在范围 [0, 300] 内
//    -100 <= Node.val <= 100
//    题目数据保证链表已经按升序 排列



public class Q83 {
    public static void main(String[] args) {
        ListNode head = DataConversionMethods.convert1DArrayToLinkedList(InputMethods.getInputForOneIntArray());
        ListNode resultHead = deleteDuplicates(head);
        System.out.println(OutputMethods.formatLinkedListOutputData(resultHead));
    }

    // Method 1: Two Pointers
//    private static ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode p1 = head;
//        ListNode p2 = head.next;
//        while (p2 != null) {
//            if (p1.val == p2.val) {
//                while (p2 != null && p2.val == p1.val) {
//                    if (p2.next != null) {
//                        p2 = p2.next;
//                    } else {
//                        p2 = null;
//                    }
//                }
//                p1.next = p2;
//            }
//            if (p2 != null) {
//                p1 = p2;
//                p2 = p2.next;
//            }
//        }
//        return head;
//    }

    // Method 2: Single pointer
    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }
}
