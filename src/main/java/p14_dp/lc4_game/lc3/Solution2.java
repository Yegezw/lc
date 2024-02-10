package p14_dp.lc4_game.lc3;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/">122. 买卖股票的最佳时机 II</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    // 买卖次数不限
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // dp[i][0] 第 i 天结束时未持有股票
        // dp[i][1] 第 i 天结束时已持有股票
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}
