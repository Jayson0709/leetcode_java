package algorithms.backtracking;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//    A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//    1: N/A 2: abc 3: def
//    4: ghi 5: jkl 6: mno
//    7: pqrs 8: tuv 9: wxyz
//    *:+  0: space #: shift
//
//    Example 1:
//    Input: digits = "23"
//    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//    Example 2:
//    Input: digits = ""
//    Output: []
//
//    Example 3:
//    Input: digits = "2"
//    Output: ["a","b","c"]
//
//    Constraints:
//    0 <= digits.length <= 4
//    digits[i] is a digit in the range ['2', '9'].



//给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//    1: N/A 2: abc 3: def
//    4: ghi 5: jkl 6: mno
//    7: pqrs 8: tuv 9: wxyz
//    *:+  0: space #: shift
//
//
//    示例 1：
//    输入：digits = "23"
//    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//    示例 2：
//    输入：digits = ""
//    输出：[]
//
//    示例 3：
//    输入：digits = "2"
//    输出：["a","b","c"]
//
//    提示：
//    0 <= digits.length <= 4
//    digits[i] 是范围 ['2', '9'] 的一个数字。



public class Q17 {
    static Map<Character, String> hMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String digits = cin.nextLine().strip();
        cin.close();

        System.out.print("[");
        List<String> result = letterCombinations(digits);
        for (int i = 0; i < result.size(); i++) {
            if (i == 0) {
                System.out.print(result.get(i));
            } else {
                System.out.print("," + result.get(i));
            }
        }
        System.out.print("]");
    }

    private static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>(0);
        }
        hMap.put('2', "abc");
        hMap.put('3', "def");
        hMap.put('4', "ghi");
        hMap.put('5', "jkl");
        hMap.put('6', "mno");
        hMap.put('7', "pqrs");
        hMap.put('8', "tuv");
        hMap.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(List<String> result, String digits, int index, StringBuilder curCombination) {
        if (index == digits.length()) {
            result.add(curCombination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = hMap.get(digit);
            int count = letters.length();
            for (int i = 0; i < count; i++) {
                curCombination.append(letters.charAt(i));
                backtrack(result, digits, index + 1, curCombination);
                curCombination.deleteCharAt(index);
            }
        }
    }
}
