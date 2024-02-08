package p14_dp.lc2_subsequence.lc2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/">712. 两个字符串的最小 ASCII 删除和</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    public int minimumDeleteSum(String s1, String s2) {
        memo = new int[s1.length()][s2.length()];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return dp(s1, 0, s2, 0);
    }

    private int[][] memo;

    // 返回使 s1[p1 ...] s2[p2 ...] 相等所删除字符的最小 ASCII 和
    private int dp(String s1, int p1, String s2, int p2) {
        int res = 0;
        if (p1 == s1.length()) {
            while (p2 < s2.length()) res += s2.charAt(p2++);
            return res;
        }
        if (p2 == s2.length()) {
            while (p1 < s1.length()) res += s1.charAt(p1++);
            return res;
        }

        if (memo[p1][p2] == -1) {
            if (s1.charAt(p1) == s2.charAt(p2)) {
                res = dp(s1, p1 + 1, s2, p2 + 1);
            } else {
                res = Math.min(
                        s1.charAt(p1) + dp(s1, p1 + 1, s2, p2), // 删除 s1[p1]
                        s2.charAt(p2) + dp(s1, p1, s2, p2 + 1)  // 删除 s2[p2]
                );
            }
            memo[p1][p2] = res;
        }

        return memo[p1][p2];
    }
}
