package algorithms.math;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Q171 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8);
        String columnTitle = cin.nextLine().strip();
        cin.close();
        System.out.println(titleToNumber(columnTitle));
    }

    private static int titleToNumber(String columnTitle) {
        int res = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            res += k * multiple;
            multiple *= 26;
        }
        return res;
    }
}
