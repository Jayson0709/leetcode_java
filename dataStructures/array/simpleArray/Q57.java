package dataStructures.array.simpleArray;
import utils.*;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given an array of non-overlapping intervals 'intervals' where intervals[i] = [start_i, end_i] represent the start and the end of the ith interval and intervals is sorted in ascending order by start_i. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//    Insert newInterval into intervals such that intervals is still sorted in ascending order by start_i and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//    Return intervals after the insertion.
//
//    Example 1:
//    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//    Output: [[1,5],[6,9]]
//    
//    Example 2:
//    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//    Output: [[1,2],[3,10],[12,16]]
//    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
//
//    Constraints:
//    0 <= intervals.length <= 10^4
//    intervals[i].length == 2
//    0 <= start_i <= end_i <= 10^5
//    intervals is sorted by start_i in ascending order.
//    newInterval.length == 2
//    0 <= start <= end <= 10^5



//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
//
//    在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//
//    示例 1：
//    输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//    输出：[[1,5],[6,9]]
//
//    示例 2：
//    输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//    输出：[[1,2],[3,10],[12,16]]
//    解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
//
//    示例 3：
//    输入：intervals = [], newInterval = [5,7]
//    输出：[[5,7]]
//
//    示例 4：
//    输入：intervals = [[1,5]], newInterval = [2,3]
//    输出：[[1,5]]
//
//    示例 5：
//    输入：intervals = [[1,5]], newInterval = [2,7]
//    输出：[[1,7]]
//
//    提示：
//    0 <= intervals.length <= 10^4
//    intervals[i].length == 2
//    0 <= intervals[i][0] <= intervals[i][1] <= 10^5
//    intervals 根据 intervals[i][0] 按 升序 排列
//    newInterval.length == 2
//    0 <= newInterval[0] <= newInterval[1] <= 10^5



public class Q57 {
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
        int[] newInterval = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        int[][] intervals = new int[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            intervals[i] = data.get(i);
        }
        int[][] result = insert(intervals, newInterval);
        OutputMethods.output2DIntArrayData(result);
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // insert to the right and no intersection
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // insert to the left and no intersection.
                ansList.add(interval);
            } else {
                // intersection, calculate the union
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
