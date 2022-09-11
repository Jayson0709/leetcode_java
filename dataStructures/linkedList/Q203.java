package dataStructures.linkedList;

import sharedClasses.ListNode;
import utils.DataConversionMethods;
import utils.InputMethods;
import utils.OneDArrayAndOneInt;
import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
//
//    Example 1:
//    1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
//                   |
//                   V
//         1 -> 2 -> 3 -> 4 -> 5
//    Input: head = [1,2,6,3,4,5,6], val = 6
//    Output: [1,2,3,4,5]
//
//    Example 2:
//    Input: head = [], val = 1
//    Output: []
//
//    Example 3:
//    Input: head = [7,7,7,7], val = 7
//    Output: []
//
//    Constraints:
//    The number of nodes in the list is in the range [0, 10^4].
//    1 <= Node.val <= 50
//    0 <= val <= 50



//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//    示例 1：
//    1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
//                   |
//                   V
//         1 -> 2 -> 3 -> 4 -> 5
//    输入：head = [1,2,6,3,4,5,6], val = 6
//    输出：[1,2,3,4,5]
//
//    示例 2：
//    输入：head = [], val = 1
//    输出：[]
//
//    示例 3：
//    输入：head = [7,7,7,7], val = 7
//    输出：[]
//
//    提示：
//    列表中的节点数目在范围 [0, 10^4] 内
//    1 <= Node.val <= 50
//    0 <= val <= 50


public class Q203 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        ListNode head = DataConversionMethods.convert1DArrayToLinkedList(obj.array);
        ListNode resultHead = removeElements(head, obj.val);
        System.out.println(OutputMethods.formatLinkedListOutputData(resultHead));
    }

    // Method 1: Recursively
    private static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    // Method 2: Iteratively
//    private static ListNode removeElements(ListNode head, int val) {
//        ListNode prev = new ListNode(-1, head);
//        ListNode curr = prev;
//        while (curr.next != null) {
//            if (curr.next.val == val) {
//                curr.next = curr.next.next;
//            } else {
//                curr = curr.next;
//            }
//        }
//        return prev.next;
//    }
}
