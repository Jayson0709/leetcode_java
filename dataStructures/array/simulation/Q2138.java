package dataStructures.array.simulation;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;



//A string s can be partitioned into groups of size k using the following procedure:
//
//    The first group consists of the first k characters of the string, the second group consists of the next k characters of the string, and so on. Each character can be a part of exactly one group.
//    For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
//    Note that the partition is done so that after removing the fill character from the last group (if it exists) and concatenating all the groups in order, the resultant string should be s.
//
//    Given the string s, the size of each group k and the character fill, return a string array denoting the composition of every group s has been divided into, using the above procedure.
//
//    Example 1:
//    Input: s = "abcdefghi", k = 3, fill = "x"
//    Output: ["abc","def","ghi"]
//    Explanation:
//    The first 3 characters "abc" form the first group.
//    The next 3 characters "def" form the second group.
//    The last 3 characters "ghi" form the third group.
//    Since all groups can be completely filled by characters from the string, we do not need to use fill.
//    Thus, the groups formed are "abc", "def", and "ghi".
//
//    Example 2:
//    Input: s = "abcdefghij", k = 3, fill = "x"
//    Output: ["abc","def","ghi","jxx"]
//    Explanation:
//    Similar to the previous example, we are forming the first three groups "abc", "def", and "ghi".
//    For the last group, we can only use the character 'j' from the string. To complete this group, we add 'x' twice.
//    Thus, the 4 groups formed are "abc", "def", "ghi", and "jxx".
//
//    Constraints:
//    1 <= s.length <= 100
//    s consists of lowercase English letters only.
//    1 <= k <= 100
//    fill is a lowercase English letter.



//字符串 s 可以按下述步骤划分为若干长度为 k 的组：
//
//    第一组由字符串中的前 k 个字符组成，第二组由接下来的 k 个字符串组成，依此类推。每个字符都能够成为 某一个 组的一部分。
//    对于最后一组，如果字符串剩下的字符 不足 k 个，需使用字符 fill 来补全这一组字符。
//    注意，在去除最后一个组的填充字符 fill（如果存在的话）并按顺序连接所有的组后，所得到的字符串应该是 s 。
//
//    给你一个字符串 s ，以及每组的长度 k 和一个用于填充的字符 fill ，按上述步骤处理之后，返回一个字符串数组，该数组表示 s 分组后 每个组的组成情况 。
//
//    示例 1：
//    输入：s = "abcdefghi", k = 3, fill = "x"
//    输出：["abc","def","ghi"]
//    解释：
//    前 3 个字符是 "abc" ，形成第一组。
//    接下来 3 个字符是 "def" ，形成第二组。
//    最后 3 个字符是 "ghi" ，形成第三组。
//    由于所有组都可以由字符串中的字符完全填充，所以不需要使用填充字符。
//    因此，形成 3 组，分别是 "abc"、"def" 和 "ghi" 。
//
//    示例 2：
//    输入：s = "abcdefghij", k = 3, fill = "x"
//    输出：["abc","def","ghi","jxx"]
//    解释：
//    与前一个例子类似，形成前三组 "abc"、"def" 和 "ghi" 。
//    对于最后一组，字符串中仅剩下字符 'j' 可以用。为了补全这一组，使用填充字符 'x' 两次。
//    因此，形成 4 组，分别是 "abc"、"def"、"ghi" 和 "jxx" 。
//
//    提示：
//    1 <= s.length <= 100
//    s 仅由小写英文字母组成
//    1 <= k <= 100
//    fill 是一个小写英文字母


public class Q2138 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        int k = Integer.parseInt(cin.nextLine().strip());
        char fill = cin.nextLine().strip().charAt(0);
        cin.close();
        System.out.println(Arrays.toString(divideString(s, k, fill)));
    }

    private static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int len = (int) Math.ceil((double) n / k);
        String [] res = new String[len];
        int index = 0;
        for (int i = 0; i < n; i += k) {
            if (i + k <= n) {
                res[index++] = s.substring(i, i + k);
            }
            else {
                res[index++] = s.substring(i, n) + Character.toString(fill).repeat(k - (n - i));
            }
        }
        return res;
    }
}
