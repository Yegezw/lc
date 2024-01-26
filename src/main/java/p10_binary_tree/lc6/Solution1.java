package p10_binary_tree.lc6;

import help.tree.TreeNode;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/">236. 二叉树的最近公共祖先</a>
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    private TreeNode find(TreeNode node, int val1, int val2) {
        if (node == null) return null;

        if (node.val == val1 || node.val == val2) return node;

        TreeNode left = find(node.left, val1, val2);
        TreeNode right = find(node.right, val1, val2);

        if (left != null && right != null) return node;
        return left != null ? left : right;
    }
}
