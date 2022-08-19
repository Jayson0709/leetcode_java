package dataStructures.hashSet;
import java.util.*;
import java.nio.charset.StandardCharsets;


//International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
//
//    'a' maps to ".-",
//    'b' maps to "-...",
//    'c' maps to "-.-.", and so on.
//    For convenience, the full table for the 26 letters of the English alphabet is given below:
//
//    [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
//    Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
//
//    For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
//    Return the number of different transformations among all words we have.
//    
//    Example 1:
//    Input: words = ["gin","zen","gig","msg"]
//    Output: 2
//    Explanation: The transformation of each word is:
//    "gin" -> "--...-."
//    "zen" -> "--...-."
//    "gig" -> "--...--."
//    "msg" -> "--...--."
//    There are 2 different transformations: "--...-." and "--...--.".
//    
//    Example 2:
//    Input: words = ["a"]
//    Output: 1
//
//    Constraints:
//    1 <= words.length <= 100
//    1 <= words[i].length <= 12
//    words[i] consists of lowercase English letters.



//国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:
//
//    'a' 对应 ".-" ，
//    'b' 对应 "-..." ，
//    'c' 对应 "-.-." ，以此类推。
//    为了方便，所有 26 个英文字母的摩尔斯密码表如下：
//
//    [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
//    给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
//
//    例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
//    对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
//
//    示例 1：
//    输入: words = ["gin", "zen", "gig", "msg"]
//    输出: 2
//    解释:
//    各单词翻译如下:
//    "gin" -> "--...-."
//    "zen" -> "--...-."
//    "gig" -> "--...--."
//    "msg" -> "--...--."
//    共有 2 种不同翻译, "--...-." 和 "--...--.".
//
//    示例 2：
//    输入：words = ["a"]
//    输出：1
//
//    提示：
//    1 <= words.length <= 100
//    1 <= words[i].length <= 12
//    words[i] 由小写英文字母组成



public class Q804 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] words = cin.nextLine().strip().split(" ");
        cin.close();
        System.out.println(uniqueMorseRepresentations(words));
    }

    public static final String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
        "....", "..", ".---", "-.-", ".-..", "--", "-.",
        "---", ".--.", "--.-", ".-.", "...", "-", "..-",
        "...-", ".--", "-..-", "-.--", "--.."};

    private static int uniqueMorseRepresentations(String[] words) {
        Set<String> translations = new HashSet<>();
        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                code.append(morseCode[word.charAt(i) - 'a']);
            }
            translations.add(code.toString());
        }
        return translations.size();
    }
}
