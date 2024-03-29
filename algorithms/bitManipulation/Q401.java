package algorithms.bitManipulation;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
//
//    For example, the below binary watch reads "4:51".
//    H     8    4    2    1      PM
//    *    *
//    M   32   16   8   4   2   1
//        *    *           *
//    Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.
//
//    The hour must not contain a leading zero.
//
//    For example, "01:00" is not valid. It should be "1:00".
//    The minute must consist of two digits and may contain a leading zero.
//
//    For example, "10:2" is not valid. It should be "10:02".
//
//    Example 1:
//    Input: turnedOn = 1
//    Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
//
//    Example 2:
//    Input: turnedOn = 9
//    Output: []
//
//    Constraints:
//    0 <= turnedOn <= 10



//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
//
//    例如，下面的二进制手表读取 "3:25" 。
//    H     8    4    2    1      PM
//                    *    *
//    M   32   16   8   4   2   1
//              *   *           *
//    （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 Unported (CC BY-SA 3.0) ）
//
//    给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
//
//    小时不会以零开头：
//
//    例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
//    分钟必须由两位数组成，可能会以零开头：
//
//    例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
//
//    示例 1：
//    输入：turnedOn = 1
//    输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
//
//    示例 2：
//    输入：turnedOn = 9
//    输出：[]
//
//    提示：
//    0 <= turnedOn <= 10



public class Q401 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int turnedOn = cin.nextInt();
        cin.close();
        System.out.println(readBinaryWatch(turnedOn));
    }

    // Method 1: Enumeration
//    public static List<String> readBinaryWatch(int turnedOn) {
//        List<String> result = new ArrayList<>();
//        for (int h = 0; h < 12; h++) {
//            for (int m = 0; m < 60; m++) {
//                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
//                    result.add(h + ":" + (m < 10 ? "0" : "") + m);
//                }
//            }
//        }
//        return result;
//    }

    // Method 2: Bit manipulation
    private static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            int h = i >> 6, m = i & 63; // Use bit manipulation to get the 4 MSB and 6 LSB
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                result.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return result;
    }
}
