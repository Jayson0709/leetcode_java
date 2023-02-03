package algorithms.search.dfs;

import sharedClasses.TreeNode;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//Two players play a turn based game on a binary tree. We are given the root of this binary tree, and the number of nodes n in the tree. n is odd, and each node has a distinct value from 1 to n.
//
//    Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x. The first player colors the node with value x red, and the second player colors the node with value y blue.
//
//    Then, the players take turns starting with the first player. In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)
//
//    If (and only if) a player cannot choose such a node in this way, they must pass their turn. If both players pass their turn, the game ends, and the winner is the player that colored more nodes.
//
//    You are the second player. If it is possible to choose such a y to ensure you win the game, return true. If it is not possible, return false.
//
//    Example 1:
//                  1
//             /         \
//            2           3
//          /   \       /   \
//         4     5     6     7
//        / \   / \
//       8  9  10  11
//    Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
//    Output: true
//    Explanation: The second player can choose the node with value 2.
//
//    Example 2:
//    Input: root = [1,2,3], n = 3, x = 1
//    Output: false
//
//    Constraints:
//    The number of nodes in the tree is n.
//    1 <= x <= n <= 100
//    n is odd.
//    1 <= Node.val <= n
//    All the values of the tree are unique.


//有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。
//
//    最开始时：
//
//    「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
//    「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
//    「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。
//
//    之后两位玩家轮流进行操作，「一号」玩家先手。每一回合，玩家选择一个被他染过色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色（「一号」玩家染红色，「二号」玩家染蓝色）。
//
//    如果（且仅在此种情况下）当前玩家无法找到这样的节点来染色时，其回合就会被跳过。
//
//    若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
//
//    现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true ；若无法获胜，就请返回 false 。
//
//    示例 1 ：
//                  1
//             /         \
//            2           3
//          /   \       /   \
//         4     5     6     7
//        / \   / \
//       8  9  10  11
//    输入：root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
//    输出：true
//    解释：第二个玩家可以选择值为 2 的节点。
//
//    示例 2 ：
//    输入：root = [1,2,3], n = 3, x = 1
//    输出：false
//
//    提示：
//    树中节点数目为 n
//    1 <= x <= n <= 100
//    n 是奇数
//    1 <= Node.val <= n
//    树中所有值 互不相同


public class Q1145 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TreeNode root = InputMethods.getInputForOneBinaryTree(cin);
        int n = Integer.parseInt(cin.nextLine().strip());
        int x = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        System.out.println(btreeGameWinningMove(root, n, x));
    }

    static TreeNode xNode;

    private static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        find(root, x);
        int leftSize = getSubtreeSize(xNode.left);
        if (leftSize >= (n + 1) / 2) {
            return true;
        }
        int rightSize = getSubtreeSize(xNode.right);
        if (rightSize >= (n + 1) / 2) {
            return true;
        }
        int remain = n - 1 - leftSize - rightSize;
        return remain >= (n + 1) / 2;
    }

    public static void find(TreeNode node, int x) {
        if (xNode != null || node == null) {
            return;
        }
        if (node.val == x) {
            xNode = node;
            return;
        }
        find(node.left, x);
        find(node.right, x);
    }

    public static int getSubtreeSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSubtreeSize(node.left) + getSubtreeSize(node.right);
    }
}
