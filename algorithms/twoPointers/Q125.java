package algorithms.twoPointers;
import java.util.*;
import java.nio.charset.StandardCharsets;

//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//    Given a string s, return true if it is a palindrome, or false otherwise.
//
//    Example 1:
//    Input: s = "A man, a plan, a canal: Panama"
//    Output: true
//    Explanation: "amanaplanacanalpanama" is a palindrome.
//
//    Example 2:
//    Input: s = "race a car"
//    Output: false
//    Explanation: "raceacar" is not a palindrome.
//
//    Example 3:
//    Input: s = " "
//    Output: true
//    Explanation: s is an empty string "" after removing non-alphanumeric characters.
//    Since an empty string reads the same forward and backward, it is a palindrome.
//
//    Constraints:
//    1 <= s.length <= 2 * 10^5
//    s consists only of printable ASCII characters.


//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//    说明：本题中，我们将空字符串定义为有效的回文串。
//
//    示例 1:
//    输入: "A man, a plan, a canal: Panama"
//    输出: true
//    解释："amanaplanacanalpanama" 是回文串
//
//    示例 2:
//    输入: "race a car"
//    输出: false
//    解释："raceacar" 不是回文串
//
//    提示：
//    1 <= s.length <= 2 * 10^5
//    字符串 s 由 ASCII 字符组成


public class Q125 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String s = cin.nextLine();
        cin.close();
        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    private static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder charsBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                charsBuilder.append(c);
            }
        }
        String str = charsBuilder.toString();
        int p1 = 0;
        int p2 = str.length() - 1;
        while (p1 <= p2) {
            if (str.charAt(p1) != str.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
