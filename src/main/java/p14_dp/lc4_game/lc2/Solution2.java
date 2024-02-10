package p14_dp.lc4_game.lc2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/description/">213. 打家劫舍 II</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        memo = new int[n];

        Arrays.fill(memo, -1);
        int res1 = dp(nums, 1, n - 1);
        Arrays.fill(memo, -1);
        int res2 = dp(nums, 0, n - 2);

        return Math.max(res1, res2);
    }

    private int[] memo;

    // 返回 nums[start ... index] 能够偷窃到的最高金额
    private int dp(int[] nums, int start, int index) {
        if (index < start) return 0;
        if (index == start) return nums[start];

        if (memo[index] == -1) {
            memo[index] = Math.max(
                    dp(nums, start, index - 1),
                    nums[index] + dp(nums, start, index - 2)
            );
        }

        return memo[index];
    }
}
