package acwing.problem898;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yin
 * @date 2021/1/24
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 总行数
        int n = Integer.parseInt(scanner.next());
        int[][] numbers = new int[n + 1][n + 1];

        for (int[] number : numbers) {
            Arrays.fill(number, Integer.MIN_VALUE);
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                numbers[i][j] = scanner.nextInt();
            }
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                int last = numbers[i - 1][j];
                if (j - 1 >= 0) {
                    last = Math.max(last, numbers[i - 1][j - 1]);
                }
                if (last != Integer.MIN_VALUE) {
                    numbers[i][j] += last;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int number : numbers[n]) {
            max = Math.max(max, number);
        }
        System.out.println(max);
    }
}
