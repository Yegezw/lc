package p12_dp.lc1_dp_base;

/**
 * 动态规划解题套路框架
 */
@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/fibonacci-number/description/">509. 斐波那契数</a>
     */
    public int fib(int n) {
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

    /**
     * <a href="https://leetcode.cn/problems/climbing-stairs/description/">70. 爬楼梯</a>
     */
    public int climbStairs(int n) {
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

    /**
     * <a href="https://leetcode.cn/problems/integer-break/description/">343. 整数拆分</a>
     */
    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 0;
        memo[2] = 1;

        for (int i = 3; i <= n; i++) {
            // 求解 memo[i]
            // i = j + (i - j)
            int res = -1;
            for (int j = 1; j <= i - 1; j++) {
                res = Math.max(res, j * (i - j));
                res = Math.max(res, j * memo[i - j]);
            }
            memo[i] = res;
        }

        return memo[n];
    }

    /**
     * <a href="https://leetcode.cn/problems/coin-change/description/">322. 零钱兑换</a>
     */
    public int coinChange(int[] coins, int amount) {
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
