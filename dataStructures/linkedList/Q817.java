package dataStructures.linkedList;

import sharedClasses.ListNode;
import utils.DataConversionMethods;
import utils.InputMethods;
import utils.TwoOneDIntArray;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


//You are given the head of a linked list containing unique integer values and an integer array nums that is a subset of the linked list values.
//
//    Return the number of connected components in nums where two values are connected if they appear consecutively in the linked list.
//
//    Example 1:
//    0 -> 1 -> 2 -> 3
//    Input: head = [0,1,2,3], nums = [0,1,3]
//    Output: 2
//    Explanation: 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
//
//    Example 2:
//    0 -> 1 -> 2 -> 3 -> 4
//    Input: head = [0,1,2,3,4], nums = [0,3,1,4]
//    Output: 2
//    Explanation: 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
//
//    Constraints:
//    The number of nodes in the linked list is n.
//    1 <= n <= 10^4
//    0 <= Node.val < n
//    All the values Node.val are unique.
//    1 <= nums.length <= n
//    0 <= nums[i] < n
//    All the values of nums are unique.



//给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
//
//    返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
//
//    示例 1：
//    0 -> 1 -> 2 -> 3
//    输入: head = [0,1,2,3], nums = [0,1,3]
//    输出: 2
//    解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。
//
//    示例 2：
//    0 -> 1 -> 2 -> 3 -> 4
//    输入: head = [0,1,2,3,4], nums = [0,3,1,4]
//    输出: 2
//    解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
//
//    提示：
//    链表中节点数为n
//    1 <= n <= 10^4
//    0 <= Node.val < n
//    Node.val 中所有值 不同
//    1 <= nums.length <= n
//    0 <= nums[i] < n
//    nums 中所有值 不同




public class Q817 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArray obj = InputMethods.getInputForTwoInt1DArray(cin);
        cin.close();
        ListNode head = DataConversionMethods.convert1DArrayToLinkedList(obj.array1);
        System.out.println(numComponents(head, obj.array2));
    }

    private static int numComponents(ListNode head, int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        boolean inSet = false;
        int res = 0;
        while (head != null) {
            if (numSet.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    res++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return res;
    }
}
