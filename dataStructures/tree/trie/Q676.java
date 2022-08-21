package dataStructures.tree.trie;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.
//
//    Implement the MagicDictionary class:
//        MagicDictionary()Initializes the object.
//        void buildDict(String[]dictionary)Sets the data structure with an array of distinct strings 'dictionary'.
//        bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match any string in the data structure, otherwise returns false.
//
//    Example 1:
//
//    Input
//    ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
//    [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
//    Output
//    [null, null, false, true, false, false]
//
//    Explanation
//    MagicDictionary magicDictionary = new MagicDictionary();
//    magicDictionary.buildDict(["hello", "leetcode"]);
//    magicDictionary.search("hello"); // return False
//    magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
//    magicDictionary.search("hell"); // return False
//    magicDictionary.search("leetcoded"); // return False
//
//    Constraints:
//    1 <=dictionary.length <= 100
//    1 <=dictionary[i].length <= 100
//    dictionary[i] consists of only lower-case English letters.
//    All the strings in dictionary are distinct.
//    1 <=searchWord.length <= 100
//    searchWord consists of only lower-case English letters.
//    buildDict will be called only once before search.
//    At most 100 calls will be made to search.



//设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
//
//    实现 MagicDictionary 类：
//        MagicDictionary() 初始化对象
//        void buildDict(String[]dictionary) 使用字符串数组dictionary 设定该数据结构，dictionary 中的字符串互不相同
//        bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
//
//    示例：
//
//    输入
//    ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
//    [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
//    输出
//    [null, null, false, true, false, false]
//
//    解释
//    MagicDictionary magicDictionary = new MagicDictionary();
//    magicDictionary.buildDict(["hello", "leetcode"]);
//    magicDictionary.search("hello"); // 返回 False
//    magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
//    magicDictionary.search("hell"); // 返回 False
//    magicDictionary.search("leetcoded"); // 返回 False
//
//    提示：
//    1 <=dictionary.length <= 100
//    1 <=dictionary[i].length <= 100
//    dictionary[i] 仅由小写英文字母组成
//    dictionary 中的所有字符串 互不相同
//    1 <=searchWord.length <= 100
//    searchWord 仅由小写英文字母组成
//    buildDict 仅在 search 之前调用一次
//    最多调用 100 次 search


public class Q676 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        MagicDictionary obj = new MagicDictionary();
        StringBuilder outputStr = new StringBuilder();
        if (orders[0].equals("MagicDictionary")) {
            outputStr.append("[null");
            for (int i = 1; i < orders.length; i++) {
                if (i == 1 && orders[i].equals("buildDict")) {
                    String[] dictionary = cin.nextLine().strip().split(" ");
                    obj.buildDict(dictionary);
                    outputStr.append(", null");
                } else if (i != 1 && orders[i].equals("search")) {
                    String searchWord = cin.nextLine().strip();
                    boolean param = obj.search(searchWord);
                    outputStr.append(", ").append(param);
                }
            }
            outputStr.append("]");
        }
        cin.close();
        System.out.println(outputStr);
    }
}


// Method 1: Simply enumerate
//class MagicDictionary {
//    String[] words;
//    public MagicDictionary() {
//    }
//
//    public void buildDict(String[] dictionary) {
//        words = dictionary;
//    }
//
//    public boolean search(String searchWord) {
//        for (String word : words) {
//            if (word.length() != searchWord.length()) {
//                continue;
//            }
//            int diff = 0;
//            for (int i = 0; i < word.length(); i++) {
//                if (word.charAt(i) != searchWord.charAt(i)) {
//                    diff++;
//                    if (diff > 1) {
//                        break;
//                    }
//                }
//            }
//            if (diff == 1) {
//                return true;
//            }
//        }
//        return false;
//    }
//}

// Method 2: use Trie
class MagicDictionary {
    Trie root;
    public MagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (cur.child[index] == null) {
                    cur.child[index] = new Trie();
                }
                cur = cur.child[index];
            }
            cur.isFinished = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, false);
    }

    public boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
        if (pos == searchWord.length()) {
            return modified && node.isFinished;
        }
        int idx = searchWord.charAt(pos) - 'a';
        if (node.child[idx] != null) {
            if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; ++i) {
                if (i != idx && node.child[i] != null) {
                    if (dfs(searchWord, node.child[i], pos + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static class Trie {
        boolean isFinished;
        Trie[] child;

        public Trie() {
            isFinished = false;
            child = new Trie[26];
        }
    }
}
