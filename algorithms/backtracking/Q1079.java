package algorithms.backtracking;
import java.util.*;
import java.nio.charset.StandardCharsets;

//You have n tiles, where each tile has one letter tiles[i] printed on it.
//
//    Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
//
//    Example 1:
//    Input: tiles = "AAB"
//    Output: 8
//    Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
//
//    Example 2:
//    Input: tiles = "AAABBC"
//    Output: 188
//
//    Example 3:
//    Input: tiles = "V"
//    Output: 1
//
//    Constraints:
//    1 <= tiles.length <= 7
//    tiles consists of uppercase English letters.

// 你有一套活字字模tiles，其中每个字模上都刻有一个字母tiles[i]。返回你可以印出的非空字母序列的数目。
// 注意：本题中，每个活字字模只能使用一次。
//
// 示例 1：
// 输入："AAB"
// 输出：8
// 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
//
// 示例 2：
// 输入："AAABBC"
// 输出：188
//
// 示例 3：
// 输入："V"
// 输出：1
//
// 提示：
// 1 <= tiles.length <= 7
// tiles 由大写英文字母组成


public class Q1079 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String tiles = cin.nextLine().strip();
        cin.close();

        int result = numTilePossibilities(tiles);
        System.out.println(result);
    }

    // 方法一，sort后的数组＋回溯
    private static int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        int[] result = new int[1];
        backtrack(result, chars, new boolean[tiles.length()], tiles.length(), 0);
        return result[0];
    }

    private static void backtrack(int[] res, char[] chars, boolean[] used, int length, int index) {
        if (index == length) {
            return;
        }
        for (int i = 0; i < length; i++) {
            if ((used[i]) || (i - 1 >= 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            res[0]++;
            backtrack(res, chars, used, length, index + 1);
            used[i] = false;
        }
    }

    // 方法二，建立一个size为26的chars数组，检查每个字符的使用情况，并进行回溯。
    // public static int numTilePossibilities(String tiles) {
    //     char[] chars = tiles.toCharArray();
    //     int[] count = new int[26];
    //     for (char c : chars) {
    //         count[c - 'A']++;
    //     }
    //     int[] result = new int[1];
    //     backtrack(result, count);
    //     return result[0];
    // }

    // public static void backtrack(int[] res, int[] count) {
    //     for (int i = 0; i < 26; i++) {
    //         if (count[i] == 0) {
    //             continue;
    //         }
    //         count[i]--;
    //         res[0]++;
    //         backtrack(res, count);
    //         count[i]++;
    //     }
    // }
}
