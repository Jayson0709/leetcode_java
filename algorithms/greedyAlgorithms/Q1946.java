package algorithms.greedyAlgorithms;
import java.util.*;
import java.nio.charset.StandardCharsets;

//You are given a string num, which represents a large integer. You are also given a 0-indexed integer array change of length 10 that maps each digit 0-9 to another digit. More formally, digit d maps to digit change[d].
//
//    You may choose to mutate a single substring of num. To mutate a substring, replace each digit num[i] with the digit it maps to in change (i.e. replace num[i] with change[num[i]]).
//
//    Return a string representing the largest possible integer after mutating (or choosing not to) a single substring of num.
//
//    A substring is a contiguous sequence of characters within the string.
//
//    Example 1:
//    Input: num = "132", change = [9,8,5,0,3,6,4,2,6,8]
//    Output: "832"
//    Explanation: Replace the substring "1":
//    - 1 maps to change[1] = 8.
//    Thus, "132" becomes "832".
//    "832" is the largest number that can be created, so return it.
//    
//    Example 2:
//    Input: num = "021", change = [9,4,3,5,7,2,1,9,0,6]
//    Output: "934"
//    Explanation: Replace the substring "021":
//    - 0 maps to change[0] = 9.
//    - 2 maps to change[2] = 3.
//    - 1 maps to change[1] = 4.
//    Thus, "021" becomes "934".
//    "934" is the largest number that can be created, so return it.
//    
//    Example 3:
//    Input: num = "5", change = [1,4,7,5,3,2,5,6,9,4]
//    Output: "5"
//    Explanation: "5" is already the largest number that can be created, so return it.
//
//    Constraints:
//    1 <= num.length <= 105
//    num consists of only digits 0-9.
//    change.length == 10
//    0 <= change[d] <= 9


//给你一个字符串 num ，该字符串表示一个大整数。另给你一个长度为 10 且 下标从 0 开始 的整数数组 change ，该数组将 0-9 中的每个数字映射到另一个数字。更规范的说法是，数字 d 映射为数字 change[d] 。
//
//    你可以选择 突变 num 的任一子字符串。突变 子字符串意味着将每位数字 num[i] 替换为该数字在 change 中的映射（也就是说，将 num[i] 替换为 change[num[i]]）。
//
//    请你找出在对 num 的任一子字符串执行突变操作（也可以不执行）后，可能得到的 最大整数 ，并用字符串表示返回。
//
//    子字符串 是字符串中的一个连续序列。
//
//    示例 1：
//    输入：num = "132", change = [9,8,5,0,3,6,4,2,6,8]
//    输出："832"
//    解释：替换子字符串 "1"：
//    - 1 映射为 change[1] = 8 。
//    因此 "132" 变为 "832" 。
//    "832" 是可以构造的最大整数，所以返回它的字符串表示。
//
//    示例 2：
//    输入：num = "021", change = [9,4,3,5,7,2,1,9,0,6]
//    输出："934"
//    解释：替换子字符串 "021"：
//    - 0 映射为 change[0] = 9 。
//    - 2 映射为 change[2] = 3 。
//    - 1 映射为 change[1] = 4 。
//    因此，"021" 变为 "934" 。
//    "934" 是可以构造的最大整数，所以返回它的字符串表示。
//
//    示例 3：
//    输入：num = "5", change = [1,4,7,5,3,2,5,6,9,4]
//    输出："5"
//    解释："5" 已经是可以构造的最大整数，所以返回它的字符串表示。
//
//    提示：
//    1 <= num.length <= 105
//    num 仅由数字 0-9 组成
//    change.length == 10
//    0 <= change[d] <= 9


public class Q1946 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String num = cin.nextLine().strip();
        int[] change = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        String result = maximumNumber(num, change);
        System.out.println(result);
    }

    private static String maximumNumber(String num, int[] change) {
        char[] chars = num.toCharArray();
        int index = 0;
        while (index < chars.length) {
            int curNum = chars[index] - '0';
            int changeNum = change[curNum];
            if (curNum >= changeNum) {
                index++;
            } else {
                while (index < chars.length) {
                    curNum = chars[index] - '0';
                    changeNum = change[curNum];
                    if (curNum <= changeNum) {
                        chars[index] = (char) (changeNum + '0');
                        index++;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        return new String(chars);
    }
}
