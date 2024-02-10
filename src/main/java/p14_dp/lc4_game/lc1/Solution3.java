package p14_dp.lc4_game.lc1;

/**
 * <a href="https://leetcode.cn/problems/unique-paths/description/">62. 不同路径</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return dp(m - 1, n - 1);
    }

    private int[][] memo;

    // 返回从 [0][0] 走到 [x][y] 的路径数
    private int dp(int x, int y) {
        if (x < 0 || y < 0) return 0;
        if (x == 0 && y == 0) return 1;

        if (memo[x][y] == 0) {
            memo[x][y] = dp(x, y - 1) + dp(x - 1, y);
        }

        return memo[x][y];
    }
}
