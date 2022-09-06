package dataStructures.tree.binaryTree;

import sharedClasses.TreeNode;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given the root of a binary tree, return the postorder traversal of its nodes' values.
//
//    Example 1:
//          1
//           \
//            2
//           /
//          3
//    Input: root = [1,null,2,3]
//    Output: [3,2,1]
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
//    The number of the nodes in the tree is in the range [0, 100].
//    -100 <= Node.val <= 100
//    
//    Follow up: Recursive solution is trivial, could you do it iteratively?



//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
//     
//
//    示例 1：
//          1
//           \
//            2
//           /
//          3
//    输入：root = [1,null,2,3]
//    输出：[3,2,1]
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
//    树中节点的数目在范围 [0, 100] 内
//    -100 <= Node.val <= 100
//
//    进阶：递归算法很简单，你可以通过迭代算法完成吗？


public class Q145 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        cin.close();
        System.out.println(postorderTraversal(root));
    }

    // Method 1: Recursively
//    private static List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        postorderTraversal(root, res);
//        return res;
//    }
//
//    private static void postorderTraversal(TreeNode node, List<Integer> res) {
//        if (node == null) {
//            return;
//        }
//        postorderTraversal(node.left, res);
//        postorderTraversal(node.right, res);
//        res.add(node.val);
//    }

    // Method 2: Iteratively
    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
