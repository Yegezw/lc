package p14_dp.lc3_bei_bao.lc1;

import java.util.Arrays;

/**
 * 0 - 1 背包问题: 记忆化搜索
 */
@SuppressWarnings("all")
public class Solution1 {

    // w[i] 代表重量, v[i] 代表价值, C 代表背包容量
    public int knapsack01(int[] w, int[] v, int C) {
        memo = new int[w.length][C + 1];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return dp(w, v, w.length - 1, C);
    }

    private int[][] memo;

    // 返回 w[0 ... index] 填充容量为 c 的背包的最大价值
    private int dp(int[] w, int[] v, int index, int c) {
        if (index == -1 || c <= 0) return 0;

        if (memo[index][c] == -1) {
            // w[index] 不放进背包
            int res = dp(w, v, index - 1, c);
            // w[index] 放进背包
            if (c >= w[index]) {
                res = Math.max(
                        res,
                        v[index] + dp(w, v, index - 1, c - w[index])
                );
            }
            memo[index][c] = res;
        }

        return memo[index][c];
    }
}
