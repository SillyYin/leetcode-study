import java.util.*;

/**
 * @author Yin
 * @date 2020/11/15
 */
public class Solution721 {
    class DSU {
        int[] parent;
        public DSU() {
            parent = new int[10001];
            for (int i = 0; i < parent.length; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToIndex = new HashMap<>();
        int index = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if ("".equals(name)) {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, index++);
                }
                dsu.union(emailToIndex.get(account.get(1)), emailToIndex.get(email));
            }
        }

        Map<Integer, List<String>> ans = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int idx = dsu.find(emailToIndex.get(email));
            ans.computeIfAbsent(idx, x -> new ArrayList<>()).add(email);
        }
        for (List<String> component : ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList<>(ans.values());
    }
}
