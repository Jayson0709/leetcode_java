package dataStructures.linkedList;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.ListNode;
import utils.OutputMethods;


//Given the head of a linked list, rotate the list to the right by k places.
//
//    Example 1:
//    1 -> 2 -> 3 -> 4 -> 5
//    5 -> 1 -> 2 -> 3 -> 4
//    4 -> 5 -> 1 -> 2 -> 3
//    Input: head = [1,2,3,4,5], k = 2
//    Output: [4,5,1,2,3]
//
//    Example 2:
//    0 -> 1 -> 2
//    2 -> 0 -> 1
//    1 -> 2 -> 0
//    Input: head = [0,1,2], k = 4
//    Output: [2,0,1]
//
//    Constraints:
//    The number of nodes in the list is in the range [0, 500].
//    -100 <= Node.val <= 100
//    0 <= k <= 2 * 109


//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动k个位置。
//
//    示例 1：
//    1 -> 2 -> 3 -> 4 -> 5
//    5 -> 1 -> 2 -> 3 -> 4
//    4 -> 5 -> 1 -> 2 -> 3
//    输入：head = [1,2,3,4,5], k = 2
//    输出：[4,5,1,2,3]
//
//    示例 2：
//    0 -> 1 -> 2
//    2 -> 0 -> 1
//    1 -> 2 -> 0
//    输入：head = [0,1,2], k = 4
//    输出：[2,0,1]
//
//    提示：
//    链表中节点的数目在范围 [0, 500] 内
//    -100 <= Node.val <= 100
//    0 <= k <= 2 * 109


public class Q61 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = cin.nextInt();
        cin.close();

        ListNode head = new ListNode(data[0]);
        ListNode tempHead = head;
        for (int i = 1; i < data.length; i++) {
            ListNode tempNode = new ListNode(data[i]);
            tempHead.next = tempNode;
            tempHead = tempNode;
        }

        ListNode resultHead = rotateRight(head, k);
        System.out.println(OutputMethods.outputLinkedListData(resultHead));
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        k = k % n;
        ListNode p = head;
        for (int i = 0; i < n - k - 1; i++) {
            p = p.next;
        }
        tail.next = head;
        head = p.next;
        p.next = null;
        return head;
    }
}
