package utils;

import sharedClasses.ListNode;
import sharedClasses.TreeNode;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


public class InputMethods {
    public static ListNode getInputForListNode() {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        ListNode head = new ListNode(data[0]);
        ListNode tempHead = head;
        for (int i = 1; i < data.length; i++) {
            ListNode tempNode = new ListNode(data[i]);
            tempHead.next = tempNode;
            tempHead = tempNode;
        }
        return head;
    }

    public static TreeNode getInputForOneTree() {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        return root;
    }
}
