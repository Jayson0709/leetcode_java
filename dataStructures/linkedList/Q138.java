package dataStructures.linkedList;
import java.util.*;
import java.nio.charset.StandardCharsets;

//A linked list of length n is given such that each node contains an additional random resultHeader, which could resultHead to any node in the list, or null.
//
//    Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random resultHeader of the new nodes should resultHead to new nodes in the copied list such that the resultHeaders in the original list and copied list represent the same list state. None of the resultHeaders in the new list should resultHead to nodes in the original list.
//
//    For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
//
//    Return the head of the copied linked list.
//
//    The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
//
//    val: an integer representing Node.val
//    random_index: the index of the node (range from 0 to n-1) that the random resultHeader resultHeads to, or null if it does not resultHead to any node.
//    Your code will only be given the head of the original linked list.
//
//    Example 1:
//    Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//    Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//    
//    Example 2:
//    Input: head = [[1,1],[2,1]]
//    Output: [[1,1],[2,1]]
//    
//    Example 3:
//    Input: head = [[3,null],[3,0],[3,null]]
//    Output: [[3,null],[3,0],[3,null]]
//
//    Constraints:
//    0 <= n <= 1000
//    -104 <= Node.val <= 104
//    Node.random is null or is resultHeading to some node in the linked list.


//给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
//
//    构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
//
//    例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
//
//    返回复制链表的头节点。
//
//    用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
//
//    val：一个表示Node.val的整数。
//    random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
//    你的代码 只 接受原链表的头节点 head 作为传入参数。
//
//    示例 1：
//    输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//    输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//    示例 2：
//    输入：head = [[1,1],[2,1]]
//    输出：[[1,1],[2,1]]
//
//    示例 3：
//    输入：head = [[3,null],[3,0],[3,null]]
//    输出：[[3,null],[3,0],[3,null]]
//
//    提示：
//    0 <= n <= 1000
//    -104<= Node.val <= 104
//    Node.random为null 或指向链表中的节点。

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Q138 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        List<String[]> data = new ArrayList<>();
        while (true) {
            String line = cin.nextLine().strip();
            if (line.length() == 0) {
                break;
            }
            data.add(line.split(" "));
        }
        cin.close();
        Node[] nodes = new Node[data.size()];
        Node head = new Node(Integer.parseInt(data.get(0)[0]));
        nodes[0] = head;
        Node p = head;
        for (int i = 1; i < data.size(); i++) {
            Node temp = new Node(Integer.parseInt(data.get(i)[0]));
            p.next = temp;
            p = temp;
            nodes[i] = p;
        }
        for (int i = 0; i < data.size(); i++) {
            String[] curData = data.get(i);
            if (!curData[1].equals("null")) {
                nodes[i].random = nodes[Integer.parseInt(curData[1])];
            }
        }

        // the output is not required by the question.
        // the random part will just be the node it points to.
        Node resultHead = copyRandomList(nodes[0]);
        System.out.print("Copied linked list (node, the random point node): [");
        while (resultHead != null) {
            System.out.print("[");
            if (resultHead.random != null) {
                System.out.print(resultHead.val + "," + resultHead.random.val);
            } else {
                System.out.print(resultHead.val + "," + "null");
            }
            System.out.print("]");
            resultHead = resultHead.next;
        }
        System.out.print("]");
        System.out.println();

        System.out.print("The original input (node, the random index): [");
        for (String[] nodeData : data) {
            System.out.print("[" + nodeData[0] + "," + nodeData[1] + "]");
        }
        System.out.print("]");
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> hMap = new HashMap<>();
        Node p = head;
        // Put the original nodes and the new nodes into the HashMap.
        while (p != null) {
            Node newNode = new Node(p.val);
            hMap.put(p, newNode);
            p = p.next;
        }
        p = head;
        // Iterate the original linked list, set the 'next' and 'random' for the new nodes.
        while (p != null) {
            Node newNode = hMap.get(p);
            if (p.next != null) {
                newNode.next = hMap.get(p.next);
            }
            if (p.random != null) {
                newNode.random = hMap.get(p.random);
            }
            p = p.next;
        }
        return hMap.get(head);
    }
}

