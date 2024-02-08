package p14_dp.lc2_subsequence.lc2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-common-subsequence/description/">1143. 最长公共子序列</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return dp(text1, 0, text2, 0);
    }

    private int[][] memo;

    // 返回 text1[p1 ...] text1[p2 ...] 最长公共子序列的长度
    private int dp(String text1, int p1, String text2, int p2) {
        if (p1 == text1.length() || p2 == text2.length()) return 0;

        if (memo[p1][p2] == -1) {
            if (text1.charAt(p1) != text2.charAt(p2)) {
                memo[p1][p2] = Math.max(
                        dp(text1, p1, text2, p2 + 1),
                        dp(text1, p1 + 1, text2, p2)
                );
            } else {
                memo[p1][p2] = 1 + dp(text1, p1 + 1, text2, p2 + 1);
            }
        }

        return memo[p1][p2];
    }

    private String getLCS(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int m = s1.length();
        int n = s2.length();
        int p1 = 0;
        int p2 = 0;

        while (p1 < m && p2 < n) {
            if (s1.charAt(p1) == s2.charAt(p2)) {
                result.append(s1.charAt(p1));
                p1++;
                p2++;
            } else {
                if (p1 + 1 < m && p2 + 1 < n) {
                    if (memo[p1 + 1][p2] >= memo[p1][p2 + 1]) p1++;
                    else p2++;
                }
                else if (p1 + 1 < m) p1++;
                else p2++;
            }
        }

        return result.toString();
    }
}
