package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
//
//    Return the sorted string. If there are multiple answers, return any of them.
//
//    Example 1:
//    Input: s = "tree"
//    Output: "eert"
//    Explanation: 'e' appears twice while 'r' and 't' both appear once.
//    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//    
//    Example 2:
//    Input: s = "cccaaa"
//    Output: "aaaccc"
//    Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
//    Note that "cacaca" is incorrect, as the same characters must be together.
//    
//    Example 3:
//    Input: s = "Aabb"
//    Output: "bbAa"
//    Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
//    Note that 'A' and 'a' are treated as two different characters.
//
//    Constraints:
//    1 <= s.length <= 5 * 10^5
//    s consists of uppercase and lowercase English letters and digits.



//给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
//
//    返回 已排序的字符串。如果有多个答案，返回其中任何一个。
//
//    示例 1:
//    输入: s = "tree"
//    输出: "eert"
//    解释: 'e'出现两次，'r'和't'都只出现一次。
//    因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
//
//    示例 2:
//    输入: s = "cccaaa"
//    输出: "cccaaa"
//    解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//    注意"cacaca"是不正确的，因为相同的字母必须放在一起。
//
//    示例 3:
//    输入: s = "Aabb"
//    输出: "bbAa"
//    解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//    注意'A'和'a'被认为是两种不同的字符。
//
//    提示:
//    1 <= s.length <= 5 * 10^5
//    s由大小写英文字母和数字组成



public class Q451 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine();
        cin.close();
        String result = frequencySort(s);
        System.out.println(result);
    }

    // Method 1: HashMap + Sorting
//    private static String frequencySort(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char c = s.charAt(i);
//            int frequency = map.getOrDefault(c, 0) + 1;
//            map.put(c, frequency);
//        }
//        List<Character> list = new ArrayList<>(map.keySet());
//        list.sort((a, b) -> map.get(b) - map.get(a));
//        StringBuilder sb = new StringBuilder();
//        for (char c : list) {
//            int frequency = map.get(c);
//            sb.append(String.valueOf(c).repeat(Math.max(0, frequency)));
//        }
//        return sb.toString();
//    }


    // Method 2: Bucket sort
    // TreeSet has a similar implementation, sort each node <character, frequency> by value frequency.
    private static String frequencySort(String s) {
        Map<Character, Integer> hMap = new HashMap<>();
        int maxFreq = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = hMap.getOrDefault(c, 0) + 1;
            hMap.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuffer();
        }
        for (Map.Entry<Character, Integer> entry : hMap.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i];
            int size = bucket.length();
            for (int j = 0; j < size; j++) {
                sb.append(String.valueOf(bucket.charAt(j)).repeat(i));
            }
        }
        return sb.toString();
    }
}
