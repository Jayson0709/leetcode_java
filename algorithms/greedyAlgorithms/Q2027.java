package algorithms.greedyAlgorithms;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a string s consisting of n characters which are either 'X' or 'O'.
//
//    A move is defined as selecting three consecutive characters of s and converting them to 'O'. Note that if a move is applied to the character 'O', it will stay the same.
//
//    Return the minimum number of moves required so that all the characters of s are converted to 'O'.
//
//    Example 1:
//    Input: s = "XXX"
//    Output: 1
//    Explanation: XXX -> OOO
//    We select all the 3 characters and convert them in one move.
//
//    Example 2:
//    Input: s = "XXOX"
//    Output: 2
//    Explanation: XXOX -> OOOX -> OOOO
//    We select the first 3 characters in the first move, and convert them to 'O'.
//    Then we select the last 3 characters and convert them so that the final string contains all 'O's.
//
//    Example 3:
//    Input: s = "OOOO"
//    Output: 0
//    Explanation: There are no 'X's in s to convert.
//
//    Constraints:
//    3 <= s.length <= 1000
//    s[i] is either 'X' or 'O'.

// 给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
// 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。注意，如果字符已经是 'O' ，只需要保持 不变 。
// 返回将 s 中所有字符均转换为 'O' 需要执行的最少操作次数。
//
// 示例 1：
// 输入：s = "XXX"
// 输出：1
// 解释：XXX -> OOO
// 一次操作，选中全部 3 个字符，并将它们转换为 'O' 。
//
// 示例 2：
// 输入：s = "XXOX"
// 输出：2
// 解释：XXOX -> OOOX -> OOOO
// 第一次操作，选择前 3 个字符，并将这些字符转换为 'O' 。
// 然后，选中后 3 个字符，并执行转换。最终得到的字符串全由字符 'O' 组成。
//
// 示例 3：
// 输入：s = "OOOO"
// 输出：0
// 解释：s 中不存在需要转换的 'X' 。
//
// 提示：
// 3 <= s.length <= 1000
// s[i] 为 'X' 或 'O'

public class Q2027 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();

        int result = minimumMoves(s);
        System.out.println(result);
    }

    private static int minimumMoves(String s) {
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                i = i + 3;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }
}
