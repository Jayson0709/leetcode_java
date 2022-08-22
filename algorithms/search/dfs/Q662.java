package algorithms.search.dfs;

import sharedClasses.TreeNode;
import utils.*;

import java.util.HashMap;
import java.util.Map;


//Given the root of a binary tree, return the maximum width of the given tree.
//
//    The maximum width of a tree is the maximum width among all levels.
//
//    The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
//
//    It is guaranteed that the answer will in the range of a 32-bit signed integer.
//
//    Example 1:
//        1
//       /  \
//      3     2
//     / \     \
//    5   3     9
//    Input: root = [1,3,2,5,3,null,9]
//    Output: 4
//    Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
//
//    Example 2:
//                   1
//                  / \
//                 3   2
//                /     \
//               5       9
//              /       /
//             6       7
//    Input: root = [1,3,2,5,null,null,9,6,null,7]
//    Output: 7
//    Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
//
//    Example 3:
//        1
//       / \
//      3   2
//     /
//    5
//    Input: root = [1,3,2,5]
//    Output: 2
//    Explanation: The maximum width exists in the second level with length 2 (3,2).
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 3000].
//    -100 <= Node.val <= 100



//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
//
//    每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
//
//    示例 1:
//    输入:
//
//        1
//       /  \
//      3     2
//     / \     \
//    5   3     9
//    输出: 4
//    解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
//
//    示例 2:
//    输入:
//
//        1
//       /
//      3
//     / \
//    5   3
//    输出: 2
//    解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
//
//    示例 3:
//    输入:
//        1
//       / \
//      3   2
//     /
//    5
//    输出: 2
//    解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
//
//    示例 4:
//    输入:
//
//          1
//         / \
//        3   2
//       /     \
//      5       9
//     /         \
//    6           7
//    输出: 8
//    解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
//    注意: 答案在32位有符号整数的表示范围内。


public class Q662 {
    public static void main(String[] args) {
        TreeNode root = InputMethods.getInputForOneTree();
        System.out.println(widthOfBinaryTree(root));
    }

    // Method 1: BFS
//    private static int widthOfBinaryTree(TreeNode root) {
//        Queue<AnnotatedNode> queue = new LinkedList<>();
//        queue.add(new AnnotatedNode(root, 0, 0));
//        int curDepth = 0, left = 0, res = 0;
//        while (!queue.isEmpty()) {
//            AnnotatedNode temp = queue.poll();
//            if (temp.node != null) {
//                queue.add(new AnnotatedNode(temp.node.left, temp.depth + 1, temp.pos * 2));
//                queue.add(new AnnotatedNode(temp.node.right, temp.depth + 1, temp.pos * 2 + 1));
//                if (curDepth != temp.depth) {
//                    curDepth = temp.depth;
//                    left = temp.pos;
//                }
//                res = Math.max(res, temp.pos - left + 1);
//            }
//        }
//        return res;
//    }

    // Method 2: DFS
    static int res;
    static Map<Integer, Integer> left;
    private static int widthOfBinaryTree(TreeNode root) {
        res = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return res;
    }

    private static void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        left.putIfAbsent(depth, pos);
        res = Math.max(res, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}

//class AnnotatedNode {
//    TreeNode node;
//    int depth, pos;
//
//    AnnotatedNode (TreeNode node, int d, int p) {
//        this.node = node;
//        depth = d;
//        pos = p;
//    }
//}