package dataStructures.string;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..
//
//    Return lexicographically the smallest string you could have after applying the mentioned step any number of moves.
//
//    Example 1:
//    Input: s = "cba", k = 1
//    Output: "acb"
//    Explanation:
//    In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
//    In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".
//    
//    Example 2:
//    Input: s = "baaca", k = 3
//    Output: "aaabc"
//    Explanation:
//    In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
//    In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".
//
//    Constraints:
//    1 <= k <= s.length <= 1000
//    s consist of lowercase English letters.



//给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
//
//    返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
//
//    示例 1：
//    输入：s = "cba", k = 1
//    输出："acb"
//    解释：
//    在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
//    在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
//
//    示例 2：
//    输入：s = "baaca", k = 3
//    输出："aaabc"
//    解释：
//    在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
//    在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
//
//    提示：
//    1 <= k <= S.length <= 1000
//    s 只由小写字母组成。



public class Q899 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        int k = cin.nextInt();
        cin.close();
        System.out.println(orderlyQueue(s, k));
    }

    private static String orderlyQueue(String s, int k) {
        if (k == 1) {
            String smallest = s;
            StringBuilder sb = new StringBuilder(s);
            int n = s.length();
            for (int i = 1; i < n; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if (sb.toString().compareTo(smallest) < 0) {
                    smallest = sb.toString();
                }
            }
            return smallest;
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }
}
