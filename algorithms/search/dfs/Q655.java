package algorithms.search.dfs;

import sharedClasses.*;
import utils.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


//Given the root of a binary tree, construct a 0-indexed m x n string matrix res that represents a formatted layout of the tree. The formatted layout matrix should be constructed using the following rules:
//
//    The height of the tree is height and the number of rows m should be equal to height + 1.
//    The number of columns n should be equal to 2height+1 - 1.
//    Place the root node in the middle of the top row (more formally, at location res[0][(n-1)/2]).
//    For each node that has been placed in the matrix at position res[r][c], place its left child at res[r+1][c-2height-r-1] and its right child at res[r+1][c+2height-r-1].
//    Continue this process until all the nodes in the tree have been placed.
//    Any empty cells should contain the empty string "".
//    Return the constructed matrix res.
//    
//    Example 1:
//          1
//         /
//        2
//    Input: root = [1,2]
//    Output:
//    [["","1",""],
//    ["2","",""]]
//    
//    Example 2:
//            1
//           / \
//          2   3
//           \
//            4
//    Input: root = [1,2,3,null,4]
//    Output:
//    [["","","","1","","",""],
//    ["","2","","","","3",""],
//    ["","","4","","","",""]]
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 2^10].
//    -99 <= Node.val <= 99
//    The depth of the tree will be in the range [1, 10].



//给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
//
//    树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
//    矩阵的列数 n 应该等于 2height+1 - 1 。
//    根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
//    对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
//    继续这一过程，直到树中的所有节点都妥善放置。
//    任意空单元格都应该包含空字符串 "" 。
//    返回构造得到的矩阵 res 。
//
//    示例 1：
//          1
//         /
//        2
//    输入：root = [1,2]
//    输出：
//    [["","1",""],
//    ["2","",""]]
//
//    示例 2：
//            1
//           / \
//          2   3
//           \
//            4
//    输入：root = [1,2,3,null,4]
//    输出：
//    [["","","","1","","",""],
//    ["","2","","","","3",""],
//    ["","","4","","","",""]]
//
//    提示：
//    树中节点数在范围 [1, 2^10] 内
//    -99 <= Node.val <= 99
//    树的深度在范围 [1, 10] 内



public class Q655 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        cin.close();
        List<List<String>> result = printTree(root);
        OutputMethods.outputEmbeddedListData(result);
    }

    // Method 1: BFS
//    static class Tuple {
//        TreeNode node;
//        int r;
//        int c;
//
//        public Tuple(TreeNode node, int r, int c) {
//            this.node = node;
//            this.r = r;
//            this.c = c;
//        }
//    }
//
//    private static List<List<String>> printTree(TreeNode root) {
//        int height = calDepth(root);
//        int m = height + 1;
//        int n = (1 << (height + 1)) - 1;
//        List<List<String>> res = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            List<String> row = new ArrayList<>();
//            for (int j = 0; j < n; j++) {
//                row.add("");
//            }
//            res.add(row);
//        }
//        Queue<Tuple> queue = new ArrayDeque<Tuple>();
//        queue.offer(new Tuple(root, 0, (n - 1) / 2));
//        while (!queue.isEmpty()) {
//            Tuple t = queue.poll();
//            TreeNode node = t.node;
//            int r = t.r, c = t.c;
//            res.get(r).set(c, Integer.toString(node.val));
//            if (node.left != null) {
//                queue.offer(new Tuple(node.left, r + 1, c - (1 << (height - r - 1))));
//            }
//            if (node.right != null) {
//                queue.offer(new Tuple(node.right, r + 1, c + (1 << (height - r - 1))));
//            }
//        }
//        return res;
//    }
//
//    public static int calDepth(TreeNode root) {
//        int res = -1;
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int len = queue.size();
//            res++;
//            while (len > 0) {
//                len--;
//                TreeNode t = queue.poll();
//                if (t != null) {
//                    if (t.left != null) {
//                        queue.offer(t.left);
//                    }
//                    if (t.right != null) {
//                        queue.offer(t.right);
//                    }
//                }
//            }
//        }
//        return res;
//    }

    // Method 2: DFS
    private static List<List<String>> printTree(TreeNode root) {
        int height = calDepth(root);
        int m = height + 1;
        int n = (1 << (height + 1)) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("");
            }
            res.add(row);
        }
        dfs(res, root, 0, (n - 1) / 2, height);
        return res;
    }

    public static int calDepth(TreeNode root) {
        int h = 0;
        if (root.left != null) {
            h = Math.max(h, calDepth(root.left) + 1);
        }
        if (root.right != null) {
            h = Math.max(h, calDepth(root.right) + 1);
        }
        return h;
    }

    public static void dfs(List<List<String>> res, TreeNode root, int r, int c, int height) {
        res.get(r).set(c, Integer.toString(root.val));
        if (root.left != null) {
            dfs(res, root.left, r + 1, c - (1 << (height - r - 1)), height);
        }
        if (root.right != null) {
            dfs(res, root.right, r + 1, c + (1 << (height - r - 1)), height);
        }
    }
}
