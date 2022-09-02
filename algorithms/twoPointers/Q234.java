package algorithms.twoPointers;

import sharedClasses.ListNode;
import utils.DataConversionMethods;
import utils.InputMethods;


//Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
//
//    Example 1:
//    1 -> 2 -> 2 -> 1
//    Input: head = [1,2,2,1]
//    Output: true
//
//    Example 2:
//    1 -> 2
//    Input: head = [1,2]
//    Output: false
//
//    Constraints:
//    The number of nodes in the list is in the range [1, 10^5].
//    0 <= Node.val <= 9
//
//    Follow up: Could you do it in O(n) time and O(1) space?



//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
//    示例 1：
//    1 -> 2 -> 2 -> 1
//    输入：head = [1,2,2,1]
//    输出：true
//
//    示例 2：
//    1 -> 2
//    输入：head = [1,2]
//    输出：false
//
//    提示：
//    链表中节点数目在范围[1, 10^5] 内
//    0 <= Node.val <= 9
//
//    进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？



public class Q234 {
    public static void main(String[] args) {
        ListNode head = DataConversionMethods.convert1DArrayToLinkedList(InputMethods.getInputForOneIntArray());
        System.out.println(isPalindrome(head));
    }

    // Method 1: Recursion
//    private static boolean isPalindrome(ListNode head) {
//        frontPointer = head;
//        return recursivelyCheck(head);
//    }
//
//    private static ListNode frontPointer;
//
//    private static boolean recursivelyCheck(ListNode currentNode) {
//        if (currentNode != null) {
//            if (!recursivelyCheck(currentNode.next)) {
//                return false;
//            }
//            if (currentNode.val != frontPointer.val) {
//                return false;
//            }
//            frontPointer = frontPointer.next;
//        }
//        return true;
//    }

    // Method 2 - version 1: two pointers
//    private static boolean isPalindrome(ListNode head) {
//        List<Integer> values = new ArrayList<>();
//
//        // copy the values into the ArrayList
//        ListNode currentNode = head;
//        while (currentNode != null) {
//            values.add(currentNode.val);
//            currentNode = currentNode.next;
//        }
//
//        // use two pointers
//        int front = 0;
//        int back = values.size() - 1;
//        while (front < back) {
//            if (!values.get(front).equals(values.get(back))) {
//                return false;
//            }
//            front++;
//            back--;
//        }
//        return true;
//    }

    // Method 2 - version 2: two pointers (quick and slow pointers)
    private static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // Find the last node of the first half of the list and reverse the second half of the list
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // check whether it's palindrome
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // restore the linked list and return the head
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private static ListNode reverseList(ListNode head) {
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

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
