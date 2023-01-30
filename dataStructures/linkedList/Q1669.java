package dataStructures.linkedList;

import sharedClasses.ListNode;
import utils.DataConversionMethods;
import utils.InputMethods;
import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given two linked lists: list1 and list2 of sizes n and m respectively.
//
//    Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
//
//    Build the result list and return its head.
//
//    Example 1:
//    Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
//    Output: [0,1,2,1000000,1000001,1000002,5]
//    Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
//
//    Example 2:
//    Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
//    Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
//    Explanation: The blue edges and nodes in the above figure indicate the result.
//
//    Constraints:
//    3 <= list1.length <= 10^4
//    1 <= a <= b < list1.length - 1
//    1 <= list2.length <= 10^4


//给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
//
//    请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
//
//    请你返回结果链表的头指针。
//
//    示例 1：
//    输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
//    输出：[0,1,2,1000000,1000001,1000002,5]
//    解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
//
//    示例 2：
//    输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
//    输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
//    解释：上图中蓝色的边和节点为答案链表。
//
//    提示：
//    3 <= list1.length <= 10^4
//    1 <= a <= b < list1.length - 1
//    1 <= list2.length <= 10^4


public class Q1669 {
    public static void main(String[] args) {
        ListNode list1 = DataConversionMethods.convert1DArrayToLinkedList(InputMethods.getInputForOneIntArray());
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int a = Integer.parseInt(cin.nextLine().strip());
        int b = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        ListNode list2 = DataConversionMethods.convert1DArrayToLinkedList(InputMethods.getInputForOneIntArray());
        System.out.println(OutputMethods.formatLinkedListOutputData(mergeInBetween(list1, a, b, list2)));
    }

    private static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode preA = list1;
        for (int i = 0; i < a - 1; i++) {
            preA = preA.next;
        }
        ListNode preB = preA;
        for (int i = 0; i < b - a + 2; i++) {
            preB = preB.next;
        }
        preA.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = preB;
        return list1;
    }
}
