package p14_dp.lc4_game.lc2;

import help.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/house-robber-iii/description/">337. 打家劫舍 III</a>
 */
@SuppressWarnings("all")
public class Solution4 {

    public int rob(TreeNode node) {
        int[] dp = dp(node);
        return Math.max(dp[0], dp[1]);
    }

    // arr[0] 表示不抢 node 得到的最高金额
    // arr[1] 表示打劫 node 得到的最高金额
    private int[] dp(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = dp(node.left);
        int[] right = dp(node.right);

        // 不打劫 node
        int res1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 打劫 node
        int res2 = node.val + left[0] + right[0];

        return new int[]{res1, res2};
    }
}
