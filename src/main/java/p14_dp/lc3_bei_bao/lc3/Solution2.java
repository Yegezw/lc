package p14_dp.lc3_bei_bao.lc3;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change-ii/description/">518. 零钱兑换 II</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount + 1];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return dp(coins, coins.length - 1, amount);
    }

    private int[][] memo;

    // 返回用 coins[0 ... index] 填满 amount 的次数
    private int dp(int[] coins, int index, int amount) {
        if (amount == 0) return 1;
        if (index < 0 || amount < 0) return 0;

        if (memo[index][amount] == -1) {
            int res = 0;
            res += dp(coins, index - 1, amount);             // coins[index] 不放进背包
            res += dp(coins, index, amount - coins[index]); // coins[index] 放进背包
            memo[index][amount] = res;
        }

        return memo[index][amount];
    }
}
