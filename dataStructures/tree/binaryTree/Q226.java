package dataStructures.tree.binaryTree;

import sharedClasses.TreeNode;
import utils.InputMethods;
import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//Given the root of a binary tree, invert the tree, and return its root.
//
//    Example 1:
//            4                     4
//          /   \                 /   \
//         2     7      ->       7     2
//        / \   / \             / \   / \
//       1  3  6   9           9  6  3   1
//    Input: root = [4,2,7,1,3,6,9]
//    Output: [4,7,2,9,6,3,1]
//
//    Example 2:
//            2                  2
//          /   \      ->      /   \
//         1     3            3     1
//    Input: root = [2,1,3]
//    Output: [2,3,1]
//
//    Example 3:
//    Input: root = []
//    Output: []
//
//    Constraints:
//    The number of nodes in the tree is in the range [0, 100].
//    -100 <= Node.val <= 100



//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
//    示例 1：
//            4                     4
//          /   \                 /   \
//         2     7      ->       7     2
//        / \   / \             / \   / \
//       1  3  6   9           9  6  3   1
//    输入：root = [4,2,7,1,3,6,9]
//    输出：[4,7,2,9,6,3,1]
//
//    示例 2：
//            2                  2
//          /   \      ->      /   \
//         1     3            3     1
//    输入：root = [2,1,3]
//    输出：[2,3,1]
//
//    示例 3：
//    输入：root = []
//    输出：[]
//
//    提示：
//    树中节点数目范围在 [0, 100] 内
//    -100 <= Node.val <= 100


public class Q226 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        cin.close();
        System.out.println(OutputMethods.formatLevelOrderTreeTraversalOutputData(invertTree(root)));
    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
