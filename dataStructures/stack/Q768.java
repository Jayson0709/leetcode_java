package dataStructures.stack;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given an integer array arr.
//
//    We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
//
//    Return the largest number of chunks we can make to sort the array.
//
//    Example 1:
//    Input: arr = [5,4,3,2,1]
//    Output: 1
//    Explanation:
//    Splitting into two or more chunks will not return the required result.
//    For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
//
//    Example 2:
//    Input: arr = [2,1,3,4,4]
//    Output: 4
//    Explanation:
//    We can split into two chunks, such as [2, 1], [3, 4, 4].
//    However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
//
//    Constraints:
//    1 <= arr.length <= 2000
//    0 <= arr[i] <= 10^8



//这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10^8。
//
//    arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
//
//    我们最多能将数组分成多少块？
//
//    示例 1:
//    输入: arr = [5,4,3,2,1]
//    输出: 1
//    解释:
//    将数组分成2块或者更多块，都无法得到所需的结果。
//    例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。
//
//    示例 2:
//    输入: arr = [2,1,3,4,4]
//    输出: 4
//    解释:
//    我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。
//    然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。
//
//    注意:
//    arr的长度在[1, 2000]之间。
//    arr[i]的大小在[0, 10^8]之间。



public class Q768 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] arr = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        System.out.println(maxChunksToSorted(arr));
    }

    private static int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                int max = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
    }
}
