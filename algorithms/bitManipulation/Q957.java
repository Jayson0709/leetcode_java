package algorithms.bitManipulation;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//There are 8 prison cells in a row and each cell is either occupied or vacant.
//
//    Each day, whether the cell is occupied or vacant changes according to the following rules:
//
//    If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
//    Otherwise, it becomes vacant.
//    Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.
//
//    You are given an integer array cells where cells[i] == 1 if the ith cell is occupied and cells[i] == 0 if the ith cell is vacant, and you are given an integer n.
//
//    Return the state of the prison after n days (i.e., n such changes described above).
//
//    Example 1:
//    Input: cells = [0,1,0,1,1,0,0,1], n = 7
//    Output: [0,0,1,1,0,0,0,0]
//    Explanation: The following table summarizes the state of the prison on each day:
//    Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
//    Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
//    Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
//    Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
//    Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
//    Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
//    Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
//    Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
//    
//    Example 2:
//    Input: cells = [1,0,0,1,0,0,1,0], n = 1000000000
//    Output: [0,0,1,1,1,1,1,0]
//
//    Constraints:
//    cells.length == 8
//    cells[i] is either 0 or 1.
//    1 <= n <= 10^9


//监狱中 8 间牢房排成一排，每间牢房可能被占用或空置。
//
//    每天，无论牢房是被占用或空置，都会根据以下规则进行变更：
//
//    如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
//    否则，它就会被空置。
//    注意：由于监狱中的牢房排成一行，所以行中的第一个和最后一个牢房不存在两个相邻的房间。
//
//    给你一个整数数组 cells ，用于表示牢房的初始状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0 。另给你一个整数 n 。
//
//    请你返回 n 天后监狱的状况（即，按上文描述进行 n 次变更）。
//
//    示例 1：
//    输入：cells = [0,1,0,1,1,0,0,1], n = 7
//    输出：[0,0,1,1,0,0,0,0]
//    解释：下表总结了监狱每天的状况：
//    Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
//    Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
//    Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
//    Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
//    Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
//    Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
//    Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
//    Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
//
//    示例 2：
//    输入：cells = [1,0,0,1,0,0,1,0], n = 1000000000
//    输出：[0,0,1,1,1,1,1,0]
//
//    提示：
//    cells.length == 8
//    cells[i] 为 0 或 1
//    1 <= n <= 10^9



public class Q957 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] cells = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        int[] result = prisonAfterNDays(cells, n);
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    private static int[] prisonAfterNDays(int[] cells, int n) {
        Map<Integer, Integer> seen = new HashMap<>();
        int state = 0;
        for (int i = 0; i < 8; i++) {
            if (cells[i] > 0) {
                state ^= 1 << i;
            }
        }

        while (n > 0) {
            if (seen.containsKey(state)) {
                n %= seen.get(state) - n;
            }
            seen.put(state, n);
            if (n >= 1) {
                n--;
                state = nextDay(state);
            }
        }
        int[] res = new int[8];
        for (int i = 0; i < 8; i++) {
            if (((state >> i) & 1) > 0) {
                res[i] = 1;
            }
        }
        return res;
    }

    private static int nextDay(int state) {
        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
                ans ^= 1 << i;
            }
        }
        return ans;
    }
}
