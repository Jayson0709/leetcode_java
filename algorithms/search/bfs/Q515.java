package algorithms.search.bfs;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
//
//    Example 1:
//           1*
//        3*     2
//    5      3      9*
//
//    Input: root = [1,3,2,5,3,null,9]
//    Output: [1,3,9]
//
//    Example 2:
//    Input: root = [1,2,3]
//    Output: [1,3]
//
//    Constraints:
//    The number of nodes in the tree will be in the range [0, 104].
//    -231 <= Node.val <= 231 - 1


//给定一棵二叉树的根节点root ，请找出该二叉树中每一层的最大值。
//
//    示例1：
//           1*
//        3*     2
//    5      3      9*
//
//    输入: root = [1,3,2,5,3,null,9]
//    输出: [1,3,9]
//
//    示例2：
//    输入: root = [1,2,3]
//    输出: [1,3]
//
//    提示：
//    二叉树的节点个数的范围是 [0,104]
//    -231<= Node.val <= 231- 1


public class Q515 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        List<Integer> result = largestValues(root);
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

    private static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            // Get current level's number of nodes
            int len = treeNodeQueue.size();
            int curMax = Integer.MIN_VALUE;
            // Iterate current level's nodes based on the num
            while (len > 0) {
                TreeNode curNode = treeNodeQueue.poll();
                if (curNode != null) {
                    curMax = Math.max(curNode.val, curMax);
                    if (curNode.left != null) {
                        treeNodeQueue.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        treeNodeQueue.offer(curNode.right);
                    }
                }
                len--;
            }
            result.add(curMax);
        }
        return result;
    }
}
