package dataStructures.tree.binaryTree;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given the root of a binary tree, return the inorder traversal of its nodes' values.
//
//        Example 1:
//        Input: root = [1,null,2,3]
//        Output: [1,3,2]
//
//        Example 2:
//        Input: root = []
//        Output: []
//
//        Example 3:
//        Input: root = [1]
//        Output: [1]
//
//        Constraints:
//        The number of nodes in the tree is in the range [0, 100].
//        -100 <= Node.val <= 100


//给定一个二叉树的根节点 root ，返回 它的 中序遍历 。
//
//    示例 1：
//    输入：root = [1,null,2,3]
//    输出：[1,3,2]
//
//    示例 2：
//    输入：root = []
//    输出：[]
//
//    示例 3：
//    输入：root = [1]
//    输出：[1]
//
//    提示：
//    树中节点数目在范围 [0, 100] 内
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

public class Q94 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        List<Integer> result = inorderTraversal(root);
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            if (i == 0) {
                System.out.print(result.get(i));
            } else {
                System.out.print("," + result.get(i));
            }
        }
        System.out.print("]");
    }

    // Method 1: Recursion
//    private static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        inorder(root, result);
//        return result;
//    }
//
//    private static void inorder(TreeNode root, List<Integer> result) {
//        if (root == null) {
//            return;
//        }
//        inorder(root.left, result);
//        result.add(root.val);
//        inorder(root.right, result);
//    }

    // Method 2: Iteratively
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

}
