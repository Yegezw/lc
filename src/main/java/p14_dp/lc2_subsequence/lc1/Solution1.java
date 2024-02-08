package p14_dp.lc2_subsequence.lc1;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/edit-distance/description/">72. 编辑距离</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return dp(word1, 0, word2, 0);
    }

    private int[][] memo;

    // 返回 word1[p1 ...] 转换成 word2[p2 ...] 所使用的最少操作数
    private int dp(String word1, int p1, String word2, int p2) {
        if (p1 == word1.length()) return word2.length() - p2;
        if (p2 == word2.length()) return word1.length() - p1;

        if (memo[p1][p2] == -1) {
            int res = Integer.MAX_VALUE;
            if (word1.charAt(p1) != word2.charAt(p2)) {
                res = Math.min(res, 1 + dp(word1, p1 + 1, word2, p2 + 1)); // 替换
                res = Math.min(res, 1 + dp(word1, p1, word2, p2 + 1));         // 增加
                res = Math.min(res, 1 + dp(word1, p1 + 1, word2, p2));         // 删除
            } else {
                res = dp(word1, p1 + 1, word2, p2 + 1);
            }
            memo[p1][p2] = res;
        }

        return memo[p1][p2];
    }
}
