package p14_dp.lc3_bei_bao.lc2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/">416. 分割等和子集</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int c = sum / 2;
        memo = new int[nums.length][c + 1];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return dp(nums, nums.length - 1, c);
    }

    private int[][] memo; // -1 0 1

    // 返回能否用 nums[0 ... index] 中的数字完全填满一个容量为 c 的背包
    private boolean dp(int[] nums, int index, int c) {
        if (c == 0) return true;
        if (index < 0 || c < 0) return false;

        if (memo[index][c] == -1) {
            memo[index][c] = 0;
            if (dp(nums, index - 1, c) || dp(nums, index - 1, c - nums[index])) memo[index][c] = 1;
        }

        return memo[index][c] == 1;
    }
}
