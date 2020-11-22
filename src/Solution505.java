import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yin
 * @date 2020/11/10
 */
public class Solution505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return 0;
        }
        int rows = maze.length;
        int columns = maze[0].length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][] dist = new int[rows][columns];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        dist[start[0]][start[1]] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int x = top[0] + dx[i];
                int y = top[1] + dy[i];
                int count = 0;
                while (x >= 0 && x < rows && y >= 0 && y < columns && maze[x][y] == 0) {
                    x += dx[i];
                    y += dy[i];
                    count++;
                }
                x -= dx[i];
                y -= dy[i];
                if (dist[top[0]][top[1]] + count < dist[x][y]) {
                    dist[x][y] = dist[top[0]][top[1]] + count;
                    // 进行更新之后才需要将这个坐标点放在队列中
                    queue.add(new int[]{x, y});
                }
                if (x == destination[0] && y == destination[1]) {
                    break;
                }
            }
        }

        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }
}
