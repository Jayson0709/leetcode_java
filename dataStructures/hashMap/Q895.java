package dataStructures.hashMap;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Q895 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("FreqStack")) {
            output.append("null");
            FreqStack obj = new FreqStack();
            for (int i = 1; i < orders.length; i++) {
                if (orders[i].equals("push")) {
                    obj.push(Integer.parseInt(cin.nextLine().strip()));
                    output.append(", null");
                } else if (orders[i].equals("pop")) {
                    output.append(", ").append(obj.pop());
                }
            }
        }
        output.append("]");
        cin.close();
        System.out.println(output);
    }
}

class FreqStack {
    private final Map<Integer, Integer> freq;
    private final Map<Integer, Deque<Integer>> group;
    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        group.putIfAbsent(freq.get(val), new ArrayDeque<>());
        group.get(freq.get(val)).push(val);
        maxFreq = Math.max(maxFreq, freq.get(val));
    }

    public int pop() {
        Deque<Integer> curStack = group.get(maxFreq);
        int val = -1;
        if (curStack.peek() != null) {
            val = curStack.peek();
        }
        freq.put(val, freq.get(val) - 1);
        group.get(maxFreq).pop();
        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        return val;
    }
}