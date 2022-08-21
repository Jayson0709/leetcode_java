package dataStructures.stack;
import utils.*;

import java.util.*;
import java.nio.charset.StandardCharsets;


//On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n-1.
//
//    Function calls are stored in a call stack: when a function call starts, its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack. The function whose ID is at the top of the stack is the current function being executed. Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.
//
//    You are given a list logs, where logs[i] represents the ith log message formatted as a string "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple times, possibly recursively.
//
//    A function's exclusive time is the sum of execution times for all function calls in the program. For example, if a function is called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.
//
//    Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the function with ID i.
//
//    Example 1:
//                |(1 start)__________________________(1 end)|
//    |(0 start)__                                            __________|(0 end)
//    0          1          2          3          4          5          6
//    Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
//    Output: [3,4]
//    Explanation:
//    Function 0 starts at the beginning of time 0, then it executes 2 for units of time and reaches the end of time 1.
//    Function 1 starts at the beginning of time 2, executes for 4 units of time, and ends at the end of time 5.
//    Function 0 resumes execution at the beginning of time 6 and executes for 1 unit of time.
//    So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
//
//    Example 2:
//    Input: n = 1, logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
//    Output: [8]
//    Explanation:
//    Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls itself.
//    Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
//    Function 0 (initial call) resumes execution then immediately calls itself again.
//    Function 0 (2nd recursive call) starts at the beginning of time 6 and executes for 1 unit of time.
//    Function 0 (initial call) resumes execution at the beginning of time 7 and executes for 1 unit of time.
//    So function 0 spends 2 + 4 + 1 + 1 = 8 units of total time executing.
//
//    Example 3:
//    Input: n = 2, logs = ["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]
//    Output: [7,1]
//    Explanation:
//    Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls itself.
//    Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
//    Function 0 (initial call) resumes execution then immediately calls function 1.
//    Function 1 starts at the beginning of time 6, executes 1 unit of time, and ends at the end of time 6.
//    Function 0 resumes execution at the beginning of time 6 and executes for 2 units of time.
//    So function 0 spends 2 + 4 + 1 = 7 units of total time executing, and function 1 spends 1 unit of total time executing.
//
//    Constraints:
//    1 <= n <= 100
//    1 <= logs.length <= 500
//    0 <= function_id < n
//    0 <= timestamp <= 109
//    No two start events will happen at the same timestamp.
//    No two end events will happen at the same timestamp.
//    Each function has an "end" log for each "start" log.



//有一个 单线程 CPU 正在运行一个含有 n 道函数的程序。每道函数都有一个位于  0 和 n-1 之间的唯一标识符。
//
//    函数调用 存储在一个 调用栈 上 ：当一个函数调用开始时，它的标识符将会推入栈中。而当一个函数调用结束时，它的标识符将会从栈中弹出。标识符位于栈顶的函数是 当前正在执行的函数 。每当一个函数开始或者结束时，将会记录一条日志，包括函数标识符、是开始还是结束、以及相应的时间戳。
//
//    给你一个由日志组成的列表 logs ，其中 logs[i] 表示第 i 条日志消息，该消息是一个按 "{function_id}:{"start" | "end"}:{timestamp}" 进行格式化的字符串。例如，"0:start:3" 意味着标识符为 0 的函数调用在时间戳 3 的 起始开始执行 ；而 "1:end:2" 意味着标识符为 1 的函数调用在时间戳 2 的 末尾结束执行。注意，函数可以 调用多次，可能存在递归调用 。
//
//    函数的 独占时间 定义是在这个函数在程序所有函数调用中执行时间的总和，调用其他函数花费的时间不算该函数的独占时间。例如，如果一个函数被调用两次，一次调用执行 2 单位时间，另一次调用执行 1 单位时间，那么该函数的 独占时间 为 2 + 1 = 3 。
//
//    以数组形式返回每个函数的 独占时间 ，其中第 i 个下标对应的值表示标识符 i 的函数的独占时间。
//
//    示例 1：
//                |(1 start)__________________________(1 end)|
//    |(0 start)__                                            __________|(0 end)
//    0          1          2          3          4          5          6
//    输入：n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
//    输出：[3,4]
//    解释：
//    函数 0 在时间戳 0 的起始开始执行，执行 2 个单位时间，于时间戳 1 的末尾结束执行。
//    函数 1 在时间戳 2 的起始开始执行，执行 4 个单位时间，于时间戳 5 的末尾结束执行。
//    函数 0 在时间戳 6 的开始恢复执行，执行 1 个单位时间。
//    所以函数 0 总共执行 2 + 1 = 3 个单位时间，函数 1 总共执行 4 个单位时间。
//
//    示例 2：
//    输入：n = 1, logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
//    输出：[8]
//    解释：
//    函数 0 在时间戳 0 的起始开始执行，执行 2 个单位时间，并递归调用它自身。
//    函数 0（递归调用）在时间戳 2 的起始开始执行，执行 4 个单位时间。
//    函数 0（初始调用）恢复执行，并立刻再次调用它自身。
//    函数 0（第二次递归调用）在时间戳 6 的起始开始执行，执行 1 个单位时间。
//    函数 0（初始调用）在时间戳 7 的起始恢复执行，执行 1 个单位时间。
//    所以函数 0 总共执行 2 + 4 + 1 + 1 = 8 个单位时间。
//
//    示例 3：
//    输入：n = 2, logs = ["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]
//    输出：[7,1]
//    解释：
//    函数 0 在时间戳 0 的起始开始执行，执行 2 个单位时间，并递归调用它自身。
//    函数 0（递归调用）在时间戳 2 的起始开始执行，执行 4 个单位时间。
//    函数 0（初始调用）恢复执行，并立刻调用函数 1 。
//    函数 1在时间戳 6 的起始开始执行，执行 1 个单位时间，于时间戳 6 的末尾结束执行。
//    函数 0（初始调用）在时间戳 7 的起始恢复执行，执行 1 个单位时间，于时间戳 7 的末尾结束执行。
//    所以函数 0 总共执行 2 + 4 + 1 = 7 个单位时间，函数 1 总共执行 1 个单位时间。
//
//    示例 4：
//    输入：n = 2, logs = ["0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"]
//    输出：[8,1]
//
//    示例 5：
//    输入：n = 1, logs = ["0:start:0","0:end:0"]
//    输出：[1]
//
//    提示：
//    1 <= n <= 100
//    1 <= logs.length <= 500
//    0 <= function_id < n
//    0 <= timestamp <= 109
//    两个开始事件不会在同一时间戳发生
//    两个结束事件不会在同一时间戳发生
//    每道函数都有一个对应 "start" 日志的 "end" 日志




public class Q636 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = Integer.parseInt(cin.nextLine().strip());
        List<String> logs = Arrays.stream(cin.nextLine().strip().split(" ")).toList();
        cin.close();
        int[] result = exclusiveTime(n, logs);
        System.out.println(OutputMethods.output1DArrayData(Arrays.stream(result).boxed().toArray(Integer[]::new)));
    }

    private static int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (String log : logs) {
            int idx = Integer.parseInt(log.substring(0, log.indexOf(':')));
            String type = log.substring(log.indexOf(':') + 1, log.lastIndexOf(':'));
            int timestamp = Integer.parseInt(log.substring(log.lastIndexOf(':') + 1));
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] += timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp;
                }
                stack.push(new int[]{idx, timestamp});
            } else {
                int[] t = stack.pop();
                res[t[0]] += timestamp - t[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return res;
    }
}
