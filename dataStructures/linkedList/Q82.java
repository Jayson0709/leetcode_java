package dataStructures.linkedList;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
//        
//    Example 1:
//    1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
//                |
//                V
//           1 -> 2 -> 5
//    Input: head = [1,2,3,3,4,4,5]
//    Output: [1,2,5]
//    
//    Example 2:
//    1 -> 1 -> 1 -> 2 -> 3
//              |
//              V
//            2 -> 3
//    Input: head = [1,1,1,2,3]
//    Output: [2,3]
//
//    Constraints:
//    The number of nodes in the list is in the range [0, 300].
//    -100 <= Node.val <= 100
//    The list is guaranteed to be sorted in ascending order.


//给定一个已排序的链表的头head ，删除原始链表中所有重复数字的节点，只留下不同的数字。返回 已排序的链表。
//
//    示例 1：
//    1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
//                |
//                V
//           1 -> 2 -> 5
//    输入：head = [1,2,3,3,4,4,5]
//    输出：[1,2,5]
//
//    示例 2：
//    1 -> 1 -> 1 -> 2 -> 3
//              |
//              V
//            2 -> 3
//    输入：head = [1,1,1,2,3]
//    输出：[2,3]
//
//    提示：
//    链表中节点数目在范围 [0, 300] 内
//    -100 <= Node.val <= 100
//    题目数据保证链表已经按升序 排列



public class Q82 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        ListNode head = new ListNode(data[0]);
        ListNode l1 = head;
        for (int i = 1; i < data.length; i++) {
            ListNode tempHead = new ListNode(data[i]);
            l1.next = tempHead;
            l1 = tempHead;
        }
        ListNode resultHead = deleteDuplicates(head);
        int index = 0;
        System.out.print("[");
        while (resultHead != null) {
            if (index == 0) {
                System.out.print(resultHead.val);
            } else {
                System.out.print(", " + resultHead.val);
            }
            resultHead = resultHead.next;
            index++;
        }
        System.out.print("]");
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                while (curr.next != null && curr.next.val == curr.val) {
                    curr.next = curr.next.next;
                }
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
