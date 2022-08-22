package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Roman numerals are represented by seven different symbols:I, V, X, L, C, D and M.
//
//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    For example,2 is written as IIin Roman numeral, just two ones added together. 12 is written asXII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
//
//    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//    I can be placed before V (5) and X (10) to make 4 and 9.
//    X can be placed before L (50) and C (100) to make 40 and 90.
//    C can be placed before D (500) and M (1000) to make 400 and 900.
//    Given a roman numeral, convert it to an integer.
//
//    Example 1:
//    Input: s = "III"
//    Output: 3
//    Explanation: III = 3.
//
//    Example 2:
//    Input: s = "LVIII"
//    Output: 58
//    Explanation: L = 50, V= 5, III = 3.
//
//    Example 3:
//    Input: s = "MCMXCIV"
//    Output: 1994
//    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//
//    Constraints:
//    1 <= s.length <= 15
//    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
//    It is guaranteed that s is a valid roman numeral in the range [1, 3999].


//罗马数字包含以下七种字符:I，V，X，L，C，D和M。
//
//    字符          数值
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
//
//    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
//
//    I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
//    X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
//    C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
//    给定一个罗马数字，将其转换成整数。
//
//    示例1:
//    输入:s = "III"
//    输出: 3
//
//    示例2:
//    输入:s = "IV"
//    输出: 4
//
//    示例3:
//    输入:s = "IX"
//    输出: 9
//
//    示例4:
//    输入:s = "LVIII"
//    输出: 58
//    解释: L = 50, V= 5, III = 3.
//
//    示例5:
//    输入:s = "MCMXCIV"
//    输出: 1994
//    解释: M = 1000, CM = 900, XC = 90, IV = 4.
//
//    提示：
//    1 <= s.length <= 15
//    s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
//    题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
//    题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
//    IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
//    关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。


public class Q13 {

    static Map<Character, Integer> romanChars = new HashMap<>();

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = cin.nextLine().strip();
        cin.close();
        int result = romanToInt(s);
        System.out.println(result);
    }
    private static int romanToInt(String s) {
        romanChars.put('I', 1);
        romanChars.put('V', 5);
        romanChars.put('X', 10);
        romanChars.put('L', 50);
        romanChars.put('C', 100);
        romanChars.put('D', 500);
        romanChars.put('M', 1000);
        int result = 0;
        int n = s.length();
        int index = n - 1;
        int curLevel = 1;
        while (index >= 0){
            char curChar = s.charAt(index);
            int val = romanChars.get(curChar);
            if (val >= curLevel) {
                result += val;
                curLevel = val;
            } else {
                result -= val;
            }
            index--;
        }
        return result;
    }
}