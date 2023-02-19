package dataStructures.queue.priorityQueue;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


//There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.
//
//    You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.
//
//    The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.
//
//    Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.
//
//    Example 1:
//    Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
//    Output: 0.78333
//    Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
//
//    Example 2:
//    Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
//    Output: 0.53485
//
//    Constraints:
//    1 <= classes.length <= 10^5
//    classes[i].length == 2
//    1 <= passi <= totali <= 10^5
//    1 <= extraStudents <= 10^5


//一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。
//
//    给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
//
//    一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。
//
//    请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。
//
//    示例 1：
//    输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
//    输出：0.78333
//    解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
//
//    示例 2：
//    输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
//    输出：0.53485
//
//    提示：
//    1 <= classes.length <= 10^5
//    classes[i].length == 2
//    1 <= passi <= totali <= 10^5
//    1 <= extraStudents <= 10^5


public class Q1792 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> classes = new ArrayList<>();
        InputMethods.getInputForIntArrArrayList(cin, classes);
        int extraStudents = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        System.out.println(maxAverageRatio(
            DataConversionMethods.convertIntArrArrayListTo2DArray(classes), extraStudents));
    }

    private static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (val1 == val2) {
                return 0;
            }
            return val1 < val2 ? 1 : -1;
        });
        for (int[] c : classes) {
            pq.offer(new int[]{c[0], c[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] arr = pq.poll();
            int pass = arr[0];
            int total = arr[1];
            pq.offer(new int[]{pass + 1, total + 1});
        }

        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] arr = pq.poll();
            int pass = arr[0];
            int total = arr[1];
            res += 1.0 * pass / total;
        }
        return res / classes.length;
    }
}
