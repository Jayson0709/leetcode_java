package dataStructures.array.simpleArray;

import utils.DataConversionMethods;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


//You are given a 0-indexed 2D integer array brackets where brackets[i] = [upper_i, percent_i] means that the ith tax bracket has an upper bound of upper_i and is taxed at a rate of percent_i. The brackets are sorted by upper bound (i.e. upper_i-1 < upper_i for 0 < i < brackets.length).
//
//    Tax is calculated as follows:
//
//    The first upper0 dollars earned are taxed at a rate of percent0.
//    The next upper1 - upper0 dollars earned are taxed at a rate of percent1.
//    The next upper2 - upper1 dollars earned are taxed at a rate of percent2.
//    And so on.
//    You are given an integer income representing the amount of money you earned. Return the amount of money that you have to pay in taxes. Answers within 10-5 of the actual answer will be accepted.
//
//    Example 1:
//    Input: brackets = [[3,50],[7,10],[12,25]], income = 10
//    Output: 2.65000
//    Explanation:
//    Based on your income, you have 3 dollars in the 1st tax bracket, 4 dollars in the 2nd tax bracket, and 3 dollars in the 3rd tax bracket.
//    The tax rate for the three tax brackets is 50%, 10%, and 25%, respectively.
//    In total, you pay $3 * 50% + $4 * 10% + $3 * 25% = $2.65 in taxes.
//
//    Example 2:
//    Input: brackets = [[1,0],[4,25],[5,50]], income = 2
//    Output: 0.25000
//    Explanation:
//    Based on your income, you have 1 dollar in the 1st tax bracket and 1 dollar in the 2nd tax bracket.
//    The tax rate for the two tax brackets is 0% and 25%, respectively.
//    In total, you pay $1 * 0% + $1 * 25% = $0.25 in taxes.
//
//    Example 3:
//    Input: brackets = [[2,50]], income = 0
//    Output: 0.00000
//    Explanation:
//    You have no income to tax, so you have to pay a total of $0 in taxes.
//
//    Constraints:
//    1 <= brackets.length <= 100
//    1 <= upper_i <= 1000
//    0 <= percent_i <= 100
//    0 <= income <= 1000
//    upper_i is sorted in ascending order.
//    All the values of upper_i are unique.
//    The upper bound of the last tax bracket is greater than or equal to income.



//给你一个下标从 0 开始的二维整数数组 brackets ，其中 brackets[i] = [upper_i, percent_i] ，表示第 i 个税级的上限是 upper_i ，征收的税率为 percent_i 。税级按上限 从低到高排序（在满足 0 < i < brackets.length 的前提下，upper_i-1 < upper_i）。
//
//    税款计算方式如下：
//
//    不超过 upper0 的收入按税率 percent0 缴纳
//    接着 upper1 - upper0 的部分按税率 percent1 缴纳
//    然后 upper2 - upper1 的部分按税率 percent2 缴纳
//    以此类推
//    给你一个整数 income 表示你的总收入。返回你需要缴纳的税款总额。与标准答案误差不超 10-5 的结果将被视作正确答案。
//
//    示例 1：
//    输入：brackets = [[3,50],[7,10],[12,25]], income = 10
//    输出：2.65000
//    解释：
//    前 $3 的税率为 50% 。需要支付税款 $3 * 50% = $1.50 。
//    接下来 $7 - $3 = $4 的税率为 10% 。需要支付税款 $4 * 10% = $0.40 。
//    最后 $10 - $7 = $3 的税率为 25% 。需要支付税款 $3 * 25% = $0.75 。
//    需要支付的税款总计 $1.50 + $0.40 + $0.75 = $2.65 。
//
//    示例 2：
//    输入：brackets = [[1,0],[4,25],[5,50]], income = 2
//    输出：0.25000
//    解释：
//    前 $1 的税率为 0% 。需要支付税款 $1 * 0% = $0 。
//    剩下 $1 的税率为 25% 。需要支付税款 $1 * 25% = $0.25 。
//    需要支付的税款总计 $0 + $0.25 = $0.25 。
//
//    示例 3：
//    输入：brackets = [[2,50]], income = 0
//    输出：0.00000
//    解释：
//    没有收入，无需纳税，需要支付的税款总计 $0 。
//
//    提示：
//    1 <= brackets.length <= 100
//    1 <= upper_i <= 1000
//    0 <= percent_i <= 100
//    0 <= income <= 1000
//    upper_i 按递增顺序排列
//    upper_i 中的所有值 互不相同
//    最后一个税级的上限大于等于 income



public class Q2303 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<int[]> data = new ArrayList<>();
        int income = 0;
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            } else {
                int[] temp = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                if (temp.length == 1) {
                    income = temp[0];
                } else {
                    data.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
                }
            }
        }
        cin.close();
        System.out.println(calculateTax(DataConversionMethods.convertIntArrArrayListTo2DArray(data), income));
    }

    private static double calculateTax(int[][] brackets, int income) {
        double res = 0.0;
        int prevUpper = 0;
        for (int[] bracket : brackets) {
            if (income <= bracket[0]) {
                res += (double) (income - prevUpper) * bracket[1] / 100;
                break;
            }
            res += (double) (bracket[0] - prevUpper) * bracket[1] / 100;
            prevUpper = bracket[0];
        }
        return res;
    }
}
