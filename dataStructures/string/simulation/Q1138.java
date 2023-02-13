package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
//
//    Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
//    abcde
//    fghij
//    klmno
//    pqrst
//    uvwxy
//    z
//
//    We may make the following moves:
//
//    'U' moves our position up one row, if the position exists on the board;
//    'D' moves our position down one row, if the position exists on the board;
//    'L' moves our position left one column, if the position exists on the board;
//    'R' moves our position right one column, if the position exists on the board;
//    '!' adds the character board[r][c] at our current position (r, c) to the answer.
//    (Here, the only positions that exist on the board are positions with letters on them.)
//
//    Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.
//
//    Example 1:
//    Input: target = "leet"
//    Output: "DDR!UURRR!!DDD!"
//
//    Example 2:
//    Input: target = "code"
//    Output: "RR!DDRR!UUL!R!"
//
//    Constraints:
//    1 <= target.length <= 100
//    target consists only of English lowercase letters.


//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
//
//    在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
//    abcde
//    fghij
//    klmno
//    pqrst
//    uvwxy
//    z
//
//    我们可以按下面的指令规则行动：
//
//    如果方格存在，'U' 意味着将我们的位置上移一行；
//    如果方格存在，'D' 意味着将我们的位置下移一行；
//    如果方格存在，'L' 意味着将我们的位置左移一列；
//    如果方格存在，'R' 意味着将我们的位置右移一列；
//    '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
//    （注意，字母板上只存在有字母的位置。）
//
//    返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
//
//    示例 1：
//    输入：target = "leet"
//    输出："DDR!UURRR!!DDD!"
//
//    示例 2：
//    输入：target = "code"
//    输出："RR!DDRR!UUL!R!"
//
//    提示：
//    1 <= target.length <= 100
//    target 仅含有小写英文字母。


public class Q1138 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String target = cin.nextLine().strip();
        cin.close();
        System.out.println(alphabetBoardPath(target));
    }

    private static String alphabetBoardPath(String target) {
        int cx = 0, cy = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int nx = (c - 'a') / 5;
            int ny = (c - 'a') % 5;
            if (nx < cx) {
                res.append("U".repeat(cx - nx));
            }
            if (ny < cy) {
                res.append("L".repeat(cy - ny));
            }
            if (nx > cx) {
                res.append("D".repeat(nx - cx));
            }
            if (ny > cy) {
                res.append("R".repeat(ny - cy));
            }
            res.append('!');
            cx = nx;
            cy = ny;
        }
        return res.toString();
    }
}
