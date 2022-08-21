package algorithms.greedyAlgorithms;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;

//Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water. If it rains over a lake that is full of water, there will be a flood. Your goal is to avoid floods in any lake.
//
//    Given an integer array rains where:
//
//    rains[i] > 0 means there will be rains over the rains[i] lake.
//    rains[i] == 0 means there are no rains this day, and you can choose one lake this day and dry it.
//    Return an array 'ans' where:
//
//    ans.length == rains.length
//    ans[i] == -1 if rains[i] > 0.
//    ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
//    If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.
//
//    Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.
//
//    Example 1:
//    Input: rains = [1,2,3,4]
//    Output: [-1,-1,-1,-1]
//    Explanation: After the first day full lakes are [1]
//    After the second day full lakes are [1,2]
//    After the third day full lakes are [1,2,3]
//    After the fourth day full lakes are [1,2,3,4]
//    There's no day to dry any lake and there is no flood in any lake.
//
//    Example 2:
//    Input: rains = [1,2,0,0,2,1]
//    Output: [-1,-1,2,1,-1,-1]
//    Explanation: After the first day full lakes are [1]
//    After the second day full lakes are [1,2]
//    After the third day, we dry lake 2. Full lakes are [1]
//    After the fourth day, we dry lake 1. There is no full lakes.
//    After the fifth day, full lakes are [2].
//    After the sixth day, full lakes are [1,2].
//    It is easy that this scenario is flood-free. [-1,-1,1,2,-1,-1] is another acceptable scenario.
//
//    Example 3:
//    Input: rains = [1,2,0,1,2]
//    Output: []
//    Explanation: After the second day, full lakes are  [1,2]. We have to dry one lake in the third day.
//    After that, it will rain over lakes [1,2]. It's easy to prove that no matter which lake you choose to dry in the 3rd day, the other one will flood.
//
//    Constraints:
//    1 <= rains.length <= 105
//    0 <= rains[i] <= 109



//你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n个湖泊下雨前是空的，那么它就会装满水。如果第 n个湖泊下雨前是 满的，这个湖泊会发生 洪水 。你的目标是避免任意一个湖泊发生洪水。
//
//    给你一个整数数组rains，其中：
//
//    rains[i] > 0表示第 i天时，第 rains[i]个湖泊会下雨。
//    rains[i] == 0表示第 i天没有湖泊会下雨，你可以选择 一个湖泊并 抽干这个湖泊的水。
//    请返回一个数组ans，满足：
//
//    ans.length == rains.length
//    如果rains[i] > 0 ，那么ans[i] == -1。
//    如果rains[i] == 0，ans[i]是你第i天选择抽干的湖泊。
//    如果有多种可行解，请返回它们中的 任意一个。如果没办法阻止洪水，请返回一个 空的数组。
//
//    请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，那么将无事发生。
//
//    示例 1：
//    输入：rains = [1,2,3,4]
//    输出：[-1,-1,-1,-1]
//    解释：第一天后，装满水的湖泊包括 [1]
//    第二天后，装满水的湖泊包括 [1,2]
//    第三天后，装满水的湖泊包括 [1,2,3]
//    第四天后，装满水的湖泊包括 [1,2,3,4]
//    没有哪一天你可以抽干任何湖泊的水，也没有湖泊会发生洪水。
//
//    示例 2：
//    输入：rains = [1,2,0,0,2,1]
//    输出：[-1,-1,2,1,-1,-1]
//    解释：第一天后，装满水的湖泊包括 [1]
//    第二天后，装满水的湖泊包括 [1,2]
//    第三天后，我们抽干湖泊 2 。所以剩下装满水的湖泊包括 [1]
//    第四天后，我们抽干湖泊 1 。所以暂时没有装满水的湖泊了。
//    第五天后，装满水的湖泊包括 [2]。
//    第六天后，装满水的湖泊包括 [1,2]。
//    可以看出，这个方案下不会有洪水发生。同时， [-1,-1,1,2,-1,-1] 也是另一个可行的没有洪水的方案。
//
//    示例 3：
//    输入：rains = [1,2,0,1,2]
//    输出：[]
//    解释：第二天后，装满水的湖泊包括 [1,2]。我们可以在第三天抽干一个湖泊的水。
//    但第三天后，湖泊 1 和 2 都会再次下雨，所以不管我们第三天抽干哪个湖泊的水，另一个湖泊都会发生洪水。
//
//    提示：
//    1 <= rains.length <= 105
//    0 <= rains[i] <= 109


public class Q1488 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] rains = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        int[] result = avoidFlood(rains);
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    private static int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        // A queue to store the indexes of days that can be used to dry the lake.
        LinkedList<Integer> dryDayIndexes = new LinkedList<>();
        // A HashMap to store the rained lakes
        // key: the corresponding number of lake, value: the day when there is a rain on the lake.
        Map<Integer, Integer> rainedLakes = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            int val = rains[i];
            if (val == 0) {
                // No rain day
                dryDayIndexes.offer(i);
                result[i] = 1;
            } else {
                if (!rainedLakes.containsKey(val)) {
                    // Previously, there is no water in the lake, fill the rain into the lake.
                    rainedLakes.put(val, i);
                } else {
                    // The lake is already filled with water, need to dry the lake.
                    if (dryDayIndexes.isEmpty() || dryDayIndexes.getLast() < rainedLakes.get(val)) {
                        // There is no chance to dry the lake.
                        return new int[0];
                    }
                    int index = -1;
                    // Iterate the queue and find the first possible day to dry the lake.
                    for (int j = 0; j < dryDayIndexes.size(); j++) {
                        int dryDayIndex = dryDayIndexes.get(j);
                        if (dryDayIndex > rainedLakes.get(val)) {
                            index = dryDayIndex;
                            dryDayIndexes.remove(j);
                            break;
                        }
                    }
                    // update the HashMap
                    rainedLakes.put(val, i);
                    result[index] = val;
                }
            }
        }
        return result;
    }
}
