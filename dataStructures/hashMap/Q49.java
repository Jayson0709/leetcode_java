package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;
import utils.*;


//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//    
//    Example 1:
//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//    
//    Example 2:
//    Input: strs = [""]
//    Output: [[""]]
//    
//    Example 3:
//    Input: strs = ["a"]
//    Output: [["a"]]
//
//    Constraints:
//    1 <= strs.length <= 10^4
//    0 <= strs[i].length <= 100
//    strs[i] consists of lowercase English letters.


//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//    字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
//
//    示例 1:
//    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//    示例 2:
//    输入: strs = [""]
//    输出: [[""]]
//
//    示例 3:
//    输入: strs = ["a"]
//    输出: [["a"]]
//
//    提示：
//    1 <= strs.length <= 10^4
//    0 <= strs[i].length <= 100
//    strs[i]仅包含小写字母


public class Q49 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] strs = cin.nextLine().strip().split(" ");
        cin.close();
        List<List<String>> result = groupAnagrams(strs);
        OutputMethods.outputEmbeddedListData(result);
    }

    // Method 1: Sorting
    // If two strings contain the same letters, the sorted string must be the same.
    // Therefore, the sorted string can be used as the key of the hash map.
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hMap = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = hMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            hMap.put(key, list);
        }
        return new ArrayList<>(hMap.values());
    }

    // Method 2: Counting
    // Because the two strings contain the same letters,
    // the number of occurrences of the same letter in the two strings must be the same.
    // Therefore, the number of occurrences of each letter can be expressed as a string as the key of the hash map.
    //
    // Because strings contain only lowercase letters,
    // we can use an array of length 26 for each string to record the number of occurrences of each letter.
//    private static List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> hMap = new HashMap<>();
//        for (String str : strs) {
//            int[] counts = new int[26];
//            int n = str.length();
//            for (int i = 0; i < n; i++) {
//                counts[str.charAt(i) - 'a']++;
//            }
//            StringBuilder strBuilder = new StringBuilder();
//            for (int i = 0; i < 26; i++) {
//                if (counts[i] > 0) {
//                    strBuilder.append((char)('a' + i));
//                    strBuilder.append(counts[i]);
//                }
//            }
//            List<String> list = hMap.getOrDefault(strBuilder.toString(), new ArrayList<>());
//            list.add(str);
//            hMap.put(strBuilder.toString(), list);
//        }
//        return new ArrayList<>(hMap.values());
//    }
}
