package interview;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



//The Game of Master Mind is played as follows:
//
//    The computer has four slots, and each slot will contain a ball that is red (R). yellow (Y). green (G) or blue (B). For example, the computer might have RGGB (Slot #1 is red, Slots #2 and #3 are green, Slot #4 is blue).
//
//    You, the user, are trying to guess the solution. You might, for example, guess YRGB.
//
//    When you guess the correct color for the correct slot, you get a "hit:' If you guess a color that exists but is in the wrong slot, you get a "pseudo-hit:' Note that a slot that is a hit can never count as a pseudo-hit.
//
//    For example, if the actual solution is RGBY and you guess GGRR, you have one hit and one pseudo-hit. Write a method that, given a guess and a solution, returns the number of hits and pseudo-hits.
//
//    Given a sequence of colors solution, and a guess, write a method that return the number of hits and pseudo-hit answer, where answer[0] is the number of hits and answer[1] is the number of pseudo-hit.
//
//    Example:
//    Input:  solution="RGBY",guess="GGRR"
//    Output:  [1,1]
//    Explanation:  hit once, pseudo-hit once.
//
//    Note:
//    len(solution) = len(guess) = 4
//    There are only "R","G","B","Y" in solution and guess.


//珠玑妙算游戏（the game of master mind）的玩法如下。
//
//    计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
//
//    给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
//
//    示例：
//    输入： solution="RGBY",guess="GGRR"
//    输出： [1,1]
//    解释： 猜中1次，伪猜中1次。
//
//    提示：
//    len(solution) = len(guess) = 4
//    solution和guess仅包含"R","G","B","Y"这4种字符


public class MasterMind {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String solution = cin.nextLine().strip();
        String guess = cin.nextLine().strip();
        cin.close();
        System.out.println(Arrays.toString(masterMind(solution, guess)));
    }

    private static int[] masterMind(String solution, String guess) {
        int[] ans = new int[2];
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < 4;i++){
            if(solution.charAt(i) == guess.charAt(i)) {
                ans[0]++;
            }
            else{
                char c1 = solution.charAt(i);
                char c2 = guess.charAt(i);
                int val = map.getOrDefault(c1,0);
                int val1 = map.getOrDefault(c2,0);
                if(val < 0){
                    ans[1]++;
                }
                map.put(c1,val + 1);
                if(val1 > 0){
                    ans[1]++;
                }
                map.put(c2,val1 - 1);
            }
        }
        return ans;
    }
}
