package p14_dp.lc3_bei_bao.lc3;

/**
 * <a href="https://leetcode.cn/problems/coin-change-ii/description/">518. 零钱兑换 II</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    public int change(int amount, int[] coins) {
        // dp[c] = 用 coins[0 ... i] 填满背包 c 的次数
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // 用 coins[0] 填充
        for (int c = 1; c <= amount; c++) {
            dp[c] = (c % coins[0] == 0 ? 1 : 0);
        }
        // 用 coins[0 ... i] 填充
        for (int i = 1; i < coins.length; i++) {
            for (int c = 1; c <= amount; c++) {
                if (c >= coins[i]) dp[c] += dp[c - coins[i]];
            }
        }

        return dp[amount];
    }
}
