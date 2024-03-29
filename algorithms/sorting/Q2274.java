package algorithms.sorting;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Alice manages a company and has rented some floors of a building as office space. Alice has decided some of these floors should be special floors, used for relaxation only.
//
//    You are given two integers bottom and top, which denote that Alice has rented all the floors from bottom to top (inclusive). You are also given the integer array special, where special[i] denotes a special floor that Alice has designated for relaxation.
//
//    Return the maximum number of consecutive floors without a special floor.
//
//    Example 1:
//    Input: bottom = 2, top = 9, special = [4,6]
//    Output: 3
//    Explanation: The following are the ranges (inclusive) of consecutive floors without a special floor:
//    - (2, 3) with a total amount of 2 floors.
//    - (5, 5) with a total amount of 1 floor.
//    - (7, 9) with a total amount of 3 floors.
//    Therefore, we return the maximum number which is 3 floors.
//    
//    Example 2:
//    Input: bottom = 6, top = 8, special = [7,6,8]
//    Output: 0
//    Explanation: Every floor rented is a special floor, so we return 0.
//
//    Constraints:
//    1 <= special.length <= 10^5
//    1 <= bottom <= special[i] <= top <= 10^9
//    All the values of special are unique.



//Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
//
//    给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。另给你一个整数数组 special ，其中 special[i] 表示 Alice 指定用于放松的特殊楼层。
//
//    返回不含特殊楼层的 最大 连续楼层数。
//
//    示例 1：
//    输入：bottom = 2, top = 9, special = [4,6]
//    输出：3
//    解释：下面列出的是不含特殊楼层的连续楼层范围：
//    - (2, 3) ，楼层数为 2 。
//    - (5, 5) ，楼层数为 1 。
//    - (7, 9) ，楼层数为 3 。
//    因此，返回最大连续楼层数 3 。
//
//    示例 2：
//    输入：bottom = 6, top = 8, special = [7,6,8]
//    输出：0
//    解释：每层楼都被规划为特殊楼层，所以返回 0 。
//
//    提示
//    1 <= special.length <= 10^5
//    1 <= bottom <= special[i] <= top <= 10^9
//    special 中的所有值 互不相同


public class Q2274 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int bottom = cin.nextInt();
        int top = cin.nextInt();
        int[] special = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        int result = maxConsecutive(bottom, top, special);
        System.out.println(result);
    }

    private static int maxConsecutive(int bottom, int top, int[] special) {
        int result;
        Arrays.sort(special);
        int n = special.length;
        result = Math.max(special[0] - bottom, top - special[n - 1]);
        for (int i = 1; i < n; i++) {
            result = Math.max(result, special[i] - special[i - 1] - 1);
        }
        return result;
    }
}
