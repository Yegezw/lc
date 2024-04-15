package p14_dp.lc3_bei_bao.lc1;

import java.util.Arrays;

/**
 * 0 - 1 背包问题: 虾皮笔试 - 最多英雄数
 */
@SuppressWarnings("all")
public class Solution5 {

    // costs[i] 代第 i 个英雄的价格, coins 代表点券数
    // 目标是用 coins 点券购买最多的英雄, 返回购买的英雄列表
    public static int[] knapsack01(int[] costs, int coins) {
        memo = new int[costs.length][coins + 1];
        path = new int[costs.length][coins + 1];
        for (int[] arr : memo) Arrays.fill(arr, -1);

        int n = dp(costs, costs.length - 1, coins);
        int[] res = new int[n];
        int index = n - 1;

        int i = costs.length - 1; // 物品
        int c = coins;            // 背包容量
        // 逆向遍历, 查看物品 i 是否被选择
        while (i >= 0 && c >= 0) {
            if (path[i][c] == 1) {
                // 物品 i 被选择
                res[index--] = costs[i];
                c -= costs[i];
                i--;
            } else {
                // 物品 i 未被选择
                i--;
            }
        }
        return res;
    }

    private static int[][] memo; // memo[index][c] 表示: costs[0 ... index] 填充 coins 能得到的最大价值
    private static int[][] path; // path[index][c] 表示: costs[0 ... index] 填充 coins, costs[index] 是否被选择

    // costs[i] 的价格为 costs[i], 价值为 1
    // 返回 costs[0 ... index] 填充 coins 能得到的最大价值
    private static int dp(int[] costs, int index, int coins) {
        if (index < 0 || coins <= 0) return 0;

        if (memo[index][coins] == -1) {
            int cost = costs[index];

            int res = dp(costs, index - 1, coins);
            if (coins >= cost) {
                int temp = 1 + dp(costs, index - 1, coins - cost);
                if (temp > res) {
                    res = temp;
                    path[index][coins] = 1;
                }
            }

            memo[index][coins] = res;
        }

        return memo[index][coins];
    }

    public static void main(String[] args) {
        int[] costs = {10, 5, 6, 11, 2, 3};
        int coins = 10;

        System.out.println(Arrays.toString(knapsack01(costs, coins)));

        for (int i = 0; i < path.length; i++) {
            System.out.printf("[0 ~ %d] ", i);
            System.out.print(Arrays.toString(path[i]));
            System.out.println(" " + costs[i]);
        }
    }
}
