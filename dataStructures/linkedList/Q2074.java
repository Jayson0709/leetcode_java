package dataStructures.linkedList;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.ListNode;
import utils.OutputMethods;


//You are given the head of a linked list.
//
//    The nodes in the linked list are sequentially assigned to non-empty groups whose lengths form the sequence of the natural numbers (1, 2, 3, 4, ...). The length of a group is the number of nodes assigned to it. In other words,
//
//    The 1st node is assigned to the first group.
//    The 2nd and the 3rd nodes are assigned to the second group.
//    The 4th, 5th, and 6th nodes are assigned to the third group, and so on.
//    Note that the length of the last group may be less than or equal to 1 + the length of the second to last group.
//
//    Reverse the nodes in each group with an even length, and return the head of the modified linked list.
//
//    Example 1:
//    | first |second |  third  |    last     |
//    | group | group |  group  |    group    |
//       5   -> 2->6 -> 3->9->1 -> 7->3->8->4
//       5   -> 6->2 -> 3->9->1 -> 4->8->3->7
//    Input: head = [5,2,6,3,9,1,7,3,8,4]
//    Output: [5,6,2,3,9,1,4,8,3,7]
//    Explanation:
//    - The length of the first group is 1, which is odd, hence no reversal occurs.
//    - The length of the second group is 2, which is even, hence the nodes are reversed.
//    - The length of the third group is 3, which is odd, hence no reversal occurs.
//    - The length of the last group is 4, which is even, hence the nodes are reversed.
//
//    Example 2:
//    | first |second | last  |
//    | group | group | group |
//       1  ->  1->0   -> 6
//       1  ->  0->1   -> 6
//    Input: head = [1,1,0,6]
//    Output: [1,0,1,6]
//    Explanation:
//    - The length of the first group is 1. No reversal occurs.
//    - The length of the second group is 2. The nodes are reversed.
//    - The length of the last group is 1. No reversal occurs.
//
//    Example 3:
//    | first | last  |
//    | group | group |
//        2  ->   1
//        2  ->   1
//    Input: head = [1,1,0,6,5]
//    Output: [1,0,1,5,6]
//    Explanation:
//    - The length of the first group is 1. No reversal occurs.
//    - The length of the second group is 2. The nodes are reversed.
//    - The length of the last group is 2. The nodes are reversed.
//
//    Constraints:
//    The number of nodes in the list is in the range [1, 10^5].
//    0 <= Node.val <= 10^5



//给你一个链表的头节点 head 。
//
//    链表中的节点 按顺序 划分成若干 非空 组，这些非空组的长度构成一个自然数序列（1, 2, 3, 4, ...）。一个组的 长度 就是组中分配到的节点数目。换句话说：
//
//    节点 1 分配给第一组
//    节点 2 和 3 分配给第二组
//    节点 4、5 和 6 分配给第三组，以此类推
//    注意，最后一组的长度可能小于或者等于 1 + 倒数第二组的长度 。
//
//    反转 每个 偶数 长度组中的节点，并返回修改后链表的头节点 head 。
//
//    示例 1：
//    | first |second |  third  |    last     |
//    | group | group |  group  |    group    |
//       5   -> 2->6 -> 3->9->1 -> 7->3->8->4
//       5   -> 6->2 -> 3->9->1 -> 4->8->3->7
//    输入：head = [5,2,6,3,9,1,7,3,8,4]
//    输出：[5,6,2,3,9,1,4,8,3,7]
//    解释：
//    - 第一组长度为 1 ，奇数，没有发生反转。
//    - 第二组长度为 2 ，偶数，节点反转。
//    - 第三组长度为 3 ，奇数，没有发生反转。
//    - 最后一组长度为 4 ，偶数，节点反转。
//
//    示例 2：
//    | first |second | last  |
//    | group | group | group |
//       1  ->  1->0   -> 6
//       1  ->  0->1   -> 6
//    输入：head = [1,1,0,6]
//    输出：[1,0,1,6]
//    解释：
//    - 第一组长度为 1 ，没有发生反转。
//    - 第二组长度为 2 ，节点反转。
//    - 最后一组长度为 1 ，没有发生反转。
//
//    示例 3：
//    | first | last  |
//    | group | group |
//        2  ->   1
//        2  ->   1
//    输入：head = [2,1]
//    输出：[2,1]
//    解释：
//    - 第一组长度为 1 ，没有发生反转。
//    - 最后一组长度为 1 ，没有发生反转。
//
//    提示：
//    链表中节点数目范围是 [1, 10^5]
//    0 <= Node.val <= 10^5
//


public class Q2074 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        ListNode head = new ListNode(data[0]);
        ListNode p = head;
        for (int i = 1; i < data.length; i++) {
            ListNode node = new ListNode(data[i]);
            p.next = node;
            p = node;
        }
        ListNode resultNode = reverseEvenLengthGroups(head);
        System.out.println(OutputMethods.outputLinkedListData(resultNode));
    }

    private static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        int curLen = 0;
        while (cur != null) {
            curLen++;
            // Try to get current sub linked list's length
            ListNode node = cur;
            int length = 0;
            // if expected length == actual length or reach the end of the list, terminate looping.
            while (length < curLen && node != null) {
                node = node.next;
                length++;
            }
            // actual length is an even number
            if (length % 2 == 0) {
                for (int i = 0; i < length - 1; i++) {
                    ListNode temp = cur.next;
                    cur.next = cur.next.next;
                    temp.next = pre.next;
                    pre.next = temp;
                }
                pre = cur;
                cur = cur.next;
            } else {
                // actual length is an odd number
                for (int i = 0; i < length; i++) {
                    cur = cur.next;
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }
}
