package algorithms.search.bfs;

import sharedClasses.TreeNode;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//Given the root of a binary tree, return the sum of all left leaves.
//
//    A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
//
//    Example 1:
//            3
//          /   \
//         9    20
//             /  \
//            15   7
//    Input: root = [3,9,20,null,null,15,7]
//    Output: 24
//    Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
//
//    Example 2:
//    Input: root = [1]
//    Output: 0
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 1000].
//    -1000 <= Node.val <= 1000



//给定二叉树的根节点 root ，返回所有左叶子之和。
//
//    示例 1：
//            3
//          /   \
//         9    20
//             /  \
//            15   7
//    输入: root = [3,9,20,null,null,15,7]
//    输出: 24
//    解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//    示例 2:
//    输入: root = [1]
//    输出: 0
//
//    提示:
//    节点数在 [1, 1000] 范围内
//    -1000 <= Node.val <= 1000


public class Q404 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        cin.close();
        System.out.println(sumOfLeaves(root));
    }

    // Method 1: DFS
//    private static int sumOfLeaves(TreeNode root) {
//        int[] val = new int[]{0};
//        dfs(root, val);
//        return val[0];
//    }
//
//    private static void dfs(TreeNode node, int[] val) {
//        if (node.left != null) {
//            if (isLeafNode(node.left)) {
//                val[0] += node.left.val;
//            } else {
//                dfs(node.left, val);
//            }
//        }
//        if (node.right != null && !isLeafNode(node.right)) {
//            dfs(node.right, val);
//        }
//    }
//
//    private static boolean isLeafNode(TreeNode node) {
//        return node.left == null && node.right == null;
//    }

    // Method 2: BFS
    private static int sumOfLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    res += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    private static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
