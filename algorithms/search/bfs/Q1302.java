package algorithms.search.bfs;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given the root of a binary tree, return the sum of values of its deepest leaves.
//
//    Example 1:
//                   1
//                /     \
//               2       3
//              / \       \
//             4   5       6
//            /             \
//           7               8
//    Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//    Output: 15
//
//    Example 2:
//    Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//    Output: 19
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 10^4].
//    1 <= Node.val <= 100



//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
//
//    示例 1：
//                   1
//                /     \
//               2       3
//              / \       \
//             4   5       6
//            /             \
//           7               8
//    输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//    输出：15
//
//    示例 2：
//    输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//    输出：19
//
//    提示：
//    树中节点数目在范围 [1, 10^4] 之间。
//    1 <= Node.val <= 100



public class Q1302 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        cin.close();
        System.out.println(deepestLeavesSum(root));
    }

    // Method 1: DFS
//    static int maxLevel = -1;
//    static int sum = 0;
//
//    public static int deepestLeavesSum(TreeNode root) {
//        dfs(root, 0);
//        return sum;
//    }
//
//    public static void dfs(TreeNode node, int level) {
//        if (node == null) {
//            return;
//        }
//        if (level > maxLevel) {
//            maxLevel = level;
//            sum = node.val;
//        } else if (level == maxLevel) {
//            sum += node.val;
//        }
//        dfs(node.left, level + 1);
//        dfs(node.right, level + 1);
//    }


    // Method 2: BFS
    private static int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sum += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return sum;
    }
}
