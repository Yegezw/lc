package p10_binary_tree.lc1;

import help.tree.TreeNode;

/**
 * 二叉树纲领篇
 */
@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/">104. 二叉树的最大深度</a>
     */
    public int maxDepth1(TreeNode root) {
        order(root);
        return res;
    }

    int res = 0;   // 记录最大深度
    int depth = 0; // 记录遍历到的节点的深度

    private void order(TreeNode node) {
        if (node == null) return;

        depth++;
        if (node.left == null && node.right == null) res = Math.max(res, depth);

        order(node.left);
        order(node.right);

        depth--;
    }

    public int maxDepth2(TreeNode node) {
        if (node == null) return 0;

        int leftMaxDepth = maxDepth2(node.left);
        int rightMaxDepth = maxDepth2(node.right);

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    /**
     * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/description/">543. 二叉树的直径</a>
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDiameter = 0; // 记录最大直径的长度

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;

        int leftMaxDepth = maxDepth(node.left);
        int rightMaxDepth = maxDepth(node.left);
        maxDiameter = Math.max(maxDiameter, leftMaxDepth + rightMaxDepth);

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
