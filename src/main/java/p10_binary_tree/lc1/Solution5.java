package p10_binary_tree.lc1;

import help.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/">102. 二叉树的层序遍历</a>
 */
@SuppressWarnings("all")
public class Solution5 {

    /**
     * 非递归
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                level.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            list.add(level);
        }

        return list;
    }

    /**
     * 递归
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        dfs(root, 0, list);

        return list;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) return;

        if (level == list.size()) list.add(new LinkedList<>());
        list.get(level).add(node.val);

        dfs(node.left, level + 1, list);
        dfs(node.right, level + 1, list);
    }
}
