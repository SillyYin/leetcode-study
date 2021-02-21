package acwing.problem1227;

import java.util.Scanner;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 分巧克力
 * @date 2021/2/21
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int m = Integer.parseInt(firstLine.split(" ")[1]);
        int[][] w = new int[n][2];
        for (int i = 0; i < n; ++i) {
            String line = in.nextLine();
            w[i][0] = Integer.parseInt(line.split(" ")[0]);
            w[i][1] = Integer.parseInt(line.split(" ")[1]);
        }
        int left = 1;
        int right = 100010;
        while (left < right) {
            // left更新为mid的时候，求mid的时候需要+1
            int mid = (left + right + 1) / 2;
            if (check(w, m, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    private static boolean check(int[][] w, int m, int mid) {
        int count = 0;
        for (int[] temp : w) {
            count += ((temp[0] / mid) * (temp[1] / mid));
        }
        return count >= m;
    }
}
