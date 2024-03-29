package algorithms.backtracking;

import utils.InputMethods;
import utils.TwoOneDIntArrayAndOneInt;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;



//You would like to make dessert and are preparing to buy the ingredients. You have n ice cream base flavors and m types of toppings to choose from. You must follow these rules when making your dessert:
//
//    There must be exactly one ice cream base.
//    You can add one or more types of topping or have no toppings at all.
//    There are at most two of each type of topping.
//    You are given three inputs:
//
//    baseCosts, an integer array of length n, where each baseCosts[i] represents the price of the ith ice cream base flavor.
//    toppingCosts, an integer array of length m, where each toppingCosts[i] is the price of one of the ith topping.
//    target, an integer representing your target price for dessert.
//    You want to make a dessert with a total cost as close to target as possible.
//
//    Return the closest possible cost of the dessert to target. If there are multiple, return the lower one.
//
//    Example 1:
//    Input: baseCosts = [1,7], toppingCosts = [3,4], target = 10
//    Output: 10
//    Explanation: Consider the following combination (all 0-indexed):
//    - Choose base 1: cost 7
//    - Take 1 of topping 0: cost 1 x 3 = 3
//    - Take 0 of topping 1: cost 0 x 4 = 0
//    Total: 7 + 3 + 0 = 10.
//
//    Example 2:
//    Input: baseCosts = [2,3], toppingCosts = [4,5,100], target = 18
//    Output: 17
//    Explanation: Consider the following combination (all 0-indexed):
//    - Choose base 1: cost 3
//    - Take 1 of topping 0: cost 1 x 4 = 4
//    - Take 2 of topping 1: cost 2 x 5 = 10
//    - Take 0 of topping 2: cost 0 x 100 = 0
//    Total: 3 + 4 + 10 + 0 = 17. You cannot make a dessert with a total cost of 18.
//
//    Example 3:
//    Input: baseCosts = [3,10], toppingCosts = [2,5], target = 9
//    Output: 8
//    Explanation: It is possible to make desserts with cost 8 and 10. Return 8 as it is the lower cost.
//
//    Constraints:
//    n == baseCosts.length
//    m == toppingCosts.length
//    1 <= n, m <= 10
//    1 <= baseCosts[i], toppingCosts[i] <= 10^4
//    1 <= target <= 10^4



//你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
//
//    必须选择 一种 冰激凌基料。
//    可以添加 一种或多种 配料，也可以不添加任何配料。
//    每种类型的配料 最多两份 。
//    给你以下三个输入：
//
//    baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
//    toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
//    target ，一个整数，表示你制作甜点的目标价格。
//    你希望自己做的甜点总成本尽可能接近目标价格 target 。
//
//    返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
//
//    示例 1：
//    输入：baseCosts = [1,7], toppingCosts = [3,4], target = 10
//    输出：10
//    解释：考虑下面的方案组合（所有下标均从 0 开始）：
//    - 选择 1 号基料：成本 7
//    - 选择 1 份 0 号配料：成本 1 x 3 = 3
//    - 选择 0 份 1 号配料：成本 0 x 4 = 0
//    总成本：7 + 3 + 0 = 10 。
//
//    示例 2：
//    输入：baseCosts = [2,3], toppingCosts = [4,5,100], target = 18
//    输出：17
//    解释：考虑下面的方案组合（所有下标均从 0 开始）：
//    - 选择 1 号基料：成本 3
//    - 选择 1 份 0 号配料：成本 1 x 4 = 4
//    - 选择 2 份 1 号配料：成本 2 x 5 = 10
//    - 选择 0 份 2 号配料：成本 0 x 100 = 0
//    总成本：3 + 4 + 10 + 0 = 17 。不存在总成本为 18 的甜点制作方案。
//
//    示例 3：
//    输入：baseCosts = [3,10], toppingCosts = [2,5], target = 9
//    输出：8
//    解释：可以制作总成本为 8 和 10 的甜点。返回 8 ，因为这是成本更低的方案。
//
//    示例 4：
//    输入：baseCosts = [10], toppingCosts = [1], target = 1
//    输出：10
//    解释：注意，你可以选择不添加任何配料，但你必须选择一种基料。
//
//    提示：
//    n == baseCosts.length
//    m == toppingCosts.length
//    1 <= n, m <= 10
//    1 <= baseCosts[i], toppingCosts[i] <= 10^4
//    1 <= target <= 10^4


public class Q1774 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArrayAndOneInt obj = InputMethods.getInputForTwoInt1DArrayAndOneInt(cin);
        cin.close();
        System.out.println(closestCost(obj.array1, obj.array2, obj.val));
    }

    // Version 1: Backtracking + DFS
    static int res;
    private static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res = Arrays.stream(baseCosts).min().getAsInt();
        for (int b : baseCosts) {
            dfs(toppingCosts, 0, b, target);
        }
        return res;
    }

    public static void dfs(int[] toppingCosts, int p, int curCost, int target) {
        if (Math.abs(res - target) < curCost - target) {
            return;
        } else if (Math.abs(res - target) >= Math.abs(curCost - target)) {
            if (Math.abs(res - target) > Math.abs(curCost - target)) {
                res = curCost;
            } else {
                res = Math.min(res, curCost);
            }
        }
        if (p == toppingCosts.length) {
            return;
        }
        dfs(toppingCosts, p + 1, curCost + toppingCosts[p] * 2, target);
        dfs(toppingCosts, p + 1, curCost + toppingCosts[p], target);
        dfs(toppingCosts, p + 1, curCost, target);
    }

    // Version 2: Dynamic programming
//    private static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
//        int x = Arrays.stream(baseCosts).min().getAsInt();
//        if (x >= target) {
//            return x;
//        }
//        boolean[] can = new boolean[target + 1];
//        int res = 2 * target - x;
//        for (int b : baseCosts) {
//            if (b <= target) {
//                can[b] = true;
//            } else {
//                res = Math.min(res, b);
//            }
//        }
//        for (int t : toppingCosts) {
//            for (int count = 0; count < 2; ++count) {
//                for (int i = target; i > 0; --i) {
//                    if (can[i] && i + t > target) {
//                        res = Math.min(res, i + t);
//                    }
//                    if (i - t > 0) {
//                        can[i] = can[i] | can[i - t];
//                    }
//                }
//            }
//        }
//        for (int i = 0; i <= res - target; ++i) {
//            if (can[target - i]) {
//                return target - i;
//            }
//        }
//        return res;
//    }
}
