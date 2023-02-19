package algorithms.twoPointers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Given a callable function f(x, y) with a hidden formula and a value z, reverse engineer the formula and return all positive integer pairs x and y where f(x,y) == z. You may return the pairs in any order.
//
//    While the exact formula is hidden, the function is monotonically increasing, i.e.:
//
//    f(x, y) < f(x + 1, y)
//    f(x, y) < f(x, y + 1)
//    The function interface is defined like this:
//
//interface CustomFunction {
//    public:
//    // Returns some positive integer f(x, y) for two positive integers x and y based on a formula.
//    int f(int x, int y);
//};
//We will judge your solution as follows:
//
//    The judge has a list of 9 hidden implementations of CustomFunction, along with a way to generate an answer key of all valid pairs for a specific z.
//    The judge will receive two inputs: a function_id (to determine which implementation to test your code with), and the target z.
//    The judge will call your findSolution and compare your results with the answer key.
//    If your results match the answer key, your solution will be Accepted.
//
//    Example 1:
//    Input: function_id = 1, z = 5
//    Output: [[1,4],[2,3],[3,2],[4,1]]
//    Explanation: The hidden formula for function_id = 1 is f(x, y) = x + y.
//    The following positive integer values of x and y make f(x, y) equal to 5:
//    x=1, y=4 -> f(1, 4) = 1 + 4 = 5.
//    x=2, y=3 -> f(2, 3) = 2 + 3 = 5.
//    x=3, y=2 -> f(3, 2) = 3 + 2 = 5.
//    x=4, y=1 -> f(4, 1) = 4 + 1 = 5.
//
//    Example 2:
//    Input: function_id = 2, z = 5
//    Output: [[1,5],[5,1]]
//    Explanation: The hidden formula for function_id = 2 is f(x, y) = x * y.
//    The following positive integer values of x and y make f(x, y) equal to 5:
//    x=1, y=5 -> f(1, 5) = 1 * 5 = 5.
//    x=5, y=1 -> f(5, 1) = 5 * 1 = 5.
//
//    Constraints:
//    1 <= function_id <= 9
//    1 <= z <= 100
//    It is guaranteed that the solutions of f(x, y) == z will be in the range 1 <= x, y <= 1000.
//    It is also guaranteed that f(x, y) will fit in 32 bit signed integer if 1 <= x, y <= 1000.


//给你一个函数  f(x, y) 和一个目标结果 z，函数公式未知，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。满足条件的结果数对可以按任意顺序返回。
//
//    尽管函数的具体式子未知，但它是单调递增函数，也就是说：
//    f(x, y) < f(x + 1, y)
//    f(x, y) < f(x, y + 1)
//    函数接口定义如下：
//
//interface CustomFunction {
//    public:
//    // Returns some positive integer f(x, y) for two positive integers x and y based on a formula.
//    int f(int x, int y);
//};
//你的解决方案将按如下规则进行评判：
//
//    判题程序有一个由 CustomFunction 的 9 种实现组成的列表，以及一种为特定的 z 生成所有有效数对的答案的方法。
//    判题程序接受两个输入：function_id（决定使用哪种实现测试你的代码）以及目标结果 z 。
//    判题程序将会调用你实现的 findSolution 并将你的结果与答案进行比较。
//    如果你的结果与答案相符，那么解决方案将被视作正确答案，即 Accepted 。
//
//    示例 1：
//    输入：function_id = 1, z = 5
//    输出：[[1,4],[2,3],[3,2],[4,1]]
//    解释：function_id = 1 暗含的函数式子为 f(x, y) = x + y
//    以下 x 和 y 满足 f(x, y) 等于 5：
//    x=1, y=4 -> f(1, 4) = 1 + 4 = 5
//    x=2, y=3 -> f(2, 3) = 2 + 3 = 5
//    x=3, y=2 -> f(3, 2) = 3 + 2 = 5
//    x=4, y=1 -> f(4, 1) = 4 + 1 = 5
//
//    示例 2：
//    输入：function_id = 2, z = 5
//    输出：[[1,5],[5,1]]
//    解释：function_id = 2 暗含的函数式子为 f(x, y) = x * y
//    以下 x 和 y 满足 f(x, y) 等于 5：
//    x=1, y=5 -> f(1, 5) = 1 * 5 = 5
//    x=5, y=1 -> f(5, 1) = 5 * 1 = 5
//
//    提示：
//    1 <= function_id <= 9
//    1 <= z <= 100
//    题目保证 f(x, y) == z 的解处于 1 <= x, y <= 1000 的范围内。
//    在 1 <= x, y <= 1000 的前提下，题目保证 f(x, y) 是一个 32 位有符号整数。


public class Q1237 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int funcType = Integer.parseInt(cin.nextLine().strip());
        int z = Integer.parseInt(cin.nextLine().strip());
        cin.close();
        System.out.println(findSolution(new CustomFunction(funcType), z));
    }

    // Method 1: enumerate
//    private static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
//        List<List<Integer>> res = new ArrayList<>();
//        for (int x = 1; x <= 1000; x++) {
//            for (int y = 1; y <= 1000; y++) {
//                if (customfunction.f(x, y) == z) {
//                    List<Integer> pair = new ArrayList<>();
//                    pair.add(x);
//                    pair.add(y);
//                    res.add(pair);
//                }
//            }
//        }
//        return res;
//    }

    // Method 2: Binary Search
//    private static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
//        List<List<Integer>> res = new ArrayList<>();
//        for (int x = 1; x <= 1000; x++) {
//            int yLeft = 1;
//            int yRight = 1000;
//            while (yLeft <= yRight) {
//                int yMiddle = (yLeft + yRight) / 2;
//                if (customfunction.f(x, yMiddle) == z) {
//                    List<Integer> pair = new ArrayList<Integer>();
//                    pair.add(x);
//                    pair.add(yMiddle);
//                    res.add(pair);
//                    break;
//                }
//                if (customfunction.f(x, yMiddle) > z) {
//                    yRight = yMiddle - 1;
//                } else {
//                    yLeft = yMiddle + 1;
//                }
//            }
//        }
//        return res;
//    }

    // Method 3: two pointers
    private static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int x = 1, y = 1000; x <= 1000 && y >= 1; x++) {
            while (y >= 1 && customfunction.f(x, y) > z) {
                y--;
            }
            if (y >= 1 && customfunction.f(x, y) == z) {
                List<Integer> pair = new ArrayList<>();
                pair.add(x);
                pair.add(y);
                res.add(pair);
            }
        }
        return res;
    }
}


class CustomFunction {

    public int funcType;

    public CustomFunction(int funcType) {
        this.funcType = funcType;
    }

    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    // Need to implement this func
    public int f(int x, int y) {
        return 1;
    }
}