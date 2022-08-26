package utils;

import sharedClasses.ListNode;
import sharedClasses.TreeNode;

import java.util.*;


public class OutputMethods {

    public static <T> StringBuilder formatListOutputData(List<T> list) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                res.append(list.get(i));
            } else {
                res.append(", ").append(list.get(i));
            }
        }
        res.append("]");
        return res;
    }

    public static <T> StringBuilder formatNestedListOutputData(List<List<T>> list) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                res.append(formatListOutputData(list.get(i)));
            } else {
                res.append(", ").append(formatListOutputData(list.get(i)));
            }
        }
        res.append("]");
        return res;
    }

    public static <T> StringBuilder format1DArrayOutputData(T[] array) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                res.append(array[i]);
            } else {
                res.append(", ").append(array[i]);
            }
        }
        res.append("]");
        return res;
    }

    public static void format2DIntArrayOutputData(int[][] array) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                res.append(format1DArrayOutputData(Arrays.stream(array[i]).boxed().toArray(Integer[]::new)));
            } else {
                res.append(", ").append(Arrays.toString(Arrays.stream(array[i]).boxed().toArray(Integer[]::new)));
            }
        }
        res.append("]");
        System.out.println(res);
    }

    public static StringBuilder formatLinkedListOutputData(ListNode head) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        res.append(head.val);
        head = head.next;
        while (head != null) {
            res.append(", ").append(head.val);
            head = head.next;
        }
        res.append("]");
        return res;
    }

    public static StringBuilder formatLevelOrderTreeTraversalOutputData(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
        }
        StringBuilder output = new StringBuilder();
        output.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            output.append(node.val).append(", ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        output.delete(output.length() - 2, output.length());
        output.append("]");
        return output;
    }

    public static StringBuilder formatInorderTreeTraversalOutputData(TreeNode root) {
        StringBuilder output = new StringBuilder();
        output.append("[");
        Deque<TreeNode> stack = new LinkedList<>();
        int i = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            output.append(", ").append(root.val);
            if (i == 0) {
                i++;
            }
            root = root.right;
        }
        output.append("]");
        output.delete(1, 3);
        return output;
    }
}
