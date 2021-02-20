package acwing.problem756;

import java.util.Scanner;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 蛇形矩阵
 * @date 2021/2/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] numbers = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        // 表示方向，从右开始移动
        int d = 1;
        // 表示当前坐标
        int x = 0;
        int y = 0;
        for (int i = 1; i <= n * m; ++i) {
            numbers[x][y] = i;
            int a = x + dx[d];
            int b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= m || numbers[a][b] != 0) {
                // 换个方向移动
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        for (int[] number : numbers) {
            for (int res : number) {
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }
}
