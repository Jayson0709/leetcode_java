package dataStructures.tree.binaryTree;


import sharedClasses.TreeNode;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given the root of a binary tree, return the preorder traversal of its nodes' values.
//
//    Example 1:
//           1
//            \
//             2
//            /
//           3
//    Input: root = [1,null,2,3]
//    Output: [1,2,3]
//
//    Example 2:
//    Input: root = []
//    Output: []
//
//    Example 3:
//    Input: root = [1]
//    Output: [1]
//
//    Constraints:
//    The number of nodes in the tree is in the range [0, 100].
//    -100 <= Node.val <= 100
//
//    Follow up: Recursive solution is trivial, could you do it iteratively?



//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//    示例 1：
//           1
//            \
//             2
//            /
//           3
//    输入：root = [1,null,2,3]
//    输出：[1,2,3]
//
//    示例 2：
//    输入：root = []
//    输出：[]
//
//    示例 3：
//    输入：root = [1]
//    输出：[1]
//
//    示例 4：
//          1
//         /
//        2
//    输入：root = [1,2]
//    输出：[1,2]
//
//    示例 5：
//          1
//           \
//            2
//    输入：root = [1,null,2]
//    输出：[1,2]
//
//    提示：
//    树中节点数目在范围 [0, 100] 内
//    -100 <= Node.val <= 100
//
//    进阶：递归算法很简单，你可以通过迭代算法完成吗？




public class Q144 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        cin.close();
        System.out.println(preorderTraversal(root));
    }

    // Method 1: recursively
//    private static List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        preorderTraversal(root, res);
//        return res;
//    }
//
//    private static void preorderTraversal(TreeNode node, List<Integer> res) {
//        if (node == null) {
//            return;
//        }
//        res.add(node.val);
//        preorderTraversal(node.left, res);
//        preorderTraversal(node.right, res);
//    }

    // Method 2: Iteratively
    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return res;
    }
}
