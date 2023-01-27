package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a string of English letters s, return the greatest English letter which occurs as both a lowercase and uppercase letter in s. The returned letter should be in uppercase. If no such letter exists, return an empty string.
//
//    An English letter b is greater than another letter 'a' if 'b' appears after 'a' in the English alphabet.
//
//    Example 1:
//    Input: s = "lEeTcOdE"
//    Output: "E"
//    Explanation:
//    The letter 'E' is the only letter to appear in both lower and upper case.
//
//    Example 2:
//    Input: s = "arRAzFif"
//    Output: "R"
//    Explanation:
//    The letter 'R' is the greatest letter to appear in both lower and upper case.
//    Note that 'A' and 'F' also appear in both lower and upper case, but 'R' is greater than 'F' or 'A'.
//
//    Example 3:
//    Input: s = "AbCdEfGhIjK"
//    Output: ""
//    Explanation:
//    There is no letter that appears in both lower and upper case.
//
//    Constraints:
//    1 <= s.length <= 1000
//    s consists of lowercase and uppercase English letters.



//给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
//
//    最好 英文字母的大写和小写形式必须 都 在 s 中出现。
//
//    英文字母 b 比另一个英文字母a更好 的前提是：英文字母表中，b 在 a 之 后 出现。
//
//    示例 1：
//    输入：s = "lEeTcOdE"
//    输出："E"
//    解释：
//    字母 'E' 是唯一一个大写和小写形式都出现的字母。
//
//    示例 2：
//    输入：s = "arRAzFif"
//    输出："R"
//    解释：
//    字母 'R' 是大写和小写形式都出现的最好英文字母。
//    注意 'A' 和 'F' 的大写和小写形式也都出现了，但是 'R' 比 'F' 和 'A' 更好。
//
//    示例 3：
//    输入：s = "AbCdEfGhIjK"
//    输出：""
//    解释：
//    不存在大写和小写形式都出现的字母。
//
//    提示：
//    1 <= s.length <= 1000
//    s 由小写和大写英文字母组成



public class Q2309 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(greatestLetter(s));
    }

    // Method 1: HashMap
    private static String greatestLetter(String s) {
        char[] letters = s.toCharArray();
        Map<Character, Integer> hMap = new HashMap<>();
        for (char letter : letters) {
            hMap.put(letter, hMap.getOrDefault(letter, 0) + 1);
        }
        int k = 'a' - 'A';
        StringBuilder res = new StringBuilder();
        for (char i = 'Z'; i >= 'A'; i--) {
            if (hMap.getOrDefault(i, 0) > 0 && hMap.getOrDefault((char)(i + k), 0) > 0) {
                res.append(i);
                break;
            }
        }
        return res.toString();
    }

    // Method 2: HashSet
//    private static String greatestLetter(String s) {
//        Set<Character> hashSet = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            hashSet.add(c);
//        }
//        for (int i = 25; i >= 0; i--) {
//            if (hashSet.contains((char) ('a' + i)) && hashSet.contains((char) ('A' + i))) {
//                return String.valueOf((char) ('A' + i));
//            }
//        }
//        return "";
//    }

    // Method 3: Bit Manipulation
//    private static String greatestLetter(String s) {
//        int lower = 0, upper = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (Character.isLowerCase(c)) {
//                lower |= 1 << (c - 'a');
//            } else {
//                upper |= 1 << (c - 'A');
//            }
//        }
//        for (int i = 25; i >= 0; i--) {
//            if ((lower & upper & (1 << i)) != 0) {
//                return String.valueOf((char) ('A' + i));
//            }
//        }
//        return "";
//    }
}
