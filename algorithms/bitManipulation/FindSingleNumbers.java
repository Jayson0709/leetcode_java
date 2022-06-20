package algorithms.bitManipulation;
import java.util.*;
import java.nio.charset.StandardCharsets;

// Find the two numbers that only appear once in the given array, where other numbers appear twice.
// (This question is on the Chinese LeetCode website)
// Time complexity requirement is O(n), and space complexity is O(1).

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
//    示例 1：
//    输入：nums = [4,1,4,6]
//    输出：[1,6] 或 [6,1]
//
//    示例 2：
//    输入：nums = [1,2,10,4,1,4,3,3]
//    输出：[2,10] 或 [10,2]
//
//    限制：
//    2 <= nums.length <= 10000


public class FindSingleNumbers {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        int[] result = singleNumbers(nums);
        System.out.println("[" + result[0] + "," + result[1] +  "]");
    }

    private static int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
