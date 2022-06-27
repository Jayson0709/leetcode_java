package algorithms.search.dfs;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given the root of a binary tree, return its maximum depth.
//
//    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//    Example 1:
//         3
//       /  \
//      9    20
//     / \  /  \
//    null 15   7
//    Input: root = [3,9,20,null,null,15,7]
//    Output: 3
//
//    Example 2:
//    Input: root = [1,null,2]
//    Output: 2
//
//    Constraints:
//    The number of nodes in the tree is in the range [0, 104].
//    -100 <= Node.val <= 100


//给定一个二叉树，找出其最大深度。
//
//    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
//    说明:叶子节点是指没有子节点的节点。
//
//    示例：
//    给定二叉树 [3,9,20,null,null,15,7]，
//         3
//       /  \
//      9    20
//     / \  /  \
//    null 15   7
//    返回它的最大深度3


public class Q104 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        int result = maxDepth(root);
        System.out.println(result);
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
