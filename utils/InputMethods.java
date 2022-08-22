package utils;

import sharedClasses.TreeNode;

import java.nio.charset.StandardCharsets;
import java.util.*;


public class InputMethods {
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

    public static void getInputForIntArrayList(Scanner cin, List<int[]> list) {
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            list.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        cin.close();
    }

    public static OneDArrayAndOneInt get1DArrayAndOneIntInput() {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] array = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int val = cin.nextInt();
        cin.close();
        return new OneDArrayAndOneInt(array, val);
    }

    public static OneDArrayAndTwoInt get1DArrayAndTwoIntInput() {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] array = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int val1 = cin.nextInt();
        int val2 = cin.nextInt();
        cin.close();
        return new OneDArrayAndTwoInt(array, val1, val2);
    }
}
