package dataStructures.tree.binarySearchTree;

import sharedClasses.ListNode;
import sharedClasses.TreeNode;
import utils.DataConversionMethods;
import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


//Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
//    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//    Example 1:
//    -10 -> -3 -> 0 -> 5 -> 9
//            |
//            |
//            |
//            V
//            0
//        -3      9
//    -10      5
//    Input: head = [-10,-3,0,5,9]
//    Output: [0,-3,9,-10,null,5]
//    Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
//
//    Example 2:
//    Input: head = []
//    Output: []
//
//    Constraints:
//    The number of nodes in head is in the range [0, 2 * 104].
//    -105 <= Node.val <= 105


//给定一个单链表的头节点 head，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
//
//    本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差不超过 1。
//
//    示例 1:
//    -10 -> -3 -> 0 -> 5 -> 9
//            |
//            |
//            |
//            V
//            0
//        -3      9
//    -10      5
//    输入: head = [-10,-3,0,5,9]
//    输出: [0,-3,9,-10,null,5]
//    解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
//
//    示例 2:
//    输入: head = []
//    输出: []
//
//    提示:
//    head中的节点数在[0, 2 * 104]范围内
//    -105<= Node.val <= 105



public class Q109 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        ListNode head = DataConversionMethods.convert1DArrayToLinkedList(data);
        cin.close();
        System.out.println(OutputMethods.formatLevelOrderTreeTraversalOutputData(sortedListToBST(head)));
    }

    private static TreeNode sortedListToBST(ListNode head) {
        // terminal condition
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // Use two pointers ('slow' and 'fast') to find the mid-point of the linked list
        // 'pre' will be the mid-point's previous node.
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // The linked list will be split up into two parts.
        // One part is the left nodes, and the other is the right nodes.
        pre.next = null;
        // Get the current node
        TreeNode curNode = new TreeNode(slow.val);
        // From the 'head' node to the 'pre' node, all the nodes are the left part of the tree.
        curNode.left = sortedListToBST(head);
        // From the 'slow.next' node to the end of the list, all the nodes are the right part of the tree.
        curNode.right = sortedListToBST(slow.next);
        return curNode;
    }
}
