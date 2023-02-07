package algorithms.sorting;

import java.nio.charset.StandardCharsets;
import java.util.*;


//LeetCode company workers use key-cards to unlock office doors. Each time a worker uses their key-card, the security system saves the worker's name and the time when it was used. The system emits an alert if any worker uses the key-card three or more times in a one-hour period.
//
//    You are given a list of strings keyName and keyTime where [keyName[i], keyTime[i]] corresponds to a person's name and the time when their key-card was used in a single day.
//
//    Access times are given in the 24-hour time format "HH:MM", such as "23:51" and "09:49".
//
//    Return a list of unique worker names who received an alert for frequent key card use. Sort the names in ascending order alphabetically.
//
//    Notice that "10:00" - "11:00" is considered to be within a one-hour period, while "22:51" - "23:52" is not considered to be within a one-hour period.
//
//    Example 1:
//    Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
//    Output: ["daniel"]
//    Explanation: "daniel" used the key card 3 times in a one-hour period ("10:00","10:40", "11:00").
//
//    Example 2:
//    Input: keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
//    Output: ["bob"]
//    Explanation: "bob" used the key card 3 times in a one-hour period ("21:00","21:20", "21:30").
//
//    Constraints:
//    1 <= keyName.length, keyTime.length <= 10^5
//    keyName.length == keyTime.length
//    keyTime[i] is in the format "HH:MM".
//    [keyName[i], keyTime[i]] is unique.
//    1 <= keyName[i].length <= 10
//    keyName[i] contains only lowercase English letters.


//力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。
//
//    给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
//
//    使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
//
//    请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
//
//    请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
//
//    示例 1：
//    输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
//    输出：["daniel"]
//    解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
//
//    示例 2：
//    输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
//    输出：["bob"]
//    解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
//
//    示例 3：
//    输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
//    输出：[]
//
//    示例 4：
//    输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
//    输出：["clare","leslie"]
//
//    提示：
//    1 <= keyName.length, keyTime.length <= 10^5
//    keyName.length == keyTime.length
//    keyTime 格式为 "HH:MM" 。
//    保证 [keyName[i], keyTime[i]] 形成的二元对 互不相同 。
//    1 <= keyName[i].length <= 10
//    keyName[i] 只包含小写英文字母。


public class Q1604 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] keyName = cin.nextLine().strip().split(" ");
        String[] keyTime = cin.nextLine().strip().split(" ");
        cin.close();
        System.out.println(alertNames(keyName, keyTime));
    }

    private static List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            timeMap.putIfAbsent(name, new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<>();
        Set<String> keySet = timeMap.keySet();
        for (String name : keySet) {
            List<Integer> list = timeMap.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2), time2 = list.get(i);
                int difference = time2 - time1;
                if (difference <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
