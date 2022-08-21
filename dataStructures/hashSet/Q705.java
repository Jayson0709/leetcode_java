package dataStructures.hashSet;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.ListNode;


//Design a HashSet without using any built-in hash table libraries.
//
//    Implement MyHashSet class:
//        void add(key) Inserts the value key into the HashSet.
//        bool contains(key) Returns whether the value key exists in the HashSet or not.
//        void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
//
//    Example 1:
//
//    Input
//    ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
//    [[], [1], [2], [1], [3], [2], [2], [2], [2]]
//    Output
//    [null, null, null, true, false, null, true, null, false]
//
//    Explanation
//    MyHashSet myHashSet = new MyHashSet();
//    myHashSet.add(1);      // set = [1]
//    myHashSet.add(2);      // set = [1, 2]
//    myHashSet.contains(1); // return True
//    myHashSet.contains(3); // return False, (not found)
//    myHashSet.add(2);      // set = [1, 2]
//    myHashSet.contains(2); // return True
//    myHashSet.remove(2);   // set = [1]
//    myHashSet.contains(2); // return False, (already removed)
//
//    Constraints:
//    0 <= key <= 10^6
//    At most 10^4 calls will be made to add, remove, and contains.



//不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
//
//    实现 MyHashSet 类：
//        void add(key) 向哈希集合中插入值 key 。
//        bool contains(key) 返回哈希集合中是否存在这个值 key 。
//        void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
//
//    示例：
//
//    输入：
//    ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
//    [[], [1], [2], [1], [3], [2], [2], [2], [2]]
//    输出：
//    [null, null, null, true, false, null, true, null, false]
//
//    解释：
//    MyHashSet myHashSet = new MyHashSet();
//    myHashSet.add(1);      // set = [1]
//    myHashSet.add(2);      // set = [1, 2]
//    myHashSet.contains(1); // 返回 True
//    myHashSet.contains(3); // 返回 False ，（未找到）
//    myHashSet.add(2);      // set = [1, 2]
//    myHashSet.contains(2); // 返回 True
//    myHashSet.remove(2);   // set = [1]
//    myHashSet.contains(2); // 返回 False ，（已移除）
//
//    提示：
//    0 <= key <= 10^6
//    最多调用 10^4 次 add、remove 和 contains



public class Q705 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("MyHashSet")) {
            MyHashSet obj = new MyHashSet();
            output.append("null");
            for (int i = 1; i < orders.length; i++) {
                switch (orders[i]) {
                    case "add" -> {
                        output.append(", null");
                        obj.add(cin.nextInt());
                    }
                    case "remove" -> {
                        output.append(", null");
                        obj.remove(cin.nextInt());
                    }
                    case "contains" -> output.append(", ").append(obj.contains(cin.nextInt()));
                }
            }
        }
        cin.close();
        output.append("]");
        System.out.println(output);
    }
}

// Method 1: use Array
//class MyHashSet {
//    boolean[] hashSet;
//    public MyHashSet() {
//        hashSet = new boolean[1000009];
//    }
//
//    public void add(int key) {
//        hashSet[key] = true;
//    }
//
//    public void remove(int key) {
//        hashSet[key] = false;
//    }
//
//    public boolean contains(int key) {
//        return hashSet[key];
//    }
//}


// Method 2: use LinkedList
class MyHashSet {
    ListNode[] nodes;
    public MyHashSet() {
        nodes = new ListNode[10009];
    }

    public void add(int key) {
        int idx = getIndex(key);
        ListNode curNode = nodes[idx], temp = curNode;
        if (curNode != null) {
            ListNode prev = null;
            while (temp != null) {
                if (temp.val == key) {
                    return;
                }
                prev = temp;
                temp = temp.next;
            }
            temp = prev;
        }
        ListNode node = new ListNode(key);

        // Two ways of insertion: insert to the head and to the tail
        // node.next = curNode;
        // nodes[idx] = node;

        if (temp != null) {
            temp.next = node;
        } else {
            nodes[idx] = node;
        }
    }

    public void remove(int key) {
        int idx = getIndex(key);
        ListNode curNode = nodes[idx];
        if (curNode != null) {
            ListNode prev = null;
            while (curNode != null) {
                if (curNode.val == key) {
                    if (prev != null) {
                        prev.next = curNode.next;
                    } else {
                        nodes[idx] = curNode.next;
                    }
                    return;
                }
                prev = curNode;
                curNode = curNode.next;
            }
        }
    }

    public boolean contains(int key) {
        int idx = getIndex(key);
        ListNode curNode = nodes[idx];
        if (curNode != null) {
            while (curNode != null) {
                if (curNode.val == key) {
                    return true;
                }
                curNode = curNode.next;
            }
        }
        return false;
    }

    int getIndex(int key) {
        // Because the length of Nodes is only 10009, the corresponding decimal number is 10011100011001
        // (the total length is 32 bits, and the other high bits are 0).
        // The hashCode is processed to allow the hash high corresponding to the key to participate in the operation
        // This allows both the high and low randomness of hashCode to be represented in the low 16 bits
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % nodes.length;
    }
}
