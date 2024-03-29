package algorithms.search.dfs;

import utils.InputMethods;


//You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].
//
//    You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:
//      The first element in s[k] starts with the selection of the element nums[k] of index = k.
//      The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
//      We stop adding right before a duplicate element occurs in s[k].
//
//    Return the longest length of a set s[k].
//
//    Example 1:
//    Input: nums = [5,4,0,3,1,6,2]
//    Output: 4
//    Explanation:
//    nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
//    One of the longest sets s[k]:
//    s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
//    
//    Example 2:
//    Input: nums = [0,1,2]
//    Output: 1
//
//    Constraints:
//    1 <= nums.length <= 10^5
//    0 <= nums[i] < nums.length
//    All the values of nums are unique.



//索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
//
//    假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
//
//    示例1:
//
//    输入: A = [5,4,0,3,1,6,2]
//    输出: 4
//    解释:
//    A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
//
//    其中一种最长的 S[K]:
//    S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
//
//    提示：
//    N是[1, 20,000]之间的整数。
//    A中不含有重复的元素。
//    A中的元素大小在[0, N-1]之间。



public class Q565 {
    public static void main(String[] args) {
        int result = arrayNesting(InputMethods.getInputForOneIntArray());
        System.out.println(result);
    }

    // Method 1: build a boolean array 'visited' (mapping).
//    private static int arrayNesting(int[] nums) {
//        int result = 0;
//        int n = nums.length;
//        boolean[] visited = new boolean[n];
//        for (int i = 0; i < n; i++) {
//            int count = 0;
//            while(!visited[i]) {
//                visited[i] = true;
//                i = nums[i];
//                count++;
//            }
//            result = Math.max(result, count);
//        }
//        return result;
//    }

    // Method 2: tag the element and do not use the visited array, reduce space complexity.
    public static int arrayNesting(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            while (nums[i] < n) {
                int num = nums[i];
                nums[i] = n;
                i = num;
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
