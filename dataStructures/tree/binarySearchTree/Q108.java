package dataStructures.tree.binarySearchTree;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
//
//    A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
//
//    Example 1:
//             0
//           /   \
//          -3   9
//         /    /
//       -10   5
//    Input: nums = [-10,-3,0,5,9]
//    Output: [0,-3,9,-10,null,5]
//    Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//           0
//         /   \
//       -10    5
//          \    \
//          -3    9
//
//    Example 2:
//       3          1
//      /      or    \
//     1              3
//    Input: nums = [1,3]
//    Output: [3,1]
//    Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
//
//    Constraints:
//    1 <= nums.length <= 10^4
//    -10^4 <= nums[i] <= 10^4
//    nums is sorted in a strictly increasing order.



//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
//
//    高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
//
//    示例 1：
//             0
//           /   \
//          -3   9
//         /    /
//       -10   5
//    输入：nums = [-10,-3,0,5,9]
//    输出：[0,-3,9,-10,null,5]
//    解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//           0
//         /   \
//       -10    5
//          \    \
//          -3    9
//
//    示例 2：
//       3          1
//      /      or    \
//     1              3
//    输入：nums = [1,3]
//    输出：[3,1]
//    解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
//
//    提示：
//    1 <= nums.length <= 10^4
//    -10^4 <= nums[i] <= 10^4
//    nums 按 严格递增 顺序排列




public class Q108 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode resultNode = sortedArrayToBST(nums);
        levelOrderTraversal(resultNode);
    }

    private static void levelOrderTraversal(TreeNode root) {
        StringBuilder output = new StringBuilder();
        if (root == null) {
            System.out.println("[]");
        } else {
            output.append("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                output.append(node.val).append(", ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            output.delete(output.length() - 2, output.length());
            output.append("]");
            System.out.println(output);
        }
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // always choose the mid-point
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
