package dataStructures.tree.binarySearchTree;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.TreeNode;
import utils.OutputMethods;

//Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
//
//    Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
//
//    Example 1:
//    Input: root = [1,0,2], low = 1, high = 2
//    Output: [1,null,2]
//
//    Example 2:
//    Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//    Output: [3,2,null,1]
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 104].
//    0 <= Node.val <= 104
//    The value of each node in the tree is unique.
//    root is guaranteed to be a valid binary search tree.
//    0 <= low <= high <= 104


//给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在唯一的答案。
//
//    所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
//
//    示例 1：
//    输入：root = [1,0,2], low = 1, high = 2
//    输出：[1,null,2]
//
//    示例 2：
//    输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//    输出：[3,2,null,1]
//
//    提示：
//    树中节点数在范围 [1, 104] 内
//    0 <= Node.val <= 104
//    树中每个节点的值都是 唯一 的
//    题目数据保证输入是一棵有效的二叉搜索树
//    0 <= low <= high <= 104


public class Q669 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int low = cin.nextInt();
        int high = cin.nextInt();
        cin.close();

        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBST(root, data[i]);
        }
        // Tree traversal
        System.out.println(OutputMethods.levelOrderTraversalOutput(trimBST(root, low, high)));
    }

    private static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // The tree is a BST, so node.left.val < node.val < node.right.val
        if (root.val < low) {
            // if node.val < low, prune the left node.
            root = root.right;
            // after pruning, check the right node.
            root = trimBST(root, low, high);
        }
        else if (root.val > high) {
            // if node.val > high, prune the right node.
            root = root.left;
            // after pruning, check the left node.
            root = trimBST(root, low, high);
        } else {
            // if node.val is in the range, go to check the left node and right node.
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
