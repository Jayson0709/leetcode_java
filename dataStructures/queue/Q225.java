package dataStructures.queue;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
//
//    Implement the MyStack class:
//
//    void push(int x) Pushes element x to the top of the stack.
//    int pop() Removes the element on the top of the stack and returns it.
//    int top() Returns the element on the top of the stack.
//    boolean empty() Returns true if the stack is empty, false otherwise.
//    Notes:
//
//    You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
//    Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
//
//    Example 1:
//
//    Input
//    ["MyStack", "push", "push", "top", "pop", "empty"]
//    [[], [1], [2], [], [], []]
//    Output
//    [null, null, null, 2, 2, false]
//
//    Explanation
//    MyStack myStack = new MyStack();
//    myStack.push(1);
//    myStack.push(2);
//    myStack.top(); // return 2
//    myStack.pop(); // return 2
//    myStack.empty(); // return False
//
//    Constraints:
//    1 <= x <= 9
//    At most 100 calls will be made to push, pop, top, and empty.
//    All the calls to pop and top are valid.
//    
//    Follow-up: Can you implement the stack using only one queue?


//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
//
//    实现 MyStack 类：
//
//    void push(int x) 将元素 x 压入栈顶。
//    int pop() 移除并返回栈顶元素。
//    int top() 返回栈顶元素。
//    boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
//    
//
//    注意：
//
//    你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
//    你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
//
//    示例：
//    输入：
//    ["MyStack", "push", "push", "top", "pop", "empty"]
//    [[], [1], [2], [], [], []]
//    输出：
//    [null, null, null, 2, 2, false]
//
//    解释：
//    MyStack myStack = new MyStack();
//    myStack.push(1);
//    myStack.push(2);
//    myStack.top(); // 返回 2
//    myStack.pop(); // 返回 2
//    myStack.empty(); // 返回 False
//
//    提示：
//    1 <= x <= 9
//    最多调用100 次 push、pop、top 和 empty
//    每次调用 pop 和 top 都保证栈不为空
//
//    进阶：你能否仅用一个队列来实现栈。


public class Q225 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        int[] data = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        MyStack obj = new MyStack();
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
                case "top" -> System.out.print(", " + obj.top());
                case "pop" -> System.out.print(", " + obj.pop());
                case "empty" -> System.out.print(", " + obj.empty());
            }
        }
        System.out.print("]");
    }
}

// Use one queue to implement the a stack.
class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        return -1;
    }

    public int top() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
