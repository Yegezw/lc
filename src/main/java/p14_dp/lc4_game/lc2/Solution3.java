package p14_dp.lc4_game.lc2;

import help.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/house-robber-iii/description/">337. 打家劫舍 III</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    // (打劫 || 不打劫) node 能够偷窃到的最高金额
    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode node) {
        if (node == null) return 0;

        if (memo.containsKey(node)) return memo.get(node);

        // 打劫 node
        int res1 = node.val;
        if (node.left != null) {
            res1 += rob(node.left.left);
            res1 += rob(node.left.right);
        }
        if (node.right != null) {
            res1 += rob(node.right.left);
            res1 += rob(node.right.right);
        }

        // 不打劫 node
        int res2 = rob(node.left) + rob(node.right);

        memo.put(node, Math.max(res1, res2));
        return memo.get(node);
    }
}
