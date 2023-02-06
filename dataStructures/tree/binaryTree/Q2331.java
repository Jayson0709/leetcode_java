package dataStructures.tree.binaryTree;

import sharedClasses.TreeNode;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given the root of a full binary tree with the following properties:
//
//    Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
//    Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
//    The evaluation of a node is as follows:
//
//    If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
//    Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
//    Return the boolean result of evaluating the root node.
//
//    A full binary tree is a binary tree where each node has either 0 or 2 children.
//
//    A leaf node is a node that has zero children.
//
//    Example 1:
//         or                       or
//        /  \                    /    \
//      True AND       ->       True   False    -> True
//          /   \
//        False  True
//    Input: root = [2,1,3,null,null,0,1]
//    Output: true
//    Explanation: The above diagram illustrates the evaluation process.
//    The AND node evaluates to False AND True = False.
//    The OR node evaluates to True OR False = True.
//    The root node evaluates to True, so we return true.
//
//    Example 2:
//    Input: root = [0]
//    Output: false
//    Explanation: The root node is a leaf node and it evaluates to false, so we return false.
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 1000].
//    0 <= Node.val <= 3
//    Every node has either 0 or 2 children.
//    Leaf nodes have a value of 0 or 1.
//    Non-leaf nodes have a value of 2 or 3.


//给你一棵 完整二叉树 的根，这棵树有以下特征：
//
//    叶子节点 要么值为 0 要么值为 1 ，其中 0 表示 False ，1 表示 True 。
//    非叶子节点 要么值为 2 要么值为 3 ，其中 2 表示逻辑或 OR ，3 表示逻辑与 AND 。
//    计算 一个节点的值方式如下：
//
//    如果节点是个叶子节点，那么节点的 值 为它本身，即 True 或者 False 。
//    否则，计算 两个孩子的节点值，然后将该节点的运算符对两个孩子值进行 运算 。
//    返回根节点 root 的布尔运算值。
//
//    完整二叉树 是每个节点有 0 个或者 2 个孩子的二叉树。
//
//    叶子节点 是没有孩子的节点。
//
//    示例 1：
//         or                       or
//        /  \                    /    \
//      True AND       ->       True   False    -> True
//          /   \
//        False  True
//    输入：root = [2,1,3,null,null,0,1]
//    输出：true
//    解释：上图展示了计算过程。
//    AND 与运算节点的值为 False AND True = False 。
//    OR 运算节点的值为 True OR False = True 。
//    根节点的值为 True ，所以我们返回 true 。
//
//    示例 2：
//    输入：root = [0]
//    输出：false
//    解释：根节点是叶子节点，且值为 false，所以我们返回 false 。
//
//    提示：
//    树中节点数目在 [1, 1000] 之间。
//    0 <= Node.val <= 3
//    每个节点的孩子数为 0 或 2 。
//    叶子节点的值为 0 或 1 。
//    非叶子节点的值为 2 或 3 。


public class Q2331 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        cin.close();
        System.out.println(evaluateTree(root));
    }

    private static boolean evaluateTree(TreeNode root) {
        if (root.left == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
