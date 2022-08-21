package dataStructures.linkedList;
import java.nio.charset.StandardCharsets;
import java.util.*;
import sharedClasses.ListNode;
import utils.*;


//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sumas a linked list.
//
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//    Example 1:
//    Input: l1 = [2,4,3], l2 = [5,6,4]
//    Output: [7,0,8]
//    Explanation: 342 + 465 = 807.

//    Example 2:
//    Input: l1 = [0], l2 = [0]
//    Output: [0]

//    Example 3:
//    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//    Output: [8,9,9,9,0,0,0,1]
//
//    Constraints:
//    The number of nodes in each linked list is in the range [1, 100].
//    0 <= Node.val <= 9
//    It is guaranteed that the list represents a number that does not have leading zeros.


// 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。

// 请你将两个数相加，并以相同形式返回一个表示和的链表。

// 你可以假设除了数字 0 之外，这两个数都不会以 0开头。

// 示例 1：

// 输入：l1 = [2,4,3], l2 = [5,6,4]
// 输出：[7,0,8]
// 解释：342 + 465 = 807.

// 示例 2：

// 输入：l1 = [0], l2 = [0]
// 输出：[0]

// 示例 3：

// 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// 输出：[8,9,9,9,0,0,0,1]
// 

// 提示：

// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零

public class Q2 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] data1 = cin.nextLine().strip().split(" ");
        ListNode l1 = new ListNode(Integer.parseInt(data1[0]));
        ListNode tempHead1 = l1;
        for (int i = 1; i < data1.length; i++) {
            ListNode tempNode = new ListNode(Integer.parseInt(data1[i]));
            tempHead1.next = tempNode;
            tempHead1 = tempNode;
        }
        String[] data2 = cin.nextLine().strip().split(" ");
        ListNode l2 = new ListNode(Integer.parseInt(data2[0]));
        ListNode tempHead2 = l2;
        for (int i = 1; i < data2.length; i++) {
            ListNode tempNode = new ListNode(Integer.parseInt(data2[i]));
            tempHead2.next = tempNode;
            tempHead2 = tempNode;
        }
        cin.close();

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(OutputMethods.outputLinkedListData(result));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int value1;
            int value2;
            if (l1 != null) {
                value1 = l1.val;
            } else {
                value1 = 0;
            }
            if (l2 != null) {
                value2 = l2.val;
            } else {
                value2 = 0;
            }
            int curSum = value1 + value2 + carry;
            if (resultHead == null) {
                resultHead = tail = new ListNode(curSum % 10);
            } else {
                tail.next = new ListNode(curSum % 10);
                tail = tail.next;
            }
            carry = curSum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return resultHead;
    }
}