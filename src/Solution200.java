import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yin
 * @date 2020/11/15
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int ans = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '#';
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        int x = point[0];
                        int y = point[1];
                        for (int k = 0; k < 4; ++k) {
                            int tempX = x + dx[k];
                            int tempY = y + dy[k];
                            if (tempX >= 0 && tempX < rows && tempY >= 0 && tempY < columns && grid[tempX][tempY] == '1') {
                                queue.add(new int[]{tempX, tempY});
                                grid[tempX][tempY] = '#';
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Solution200 solution200 = new Solution200();
        System.out.println(solution200.numIslands(grid));
    }
}
