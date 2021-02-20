package acwing.problem1113;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 红与黑
 * @date 2021/2/19
 */
public class Main {
    static int countRes(int startX, int startY, String[][] board, int m, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j].equals("@")) {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        while (!queue.isEmpty()) {
            int[] startPoint = queue.poll();
            int x = startPoint[0];
            int y = startPoint[1];
            res++;
            board[x][y] = "#";
            for (int i = 0; i < 4; ++i) {
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && ".".equals(board[a][b])) {
                    board[a][b] = "#";
                    queue.add(new int[]{a, b});
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String firstLine = in.nextLine();
            int m = Integer.parseInt(firstLine.split(" ")[0]);
            int n = Integer.parseInt(firstLine.split(" ")[1]);
            if (m == 0 && n == 0) {
                break;
            }
            String[][] board = new String[n][m];
            int startX = 0;
            int startY = 0;
            for (int i = 0; i < n; ++i) {
                String line = in.nextLine();
                board[i] = line.split("");
                for (int j = 0; j < m; ++j) {
                    if ("@".equals(board[i][j])) {
                        startX = i;
                        startY = j;
                    }
                }
            }
            System.out.println(countRes(startX, startY, board, m, n));
        }
    }
}
