package dataStructures.hashMap;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//There is an authentication system that works with authentication tokens. For each session, the user will receive a new authentication token that will expire timeToLive seconds after the currentTime. If the token is renewed, the expiry time will be extended to expire timeToLive seconds after the (potentially different) currentTime.
//
//    Implement the AuthenticationManager class:
//
//    AuthenticationManager(int timeToLive) constructs the AuthenticationManager and sets the timeToLive.
//    generate(string tokenId, int currentTime) generates a new token with the given tokenId at the given currentTime in seconds.
//    renew(string tokenId, int currentTime) renews the unexpired token with the given tokenId at the given currentTime in seconds. If there are no unexpired tokens with the given tokenId, the request is ignored, and nothing happens.
//    countUnexpiredTokens(int currentTime) returns the number of unexpired tokens at the given currentTime.
//    Note that if a token expires at time t, and another action happens on time t (renew or countUnexpiredTokens), the expiration takes place before the other actions.
//
//    Example 1:
//    Input
//    ["AuthenticationManager", "renew", "generate", "countUnexpiredTokens", "generate", "renew", "renew", "countUnexpiredTokens"]
//    [[5], ["aaa", 1], ["aaa", 2], [6], ["bbb", 7], ["aaa", 8], ["bbb", 10], [15]]
//    Output
//    [null, null, null, 1, null, null, null, 0]
//
//    Explanation
//    AuthenticationManager authenticationManager = new AuthenticationManager(5); // Constructs the AuthenticationManager with timeToLive = 5 seconds.
//    authenticationManager.renew("aaa", 1); // No token exists with tokenId "aaa" at time 1, so nothing happens.
//    authenticationManager.generate("aaa", 2); // Generates a new token with tokenId "aaa" at time 2.
//    authenticationManager.countUnexpiredTokens(6); // The token with tokenId "aaa" is the only unexpired one at time 6, so return 1.
//    authenticationManager.generate("bbb", 7); // Generates a new token with tokenId "bbb" at time 7.
//    authenticationManager.renew("aaa", 8); // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time 8 the renew request is ignored, and nothing happens.
//    authenticationManager.renew("bbb", 10); // The token with tokenId "bbb" is unexpired at time 10, so the renew request is fulfilled and now the token will expire at time 15.
//    authenticationManager.countUnexpiredTokens(15); // The token with tokenId "bbb" expires at time 15, and the token with tokenId "aaa" expired at time 7, so currently no token is unexpired, so return 0.
//
//    Constraints:
//    1 <= timeToLive <= 10^8
//    1 <= currentTime <= 10^8
//    1 <= tokenId.length <= 5
//    tokenId consists only of lowercase letters.
//    All calls to generate will contain unique values of tokenId.
//    The values of currentTime across all the function calls will be strictly increasing.
//    At most 2000 calls will be made to all functions combined.


//你需要设计一个包含验证码的验证系统。每一次验证中，用户会收到一个新的验证码，这个验证码在 currentTime 时刻之后 timeToLive 秒过期。如果验证码被更新了，那么它会在 currentTime （可能与之前的 currentTime 不同）时刻延长 timeToLive 秒。
//
//    请你实现 AuthenticationManager 类：
//
//    AuthenticationManager(int timeToLive) 构造 AuthenticationManager 并设置 timeToLive 参数。
//    generate(string tokenId, int currentTime) 给定 tokenId ，在当前时间 currentTime 生成一个新的验证码。
//    renew(string tokenId, int currentTime) 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻更新。如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
//    countUnexpiredTokens(int currentTime) 请返回在给定 currentTime 时刻，未过期 的验证码数目。
//    如果一个验证码在时刻 t 过期，且另一个操作恰好在时刻 t 发生（renew 或者 countUnexpiredTokens 操作），过期事件 优先于 其他操作。
//
//    示例 1：
//
//    输入：
//    ["AuthenticationManager", "renew", "generate", "countUnexpiredTokens", "generate", "renew", "renew", "countUnexpiredTokens"]
//    [[5], ["aaa", 1], ["aaa", 2], [6], ["bbb", 7], ["aaa", 8], ["bbb", 10], [15]]
//    输出：
//    [null, null, null, 1, null, null, null, 0]
//
//    解释：
//    AuthenticationManager authenticationManager = new AuthenticationManager(5); // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
//    authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
//    authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
//    authenticationManager.countUnexpiredTokens(6); // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
//    authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
//    authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
//    authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
//    authenticationManager.countUnexpiredTokens(15); // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
//
//    提示：
//    1 <= timeToLive <= 10^8
//    1 <= currentTime <= 10^8
//    1 <= tokenId.length <= 5
//    tokenId 只包含小写英文字母。
//    所有 generate 函数的调用都会包含独一无二的 tokenId 值。
//    所有函数调用中，currentTime 的值 严格递增 。
//    所有函数的调用次数总共不超过 2000 次。


public class Q1797 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] order = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (order[0].equals("AuthenticationManager")) {
            AuthenticationManager obj = new AuthenticationManager(Integer.parseInt(cin.nextLine().strip()));
            output.append("null");
            for (int i = 1; i < order.length; i++) {
                switch (order[i]) {
                    case "generate" -> {
                        String[] data = cin.nextLine().strip().split(" ");
                        obj.generate(data[0], Integer.parseInt(data[1]));
                        output.append(", null");
                    }
                    case "renew" -> {
                        String[] data = cin.nextLine().strip().split(" ");
                        obj.renew(data[0], Integer.parseInt(data[1]));
                        output.append(", null");
                    }
                    case "countUnexpectedTokens" ->
                        output.append(", ").append(obj.countUnexpiredTokens(Integer.parseInt(cin.nextLine().strip())));
                }
            }
        }
        cin.close();
        output.append("]");
        System.out.println(output);
    }
}

// Method 1: pure HashMap
//class AuthenticationManager {
//    int timeToLive;
//    Map<String, Integer> map;
//
//    public AuthenticationManager(int timeToLive) {
//        this.timeToLive = timeToLive;
//        this.map = new HashMap<>();
//    }
//
//    public void generate(String tokenId, int currentTime) {
//        map.put(tokenId, currentTime + timeToLive);
//    }
//
//    public void renew(String tokenId, int currentTime) {
//        if (map.getOrDefault(tokenId, 0) > currentTime) {
//            map.put(tokenId, currentTime + timeToLive);
//        }
//    }
//
//    public int countUnexpiredTokens(int currentTime) {
//        int res = 0;
//        for (int time : map.values()) {
//            if (time > currentTime) {
//                res++;
//            }
//        }
//        return res;
//    }
//}


// Method 2: HashMap + doubly linked-list
class AuthenticationManager {
    int timeToLive;
    Node head;
    Node tail;
    Map<String, Node> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        Node node = new Node(currentTime + timeToLive, tokenId);
        map.put(tokenId, node);
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        tail.prev = node;
        node.next = tail;
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId).expire > currentTime) {
            Node node = map.get(tokenId);
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.expire = currentTime + timeToLive;
            Node last = tail.prev;
            last.next = node;
            node.prev = last;
            tail.prev = node;
            node.next = tail;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        while (head.next.expire > 0 && head.next.expire <= currentTime) {
            Node node = head.next;
            map.remove(node.key);
            head.next = node.next;
            node.next.prev = head;
        }
        return map.size();
    }
}

class Node {
    int expire;
    String key;
    Node prev;
    Node next;

    public Node(int expire) {
        this(expire, null, null, null);
    }

    public Node(int expire, String key) {
        this(expire, key, null, null);
    }

    public Node(int expire, String key, Node prev, Node next) {
        this.expire = expire;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}