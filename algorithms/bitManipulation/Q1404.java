package algorithms.bitManipulation;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:
//
//    If the current number is even, you have to divide it by 2.
//
//    If the current number is odd, you have to add 1 to it.
//
//    It is guaranteed that you can always reach one for all test cases.
//
//    Example 1:
//    Input: s = "1101"
//    Output: 6
//    Explanation: "1101" corresponds to number 13 in their decimal representation.
//    Step 1) 13 is odd, add 1 and obtain 14.
//    Step 2) 14 is even, divide by 2 and obtain 7.
//    Step 3) 7 is odd, add 1 and obtain 8.
//    Step 4) 8 is even, divide by 2 and obtain 4.
//    Step 5) 4 is even, divide by 2 and obtain 2.
//    Step 6) 2 is even, divide by 2 and obtain 1.
//    
//    Example 2:
//    Input: s = "10"
//    Output: 1
//    Explanation: "10" corresponds to number 2 in their decimal representation.
//    Step 1) 2 is even, divide by 2 and obtain 1.
//    
//    Example 3:
//    Input: s = "1"
//    Output: 0
//    
//    Constraints:
//    1 <= s.length<= 500
//    s consists of characters '0' or '1'
//    s[0] == '1'



//给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
//
//    如果当前数字为偶数，则将其除以 2 。
//
//    如果当前数字为奇数，则将其加上 1 。
//
//    题目保证你总是可以按上述规则将测试用例变为 1 。
//
//    示例 1：
//    输入：s = "1101"
//    输出：6
//    解释："1101" 表示十进制数 13 。
//    Step 1) 13 是奇数，加 1 得到 14
//    Step 2) 14 是偶数，除 2 得到 7
//    Step 3) 7  是奇数，加 1 得到 8
//    Step 4) 8  是偶数，除 2 得到 4
//    Step 5) 4  是偶数，除 2 得到 2
//    Step 6) 2  是偶数，除 2 得到 1
//
//    示例 2：
//    输入：s = "10"
//    输出：1
//    解释："10" 表示十进制数 2 。
//    Step 1) 2 是偶数，除 2 得到 1
//
//    示例 3：
//    输入：s = "1"
//    输出：0
//
//    提示：
//    1 <= s.length<= 500
//    s 由字符 '0' 或 '1' 组成。
//    s[0] == '1'



public class Q1404 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(numSteps(s));
    }

    private static int numSteps(String s) {
        int n = s.length();
        int ans = 0;
        // Whether we have seen 1 or not.
        boolean meetOne = false;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                // If the current char is 0, there are two cases
                // (1) haven't met 1 before, so the 0 is the lowest zero in the string，and requires a division by two
                // (2) met 1 before, so the 0 becomes 1 due to an addition operation to the right of it,
                // so requires a division and a division.
                ans += (meetOne ? 2 : 1);
            } else {
                // If the current char is 0, there are two cases
                // (1) haven't met 1 before, so the 1 requires a division by two and one addition.
                //     There's a special case to consider, where this 1 is the leftmost 1 in the string,
                //     and it doesn't require any manipulation
                // (2) met 1 before, so this 1 becomes 0 due to some addition operation from the right,
                //     so it requires only one division.
                if (!meetOne) {
                    if (i != 0) {
                        ans += 2;
                    }
                    meetOne = true;
                } else {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
