package dataStructures.tree.binaryTree;

import sharedClasses.TreeNode;
import utils.InputMethods;
import utils.OneDArrayAndOneInt;
import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//A maximum tree is a tree where every node has a value greater than any other value in its subtree.
//
//    You are given the root of a maximum binary tree and an integer val.
//
//    Just as in the previous problem, the given tree was constructed from a list a (root = Construct(a)) recursively with the following Construct(a) routine:
//
//    If 'a' is empty, return null.
//    Otherwise, let a[i] be the largest element of 'a'. Create a root node with the value a[i].
//    The left child of root will be Construct([a[0], a[1], ..., a[i - 1]]).
//    The right child of root will be Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]).
//    Return root.
//    Note that we were not given a directly, only a root node root = Construct(a).
//
//    Suppose b is a copy of a with the value val appended to it. It is guaranteed that b has unique values.
//
//    Return Construct(b).
//
//    Example 1:
//             4                   5
//           /   \                /
//          1     3              4
//               /              / \
//              2              1   3
//                                /
//                               2
//    Input: root = [4,1,3,null,null,2], val = 5
//    Output: [5,4,null,1,3,null,null,2]
//    Explanation: a = [1,4,2,3], b = [1,4,2,3,5]
//    
//    Example 2:
//            5               5
//           / \            /   \
//          2   4          2     4
//           \              \     \
//            1              1     3
//    Input: root = [5,2,4,null,1], val = 3
//    Output: [5,2,4,null,1,null,3]
//    Explanation: a = [2,1,5,4], b = [2,1,5,4,3]
//    
//    Example 3:
//            5                 5
//          /   \             /   \
//         2     3           2     4
//          \                 \   /
//           1                 1 3
//    Input: root = [5,2,3,null,1], val = 4
//    Output: [5,2,4,null,1,3]
//    Explanation: a = [2,1,5,3], b = [2,1,5,3,4]
//
//    Constraints:
//    The number of nodes in the tree is in the range [1, 100].
//    1 <= Node.val <= 100
//    All the values of the tree are unique.
//    1 <= val <= 100



//最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
//
//    给你最大树的根节点 root 和一个整数 val 。
//
//    就像 之前的问题 那样，给定的树是利用 Construct(a) 例程从列表 a（root = Construct(a)）递归地构建的：
//
//    如果 a 为空，返回 null 。
//    否则，令 a[i] 作为 a 的最大元素。创建一个值为 a[i] 的根节点 root 。
//    root 的左子树将被构建为 Construct([a[0], a[1], ..., a[i - 1]]) 。
//    root 的右子树将被构建为 Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
//    返回 root 。
//    请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。
//
//    假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
//
//    返回 Construct(b) 。
//
//    示例 1：
//             4                   5
//           /   \                /
//          1     3              4
//               /              / \
//              2              1   3
//                                /
//                               2
//    输入：root = [4,1,3,null,null,2], val = 5
//    输出：[5,4,null,1,3,null,null,2]
//    解释：a = [1,4,2,3], b = [1,4,2,3,5]
//
//    示例 2：
//            5               5
//           / \            /   \
//          2   4          2     4
//           \              \     \
//            1              1     3
//    输入：root = [5,2,4,null,1], val = 3
//    输出：[5,2,4,null,1,null,3]
//    解释：a = [2,1,5,4], b = [2,1,5,4,3]
//
//    示例 3：
//            5                 5
//          /   \             /   \
//         2     3           2     4
//          \                 \   /
//           1                 1 3
//    输入：root = [5,2,3,null,1], val = 4
//    输出：[5,2,4,null,1,3]
//    解释：a = [2,1,5,3], b = [2,1,5,3,4]
//
//    提示：
//    树中节点数目在范围 [1, 100] 内
//    1 <= Node.val <= 100
//    树中的所有值 互不相同
//    1 <= val <= 100



public class Q998 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        cin.close();
        TreeNode resultNode = insertIntoMaxTree(InputMethods.getInputForOneBinaryTree(obj.array), obj.val);
        System.out.println(OutputMethods.formatLevelOrderTreeTraversalOutputData(resultNode));
    }

    private static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (parent == null) {
                    return new TreeNode(val, root, null);
                }
                parent.right = new TreeNode(val, cur, null);
                return root;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        if (parent != null) {
            parent.right = new TreeNode(val);
        }
        return root;
    }
}
