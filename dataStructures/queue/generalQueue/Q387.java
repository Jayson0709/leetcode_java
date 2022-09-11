package dataStructures.queue.generalQueue;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
//
//    Example 1:
//    Input: s = "leetcode"
//    Output: 0
//
//    Example 2:
//    Input: s = "loveleetcode"
//    Output: 2
//
//    Example 3:
//    Input: s = "aabb"
//    Output: -1
//
//    Constraints:
//    1 <= s.length <= 105
//    s consists of only lowercase English letters.


//给定一个字符串s，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1。
//
//    示例 1：
//    输入: s = "leetcode"
//    输出: 0
//
//    示例 2:
//    输入: s = "loveleetcode"
//    输出: 2
//
//    示例 3:
//    输入: s = "aabb"
//    输出: -1
//
//    提示:
//    1 <= s.length <= 105
//    s只包含小写字母


public class Q387 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        int result = firstUniqueChar(s);
        System.out.println(result);
    }

    // Method 1: HashMap
//    private static int firstUniqueChar(String s) {
//        Map<Character, Integer> hMap = new HashMap<>();
//        for (char letter : s.toCharArray()) {
//            hMap.put(letter, hMap.getOrDefault(letter, 0) + 1);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (hMap.get(s.charAt(i)) == 1) {
//                return  i;
//            }
//        }
//        return -1;
//    }

    // Method 2: Queue + HashMap
    private static int firstUniqueChar(String s) {
        Map<Character, Integer> positionMap = new HashMap<>();
        Queue<LetterIndexPair> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (!positionMap.containsKey(curChar)) {
                positionMap.put(curChar, i);
                queue.offer(new LetterIndexPair(curChar, i));
            } else {
                // character already exists in the HashMap, make the value -1
                positionMap.put(curChar, -1);
                while (!queue.isEmpty() && positionMap.get(queue.peek().letter) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().index;
    }

    static class LetterIndexPair {
        char letter;
        int index;

        LetterIndexPair(char letter, int index) {
            this.letter = letter;
            this.index = index;
        }
    }
}
