package algorithms.search.dfs;

import sharedClasses.TreeNode;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
//
//    A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
//
//    Example 1:
//              5
//            /   \
//           4     8
//          /     /  \
//         11    13   4
//        /  \       /  \
//       7    2     5    1
//    Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//    Output: [[5,4,11,2],[5,8,4,5]]
//    Explanation: There are two paths whose sum equals targetSum:
//    5 + 4 + 11 + 2 = 22
//    5 + 8 + 4 + 5 = 22
//
//    Example 2:
//        1
//       / \
//      2   3
//    Input: root = [1,2,3], targetSum = 5
//    Output: []
//
//    Example 3:
//    Input: root = [1,2], targetSum = 0
//    Output: []
//
//    Constraints:
//    The number of nodes in the tree is in the range [0, 5000].
//    -1000 <= Node.val <= 1000
//    -1000 <= targetSum <= 1000


//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
//    叶子节点 是指没有子节点的节点。
//
//    示例 1：
//              5
//            /   \
//           4     8
//          /     /  \
//         11    13   4
//        /  \       /  \
//       7    2     5    1
//    输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//    输出：[[5,4,11,2],[5,8,4,5]]
//
//    示例 2：
//        1
//       / \
//      2   3
//    输入：root = [1,2,3], targetSum = 5
//    输出：[]
//
//    示例 3：
//    输入：root = [1,2], targetSum = 0
//    输出：[]
//
//    提示：
//    树中节点总数在范围 [0, 5000] 内
//    -1000 <= Node.val <= 1000
//    -1000 <= targetSum <= 1000


public class Q113 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        int targetSum = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        System.out.println(pathSum(root, targetSum));
    }

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }

    private static void dfs(TreeNode node, int targetSum) {
        // case to terminate searching
        if (node == null) {
            return;
        }
        // add the current node value to the queue.
        path.add(node.val);
        // decrement the node value for the target
        targetSum -= node.val;
        // When reach a leave node and the targetSum becomes zero
        if (node.left == null && node.right == null && targetSum == 0) {
            result.add(new LinkedList<>(path));
        }
        // continue search to the left node.
        dfs(node.left, targetSum);
        // continue search to the right node.
        dfs(node.right, targetSum);
        // avoid repetitive calculation
        path.remove(path.size() - 1);
    }
}
