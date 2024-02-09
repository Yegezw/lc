package p14_dp.lc3_bei_bao.lc4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/target-sum/description/">494. 目标和</a>
 */
@SuppressWarnings("all")
public class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        memo = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            memo.add(new HashMap<>());
        }
        return dp(nums, nums.length - 1, target);
    }

    private List<Map<Integer, Integer>> memo; // memo[index][target]

    // 返回用 nums[0 ... index] 构造出 target 的次数
    private int dp(int[] nums, int index, int target) {
        if (index == -1 && target == 0) return 1;
        if (index == -1) return 0;

        if (!memo.get(index).containsKey(target)) {
            int res = 0;
            int num = nums[index];
            res += dp(nums, index - 1, target - num);
            res += dp(nums, index - 1, target + num);

            memo.get(index).put(target, res);
        }

        return memo.get(index).get(target);
    }
}
