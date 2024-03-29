package algorithms.search.bfs;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a string s of even length consisting of digits from 0 to 9, and two integers a and b.
//
//    You can apply either of the following two operations any number of times and in any order on s:
//
//    Add 'a' to all odd indices of s (0-indexed). Digits post 9 are cycled back to 0. For example, if s = "3456" and a = 5, s becomes "3951".
//    Rotate s to the right by b positions. For example, if s = "3456" and b = 1, s becomes "6345".
//    Return lexicographically the smallest string you can obtain by applying the above operations any number of times on s.
//
//    A string 'a' is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b. For example, "0158" is lexicographically smaller than "0190" because the first position they differ is at the third letter, and '5' comes before '9'.
//
//    Example 1:
//    Input: s = "5525", a = 9, b = 2
//    Output: "2050"
//    Explanation: We can apply the following operations:
//    Start:  "5525"
//    Rotate: "2555"
//    Add:    "2454"
//    Add:    "2353"
//    Rotate: "5323"
//    Add:    "5222"
//    Add:    "5121"
//    Rotate: "2151"
//    Add:    "2050"
//    There is no way to obtain a string that is lexicographically smaller than "2050".
//
//    Example 2:
//    Input: s = "74", a = 5, b = 1
//    Output: "24"
//    Explanation: We can apply the following operations:
//    Start:  "74"
//    Rotate: "47"
//    Add:    "42"
//    Rotate: "24"
//    There is no way to obtain a string that is lexicographically smaller than "24".
//
//    Example 3:
//    Input: s = "0011", a = 4, b = 2
//    Output: "0011"
//    Explanation: There are no sequence of operations that will give us a lexicographically smaller string than "0011".
//
//    Constraints:
//    2 <= s.length <= 100
//    s.length is even.
//    s consists of digits from 0 to 9 only.
//    1 <= a <= 9
//    1 <= b <= s.length - 1



//给你一个字符串 s 以及两个整数 a 和 b 。其中，字符串 s 的长度为偶数，且仅由数字 0 到 9 组成。
//
//    你可以在 s 上按任意顺序多次执行下面两个操作之一：
//
//    累加：将 a 加到 s 中所有下标为奇数的元素上（下标从 0 开始）。数字一旦超过 9 就会变成 0，如此循环往复。例如，s = "3456" 且 a = 5，则执行此操作后 s 变成 "3951"。
//    轮转：将 s 向右轮转 b 位。例如，s = "3456" 且 b = 1，则执行此操作后 s 变成 "6345"。
//    请你返回在 s 上执行上述操作任意次后可以得到的 字典序最小 的字符串。
//
//    如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，字符串 a 中的字符出现在字母表中的时间早于 b 中的对应字符。例如，"0158” 字典序比 "0190" 小，因为不同的第一个位置是在第三个字符，显然 '5' 出现在 '9' 之前。
//
//    示例 1：
//    输入：s = "5525", a = 9, b = 2
//    输出："2050"
//    解释：执行操作如下：
//    初态："5525"
//    轮转："2555"
//    累加："2454"
//    累加："2353"
//    轮转："5323"
//    累加："5222"
//    累加："5121"
//    轮转："2151"
//    累加："2050"
//    无法获得字典序小于 "2050" 的字符串。
//
//    示例 2：
//    输入：s = "74", a = 5, b = 1
//    输出："24"
//    解释：执行操作如下：
//    初态："74"
//    轮转："47"
//    累加："42"
//    轮转："24"
//    无法获得字典序小于 "24" 的字符串。
//
//    示例 3：
//    输入：s = "0011", a = 4, b = 2
//    输出："0011"
//    解释：无法获得字典序小于 "0011" 的字符串。
//
//    示例 4：
//    输入：s = "43987654", a = 7, b = 3
//    输出："00553311"
//
//    提示：
//    2 <= s.length <= 100
//    s.length 是偶数
//    s 仅由数字 0 到 9 组成
//    1 <= a <= 9
//    1 <= b <= s.length - 1


public class Q1625 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        int a = cin.nextInt();
        int b = cin.nextInt();
        cin.close();

        String result = findLexSmallestString(s, a, b);
        System.out.println(result);
    }

    // Method 1: BFS
//    private static String findLexSmallestString(String s, int a, int b) {
//        SortedSet<String> set = new TreeSet<>();
//        Deque<String> q = new ArrayDeque<>();
//        set.add(s);
//        q.offer(s);
//        while (!q.isEmpty()) {
//            String cur = q.poll();
//            int len = cur.length();
//            String temp1 = cur.substring(len - b) + cur.substring(0, len - b);
//            helper(temp1, set, q);
//            char[] arr = cur.toCharArray();
//            for (int i = 1; i < len; i += 2) {
//                arr[i] = (char) ((arr[i] - '0' + a) % 10 + '0');
//            }
//            String temp2 = new String(arr);
//            helper(temp2, set, q);
//        }
//        return set.first();
//    }
//
//    private static void helper(String s, SortedSet<String> set, Deque<String> q) {
//        if (!set.contains(s)) {
//            set.add(s);
//            q.offer(s);
//        }
//    }

    // Method 2: enumerate
    private static String findLexSmallestString(String s, int a, int b) {
        int length = s.length();
        String res = s;
        for (int i = 0; i < length; i++) {
            s = s.substring(b) + s.substring(0, b);
            char[] chars = s.toCharArray();
            for (int j = 0; j < 10; j++) {
                for (int k = 1; k < length; k += 2) {
                    chars[k] = (char) (((chars[k] - '0' + a) % 10) + '0');
                }
                if ((b & 1) == 1) {
                    for (int p = 0; p < 10; ++p) {
                        for (int k = 0; k < length; k += 2) {
                            chars[k] = (char) (((chars[k] - '0' + a) % 10) + '0');
                        }
                        s = String.valueOf(chars);
                        if (res.compareTo(s) > 0) {
                            res = s;
                        }
                    }
                } else {
                    s = String.valueOf(chars);
                    if (res.compareTo(s) > 0) {
                        res = s;
                    }
                }
            }
        }
        return res;
    }
}
