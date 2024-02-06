package p12_dp.lc1_dp_base.lc1;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/">70. 爬楼梯</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    // 记忆化搜索
    public int climbStairs1(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n);
    }

    private int[] memo;

    private int dp(int n) {
        if (n == 1 || n == 2) return n;

        if (memo[n] == -1) memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }

    // 动态规划
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) return n;

        int prev1 = 1; // 1 -> 1
        int prev2 = 2; // 2 -> 2

        for (int i = 3; i <= n; i++) {
            int res = prev1 + prev2;
            prev1 = prev2;
            prev2 = res;
        }

        return prev2;
    }
}
