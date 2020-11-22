import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yin
 * @date 2020/11/15
 */
public class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        dfs(root1, res1);
        dfs(root2, res2);
        if (res1.size() != res2.size()) {
            return false;
        }
        for (int i = 0; i < res1.size(); ++i) {
            if (!res1.get(i).equals(res2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                res.add(root.val);
            }

            dfs(root.left, res);
            dfs(root.right, res);
        }
    }
}
