package algorithms.search.unionFind;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given an integer array of unique positive integers nums. Consider the following graph:
//
//    There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
//    There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
//    Return the size of the largest connected component in the graph.
//    
//    Example 1:
//    4 - 6 - 13 - 35
//    Input: nums = [4,6,15,35]
//    Output: 4
//    
//    Example 2:
//    20 - 50     9 - 63
//    Input: nums = [20,50,9,63]
//    Output: 2
//    
//    Example 3:

//    Input: nums = [2,3,6,7,4,12,21,39]
//    Output: 8
//
//    Constraints:
//    1 <= nums.length <= 2 * 10^4
//    1 <= nums[i] <= 10^5
//    All the values of nums are unique.



//给定一个由不同正整数的组成的非空数组nums ，考虑下面的图：
//
//    有nums.length个节点，按从nums[0]到nums[nums.length - 1]标记；
//    只有当nums[i]和nums[j]共用一个大于 1 的公因数时，nums[i]和nums[j]之间才有一条边。
//    返回 图中最大连通组件的大小 。
//
//    示例 1：
//    4 - 6 - 13 - 35
//    输入：nums = [4,6,15,35]
//    输出：4
//
//    示例 2：
//    20 - 50     9 - 63
//    输入：nums = [20,50,9,63]
//    输出：2
//
//    示例 3：
//    输入：nums = [2,3,6,7,4,12,21,39]
//    输出：8
//
//    提示：
//    1 <= nums.length <= 2 * 10^4
//    1 <= nums[i] <= 10^5
//    nums中所有值都 不同



public class Q952 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        System.out.println(largestComponentSize(nums));
    }

    private static int largestComponentSize(int[] nums) {
        int m = 0;
        for (int num : nums) {
            m = Math.max(num, m);
        }
        UnionFind uf = new UnionFind(m + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int[] counts = new int[m + 1];
        int ans = 0;
        for (int num : nums) {
            int root = uf.find(num);
            counts[root]++;
            ans = Math.max(ans, counts[root]);
        }
        return ans;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
    }

    public void union(int x1, int x2) {
        int rootX1 = find(x1);
        int rootX2 = find(x2);
        if (rootX1 != rootX2) {
            if (rank[rootX1] > rank[rootX2]) {
                parent[rootX2] = rootX1;
            } else if (rank[rootX1] < rank[rootX2]) {
                parent[rootX1] = rootX2;
            } else {
                parent[rootX2] = rootX1;
                rank[rootX1]++;
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
