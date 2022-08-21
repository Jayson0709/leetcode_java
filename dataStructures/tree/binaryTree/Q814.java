package dataStructures.tree.binaryTree;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
//
//    A subtree of a node 'node' is 'node' plus every node that is a descendant of node.
//
//    Example 1:
//         1            1
//          \            \
//          0     ->      0
//         / \             \
//        0   1             1
//    Input: root = [1,null,0,0,1]
//    Output: [1,null,0,null,1]
//    Explanation:
//    Only the red nodes satisfy the property "every subtree not containing a 1".
//    The diagram on the right represents the answer.
//    
//    Example 2:
//                  1            1
//                 / \            \
//                0   1  ->        1
//               / \ / \            \
//              0  0 0  1            1
//    Input: root = [1,0,1,0,0,0,1]
//    Output: [1,null,1,null,1]
//    
//    Example 3:
//                      1                     1
//                    /   \                 /   \
//                   1     0               1     0
//                 /   \  /  \   ->       / \     \
//                1    1  0   1          1   1     1
//               /
//              0
//    Input: root = [1,1,0,1,1,0,1,0]
//    Output: [1,1,0,1,1,null,1]
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 200].
//    Node.val is either 0 or 1.
//
//
//给你二叉树的根结点root，此外树的每个结点的值要么是 0 ，要么是 1 。
//
//    返回移除了所有不包含 1 的子树的原二叉树。
//
//    节点 node 的子树为 node 本身加上所有 node 的后代。
//
//    示例 1：
//         1            1
//          \            \
//          0     ->      0
//         / \             \
//        0   1             1
//    输入：root = [1,null,0,0,1]
//    输出：[1,null,0,null,1]
//    解释：
//    只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
//
//    示例 2：
//                  1            1
//                 / \            \
//                0   1  ->        1
//               / \ / \            \
//              0  0 0  1            1
//    输入：root = [1,0,1,0,0,0,1]
//    输出：[1,null,1,null,1]
//
//    示例 3：
//                      1                     1
//                    /   \                 /   \
//                   1     0               1     0
//                 /   \  /  \   ->       / \     \
//                1    1  0   1          1   1     1
//               /
//              0
//    输入：root = [1,1,0,1,1,0,1,0]
//    输出：[1,1,0,1,1,null,1]
//
//    提示：
//    树中节点的数目在范围 [1, 200] 内
//    Node.val 为 0 或 1



public class Q814 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        TreeNode resultRoot = pruneTree(root);
        StringBuilder output = new StringBuilder();
        output.append("[");
        inorderTraversal(resultRoot, output);
        output.append("]");
        output.delete(1, 3);
        System.out.println(output);
    }

    private static void inorderTraversal(TreeNode node, StringBuilder output) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, output);
        output.append(", ").append(node.val);
        inorderTraversal(node.right, output);
    }

    // Method 1: Recursion
    private static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    // Method 2: use DFS
//    private static TreeNode pruneTree(TreeNode root) {
//        boolean isValid = dfs(root);
//        return !isValid && root.val == 0 ? null : root;
//    }
//
//    private static boolean dfs(TreeNode cur) {
//        if (cur == null) {
//            return false;
//        }
//        boolean leftIsValid = dfs(cur.left);
//        boolean rightIsValid = dfs(cur.right);
//        if (!leftIsValid) {
//            cur.left = null;
//        }
//        if (!rightIsValid) {
//            cur.right = null;
//        }
//        return cur.val == 1 || leftIsValid || rightIsValid;
//    }
}
