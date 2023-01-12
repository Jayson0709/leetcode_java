package dataStructures.hashMap;

import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//You are given a string s that contains some bracket pairs, with each pair containing a non-empty key.
//
//    For example, in the string "(name)is(age)yearsold", there are two bracket pairs that contain the keys "name" and "age".
//    You know the values of a wide range of keys. This is represented by a 2D string array knowledge where each knowledge[i] = [key_i, value_i] indicates that key key_i has a value of value_i.
//
//    You are tasked to evaluate all the bracket pairs. When you evaluate a bracket pair that contains some key key_i, you will:
//
//    Replace key_i and the bracket pair with the key's corresponding value_i.
//    If you do not know the value of the key, you will replace key_i and the bracket pair with a question mark "?" (without the quotation marks).
//    Each key will appear at most once in your knowledge. There will not be any nested brackets in s.
//
//    Return the resulting string after evaluating all the bracket pairs.
//
//    Example 1:
//    Input: s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
//    Output: "bobistwoyearsold"
//    Explanation:
//    The key "name" has a value of "bob", so replace "(name)" with "bob".
//    The key "age" has a value of "two", so replace "(age)" with "two".
//
//    Example 2:
//    Input: s = "hi(name)", knowledge = [["a","b"]]
//    Output: "hi?"
//    Explanation: As you do not know the value of the key "name", replace "(name)" with "?".
//
//    Example 3:
//    Input: s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
//    Output: "yesyesyesaaa"
//    Explanation: The same key can appear multiple times.
//    The key "a" has a value of "yes", so replace all occurrences of "(a)" with "yes".
//    Notice that the "a"s not in a bracket pair are not evaluated.
//
//    Constraints:
//    1 <= s.length <= 10^5
//    0 <= knowledge.length <= 10^5
//    knowledge[i].length == 2
//    1 <= key_i.length, value_i.length <= 10
//    s consists of lowercase English letters and round brackets '(' and ')'.
//    Every open bracket '(' in s will have a corresponding close bracket ')'.
//    The key in each bracket pair of s will be non-empty.
//    There will not be any nested bracket pairs in s.
//    key_i and value_i consist of lowercase English letters.
//    Each key_i in knowledge is unique.


//给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。
//
//    比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
//    你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [key_i, value_i] ，表示键 key_i 对应的值为 value_i 。
//
//    你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 key_i 时，你需要：
//
//    将 key_i 和括号用对应的值 value_i 替换。
//    如果从 knowledge 中无法得知某个键对应的值，你需要将 key_i 和括号用问号 "?" 替换（不需要引号）。
//    knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。
//
//    请你返回替换 所有 括号对后的结果字符串。
//
//    示例 1：
//    输入：s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
//    输出："bobistwoyearsold"
//    解释：
//    键 "name" 对应的值为 "bob" ，所以将 "(name)" 替换为 "bob" 。
//    键 "age" 对应的值为 "two" ，所以将 "(age)" 替换为 "two" 。
//
//    示例 2：
//    输入：s = "hi(name)", knowledge = [["a","b"]]
//    输出："hi?"
//    解释：由于不知道键 "name" 对应的值，所以用 "?" 替换 "(name)" 。
//
//    示例 3：
//    输入：s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
//    输出："yesyesyesaaa"
//    解释：相同的键在 s 中可能会出现多次。
//    键 "a" 对应的值为 "yes" ，所以将所有的 "(a)" 替换为 "yes" 。
//    注意，不在括号里的 "a" 不需要被替换。
//
//    提示：
//    1 <= s.length <= 10^5
//    0 <= knowledge.length <= 10^5
//    knowledge[i].length == 2
//    1 <= key_i.length, value_i.length <= 10
//    s 只包含小写英文字母和圆括号 '(' 和 ')' 。
//    s 中每一个左圆括号 '(' 都有对应的右圆括号 ')' 。
//    s 中每对括号内的键都不会为空。
//    s 中不会有嵌套括号对。
//    key_i 和 value_i 只包含小写英文字母。
//    knowledge 中的 key_i 不会重复。


public class Q1807 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        List<List<String>> knowledge = new ArrayList<>();
        InputMethods.getInputForNestedStringArrayList(cin, knowledge);
        cin.close();
        System.out.println(evaluate(s, knowledge));
    }

    private static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> keyMap = new HashMap<>();
        for (List<String> pair : knowledge) {
            keyMap.put(pair.get(0), pair.get(1));
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        int length = s.length();
        while (index < length) {
            if (s.charAt(index) != '(') {
                result.append(s.charAt(index));
                index++;
                continue;
            }
            int left = index;
            while (index < length && s.charAt(index) != ')') {
                index++;
            }
            String keyword = s.substring(left + 1, index++);
            result.append(keyMap.containsKey(keyword) ? keyMap.get(keyword) : '?');
        }
        return result.toString();
    }
}
