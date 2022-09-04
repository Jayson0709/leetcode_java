package algorithms.greedyAlgorithms;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
//
//    Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
//
//    Return a list of integers representing the size of these parts.
//
//    Example 1:
//    Input: s = "ababcbacadefegdehijhklij"
//    Output: [9,7,8]
//    Explanation:
//    The partition is "ababcbaca", "defegde", "hijhklij".
//    This is a partition so that each letter appears in at most one part.
//    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
//
//    Example 2:
//    Input: s = "eccbbbbdec"
//    Output: [10]
//
//    Constraints:
//    1 <= s.length <= 500
//    s consists of lowercase English letters.


//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//
//    示例：
//
//    输入：S = "ababcbacadefegdehijhklij"
//    输出：[9,7,8]
//    解释：
//    划分结果为 "ababcbaca", "defegde", "hijhklij"。
//    每个字母最多出现在一个片段中。
//    像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
//
//    提示：
//    S的长度在[1, 500]之间。
//    S只包含小写字母 'a' 到 'z' 。



public class Q763 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(partitionLabels(s));
    }

    private static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        int[] lastIndexes = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            lastIndexes[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, lastIndexes[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
