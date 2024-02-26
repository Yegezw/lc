package p14_dp.lc4_game.lc3;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/">188. 买卖股票的最佳时机 IV</a>
 */
@SuppressWarnings("all")
public class Solution6 {

    // 最多买卖 maxK 次
    public int maxProfit(int maxK, int[] prices) {
        int n = prices.length;
        if (maxK > n / 2) maxK = n / 2; // k 无限制

        // dp[i][k][0] 第 i 天结束时未持有股票, 从开始到现在最多买入 k 次
        // dp[i][k][1] 第 i 天结束时已持有股票, 从开始到现在最多买入 k 次
        int[][][] dp = new int[n][maxK + 1][2];

        for (int i = 0; i < n; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }

                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][maxK][0];
    }
}
