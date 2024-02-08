package p14_dp.lc2_subsequence.lc3;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/">1312. 让字符串成为回文串的最少插入次数</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    public int minInsertions(String s) {
        int n = s.length();
        memo = new int[n][n];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return dp(s, 0, n - 1);
    }

    private int[][] memo;

    // 返回让 s[l ... r] 成为回文串的最小插入次数
    private int dp(String s, int l, int r) {
        if (l >= r) return 0;

        if (memo[l][r] == -1) {
            if (s.charAt(l) == s.charAt(r)) {
                memo[l][r] = dp(s, l + 1, r - 1);
            } else {
                memo[l][r] = 1 + Math.min(
                        dp(s, l, r - 1), // 左边插入 
                        dp(s, l + 1, r)  // 右边插入
                );
            }
        }

        return memo[l][r];
    }
}
