package dataStructures.stack;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
//
//    Example 1:
//    Input: heights = [2,1,5,6,2,3]
//    Output: 10
//    Explanation: The above is a histogram where width of each bar is 1.
//    The largest rectangle is constructed by pillar with height 5 and pillar with height 6, which has an area = 10 units.
//
//    Example 2:
//    Input: heights = [2,4]
//    Output: 4
//
//    Constraints:
//    1 <= heights.length <= 10^5
//    0 <= heights[i] <= 10^4



//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//    求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//    示例 1:
//    输入：heights = [2,1,5,6,2,3]
//    输出：10
//    解释：最大的矩形为5和6可构成的矩形，面积为 10
//
//    示例 2：
//    输入： heights = [2,4]
//    输出： 4
//
//    提示：
//    1 <= heights.length <=10^5
//    0 <= heights[i] <= 10^4


public class Q84 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] heights = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        int result = largestRectangleArea(heights);
        System.out.println(result);
    }

    // Method: Monotonous Stack + Sentinel Value
    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> monoStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                monoStack.pop();
            }
            left[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
            monoStack.push(i);
        }
        monoStack.clear();
        for (int i = n - 1; i >=0; i--) {
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                monoStack.pop();
            }
            right[i] = monoStack.isEmpty() ? n : monoStack.peek();
            monoStack.push(i);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        return result;
    }
}
