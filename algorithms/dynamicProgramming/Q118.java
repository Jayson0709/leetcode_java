package algorithms.dynamicProgramming;

import utils.OutputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Q118 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int numRows = cin.nextInt();
        cin.close();
        System.out.println(OutputMethods.formatNestedListOutputData(generate(numRows)));
    }

    // Method 1: use Math formula / dynamic programming
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
