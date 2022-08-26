package dataStructures.array.prefixSum;

import utils.InputMethods;
import utils.OneDArrayAndOneInt;
import utils.OutputMethods;

import java.util.Arrays;


//You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.
//
//    To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
//
//    If k > 0, replace the ith number with the sum of the next k numbers.
//    If k < 0, replace the ith number with the sum of the previous k numbers.
//    If k == 0, replace the ith number with 0.
//    As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
//
//    Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
//
//    Example 1:
//    Input: code = [5,7,1,4], k = 3
//    Output: [12,10,16,13]
//    Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
//
//    Example 2:
//    Input: code = [1,2,3,4], k = 0
//    Output: [0,0,0,0]
//    Explanation: When k is zero, the numbers are replaced by 0.
//
//    Example 3:
//    Input: code = [2,4,9,3], k = -2
//    Output: [12,5,6,13]
//    Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
//
//    Constraints:
//    n == code.length
//    1 <= n <= 100
//    1 <= code[i] <= 100
//    -(n - 1) <= k <= n - 1



//你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
//
//    为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
//
//    如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
//    如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
//    如果 k == 0 ，将第 i 个数字用 0 替换。
//    由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
//
//    给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
//
//    示例 1：
//    输入：code = [5,7,1,4], k = 3
//    输出：[12,10,16,13]
//    解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
//
//    示例 2：
//    输入：code = [1,2,3,4], k = 0
//    输出：[0,0,0,0]
//    解释：当 k 为 0 时，所有数字都被 0 替换。
//
//    示例 3：
//    输入：code = [2,4,9,3], k = -2
//    输出：[12,5,6,13]
//    解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
//
//    提示：
//    n == code.length
//    1 <= n <= 100
//    1 <= code[i] <= 100
//    -(n - 1) <= k <= n - 1





public class Q1652 {
    public static void main(String[] args) {
        OneDArrayAndOneInt obj = InputMethods.getInputForOneInt1DArrayAndOneInt();
        int[] result = decrypt(obj.array, obj.val);
        System.out.println(OutputMethods.format1DArrayOutputData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    private static int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        int[] prefixSum = new int[n];
        prefixSum[0] = code[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + code[i];
        }
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int x = i + k;
                if (x < n) {
                    code[i] = prefixSum[x] - prefixSum[i];
                } else {
                    code[i] = prefixSum[n - 1] - prefixSum[i] + prefixSum[x - n];
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                int x = i + k;
                if (x > 0) {
                    code[i] = prefixSum[i - 1] - prefixSum[x - 1];
                } else {
                    // when i == 0, there is no prefix[i-1]
                    code[i] = i == 0 ? 0 : prefixSum[i - 1];
                    code[i] += prefixSum[n - 1] - prefixSum[n - 1 + x];
                }
            }
        }
        return code;
    }
}
