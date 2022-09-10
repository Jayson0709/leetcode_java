package dataStructures.tree.trie;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;



//A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
//
//    Implement the Trie class:
//        Trie() Initializes the trie object.
//        void insert(String word) Inserts the string word into the trie.
//        boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
//        boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix 'prefix', and false otherwise.
//
//    Example 1:
//
//    Input
//    ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//    [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//    Output
//    [null, null, true, false, true, null, true]
//
//    Explanation
//    Trie trie = new Trie();
//    trie.insert("apple");
//    trie.search("apple");   // return True
//    trie.search("app");     // return False
//    trie.startsWith("app"); // return True
//    trie.insert("app");
//    trie.search("app");     // return True
//
//    Constraints:
//    1 <= word.length, prefix.length <= 2000
//    word and prefix consist only of lowercase English letters.
//    At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.



//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
//
//    请你实现 Trie 类：
//        Trie() 初始化前缀树对象。
//        void insert(String word) 向前缀树中插入字符串 word 。
//        boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
//        boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
//
//    示例：
//
//    输入
//    ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//    [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//    输出
//    [null, null, true, false, true, null, true]
//
//    解释
//    Trie trie = new Trie();
//    trie.insert("apple");
//    trie.search("apple");   // 返回 True
//    trie.search("app");     // 返回 False
//    trie.startsWith("app"); // 返回 True
//    trie.insert("app");
//    trie.search("app");     // 返回 True
//
//    提示：
//    1 <= word.length, prefix.length <= 2000
//    word 和 prefix 仅由小写英文字母组成
//    insert、search 和 startsWith 调用次数 总计 不超过 3 * 10^4 次


public class Q208 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("Trie")) {
            Trie obj = new Trie();
            output.append("null");
            for (String order : orders) {
                switch (order) {
                    case "insert" -> {
                        obj.insert(cin.nextLine().strip());
                        output.append(", null");
                    }
                    case "search" -> output.append(", ").append(obj.search(cin.nextLine().strip()));
                    case "startsWith" -> output.append(", ").append(obj.startsWith(cin.nextLine().strip()));
                }
            }
        }
        cin.close();
        output.append("]");
        System.out.println(output);
    }

    static class Trie {
        private final Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }
}

