package p14_dp.lc2_subsequence.lc2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/delete-operation-for-two-strings/description/">583. 两个字符串的删除操作</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        memo = new int[m][n];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        int len = dp(word1, 0, word2, 0);

        return m - len + n - len;
    }

    private int[][] memo;

    // 返回 s1[p1 ...] s2[p2 ...] len(LCS)
    private int dp(String s1, int p1, String s2, int p2) {
        if (p1 == s1.length() || p2 == s2.length()) return 0;

        if (memo[p1][p2] == -1) {
            if (s1.charAt(p1) != s2.charAt(p2)) {
                memo[p1][p2] = Math.max(
                        dp(s1, p1, s2, p2 + 1),
                        dp(s1, p1 + 1, s2, p2)
                );
            } else {
                memo[p1][p2] = 1 + dp(s1, p1 + 1, s2, p2 + 1);
            }
        }

        return memo[p1][p2];
    }
}
