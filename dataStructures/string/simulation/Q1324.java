package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Given a string s. Return all the words vertically in the same order in which they appear in s.
//    Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
//    Each word would be put on only one column and that in one column there will be only one word.
//    
//    Example 1:
//    Input: s = "HOW ARE YOU"
//    Output: ["HAY","ORO","WEU"]
//    Explanation: Each word is printed vertically.
//    "HAY"
//    "ORO"
//    "WEU"
//    
//    Example 2:
//    Input: s = "TO BE OR NOT TO BE"
//    Output: ["TBONTB","OEROOE","   T"]
//    Explanation: Trailing spaces is not allowed.
//    "TBONTB"
//    "OEROOE"
//    "   T"
//    
//    Example 3:
//    Input: s = "CONTEST IS COMING"
//    Output: ["CIC","OSO","N M","T I","E N","S G","T"]
//    
//    Constraints:
//    1 <= s.length <= 200
//    s contains only upper case English letters.
//    It's guaranteed that there is only one space between 2 words.



//给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
//    单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
//    每个单词只能放在一列上，每一列中也只能有一个单词。
//
//    示例 1：
//    输入：s = "HOW ARE YOU"
//    输出：["HAY","ORO","WEU"]
//    解释：每个单词都应该竖直打印。
//    "HAY"
//    "ORO"
//    "WEU"
//
//    示例 2：
//    输入：s = "TO BE OR NOT TO BE"
//    输出：["TBONTB","OEROOE","   T"]
//    解释：题目允许使用空格补位，但不允许输出末尾出现空格。
//    "TBONTB"
//    "OEROOE"
//    "   T"
//
//    示例 3：
//    输入：s = "CONTEST IS COMING"
//    输出：["CIC","OSO","N M","T I","E N","S G","T"]
//
//    提示：
//    1 <= s.length <= 200
//    s 仅含大写英文字母。
//    题目数据保证两个单词之间只有一个空格。


public class Q1324 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        System.out.println(printVertically(s));
    }

    private static List<String> printVertically(String s) {
        String[] words = s.strip().split(" ");
        int size = 0;
        for (String word : words) {
            size = Math.max(size, word.length());
        }
        List<String> res = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            StringBuilder temp = new StringBuilder();
            for (String word : words) {
                if (i < word.length()) {
                    temp.append(word.charAt(i));
                } else {
                    temp.append(' ');
                }
            }
            int idx = temp.length() - 1;
            while (temp.charAt(idx) == ' ') {
                idx--;
            }
            res.add(temp.substring(0, idx + 1));
        }
        return res;
    }
}
