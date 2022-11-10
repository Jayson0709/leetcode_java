package interview;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


//An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out" basis. People must adopt either the"oldest" (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in Linked list data structure.
//
//    enqueue method has a animal parameter, animal[0] represents the number of the animal, animal[1] represents the type of the animal, 0 for cat and 1 for dog.
//
//    dequeue* method returns [animal number, animal type], if there's no animal that can be adopted, return [-1, -1].
//
//    Example1:
//    Input:
//    ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
//    [[], [[0, 0]], [[1, 0]], [], [], []]
//    Output:
//    [null,null,null,[0,0],[-1,-1],[1,0]]
//
//    Example2:
//    Input:
//    ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
//    [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
//    Output:
//    [null,null,null,null,[2,1],[0,0],[1,0]]
//
//    Note:
//    The number of animals in the shelter will not exceed 20000.


//动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
//
//    enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
//
//    dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
//
//    示例1:
//    输入：
//    ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
//    [[], [[0, 0]], [[1, 0]], [], [], []]
//    输出：
//    [null,null,null,[0,0],[-1,-1],[1,0]]
//
//    示例2:
//    输入：
//    ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
//    [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
//    输出：
//    [null,null,null,null,[2,1],[0,0],[1,0]]
//
//    说明:
//    收纳所的最大容量为20000


public class AnimalShelter {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] orders = cin.nextLine().strip().split(" ");
        StringBuilder output = new StringBuilder();
        output.append("[");
        if (orders[0].equals("AnimalShelf")) {
            output.append("null");
            AnimalShelf obj = new AnimalShelf();
            for (int i = 1; i < orders.length; i++) {
                switch (orders[i]) {
                    case "enqueue" -> {
                        obj.enqueue(Arrays.stream(cin.nextLine().strip().split(" ")).mapToInt(Integer::parseInt).toArray());
                        output.append(", null");
                    }
                    case "dequeueAny" -> output.append(", ").append(Arrays.toString(obj.dequeueAny()));
                    case "dequeueCat" -> output.append(", ").append(Arrays.toString(obj.dequeueCat()));
                    case "dequeueDog" -> output.append(", ").append(Arrays.toString(obj.dequeueDog()));
                }
            }
        }
        output.append("]");
        System.out.println(output);
    }
}

class AnimalShelf {

    LinkedList<int[]> queueCat;
    LinkedList<int[]> queueDog;

    public AnimalShelf() {
        queueCat = new LinkedList<>();
        queueDog = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            queueCat.addLast(animal);
        } else if (animal[1] == 1) {
            queueDog.addLast(animal);
        }
    }

    public int[] dequeueAny() {
        int[] headCat;
        if (!queueCat.isEmpty()) {
            headCat = queueCat.getFirst();
        } else if (!queueDog.isEmpty()) {
            return queueDog.removeFirst();
        } else {
            return new int[]{-1,-1};
        }
        int[] headDog;
        if (!queueDog.isEmpty()) {
            headDog = queueDog.getFirst();
        } else {
            return queueCat.removeFirst();
        }
        if (headCat[0]<=headDog[0]) {
            return queueCat.removeFirst();
        } else {
            return queueDog.removeFirst();
        }
    }

    public int[] dequeueDog() {
        if (!queueDog.isEmpty()) {
            return queueDog.removeFirst();
        } else {
            return new int[]{-1,-1};
        }
    }

    public int[] dequeueCat() {
        if (!queueCat.isEmpty()) {
            return queueCat.removeFirst();
        } else {
            return new int[]{-1,-1};
        }
    }
}
