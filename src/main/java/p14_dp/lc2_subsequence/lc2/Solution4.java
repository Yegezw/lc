package p14_dp.lc2_subsequence.lc2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/">718. 最长重复子数组</a>
 */
@SuppressWarnings("all")
public class Solution4 {

    // 动态规划
    public int findLength1(int[] nums1, int[] nums2) {
        // memo[p1][p2] 代表
        // 以 p1 p2 为结尾的、且包含 p1 p2 的最长重复子数组的长度
        int[][] memo = new int[nums1.length][nums2.length];

        int maxLen = 0;
        for (int p1 = 0; p1 < nums1.length; p1++) {
            for (int p2 = 0; p2 < nums2.length; p2++) {
                // 求解 memo[p1][p2]
                if (nums1[p1] == nums2[p2]) {
                    if (p1 - 1 >= 0 && p2 - 1 >= 0) {
                        memo[p1][p2] = memo[p1 - 1][p2 - 1] + 1;
                    } else {
                        memo[p1][p2] = 1;
                    }
                }
                maxLen = Math.max(maxLen, memo[p1][p2]);
            }
        }

        return maxLen;
    }

    // 输出路径
    public int findLength2(int[] nums1, int[] nums2) {
        // memo[p1][p2] 代表
        // 以 p1 p2 为结尾的、且包含 p1 p2 的最长重复子数组的长度
        int[][] memo = new int[nums1.length][nums2.length];

        int maxLen = 0;
        int end = -1; // nums1 的末尾索引
        for (int p1 = 0; p1 < nums1.length; p1++) {
            for (int p2 = 0; p2 < nums2.length; p2++) {
                // 求解 memo[p1][p2]
                if (nums1[p1] == nums2[p2]) {
                    if (p1 - 1 >= 0 && p2 - 1 >= 0) {
                        memo[p1][p2] = memo[p1 - 1][p2 - 1] + 1;
                    } else {
                        memo[p1][p2] = 1;
                    }
                }

                if (memo[p1][p2] > maxLen) {
                    maxLen = memo[p1][p2];
                    end = p1;
                }
            }
        }

        // 输出路径
        int start = end - (maxLen - 1);
        int[] arr = Arrays.copyOfRange(nums1, start, end + 1);
        System.out.println(Arrays.toString(arr)); // 输出最长重复子数组

        return maxLen;
    }
}
