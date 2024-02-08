package p14_dp.lc1_base.lc2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-falling-path-sum/description/">931. 下降路径最小和</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        memo = new int[n][n];
        for (int[] arr : memo) Arrays.fill(arr, 66666);

        int res = Integer.MAX_VALUE;
        // 终点可能在 matrix[n - 1] 的任意一列
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp(matrix, n - 1, i));
        }
        return res;
    }

    private int[][] memo;

    // 返回 matrix[0][.] 到 matrix[x][y] 的最小路径和
    private int dp(int[][] matrix, int x, int y) {
        if (y < 0 || y >= matrix.length) return Integer.MAX_VALUE;
        if (x == 0) return matrix[0][y];

        if (memo[x][y] == 66666) {
            int min = min(
                    dp(matrix, x - 1, y),
                    dp(matrix, x - 1, y - 1),
                    dp(matrix, x - 1, y + 1)
            );
            memo[x][y] = matrix[x][y] + min;
        }

        return memo[x][y];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
