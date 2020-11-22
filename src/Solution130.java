import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yin
 * @date 2020/11/10
 */
public class Solution130 {
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private int rows;
    private int columns;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        rows = board.length;
        columns = board[0].length;

        for (int i = 0; i < columns; ++i) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if (board[rows - 1][i] == 'O') {
                dfs(rows - 1, i, board);
            }
        }

        for (int i = 0; i < rows; ++i) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if (board[i][columns - 1] == 'O') {
                dfs(i, columns - 1, board);
            }
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(int row, int column, char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, column});
        board[row][column] = '#';
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];
            for (int i = 0; i < 4; ++i) {
                int tempX = x + DX[i];
                int tempY = y + DY[i];
                if (tempX >= 0 && tempX < rows && tempY >= 0 && tempY < columns && board[tempX][tempY] == 'O') {
                    board[tempX][tempY] = '#';
                    queue.add(new int[]{tempX, tempY});
                }
            }
        }
    }

    private void dfs(int row, int column, char[][] board) {
        board[row][column] = '#';
        for (int i = 0; i < 4; ++i) {
            int x = row + DX[i];
            int y = column + DY[i];
            if (x >= 0 && x < rows && y >= 0 && y < columns && board[x][y] == 'O') {
                dfs(x, y, board);
            }
        }
    }
}
