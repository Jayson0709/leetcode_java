package dataStructures.tree.trie;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Design a special dictionary that searches the words in it by a prefix and a suffix.
//
//    Implement the WordFilter class:
//        WordFilter(string[] words) Initializes the object with the words in the dictionary.
//        f(string pref, string suff) Returns the index of the word in the dictionary, which has the prefix pref and the suffix suff. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
//
//    Example 1:
//
//    Input
//    ["WordFilter", "f"]
//    [[["apple"]], ["a", "e"]]
//    Output
//    [null, 0]
//    Explanation
//    WordFilter wordFilter = new WordFilter(["apple"]);
//    wordFilter.f("a", "e"); // return 0, because the word at index 0 has 'prefix' = "a" and suffix = "e".
//
//    Constraints:
//    1 <= words.length <= 10^4
//    1 <= words[i].length <= 7
//    1 <= pref.length, suff.length <= 7
//    words[i], pref and suff consist of lowercase English letters only.
//    At most 10^4 calls will be made to the function f.


//设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
//
//    实现 WordFilter 类：
//        WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
//        f(string pref, string suff) 返回词典中具有前缀prefix和后缀 suffix的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
//
//    示例：
//
//    输入
//    ["WordFilter", "f"]
//    [[["apple"]], ["a", "e"]]
//    输出
//    [null, 0]
//    解释
//    WordFilter wordFilter = new WordFilter(["apple"]);
//    wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
//
//    提示：
//    1 <= words.length <= 10^4
//    1 <= words[i].length <= 7
//    1 <= pref.length, suff.length <= 7
//    words[i]、pref 和 suff 仅由小写英文字母组成
//    最多对函数 f 执行 10^4 次调用


public class Q745 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String[] orders = cin.nextLine().split(" ");
        StringBuilder output = new StringBuilder();
        if (orders[0].equals("WordFilter")) {
            String[] words = cin.nextLine().strip().split(" ");
            WordFilter obj = new WordFilter(words);
            output.append("[null");
            for (int i = 1; i < orders.length; i++) {
                String[] prefixAndSuffix = cin.nextLine().strip().split(" ");
                int result = obj.f(prefixAndSuffix[0], prefixAndSuffix[1]);
                output.append(", ").append(result);
            }
            output.append("]");
        }
        cin.close();
        System.out.println(output);
    }
}

// Method 1: use HashMap to calculate the possibility of each prefix and suffix
//class WordFilter {
//    Map<String, Integer> dict;
//    public WordFilter(String[] words) {
//        dict = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            String word = words[i];
//            int m = word.length();
//            for (int prefixLen = 1; prefixLen <= m; prefixLen++) {
//                for (int suffixLen = 1; suffixLen <= m; suffixLen++) {
//                    dict.put(word.substring(0, prefixLen) + "#" + word.substring(m - suffixLen), i);
//                }
//            }
//        }
//    }
//
//    public int f(String pref, String suff) {
//        return dict.getOrDefault(pref + "#" + suff, -1);
//    }
//}


// Method 2: Use Trie
class WordFilter {

    Trie trie;
    String weightKey;
    public WordFilter(String[] words) {
        trie = new Trie();
        weightKey = "##";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie cur = trie;
            int m = word.length();
            for (int j = 0; j < m; j++) {
                Trie tmp = cur;
                for (int k = j; k < m; k++) {
                    String key = String.valueOf(word.charAt(k)) + '#';
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Trie());
                    }
                    tmp = tmp.children.get(key);
                    tmp.weight.put(weightKey, i);
                }
                tmp = cur;
                for (int k = j; k < m; k++) {
                    String key = "#" + word.charAt(m - k - 1);
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Trie());
                    }
                    tmp = tmp.children.get(key);
                    tmp.weight.put(weightKey, i);
                }
                String key = String.valueOf(word.charAt(j)) + word.charAt(m - j - 1);
                if (!cur.children.containsKey(key)) {
                    cur.children.put(key, new Trie());
                }
                cur = cur.children.get(key);
                cur.weight.put(weightKey, i);
            }
        }
    }

    public int f(String pref, String suff) {
        Trie cur = trie;
        int m = Math.max(pref.length(), suff.length());
        for (int i = 0; i < m; i++) {
            char c1 = i < pref.length() ? pref.charAt(i) : '#';
            char c2 = i < suff.length() ? suff.charAt(suff.length() - 1 - i) : '#';
            String key = String.valueOf(c1) + c2;
            if (!cur.children.containsKey(key)) {
                return -1;
            }
            cur = cur.children.get(key);
        }
        return cur.weight.get(weightKey);
    }

    static class Trie {
        Map<String, Trie> children;
        Map<String, Integer> weight;

        public Trie() {
            children = new HashMap<>();
            weight = new HashMap<>();
        }
    }
}