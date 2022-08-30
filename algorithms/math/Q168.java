package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Q168 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        int columnNumber = cin.nextInt();
        cin.close();
        System.out.println(convertToTitle(columnNumber));
    }

    // Version 1
//    private static String convertToTitle(int columnNumber) {
//        StringBuilder sb = new StringBuilder();
//        while (columnNumber > 0) {
//            int a0 = (columnNumber - 1) % 26 + 1;
//            sb.append((char)(a0 - 1 + 'A'));
//            columnNumber = (columnNumber - a0) / 26;
//        }
//        return sb.reverse().toString();
//    }

    // Version 2
    private static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
