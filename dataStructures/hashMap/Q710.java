package dataStructures.hashMap;
import java.util.*;
import java.nio.charset.StandardCharsets;

//You are given an integer n and an array of unique integers blacklist. Design an algorithm to pick a random integer in the range [0, n - 1] that is not in blacklist. Any integer that is in the mentioned range and not in blacklist should be equally likely to be returned.
//
//    Optimize your algorithm such that it minimizes the number of calls to the built-in random function of your language.
//
//    Implement the Solution class:
//        Solution(int n, int[] blacklist) Initializes the object with the integer n and the blacklisted integers blacklist.
//        int pick() Returns a random integer in the range [0, n - 1] and not in blacklist.
//
//    Example 1:
//    Input
//    ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
//    [[7, [2, 3, 5]], [], [], [], [], [], [], []]
//    Output
//    [null, 0, 4, 1, 6, 1, 0, 4]
//
//    Explanation
//    Solution solution = new Solution(7, [2, 3, 5]);
//    solution.pick(); // return 0, any integer from [0,1,4,6] should be ok. Note that for every call of pick,
//    // 0, 1, 4, and 6 must be equally likely to be returned (i.e., with probability 1/4).
//    solution.pick(); // return 4
//    solution.pick(); // return 1
//    solution.pick(); // return 6
//    solution.pick(); // return 1
//    solution.pick(); // return 0
//    solution.pick(); // return 4
//
//    Constraints:
//    1 <= n <= 109
//    0 <= blacklist.length <= min(105, n - 1)
//    0 <= blacklist[i] < n
//    All the values of blacklist are unique.
//    At most 2 * 104 calls will be made to pick.


//给定一个整数 n 和一个 无重复 黑名单整数数组blacklist。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个未加入黑名单blacklist的整数。任何在上述范围内且不在黑名单blacklist中的整数都应该有 同等的可能性 被返回。
//
//    优化你的算法，使它最小化调用语言 内置 随机函数的次数。
//
//    实现Solution类:
//      Solution(int n, int[] blacklist)初始化整数 n 和被加入黑名单blacklist的整数
//      int pick()返回一个范围为 [0, n - 1] 且不在黑名单blacklist 中的随机整数
//
//    示例 1：
//    输入
//    ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
//    [[7, [2, 3, 5]], [], [], [], [], [], [], []]
//    输出
//    [null, 0, 4, 1, 6, 1, 0, 4]
//
//    解释
//    Solution solution = new Solution(7, [2, 3, 5]);
//    solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
//    // 0、1、4和6的返回概率必须相等(即概率为1/4)。
//    solution.pick(); // 返回 4
//    solution.pick(); // 返回 1
//    solution.pick(); // 返回 6
//    solution.pick(); // 返回 1
//    solution.pick(); // 返回 0
//    solution.pick(); // 返回 4
//
//    提示:
//    1 <= n <= 109
//    0 <= blacklist.length <= min(105, n - 1)
//    0 <= blacklist[i] < n
//    blacklist中所有值都 不同
//    pick最多被调用2 * 104次


public class Q710 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String[] orders = cin.nextLine().strip().split(" ");
        int n = Integer.parseInt(cin.nextLine());
        int[] blacklist = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();

        Solution obj = new Solution(n, blacklist);
        System.out.print("[null");
        for (int i = 1; i < orders.length; i++) {
            System.out.print(", " + obj.pick());
        }
        System.out.print("]");
    }
}

class Solution {
    Map<Integer, Integer> hMap;
    int whitelistLen;
    Random random;

    public Solution(int n, int[] blacklist) {
        hMap = new HashMap<>();
        random = new Random();
        whitelistLen = n - blacklist.length;
        // Regard the range [0, n - 1] as an array, randomly pick 0 to 'whitelistLen'
        // As there exist blacklisted numbers in the [0, whitelistLen] range
        // Therefore, we can map the blacklisted numbers to whitelist number of the range [whitelistLen, n - 1];
        Set<Integer> whitelist = new HashSet<>();
        // Get all the numbers that are bigger than 'whitelistLen'.
        for (int i = whitelistLen; i < n; i++) {
            whitelist.add(i);
        }
        // Remove all the blacklisted numbers.
        for (int num : blacklist) {
            whitelist.remove(num);
        }
        // Map the blacklisted numbers that are smaller than 'whitelistLen' to the whitelist that is greater than 'whitelistLen'
        Iterator<Integer> itr = whitelist.iterator();
        for (int num : blacklist) {
            if (num < whitelistLen) {
                hMap.put(num, itr.next());
            }
        }
    }

    public int pick() {
        int index = random.nextInt(whitelistLen);
        Integer blacklistIndex = hMap.get(index);
        // Get into the blacklist
        if (blacklistIndex != null) {
            return blacklistIndex;
        }
        // Does not hit the blacklist, return the index.
        return index;
    }
}
