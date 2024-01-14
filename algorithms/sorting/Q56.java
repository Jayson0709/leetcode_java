package algorithms.sorting;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


//Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping intervals, 
// and return an array of the non-overlapping intervals that cover all the intervals in the input.
//    
//    Example 1:
//    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//    
//    Example 2:
//    Input: intervals = [[1,4],[4,5]]
//    Output: [[1,5]]
//    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//    
//    Constraints:
//    1 <= intervals.length <= 10^4
//    intervals[i].length == 2
//    0 <= start_i <= end_i <= 10^4


//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [start_i, end_i] 。请你合并所有重叠的区间，
// 并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//    示例 1：
//    输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//    输出：[[1,6],[8,10],[15,18]]
//    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//    示例 2：
//    输入：intervals = [[1,4],[4,5]]
//    输出：[[1,5]]
//    解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//    提示：
//    1 <= intervals.length <= 10^4
//    intervals[i].length == 2
//    0 <= start_i <= end_i <= 10^4


public class Q56 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        System.out.println(Arrays.deepToString((merge(DataConversionMethods.convertIntArrArrayListTo2DArray(data)))));
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            }
            return 0;
        });
        int length = intervals.length;
        if (length == 1) {
            return intervals;
        }
        int j = 1;
        List<int[]> pairs = new ArrayList<>();
        int[] curPair = intervals[0];
        while (j < length) {
            while (j < length && curPair[1] >= intervals[j][0]) {
                curPair[1] = Math.max(curPair[1], intervals[j][1]);
                j++;
            }
            pairs.add(curPair);
            if (j == length) {
                break;
            }
            else if (j == length - 1) {
                pairs.add(intervals[j]);
            }
            curPair = intervals[j];
            j++;
        }
        int[][] result = new int[pairs.size()][];
        for (int k = 0; k < pairs.size(); k++) {
            result[k] = pairs.get(k);
        }
        return result;
    }
}
