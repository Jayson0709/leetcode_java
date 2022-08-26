package dataStructures.stack;
import java.util.*;
import java.nio.charset.StandardCharsets;
import sharedClasses.TreeNode;
import utils.*;


//You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
//
//    Create a root node whose value is the maximum value in nums.
//    Recursively build the left subtree on the subarray prefix to the left of the maximum value.
//    Recursively build the right subtree on the subarray suffix to the right of the maximum value.
//    Return the maximum binary tree built from nums.
//
//    Example 1:
//                  6
//                /   \
//               3     5
//                \    /
//                 2  0
//                  \
//                   1
//    Input: nums = [3,2,1,6,0,5]
//    Output: [6,3,5,null,2,0,null,null,1]
//    Explanation: The recursive calls are as follows:
//    - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
//    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
//    - Empty array, so no child.
//    - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
//    - Empty array, so no child.
//    - Only one element, so child is a node with value 1.
//    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
//    - Only one element, so child is a node with value 0.
//    - Empty array, so no child.
//
//    Example 2:
//         3
//          \
//           2
//            \
//             1
//    Input: nums = [3,2,1]
//    Output: [3,null,2,null,1]
//
//    Constraints:
//    1 <= nums.length <= 1000
//    0 <= nums[i] <= 1000
//    All integers in nums are unique.



//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
//
//    创建一个根节点，其值为 nums 中的最大值。
//    递归地在最大值 左边 的 子数组前缀上 构建左子树。
//    递归地在最大值 右边 的 子数组后缀上 构建右子树。
//    返回 nums 构建的 最大二叉树 。
//
//    示例 1：
//                  6
//                /   \
//               3     5
//                \    /
//                 2  0
//                  \
//                   1
//    输入：nums = [3,2,1,6,0,5]
//    输出：[6,3,5,null,2,0,null,null,1]
//    解释：递归调用如下所示：
//    - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//    - 空数组，无子节点。
//    - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//    - 空数组，无子节点。
//    - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//    - 只有一个元素，所以子节点是一个值为 0 的节点。
//    - 空数组，无子节点。
//
//    示例 2：
//         3
//          \
//           2
//            \
//             1
//    输入：nums = [3,2,1]
//    输出：[3,null,2,null,1]
//
//    提示：
//    1 <= nums.length <= 1000
//    0 <= nums[i] <= 1000
//    nums 中的所有整数 互不相同



public class Q654 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int[] nums = Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        cin.close();
        TreeNode resultNode = constructMaximumBinaryTree(nums);
        System.out.println(OutputMethods.formatLevelOrderTreeTraversalOutputData(resultNode));
    }

    // Method 1: Recursion
//    private static TreeNode constructMaximumBinaryTree(int[] nums) {
//        return construct(nums, 0, nums.length - 1);
//    }
//
//    public static TreeNode construct(int[] nums, int left, int right) {
//        if (left > right) {
//            return null;
//        }
//        int best = left;
//        for (int i = left + 1; i <= right; ++i) {
//            if (nums[i] > nums[best]) {
//                best = i;
//            }
//        }
//        TreeNode node = new TreeNode(nums[best]);
//        node.left = construct(nums, left, best - 1);
//        node.right = construct(nums, best + 1, right);
//        return node;
//    }

    // Method 2: use stack
    private static TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        TreeNode[] tree = new TreeNode[n];
        for (int i = 0; i < n; ++i) {
            tree[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        TreeNode root = null;
        for (int i = 0; i < n; ++i) {
            if (left[i] == -1 && right[i] == -1) {
                root = tree[i];
            } else if (right[i] == -1 || (left[i] != -1 && nums[left[i]] < nums[right[i]])) {
                tree[left[i]].right = tree[i];
            } else {
                tree[right[i]].left = tree[i];
            }
        }
        return root;
    }
}
