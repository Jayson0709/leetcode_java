package algorithms.bitManipulation;
import utils.*;

import java.nio.charset.StandardCharsets;
import java.util.*;


//You are given an n x n binary grid board. In each move, you can swap any two rows with each other, or any two columns with each other.
//
//    Return the minimum number of moves to transform the board into a chessboard board. If the task is impossible, return -1.
//
//    A chessboard board is a board where no 0's and no 1's are 4-directionally adjacent.
//
//    Example 1:
//    |0|1|1|0|        |1|0|1|0|        |1|0|1|0|
//    |0|1|1|0|   ->   |1|0|1|0|   ->   |0|1|0|1|
//    |1|0|0|1|        |0|1|0|1|        |1|0|1|0|
//    |1|0|0|1|        |0|1|0|1|        |0|1|0|1|
//    Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
//    Output: 2
//    Explanation: One potential sequence of moves is shown.
//    The first move swaps the first and second column.
//    The second move swaps the second and third row.
//
//    Example 2:
//    |0|1|
//    |1|0|
//    Input: board = [[0,1],[1,0]]
//    Output: 0
//    Explanation: Also note that the board with 0 in the top left corner, is also a valid chessboard.
//    
//    Example 3:
//    |1|0|
//    |1|0|s
//    Input: board = [[1,0],[1,0]]
//    Output: -1
//    Explanation: No matter what sequence of moves you make, you cannot end with a valid chessboard.
//    
//    Constraints:
//    n == board.length
//    n == board[i].length
//    2 <= n <= 30
//    board[i][j] is either 0 or 1.



//一个 n x n 的二维网络 board 仅由 0 和 1 组成 。每次移动，你能任意交换两列或是两行的位置。
//
//    返回 将这个矩阵变为  “棋盘”  所需的最小移动次数 。如果不存在可行的变换，输出 -1。
//
//    “棋盘” 是指任意一格的上下左右四个方向的值均与本身不同的矩阵。
//
//    示例 1:
//    |0|1|1|0|        |1|0|1|0|        |1|0|1|0|
//    |0|1|1|0|   ->   |1|0|1|0|   ->   |0|1|0|1|
//    |1|0|0|1|        |0|1|0|1|        |1|0|1|0|
//    |1|0|0|1|        |0|1|0|1|        |0|1|0|1|
//    输入: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
//    输出: 2
//    解释:一种可行的变换方式如下，从左到右：
//    第一次移动交换了第一列和第二列。
//    第二次移动交换了第二行和第三行。
//
//    示例 2:
//    |0|1|
//    |1|0|
//    输入: board = [[0, 1], [1, 0]]
//    输出: 0
//    解释: 注意左上角的格值为0时也是合法的棋盘，也是合法的棋盘.
//
//    示例 3:
//    |1|0|
//    |1|0|
//    输入: board = [[1, 0], [1, 0]]
//    输出: -1
//    解释: 任意的变换都不能使这个输入变为合法的棋盘。
//
//    提示：
//    n == board.length
//    n == board[i].length
//    2 <= n <= 30
//    board[i][j] 将只包含 0或 1



public class Q782 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, data);
        cin.close();
        System.out.println(movesToChessboard(DataConversionMethods.convertIntArrArrayListTo2DArray(data)));
    }

    // Method 1: pure Math problem
    // Ref: https://leetcode.cn/problems/transform-to-chessboard/solution/bian-wei-qipan-by-capital-worker-rlzb/
//    private static int movesToChessboard(int[][] board) {
//        if (!check(board)) {
//            return -1;
//        }
//        int[] col = new int[board.length];
//        for (int i = 0; i < board.length; i++) {
//            col[i] = board[i][0];
//        }
//        return getSwapCount(board[0]) + getSwapCount(col);
//    }
//
//    public static boolean check(int[][] board) {
//        return checkFirstRow(board) &&
//            checkFirstCol(board) &&
//            checkRow(board) &&
//            checkCol(board);
//    }
//
//    public static boolean checkFirstRow(int[][] board) {
//        int rowOneCnt = 0;
//        int rowZeroCnt = 0;
//        int[] first = board[0];
//        for (int num : first) {
//            if (num == 0) {
//                rowZeroCnt++;
//            } else {
//                rowOneCnt++;
//            }
//        }
//        return rowOneCnt == rowZeroCnt || Math.abs(rowOneCnt - rowZeroCnt) == 1;
//    }
//
//    public static boolean checkFirstCol(int[][] board) {
//        int oneCnt = 0, zeroCnt = 0;
//        for (int i = 0; i < board.length; i++) {
//            if (board[0][i] == 0) {
//                zeroCnt++;
//            } else {
//                oneCnt++;
//            }
//        }
//        return oneCnt == zeroCnt || Math.abs(oneCnt - zeroCnt) == 1;
//    }
//
//    public static boolean checkRow(int[][] board) {
//        //The first row acts as a sentinel and all the other rows are
//        // either equal to the first row or opposite the first row
//        //For example, rows following row 0110 can only be 0110 and 1001
//        int[] sentinel = board[0];
//        int sameCnt = 0, oppositeCnt = 0;
//        for (int[] cur : board) {
//            // row equal to the sentinel
//            if (sentinel[0] == cur[0]) {
//                for (int i = 0; i < sentinel.length; i++) {
//                    if (sentinel[i] != cur[i]) {
//                        return false;
//                    }
//                }
//                sameCnt++;
//            } else {
//                // row opposite to the sentinel
//                for (int i = 0; i < sentinel.length; i++) {
//                    if (sentinel[i] + cur[i] != 1) {
//                        return false;
//                    }
//                }
//                oppositeCnt++;
//            }
//        }
//        return sameCnt == oppositeCnt || Math.abs(sameCnt - oppositeCnt) == 1;
//    }
//
//    public static boolean checkCol(int[][] board) {
//        //The first column acts as a sentinel and all the other columns are
//        // either equal to the first column or opposite the first column
//        //For example, columns following column 0110 can only be 0110 and 1001
//        int sameCnt = 0, oppositeCnt = 0;
//        int[] sentinel = new int[board.length];
//        for (int j = 0; j < board.length; j++) {
//            sentinel[j] = board[j][0];
//        }
//        for (int j = 0; j < board.length; j++) {
//            if (board[0][j] == sentinel[0]) {
//                for (int i = 0; i < sentinel.length; i++) {
//                    if (sentinel[i] != board[i][j]) {
//                        return false;
//                    }
//                }
//                sameCnt++;
//            } else {
//                for (int i = 0; i < sentinel.length; i++) {
//                    if (sentinel[i] + board[i][j] != 1) {
//                        return false;
//                    }
//                }
//                oppositeCnt++;
//            }
//        }
//        return sameCnt == oppositeCnt || Math.abs(sameCnt - oppositeCnt) == 1;
//    }
//
//    private static int getSwapCount(int[] sentinel) {
//        // Assume all to be 10101010
//        int preNum = 1;
//        int errorCnt = 0;
//        for (int i : sentinel) {
//            // Count how many mismatches there are
//            if (i != preNum) {
//                errorCnt++;
//            }
//            preNum = preNum == 1 ? 0 : 1;
//        }
//        // Is the array even or odd
//        if (sentinel.length % 2 == 0) {
//            // Even, can be 01010101 or 10101010
//            return Math.min(sentinel.length - errorCnt, errorCnt) / 2;
//        } else {
//            // Odd, depends on the number of 0 and 1.
//            // If the number of 1 is bigger, should be 101010101
//            // If the number of 0 is bigger, should be 010101010
//            // and the number of mismatches have to even.
//            if (errorCnt % 2 == 0) {
//                return errorCnt / 2;
//            } else {
//                return (sentinel.length - errorCnt) >> 1;
//            }
//        }
//    }

    // Method 2: use Bit Manipulation
    private static int movesToChessboard(int[][] board) {
        int n = board.length;
        int rowMask = 0, colMask = 0;

        // Check the first row and first column
        for (int i = 0; i < n; i++) {
            rowMask |= (board[0][i] << i);
            colMask |= (board[i][0] << i);
        }
        int reverseRowMask = ((1 << n) - 1) ^ rowMask;
        int reverseColMask = ((1 << n) - 1) ^ colMask;
        int rowCnt = 0, colCnt = 0;
        for (int i = 0; i < n; i++) {
            int currRowMask = 0;
            int currColMask = 0;
            for (int j = 0; j < n; j++) {
                currRowMask |= (board[i][j] << j);
                currColMask |= (board[j][i] << j);
            }
            // Check whether each row is valid or not.
            if (currRowMask != rowMask && currRowMask != reverseRowMask) {
                return -1;
            } else if (currRowMask == rowMask) {
                // track the number of rows that are equal to the first row.
                rowCnt++;
            }
            // Check whether each column is valid or not.
            if (currColMask != colMask && currColMask != reverseColMask) {
                return -1;
            } else if (currColMask == colMask) {
                // track the number of columns that are equal to the first column.
                colCnt++;
            }
        }
        int rowMoves = getMoves(rowMask, rowCnt, n);
        int colMoves = getMoves(colMask, colCnt, n);
        return (rowMoves == -1 || colMoves == -1) ? -1 : (rowMoves + colMoves);
    }

    public static int getMoves(int mask, int count, int n) {
        int ones = Integer.bitCount(mask);
        int count0 = n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
        if ((n & 1) == 1) {
            // If n is odd, the number of ones and zeros in each row differs by one,
            // and adjacent rows alternate.
            if (Math.abs(n - 2 * ones) != 1 || Math.abs(n - 2 * count) != 1 ) {
                return -1;
            }
            if (ones == (n >> 1)) {
                // The minimum number of swaps starting with 0
                return count0;
            } else {
                return (n + 1) / 2 - Integer.bitCount(mask & 0x55555555);
            }
        } else {
            // If n is even, the number of ones and zeros in each row is the same,
            // and adjacent rows alternate.
            if (ones != (n >> 1) || count != (n >> 1)) {
                return -1;
            }
            // Find the minimum number of rows swapped
            int count1 = n / 2 - Integer.bitCount(mask & 0x55555555);
            return Math.min(count0, count1);
        }
    }
}
