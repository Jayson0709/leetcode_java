package algorithms.memoization;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//    Note that the same word in the dictionary may be reused multiple times in the segmentation.
//
//    Example 1:
//    Input: s = "leetcode", wordDict = ["leet","code"]
//    Output: true
//    Explanation: Return true because "leetcode" can be segmented as "leet code".
//
//    Example 2:
//    Input: s = "applepenapple", wordDict = ["apple","pen"]
//    Output: true
//    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//    Note that you are allowed to reuse a dictionary word.
//
//    Example 3:
//    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//    Output: false
//
//    Constraints:
//    1 <= s.length <= 300
//    1 <= wordDict.length <= 1000
//    1 <= wordDict[i].length <= 20
//    s and wordDict[i] consist of only lowercase English letters.
//    All the strings of wordDict are unique.



//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//
//    注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
//
//    示例 1：
//    输入: s = "leetcode", wordDict = ["leet", "code"]
//    输出: true
//    解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
//
//    示例 2：
//    输入: s = "applepenapple", wordDict = ["apple", "pen"]
//    输出: true
//    解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//        注意，你可以重复使用字典中的单词。
//
//    示例 3：
//    输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//    输出: false
//
//    提示：
//    1 <= s.length <= 300
//    1 <= wordDict.length <= 1000
//    1 <= wordDict[i].length <= 20
//    s 和 wordDict[i] 仅有小写英文字母组成
//    wordDict 中的所有字符串 互不相同


public class Q139 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String s = cin.nextLine();
        String[] words = cin.nextLine().strip().split(" ");
        cin.close();
        List<String> wordDict = new ArrayList<>(Arrays.asList(words));
        boolean result = wordBreak(s, wordDict);
        System.out.println(result);
    }

    // Method 1: Dynamic programming
//    private static boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> wordDictSet = new HashSet<>(wordDict);
//        boolean[] dp = new boolean[s.length() + 1];
//        dp[0] = true;
//        for (int i = 1; i <= s.length(); i++) {
//           for (int j = 0; j < i; j++) {
//               if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
//                   dp[i] = true;
//                   break;
//               }
//           }
//        }
//        return dp[s.length()];
//    }


    // Method 2: DFS + memoization
    static Set<Integer> indexSet = new HashSet<>();
    private static boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, indexSet, 0);
    }

    private static boolean dfs(String s, List<String> wordDict, Set<Integer> indexSet, int startIndex) {
        // String is already fully checked.
        if (startIndex == s.length()) {
            return true;
        }
        for (int i = startIndex + 1; i <= s.length(); i++) {
            // If already visited, skip and avoid for repetition.
            if (indexSet.contains(i)) {
                continue;
            }
            // Get the substring and check whether in the wordDict.
            if (wordDict.contains(s.substring(startIndex, i))) {
                if (dfs(s, wordDict, indexSet, i)) {
                    return true;
                }
                // flag the index.
                indexSet.add(i);
            }
        }
        return false;
    }
}
