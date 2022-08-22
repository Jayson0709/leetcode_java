package algorithms.windowSliding;

import utils.InputMethods;


//You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
//
//    You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
//
//    You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
//    Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
//    Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
//    Given the integer array fruits, return the maximum number of fruits you can pick.
//
//    Example 1:
//    Input: fruits = [1,2,1]
//    Output: 3
//    Explanation: We can pick from all 3 trees.
//
//    Example 2:
//    Input: fruits = [0,1,2,2]
//    Output: 3
//    Explanation: We can pick from trees [1,2,2].
//    If we had started at the first tree, we would only pick from trees [0,1].
//
//    Example 3:
//    Input: fruits = [1,2,3,2,2]
//    Output: 4
//    Explanation: We can pick from trees [2,3,2,2].
//    If we had started at the first tree, we would only pick from trees [1,2].
//
//    Constraints:
//    1 <= fruits.length <= 105
//    0 <= fruits[i] < fruits.length


//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
//
//    你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
//
//    你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
//    你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
//    一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
//    给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
//
//    示例 1：
//    输入：fruits = [1,2,1]
//    输出：3
//    解释：可以采摘全部 3 棵树。
//
//    示例 2：
//    输入：fruits = [0,1,2,2]
//    输出：3
//    解释：可以采摘 [1,2,2] 这三棵树。
//    如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
//
//    示例 3：
//    输入：fruits = [1,2,3,2,2]
//    输出：4
//    解释：可以采摘 [2,3,2,2] 这四棵树。
//    如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
//
//    示例 4：
//    输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
//    输出：5
//    解释：可以采摘 [1,2,1,1,2] 这五棵树。
//
//    提示：
//    1 <= fruits.length <= 105
//    0 <= fruits[i] < fruits.length


public class Q904 {
    public static void main(String[] args) {
        int result = totalFruit(InputMethods.getInputForOneIntArray());
        System.out.println(result);
    }

    private static int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n == 1 || n == 2) {
            return n;
        }
        int result = 0;
        int[] baskets = new int[]{-1, -1}; // an array to store the fruits in each basket
        int curFruit = -1;
        int curFruitStartIndex = 0;
        int basketStartIndex = 0;
        int curWindowSize;
        for (int i = 0; i < n; i++) {
            int fruit = fruits[i];
            // Get a fruit that is allowed to pick up for current types we have.
            if (fruit == baskets[0] || fruit == baskets[1]) {
                // if the fruit is not what we currently hold, update curFruit and curFruitStartIndex.
                if (fruit != curFruit) {
                    curFruit = fruit;
                    curFruitStartIndex = i;
                }
            } else { // Get a fruit that is not allowed to pick up for current types we have.
                // Update the index of the left side of the window.
                basketStartIndex = curFruitStartIndex;
                curFruitStartIndex = i;
                // Update the baskets accordingly.
                if (baskets[0] == curFruit) {
                    baskets[1] = fruit;
                    curFruit = baskets[1];
                } else {
                    baskets[0] = fruit;
                    curFruit = baskets[0];
                }
            }
            // Calculate the current window size
            curWindowSize = i - basketStartIndex + 1;
            // Keep the maximum window size
            result = Math.max(result, curWindowSize);
        }
        return result;
    }
}
