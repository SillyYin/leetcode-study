import util.TreeNode;

import java.util.LinkedList;

/**
 * @author Yin
 * @date 2020/10/29
 */
public class Solution988 {
    public String minString = "####";
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<Integer> res = new LinkedList<>();
        res.add(root.val);
        backtrack(root, res);
        return minString;
    }

    private void backtrack(TreeNode root, LinkedList<Integer> res) {
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            res.forEach(e -> {
                sb.append((char)(e + 'a'));
            });
            // 注意sb一旦进行反转，其本身的内容就是反转后的内容
            String content = sb.reverse().toString();
            if ("####".equals(minString)) {
                minString = content;
            }
            minString = minString.compareTo(sb.toString()) < 0 ? minString:content;
            return;
        }

        if (root.left != null) {
            res.add(root.left.val);
            backtrack(root.left, res);
            res.removeLast();
        }

        if (root.right != null) {
            res.add(root.right.val);
            backtrack(root.right, res);
            res.removeLast();
        }
    }
}
