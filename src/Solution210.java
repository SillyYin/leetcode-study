import java.util.*;

/**
 * @author Yin
 * @date 2020/11/17
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inPoint = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int count = 0;
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            inPoint[pre[0]]++;
        }
        for (int i = 0; i < numCourses; ++i) {
            if (inPoint[i] == 0) {
                queue.add(i);
                res[count] = i;
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            List<Integer> postCourses = graph.get(course);
            for (int postCourse : postCourses) {
                if (--inPoint[postCourse] == 0) {
                    queue.add(postCourse);
                    res[count++] = postCourse;
                }
            }
        }
        // 注意如果题目要求的是返回空数组，那么就新建一个长度为0的数组
        return count == numCourses ? res : new int[0];
    }
}
