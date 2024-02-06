package p12_hui_su.lc3;

/**
 * <a href="https://leetcode.cn/problems/max-area-of-island/description/">695. 岛屿的最大面积</a>
 */
@SuppressWarnings("all")
public class Solution6 {

    // 上右下左
    private final int[][] dir = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    private int m, n;
    private boolean[][] visited;
    private int curArea;
    private int maxArea;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        maxArea = 0;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 1 && !visited[x][y]) {
                    curArea = 0;
                    floodfill(grid, x, y);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }

        return maxArea;
    }

    // 从 grid[x][y] 的位置开始, 进行 floodfill
    // 保证 [x, y] 合法, 且 grid[x][y] 是没有被访问过的陆地
    private void floodfill(int[][] grid, int x, int y) {
        visited[x][y] = true;
        curArea++;

        for (int i = 0; i < 4; i++) {
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == 1) floodfill(grid, newx, newy);
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
