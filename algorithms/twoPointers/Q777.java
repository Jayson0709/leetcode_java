package algorithms.twoPointers;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.
//
//    Example 1:
//    Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
//    Output: true
//    Explanation: We can transform start to end following these steps:
//    RXXLRXRXL ->
//    XRXLRXRXL ->
//    XRLXRXRXL ->
//    XRLXXRRXL ->
//    XRLXXRRLX
//
//    Example 2:
//    Input: start = "X", end = "L"
//    Output: false
//
//    Constraints:
//    1 <= start.length <= 10^4
//    start.length == end.length
//    Both start and end will only consist of characters in 'L', 'R', and 'X'.


//在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
//
//    示例 :
//    输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
//    输出: True
//    解释:
//    我们可以通过以下几步将start转换成end:
//    RXXLRXRXL ->
//    XRXLRXRXL ->
//    XRLXRXRXL ->
//    XRLXXRRXL ->
//    XRLXXRRLX
//
//    提示：
//    1 <= len(start) = len(end) <= 10000。
//    start和end中的字符串仅限于'L', 'R'和'X'。


public class Q777 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String start = cin.nextLine().strip();
        String end = cin.nextLine().strip();
        cin.close();
        System.out.println(canTransform(start, end));
    }

    private static boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }
}
