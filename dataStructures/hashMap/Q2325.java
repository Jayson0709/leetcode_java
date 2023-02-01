package dataStructures.hashMap;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//You are given the strings key and message, which represent a cipher key and a secret message, respectively. The steps to decode message are as follows:
//
//    Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
//    Align the substitution table with the regular English alphabet.
//    Each letter in message is then substituted using the table.
//    Spaces ' ' are transformed to themselves.
//    For example, given key = "happy boy" (actual key would have at least one instance of each letter in the alphabet), we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
//    Return the decoded message.
//
//    Example 1:
//    |t|h|e|q|u|i|c|k|b|r|o|w|n|f|x|j|m|p|s|v|l|a|z|y|d|g|
//    |a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|
//    Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
//    Output: "this is a secret"
//    Explanation: The diagram above shows the substitution table.
//    It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over the lazy dog".
//
//    Example 2:
//    |e|l|j|u|x|h|p|w|n|y|r|d|g|t|q|k|v|i|s|z|c|f|m|a|b|o|
//    |a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|
//    Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
//    Output: "the five boxing wizards jump quickly"
//    Explanation: The diagram above shows the substitution table.
//    It is obtained by taking the first appearance of each letter in "eljuxhpwnyrdgtqkviszcfmabo".
//
//    Constraints:
//    26 <= key.length <= 2000
//    key consists of lowercase English letters and ' '.
//    key contains every letter in the English alphabet ('a' to 'z') at least once.
//    1 <= message.length <= 2000
//    message consists of lowercase English letters and ' '.


//给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
//
//    使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
//    将替换表与普通英文字母表对齐，形成对照表。
//    按照对照表 替换 message 中的每个字母。
//    空格 ' ' 保持不变。
//    例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
//    返回解密后的消息。
//
//    示例 1：
//    |t|h|e|q|u|i|c|k|b|r|o|w|n|f|x|j|m|p|s|v|l|a|z|y|d|g|
//    |a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|
//    输入：key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
//    输出："this is a secret"
//    解释：对照表如上图所示。
//    提取 "the quick brown fox jumps over the lazy dog" 中每个字母的首次出现可以得到替换表。
//
//    示例 2：
//    |e|l|j|u|x|h|p|w|n|y|r|d|g|t|q|k|v|i|s|z|c|f|m|a|b|o|
//    |a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|
//    输入：key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
//    输出："the five boxing wizards jump quickly"
//    解释：对照表如上图所示。
//    提取 "eljuxhpwnyrdgtqkviszcfmabo" 中每个字母的首次出现可以得到替换表。
//
//    提示：
//    26 <= key.length <= 2000
//    key 由小写英文字母及 ' ' 组成
//    key 包含英文字母表中每个字符（'a' 到 'z'）至少一次
//    1 <= message.length <= 2000
//    message 由小写英文字母和 ' ' 组成


public class Q2325 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String key = cin.nextLine().strip();
        String message = cin.nextLine().strip();
        cin.close();
        System.out.println(decodeMessage(key, message));
    }

    private final static char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static String decodeMessage(String key, String message) {
        int index = 0;
        Map<Character, Character> decodeMap = new HashMap<>();
        for (char letter : key.toCharArray()) {
            if (letter != ' ' && !decodeMap.containsKey(letter)) {
                decodeMap.put(letter, letters[index]);
                index++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (char letter : message.toCharArray()) {
            if (letter != ' ') {
                res.append(decodeMap.get(letter));
            } else {
                res.append(letter);
            }
        }
        return res.toString();
    }
}
