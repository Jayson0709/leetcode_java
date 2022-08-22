package dataStructures.tree.binaryTree;

import sharedClasses.TreeNode;
import utils.InputMethods;

import java.util.LinkedList;
import java.util.Queue;


//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//
//    Example 1:
//            1
//        2       2
//     3     4  4    3
//    Input: root = [1,2,2,3,4,4,3]
//    Output: true
//
//    Example 2:
//            1
//        2       2
//    null  3   null    3
//    Input: root = [1,2,2,null,3,null,3]
//    Output: false
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 1000].
//    -100 <= Node.val <= 100
//
//    Follow up: Could you solve it both recursively and iteratively?



//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//    示例 1：
//            1
//        2       2
//     3     4  4    3
//    输入：root = [1,2,2,3,4,4,3]
//    输出：true
//
//    示例 2：
//            1
//        2       2
//    null  3   null    3
//    输入：root = [1,2,2,null,3,null,3]
//    输出：false
//
//    提示：
//    树中节点数目在范围 [1, 1000] 内
//    -100 <= Node.val <= 100
//
//    进阶：你可以运用递归和迭代两种方法解决这个问题吗？


public class Q101 {
    public static void main(String[] args) {
        TreeNode root = InputMethods.getInputForOneTree();
        boolean result = isSymmetric(root);
        System.out.println(result);
    }

    // Method 1: Recursion
//    private static boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return compare(root.left, root.right);
//    }
//
//    private static boolean compare(TreeNode node1, TreeNode node2) {
//        if (node1 == null && node2 == null) {
//            return true;
//        }
//        if (node1 == null || node2 == null || node1.val != node2.val) {
//            return false;
//        }
//        return compare(node1.left, node2.right) && compare(node1.right, node2.left);
//    }

    // Method 2: Iteratively
    private static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            queue.offer(node1.left);
            queue.offer(node2.right);

            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
