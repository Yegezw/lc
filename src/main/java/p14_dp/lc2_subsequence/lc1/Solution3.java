package p14_dp.lc2_subsequence.lc1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/">53. 最大子数组和</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    // 动态规划
    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE;

        int pre = 0;
        for (int num : nums) {
            // pre = 以 num 为结尾的最大子数组和
            pre = Math.max(num, pre + num);
            res = Math.max(res, pre);
        }

        return res;
    }

    // 优化空间复杂度
    public int maxSubArray2(int[] nums) {
        // memo[i] = nums[0 ... i] 以 i 为结尾的最大子数组和
        int[] memo = new int[nums.length];
        memo[0] = nums[0];

        int res = memo[0];
        for (int i = 1; i < nums.length; i++) {
            // 求解 memo[i]
            memo[i] = Math.max(nums[i], nums[i] + memo[i - 1]);
            res = Math.max(res, memo[i]);
        }

        return res;
    }

    // 输出路径
    public int maxSubArray3(int[] nums) {
        int[] memo = Arrays.copyOf(nums, nums.length);

        // prev[i] = 以 i 为结尾的 MSA 的上一个元素的索引
        int[] prev = new int[nums.length];
        Arrays.fill(prev, -1);

        int maxSum = memo[0];
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            // 求解 memo[i] 和 prev[i]
            if (nums[i] + memo[i - 1] > nums[i]) {
                memo[i] = nums[i] + memo[i - 1];
                prev[i] = i - 1;
            }

            if (memo[i] > maxSum) {
                maxSum = memo[i];
                end = i;
            }
        }

        // 输出路径
        LinkedList<Integer> list = new LinkedList<>();
        while (end != -1) {
            list.addFirst(nums[end]);
            end = prev[end];
        }
        System.out.println(list); // 输出最大子数组

        return maxSum;
    }
}
