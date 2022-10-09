package dataStructures.linkedList;

import sharedClasses.ListNode;
import utils.DataConversionMethods;
import utils.InputMethods;
import utils.OneDIntArrayAndTwoInt;
import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//
//    Example 1:
//    1 -> 2 -> 3 -> 4 -> 5
//              |
//              V
//    1 -> 4 -> 3 -> 2 -> 5
//    Input: head = [1,2,3,4,5], left = 2, right = 4
//    Output: [1,4,3,2,5]
//
//    Example 2:
//    Input: head = [5], left = 1, right = 1
//    Output: [5]
//
//    Constraints:
//    The number of nodes in the list is n.
//    1 <= n <= 500
//    -500 <= Node.val <= 500
//    1 <= left <= right <= n
//
//    Follow up: Could you do it in one pass?


//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
//
//    示例 1：
//    1 -> 2 -> 3 -> 4 -> 5
//              |
//              V
//    1 -> 4 -> 3 -> 2 -> 5
//    输入：head = [1,2,3,4,5], left = 2, right = 4
//    输出：[1,4,3,2,5]
//
//    示例 2：
//    输入：head = [5], left = 1, right = 1
//    输出：[5]
//
//    提示：
//    链表中节点数目为 n
//    1 <= n <= 500
//    -500 <= Node.val <= 500
//    1 <= left <= right <= n
//
//    进阶： 你可以使用一趟扫描完成反转吗？



public class Q92 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDIntArrayAndTwoInt obj = InputMethods.getInputFOrOneInt1DArrayAndTwoInt(cin);
        cin.close();
        ListNode head = DataConversionMethods.convert1DArrayToLinkedList(obj.array);
        ListNode resultNode = reverseBetween(head, obj.val1, obj.val2);
        System.out.println(OutputMethods.formatLinkedListOutputData(resultNode));
    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
