package algorithms.search.dfs;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.TreeNode;


//Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
//
//    Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
//    
//    Example 1:
//           1
//          / \
//         7   0
//        / \
//       7  -8
//    Input: root = [1,7,0,7,-8,null,null]
//    Output: 2
//    Explanation:
//    Level 1 sum = 1.
//    Level 2 sum = 7 + 0 = 7.
//    Level 3 sum = 7 + -8 = -1.
//    So we return the level with the maximum sum which is level 2.
//    
//    Example 2:
//    Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
//    Output: 2
//    
//    Constraints:
//    The number of nodes in the tree is in the range [1, 10^4].
//    -10^5 <= Node.val <= 10^5



//给你一个二叉树的根节点root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
//
//    请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中最小 的那个。
//
//    示例 1：
//           1
//          / \
//         7   0
//        / \
//       7  -8
//    输入：root = [1,7,0,7,-8,null,null]
//    输出：2
//    解释：
//    第 1 层各元素之和为 1，
//    第 2 层各元素之和为 7 + 0 = 7，
//    第 3 层各元素之和为 7 + -8 = -1，
//    所以我们返回第 2 层的层号，它的层内元素之和最大。
//
//    示例 2：
//    输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
//    输出：2
//
//    提示：
//    树中的节点数在[1, 10^4]范围内
//    -10^5<= Node.val <= 10^5



public class Q1161 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        System.out.println(maxLevelSum(root));
    }

    // Method 1: BFS
//    private static int maxLevelSum(TreeNode root) {
//        int result = 1, maxSum = root.val;
//        List<TreeNode> queue = new ArrayList<>();
//        queue.add(root);
//        for (int level = 1; !queue.isEmpty(); level++) {
//            List<TreeNode> levelQueue = new ArrayList<>();
//            int sum = 0;
//            for (TreeNode node : queue) {
//                sum += node.val;
//                if (node.left != null) {
//                    levelQueue.add(node.left);
//                }
//                if (node.right != null) {
//                    levelQueue.add(node.right);
//                }
//            }
//            if (sum > maxSum) {
//                maxSum = sum;
//                result = level;
//            }
//            queue = levelQueue;
//        }
//        return result;
//    }

    // Method 2: DFS
    private static final List<Integer> sum = new ArrayList<>();
    private static int maxLevelSum(TreeNode root) {
        dfs(root, 0);
        int result = 0;
        for (int i = 0; i < sum.size(); i++) {
            if (sum.get(i) > sum.get(result)) {
                result = i;
            }
        }
        return result + 1;
    }

    private static void dfs(TreeNode node, int level) {
        if (level == sum.size()) {
            sum.add(node.val);
        } else {
            sum.set(level, sum.get(level) + node.val);
        }
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }
    }
}
