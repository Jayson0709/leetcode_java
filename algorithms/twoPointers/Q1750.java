package algorithms.twoPointers;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:
//
//    Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
//    Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
//    The prefix and the suffix should not intersect at any index.
//    The characters from the prefix and suffix must be the same.
//    Delete both the prefix and the suffix.
//    Return the minimum length of s after performing the above operation any number of times (possibly zero times).
//
//    Example 1:
//    Input: s = "ca"
//    Output: 2
//    Explanation: You can't remove any characters, so the string stays as is.
//
//    Example 2:
//    Input: s = "cabaabac"
//    Output: 0
//    Explanation: An optimal sequence of operations is:
//    - Take prefix = "c" and suffix = "c" and remove them, s = "abaaba".
//    - Take prefix = "a" and suffix = "a" and remove them, s = "baab".
//    - Take prefix = "b" and suffix = "b" and remove them, s = "aa".
//    - Take prefix = "a" and suffix = "a" and remove them, s = "".
//
//    Example 3:
//    Input: s = "aabccabba"
//    Output: 3
//    Explanation: An optimal sequence of operations is:
//    - Take prefix = "aa" and suffix = "a" and remove them, s = "bccabb".
//    - Take prefix = "b" and suffix = "bb" and remove them, s = "cca".
//
//    Constraints:
//    1 <= s.length <= 10^5
//    s only consists of characters 'a', 'b', and 'c'.


//给你一个只包含字符 'a'，'b'和 'c'的字符串s，你可以执行下面这个操作（5 个步骤）任意次：
//
//    选择字符串 s一个 非空 的前缀，这个前缀的所有字符都相同。
//    选择字符串 s一个 非空 的后缀，这个后缀的所有字符都相同。
//    前缀和后缀在字符串中任意位置都不能有交集。
//    前缀和后缀包含的所有字符都要相同。
//    同时删除前缀和后缀。
//    请你返回对字符串 s执行上面操作任意次以后（可能 0 次），能得到的 最短长度。
//
//    示例 1：
//    输入：s = "ca"
//    输出：2
//    解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
//
//    示例 2：
//    输入：s = "cabaabac"
//    输出：0
//    解释：最优操作序列为：
//    - 选择前缀 "c" 和后缀 "c" 并删除它们，得到 s = "abaaba" 。
//    - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "baab" 。
//    - 选择前缀 "b" 和后缀 "b" 并删除它们，得到 s = "aa" 。
//    - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "" 。
//
//    示例 3：
//    输入：s = "aabccabba"
//    输出：3
//    解释：最优操作序列为：
//    - 选择前缀 "aa" 和后缀 "a" 并删除它们，得到 s = "bccabb" 。
//    - 选择前缀 "b" 和后缀 "bb" 并删除它们，得到 s = "cca" 。
//
//    提示：
//    1 <= s.length <= 10^5
//    s只包含字符'a'，'b'和'c'。



public class Q1750 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(minimumLength(s));
    }

    private static int minimumLength(String s) {
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right && chars[left] == chars[right]) {
            while (left + 1 <= right && chars[left + 1] == chars[left]) {
                left++;
            }
            while (right - 1 >= left && chars[right - 1] == chars[right]) {
                right--;
            }
            left++;
            right--;
        }
        return Math.max(right - left + 1, 0);
    }
}
