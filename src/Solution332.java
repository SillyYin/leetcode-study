import java.util.*;

/**
 * @author Yin
 * @date 2020/11/18
 */
public class Solution332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), e -> new PriorityQueue<>()).add(ticket.get(1));
        }
        List<String> path = new LinkedList<>();
        dfs(graph, path, "JFK");
        Collections.reverse(path);
        return path;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, List<String> path, String position) {
        while (graph.containsKey(position) && graph.get(position).size() > 0) {
            String temp = graph.get(position).poll();
            dfs(graph, path, temp);
        }
        // path中存储的回溯的时候的路径
        path.add(position);
    }


}
