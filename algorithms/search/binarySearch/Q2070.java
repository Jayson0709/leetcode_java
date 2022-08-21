package algorithms.search.binarySearch;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a 2D integer array items where items[i] = [price_i, beauty_i] denotes the price and beauty of an item respectively.
//
//    You are also given a 0-indexed integer array queries. For each 'queries[j]', you want to determine the maximum beauty of an item whose price is less than or equal to 'queries[j]'. If no such item exists, then the answer to this query is 0.
//
//    Return an array answer of the same length as queries where answer[j] is the answer to the jth query.
//
//    Example 1:
//    Input: items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
//    Output: [2,4,5,5,6,6]
//    Explanation:
//    - For queries[0]=1, [1,2] is the only item which has price <= 1. Hence, the answer for this query is 2.
//    - For queries[1]=2, the items which can be considered are [1,2] and [2,4].
//    The maximum beauty among them is 4.
//    - For queries[2]=3 and queries[3]=4, the items which can be considered are [1,2], [3,2], [2,4], and [3,5].
//    The maximum beauty among them is 5.
//    - For queries[4]=5 and queries[5]=6, all items can be considered.
//    Hence, the answer for them is the maximum beauty of all items, i.e., 6.
//    
//    Example 2:
//    Input: items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]
//    Output: [4]
//    Explanation:
//    The price of every item is equal to 1, so we choose the item with the maximum beauty 4.
//    Note that multiple items can have the same price and/or beauty.
//    
//    Example 3:
//    Input: items = [[10,1000]], queries = [5]
//    Output: [0]
//    Explanation:
//    No item has a price less than or equal to 5, so no item can be chosen.
//    Hence, the answer to the query is 0.
//
//    Constraints:
//    1 <= items.length, queries.length <= 10^5
//    items[i].length == 2
//    1 <= price_i, beauty_i, queries[j] <= 10^9


//给你一个二维整数数组items，其中items[i] = [price_i, beauty_i]分别表示每一个物品的 价格和 美丽值。
//
//    同时给你一个下标从 0开始的整数数组queries。对于每个查询queries[j]，你想求出价格小于等于queries[j]的物品中，最大的美丽值是多少。如果不存在符合条件的物品，那么查询的结果为0。
//
//    请你返回一个长度与 queries相同的数组answer，其中answer[j]是第j个查询的答案。
//
//    示例 1：
//    输入：items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
//    输出：[2,4,5,5,6,6]
//    解释：
//    - queries[0]=1 ，[1,2] 是唯一价格 <= 1 的物品。所以这个查询的答案为 2 。
//    - queries[1]=2 ，符合条件的物品有 [1,2] 和 [2,4] 。
//    它们中的最大美丽值为 4 。
//    - queries[2]=3 和 queries[3]=4 ，符合条件的物品都为 [1,2] ，[3,2] ，[2,4] 和 [3,5] 。
//    它们中的最大美丽值为 5 。
//    - queries[4]=5 和 queries[5]=6 ，所有物品都符合条件。
//    所以，答案为所有物品中的最大美丽值，为 6 。
//
//    示例 2：
//    输入：items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]
//    输出：[4]
//    解释：
//    每个物品的价格均为 1 ，所以我们选择最大美丽值 4 。
//    注意，多个物品可能有相同的价格和美丽值。
//
//    示例 3：
//    输入：items = [[10,1000]], queries = [5]
//    输出：[0]
//    解释：
//    没有物品的价格小于等于 5 ，所以没有物品可以选择。
//    因此，查询的结果为 0 。
//
//    提示：
//    1 <= items.length, queries.length <= 10^5
//    items[i].length == 2
//    1 <= price_i, beauty_i, queries[j] <= 10^9


public class Q2070 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        int[] line;
        while (true) {
            line = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (line.length == 2) {
                data.add(line);
            } else {
                break;
            }
        }
        cin.close();
        int[] queries = line;
        int n = data.size();
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i] = data.get(i);
        }
        int[] result = maximumBeauty(items, queries);
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    private static int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];
        Arrays.sort(items, Comparator.comparingInt(o -> o[0]));
        int m = items.length;
        int max = 0;
        for (int[] item : items) {
            if (item[1] <= max) {
                item[1] = max;
            } else {
                max = item[1];
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (items[mid][0] <= queries[i]) {
                    result[i] = items[mid][1];
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return result;
    }
}
