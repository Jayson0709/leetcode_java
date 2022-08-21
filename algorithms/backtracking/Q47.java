package algorithms.backtracking;
import java.util.*;
import java.nio.charset.StandardCharsets;
import utils.IOMethods;


//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//
//    Example 1:
//    Input: nums = [1,1,2]
//    Output:
//    [[1,1,2],
//    [1,2,1],
//    [2,1,1]]
//
//    Example 2:
//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//    Constraints:
//    1 <= nums.length <= 8
//    -10 <= nums[i] <= 10


//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//    示例 1：
//    输入：nums = [1,1,2]
//    输出：
//    [[1,1,2],
//    [1,2,1],
//    [2,1,1]]
//
//    示例 2：
//    输入：nums = [1,2,3]
//    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//    提示：
//    1 <= nums.length <= 8
//    -10 <= nums[i] <= 10


public class Q47 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        List<List<Integer>> result = permuteUnique(nums);
        IOMethods.outputEmbeddedListData(result);
    }

    static boolean[] visited;
    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            visited[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            visited[i] = false;
            perm.remove(idx);
        }
    }
}
