import java.util.*;

/**
 * 入度为0表示其所有的先修课都已经修完了
 * @author Yin
 * @date 2020/11/17
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 记录每个点的入度
        int[] inPoint = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int wantToLearn = pre[0];
            int needToLearn = pre[1];
            graph.get(needToLearn).add(wantToLearn);
            inPoint[wantToLearn]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // 统计入度为0的点
        int count = 0;
        for (int i = 0; i < numCourses; ++i) {
            if (inPoint[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            List<Integer> postCourse = graph.get(course);
            for (int i = 0; i < postCourse.size(); ++i) {
                inPoint[postCourse.get(i)]--;
                if (inPoint[postCourse.get(i)] == 0) {
                    queue.add(postCourse.get(i));
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
