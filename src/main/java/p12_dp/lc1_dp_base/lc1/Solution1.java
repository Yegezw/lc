package p12_dp.lc1_dp_base.lc1;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/fibonacci-number/description/">509. 斐波那契数</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    // 记忆化搜索
    public int fib1(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n);
    }

    private int[] memo;

    private int dp(int n) {
        if (n == 0 || n == 1) return n;

        if (memo[n] == -1) memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }

    // 动态规划
    public int fib2(int n) {
        if (n == 0 || n == 1) return n;

        int prev1 = 0; // 0 -> 0
        int prev2 = 1; // 1 -> 1

        for (int i = 2; i <= n; i++) {
            int res = prev1 + prev2;
            prev1 = prev2;
            prev2 = res;
        }

        return prev2;
    }
}
