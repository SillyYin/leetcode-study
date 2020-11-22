/**
 * @author Yin
 * @date 2020/11/15
 */
public class Solution547 {
    class DSU {
        int[] p;
        public DSU() {
            p = new int[201];
            for (int i = 0; i < p.length; ++i) {
                p[i] = i;
            }
        }

        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public void union(int x, int y) {
            p[find(x)] = find(y);
        }
    }
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        DSU dsu = new DSU();

        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M[0].length; ++j) {
                if (i != j && M[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < M.length; ++i) {
            if (i == dsu.find(i)) {
                ans++;
            }
        }
        return ans;
    }
}
