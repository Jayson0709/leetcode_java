package algorithms.dynamicProgramming;


import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


//We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
//
//    You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
//
//    If you choose a job that ends at time X you will be able to start another job that starts at time X.
//    
//    Example 1:
//    Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//    Output: 120
//    Explanation: The subset chosen is the first and fourth job.
//    Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
//    
//    Example 2:
//    Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
//    Output: 150
//    Explanation: The subset chosen is the first, fourth and fifth job.
//    Profit obtained 150 = 20 + 70 + 60.
//    
//    Example 3:
//    Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//    Output: 6
//
//    Constraints:
//    1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
//    1 <= startTime[i] < endTime[i] <= 10^9
//    1 <= profit[i] <= 10^4



//你打算利用空闲时间来做兼职工作赚些零花钱。
//
//    这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
//
//    给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
//
//    注意，时间上出现重叠的 2 份工作不能同时进行。
//
//    如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
//
//    示例 1：
//    输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//    输出：120
//    解释：
//    我们选出第 1 份和第 4 份工作，
//    时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
//
//    示例 2：
//    输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
//    输出：150
//    解释：
//    我们选择第 1，4，5 份工作。
//    共获得报酬 150 = 20 + 70 + 60。
//
//    示例 3：
//    输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//    输出：6
//
//    提示：
//    1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
//    1 <= startTime[i] < endTime[i] <= 10^9
//    1 <= profit[i] <= 10^4


public class Q1235 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] startTime = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] endTime = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] profit = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    private static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1][2]);
        }
        return dp[n];
    }

    public static int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
