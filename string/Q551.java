package string;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a string s representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
//
//    'A': Absent.
//    'L': Late.
//    'P': Present.
//    The student is eligible for an attendance award if they meet both of the following criteria:
//      The student was absent ('A') for strictly fewer than 2 days total.
//      The student was never late ('L') for 3 or more consecutive days.
//      Return true if the student is eligible for an attendance award, or false otherwise.
//
//    Example 1:
//    Input: s = "PPALLP"
//    Output: true
//    Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
//
//    Example 2:
//    Input: s = "PPALLL"
//    Output: false
//    Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
//
//    Constraints:
//    1 <= s.length <= 1000
//    s[i] is either 'A', 'L', or 'P'.


//给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
//
//    'A'：Absent，缺勤
//    'L'：Late，迟到
//    'P'：Present，到场
//    如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
//      按 总出勤 计，学生缺勤（'A'）严格 少于两天。
//      学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
//      如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
//
//    示例 1：
//    输入：s = "PPALLP"
//    输出：true
//    解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
//
//    示例 2：
//    输入：s = "PPALLL"
//    输出：false
//    解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
//
//    提示：
//    1 <= s.length <= 1000
//    s[i] 为 'A'、'L' 或 'P'



public class Q551 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(checkRecord(s));
    }

    private static boolean checkRecord(String s) {
        int lateCount = 0, absentCount = 0;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == 'A') {
                absentCount++;
                index++;
            } else if (s.charAt(index) == 'L') {
                while (index < s.length() && s.charAt(index) == 'L') {
                    lateCount++;
                    index++;
                }
            } else {
                index++;
            }
            if (absentCount >= 2 || lateCount >= 3) {
                return false;
            }
            lateCount = 0;
        }
        return true;
    }
}
