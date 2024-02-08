package p14_dp.lc2_subsequence.lc3;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-subsequence/description/">516. 最长回文子序列</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        memo = new int[n][n];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return dp(s, 0, n - 1);
    }

    private int[][] memo;

    // 返回 s[l ... r] 最长回文子序列的长度
    private int dp(String s, int l, int r) {
        if (l > r) return 0;
        if (l == r) return 1;

        if (memo[l][r] == -1) {
            if (s.charAt(l) == s.charAt(r)) {
                memo[l][r] = 2 + dp(s, l + 1, r - 1);
            } else {
                memo[l][r] = Math.max(
                        dp(s, l + 1, r), // s[l] 不属于回文子序列
                        dp(s, l, r - 1)  // s[r] 不属于回文子序列
                );
            }
        }

        return memo[l][r];
    }
}
