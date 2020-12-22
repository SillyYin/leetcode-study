import util.TreeNode;

import java.util.*;

/**
 * @author Yin
 * @date 2020/12/22
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < queueSize; ++i) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (level % 2 != 0) {
                Collections.reverse(ans);
            }
            res.add(new ArrayList<>(ans));
            level++;
        }
        return res;
    }
}
