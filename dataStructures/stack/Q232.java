package dataStructures.stack;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
//
//    Implement the MyQueue class:
//
//    void push(int x) Pushes element x to the back of the queue.
//    int pop() Removes the element from the front of the queue and returns it.
//    int peek() Returns the element at the front of the queue.
//    boolean empty() Returns true if the queue is empty, false otherwise.
//    Notes:
//
//    You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
//    Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
//
//    Example 1:
//
//    Input
//    ["MyQueue", "push", "push", "peek", "pop", "empty"]
//    [[], [1], [2], [], [], []]
//    Output
//    [null, null, null, 1, 1, false]
//
//    Explanation
//    MyQueue myQueue = new MyQueue();
//    myQueue.push(1); // queue is: [1]
//    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//    myQueue.peek(); // return 1
//    myQueue.pop(); // return 1, queue is [2]
//    myQueue.empty(); // return false
//
//    Constraints:
//    1 <= x <= 9
//    At most 100 calls will be made to push, pop, peek, and empty.
//    All the calls to pop and peek are valid.
//
//    Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.


//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
//
//    实现 MyQueue 类：
//
//    void push(int x) 将元素 x 推到队列的末尾
//    int pop() 从队列的开头移除并返回元素
//    int peek() 返回队列开头的元素
//    boolean empty() 如果队列为空，返回 true ；否则，返回 false
//    说明：
//
//    你 只能 使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
//    你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
//
//    示例 1：
//
//    输入：
//    ["MyQueue", "push", "push", "peek", "pop", "empty"]
//    [[], [1], [2], [], [], []]
//    输出：
//    [null, null, null, 1, 1, false]
//
//    解释：
//    MyQueue myQueue = new MyQueue();
//    myQueue.push(1); // queue is: [1]
//    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//    myQueue.peek(); // return 1
//    myQueue.pop(); // return 1, queue is [2]
//    myQueue.empty(); // return false
//
//    提示：
//    1 <= x <= 9
//    最多调用 100 次 push、pop、peek 和 empty
//    假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
//
//    进阶：
//    你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。


public class Q232 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String[] orders = cin.nextLine().strip().split(" ");
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        MyQueue obj = new MyQueue();
        System.out.print("[null");
        int j = 0;
        for (int i = 1; i < orders.length; i++) {
            String order = orders[i];
            switch (order) {
                case "push" -> {
                    obj.push(data[j]);
                    j++;
                    System.out.print(", null");
                }
                case "peek" -> System.out.print(", " + obj.peek());
                case "pop" -> System.out.print(", " + obj.pop());
                case "empty" -> System.out.print(", " + obj.empty());
            }
        }
        System.out.print("]");
    }

}

class MyQueue {
    Stack<Integer> inStack, outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.empty();
    }

    private void inToOut() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
