package dataStructures.stack;

import utils.InputMethods;
import utils.TwoOneDIntArray;

import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


//Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
//
//    Example 1:
//    Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//    Output: true
//    Explanation: We might do the following sequence:
//    push(1), push(2), push(3), push(4),
//    pop() -> 4,
//    push(5),
//    pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
//
//    Example 2:
//    Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//    Output: false
//    Explanation: 1 cannot be popped before 2.
//
//    Constraints:
//    1 <= pushed.length <= 1000
//    0 <= pushed[i] <= 1000
//    All the elements of pushed are unique.
//    popped.length == pushed.length
//    popped is a permutation of pushed.



//给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
//
//    示例 1：
//    输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//    输出：true
//    解释：我们可以按以下顺序执行：
//    push(1), push(2), push(3), push(4), pop() -> 4,
//    push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
//
//    示例 2：
//    输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//    输出：false
//    解释：1 不能在 2 之前弹出。
//
//    提示：
//    1 <= pushed.length <= 1000
//    0 <= pushed[i] <= 1000
//    pushed 的所有元素 互不相同
//    popped.length == pushed.length
//    popped 是 pushed 的一个排列


public class Q946 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArray obj = InputMethods.getInputForTwoInt1DArray(cin);
        cin.close();
        System.out.println(validateStackSequences(obj.array1, obj.array2));
    }

    private static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
