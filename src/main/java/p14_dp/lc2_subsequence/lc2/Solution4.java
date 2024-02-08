package p14_dp.lc2_subsequence.lc2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/">718. 最长重复子数组</a>
 */
@SuppressWarnings("all")
public class Solution4 {

    public int findLength(int[] nums1, int[] nums2) {
        memo = new int[nums1.length][nums2.length];
        for (int[] arr : memo) Arrays.fill(arr, -1);

        int res = -1;
        for (int p1 = 0; p1 < nums1.length; p1++) {
            for (int p2 = 0; p2 < nums2.length; p2++) {
                res = Math.max(res, dp(nums1, p1, nums2, p2));
            }
        }
        return res;
    }

    private int[][] memo;

    // 返回 nums1[p1 ...] nums2[p2 ...] 以 p1 p2 作为起点的最长重复子数组长度
    private int dp(int[] nums1, int p1, int[] nums2, int p2) {
        if (p1 == nums1.length || p2 == nums2.length) return 0;

        if (memo[p1][p2] == -1) {
            if (nums1[p1] != nums2[p2]) {
                memo[p1][p2] = 0;
            } else {
                memo[p1][p2] = 1 + dp(nums1, p1 + 1, nums2, p2 + 1);
            }
        }

        return memo[p1][p2];
    }
}