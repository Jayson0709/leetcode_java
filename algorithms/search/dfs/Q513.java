package algorithms.search.dfs;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given the root of a binary tree, return the leftmost value in the last row of the tree.
//
//    Example 1:
//       2
//    1    3
//    Input: root = [2,1,3]
//    Output: 1
//    
//    Example 2:
//    Input: root = [1,2,3,4,null,5,6,null,null,7]
//    Output: 7
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 104].
//    -231 <= Node.val <= 231 - 1

//给定一个二叉树的 根节点 root，请找出该二叉树的最底层最左边节点的值。
//
//    假设二叉树中至少有一个节点。
//
//    示例 1:
//       2
//    1    3
//    输入: root = [2,1,3]
//    输出: 1
//
//    示例 2:
//    输入: [1,2,3,4,null,5,6,null,null,7]
//    输出: 7
//
//    提示:
//    二叉树的节点个数的范围是 [1,104]
//    -231<= Node.val <= 231- 1


public class Q513 {
    static int curVal = 0;
    static int curHeight = 0;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        int result = findBottomLeftValue(root);
        System.out.println(result);
    }

    private static int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return curVal;
    }

    private static void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
    }
}
