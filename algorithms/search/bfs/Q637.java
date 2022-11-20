package algorithms.search.bfs;

import sharedClasses.TreeNode;
import utils.InputMethods;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10^(-5) of the actual answer will be accepted.
//
//    Example 1:
//    Input: root = [3,9,20,null,null,15,7]
//    Output: [3.00000,14.50000,11.00000]
//    Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
//    Hence, return [3, 14.5, 11].
//
//    Example 2:
//    Input: root = [3,9,20,15,7]
//    Output: [3.00000,14.50000,11.00000]
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 10^4].
//    -2^31 <= Node.val <= 2^31 - 1


//给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10^(-5) 以内的答案可以被接受。
//
//    示例 1：
//       3
//      / \
//     9   20
//        /  \
//       15   7
//    输入：root = [3,9,20,null,null,15,7]
//    输出：[3.00000,14.50000,11.00000]
//    解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
//    因此返回 [3, 14.5, 11] 。
//
//    示例 2:
//                3
//               / \
//              9   20
//            /  \
//           15   7
//    输入：root = [3,9,20,15,7]
//    输出：[3.00000,14.50000,11.00000]
//
//    提示：
//    树中节点数量在 [1, 10^4] 范围内
//    -2^31 <= Node.val <= 2^31 - 1


public class Q637 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        int[] data = InputMethods.getInputForOneIntArray();
        for (int val : data) {
            root.insertInBT(root, val);
        }
        System.out.println(averageOfLevels(root));
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            double curSum = 0.0;
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    curSum += node.val;
                }
                if (node != null && node.left != null) {
                    queue.add(node.left);
                }
                if (node != null && node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(curSum / curSize);
        }
        return result;
    }
}
