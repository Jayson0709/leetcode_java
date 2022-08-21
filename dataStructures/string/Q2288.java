package dataStructures.string;
import java.util.*;
import java.nio.charset.StandardCharsets;


//A sentence is a string of single-space separated words where each word can contain digits, lowercase letters, and the dollar sign '$'. A word represents a price if it is a sequence of digits preceded by a dollar sign.
//
//    For example, "$100", "$23", and "$6" represent prices while "100", "$", and "$1e5" do not.
//    You are given a string sentence representing a sentence and an integer discount. For each word representing a price, apply a discount of discount% on the price and update the word in the sentence. All updated prices should be represented with exactly two decimal places.
//
//    Return a string representing the modified sentence.
//
//    Note that all prices will contain at most 10 digits.
//
//    Example 1:
//    Input: sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
//    Output: "there are $0.50 $1.00 and 5$ candies in the shop"
//    Explanation:
//    The words which represent prices are "$1" and "$2".
//    - A 50% discount on "$1" yields "$0.50", so "$1" is replaced by "$0.50".
//    - A 50% discount on "$2" yields "$1". Since we need to have exactly 2 decimal places after a price, we replace "$2" with "$1.00".
//
//    Example 2:
//    Input: sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
//    Output: "1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
//    Explanation:
//    Applying a 100% discount on any price will result in 0.
//    The words representing prices are "$3", "$5", "$6", and "$9".
//    Each of them is replaced by "$0.00".
//
//    Constraints:
//    1 <= sentence.length <= 105
//    sentence consists of lowercase English letters, digits, ' ', and '$'.
//    sentence does not have leading or trailing spaces.
//    All words in sentence are separated by a single space.
//    All prices will be positive numbers without leading zeros.
//    All prices will have at most 10 digits.
//    0 <= discount <= 100


//句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个价格。
//
//    例如 "$100"、"$23" 和 "$6.75" 表示价格，而 "100"、"$" 和 "2$3" 不是。
//    注意：本题输入中的价格均为整数。
//
//    给你一个字符串 sentence 和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
//
//    返回表示修改后句子的字符串。
//
//    示例 1：
//    输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
//    输出："there are $0.50 $1.00 and 5$ candies in the shop"
//    解释：
//    表示价格的单词是 "$1" 和 "$2" 。
//    - "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。
//    - "$2" 减免 50% 为 "$1" ，所以 "$1" 替换为 "$1.00" 。
//
//    示例 2：
//    输入：sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
//    输出："1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
//    解释：
//    任何价格减免 100% 都会得到 0 。
//    表示价格的单词分别是 "$3"、"$5"、"$6" 和 "$9"。
//    每个单词都替换为 "$0.00"。
//
//    提示：
//    1 <= sentence.length <= 105
//    sentence 由小写英文字母、数字、' ' 和'$' 组成
//    sentence 不含前导和尾随空格
//    sentence 的所有单词都用单个空格分隔
//    所有价格都是 正 整数且不含前导零
//    所有价格 最多 为 10 位数字
//    0 <= discount <= 100


public class Q2288 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String sentence = cin.nextLine().strip();
        int discount = cin.nextInt();
        cin.close();

        String result = discountPrices(sentence, discount);
        System.out.println(result);
    }

    private static String discountPrices(String sentence, int discount) {
        String[] strings = sentence.split(" ");
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < strings.length; i++) {
            String s = strings[i];
            if(s.matches("[$][0-9]+")) { // use Regular Expression, only one $ with number(s)
                s = s.substring(1); // remove the $ sign
                double d = Double.parseDouble(s);   // convert to double
                d = d - d * ((double)discount / 100);   // minus the discount
                strings[i] = "$" + String.format("%.2f", d);   // round to two decimals, and add the $ sign.
            }
            strBuilder.append(strings[i]);
            if(i < strings.length - 1) {
                strBuilder.append(" ");
            }
        }
        return strBuilder.toString();
    }
}
