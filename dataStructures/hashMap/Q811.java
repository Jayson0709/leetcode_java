package dataStructures.hashMap;

import utils.DataConversionMethods;
import utils.InputMethods;

import java.nio.charset.StandardCharsets;
import java.util.*;


//A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
//
//    A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.
//
//    For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
//    Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input. You may return the answer in any order.
//    
//    Example 1:
//    Input: cpdomains = ["9001 discuss.leetcode.com"]
//    Output: ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
//    Explanation: We only have one website domain: "discuss.leetcode.com".
//    As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
//    
//    Example 2:
//    Input: cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
//    Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
//    Explanation: We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times.
//    For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
//
//    Constraints:
//    1 <= cpdomain.length <= 100
//    1 <= cpdomain[i].length <= 100
//    cpdomain[i] follows either the "rep_i d1i.d2i.d3i" format or the "rep_i d1i.d2i" format.
//    rep_i is an integer in the range [1, 10^4].
//    d1i, d2i, and d3i consist of lowercase English letters.



//网站域名 "discuss.leetcode.com" 由多个子域名组成。顶级域名为 "com" ，二级域名为 "leetcode.com" ，最低一级为 "discuss.leetcode.com" 。当访问域名 "discuss.leetcode.com" 时，同时也会隐式访问其父域名 "leetcode.com" 以及 "com" 。
//
//    计数配对域名 是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示，其中 rep 表示访问域名的次数，d1.d2.d3 为域名本身。
//
//    例如，"9001 discuss.leetcode.com" 就是一个 计数配对域名 ，表示 discuss.leetcode.com 被访问了 9001 次。
//    给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的 计数配对域名 ，并以数组形式返回。可以按 任意顺序 返回答案。
//
//    示例 1：
//    输入：cpdomains = ["9001 discuss.leetcode.com"]
//    输出：["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
//    解释：例子中仅包含一个网站域名："discuss.leetcode.com"。
//    按照前文描述，子域名 "leetcode.com" 和 "com" 都会被访问，所以它们都被访问了 9001 次。
//
//    示例 2：
//    输入：cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
//    输出：["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
//    解释：按照前文描述，会访问 "google.mail.com" 900 次，"yahoo.com" 50 次，"intel.mail.com" 1 次，"wiki.org" 5 次。
//    而对于父域名，会访问 "mail.com" 900 + 1 = 901 次，"com" 900 + 50 + 1 = 951 次，和 "org" 5 次。
//
//    提示：
//    1 <= cpdomain.length <= 100
//    1 <= cpdomain[i].length <= 100
//    cpdomain[i] 会遵循 "rep_i d1i.d2i.d3i" 或 "rep_i d1i.d2i" 格式
//    rep_i 是范围 [1, 10^4] 内的一个整数
//    d1i、d2i 和 d3i 由小写英文字母组成



public class Q811 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        List<String> data = new ArrayList<>();
        InputMethods.getInputForStringArrayList(cin, data);
        cin.close();
        System.out.println(subdomainVisits(DataConversionMethods.convertStringArrayListTo1DArray(data)));
    }

    private static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> hMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int spaceIdx = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0, spaceIdx));
            String domain = cpdomain.substring(spaceIdx + 1);
            hMap.put(domain, hMap.getOrDefault(domain, 0) + count);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    hMap.put(subdomain, hMap.getOrDefault(subdomain, 0) + count);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hMap.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}
