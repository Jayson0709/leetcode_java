package dataStructures.stack;

import utils.InputMethods;
import utils.TwoOneDArray;

import java.nio.charset.StandardCharsets;
import java.util.*;


//The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
//
//    You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
//
//    For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
//
//    Return an array 'ans' of length nums1.length such that ans[i] is the next greater element as described above.
//    
//    Example 1:
//    Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//    Output: [-1,3,-1]
//    Explanation: The next greater element for each value of nums1 is as follows:
//    - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
//    - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
//    - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
//    
//    Example 2:
//    Input: nums1 = [2,4], nums2 = [1,2,3,4]
//    Output: [3,-1]
//    Explanation: The next greater element for each value of nums1 is as follows:
//    - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
//    - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
//
//    Constraints:
//    1 <= nums1.length <= nums2.length <= 1000
//    0 <= nums1[i], nums2[i] <= 10^4
//    All integers in nums1 and nums2 are unique.
//    All the integers of nums1 also appear in nums2.
//    
//    Follow up: Could you find an O(nums1.length + nums2.length) solution?



//nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
//
//    给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
//
//    对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
//
//    返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
//
//    示例 1：
//    输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
//    输出：[-1,3,-1]
//    解释：nums1 中每个值的下一个更大元素如下所述：
//    - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
//    - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
//    - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
//
//    示例 2：
//    输入：nums1 = [2,4], nums2 = [1,2,3,4].
//    输出：[3,-1]
//    解释：nums1 中每个值的下一个更大元素如下所述：
//    - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
//    - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
//
//    提示：
//    1 <= nums1.length <= nums2.length <= 1000
//    0 <= nums1[i], nums2[i] <= 10^4
//    nums1和nums2中所有整数 互不相同
//    nums1 中的所有整数同样出现在 nums2 中
//
//    进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？


public class Q496 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDArray obj = InputMethods.getInputForTwoInt1DArray(cin);
        cin.close();
        System.out.println(Arrays.toString(nextGreaterElement(obj.array1, obj.array2)));
    }

    // Method 1: Brute force
//    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int m = nums1.length, n = nums2.length;
//        int[] ans = new int[m];
//        for (int i = 0; i < m; i++) {
//            int j = 0;
//            while (j < n && nums2[j] != nums1[i]) {
//                j++;
//            }
//            int k = j + 1;
//            while (k < n && nums2[k] < nums2[j]) {
//                k++;
//            }
//            ans[i] = k < n ? nums2[k] : -1;
//        }
//        return ans;
//    }

    // Method 2: use stack and hash map
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
