package interview;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


//Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
//
//    Example 1:
//    Input: s = "leetcode"
//    Output: false
//
//    Example 2:
//    Input: s = "abc"
//    Output: true
//
//    Note:
//    0 <= len(s) <= 100


//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
//    示例 1：
//    输入: s = "leetcode"
//    输出: false
//
//    示例 2：
//    输入: s = "abc"
//    输出: true
//
//    限制：
//    0 <= len(s) <= 100
//    s[i]仅包含小写字母
//    如果你不使用额外的数据结构，会很加分。


public class IsUnique {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(isUnique(s));
    }

    // Version 1: use Array
//    private static boolean isUnique(String astr) {
//        int[] arr = new int[128];
//        for (int i = 0; i < astr.length(); i++) {
//            //associate the char with the array
//            if (arr[astr.charAt(i)] != 0)
//                return false;
//            arr[astr.charAt(i)]++;
//        }
//        return true;
//    }

    // Version 2: bit manipulation
    private static boolean isUnique(String astr) {
        long bits = 0;
        int size = astr.length();
        for (int i = 0; i < size; i++) {
            int move = astr.charAt(i) - 'A';
            if ((bits & (1L << move)) != 0) {
                // duplicate, return false
                return false;
            } else {
                //mark the current index
                bits |= (1L << move);
            }
        }
        return true;
    }

    // Version 3: use HashSet
//    private static boolean isUnique(String astr) {
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < astr.length(); i++) {
//            if (!set.add(astr.charAt(i)))
//                return false;
//        }
//        return true;
//    }

    // Version 4: use String API
//    private static boolean isUnique(String astr) {
//        for (int i = 0; i < astr.length(); i++) {
//            char c = astr.charAt(i);
//            if (astr.indexOf(c) != astr.lastIndexOf(c))
//                return false;
//        }
//        return true;
//    }
}
