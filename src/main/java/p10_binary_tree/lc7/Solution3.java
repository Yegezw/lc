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
        path.add(node.val);

        // 叶子节点
        if (node.left == null && node.right == null) {
            if (sum == targetSum) res.add(new LinkedList<>(path));
            sum -= node.val;
            path.removeLast();
            return;
        }

        dfs(node.left, targetSum);
        dfs(node.right, targetSum);
        sum -= node.val;
        path.removeLast();
    }

    /**
     * <a href="https://leetcode.cn/problems/path-sum-iii/description/">437. 路径总和 III</a>
     */
    public int pathSum3(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int res = findPath(root, targetSum);    // 包含当前 root 节点
        res += findPath(root.left, targetSum);  // 不包含当前 root 节点
        res += findPath(root.right, targetSum); // 不包含当前 root 节点

        return res;
    }

    // 在以 node 为根节点的二叉树中, 寻找包含 node 的和为 sum 的路径, 返回路径个数
    private int findPath(TreeNode node, int targetSum) {
        if (node == null) return 0;

        int res = 0;
        if (node.val == targetSum) res++;
        res += findPath(node.left, targetSum - node.val);
        res += findPath(node.right, targetSum - node.val);

        return res;
    }
}
