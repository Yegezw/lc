package p10_binary_tree.lc7;

import help.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class Solution3 {

    /**
     * <a href="https://leetcode.cn/problems/path-sum/description/">112. 路径总和</a>
     */
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) return false;
        if (node.left == null && node.right == null) return targetSum == node.val; // 叶子节点

        return hasPathSum(node.left, targetSum - node.val) || hasPathSum(node.right, targetSum - node.val);
    }

    /**
     * <a href="https://leetcode.cn/problems/path-sum-ii/description/">113. 路径总和 II</a>
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private int sum;
    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> res = new ArrayList<>();

    private void dfs(TreeNode node, int targetSum) {
        if (node == null) return;

        sum += node.val;
        path.addLast(node.val);

        // 叶子节点
        if (node.left == null && node.right == null) {
            if (sum == targetSum) res.add(new LinkedList<>(path));
            sum -= node.val;
            path.removeLast();
            return;
        }
        // 非叶子节点
        else {
            dfs(node.left, targetSum);
            dfs(node.right, targetSum);
            sum -= node.val;
            path.removeLast();
        }
    }
}
