package p10_binary_tree.lc7;

import help.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
public class Solution5 {

    /**
     * <a href="https://leetcode.cn/problems/maximum-width-of-binary-tree/description/">662. 二叉树最大宽度</a>
     */
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            int l = -1;
            int r = -1;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (i == 0) l = cur.val;
                if (i == size - 1) r = cur.val;

                if (cur.left != null) {
                    cur.left.val = cur.val * 2;
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur.val * 2 + 1;
                    queue.add(cur.right);
                }
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/">958. 二叉树的完全性检验</a>
     */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur == null) break;

            // 无脑入队
            queue.add(cur.left);
            queue.add(cur.right);
        }

        while (!queue.isEmpty()) {
            if (queue.remove() != null) return false;
        }

        return true;
    }

    /**
     * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/">111. 二叉树的最小深度</a>
     */
    public int minDepth(TreeNode node) {
        if (node == null) return 0;

        int left = minDepth(node.left);
        int right = minDepth(node.right);

        if (left != 0 && right != 0) return Math.min(left, right) + 1;
        return left + right + 1;
    }
}
