package dataStructures.stack;

import utils.InputMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


//We are given an array asteroids of integers representing asteroids in a row.
//
//    For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
//    Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
//
//    Example 1:
//    Input: asteroids = [5,10,-5]
//    Output: [5,10]
//    Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
//    
//    Example 2:
//    Input: asteroids = [8,-8]
//    Output: []
//    Explanation: The 8 and -8 collide exploding each other.
//    
//    Example 3:
//    Input: asteroids = [10,2,-5]
//    Output: [10]
//    Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
//
//    Constraints:
//    2 <= asteroids.length <= 10^4
//    -1000 <= asteroids[i] <= 1000
//    asteroids[i] != 0



//给定一个整数数组 asteroids，表示在同一行的行星。
//
//    对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
//
//    找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
//
//    示例 1：
//    输入：asteroids = [5,10,-5]
//    输出：[5,10]
//    解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
//
//    示例 2：
//    输入：asteroids = [8,-8]
//    输出：[]
//    解释：8 和 -8 碰撞后，两者都发生爆炸。
//
//    示例 3：
//    输入：asteroids = [10,2,-5]
//    输出：[10]
//    解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
//
//    提示：
//    2 <= asteroids.length<= 10^4
//    -1000 <= asteroids[i] <= 1000
//    asteroids[i] != 0


public class Q735 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(InputMethods.getInputForOneIntArray())));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> remaining = new ArrayList<>();
        boolean bothCrashed = false;
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                if (stack.isEmpty()) {
                    remaining.add(asteroid);
                } else {
                    while (!stack.isEmpty() && stack.peek() <= Math.abs(asteroid)) {
                        if (stack.peek() == Math.abs(asteroid)) {
                            stack.pop();
                            bothCrashed = true;
                            break;
                        }
                        stack.pop();
                    }
                    if (stack.isEmpty() && !bothCrashed) {
                        remaining.add(asteroid);
                    }
                    bothCrashed = false;
                }
            }
        }
        remaining.addAll(stack);
        int[] result = new int[remaining.size()];
        for (int i =0; i < result.length; i++) {
            result[i] = remaining.get(i);
        }
        return result;
    }
}
