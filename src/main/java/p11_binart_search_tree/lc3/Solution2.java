package p11_binart_search_tree.lc3;

import help.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉搜索树构造篇
 */
@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/unique-binary-search-trees-ii/description/">95. 不同的二叉搜索树 II</a>
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return build(1, n);
    }

    // 返回用 [l ... r] 组成的 BST 的 root 列表
    private List<TreeNode> build(int l, int r) {
        List<TreeNode> res = new LinkedList<>();

        if (l > r) {
            res.add(null);
            return res;
        }

        for (int i = l; i <= r; i++) {
            // root 的值为 i
            List<TreeNode> leftRoot = build(l, i - 1);
            List<TreeNode> rightRoot = build(i + 1, r);

            for (TreeNode left : leftRoot) {
                for (TreeNode right : rightRoot) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
