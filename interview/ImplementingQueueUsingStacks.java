package interview;


//Implement a MyQueue class which implements a queue using two stacks.
//
//    Example:
//    MyQueue queue = new MyQueue();
//    queue.push(1);
//    queue.push(2);
//    queue.peek();  // return 1
//    queue.pop();   // return 1
//    queue.empty(); // return false
//
//    Notes:
//    You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
//    Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
//    You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).


//实现一个MyQueue类，该类用两个栈来实现一个队列。
//
//    示例：
//    MyQueue queue = new MyQueue();
//    queue.push(1);
//    queue.push(2);
//    queue.peek();  // 返回 1
//    queue.pop();   // 返回 1
//    queue.empty(); // 返回 false
//
//    说明：
//    你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
//    你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
//    假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。


import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Stack;

public class ImplementingQueueUsingStacks {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        cin.close();
        if (orders.length == 0) {
            return;
        }
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("MyQueue")) {
            MyQueue obj = new MyQueue();
            output.append(", null");
            for (int i = 1; i < orders.length; i++) {
                switch (orders[i]) {
                    case "push" -> {
                        obj.push(Integer.parseInt(cin.nextLine()));
                        output.append(", null");
                    }
                    case "pop" -> output.append(", ").append(obj.pop());
                    case "peek" -> output.append(", ").append(obj.peek());
                    default -> output.append(", ").append(obj.empty());
                }
            }
        }
        output.append("]");
        System.out.println(output);
    }
}

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.empty()) {
            migrateData();
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.empty()) {
            migrateData();
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    private void migrateData() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }
}
