package dataStructures.array.prefixSum;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given an integer array nums, handle multiple queries of the following type:
//
//    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
//    Implement the NumArray class:
//
//    NumArray(int[] nums) Initializes the object with the integer array nums.
//    int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
//
//    Example 1:
//    Input
//    ["NumArray", "sumRange", "sumRange", "sumRange"]
//    [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//    Output
//    [null, 1, -1, -3]
//    Explanation
//    NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//    numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
//    numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
//    numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
//
//    Constraints:
//    1 <= nums.length <= 104
//    -105 <= nums[i] <= 105
//    0 <= left <= right < nums.length
//    At most 104 calls will be made to sumRange.

//给定一个整数数组 nums，处理以下类型的多个查询:
//
//    计算索引left和right（包含 left 和 right）之间的 nums 元素的 和 ，其中left <= right
//    实现 NumArray 类：
//
//    NumArray(int[] nums) 使用数组 nums 初始化对象
//    int sumRange(int i, int j) 返回数组 nums中索引left和right之间的元素的 总和 ，包含left和right两点（也就是nums[left] + nums[left + 1] + ... + nums[right])
//
//    示例 1：
//    输入：
//    ["NumArray", "sumRange", "sumRange", "sumRange"]
//    [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//    输出：
//    [null, 1, -1, -3]
//    解释：
//    NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//    numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//    numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
//    numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
//
//    提示：
//    1 <= nums.length <= 104
//    -105<= nums[i] <=105
//    0 <= i <= j < nums.length
//    最多调用 104 次 sumRange 方法


public class Q303 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<int[]> sumRanges = new ArrayList<>();
        for (int i = 1; i < orders.length; i++) {
            sumRanges.add(Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        NumArray obj = new NumArray(nums);
        System.out.print("[null");
        for (int[] sumRange : sumRanges) {
            int temp = obj.sumRange(sumRange[0], sumRange[1]);
            System.out.print(", " + temp);
        }
        System.out.print("]");
    }
}

class NumArray {

    int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
