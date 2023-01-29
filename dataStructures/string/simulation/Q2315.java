package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given a string s, where every two consecutive vertical bars '|' are grouped into a pair. In other words, the 1st and 2nd '|' make a pair, the 3rd and 4th '|' make a pair, and so forth.
//
//    Return the number of '*' in s, excluding the '*' between each pair of '|'.
//
//    Note that each '|' will belong to exactly one pair.
//
//    Example 1:
//    Input: s = "l|*e*et|c**o|*de|"
//    Output: 2
//    Explanation: The considered characters are underlined: "l|*e*et|c**o|*de|".
//    The characters between the first and second '|' are excluded from the answer.
//    Also, the characters between the third and fourth '|' are excluded from the answer.
//    There are 2 asterisks considered. Therefore, we return 2.
//
//    Example 2:
//    Input: s = "iamprogrammer"
//    Output: 0
//    Explanation: In this example, there are no asterisks in s. Therefore, we return 0.
//
//    Example 3:
//    Input: s = "yo|uar|e**|b|e***au|tifu|l"
//    Output: 5
//    Explanation: The considered characters are underlined: "yo|uar|e**|b|e***au|tifu|l". There are 5 asterisks considered. Therefore, we return 5.
//
//    Constraints:
//    1 <= s.length <= 1000
//    s consists of lowercase English letters, vertical bars '|', and asterisks '*'.
//    s contains an even number of vertical bars '|'.


//给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
//
//    请你返回 不在 竖线对之间，s 中 '*' 的数目。
//
//    注意，每个竖线 '|' 都会 恰好 属于一个对。
//
//    示例 1：
//    输入：s = "l|*e*et|c**o|*de|"
//    输出：2
//    解释：不在竖线对之间的字符加粗加斜体后，得到字符串："l|*e*et|c**o|*de|" 。
//    第一和第二条竖线 '|' 之间的字符不计入答案。
//    同时，第三条和第四条竖线 '|' 之间的字符也不计入答案。
//    不在竖线对之间总共有 2 个星号，所以我们返回 2 。
//
//    示例 2：
//    输入：s = "iamprogrammer"
//    输出：0
//    解释：在这个例子中，s 中没有星号。所以返回 0 。
//
//    示例 3：
//    输入：s = "yo|uar|e**|b|e***au|tifu|l"
//    输出：5
//    解释：需要考虑的字符加粗加斜体后："yo|uar|e**|b|e***au|tifu|l" 。不在竖线对之间总共有 5 个星号。所以我们返回 5 。
//
//    提示：
//    1 <= s.length <= 1000
//    s 只包含小写英文字母，竖线 '|' 和星号 '*' 。
//    s 包含 偶数 个竖线 '|' 。


public class Q2315 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(countAsterisks(s));
    }

    // Version 1
    private static int countAsterisks(String s) {
        int length = s.length();
        int index = 0;
        int barCount = 0;
        int res = 0;
        while (index < length) {
            if (s.charAt(index) == '*' && barCount % 2 == 0) {
                res++;
            } else if (s.charAt(index) == '|') {
                barCount++;
            }
            index++;
        }
        return res;
    }

    // Version 2
//    private static int countAsterisks(String s) {
//        boolean valid = true;
//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '|') {
//                valid = !valid;
//            } else if (c == '*' && valid) {
//                res++;
//            }
//        }
//        return res;
//    }
}
