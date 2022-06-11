package math;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
//
//    Answers within 10-5 of the actual value will be accepted as correct.
//
//    Example 1:
//    Input: hour = 12, minutes = 30
//    Output: 165
//
//    Example 2:
//    Input: hour = 3, minutes = 30
//    Output: 75
//
//    Example 3:
//    Input: hour = 3, minutes = 15
//    Output: 7.5
//
//    Constraints:
//    1 <= hour <= 12
//    0 <= minutes <= 59


//给你两个数hour和minutes。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
//
//    示例 1：
//    输入：hour = 12, minutes = 30
//    输出：165
//
//    示例 2：
//    输入：hour = 3, minutes = 30
//    输出；75
//
//    示例 3：
//    输入：hour = 3, minutes = 15
//    输出：7.5
//
//    示例 4：
//    输入：hour = 4, minutes = 50
//    输出：155
//
//    示例 5：
//    输入：hour = 12, minutes = 0
//    输出：0
//
//
//    提示：
//    1 <= hour <= 12
//    0 <= minutes <= 59
//    与标准答案误差在10^-5以内的结果都被视为正确结果。


public class Q1344 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int hour = cin.nextInt();
        int minutes = cin.nextInt();
        cin.close();

        double result = angleClock(hour, minutes);
        System.out.println(result);
    }

    private static double angleClock(int hour, int minutes) {
        // Each minute, the hour band will go 0.5 degree, and the minute band will go 6 degrees.
        // Each hour,the hour band will go 30 degrees.
        double angle = Math.abs(hour * 30 - minutes * 5.5);
        return Math.min(angle, 360 - angle);
    }
}
