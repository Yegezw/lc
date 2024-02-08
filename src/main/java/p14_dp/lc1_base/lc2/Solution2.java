package p14_dp.lc1_base.lc2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/distinct-subsequences/description/">115. 不同的子序列</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    public int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return dp(s, 0, t, 0);
    }

    private int[][] memo;

    // 返回 s[si ...] 的子序列中 t[ti ...] 出现的次数
    private int dp(String s, int si, String t, int ti) {
        if (ti == t.length()) return 1;
        if (s.length() - si < t.length() - ti) return 0;

        if (memo[si][ti] == -1) {
            if (s.charAt(si) != t.charAt(ti)) {
                // s[si] 与 t[ti] 不匹配
                memo[si][ti] = dp(s, si + 1, t, ti);
            } else {
                // s[si] 与 t[ti] 匹配, 两种情况累加
                memo[si][ti] = dp(s, si + 1, t, ti + 1) + dp(s, si + 1, t, ti);
            }
        }

        return memo[si][ti];
    }
}
