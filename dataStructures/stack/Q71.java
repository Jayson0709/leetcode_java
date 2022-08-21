package dataStructures.stack;
import java.util.*;
import java.nio.charset.StandardCharsets;

//Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
//
//    In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
//
//    The canonical path should have the following format:
//
//    The path starts with a single slash '/'.
//    Any two directories are separated by a single slash '/'.
//    The path does not end with a trailing '/'.
//    The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
//    Return the simplified canonical path.
//    
//    Example 1:
//    Input: path = "/home/"
//    Output: "/home"
//    Explanation: Note that there is no trailing slash after the last directory name.
//    
//    Example 2:
//    Input: path = "/../"
//    Output: "/"
//    Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
//    
//    Example 3:
//    Input: path = "/home//foo/"
//    Output: "/home/foo"
//    Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
//
//    Constraints:
//    1 <= path.length <= 3000
//    path consists of English letters, digits, period '.', slash '/' or '_'.
//    path is a valid absolute Unix path.


//给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
//
//    在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
//
//    请注意，返回的 规范路径 必须遵循下述格式：
//
//    始终以斜杠 '/' 开头。
//    两个目录名之间必须只有一个斜杠 '/' 。
//    最后一个目录名（如果存在）不能 以 '/' 结尾。
//    此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
//    返回简化后得到的 规范路径 。
//
//    示例 1：
//    输入：path = "/home/"
//    输出："/home"
//    解释：注意，最后一个目录名后面没有斜杠。
//
//    示例 2：
//    输入：path = "/../"
//    输出："/"
//    解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
//
//    示例 3：
//    输入：path = "/home//foo/"
//    输出："/home/foo"
//    解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
//
//    示例 4：
//    输入：path = "/a/./b/../../c/"
//    输出："/c"
//
//    提示：
//    1 <= path.length <= 3000
//    path 由英文字母，数字，'.'，'/' 或 '_' 组成。
//    path 是一个有效的 Unix 风格绝对路径。



public class Q71 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String path = cin.nextLine().strip();
        cin.close();

        String result = simplifyPath(path);
        System.out.println(result);
    }

    private static String simplifyPath(String path) {
        String[] items = path.split("/");
        int n = path.length();
        Deque<String> stack = new ArrayDeque<>();
        for (String item : items) {
            // 1: current item == "..", pop the top item of the stack, if there is one.
            // 2: current item == ".", ignore it and continue.
            // 3: current item == something valid, add to the stack.
            if (item.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (item.length() > 0 && !item.equals(".")) {
                stack.addLast(item);
            }
        }
        StringBuilder resultBuilder = new StringBuilder();
        if (stack.isEmpty()) {
            resultBuilder.append("/");
        } else {
            while (!stack.isEmpty()) {
                resultBuilder.append("/").append(stack.pollFirst());
            }
        }
        return resultBuilder.toString();
    }
}
