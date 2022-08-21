package dataStructures.tree.binaryTree;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.TreeNode;


//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
//
//    Example 1:
//        3
//       /  \
//      9    20
//           / \
//          15   7
//    Input: root = [3,9,20,null,null,15,7]
//    Output: [[3],[9,20],[15,7]]
//
//    Example 2:
//    Input: root = [1]
//    Output: [[1]]
//
//    Example 3:
//    Input: root = []
//    Output: []
//
//    Constraints:
//    The number of nodes in the tree is in the range [0, 2000].
//    -1000 <= Node.val <= 1000



//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//    示例 1：
//        3
//       /  \
//      9    20
//           / \
//          15   7
//    输入：root = [3,9,20,null,null,15,7]
//    输出：[[3],[9,20],[15,7]]
//
//    示例 2：
//    输入：root = [1]
//    输出：[[1]]
//
//    示例 3：
//    输入：root = []
//    输出：[]
//
//    提示：
//    树中节点数目在范围 [0, 2000] 内
//    -1000 <= Node.val <= 1000


public class Q102 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }

        List<List<Integer>> result = levelOrder(root);
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            List<Integer> levelData = result.get(i);
            if (i == 0) {
                System.out.print("[");
            } else {
                System.out.print(", [");
            }
            printOutData(levelData);
            System.out.print("]");

        }
        System.out.print("]");
    }

    private static void printOutData(List<Integer> levelData) {
        for (int j = 0; j < levelData.size(); j++) {
            if (j == 0) {
                System.out.print(levelData.get(j));
            } else {
                System.out.print(", " + levelData.get(j));
            }
        }
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int count = nodes.size();
            List<Integer> curLevelData = new ArrayList<>();
            while (count > 0) {
                TreeNode node = nodes.poll();
                if (node != null) {
                    curLevelData.add(node.val);
                    if (node.left != null) {
                        nodes.offer(node.left);
                    }
                    if (node.right != null) {
                        nodes.offer(node.right);
                    }
                }
                count--;
            }
            result.add(curLevelData);
        }
        return result;
    }
}
