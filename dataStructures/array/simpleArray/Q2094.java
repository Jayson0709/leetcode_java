package dataStructures.array.simpleArray;
import java.util.*;
import java.nio.charset.StandardCharsets;
import utils.*;


//You are given an integer array digits, where each element is a digit. The array may contain duplicates.
//
//    You need to find all the unique integers that follow the given requirements:
//
//    The integer consists of the concatenation of three elements from digits in any arbitrary order.
//    The integer does not have leading zeros.
//    The integer is even.
//    For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.
//
//    Return a sorted array of the unique integers.
//
//    Example 1:
//    Input: digits = [2,1,3,0]
//    Output: [102,120,130,132,210,230,302,310,312,320]
//    Explanation: All the possible integers that follow the requirements are in the output array.
//    Notice that there are no odd integers or integers with leading zeros.
//
//    Example 2:
//    Input: digits = [2,2,8,8,2]
//    Output: [222,228,282,288,822,828,882]
//    Explanation: The same digit can be used as many times as it appears in digits.
//    In this example, the digit 8 is used twice each time in 288, 828, and 882.
//
//    Example 3:
//    Input: digits = [3,7,5]
//    Output: []
//    Explanation: No even integers can be formed using the given digits.
//
//    Constraints:
//    3 <= digits.length <= 100
//    0 <= digits[i] <= 9



//给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
//
//    你需要找出 所有 满足下述条件且 互不相同 的整数：
//
//    该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
//    该整数不含 前导零
//    该整数是一个 偶数
//    例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
//
//    将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
//
//    示例 1：
//    输入：digits = [2,1,3,0]
//    输出：[102,120,130,132,210,230,302,310,312,320]
//    解释：
//    所有满足题目条件的整数都在输出数组中列出。
//    注意，答案数组中不含有 奇数 或带 前导零 的整数。
//
//    示例 2：
//    输入：digits = [2,2,8,8,2]
//    输出：[222,228,282,288,822,828,882]
//    解释：
//    同样的数字（0 - 9）在构造整数时可以重复多次，重复次数最多与其在 digits 中出现的次数一样。
//    在这个例子中，数字 8 在构造 288、828 和 882 时都重复了两次。
//
//    示例 3：
//    输入：digits = [3,7,5]
//    输出：[]
//    解释：
//    使用给定的 digits 无法构造偶数。
//
//    提示：
//    3 <=  digits.length <= 100
//    0 <= digits[i] <= 9



public class Q2094 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] digits = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        int[] result = findEvenNumbers(digits);
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    private static int[] findEvenNumbers(int[] digits) {
        Set<Integer> numSet = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n - 2; i++) {
            int x = digits[i];
            for (int j = i + 1; j < n - 1; j++) {
                int y = digits[j];
                for (int k = j + 1; k < n; k++) {
                    int z = digits[k];
                    if (x % 2 == 0) {
                        numSet.add(y * 100 + z * 10 + x);
                        numSet.add(z * 100 + y * 10 + x);
                    }
                    if (y % 2 == 0) {
                        numSet.add(x * 100 + z * 10 + y);
                        numSet.add(z * 100 + x * 10 + y);
                    }
                    if (z % 2 == 0) {
                        numSet.add(x * 100 + y * 10 + z);
                        numSet.add(y * 100 + x * 10 + z);
                    }
                }
            }
        }
        List<Integer> numList = new ArrayList<>();
        for (int num : numSet) {
            if (num >= 100) {
                numList.add(num);
            }
        }
        int[] res = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            res[i] = numList.get(i);
        }
        Arrays.sort(res);
        return res;
    }
}
