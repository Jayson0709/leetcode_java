package dataStructures.hashSet;

import sharedClasses.ListNode;
import utils.DataConversionMethods;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


//Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
//
//    For example, the following two linked lists begin to intersect at node c1:
//    A:       a1 -> a2 -v
//                        -> c1 -> c2 -> c3
//    B: b1 -> b2 -> b3 -^
//
//    The test cases are generated such that there are no cycles anywhere in the entire linked structure.
//
//    Note that the linked lists must retain their original structure after the function returns.
//
//    Custom Judge:
//
//    The inputs to the judge are given as follows (your program is not given these inputs):
//
//    intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
//    listA - The first linked list.
//    listB - The second linked list.
//    skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
//    skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
//    The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
//
//    Example 1:
//    A:      4 -> 8 -v
//                      -> 2 -> 4
//    B: 5 -> 6 -> 1 -^
//    Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
//    Output: Intersected at '8'
//    Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
//    From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
//    - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
//
//    Example 2:
//    A: 1 -> 9 -> 1 -v
//                     -> 2 -> 4
//    B:           3 -^
//    Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//    Output: Intersected at '2'
//    Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
//    From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
//
//    Example 3:
//    A: 2 -> 6 -> 4
//    B:      1 -> 5
//    Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//    Output: No intersection
//    Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
//    Explanation: The two lists do not intersect, so return null.
//
//    Constraints:
//    The number of nodes of listA is in the m.
//    The number of nodes of listB is in the n.
//    1 <= m, n <= 3 * 10^4
//    1 <= Node.val <= 10^5
//    0 <= skipA < m
//    0 <= skipB < n
//    intersectVal is 0 if listA and listB do not intersect.
//    intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
//
//    Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?



//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
//
//    图示两个链表在节点 c1 开始相交：
//    A:       a1 -> a2 -v
//                        -> c1 -> c2 -> c3
//    B: b1 -> b2 -> b3 -^
//
//    题目数据 保证 整个链式结构中不存在环。
//
//    注意，函数返回结果后，链表必须 保持其原始结构 。
//
//    自定义评测：
//
//    评测系统 的输入如下（你设计的程序 不适用 此输入）：
//
//    intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
//    listA - 第一个链表
//    listB - 第二个链表
//    skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
//    skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
//    评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
//
//    示例 1：
//    A:      4 -> 8 -v
//                      -> 2 -> 4
//    B: 5 -> 6 -> 1 -^
//    输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
//    输出：Intersected at '8'
//    解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//    从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
//    在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//    示例 2：
//    A: 1 -> 9 -> 1 -v
//                     -> 2 -> 4
//    B:           3 -^
//    输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//    输出：Intersected at '2'
//    解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//    从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
//    在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//    示例 3：
//    A: 2 -> 6 -> 4
//    B:      1 -> 5
//    输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//    输出：null
//    解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//    由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//    这两个链表不相交，因此返回 null 。
//
//    提示：
//    listA 中节点数目为 m
//    listB 中节点数目为 n
//    1 <= m, n <= 3 * 10^4
//    1 <= Node.val <= 10^5
//    0 <= skipA <= m
//    0 <= skipB <= n
//    如果 listA 和 listB 没有交点，intersectVal 为 0
//    如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
//
//    进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？




public class Q160 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int intersectVal = Integer.parseInt(cin.nextLine().strip());
        int[] listAData = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] listBData = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int skipA = Integer.parseInt(cin.nextLine().strip());
        int skipB = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        ListNode headA = DataConversionMethods.convert1DArrayToLinkedList(listAData);
        ListNode headB = DataConversionMethods.convert1DArrayToLinkedList(listBData);
        for (int i = 0; i < skipA; i++) {
            headA = headA.next;
        }
        for (int i = 0; i < skipB; i++) {
            headB = headB.next;
        }
        // Attention: Due to fact that the hashcode of each ListNode is different (implementation issue)
        // the HashSet will treat each node differently, the ResultNode will always be null.
        ListNode resultNode = getIntersectionNode(headA, headB);
        if (resultNode != null && resultNode.val == intersectVal) {
            System.out.println("Intersected at '" + resultNode.val + "'");
        } else {
            System.out.println(0);
        }
    }

    // Method 1: Two pointers
//    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode pA = headA, pB = headB;
//        while (pA != pB) {
//            pA = pA == null ? headB : pA.next;
//            pB = pB == null ? headA : pB.next;
//        }
//        return pA;
//    }

    // Method 2: Use HashSet
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
