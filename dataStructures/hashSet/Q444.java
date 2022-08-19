package dataStructures.hashSet;
import java.util.*;
import java.nio.charset.StandardCharsets;

// The English version can be found here: https://leetcode.com/problems/sequence-reconstruction/


//给定一个长度为 n 的整数数组 nums ，其中 nums 是范围为 [1，n] 的整数的排列。还提供了一个 2D 整数数组sequences，其中sequences[i]是nums的子序列。
//    检查 nums 是否是唯一的最短超序列 。最短 超序列 是 长度最短 的序列，并且所有序列sequences[i]都是它的子序列。对于给定的数组sequences，可能存在多个有效的 超序列 。
//
//    例如，对于sequences = [[1,2],[1,3]]，有两个最短的 超序列 ，[1,2,3] 和 [1,3,2] 。
//    而对于sequences = [[1,2],[1,3],[1,2,3]]，唯一可能的最短 超序列 是 [1,2,3] 。[1,2,3,4] 是可能的超序列，但不是最短的。
//    如果 nums 是序列的唯一最短 超序列 ，则返回 true ，否则返回 false 。
//    子序列 是一个可以通过从另一个序列中删除一些元素或不删除任何元素，而不改变其余元素的顺序的序列。
//
//    示例 1：
//    输入：nums = [1,2,3], sequences = [[1,2],[1,3]]
//    输出：false
//    解释：有两种可能的超序列：[1,2,3]和[1,3,2]。
//    序列 [1,2] 是[1,2,3]和[1,3,2]的子序列。
//    序列 [1,3] 是[1,2,3]和[1,3,2]的子序列。
//    因为 nums 不是唯一最短的超序列，所以返回false。
//
//    示例 2：
//    输入：nums = [1,2,3], sequences = [[1,2]]
//    输出：false
//    解释：最短可能的超序列为 [1,2]。
//    序列 [1,2] 是它的子序列：[1,2]。
//    因为 nums 不是最短的超序列，所以返回false。
//
//    示例 3：
//    输入：nums = [1,2,3], sequences = [[1,2],[1,3],[2,3]]
//    输出：true
//    解释：最短可能的超序列为[1,2,3]。
//    序列 [1,2] 是它的一个子序列：[1,2,3]。
//    序列 [1,3] 是它的一个子序列：[1,2,3]。
//    序列 [2,3] 是它的一个子序列：[1,2,3]。
//    因为 nums 是唯一最短的超序列，所以返回true。
//
//    提示：
//    n == nums.length
//    1 <= n <= 10^4
//    nums是[1, n]范围内所有整数的排列
//    1 <= sequences.length <= 10^4
//    1 <= sequences[i].length <= 10^4
//    1 <= sum(sequences[i].length) <= 10^5
//    1 <= sequences[i][j] <= n
//    sequences的所有数组都是 唯一 的
//    sequences[i]是nums 的一个子序列



public class Q444 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<int[]> seqData = new ArrayList<>();
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            seqData.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        int[][] sequences = new int[seqData.size()][];
        for (int i = 0; i < seqData.size(); i++) {
            sequences[i] = seqData.get(i);
        }
        boolean result = sequenceReconstruction(nums, sequences);
        System.out.println(result);
    }

    // Version 1
    private static boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        // Check the integrity of the set, whether it's from 1 to n.
        Set<Integer> hSet = new HashSet<>();
        int n = nums.length;
        for (int[] sequence : sequences) {
            for (int num : sequence) {
                hSet.add(num);
            }
        }
        // If the sequence only has one element and the element is not in the sequences.
        if (n == 1 && !hSet.contains(n)) {
            return false;
        }
        // incomplete numbers
        if (n != hSet.size()) {
            return false;
        }
        // Build the directed graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // Record the in-degrees.
        int[] inDegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length - 1; i++) {
                if (!graph.get(sequence[i]).contains(sequence[i + 1])) {
                    graph.get(sequence[i]).add(sequence[i + 1]);
                    inDegree[sequence[i+1]]++;
                }
            }
        }
        // Prepare the topology, elements in the queue will only have 0 in-degree.
        // In the queue, every time there could only are elements with 0 in-degree.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        // if elements with 0 in-degree are not unique, the sequence cannot be determined.
        if (queue.size() != 1) {
            return false;
        }
        while (!queue.isEmpty()) {
            if (queue.size() != 1) {
                return false;
            }
            int cur = queue.poll();
            list.add(cur);
            if (graph.get(cur) == null) {
                continue;
            }
            for (int next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (list.size() != n) {
            return false;
        }
        // If the order is not the same, return false
        for (int i = 0; i < n; i++) {
            if (list.get(i) != nums[i]) {
                return false;
            }
        }
        return true;
    }

    // Version 2
//    private static boolean sequenceReconstruction(int[] nums, int[][] sequences) {
//        int n = nums.length;
//        int[] inDegrees = new int[n + 1];
//        Set<Integer>[] graph = new Set[n + 1];
//        for (int i = 1; i <= n; i++) {
//            graph[i] = new HashSet<Integer>();
//        }
//        for (int[] sequence : sequences) {
//            int size = sequence.length;
//            for (int i = 1; i < size; i++) {
//                int prev = sequence[i - 1], next = sequence[i];
//                if (graph[prev].add(next)) {
//                    inDegrees[next]++;
//                }
//            }
//        }
//        Queue<Integer> queue = new ArrayDeque<Integer>();
//        for (int i = 1; i <= n; i++) {
//            if (inDegrees[i] == 0) {
//                queue.offer(i);
//            }
//        }
//        while (!queue.isEmpty()) {
//            if (queue.size() > 1) {
//                return false;
//            }
//            int num = queue.poll();
//            Set<Integer> set = graph[num];
//            for (int next : set) {
//                inDegrees[next]--;
//                if (inDegrees[next] == 0) {
//                    queue.offer(next);
//                }
//            }
//        }
//        return true;
//    }
}
