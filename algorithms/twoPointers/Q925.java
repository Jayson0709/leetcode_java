package algorithms.twoPointers;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
//
//    You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
//
//    Example 1:
//    Input: name = "alex", typed = "aaleex"
//    Output: true
//    Explanation: 'a' and 'e' in 'alex' were long pressed.
//
//    Example 2:
//    Input: name = "saeed", typed = "ssaaedd"
//    Output: false
//    Explanation: 'e' must have been pressed twice, but it was not in the typed output.
//
//    Constraints:
//    1 <= name.length, typed.length <= 1000
//    name and typed consist of only lowercase English letters.



//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
//
//    你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
//
//    示例 1：
//    输入：name = "alex", typed = "aaleex"
//    输出：true
//    解释：'alex' 中的 'a' 和 'e' 被长按。
//
//    示例 2：
//    输入：name = "saeed", typed = "ssaaedd"
//    输出：false
//    解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
//
//    提示：
//    1 <= name.length, typed.length <= 1000
//    name 和 typed 的字符都是小写字母



public class Q925 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String name = cin.nextLine().strip();
        String typed = cin.nextLine().strip();
        cin.close();
        System.out.println(isLongPressedName(name, typed));
    }

    private static boolean isLongPressedName(String name, String typed) {
        int ptr1 = 0, ptr2 = 0;
        int n = name.length();
        while (ptr2 < typed.length()) {
            if (ptr1 < n && name.charAt(ptr1) == typed.charAt(ptr2)) {
                ptr1++;
                ptr2++;
            } else if (ptr2 > 0 && typed.charAt(ptr2) == typed.charAt(ptr2 - 1)) {
                ptr2++;
            } else {
                return false;
            }
        }
        return ptr1 == n;
    }
}
