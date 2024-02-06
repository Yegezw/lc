package p14_dp.lc1_dp_base.lc1;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/integer-break/description/">343. 整数拆分</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    // 记忆化搜索
    public int integerBreak1(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n);
    }

    private int[] memo;

    private int dp(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        if (memo[n] == -1) {
            int res = -1;
            for (int i = 1; i <= n - 1; i++) {
                // n = i + (n - i)
                res = Math.max(res, i * (n - i));
                res = Math.max(res, i * dp(n - i));
            }
            memo[n] = res;
        }

        return memo[n];
    }

    // 动态规划
    public int integerBreak2(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 0;
        memo[2] = 1;

        for (int i = 3; i <= n; i++) {
            // 求解 memo[i]
            int res = -1;
            for (int j = 1; j <= i - 1; j++) {
                // i = j + (i - j)
                res = Math.max(res, j * (i - j));
                res = Math.max(res, j * memo[i - j]);
            }
            memo[i] = res;
        }

        return memo[n];
    }
}
