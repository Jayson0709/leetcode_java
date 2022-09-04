package dataStructures.tree.binaryTree;

import sharedClasses.TreeNode;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//Given a binary tree, determine if it is height-balanced.
//
//    For this problem, a height-balanced binary tree is defined as:
//
//    a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//
//    Example 1:
//              3
//            /   \
//           9    20
//               /  \
//              15   7
//    Input: root = [3,9,20,null,null,15,7]
//    Output: true
//
//    Example 2:
//                   1
//                 /   \
//                2     2
//              /   \
//             3     3
//           /  \
//          4    4
//    Input: root = [1,2,2,3,3,null,null,4,4]
//    Output: false
//
//    Example 3:
//    Input: root = []
//    Output: true
//
//    Constraints:
//    The number of nodes in the tree is in the range [0, 5000].
//    -10^4 <= Node.val <= 10^4



//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//    本题中，一棵高度平衡二叉树定义为：
//
//    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//    示例 1：
//              3
//            /   \
//           9    20
//               /  \
//              15   7
//    输入：root = [3,9,20,null,null,15,7]
//    输出：true
//
//    示例 2：
//                   1
//                 /   \
//                2     2
//              /   \
//             3     3
//           /  \
//          4    4
//    输入：root = [1,2,2,3,3,null,null,4,4]
//    输出：false
//
//    示例 3：
//    输入：root = []
//    输出：true
//
//    提示：
//    树中的节点数在范围 [0, 5000] 内
//    -10^4 <= Node.val <= 10^4



public class Q110 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        cin.close();
        System.out.println(isBalanced(root));
    }

    // Version 1: check recursively from top to bottom
//    private static boolean isBalanced(TreeNode root) {
//        if (root == null) {
//            return true;
//        } else {
//            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//        }
//    }
//
//    public static int height(TreeNode root) {
//        if (root == null) {
//            return 0;
//        } else {
//            return Math.max(height(root.left), height(root.right)) + 1;
//        }
//    }

    // Version 2: check recursively from bottom to top
    private static boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
