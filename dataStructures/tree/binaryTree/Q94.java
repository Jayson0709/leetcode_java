package dataStructures.tree.binaryTree;

import sharedClasses.TreeNode;
import utils.*;


import java.nio.charset.StandardCharsets;
import java.util.*;


//Given the root of a binary tree, return the inorder traversal of its nodes' values.
//
//        Example 1:
//        Input: root = [1,null,2,3]
//        Output: [1,3,2]
//
//        Example 2:
//        Input: root = []
//        Output: []
//
//        Example 3:
//        Input: root = [1]
//        Output: [1]
//
//        Constraints:
//        The number of nodes in the tree is in the range [0, 100].
//        -100 <= Node.val <= 100


//给定一个二叉树的根节点 root ，返回 它的 中序遍历 。
//
//    示例 1：
//    输入：root = [1,null,2,3]
//    输出：[1,3,2]
//
//    示例 2：
//    输入：root = []
//    输出：[]
//
//    示例 3：
//    输入：root = [1]
//    输出：[1]
//
//    提示：
//    树中节点数目在范围 [0, 100] 内
//    -100 <= Node.val <= 100


public class Q94 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        cin.close();
        System.out.println(inorderTraversal(root));
    }

    // Method 1: Recursion
//    private static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        inorder(root, result);
//        return result;
//    }
//
//    private static void inorder(TreeNode root, List<Integer> result) {
//        if (root == null) {
//            return;
//        }
//        inorder(root.left, result);
//        result.add(root.val);
//        inorder(root.right, result);
//    }

    // Method 2: Iteratively
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

}
