package dataStructures.stack;

import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;



//Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
//
//    The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) for which the stock price was less than or equal to today's price.
//
//    For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
//    Implement the StockSpanner class:
//
//    StockSpanner() Initializes the object of the class.
//    int next(int price) Returns the span of the stock's price given that today's price is price.
//    
//    Example 1:
//
//    Input
//    ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
//    [[], [100], [80], [60], [70], [60], [75], [85]]
//    Output
//    [null, 1, 1, 1, 2, 1, 4, 6]
//
//    Explanation
//    StockSpanner stockSpanner = new StockSpanner();
//    stockSpanner.next(100); // return 1
//    stockSpanner.next(80);  // return 1
//    stockSpanner.next(60);  // return 1
//    stockSpanner.next(70);  // return 2
//    stockSpanner.next(60);  // return 1
//    stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
//    stockSpanner.next(85);  // return 6
//
//    Constraints:
//    1 <= price <= 10^5
//    At most 10^4 calls will be made to next.




//编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
//
//    今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
//
//    例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
//
//    示例：
//    输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
//    输出：[null,1,1,1,2,1,4,6]
//    解释：
//    首先，初始化 S = StockSpanner()，然后：
//    S.next(100) 被调用并返回 1，
//    S.next(80) 被调用并返回 1，
//    S.next(60) 被调用并返回 1，
//    S.next(70) 被调用并返回 2，
//    S.next(60) 被调用并返回 1，
//    S.next(75) 被调用并返回 4，
//    S.next(85) 被调用并返回 6。
//
//    注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
//    (包括今天的价格 75) 小于或等于今天的价格。
//
//    提示：
//    调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。
//    每个测试用例最多可以调用  10000 次 StockSpanner.next。
//    在所有测试用例中，最多调用 150000 次 StockSpanner.next。
//    此问题的总时间限制减少了 50%。




public class Q901 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("StockSpanner")) {
            output.append("null");
            StockSpanner obj = new StockSpanner();
            for (int i = 1; i < orders.length; i++) {
                output.append(", ").append(obj.next(cin.nextInt()));
            }
        }
        cin.close();
        output.append("]");
        System.out.println(output);
    }
}


class StockSpanner {
    Deque<int[]> stack;
    int index;
    public StockSpanner() {
        stack = new LinkedList<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        index = -1;
    }

    public int next(int price) {
        index++;
        while (stack.peek() != null && price >= stack.peek()[1]) {
            stack.pop();
        }
        int res = -1;
        if (stack.peek() != null) {
            res = index - stack.peek()[0];
        }
        stack.push(new int[]{index, price});
        return res;
    }
}