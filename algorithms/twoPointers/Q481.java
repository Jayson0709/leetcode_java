package algorithms.twoPointers;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//A magical string s consists of only '1' and '2' and obeys the following rules:
//
//    The string s is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string s itself.
//    The first few elements of s is s = "1221121221221121122……". If we group the consecutive 1's and 2's in s, it will be "1 22 11 2 1 22 1 22 11 2 11 22 ......" and the occurrences of 1's or 2's in each group are "1 2 2 1 1 2 1 2 2 1 2 2 ......". You can see that the occurrence sequence is s itself.
//
//    Given an integer n, return the number of 1's in the first n number in the magical string s.
//
//    Example 1:
//    Input: n = 6
//    Output: 3
//    Explanation: The first 6 elements of magical string s is "122112" and it contains three 1's, so return 3.
//
//    Example 2:
//    Input: n = 1
//    Output: 1
//
//    Constraints:
//    1 <= n <= 10^5



//神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
//
//    神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
//    s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。上面的出现次数正是 s 自身。
//
//    给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
//
//    示例 1：
//    输入：n = 6
//    输出：3
//    解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。
//
//    示例 2：
//    输入：n = 1
//    输出：1
//
//    提示：
//    1 <= n <= 10^5



public class Q481 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(magicalString(n));
    }

    private static int magicalString(int n) {
        if (n < 4) {
            return 1;
        }
        char[] s = new char[n];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';
        int res = 1;
        int i = 2;
        int j = 3;
        while (j < n) {
            int size = s[i] - '0';
            int num = 3 - (s[j - 1] - '0');
            while (size > 0 && j < n) {
                s[j] = (char) ('0' + num);
                if (num == 1) {
                    ++res;
                }
                j++;
                size--;
            }
            i++;
        }
        return res;
    }
}
