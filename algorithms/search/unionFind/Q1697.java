package algorithms.search.unionFind;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Q1697 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = Integer.parseInt(cin.nextLine().strip());
        List<int[]> data1 = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data1);
        List<int[]> data2 = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data2);
        cin.close();
        System.out.println(Arrays.toString(distanceLimitedPathsExist(n,
            DataConversionMethods.convertIntArrArrayListTo2DArray(data1),
            DataConversionMethods.convertIntArrArrayListTo2DArray(data2))));
    }

    private static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(a -> queries[a][2]));

        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        boolean[] res = new boolean[queries.length];
        int k = 0;
        for (int i : index) {
            while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                merge(uf, edgeList[k][0], edgeList[k][1]);
                k++;
            }
            res[i] = find(uf, queries[i][0]) == find(uf, queries[i][1]);
        }
        return res;
    }

    public static int find(int[] uf, int x) {
        if (uf[x] == x) {
            return x;
        }
        return uf[x] = find(uf, uf[x]);
    }

    public static void merge(int[] uf, int x, int y) {
        x = find(uf, x);
        y = find(uf, y);
        uf[y] = x;
    }
}
