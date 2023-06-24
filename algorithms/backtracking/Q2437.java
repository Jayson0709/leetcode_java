package algorithms.backtracking;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given a string of length 5 called time, representing the current time on a digital clock in the format "hh:mm". The earliest possible time is "00:00" and the latest possible time is "23:59".
//
//    In the string time, the digits represented by the ? symbol are unknown, and must be replaced with a digit from 0 to 9.
//
//    Return an integer answer, the number of valid clock times that can be created by replacing every ? with a digit from 0 to 9.
//
//    Example 1:
//    Input: time = "?5:00"
//    Output: 2
//    Explanation: We can replace the ? with either a 0 or 1, producing "05:00" or "15:00". Note that we cannot replace it with a 2, since the time "25:00" is invalid. In total, we have two choices.
//
//    Example 2:
//    Input: time = "0?:0?"
//    Output: 100
//    Explanation: Each ? can be replaced by any digit from 0 to 9, so we have 100 total choices.
//
//    Example 3:
//    Input: time = "??:??"
//    Output: 1440
//    Explanation: There are 24 possible choices for the hours, and 60 possible choices for the minutes. In total, we have 24 * 60 = 1440 choices.
//
//    Constraints:
//    time is a valid string of length 5 in the format "hh:mm".
//    "00" <= hh <= "23"
//    "00" <= mm <= "59"
//    Some of the digits might be replaced with '?' and need to be replaced with digits from 0 to 9.


//给你一个长度为 5 的字符串 time ，表示一个电子时钟当前的时间，格式为 "hh:mm" 。最早 可能的时间是 "00:00" ，最晚 可能的时间是 "23:59" 。
//
//    在字符串 time 中，被字符 ? 替换掉的数位是 未知的 ，被替换的数字可能是 0 到 9 中的任何一个。
//
//    请你返回一个整数 answer ，将每一个 ? 都用 0 到 9 中一个数字替换后，可以得到的有效时间的数目。
//
//    示例 1：
//    输入：time = "?5:00"
//    输出：2
//    解释：我们可以将 ? 替换成 0 或 1 ，得到 "05:00" 或者 "15:00" 。注意我们不能替换成 2 ，因为时间 "25:00" 是无效时间。所以我们有两个选择。
//
//    示例 2：
//    输入：time = "0?:0?"
//    输出：100
//    解释：两个 ? 都可以被 0 到 9 之间的任意数字替换，所以我们总共有 100 种选择。
//
//    示例 3：
//    输入：time = "??:??"
//    输出：1440
//    解释：小时总共有 24 种选择，分钟总共有 60 种选择。所以总共有 24 * 60 = 1440 种选择。
//
//    提示：
//    time 是一个长度为 5 的有效字符串，格式为 "hh:mm" 。
//    "00" <= hh <= "23"
//    "00" <= mm <= "59"
//    字符串中有的数位是 '?' ，需要用 0 到 9 之间的数字替换。


public class Q2437 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String time = cin.nextLine().strip();
        cin.close();
        System.out.println(countTimes(time));
    }

    // Method 1: Enumeration
    private static int countTimes(String time) {
        int countHour = 0;
        int countMinute = 0;
        // For hours
        for (int i = 0; i < 24; i++) {
            int firstDigit = i / 10;
            int secondDigit = i % 10;
            if ((time.charAt(0) == '?' || time.charAt(0) == firstDigit + '0') &&
                (time.charAt(1) == '?' || time.charAt(1) == secondDigit + '0')) {
                countHour++;
            }
        }
        // For minutes
        for (int i = 0; i < 60; i++) {
            int firstDigit = i / 10;
            int secondDigit = i % 10;
            if ((time.charAt(3) == '?' || time.charAt(3) == firstDigit + '0') &&
                (time.charAt(4) == '?' || time.charAt(4) == secondDigit + '0')) {
                countMinute++;
            }
        }
        return countHour * countMinute;
    }
}
