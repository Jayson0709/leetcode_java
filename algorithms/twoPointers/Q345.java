package algorithms.twoPointers;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//Given a string s, reverse only all the vowels in the string and return it.
//
//    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
//
//    Example 1:
//    Input: s = "hello"
//    Output: "holle"
//
//    Example 2:
//    Input: s = "leetcode"
//    Output: "leotcede"
//
//    Constraints:
//    1 <= s.length <= 3 * 10^5
//    s consist of printable ASCII characters.




//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
//
//    元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
//
//    示例 1：
//    输入：s = "hello"
//    输出："holle"
//
//    示例 2：
//    输入：s = "leetcode"
//    输出："leotcede"
//
//    提示：
//    1 <= s.length <= 3 * 10^5
//    s 由 可打印的 ASCII 字符组成



public class Q345 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(reverseVowels(s));
    }

    private static String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && isVowel(arr[i])) {
                i++;
            }
            while (j > 0 && isVowel(arr[j])) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return new String(arr);
    }

    public static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) < 0;
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
