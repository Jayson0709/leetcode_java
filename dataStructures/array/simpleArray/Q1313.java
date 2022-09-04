package dataStructures.array.simpleArray;

import utils.InputMethods;

import java.util.Arrays;

//We are given a list nums of integers representing a list compressed with run-length encoding.
//
//    Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]](with i >= 0). For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.
//
//    Return the decompressed list.
//
//    Example 1:
//    Input: nums = [1,2,3,4]
//    Output: [2,4,4,4]
//    Explanation: The first pair [1,2] means we have freq = 1 and val = 2, so we generate the array [2].
//    The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
//    At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
//    
//    Example 2:
//    Input: nums = [1,1,2,3]
//    Output: [1,3,3]
//
//    Constraints:
//    2 <= nums.length <= 100
//    nums.length % 2 == 0
//    1 <= nums[i] <= 100


//给你一个以行程长度编码压缩的整数列表nums。
//
//    考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]]（其中i >= 0），每一对都表示解压后子列表中有 freq个值为val的元素，你需要从左到右连接所有子列表以生成解压后的列表。
//
//    请你返回解压后的列表。
//
//    示例 1：
//    输入：nums = [1,2,3,4]
//    输出：[2,4,4,4]
//    解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
//    第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
//    最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
//
//    示例 2：
//    输入：nums = [1,1,2,3]
//    输出：[1,3,3]
//
//    提示：
//    2 <= nums.length <= 100
//    nums.length % 2 == 0
//    1 <= nums[i] <= 100



public class Q1313 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLEList(InputMethods.getInputForOneIntArray())));
    }

    private static int[] decompressRLEList(int[] nums){
        int n = nums.length;
        int len = 0;
        for (int i = 0; i < n; i += 2) {
            len += nums[i];
        }
        int[] result = new int[len];
        int index = 0;
        for (int i = 1; i < n; i += 2) {
            int val = nums[i];
            int freq = nums[i - 1];
            for (int j = 0; j < freq; j++) {
                result[index] = val;
                index++;
            }
        }
        return result;
    }
}
