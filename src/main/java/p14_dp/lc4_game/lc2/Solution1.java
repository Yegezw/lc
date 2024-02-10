package p14_dp.lc4_game.lc2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">198. 打家劫舍</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(nums, n - 1);
    }

    private int[] memo;

    // 返回 nums[0 ... index] 能够偷窃到的最高金额
    private int dp(int[] nums, int index) {
        if (index < 0) return 0;
        if (index == 0) return nums[0];

        if (memo[index] == -1) {
            memo[index] = Math.max(
                    dp(nums, index - 1),
                    nums[index] + dp(nums, index - 2)
            );
        }

        return memo[index];
    }
}
