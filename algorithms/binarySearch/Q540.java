package algorithms.binarySearch;
import java.util.*;
import java.nio.charset.StandardCharsets;

//You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
//
//    Return the single element that appears only once.
//
//    Your solution must run in O(log n) time and O(1) space.
//
//    Example 1:
//
//    Input: nums = [1,1,2,3,3,4,4,8,8]
//    Output: 2
//    Example 2:
//
//    Input: nums = [3,3,7,7,10,11,11]
//    Output: 10
//
//    Constraints:
//
//    1 <= nums.length <= 105
//    0 <= nums[i] <= 105


//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
//
//    请你找出并返回只出现一次的那个数。
//
//    你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
//
//    示例 1:
//
//    输入: nums = [1,1,2,3,3,4,4,8,8]
//    输出: 2
//    示例 2:
//
//    输入: nums =  [3,3,7,7,10,11,11]
//    输出: 10
//
//    提示:
//
//    1 <= nums.length <= 105
//    0 <= nums[i]<= 105

public class Q540 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        int result = singleNonDuplicate(nums);
        System.out.println(result);
    }

    private static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            // check parity of mid
            mid -= mid & 1;
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
