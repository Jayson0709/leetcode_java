package utils;

import sharedClasses.TreeNode;

import java.nio.charset.StandardCharsets;
import java.util.*;


public class InputMethods {
    public static TreeNode getInputForOneBinaryTree(Scanner cin) {
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        return root;
    }

    public static TreeNode getInputForOneBinaryTree(int[] data) {
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insertInBT(root, data[i]);
        }
        return root;
    }

    public static int[] getInputForOneIntArray() {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        return data;
    }

    public static void getInputForStringArrayList(Scanner cin, List<String> list) {
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            list.add(line);
        }
    }

    public static void getInputForStringArrArrayList(Scanner cin, List<String[]> list) {
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            list.add(line.split(" "));
        }
    }

    public static void getInputForNestedStringArrayList(Scanner cin, List<List<String>> list) {
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            List<String> temp = Arrays.asList(line.split(" "));
            list.add(temp);
        }
    }

    public static void getInputForIntArrArrayList(Scanner cin, List<int[]> list) {
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            list.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
    }

    public static TwoIntAndOne2DArray getInputForTwoIntAndOneInt2DArray(Scanner cin) {
        int val1 = Integer.parseInt(cin.nextLine().strip());
        int val2 = Integer.parseInt(cin.nextLine().strip());
        List<int[]> data = new ArrayList<>();
        getInputForIntArrArrayList(cin, data);
        return new TwoIntAndOne2DArray(val1, val2,
            DataConversionMethods.convertIntArrArrayListTo2DArray(data));
    }

    public static OneDIntArrayAndOneInt getInputForOneInt1DArrayAndOneInt(Scanner cin) {
        int[] array = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int val = cin.nextInt();
        return new OneDIntArrayAndOneInt(array, val);
    }

    public static OneDIntArrayAndTwoInt getInputFOrOneInt1DArrayAndTwoInt(Scanner cin) {
        int[] array = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int val1 = cin.nextInt();
        int val2 = cin.nextInt();
        return new OneDIntArrayAndTwoInt(array, val1, val2);
    }

    public static TwoOneDIntArray getInputForTwoInt1DArray(Scanner cin) {
        int[] array1 = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        return new TwoOneDIntArray(array1, array2);
    }

    public static TwoOneDIntArrayAndOneInt getInputForTwoInt1DArrayAndOneInt(Scanner cin) {
        int[] array1 = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int val = cin.nextInt();
        return new TwoOneDIntArrayAndOneInt(array1, array2, val);
    }
}
