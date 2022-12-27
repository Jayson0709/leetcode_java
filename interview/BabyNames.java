package interview;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//Each year, the government releases a list of the 10000 most common baby names and their frequencies (the number of babies with that name).
//    The only problem with this is that some names have multiple spellings. For example,"John" and ''Jon" are essentially the same name but would be listed separately in the list." +
//    " Given two lists, one of names/frequencies and the other of pairs of equivalent names, write an algorithm to print a new list of the true frequency of each name." +
//    " Note that if John and Jon are synonyms, and Jon and Johnny are synonyms, then John and Johnny are synonyms. (It is both transitive and symmetric.)" +
//    " In the final list, choose the name that are lexicographically smallest as the "real" name.
//
//    Example:
//    Input: names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
//    Output: ["John(27)","Chris(36)"]
//
//    Note:
//    names.length <= 100000


//每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，
//    一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
//
//    在结果列表中，选择 字典序最小 的名字作为真实名字。
//
//    示例：
//    输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
//    输出：["John(27)","Chris(36)"]
//
//    提示：
//    names.length <= 100000

public class BabyNames {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] names = cin.nextLine().strip().split(" ");
        String[] synonyms = cin.nextLine().strip().split(" ");
        cin.close();
        System.out.println(Arrays.toString(trulyMostPopular(names, synonyms)));
    }

    private static String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> unionMap = new HashMap<>();
        for (String name : names) {
            int idx1 = name.indexOf('(');
            int idx2 = name.indexOf(')');
            int frequency = Integer.parseInt(name.substring(idx1 + 1, idx2));
            map.put(name.substring(0, idx1), frequency);
        }
        for (String pair : synonyms) {
            int idx = pair.indexOf(',');
            String name1 = pair.substring(1, idx);
            String name2 = pair.substring(idx + 1, pair.length() - 1);
            while (unionMap.containsKey(name1)) {
                name1 = unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)) {
                name2 = unionMap.get(name2);
            }
            if(!name1.equals(name2)){
                int frequency = map.getOrDefault(name1, 0) + map.getOrDefault(name2, 0);
                String trulyName = name1.compareTo(name2) < 0 ? name1 : name2;
                String nickName = name1.compareTo(name2) < 0 ? name2 : name1;
                unionMap.put(nickName, trulyName);
                map.remove(nickName);
                map.put(trulyName, frequency);
            }
        }
        String[] res = new String[map.size()];
        int index = 0;
        for (String name : map.keySet()) {
            String sb = name + '(' +
                map.get(name) +
                ')';
            res[index++] = sb;
        }
        return res;
    }
}
