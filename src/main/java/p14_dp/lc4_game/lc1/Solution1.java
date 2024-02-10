package p14_dp.lc4_game.lc1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/minimum-path-sum/description/">64. 最小路径和</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return dp(grid, m - 1, n - 1);
    }

    private int[][] memo;

    // 返回 grid[0][0] 到 grid[x][y] 的最小路径和
    private int dp(int[][] grid, int x, int y) {
        if (x < 0 || y < 0) return Integer.MAX_VALUE;
        if (x == 0 && y == 0) return grid[0][0];

        if (memo[x][y] == -1) {
            memo[x][y] = grid[x][y] + Math.min(
                    dp(grid, x, y - 1), // 左
                    dp(grid, x - 1, y)  // 上
            );
        }

        return memo[x][y];
    }

    private LinkedList<Integer> getPath(int[][] grid) {
        LinkedList<Integer> path = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;
        int x = m - 1;
        int y = n - 1;

        while (x >= 0 && y >= 0) {
            path.addFirst(grid[x][y]);

            if (x - 1 >= 0 && y - 1 >= 0) {
                if (memo[x][y - 1] <= memo[x - 1][y]) y--;
                else x--;
            }
            else if (x - 1 >= 0) x--;
            else y--;
        }

        return path;
    }
}
