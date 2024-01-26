package p11_binart_search_tree.lc2;

import help.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树基操篇
 */
@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/">98. 验证二叉搜索树</a>
     */
    public boolean isValidBST1(TreeNode root) {
        return isValidBST1(root, null, null);
    }

    private boolean isValidBST1(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) return true;

        if (min != null && node.val <= min.val) return false;
        if (max != null && node.val >= max.val) return false;

        return isValidBST1(node.left, min, node) && isValidBST1(node.right, node, max);
    }

    private TreeNode prev = null;

    public boolean isValidBST2(TreeNode node) {
        if (node == null) return true;

        if (!isValidBST2(node.left)) return false;

        if (prev == null) prev = node;
        else {
            if (prev.val >= node.val) return false;
            else prev = node;
        }

        return isValidBST2(node.right);
    }

    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;

        // 用 cur 来遍历节点, stack 存储遍历过的节点
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();

                if (prev == null) prev = cur;
                else {
                    if (prev.val >= cur.val) return false;
                    else prev = cur;
                }

                cur = cur.right;
            }
        }

        return true;
    }
}
