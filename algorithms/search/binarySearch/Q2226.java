package algorithms.search.binarySearch;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i]. You can divide each pile into any number of sub piles, but you cannot merge two piles together.
//
//    You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies. Each child can take at most one pile of candies and some piles of candies may go unused.
//
//    Return the maximum number of candies each child can get.
//
//    Example 1:
//    Input: candies = [5,8,6], k = 3
//    Output: 5
//    Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1. We now have five piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children. It can be proven that each child cannot receive more than 5 candies.
//
//    Example 2:
//    Input: candies = [2,5], k = 11
//    Output: 0
//    Explanation: There are 11 children but only 7 candies in total, so it is impossible to ensure each child receives at least one candy. Thus, each child gets no candy and the answer is 0.
//
//    Constraints:
//    1 <= candies.length <= 10^5
//    1 <= candies[i] <= 10^7
//    1 <= k <= 10^12



//给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆 ，但 无法 再将两堆合并到一起。
//
//    另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。
//
//    返回每个小孩可以拿走的 最大糖果数目 。
//
//    示例 1：
//    输入：candies = [5,8,6], k = 3
//    输出：5
//    解释：可以将 candies[1] 分成大小分别为 5 和 3 的两堆，然后把 candies[2] 分成大小分别为 5 和 1 的两堆。现在就有五堆大小分别为 5、5、3、5 和 1 的糖果。可以把 3 堆大小为 5 的糖果分给 3 个小孩。可以证明无法让每个小孩得到超过 5 颗糖果。
//
//    示例 2：
//    输入：candies = [2,5], k = 11
//    输出：0
//    解释：总共有 11 个小孩，但只有 7 颗糖果，但如果要分配糖果的话，必须保证每个小孩至少能得到 1 颗糖果。因此，最后每个小孩都没有得到糖果，答案是 0 。
//
//    提示：
//    1 <= candies.length <= 10^5
//    1 <= candies[i] <= 10^7
//    1 <= k <= 10^12



public class Q2226 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] candies = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        long k = cin.nextLong();
        cin.close();

        int result = maximumCandies(candies, k);
        System.out.println(result);
    }

    private static int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int num : candies) {
            sum += num;
        }
        if (sum < k) {
            return 0;
        }
        long left = 1, right = sum;
        long result = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(candies, mid, k)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) result;
    }

    private static boolean check(int[] candies, long limit, long k) {
        for (int val : candies) {
            if (val == limit) {
                k--;
            } else if (val > limit) {
                k -= val / limit;
            }
        }
        return k <= 0;
    }
}
