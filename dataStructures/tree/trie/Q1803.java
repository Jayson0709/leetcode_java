package dataStructures.tree.trie;

import utils.InputMethods;
import utils.OneDIntArrayAndTwoInt;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Q1803 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDIntArrayAndTwoInt obj = InputMethods.getInputFOrOneInt1DArrayAndTwoInt(cin);
        cin.close();
        System.out.println(countPairs(obj.array, obj.val1, obj.val2));
    }

    static class Trie {
        // son[0] -> left son[1] -> right
        Trie[] son = new Trie[2];
        int sum;

        public Trie() {
            sum = 0;
        }
    }

    private static Trie root = null;

    private static final int HIGH_BIT = 14;

    private static int countPairs(int[] nums, int low, int high) {
        return f(nums, high) - f(nums, low - 1);
    }

    public static int f(int[] nums, int x) {
        root = new Trie();
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            res += get(nums[i], x);
        }
        return res;
    }

    public static void add(int num) {
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (cur.son[bit] == null) {
                cur.son[bit] = new Trie();
            }
            cur = cur.son[bit];
            cur.sum++;
        }
    }

    public static int get(int num, int x) {
        Trie cur = root;
        int sum = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int r = (num >> k) & 1;
            if (((x >> k) & 1) != 0) {
                if (cur.son[r] != null) {
                    sum += cur.son[r].sum;
                }
                if (cur.son[r ^ 1] == null) {
                    return sum;
                }
                cur = cur.son[r ^ 1];
            } else {
                if (cur.son[r] == null) {
                    return sum;
                }
                cur = cur.son[r];
            }
        }
        sum += cur.sum;
        return sum;
    }
}