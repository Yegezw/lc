package p14_dp.lc3_bei_bao.lc1;

/**
 * 0 - 1 背包问题: 动态规划
 */
@SuppressWarnings("all")
public class Solution2 {

    // w[i] 代表重量, v[i] 代表价值, C 代表背包容量
    public int knapsack01(int[] w, int[] v, int C) {
        if (w.length == 0 || C == 0) return 0;

        // dp[i][c] = 用 w[0 ... i] 填充容量为 c 的背包的最大价值
        int[][] dp = new int[w.length][C + 1];

        // 用 w[0] 填充背包
        for (int c = 0; c <= C; c++) {
            dp[0][c] = (c >= w[0] ? v[0] : 0);
        }
        // 用 w[0 ... i] 填充背包
        for (int i = 1; i < w.length; i++) {
            for (int c = 0; c <= C; c++) {
                // w[i] 不放进背包
                int res = dp[i - 1][c];
                // w[i] 放进背包
                if (c >= w[i]) res = Math.max(res, v[i] + dp[i - 1][c - w[i]]);

                dp[i][c] = res;
            }
        }

        return dp[w.length - 1][C];
    }
}
