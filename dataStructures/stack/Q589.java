package dataStructures.stack;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
//
//    Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
//
//    Example 1:
//                   1
//               /   |   \
//              3    2    4
//             / \
//            5   6
//    Input: root = [1,null,3,2,4,null,5,6]
//    Output: [1,3,5,6,2,4]
//    
//    Example 2:
//                  1
//              /  /  \  \
//             2  3   4   5
//               / \  |  / \
//              6  7  8 9  10
//                 |  | |
//                11 12 13
//                 |
//                14
//    Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
//    Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
//
//    Constraints:
//    The number of nodes in the tree is in the range [0, 10^4].
//    0 <= Node.val <= 10^4
//    The height of the n-ary tree is less than or equal to 1000.
//
//    Follow up: Recursive solution is trivial, could you do it iteratively?


//给定一个 n叉树的根节点 root，返回 其节点值的 前序遍历 。
//
//    n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
//
//    示例 1：
//                   1
//               /   |   \
//              3    2    4
//             / \
//            5   6
//    输入：root = [1,null,3,2,4,null,5,6]
//    输出：[1,3,5,6,2,4]
//
//    示例 2：
//                  1
//              /  /  \  \
//             2  3   4   5
//               / \  |  / \
//              6  7  8 9  10
//                 |  | |
//                11 12 13
//                 |
//                14
//    输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
//    输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
//
//    提示：
//    节点总数在范围[0, 10^4]内
//    0 <= Node.val <= 10^4
//    n 叉树的高度小于或等于 1000
//
//    进阶：递归法很简单，你可以使用迭代法完成此题吗?



public class Q589 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] data = cin.nextLine().strip().split(" ");
        cin.close();
        List<Integer> result;
        Node root = new Node(Integer.parseInt(data[0]));
        if (data.length > 2) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            int index = 2;
            int n = data.length;
            while (index < n && !queue.isEmpty()) {
                Node node = queue.poll();
                List<Node> children = new ArrayList<>();
                while (index < n && !data[index].equals("null")) {
                    children.add(new Node(Integer.parseInt(data[index])));
                    index++;
                }
                if (!children.isEmpty()) {
                    node.children = children;
                    for (Node temp : children) {
                        queue.offer(temp);
                    }
                } else {
                    node.children = null;
                }
                index++;
            }
        }
        result = preorder(root);
        OutputMethods.outputListData(result);
    }

    // Method 1: recursively
//    private static List<Integer> preorder(Node root) {
//        List<Integer> result = new ArrayList<>();
//        helper(root, result);
//        return result;
//    }
//
//    private static void helper(Node node, List<Integer> result) {
//        if (node == null) {
//            return;
//        }
//        result.add(node.val);
//        for (Node child : node.children) {
//            helper(child, result);
//        }
//    }

    // Method 2: iteratively + use Stack
    private static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Node, Integer> map = new HashMap<>();
        Deque<Node> stack = new ArrayDeque<>();
        Node node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                List<Node> children = node.children;
                if (children != null && children.size() > 0) {
                    map.put(node, 0);
                    node = children.get(0);
                } else {
                    node = null;
                }
            }
            node = stack.peek();
            if (node != null) {
                int index = map.getOrDefault(node, -1) + 1;
                List<Node> children = node.children;
                if (children != null && children.size() > index) {
                    map.put(node, index);
                    node = children.get(index);
                } else {
                    stack.pop();
                    map.remove(node);
                    node = null;
                }
            }
        }
        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
