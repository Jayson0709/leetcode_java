package dataStructures.queue;
import java.util.*;
import java.nio.charset.StandardCharsets;

//You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
//    Return the max sliding window.
//
//    Example 1:
//    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//    Output: [3,3,5,5,6,7]
//    Explanation:
//    Window position                Max
//    ---------------               -----
//    [1  3  -1] -3  5  3  6  7       3
//    1 [3  -1  -3] 5  3  6  7       3
//    1  3 [-1  -3  5] 3  6  7       5
//    1  3  -1 [-3  5  3] 6  7       5
//    1  3  -1  -3 [5  3  6] 7       6
//    1  3  -1  -3  5 [3  6  7]      7
//    
//    Example 2:
//    Input: nums = [1], k = 1
//    Output: [1]
//
//    Constraints:
//    1 <= nums.length <= 105
//    -104 <= nums[i] <= 104
//    1 <= k <= nums.length


//给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
//
//    返回 滑动窗口中的最大值 。
//
//    示例 1：
//    输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//    输出：[3,3,5,5,6,7]
//    解释：
//    滑动窗口的位置                最大值
//    ---------------               -----
//    [1  3  -1] -3  5  3  6  7       3
//    1 [3  -1  -3] 5  3  6  7       3
//    1  3 [-1  -3  5] 3  6  7       5
//    1  3  -1 [-3  5  3] 6  7       5
//    1  3  -1  -3 [5  3  6] 7       6
//    1  3  -1  -3  5 [3  6  7]      7
//
//    示例 2：
//    输入：nums = [1], k = 1
//    输出：[1]
//
//    提示：
//    1 <= nums.length <= 105
//    -104<= nums[i] <= 104
//    1 <= k <= nums.length


public class Q239 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = cin.nextInt();
        cin.close();

        int[] result = maxSlidingWindow(nums, k);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                System.out.print(result[i]);
            } else {
                System.out.print("," + result[i]);
            }
        }
        System.out.print("]");
    }

    // Method 1: Priority Queue
    private static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        result[0] = pq.peek()[0];
        for (int i = k; i < len; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            result[i - k + 1] = pq.peek()[0];
        }
        return result;
    }

    // Method 2: Prefix + Suffix, preprocessing.
//    private static int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        int[] prefixMax = new int[n];
//        int[] suffixMax = new int[n];
//        for (int i = 0; i < n; ++i) {
//            if (i % k == 0) {
//                prefixMax[i] = nums[i];
//            }
//            else {
//                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
//            }
//        }
//        for (int i = n - 1; i >= 0; --i) {
//            if (i == n - 1 || (i + 1) % k == 0) {
//                suffixMax[i] = nums[i];
//            } else {
//                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
//            }
//        }
//
//        int[] ans = new int[n - k + 1];
//        for (int i = 0; i <= n - k; ++i) {
//            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
//        }
//        return ans;
//    }
}
