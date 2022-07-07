package dataStructures.tree.trie;
import java.util.*;
import java.nio.charset.StandardCharsets;


//In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
//
//    Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
//
//    Return the sentence after the replacement.
//
//    Example 1:
//    Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
//    Output: "the cat was rat by the bat"
//
//    Example 2:
//    Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//    Output: "a a b c"
//
//    Constraints:
//    1 <= dictionary.length <= 1000
//    1 <= dictionary[i].length <= 100
//    dictionary[i] consists of only lower-case letters.
//    1 <= sentence.length <= 106
//    sentence consists of only lower-case letters and spaces.
//    The number of words in sentence is in the range [1, 1000]
//    The length of each word in sentence is in the range [1, 1000]
//    Every two consecutive words in sentence will be separated by exactly one space.
//    sentence does not have leading or trailing spaces.


//在英语中，我们有一个叫做词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。例如，词根an，跟随着单词other(其他)，可以形成新的单词another(另一个)。
//
//    现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
//
//    你需要输出替换之后的句子。
//
//    示例 1：
//    输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
//    输出："the cat was rat by the bat"
//
//    示例 2：
//    输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//    输出："a a b c"
//
//    提示：
//    1 <= dictionary.length<= 1000
//    1 <= dictionary[i].length <= 100
//    dictionary[i]仅由小写字母组成。
//    1 <= sentence.length <= 10^6
//    sentence仅由小写字母和空格组成。
//    sentence 中单词的总量在范围 [1, 1000] 内。
//    sentence 中每个单词的长度在范围 [1, 1000] 内。
//    sentence 中单词之间由一个空格隔开。
//    sentence没有前导或尾随空格。




public class Q648 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String[] words = cin.nextLine().strip().split(" ");
        String sentence = cin.nextLine().strip();
        cin.close();
        List<String> dictionary = new ArrayList<>(Arrays.asList(words));

        String result = replaceWords(dictionary, sentence);
        System.out.println(result);
    }

    // Method 1: use HashSet
//    private static String replaceWords(List<String> dictionary, String sentence) {
//        Set<String> dictionarySet = new HashSet<>(dictionary);
//        String[] words = sentence.split(" ");
//        for (int i = 0; i < words.length; i++) {
//            String word = words[i];
//            for (int j = 0; j < word.length(); j++) {
//                if (dictionarySet.contains(word.substring(0, 1 + j))) {
//                    words[i] = word.substring(0, 1 + j);
//                    break;
//                }
//            }
//        }
//        return String.join(" ", words);
//    }

    // Method 2: use trie
    private static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            Trie cur = trie;
            for (int i = 0; i < root.length(); i++) {
                char c = root.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.put('#', new Trie());
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ", words);
    }

    private static String findRoot(String word, Trie trie) {
        StringBuilder root = new StringBuilder();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#')) {
                return root.toString();
            }
            if (!cur.children.containsKey(c)) {
                return word;
            }
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }
}

class Trie {
    Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<>();
    }
}
