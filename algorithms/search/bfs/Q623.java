package algorithms.search.bfs;

import sharedClasses.TreeNode;
import utils.InputMethods;
import utils.OneDArrayAndTwoInt;
import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth 'depth'.
//
//    Note that the root node is at depth 1.
//
//    The adding rule is:
//
//    Given the integer depth, for each not null tree node cur at the depth 'depth - 1', create two tree nodes with value val as cur's left subtree root and right subtree root.
//    cur's original left subtree should be the left subtree of the new left subtree root.
//    cur's original right subtree should be the right subtree of the new right subtree root.
//    If depth == 1 that means there is no depth 'depth - 1' at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
//
//    Example 1:
//                  4                             4
//                /   \                        /     \
//               2     6       ->             1       1
//              / \   /                      /         \
//             3   1 5                      2           6
//                                         /  \        /
//                                        3    1      5
//    Input: root = [4,2,6,3,1,5], val = 1, depth = 2
//    Output: [4,1,1,2,null,null,6,3,1,5]
//
//    Example 2:
//             4                         4
//            /                         /
//           2          ->             2
//          / \                       / \
//         3   1                     1   1
//                                  /     \
//                                 3       1
//    Input: root = [4,2,null,3,1], val = 1, depth = 3
//    Output: [4,2,null,1,1,3,null,null,1]
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 10^4].
//    The depth of the tree is in the range [1, 104].
//    -100 <= Node.val <= 100
//    -10^5 <= val <= 10^5
//    1 <= depth <= the depth of tree + 1



//给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
//
//    注意，根节点 root 位于深度 1 。
//
//    加法规则如下:
//
//    给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
//    cur 原来的左子树应该是新的左子树根的左子树。
//    cur 原来的右子树应该是新的右子树根的右子树。
//    如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
//
//    示例 1:
//                  4                             4
//                /   \                        /     \
//               2     6       ->             1       1
//              / \   /                      /         \
//             3   1 5                      2           6
//                                         /  \        /
//                                        3    1      5
//    输入: root = [4,2,6,3,1,5], val = 1, depth = 2
//    输出: [4,1,1,2,null,null,6,3,1,5]
//
//    示例 2:
//             4                         4
//            /                         /
//           2          ->             2
//          / \                       / \
//         3   1                     1   1
//                                  /     \
//                                 3       1
//    输入: root = [4,2,null,3,1], val = 1, depth = 3
//    输出:  [4,2,null,1,1,3,null,null,1]
//
//    提示:
//    节点数在 [1, 10^4] 范围内
//    树的深度在 [1, 10^4]范围内
//    -100 <= Node.val <= 100
//    -10^5 <= val <= 10^5
//    1 <= depth <= the depth of tree + 1



public class Q623 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDArrayAndTwoInt obj = InputMethods.getOneInt1DArrayAndTwoIntInput(cin);
        TreeNode root = InputMethods.getInputForOneBinaryTree(obj.array);
        cin.close();
        System.out.println(OutputMethods.levelOrderTraversalOutput(addOneRow(root, obj.val1, obj.val2)));
    }


    // Method 1: DFS
//    private static TreeNode addOneRow(TreeNode root, int val, int depth) {
//        if (root == null) {
//            return null;
//        }
//        if (depth == 1) {
//            return new TreeNode(val, root, null);
//        }
//        if (depth == 2) {
//            root.left = new TreeNode(val, root.left, null);
//            root.right = new TreeNode(val, null, root.right);
//        } else {
//            root.left = addOneRow(root.left, val, depth - 1);
//            root.right = addOneRow(root.right, val, depth - 1);
//        }
//        return root;
//    }

    // Method 2: BFS
    private static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Queue<TreeNode> curLevel = new LinkedList<>();
        curLevel.offer(root);
        for (int i = 1; i < depth - 1; i++) {
            Queue<TreeNode> temp = new LinkedList<>();
            for (TreeNode node : curLevel) {
                if (node.left != null) {
                    temp.offer(node.left);
                }
                if (node.right != null) {
                    temp.offer(node.right);
                }
            }
            curLevel = temp;
        }
        for (TreeNode node : curLevel) {
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        }
        return root;
    }
}
