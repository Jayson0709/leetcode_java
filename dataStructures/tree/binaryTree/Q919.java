package dataStructures.tree.binaryTree;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.TreeNode;
import utils.*;


//A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
//
//    Design an algorithm to insert a new node to a complete binary tree keeping it complete after the insertion.
//
//    Implement the CBTInserter class:
//
//    CBTInserter(TreeNode root) Initializes the data structure with the root of the complete binary tree.
//    int insert(int v) Inserts a TreeNode into the tree with value Node.val == val so that the tree remains complete, and returns the value of the parent of the inserted TreeNode.
//    TreeNode get_root() Returns the root node of the tree.
//
//    Example 1:
//         1            1                   1
//        /     ->     / \      ->         / \
//       2            2   3               2   3
//                                       /
//                                      4
//    Input
//    ["CBTInserter", "insert", "insert", "get_root"]
//    [[[1, 2]], [3], [4], []]
//    Output
//    [null, 1, 2, [1, 2, 3, 4]]
//
//    Explanation
//    CBTInserter cBTInserter = new CBTInserter([1, 2]);
//    cBTInserter.insert(3);  // return 1
//    cBTInserter.insert(4);  // return 2
//    cBTInserter.get_root(); // return [1, 2, 3, 4]
//
//    Constraints:
//    The number of nodes in the tree will be in the range [1, 1000].
//    0 <= Node.val <= 5000
//    root is a complete binary tree.
//    0 <= val <= 5000
//    At most 10^4 calls will be made to insert and get_root.



//完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
//
//    设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
//
//    实现 CBTInserter 类:
//        CBTInserter(TreeNode root)使用头节点为root的给定树初始化该数据结构；
//        CBTInserter.insert(int v) 向树中插入一个值为Node.val == val的新节点TreeNode。使树保持完全二叉树的状态，并返回插入节点TreeNode的父节点的值；
//        CBTInserter.get_root() 将返回树的头节点。
//
//    示例 1：
//         1            1                   1
//        /     ->     / \      ->         / \
//       2            2   3               2   3
//                                       /
//                                      4
//    输入
//    ["CBTInserter", "insert", "insert", "get_root"]
//    [[[1, 2]], [3], [4], []]
//    输出
//    [null, 1, 2, [1, 2, 3, 4]]
//
//    解释
//    CBTInserter cBTInserter = new CBTInserter([1, 2]);
//    cBTInserter.insert(3);  // 返回 1
//    cBTInserter.insert(4);  // 返回 2
//    cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
//
//    提示：
//    树中节点数量范围为[1, 1000]
//    0 <= Node.val <= 5000
//    root是完全二叉树
//    0 <= val <= 5000
//    每个测试用例最多调用insert和get_root操作10^4次



public class Q919 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("CBTInserter")) {
            output.append("null");
            int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
            TreeNode root = new TreeNode(data[0]);
            for (int i = 1; i < data.length; i++) {
                root.insertInBT(root, data[i]);
            }
            CBTInserter obj = new CBTInserter(root);
            for (int i = 1; i < orders.length; i++) {
                if (orders[i].equals("insert")) {
                    int val = Integer.parseInt(cin.nextLine());
                    output.append(", ").append(obj.insert(val));
                } else if (orders[i].equals("get_root")) {
                    output.append(", ").append(OutputMethods.levelOrderTraversalOutput(obj.get_root()));
                }
            }
        }
        cin.close();
        output.append("]");
        System.out.println(output);
    }
}

class CBTInserter {
    TreeNode root;
    Queue<TreeNode> candidate;
    public CBTInserter(TreeNode root) {
        this.candidate = new ArrayDeque<>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // BFS
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (!(node.left != null && node.right != null)) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int result;
        if (node != null) {
            result = node.val;
            if (node.left == null) {
                node.left = child;
            } else if (node.right == null) {
                node.right = child;
                candidate.poll();
            }
            candidate.offer(child);
        } else {
            result = -1;
        }
        return result;
    }

    public TreeNode get_root() {
        return root;
    }
}
