package dataStructures.linkedList;
import java.util.*;
import java.nio.charset.StandardCharsets;


//给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素insertVal ，使这个列表仍然是循环升序的。
//
//    给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
//
//    如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
//
//    如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
//
//    示例 1：
//    输入：head = [3,4,1], insertVal = 2
//    输出：[3,4,1,2]
//    解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
//
//    示例 2：
//    输入：head = [], insertVal = 1
//    输出：[1]
//    解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
//
//    示例 3：
//    输入：head = [1], insertVal = 0
//    输出：[1,0]
//
//    提示：
//    0 <= Number of Nodes <= 5 * 10^4
//    -10^6 <= Node.val <= 10^6
//    -10^6 <=insertVal <= 10^6


public class Q708 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int insertVal = cin.nextInt();
        cin.close();

        ListNode head = new ListNode(data[0]);
        ListNode p = head;
        for (int i = 1; i < data.length; i++) {
            ListNode tempNode = new ListNode(data[i]);
            p.next = tempNode;
            p = tempNode;
        }
        p.next= head;

        ListNode result = insert(head, insertVal);
        System.out.print("[" + result.val);
        result = result.next;
        while (result != null) {
            System.out.print(" ," + result.val);
            result = result.next;
        }
        System.out.print("]");
    }

    private static ListNode insert(ListNode head, int insertVal) {
        ListNode insertNode = new ListNode(insertVal);
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }
        if (head.next == head) {
            head.next = insertNode;
            insertNode.next = head;
            return head;
        }
        ListNode curr = head;
        ListNode next = head.next;
        while (next != head) {
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            if (curr.val > next.val) {
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
            }
            curr = curr.next;
            next = next.next;
        }
        curr.next = insertNode;
        insertNode.next = next;
        return head;
    }
}
