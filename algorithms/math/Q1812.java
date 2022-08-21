package algorithms.math;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given coordinates, a string that represents the coordinates of a square of the chessboard. Below is a chessboard for your reference.
//
//    8| W | B | W | B | W | B | W | B |
//    7| B | W | B | W | B | W | B | W |
//    6| W | B | W | B | W | B | W | B |
//    5| B | W | B | W | B | W | N | W |
//    4| W | B | W | B | W | B | W | B |
//    3| B | W | B | W | B | W | N | W |
//    2| W | B | W | B | W | B | W | B |
//    1| B | W | B | W | B | W | N | W |
//       a   b   c   d   e   f   g   h
//
//    Return true if the square is white, and false if the square is black.
//
//    The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number second.
//
//    Example 1:
//    Input: coordinates = "a1"
//    Output: false
//    Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.
//
//    Example 2:
//    Input: coordinates = "h3"
//    Output: true
//    Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.
//
//    Example 3:
//    Input: coordinates = "c7"
//    Output: false
//
//    Constraints:
//    coordinates.length == 2
//    'a' <= coordinates[0] <= 'h'
//    '1' <= coordinates[1] <= '8'



//给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
//
//    8| W | B | W | B | W | B | W | B |
//    7| B | W | B | W | B | W | B | W |
//    6| W | B | W | B | W | B | W | B |
//    5| B | W | B | W | B | W | N | W |
//    4| W | B | W | B | W | B | W | B |
//    3| B | W | B | W | B | W | N | W |
//    2| W | B | W | B | W | B | W | B |
//    1| B | W | B | W | B | W | N | W |
//       a   b   c   d   e   f   g   h
//
//    如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
//
//    给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
//
//    示例 1：
//    输入：coordinates = "a1"
//    输出：false
//    解释：如上图棋盘所示，"a1" 坐标的格子是黑色的，所以返回 false 。
//
//    示例 2：
//    输入：coordinates = "h3"
//    输出：true
//    解释：如上图棋盘所示，"h3" 坐标的格子是白色的，所以返回 true 。
//
//    示例 3：
//    输入：coordinates = "c7"
//    输出：false
//
//    提示：
//    coordinates.length == 2
//    'a' <= coordinates[0] <= 'h'
//    '1' <= coordinates[1] <= '8'



public class Q1812 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String coordinates = cin.nextLine().strip();
        cin.close();
        System.out.println(squareIsWhite(coordinates));
    }

    private static boolean squareIsWhite(String coordinates) {
        char x = coordinates.charAt(0);
        int y = coordinates.charAt(1) - '0';
        if (x == 'a' || x == 'c' || x == 'e' || x == 'g') {
            return y % 2 == 0;
        } else if (x == 'b' || x == 'd' || x == 'f' || x == 'h') {
            return y % 2 != 0;
        }
        return true;
    }
}
