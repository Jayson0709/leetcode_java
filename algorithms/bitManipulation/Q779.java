package algorithms.bitManipulation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
//
//    For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
//    Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
//    
//    Example 1:
//    Input: n = 1, k = 1
//    Output: 0
//    Explanation: row 1: 0
//    
//    Example 2:
//    Input: n = 2, k = 1
//    Output: 0
//    Explanation:
//    row 1: 0
//    row 2: 01
//    
//    Example 3:
//    Input: n = 2, k = 2
//    Output: 1
//    Explanation:
//    row 1: 0
//    row 2: 01
//
//    Constraints:
//    1 <= n <= 30
//    1 <= k <= 2^n - 1




//我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
//
//    例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
//    给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
//
//    示例 1:
//    输入: n = 1, k = 1
//    输出: 0
//    解释: 第一行：0
//
//    示例 2:
//    输入: n = 2, k = 1
//    输出: 0
//    解释:
//    第一行: 0
//    第二行: 01
//
//    示例 3:
//    输入: n = 2, k = 2
//    输出: 1
//    解释:
//    第一行: 0
//    第二行: 01
//
//    提示:
//    1 <= n <= 30
//    1 <= k <= 2^n - 1



public class Q779 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        int k = cin.nextInt();
        cin.close();
        System.out.println(kthGrammar(n, k));
    }

    private static int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }
}
