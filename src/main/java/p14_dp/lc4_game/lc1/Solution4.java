package p14_dp.lc4_game.lc1;

/**
 * <a href="https://leetcode.cn/problems/unique-paths-ii/description/">63. 不同路径 II</a>
 */
@SuppressWarnings("all")
public class Solution4 {

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                // 求解 dp[x][y]
                if (obstacleGrid[x][y] != 1) {
                    if (y - 1 >= 0) dp[x][y] += dp[x][y - 1];
                    if (x - 1 >= 0) dp[x][y] += dp[x - 1][y];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
