package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//An integer x is a good if after rotating each digit individually by 180 degrees, we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave it alone.
//
//    A number is valid if each digit remains a digit after rotation. For example:
//
//    0, 1, and 8 rotate to themselves,
//    2 and 5 rotate to each other (in this case they are rotated in a different direction, in other words, 2 or 5 gets mirrored),
//    6 and 9 rotate to each other, and
//    the rest of the numbers do not rotate to any other number and become invalid.
//    Given an integer n, return the number of good integers in the range [1, n].
//    
//    Example 1:
//    Input: n = 10
//    Output: 4
//    Explanation: There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
//    Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
//    
//    Example 2:
//    Input: n = 1
//    Output: 0
//
//    Example 3:
//    Input: n = 2
//    Output: 1
//
//    Constraints:
//    1 <= n <= 10^4



//我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
//
//    如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
//
//    现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
//
//    示例：
//    输入: 10
//    输出: 4
//    解释:
//    在[1, 10]中有四个好数： 2, 5, 6, 9。
//    注意 1 和 10 不是好数, 因为他们在旋转之后不变。
//
//    提示：
//    N 的取值范围是 [1, 10000]。



public class Q788 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(rotatedDigits(n));
    }

    // Method 1: Enumeration + HashMap + StringBuilder
//    static Map<Character, Integer> charToNum = new HashMap<>();
//    private static int rotatedDigits(int n) {
//        charToNum.put('0', 0);
//        charToNum.put('1', 1);
//        charToNum.put('2', 5);
//        charToNum.put('5', 2);
//        charToNum.put('6', 9);
//        charToNum.put('8', 8);
//        charToNum.put('9', 6);
//        int res = 0;
//        for (int i = 1; i <= n; i++) {
//            StringBuilder curr = new StringBuilder();
//            for (char c : String.valueOf(i).toCharArray()) {
//                if (charToNum.get(c) == null) {
//                    curr.setLength(0);
//                    break;
//                } else {
//                    curr.append(charToNum.get(c));
//                }
//            }
//            if (curr.length() != 0 && Integer.parseInt(curr.toString()) != i) {
//                res++;
//            }
//        }
//        return res;
//    }

    // Method 2: Enumeration + Array + boolean tags
    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    private static int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            boolean valid = true, diff = false;
            for (char c : num.toCharArray()) {
                if (check[c - '0'] == -1) {
                    valid = false;
                } else if (check[c - '0'] == 1) {
                    diff = true;
                }
            }
            if (valid && diff) {
                res++;
            }
        }
        return res;
    }
}
