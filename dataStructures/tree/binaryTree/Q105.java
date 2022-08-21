package dataStructures.tree.binaryTree;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.TreeNode;
import utils.*;


//Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
//
//    Example 1:
//            3
//           / \
//          9   20
//             /  \
//            15   7
//    Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//    Output: [3,9,20,null,null,15,7]
//
//    Example 2:
//    Input: preorder = [-1], inorder = [-1]
//    Output: [-1]
//
//    Constraints:
//    1 <= preorder.length <= 3000
//    inorder.length == preorder.length
//    -3000 <= preorder[i], inorder[i] <= 3000
//    preorder and inorder consist of unique values.
//    Each value of inorder also appears in preorder.
//    preorder is guaranteed to be the preorder traversal of the tree.
//    inorder is guaranteed to be the inorder traversal of the tree.



//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
//
//    示例 1:
//            3
//           / \
//          9   20
//             /  \
//            15   7
//    输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//    输出: [3,9,20,null,null,15,7]
//
//    示例 2:
//    输入: preorder = [-1], inorder = [-1]
//    输出: [-1]
//
//    提示:
//    1 <= preorder.length <= 3000
//    inorder.length == preorder.length
//    -3000 <= preorder[i], inorder[i] <= 3000
//    preorder 和 inorder 均 无重复 元素
//    inorder 均出现在 preorder
//    preorder 保证 为二叉树的前序遍历序列
//    inorder 保证 为二叉树的中序遍历序列



public class Q105 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] preorder = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] inorder = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode resultNode = buildTree(preorder, inorder);
        System.out.println(OutputMethods.levelOrderTraversalOutput(resultNode));
    }

    // Method 1: Recursively (reference answer)
//    private static Map<Integer, Integer> indexMap;
//
//    private static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
//        if (preorderLeft > preorderRight) {
//            return null;
//        }
//        // the first node of preorder is root node.
//        int inorderRoot = indexMap.get(preorder[preorderLeft]);
//        TreeNode root = new TreeNode(preorder[preorderLeft]);
//        int sizeLeftSubtree = inorderRoot - inorderLeft;
//        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft, inorderRoot - 1);
//        root.right = myBuildTree(preorder, inorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1, inorderRight);
//        return root;
//    }
//
//    private static TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        indexMap = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            indexMap.put(inorder[i], i);
//        }
//        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
//    }

    // Method 2: Iteratively + Stack
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIdx = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node != null && node.val != inorder[inorderIdx]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIdx]) {
                    node = stack.pop();
                    inorderIdx++;
                }
                if (node != null) {
                    node.right = new TreeNode(preorderVal);
                    stack.push(node.right);
                }
            }
        }
        return root;
    }
}
