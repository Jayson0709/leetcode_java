package algorithms.greedyAlgorithms;
import java.util.*;
import java.nio.charset.StandardCharsets;


//An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.
//
//    Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A has a size of at least two.
//
//    Example 1:
//    Input: intervals = [[1,3],[1,4],[2,5],[3,5]]
//    Output: 3
//    Explanation: Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
//    Also, there isn't a smaller size set that fulfills the above condition.
//    Thus, we output the size of this set, which is 3.
//
//    Example 2:
//    Input: intervals = [[1,2],[2,3],[2,4],[4,5]]
//    Output: 5
//    Explanation: An example of a minimum sized set is {1, 2, 3, 4, 5}.
//
//    Constraints:
//    1 <= intervals.length <= 3000
//    intervals[i].length == 2
//    0 <= ai <bi <= 10^8


//一个整数区间[a, b](a < b) 代表着从a到b的所有连续整数，包括a和b。
//
//    给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
//
//    输出这个最小集合S的大小。
//
//    示例 1:
//    输入: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
//    输出: 3
//    解释:
//    考虑集合 S = {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。
//    且这是S最小的情况，故我们输出3。
//
//    示例 2:
//    输入: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
//    输出: 5
//    解释:
//    最小的集合S = {1, 2, 3, 4, 5}.
//
//    注意:
//    intervals的长度范围为[1, 3000]。
//    intervals[i]长度为2，分别代表左、右边界。
//    intervals[i][j] 的值是[0, 10^8]范围内的整数。



public class Q757 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            data.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        int[][] intervals = new int[data.size()][2];
        for (int i = 0; i < data.size(); i++) {
            intervals[i] = data.get(i);
        }
        int result = intersectionSizeTwo(intervals);
        System.out.println(result);
    }

    // Greedy algorithm + Sorting
    private static int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        int m = 2;
        int result = 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(new ArrayList<>());
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = intervals[i][0], k = temp.get(i).size(); k < m; j++, k++) {
                result++;
                help(intervals, temp, i - 1, j);
            }
        }
        return result;
    }

    private static void help(int[][] intervals, List<List<Integer>> temp, int pos, int num) {
        for (int i = pos; i >= 0; i--) {
            if (intervals[i][1] < num) {
                break;
            }
            temp.get(i).add(num);
        }
    }
}
