package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;
import utils.OutputMethods;


//Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.
//
//    A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
//
//    Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.
//
//    Example 1:
//    Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//    Output: ["mee","aqq"]
//    Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
//    "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
//
//    Example 2:
//    Input: words = ["a","b","c"], pattern = "a"
//    Output: ["a","b","c"]
//    
//
//    Constraints:
//    1 <= pattern.length <= 20
//    1 <= words.length <= 50
//    words[i].length == pattern.length
//    pattern and words[i] are lowercase English letters.


//你有一个单词列表words和一个模式pattern，你想知道 words 中的哪些单词与模式匹配。
//
//    如果存在字母的排列 p，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
//
//    （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
//
//    返回 words 中与给定模式匹配的单词列表。
//
//    你可以按任何顺序返回答案。
//
//    示例：
//    输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//    输出：["mee","aqq"]
//    解释：
//    "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
//    "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
//    因为 a 和 b 映射到同一个字母。
//
//    提示：
//    1 <= words.length <= 50
//    1 <= pattern.length = words[i].length<= 20


public class Q890 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<String> wordsList = new ArrayList<>();
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            wordsList.add(line);
        }
        int size = wordsList.size();
        String[] words = new String[size - 1];
        String pattern = null;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                pattern = wordsList.get(i);
                break;
            }
            words[i] = wordsList.get(i);
        }
        cin.close();

        List<String> result = findAndReplacePattern(words, pattern);
        OutputMethods.outputListData(result);
    }

    private static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern) && match(pattern, word)) {
                result.add(word);
            }
        }
        return result;
    }

    private static boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            char y = pattern.charAt(i);
            if (!map.containsKey(x)) {
                map.put(x, y);
            } else if (map.get(x) != y) {
                return false;
            }
        }
        return true;
    }
}
