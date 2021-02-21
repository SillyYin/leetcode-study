package acwing.problem680;

import java.util.Scanner;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 剪绳子
 * @date 2021/2/21
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] lengths = new int[n];
        for (int i = 0; i < n; ++i) {
            lengths[i] = in.nextInt();
        }
        double left = 0;
        double right = 1e+9;
        // 题目要求结果是保留两位小数，所以精度保持在-4次方即可
        while (right - left > 1e-4) {
            double mid = (left + right) / 2;
            if (check(lengths, m, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.printf("%.2f", left);
    }

    /**
     * 当需要的绳子长度是mid的时候，计算出最多能切割多少条，然后看是否能达到m
     * @param lengths
     * @param m
     * @param mid
     * @return
     */
    private static boolean check(int[] lengths, int m, double mid) {
        int count = 0;
        for (int len : lengths) {
            count += len / mid;
        }
        return count >= m;
    }
}
