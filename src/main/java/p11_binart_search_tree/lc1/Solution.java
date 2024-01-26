package p11_binart_search_tree.lc1;

import help.tree.TreeNode;

/**
 * 二叉搜索树特性篇
 */
@SuppressWarnings("all")
public class Solution {

    /**
     * <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/">230. 二叉搜索树中第 K 小的元素</a>
     */
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    private int rank; // 当前遍历到 node 的排名
    private int res;  // 记录结果

    private void inOrder(TreeNode node, int k) {
        if (node == null) return;

        inOrder(node.left, k);

        rank++;
        if (rank == k) {
            res = node.val;
            return;
        }

        inOrder(node.right, k);
    }

    /**
     * <a href="https://leetcode.cn/problems/convert-bst-to-greater-tree/description/">538. 把二叉搜索树转换为累加树</a>
     */
    public TreeNode convertBST(TreeNode root) {
        order(root);
        return root;
    }

    private int sum = 0; // 累加和

    private void order(TreeNode node) {
        if (node == null) return;

        order(node.right);

        sum += node.val;
        node.val = sum;

        order(node.left);
    }
}
