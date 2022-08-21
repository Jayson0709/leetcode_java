package dataStructures.tree.segmentTree;
import java.util.*;
import java.nio.charset.StandardCharsets;

//A Range Module is a module that tracks ranges of numbers. Design a data structure to track the ranges represented as half-open intervals and query about them.
//
//    A half-open interval [left, right) denotes all the real numbers x where left <= x < right.
//
//    Implement the RangeModule class:
//
//    RangeModule() Initializes the object of the data structure.
//    void addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
//    boolean queryRange(int left, int right) Returns true if every real number in the interval [left, right) is currently being tracked, and false otherwise.
//    void removeRange(int left, int right) Stops tracking every real number currently being tracked in the half-open interval [left, right).
//
//    Example 1:
//    Input
//    ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
//    [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
//    Output
//    [null, null, null, true, false, true]
//
//    Explanation
//    RangeModule rangeModule = new RangeModule();
//    rangeModule.addRange(10, 20);
//    rangeModule.removeRange(14, 16);
//    rangeModule.queryRange(10, 14); // return True,(Every number in [10, 14) is being tracked)
//    rangeModule.queryRange(13, 15); // return False,(Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
//    rangeModule.queryRange(16, 17); // return True, (The number 16 in [16, 17) is still being tracked, despite the remove operation)
//
//    Constraints:
//    1 <= left < right <= 109
//    At most 104 calls will be made to addRange, queryRange, and removeRange.


//Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。
//
//    半开区间[left, right)表示所有left <= x < right的实数 x 。
//
//    实现 RangeModule 类:
//
//    RangeModule()初始化数据结构的对象。
//    void addRange(int left, int right) 添加 半开区间[left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间[left, right)中尚未跟踪的任何数字到该区间中。
//    boolean queryRange(int left, int right)只有在当前正在跟踪区间[left, right)中的每一个实数时，才返回 true，否则返回 false 。
//    void removeRange(int left, int right)停止跟踪 半开区间[left, right)中当前正在跟踪的每个实数。
//
//    示例 1：
//    输入
//    ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
//    [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
//    输出
//    [null, null, null, true, false, true]
//
//    解释
//    RangeModule rangeModule = new RangeModule();
//    rangeModule.addRange(10, 20);
//    rangeModule.removeRange(14, 16);
//    rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
//    rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
//    rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
//
//    提示：
//    1 <= left < right <= 109
//    在单个测试用例中，对addRange、 queryRange和 removeRange 的调用总数不超过104次


public class Q715 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        List<int[]> rangePairs = new ArrayList<>();
        cin.nextLine();
        for (int i = 1; i < orders.length; i++) {
            rangePairs.add(Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        cin.close();
        RangeModule obj = new RangeModule();
        System.out.print("[null");
        for (int i = 0; i < rangePairs.size(); i++) {
            String curOrder = orders[i + 1];
            int[] curPair = rangePairs.get(i);
            switch (curOrder) {
                case "addRange" -> {
                    obj.addRange(curPair[0], curPair[1]);
                    System.out.print(", null");
                }
                case "removeRange" -> {
                    obj.removeRange(curPair[0], curPair[1]);
                    System.out.print(", null");
                }
                case "queryRange" -> {
                    boolean result = obj.queryRange(curPair[0], curPair[1]);
                    System.out.print(", " + result);
                }
            }
        }
        System.out.print("]");
    }
}

// Method 1 - a: Segment Tree (Array-based)
//class RangeModule {
//    static class Node {
//        int ls, rs, sum, add;
//    }
//    int N = (int)1e9 + 10, M = 500010, cnt = 1;
//    Node[] tr = new Node[M];
//    void update(int u, int lc, int rc, int l, int r, int v) {
//        int len = rc - lc + 1;
//        if (l <= lc && rc <= r) {
//            tr[u].sum = v == 1 ? len : 0;
//            tr[u].add = v;
//            return ;
//        }
//        pushDown(u, len);
//        int mid = lc + rc >> 1;
//        if (l <= mid) update(tr[u].ls, lc, mid, l, r, v);
//        if (r > mid) update(tr[u].rs, mid + 1, rc, l, r, v);
//        pushUp(u);
//    }
//    int query(int u, int lc, int rc, int l, int r) {
//        if (l <= lc && rc <= r) return tr[u].sum;
//        pushDown(u, rc - lc + 1);
//        int mid = lc + rc >> 1, ans = 0;
//        if (l <= mid) ans = query(tr[u].ls, lc, mid, l, r);
//        if (r > mid) ans += query(tr[u].rs, mid + 1, rc, l, r);
//        return ans;
//    }
//    void pushDown(int u, int len) {
//        if (tr[u] == null) tr[u] = new Node();
//        if (tr[u].ls == 0) {
//            tr[u].ls = ++cnt;
//            tr[tr[u].ls] = new Node();
//        }
//        if (tr[u].rs == 0) {
//            tr[u].rs = ++cnt;
//            tr[tr[u].rs] = new Node();
//        }
//        if (tr[u].add == 0) return;
//        if (tr[u].add == -1) {
//            tr[tr[u].ls].sum = tr[tr[u].rs].sum = 0;
//        } else {
//            tr[tr[u].ls].sum = len - len / 2;
//            tr[tr[u].rs].sum = len / 2;
//        }
//        tr[tr[u].ls].add = tr[tr[u].rs].add = tr[u].add;
//        tr[u].add = 0;
//    }
//    void pushUp(int u) {
//        tr[u].sum = tr[tr[u].ls].sum + tr[tr[u].rs].sum;
//    }
//    public void addRange(int left, int right) {
//        update(1, 1, N - 1, left, right - 1, 1);
//    }
//    public boolean queryRange(int left, int right) {
//        return query(1, 1, N - 1, left, right - 1) == right - left;
//    }
//    public void removeRange(int left, int right) {
//        update(1, 1, N - 1, left, right - 1, -1);
//    }
//}


// Method 1 - b: Segment Tree (Dynamic pointers)
class RangeModule {
    static class Node {
        Node ls, rs;
        int sum, add;
    }
    int N = (int)1e9 + 10;
    Node root = new Node();
    void update(Node node, int lc, int rc, int l, int r, int v) {
        int len = rc - lc + 1;
        if (l <= lc && rc <= r) {
            node.sum = v == 1 ? len : 0;
            node.add = v;
            return ;
        }
        pushDown(node, len);
        int mid = lc + rc >> 1;
        if (l <= mid) update(node.ls, lc, mid, l, r, v);
        if (r > mid) update(node.rs, mid + 1, rc, l, r, v);
        pushUp(node);
    }
    int query(Node node, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) return node.sum;
        pushDown(node, rc - lc + 1);
        int mid = lc + rc >> 1, ans = 0;
        if (l <= mid) ans = query(node.ls, lc, mid, l, r);
        if (r > mid) ans += query(node.rs, mid + 1, rc, l, r);
        return ans;
    }
    void pushDown(Node node, int len) {
        if (node.ls == null) node.ls = new Node();
        if (node.rs == null) node.rs = new Node();
        if (node.add == 0) return ;
        int add = node.add;
        if (add == -1) {
            node.ls.sum = node.rs.sum = 0;
        } else {
            node.ls.sum = len - len / 2;
            node.rs.sum = len / 2;
        }
        node.ls.add = node.rs.add = add;
        node.add = 0;
    }
    void pushUp(Node node) {
        node.sum = node.ls.sum + node.rs.sum;
    }
    public void addRange(int left, int right) {
        update(root, 1, N - 1, left, right - 1, 1);
    }
    public boolean queryRange(int left, int right) {
        return query(root, 1, N - 1, left, right - 1) == right - left;
    }
    public void removeRange(int left, int right) {
        update(root, 1, N - 1, left, right - 1, -1);
    }
}


// Method 2: Ordered Set
//class RangeModule {
//    TreeMap<Integer, Integer> intervals;
//
//    public RangeModule() {
//        intervals = new TreeMap<Integer, Integer>();
//    }
//
//    public void addRange(int left, int right) {
//        Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
//        if (entry != intervals.firstEntry()) {
//            Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
//            if (start != null && start.getValue() >= right) {
//                return;
//            }
//            if (start != null && start.getValue() >= left) {
//                left = start.getKey();
//                intervals.remove(start.getKey());
//            }
//        }
//        while (entry != null && entry.getKey() <= right) {
//            right = Math.max(right, entry.getValue());
//            intervals.remove(entry.getKey());
//            entry = intervals.higherEntry(entry.getKey());
//        }
//        intervals.put(left, right);
//    }
//
//    public boolean queryRange(int left, int right) {
//        Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
//        if (entry == intervals.firstEntry()) {
//            return false;
//        }
//        entry = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
//        return entry != null && right <= entry.getValue();
//    }
//
//    public void removeRange(int left, int right) {
//        Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
//        if (entry != intervals.firstEntry()) {
//            Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
//            if (start != null && start.getValue() >= right) {
//                int ri = start.getValue();
//                if (start.getKey() == left) {
//                    intervals.remove(start.getKey());
//                } else {
//                    intervals.put(start.getKey(), left);
//                }
//                if (right != ri) {
//                    intervals.put(right, ri);
//                }
//                return;
//            } else if (start != null && start.getValue() > left) {
//                intervals.put(start.getKey(), left);
//            }
//        }
//        while (entry != null && entry.getKey() < right) {
//            if (entry.getValue() <= right) {
//                intervals.remove(entry.getKey());
//                entry = intervals.higherEntry(entry.getKey());
//            } else {
//                intervals.put(right, entry.getValue());
//                intervals.remove(entry.getKey());
//                break;
//            }
//        }
//    }
//}
