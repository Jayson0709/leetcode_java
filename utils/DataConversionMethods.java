package utils;

import sharedClasses.*;

import java.util.List;


public class DataConversionMethods {

    public static String[] convertStringArrayListTo1DArray(List<String> list) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static int[][] convertIntArrArrayListTo2DArray(List<int[]> list) {
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static ListNode convert1DArrayToLinkedList(int[] data) {
        ListNode head = new ListNode(data[0]);
        ListNode tempHead = head;
        for (int i = 1; i < data.length; i++) {
            ListNode tempNode = new ListNode(data[i]);
            tempHead.next = tempNode;
            tempHead = tempNode;
        }
        return head;
    }
}
