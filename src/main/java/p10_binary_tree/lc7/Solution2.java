package p10_binary_tree.lc7;

import help.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/symmetric-tree/description/">101. 对称二叉树</a>
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;

        return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();

            if (left == null && right == null) continue; // 注意
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }

    /**
     * <a href="https://leetcode.cn/problems/balanced-binary-tree/description/">110. 平衡二叉树</a>
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        getHeight(root);
        return res;
    }

    private boolean res = true;

    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        if (Math.abs(left - right) > 1) res = false;
        return Math.max(left, right) + 1;
    }

    /**
     * <a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/">129. 求根节点到叶节点数字之和</a>
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    //   2
    //  /
    // 3
    public int dfs(TreeNode node, int sum) {
        if (node == null) return 0; // 注意

        int cur = sum * 10 + node.val;
        if (node.left == null && node.right == null) return cur;

        return dfs(node.left, cur) + dfs(node.right, cur);
    }
}
