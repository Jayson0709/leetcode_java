package algorithms.twoPointers;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//    The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//    
//    Example 1:
//    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//    Output: [1,2,2,3,5,6]
//    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//    
//    Example 2:
//    Input: nums1 = [1], m = 1, nums2 = [], n = 0
//    Output: [1]
//    Explanation: The arrays we are merging are [1] and [].
//    The result of the merge is [1].
//    
//    Example 3:
//    Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//    Output: [1]
//    Explanation: The arrays we are merging are [] and [1].
//    The result of the merge is [1].
//    Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
//
//    Constraints:
//    nums1.length == m + n
//    nums2.length == n
//    0 <= m, n <= 200
//    1 <= m + n <= 200
//    -109 <= nums1[i], nums2[j] <= 109
//
//    Follow up: Can you come up with an algorithm that runs in O(m + n) time?


//给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
//    请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//
//    注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
//
//    示例 1：
//    输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//    输出：[1,2,2,3,5,6]
//    解释：需要合并 [1,2,3] 和 [2,5,6] 。
//    合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
//
//    示例 2：
//    输入：nums1 = [1], m = 1, nums2 = [], n = 0
//    输出：[1]
//    解释：需要合并 [1] 和 [] 。
//    合并结果是 [1] 。
//
//    示例 3：
//    输入：nums1 = [0], m = 0, nums2 = [1], n = 1
//    输出：[1]
//    解释：需要合并的数组是 [] 和 [1] 。
//    合并结果是 [1] 。
//    注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
//
//    提示：
//    nums1.length == m + n
//    nums2.length == n
//    0 <= m, n <= 200
//    1 <= m + n <= 200
//    -109 <= nums1[i], nums2[j] <= 109
//
//    进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？


public class Q88 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        OneDIntArrayAndOneInt obj1 = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        int[] nums1 = obj1.array;
        OneDIntArrayAndOneInt obj2 = InputMethods.getInputForOneInt1DArrayAndOneInt(cin);
        int[] nums2 = obj2.array;
        cin.close();
        merge(nums1, obj1.val, nums2, obj1.val);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Use two pointers from the back to the front
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int curNum;
        int tail = m + n - 1;
        while (ptr1 >= 0 || ptr2 >= 0) {
            if (ptr1 == -1) {
                curNum = nums2[ptr2];
                ptr2--;
            } else if (ptr2 == -1) {
                curNum = nums1[ptr1];
                ptr1--;
            } else if (nums1[ptr1] > nums2[ptr2]) {
                curNum = nums1[ptr1];
                ptr1--;
            } else {
                curNum = nums2[ptr2];
                ptr2--;
            }
            nums1[tail] = curNum;
            tail--;
        }
    }
}
