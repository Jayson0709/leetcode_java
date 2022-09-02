package algorithms.search.dfs;

import sharedClasses.TreeNode;
import utils.InputMethods;



//Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
//
//    The length of the path between two nodes is represented by the number of edges between them.
//    
//    Example 1:
//               5
//            /     \
//           4       5
//          / \       \
//         1   1       5
//    Input: root = [5,4,5,1,1,null,5]
//    Output: 2
//    Explanation: The shown image shows that the longest path of the same value (i.e. 5).
//    
//    Example 2:
//               1
//             /   \
//            4     5
//           / \     \
//          4   4     5
//    Input: root = [1,4,5,4,4,null,5]
//    Output: 2
//    Explanation: The shown image shows that the longest path of the same value (i.e. 4).
//    
//    Constraints:
//    The number of nodes in the tree is in the range [0, 10^4].
//    -1000 <= Node.val <= 1000
//    The depth of the tree will not exceed 1000.



//给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
//
//    两个节点之间的路径长度 由它们之间的边数表示。
//
//    示例 1:
//               5
//            /     \
//           4       5
//          / \       \
//         1   1       5
//    输入：root = [5,4,5,1,1,5]
//    输出：2
//
//    示例 2:
//               1
//             /   \
//            4     5
//           / \     \
//          4   4     5
//    输入：root = [1,4,5,4,4,5]
//    输出：2
//
//    提示:
//    树的节点数的范围是 [0, 10^4] 
//    -1000 <= Node.val <= 1000
//    树的深度将不超过 1000 


public class Q687 {
    public static void main(String[] args) {
        TreeNode root = InputMethods.getInputForOneBinaryTree(InputMethods.getInputForOneIntArray());
        System.out.println(longestUnivaluePath(root));
    }

    static int res;

    private static int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left), right = dfs(root.right);
        int left1 = 0, right1 = 0;
        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        res = Math.max(res, left1 + right1);
        return Math.max(left1, right1);
    }
}
