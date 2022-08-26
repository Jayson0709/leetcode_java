package dataStructures.tree.binarySearchTree;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.TreeNode;
import utils.*;


//Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
//
//    A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
//
//    Example 1:
//       1                              2                          3
//        \                            /  \                       / \
//         2                          1    3                     1   4
//          \             ->                \         or          \
//           3                               4                     2
//            \
//             4
//    Input: root = [1,null,2,null,3,null,4,null,null]
//    Output: [2,1,3,null,null,null,4]
//    Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
//
//    Example 2:
//         2
//       /   \
//      1     3
//    Input: root = [2,1,3]
//    Output: [2,1,3]
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 10^4].
//    1 <= Node.val <= 10^5



//给你一棵二叉搜索树，请你返回一棵平衡后的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
//
//    如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是平衡的 。
//
//    
//
//    示例 1：
//       1                              2                          3
//        \                            /  \                       / \
//         2                          1    3                     1   4
//          \             ->                \         or          \
//           3                               4                     2
//            \
//             4
//    输入：root = [1,null,2,null,3,null,4,null,null]
//    输出：[2,1,3,null,null,null,4]
//    解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
//
//    示例 2：
//         2
//       /   \
//      1     3
//    输入: root = [2,1,3]
//    输出: [2,1,3]
//
//    提示：
//    树节点的数目在[1, 10^4]范围内。
//    1 <= Node.val <= 10^5


public class Q1382 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBST(root, data[i]);
        }
        TreeNode resultNode = balanceBST(root);
        System.out.println(OutputMethods.formatInorderTreeTraversalOutputData(resultNode));
    }

    static List<Integer> inorderSeq = new ArrayList<>();
    private static TreeNode balanceBST(TreeNode root) {
        getInorder(root);
        return build(0, inorderSeq.size() - 1);
    }

    private static void getInorder(TreeNode node) {
        if (node.left != null) {
            getInorder(node.left);
        }
        inorderSeq.add(node.val);
        if (node.right != null) {
            getInorder(node.right);
        }
    }

    private static TreeNode build(int left, int right) {
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(inorderSeq.get(mid));
        if (left <= mid - 1) {
            node.left = build(left, mid - 1);
        }
        if (right >= mid + 1) {
            node.right = build(mid + 1, right);
        }
        return node;
    }
}



