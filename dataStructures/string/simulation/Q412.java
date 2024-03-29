package dataStructures.string.simulation;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



//Given an integer n, return a string array answer (1-indexed) where:
//
//    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
//    answer[i] == "Fizz" if i is divisible by 3.
//    answer[i] == "Buzz" if i is divisible by 5.
//    answer[i] == i (as a string) if none of the above conditions are true.
//
//    Example 1:
//    Input: n = 3
//    Output: ["1","2","Fizz"]
//
//    Example 2:
//    Input: n = 5
//    Output: ["1","2","Fizz","4","Buzz"]
//
//    Example 3:
//    Input: n = 15
//    Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
//
//    Constraints:
//    1 <= n <= 10^4



//给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
//
//    answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
//    answer[i] == "Fizz" 如果 i 是 3 的倍数。
//    answer[i] == "Buzz" 如果 i 是 5 的倍数。
//    answer[i] == i （以字符串形式）如果上述条件全不满足。
//
//    示例 1：
//    输入：n = 3
//    输出：["1","2","Fizz"]
//
//    示例 2：
//    输入：n = 5
//    输出：["1","2","Fizz","4","Buzz"]
//
//    示例 3：
//    输入：n = 15
//    输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
//
//    提示：
//    1 <= n <= 10^4



public class Q412 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = cin.nextInt();
        cin.close();
        System.out.println(fizzBuzz(n));
    }

    private static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            if (i % 3 == 0) {
                temp.append("Fizz");
            }
            if (i % 5 == 0) {
                temp.append("Buzz");
            }
            if (temp.length() == 0) {
                temp.append(i);
            }
            res.add(temp.toString());
        }
        return res;
    }
}
