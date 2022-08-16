package algorithms.search.binarySearch;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
//
//    Note that the letters wrap around.
//
//    For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
//
//    Example 1:
//    Input: letters = ["c","f","j"], target = "a"
//    Output: "c"
//
//    Example 2:
//    Input: letters = ["c","f","j"], target = "c"
//    Output: "f"
//
//    Example 3:
//    Input: letters = ["c","f","j"], target = "d"
//    Output: "f"
//
//    Constraints:
//    2 <= letters.length <= 10^4
//    letters[i] is a lowercase English letter.
//    letters is sorted in non-decreasing order.
//    'letters' contains at least two different characters.
//    target is a lowercase English letter.



//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母  target，请你寻找在这一有序列表里比目标字母大的最小字母。
//
//    在比较时，字母是依序循环出现的。举个例子：
//
//    如果目标字母 target = 'z' 并且字符列表为  letters = ['a', 'b']，则答案返回  'a'
//
//    示例 1：
//    输入: letters = ["c", "f", "j"]，target = "a"
//    输出: "c"
//
//    示例 2:
//    输入: letters = ["c","f","j"], target = "c"
//    输出: "f"
//
//    示例 3:
//    输入: letters = ["c","f","j"], target = "d"
//    输出: "f"
//
//    提示：
//    2 <= letters.length <= 10^4
//    letters[i]  是一个小写字母
//    letters 按非递减顺序排序
//    letters 最少包含两个不同的字母
//    target 是一个小写字母



public class Q744 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] data = cin.nextLine().strip().split(" ");
        char target = cin.nextLine().strip().charAt(0);
        cin.close();
        char[] letters = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            letters[i] = data[i].charAt(0);
        }
        System.out.println(nextGreatestLetter(letters, target));
    }

    // Method 1: linear search
//    private static char nextGreatestLetter(char[] letters, char target) {
//        char res = letters[0];
//        for (char letter : letters) {
//            if (letter > target) {
//                res = letter;
//                break;
//            }
//        }
//        return res;
//    }

    // Method 2: binary search
    private static char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        if (target >= letters[length - 1]) {
            return letters[0];
        }
        int low = 0, high = length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (letters[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return letters[low];
    }
}
