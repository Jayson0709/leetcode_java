package algorithms.search.bfs;

import sharedClasses.TreeNode;
import utils.InputMethods;
import utils.TwoOneDArray;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//
//    Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
//
//    Example 1:
//    Input: p = [1,2,3], q = [1,2,3]
//    Output: true
//
//    Example 2:
//    Input: p = [1,2], q = [1,null,2]
//    Output: false
//
//    Example 3:
//    Input: p = [1,2,1], q = [1,1,2]
//    Output: false
//
//    Constraints:
//    The number of nodes in both trees is in the range [0, 100].
//    -104 <= Node.val <= 104


//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
//    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
//    示例 1：
//    输入：p = [1,2,3], q = [1,2,3]
//    输出：true
//
//    示例 2：
//    输入：p = [1,2], q = [1,null,2]
//    输出：false
//
//    示例 3：
//    输入：p = [1,2,1], q = [1,1,2]
//    输出：false
//
//    提示：
//    两棵树上的节点数目都在范围 [0, 100] 内
//    -104 <= Node.val <= 104



public class Q100 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDArray obj = InputMethods.getTwoInt1DArrayInput(cin);
        TreeNode p = InputMethods.getInputForOneBinaryTree(obj.array1);
        TreeNode q = InputMethods.getInputForOneBinaryTree(obj.array2);
        cin.close();
        boolean result = isSameTree(p, q);
        System.out.println(result);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null & q == null) {
                continue;
            }
            if ((p == null || q == null) || p.val != q.val) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.left);
            queue.offer(p.right);
            queue.offer(q.right);
        }
        return true;
    }
}
