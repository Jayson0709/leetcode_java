package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


//A password is said to be strong if it satisfies all the following criteria:
//
//    It has at least 8 characters.
//    It contains at least one lowercase letter.
//    It contains at least one uppercase letter.
//    It contains at least one digit.
//    It contains at least one special character. The special characters are the characters in the following string: "!@#$%^&*()-+".
//    It does not contain 2 of the same character in adjacent positions (i.e., "aab" violates this condition, but "aba" does not).
//    Given a string password, return true if it is a strong password. Otherwise, return false.
//
//    Example 1:
//    Input: password = "IloveLe3tcode!"
//    Output: true
//    Explanation: The password meets all the requirements. Therefore, we return true.
//
//    Example 2:
//    Input: password = "Me+You--IsMyDream"
//    Output: false
//    Explanation: The password does not contain a digit and also contains 2 of the same character in adjacent positions. Therefore, we return false.
//
//    Example 3:
//    Input: password = "1aB!"
//    Output: false
//    Explanation: The password does not meet the length requirement. Therefore, we return false.
//
//    Constraints:
//    1 <= password.length <= 100
//    password consists of letters, digits, and special characters: "!@#$%^&*()-+".


//如果一个密码满足以下所有条件，我们称它是一个 强 密码：
//
//    它有至少 8 个字符。
//    至少包含 一个小写英文 字母。
//    至少包含 一个大写英文 字母。
//    至少包含 一个数字 。
//    至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
//    它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
//    给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。
//
//    示例 1：
//    输入：password = "IloveLe3tcode!"
//    输出：true
//    解释：密码满足所有的要求，所以我们返回 true 。
//
//    示例 2：
//    输入：password = "Me+You--IsMyDream"
//    输出：false
//    解释：密码不包含数字，且包含 2 个连续相同的字符。所以我们返回 false 。
//
//    示例 3：
//    输入：password = "1aB!"
//    输出：false
//    解释：密码不符合长度要求。所以我们返回 false 。
//
//    提示：
//    1 <= password.length <= 100
//    password 包含字母，数字和 "!@#$%^&*()-+" 这些特殊字符。


public class Q2299 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String password = cin.nextLine().strip();
        cin.close();
        System.out.println(strongPasswordCheckerII(password));
    }

    private static boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }

        Set<Character> specials = new HashSet<>() {{
            add('!');
            add('@');
            add('#');
            add('$');
            add('%');
            add('^');
            add('&');
            add('*');
            add('(');
            add(')');
            add('-');
            add('+');
        }};
        int n = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        for (int i = 0; i < n; ++i) {
            if (i != n - 1 && password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (specials.contains(ch)) {
                hasSpecial = true;
            }
        }
        return hasLower && hasUpper && hasDigit && hasSpecial;
    }
}
