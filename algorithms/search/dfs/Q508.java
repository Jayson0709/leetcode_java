package algorithms.search.dfs;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.TreeNode;
import utils.OutputMethods;


//Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.
//
//    The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
//
//    Example 1:
//    Input: root = [5,2,-3]
//    Output: [2,-3,4]
//
//    Example 2:
//    Input: root = [5,2,-5]
//    Output: [2]
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 104].
//    -105 <= Node.val <= 105


//给你一个二叉树的根结点root，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
//
//    一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
//
//    示例 1：
//    输入: root = [5,2,-3]
//    输出: [2,-3,4]
//
//    示例2：
//    输入: root = [5,2,-5]
//    输出: [2]
//
//    提示:
//    节点数在[1, 104]范围内
//    -105<= Node.val <= 105


public class Q508 {
    static Map<Integer, Integer> hMap = new HashMap<>();
    static int max = 0;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode root = new TreeNode();
        root.val = data[0];
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        int[] result = findFrequentTreeSum(root);
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    private static int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int n = list.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int cur = root.val + dfs(root.left) + dfs(root.right);
        hMap.put(cur, hMap.getOrDefault(cur, 0) + 1);
        max = Math.max(max, hMap.get(cur));
        return cur;
    }
}
