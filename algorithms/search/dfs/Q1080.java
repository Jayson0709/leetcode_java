package algorithms.search.dfs;

import sharedClasses.TreeNode;
import utils.InputMethods;
import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//Given the root of a binary tree and an integer limit, delete all insufficient nodes in the tree simultaneously, and return the root of the resulting binary tree.
//
//    A node is insufficient if every root to leaf path intersecting this node has a sum strictly less than limit.
//
//    A leaf is a node with no children.
//
//    Example 1:
//                      1
//                   /      \
//                  2         3
//                /   \      /  \
//               4   -99   -99    7
//             / \   / \    / \   / \
//             8 9 -99 -99 12 13 -99 14
//    Input: root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
//    Output: [1,2,3,4,null,null,7,8,9,null,14]
//
//    Example 2:
//                5
//              /   \
//             4     8
//            /     / \
//           11    17  4
//          /  \      / \
//         7   1     5   3
//    Input: root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
//    Output: [5,4,8,11,null,17,4,7,null,null,null,5]
//
//    Example 3:
//                1
//              /   \
//             2    -3
//            /     /
//           -5    4
//    Input: root = [1,2,-3,-5,null,4,null], limit = -1
//    Output: [1,null,-3,4]
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 5000].
//    -10^5 <= Node.val <= 10^5
//    -10^9 <= limit <= 10^9


//给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
//
//    假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
//
//    叶子节点，就是没有子节点的节点。
//
//    示例 1：
//                      1
//                   /      \
//                  2         3
//                /   \      /  \
//               4   -99   -99    7
//             / \   / \    / \   / \
//             8 9 -99 -99 12 13 -99 14
//    输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
//    输出：[1,2,3,4,null,null,7,8,9,null,14]
//
//    示例 2：
//                5
//              /   \
//             4     8
//            /     / \
//           11    17  4
//          /  \      / \
//         7   1     5   3
//    输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
//    输出：[5,4,8,11,null,17,4,7,null,null,null,5]
//
//    示例 3：
//                1
//              /   \
//             2    -3
//            /     /
//           -5    4
//    输入：root = [1,2,-3,-5,null,4,null], limit = -1
//    输出：[1,null,-3,4]
//
//    提示：
//    树中节点数目在范围 [1, 5000] 内
//    -10^5 <= Node.val <= 10^5
//    -10^9 <= limit <= 10^9


public class Q1080 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        int limit = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        System.out.println(OutputMethods.formatInorderTreeTraversalOutputData(sufficientSubset(root, limit)));
    }

    public static TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean haveSufficient = hasSufficientLeaf(root, 0, limit);
        return haveSufficient ? root : null;
    }

    public static boolean hasSufficientLeaf(TreeNode node, int sum, int limit) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.val + sum >= limit;
        }
        boolean haveSufficientLeft = hasSufficientLeaf(node.left, sum + node.val, limit);
        boolean haveSufficientRight = hasSufficientLeaf(node.right, sum + node.val, limit);
        if (!haveSufficientLeft) {
            node.left = null;
        }
        if (!haveSufficientRight) {
            node.right = null;
        }
        return haveSufficientLeft || haveSufficientRight;
    }
}
