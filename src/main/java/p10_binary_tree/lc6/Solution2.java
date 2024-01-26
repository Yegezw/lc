package p10_binary_tree.lc6;

import help.tree.TreeNode;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">235. 二叉搜索树的最近公共祖先</a>
     */
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;

        // p 和 q 位于 node 同侧
        if (p.val < node.val && q.val < node.val) return lowestCommonAncestor(node.left, p, q);
        if (p.val > node.val && q.val > node.val) return lowestCommonAncestor(node.right, p, q);

        // p 和 q 位于 node 异侧 || node == p || node == q
        return node;
    }
}
