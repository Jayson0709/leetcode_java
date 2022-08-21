package algorithms.backtracking;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given the root of a binary tree, return all root-to-leaf paths in any order.
//
//    A leaf is a node with no children.
//
//    Example 1:
//        1
//       / \
//      2   3
//       \
//        5
//    Input: root = [1,2,3,null,5]
//    Output: ["1->2->5","1->3"]
//
//    Example 2:
//    Input: root = [1]
//    Output: ["1"]
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 100].
//    -100 <= Node.val <= 100


//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
//    叶子节点 是指没有子节点的节点。
//
//    示例 1：
//        1
//       / \
//      2   3
//       \
//        5
//    输入：root = [1,2,3,null,5]
//    输出：["1->2->5","1->3"]
//
//    示例 2：
//    输入：root = [1]
//    输出：["1"]
//
//    提示：
//    树中节点的数目在范围 [1, 100] 内
//    -100 <= Node.val <= 100

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // a simple implementation for tree node insertion
    // Does not support null value input.
    public void insertInBST(TreeNode node, int value) {
        if (value < node.val) {
            if (node.left != null) {
                insertInBST(node.left, value);
            } else {
                node.left = new TreeNode(value);
            }
        } else if (value > node.val) {
            if (node.right != null) {
                insertInBST(node.right, value);
            } else {
                node.right = new TreeNode(value);
            }
        }
    }

    // a simple implementation for binary tree node insertion
    // Does not support null value input.
    public void insertInBT(TreeNode node, int value) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            node = q.peek();
            q.remove();
            if (node.left == null) {
                node.left = new TreeNode(value);
                break;
            } else {
                q.add(node.left);
            }
            if (node.right == null) {
                node.right = new TreeNode(value);
                break;
            } else {
                q.add(node.right);
            }
        }
    }
}

public class Q257 {

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        List<String> result = binaryTreePaths(root);
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            if (i == 0) {
                System.out.print(result.get(i));
            } else {
                System.out.print(", " + result.get(i));
            }
        }
        System.out.print("]");
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new ArrayList<>());
        return result;
    }

    private static void dfs(TreeNode root, List<Integer> curPathList) {
        // null node, just return.
        if (root == null) {
            return;
        }
        curPathList.add(root.val);
        // Reach a leaf node.
        if (root.left == null && root.right == null) {
            result.add(getPathString(curPathList));
        }
        dfs(root.left, curPathList);
        dfs(root.right, curPathList);
        curPathList.remove(curPathList.size() - 1);
    }

    private static String getPathString(List<Integer> curPathList) {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append(curPathList.get(0));
        for (int i = 1; i < curPathList.size(); i++) {
            pathBuilder.append("->").append(curPathList.get(i));
        }
        return pathBuilder.toString();
    }
}
