package algorithms.dynamicProgramming;

import utils.InputMethods;
import utils.TwoOneDIntArray;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


//You are given two integer arrays of the same length nums1 and nums2. In one operation, you are allowed to swap nums1[i] with nums2[i].
//
//    For example, if nums1 = [1,2,3,8], and nums2 = [5,6,7,4], you can swap the element at i = 3 to obtain nums1 = [1,2,3,4] and nums2 = [5,6,7,8].
//    Return the minimum number of needed operations to make nums1 and nums2 strictly increasing. The test cases are generated so that the given input always makes it possible.
//
//    An array arr is strictly increasing if and only if arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1].
//    
//    Example 1:
//    Input: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
//    Output: 1
//    Explanation:
//    Swap nums1[3] and nums2[3]. Then the sequences are:
//    nums1 = [1, 3, 5, 7] and nums2 = [1, 2, 3, 4]
//    which are both strictly increasing.
//    
//    Example 2:
//    Input: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
//    Output: 1
//    
//    Constraints:
//    2 <= nums1.length <= 10^5
//    nums2.length == nums1.length
//    0 <= nums1[i], nums2[i] <= 2 * 10^5



//我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。
//
//    例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
//    返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。
//
//    数组 arr 严格递增 且  arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。
//
//    注意：
//    用例保证可以实现操作。
//
//    示例 1:
//    输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
//    输出: 1
//    解释:
//    交换 A[3] 和 B[3] 后，两个数组如下:
//    A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
//    两个数组均为严格递增的。
//
//    示例 2:
//    输入: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
//    输出: 1
//
//    提示:
//    2 <= nums1.length <= 10^5
//    nums2.length == nums1.length
//    0 <= nums1[i], nums2[i] <= 2 * 10^5


public class Q801 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        TwoOneDIntArray obj = InputMethods.getInputForTwoInt1DArray(cin);
        cin.close();
        System.out.println(minSwap(obj.array1, obj.array2));
    }

    private static int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int at = a, bt = b;
            a = n;
            b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1])  {
                a = Math.min(a, at);
                b = Math.min(b, bt + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, bt);
                b = Math.min(b, at + 1);
            }
        }
        return Math.min(a, b);
    }
}
