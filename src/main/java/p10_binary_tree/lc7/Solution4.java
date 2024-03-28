package p10_binary_tree.lc7;

import help.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/path-sum-iii/description/">437. 路径总和 III</a>
 */
@SuppressWarnings("all")
public class Solution4 {

    private int res;
    private long sum;
    private Map<Long, Integer> map; // sum -> count

    public int pathSum(TreeNode root, int targetSum) {
        res = 0;
        sum = 0;
        map = new HashMap<>();

        map.put(0L, 1); // 为了处理包含根节点的情况
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode node, int targetSum) {
        if (node == null) return;

        // 进入 node
        sum += node.val;
        res += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        dfs(node.left, targetSum);
        dfs(node.right, targetSum);

        // 离开 node
        map.put(sum, map.getOrDefault(sum, 0) - 1);
        sum -= node.val;
    }
}
