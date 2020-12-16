import java.util.*;

/**
 * @author Yin
 * @date 2020/12/5
 */
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Queue<TaskNode> heap = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        for (int item : count) {
            if (item == 0) {
                continue;
            }
            TaskNode node = new TaskNode((char) ('A' + item), item);
            heap.offer(node);
        }
        int res = 0;
        while (!heap.isEmpty()) {
            int interval = n + 1;
            List<TaskNode> next = new ArrayList<>();
            while (interval > 0 && !heap.isEmpty()) {
                TaskNode current = heap.poll();
                current.count--;
                next.add(current);
                interval--;
                res++;
            }
            for (TaskNode node : next) {
                if (node.count == 0) {
                    continue;
                }
                heap.offer(node);
            }
            if (heap.isEmpty()) {
                break;
            }
            res += interval;
        }
        return res;
    }

    class TaskNode {
        char task;
        int count;

        public TaskNode(char task, int count) {
            this.task = task;
            this.count = count;
        }
    }
}
