package dataStructures.linkedList;
import java.util.*;
import java.nio.charset.StandardCharsets;


//Design a Skiplist without using any built-in libraries.
//
//    A skiplist is a data structure that takes O(log(n)) time to add, erase and search. Comparing with Treap and red-black tree which has the same function and performance, the code length of Skiplist can be comparatively short and the idea behind Skiplists is just simple linked lists.
//
//    For example, we have a Skiplist containing [30,40,50,60,70,90] and we want to add 80 and 45 into it. The Skiplist works this way:
//
//    Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
//
//    You can see there are many layers in the Skiplist. Each layer is a sorted linked list. With the help of the top layers, add, erase and search can be faster than O(n). It can be proven that the average time complexity for each operation is O(log(n)) and space complexity is O(n).
//
//    See more about Skiplist: https://en.wikipedia.org/wiki/Skip_list
//
//    Implement the Skiplist class:
//
//    Skiplist() Initializes the object of the skiplist.
//        bool search(int target) Returns true if the integer target exists in the Skiplist or false otherwise.
//        void add(int num) Inserts the value num into the SkipList.
//        bool erase(int num) Removes the value num from the Skiplist and returns true. If num does not exist in the Skiplist, do nothing and return false. If there exist multiple num values, removing any one of them is fine.
//    Note that duplicates may exist in the Skiplist, your code needs to handle this situation.
//
//    Example 1:
//
//    Input
//    ["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
//    [[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
//    Output
//    [null, null, null, null, false, null, true, false, true, false]
//
//    Explanation
//    Skiplist skiplist = new Skiplist();
//    skiplist.add(1);
//    skiplist.add(2);
//    skiplist.add(3);
//    skiplist.search(0); // return False
//    skiplist.add(4);
//    skiplist.search(1); // return True
//    skiplist.erase(0);  // return False, 0 is not in skiplist.
//    skiplist.erase(1);  // return True
//    skiplist.search(1); // return False, 1 has already been erased.
//
//    Constraints:
//    0 <= num, target <= 2 * 10^4
//    At most 5 * 10^4 calls will be made to search, add, and erase.



//不使用任何库函数，设计一个 跳表 。
//
//    跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
//
//    例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：
//
//    (Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons)
//
//    跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
//
//    了解更多 :https://en.wikipedia.org/wiki/Skip_list
//
//    在本题中，你的设计应该要包含这些函数：
//        bool search(int target) : 返回target是否存在于跳表中。
//        void add(int num):插入一个元素到跳表。
//        bool erase(int num): 在跳表中删除一个值，如果num不存在，直接返回false. 如果存在多个num，删除其中任意一个即可。
//    注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
//
//
//    示例 1:
//
//    输入
//    ["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
//    [[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
//    输出
//    [null, null, null, null, false, null, true, false, true, false]
//
//    解释
//    Skiplist skiplist = new Skiplist();
//    skiplist.add(1);
//    skiplist.add(2);
//    skiplist.add(3);
//    skiplist.search(0);   // 返回 false
//    skiplist.add(4);
//    skiplist.search(1);   // 返回 true
//    skiplist.erase(0);    // 返回 false，0 不在跳表中
//    skiplist.erase(1);    // 返回 true
//    skiplist.search(1);   // 返回 false，1 已被擦除
//
//    提示:
//    0 <= num, target <= 2 * 10^4
//    调用search, add, erase操作次数不大于5 * 10^4



public class Q1206 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("Skiplist")) {
            Skiplist obj = new Skiplist();
            output.append(", null");
            for (int i = 1; i < orders.length; i++) {
                switch (orders[i]) {
                    case "add" -> {
                        int num = cin.nextInt();
                        obj.add(num);
                        output.append(", null");
                    }
                    case "search" -> {
                        int target = cin.nextInt();
                        output.append(", ").append(obj.search(target));
                    }
                    case "erase" -> {
                        int num = cin.nextInt();
                        output.append(", ").append(obj.erase(num));
                    }
                }
            }
        }
        output.append("]");
        System.out.println(output);
    }
}


class Skiplist {
    static final int MAX_LEVEL = 32;
    static final double P_FACTOR = 0.25;
    private final SkiplistNode head;
    private int level;
    private final Random random;

    public Skiplist() {
        this.head = new SkiplistNode(-1, MAX_LEVEL);
        this.level = 0;
        this.random = new Random();
    }

    public boolean search(int target) {
        SkiplistNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
            /* At level i, find the element that is less than and closest to target. */
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        /* check whether the current element is equal to target. */
        return curr != null && curr.val == target;
    }

    public void add(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        Arrays.fill(update, head);
        SkiplistNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
            /* At level i, find the element that is less than and closest to num. */
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        int lv = randomLevel();
        level = Math.max(level, lv);
        SkiplistNode newNode = new SkiplistNode(num, lv);
        for (int i = 0; i < lv; i++) {
            /* Update the state of level i, with the forward of the current element pointing to the new node */
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        SkiplistNode curr = this.head;
        for (int i = level - 1; i >= 0; i--) {
            /* At level i, find the element that is less than and closest to num. */
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        curr = curr.forward[0];
        /* If it does not exist, return false. */
        if (curr == null || curr.val != num) {
            return false;
        }
        for (int i = 0; i < level; i++) {
            if (update[i].forward[i] != curr) {
                break;
            }
            /* Update the state of level i, to point forward to the next hop of the deletes node. */
            update[i].forward[i] = curr.forward[i];
        }
        /* Update the current level */
        while (level > 1 && head.forward[level - 1] == null) {
            level--;
        }
        return true;
    }

    private int randomLevel() {
        int lv = 1;
        /* randomly generate level (lv) */
        while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
            lv++;
        }
        return lv;
    }
}

class SkiplistNode {
    int val;
    SkiplistNode[] forward;

    public SkiplistNode(int val, int maxLevel) {
        this.val = val;
        this.forward = new SkiplistNode[maxLevel];
    }
}
