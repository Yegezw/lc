package p12_dp.lc1_dp_base.lc1;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/description/">322. 零钱兑换</a>
 */
@SuppressWarnings("all")
public class Solution4 {

    // 记忆化搜索
    public int coinChange1(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -10);
        return dp(coins, amount);
    }

    private int[] memo;

    private int dp(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (memo[amount] == -10) {
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int subProblem = dp(coins, amount - coin);
                if (subProblem == -1) continue;
                res = Math.min(res, 1 + subProblem);
            }
            memo[amount] = res != Integer.MAX_VALUE ? res : -1;
        }

        return memo[amount];
    }

    // 动态规划
    public int coinChange2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        memo[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // 求解 memo[i]
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) continue;

                int subProblem = memo[i - coin];
                if (subProblem == -1) continue;

                res = Math.min(res, 1 + subProblem);
            }
            memo[i] = res != Integer.MAX_VALUE ? res : -1;
        }

        return memo[amount];
    }
}
