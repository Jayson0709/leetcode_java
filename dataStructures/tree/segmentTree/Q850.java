package dataStructures.tree.segmentTree;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Q850 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        System.out.println(rectangleArea(DataConversionMethods.convertIntArrArrayListTo2DArray(data)));
        cin.close();
    }

    private static SegmentTree[] tree;
    private static List<Integer> hBound;

    public static int rectangleArea(int[][] rectangles) {
        final int MOD = 1000000007;
        int n = rectangles.length;
        Set<Integer> set = new HashSet<>();
        for (int[] rect : rectangles) {
            set.add(rect[1]);
            set.add(rect[3]);
        }
        hBound = new ArrayList<>(set);
        Collections.sort(hBound);
        int m = hBound.size();
        tree = new SegmentTree[m * 4 + 1];
        init(1, 1, m - 1);

        List<int[]> sweep = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sweep.add(new int[]{rectangles[i][0], i, 1});
            sweep.add(new int[]{rectangles[i][2], i, -1});
        }
        sweep.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        long ans = 0;
        for (int i = 0; i < sweep.size(); ++i) {
            int j = i;
            while (j + 1 < sweep.size() && sweep.get(i)[0] == sweep.get(j + 1)[0]) {
                ++j;
            }
            if (j + 1 == sweep.size()) {
                break;
            }
            for (int k = i; k <= j; ++k) {
                int[] arr = sweep.get(k);
                int idx = arr[1], diff = arr[2];
                int left = binarySearch(hBound, rectangles[idx][1]) + 1;
                int right = binarySearch(hBound, rectangles[idx][3]);
                update(1, 1, m - 1, left, right, diff);
            }
            ans += (long) tree[1].length * (sweep.get(j + 1)[0] - sweep.get(j)[0]);
            i = j;
        }
        return (int) (ans % MOD);
    }

    public static void init(int idx, int l, int r) {
        tree[idx] = new SegmentTree();
        if (l == r) {
            tree[idx].maxLength = hBound.get(l) - hBound.get(l - 1);
            return;
        }
        int mid = (l + r) / 2;
        init(idx * 2, l, mid);
        init(idx * 2 + 1, mid + 1, r);
        tree[idx].maxLength = tree[idx * 2].maxLength + tree[idx * 2 + 1].maxLength;
    }

    public static void update(int idx, int l, int r, int ul, int ur, int diff) {
        if (l > ur || r < ul) {
            return;
        }
        if (ul <= l && r <= ur) {
            tree[idx].cover += diff;
            pushUp(idx, l, r);
            return;
        }
        int mid = (l + r) / 2;
        update(idx * 2, l, mid, ul, ur, diff);
        update(idx * 2 + 1, mid + 1, r, ul, ur, diff);
        pushUp(idx, l, r);
    }

    public static void pushUp(int idx, int l, int r) {
        if (tree[idx].cover > 0) {
            tree[idx].length = tree[idx].maxLength;
        } else if (l == r) {
            tree[idx].length = 0;
        } else {
            tree[idx].length = tree[idx * 2].length + tree[idx * 2 + 1].length;
        }
    }

    public static int binarySearch(List<Integer> hBound, int target) {
        int left = 0, right = hBound.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (hBound.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static class SegmentTree {
        int cover = 0;
        int length = 0;
        int maxLength = 0;
    }
}
