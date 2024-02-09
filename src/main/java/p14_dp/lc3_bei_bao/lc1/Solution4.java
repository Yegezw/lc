package p14_dp.lc3_bei_bao.lc1;

/**
 * 0 - 1 背包问题: 空间复杂度优化二
 */
@SuppressWarnings("all")
public class Solution4 {

    // w[i] 代表重量, v[i] 代表价值, C 代表背包容量
    public int knapsack01(int[] w, int[] v, int C) {
        if (w.length == 0 || C == 0) return 0;

        // dp[c] = 用 w[0 ... i] 填充容量为 c 的背包的最大价值
        int[] dp = new int[C + 1];

        // 用 w[0] 填充背包
        for (int c = 0; c <= C; c++) {
            dp[c] = (c >= w[0] ? v[0] : 0);
        }
        // 用 w[0 ... i] 填充背包
        for (int i = 1; i < w.length; i++) {
            for (int c = C; c >= w[i]; c--) {
                // w[i] 不放进背包 OR 放进背包
                dp[c] = Math.max(dp[c], v[i] + dp[c - w[i]]);
            }
        }

        return dp[C];
    }
}
