package p14_dp.lc3_bei_bao.lc2;

/**
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/">416. 分割等和子集</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int C = sum / 2;

        // dp[c] = 用 nums[0 ... i] 中的数字, 能否完全填满一个容量为 c 的背包
        boolean[] dp = new boolean[C + 1];
        dp[0] = true;

        // 用 nums[0] 填充背包
        for (int c = 1; c <= C; c++) {
            dp[c] = (c == nums[0]);
        }
        // 用 nums[0 ... i] 填充背包
        for (int i = 1; i < nums.length; i++) {
            for (int c = C; c >= nums[i]; c--) {
                // nums[i] 不放进背包 OR 放进背包
                dp[c] = dp[c] || dp[c - nums[i]];
            }
        }

        return dp[C];
    }
}
