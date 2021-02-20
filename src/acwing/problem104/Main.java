package acwing.problem104;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 货仓选址问题
 * 排序之后，选择中位数的位置就可以得到总和最小的情况
 * @author Yin
 * @date 2021/1/30
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] locations = new int[n];
        for (int i = 0; i < n; ++i) {
            locations[i] = in.nextInt();
        }
        Arrays.sort(locations);
        int res = 0;
        for (int location : locations) {
            res += Math.abs(location - locations[n / 2]);
        }
        System.out.println(res);
    }
}
