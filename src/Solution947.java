import java.util.HashMap;
import java.util.Map;

/**
 * @author Yin
 * @date 2021/1/17
 */
public class Solution947 {
    class DSU {
        private Map<Integer, Integer> parent;
        private int count;

        public DSU() {
            parent = new HashMap<>();
            count = 0;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent.put(rootX, rootY);
            count--;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }

            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }

            return parent.get(x);
        }

        public int getCount() {
            return count;
        }
    }
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU();
        for (int[] stone : stones) {
            dsu.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - dsu.getCount();
    }
}
