package algorithms.search.dfs;

import sharedClasses.TreeNode;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//Given the root of a binary tree, return all duplicate subtrees.
//
//    For each kind of duplicate subtrees, you only need to return the root node of any one of them.
//
//    Two trees are duplicate if they have the same structure with the same node values.
//    
//    Example 1:
//               1
//             /   \
//            2     3
//           /    /   \
//          4    2     4
//              /
//             4
//    Input: root = [1,2,3,4,null,2,4,null,null,4]
//    Output: [[2,4],[4]]
//    
//    Example 2:
//             2
//           /   \
//          1     1
//    Input: root = [2,1,1]
//    Output: [[1]]
//    
//    Example 3:
//              2
//            /   \
//           2     2
//          /     /
//         3     3
//    Input: root = [2,2,2,3,null,3,null]
//    Output: [[2,3],[3]]
//    
//    Constraints:
//    The number of the nodes in the tree will be in the range [1, 10^4]
//    -200 <= Node.val <= 200



//给定一棵二叉树 root，返回所有重复的子树。
//
//    对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
//    如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
//
//    示例 1：
//               1
//             /   \
//            2     3
//           /    /   \
//          4    2     4
//              /
//             4
//    输入：root = [1,2,3,4,null,2,4,null,null,4]
//    输出：[[2,4],[4]]
//
//    示例 2：
//             2
//           /   \
//          1     1
//    输入：root = [2,1,1]
//    输出：[[1]]
//
//    示例 3：
//              2
//            /   \
//           2     2
//          /     /
//         3     3
//    输入：root = [2,2,2,3,null,3,null]
//    输出：[[2,3],[3]]
//
//    提示：
//    树中的结点数在[1,10^4]范围内。
//    -200 <= Node.val <= 200



public class Q652 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        cin.close();
        List<TreeNode> result = findDuplicateSubtrees(root);
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            if (i == 0) {
                System.out.print(result.get(i).val);
            } else {
                System.out.print(", " + result.get(i).val);
            }
        }
        System.out.print("]");
    }

    static Map<String, TreeNode> visited = new HashMap<>();
    static Set<TreeNode> repeat = new HashSet<>();
    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(repeat);
    }

    private static String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(dfs(node.left));
        sb.append(")(");
        sb.append(dfs(node.right));
        sb.append(")");
        String serial = sb.toString();
        if (visited.containsKey(serial)) {
            repeat.add(visited.get(serial));
        } else {
            visited.put(serial, node);
        }
        return serial;
    }
}
