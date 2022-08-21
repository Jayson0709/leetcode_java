package algorithms.search.dfs;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a binary tree, find its minimum depth.
//
//    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//    Note:A leaf is a node with no children.
//
//    Example 1:
//        3
//       /  \
//      9    20
//          /  \
//         15   7
//    Input: root = [3,9,20,null,null,15,7]
//    Output: 2
//
//    Example 2:
//    Input: root = [2,null,3,null,4,null,5,null,6]
//    Output: 5
//
//    Constraints:
//    The number of nodes in the tree is in the range [0, 105].
//    -1000 <= Node.val <= 1000



//给定一个二叉树，找出其最小深度。
//
//    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//    说明：叶子节点是指没有子节点的节点。
//
//    示例 1：
//        3
//       /  \
//      9    20
//          /  \
//         15   7
//    输入：root = [3,9,20,null,null,15,7]
//    输出：2
//
//    示例 2：
//    输入：root = [2,null,3,null,4,null,5,null,6]
//    输出：5
//
//    提示：
//    树中节点数的范围在 [0, 105] 内
//    -1000 <= Node.val <= 1000


public class Q111 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        int result = minDepth(root);
        System.out.println(result);
    }

    private static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // both left and right nodes are null, means it's leaf node.
        if (root.left == null && root.right == null) {
            return 1;
        }
        // If there is one null node between root.left and root.right
        // We need to return the non-null node
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        // If there is a null node, which means there must be one value equal to 0 between leftMin and rightMin
        // So we can simply return leftMin + rightMin + 1
        if (root.left == null || root.right == null) {
            return leftMin + rightMin + 1;
        }
        // Both left and right nodes are not null
        return Math.min(leftMin, rightMin) + 1;
    }
}
