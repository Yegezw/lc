package p99_lu.p1_hui_su.lc0;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/description/">200. 岛屿数量</a>
 */
@SuppressWarnings("all")
public class Solution5 {

    // 上右下左
    private int[][] dir = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    private int m, n;
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int res = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == '1' && !visited[x][y]) {
                    res++;
                    floodfill(grid, x, y);
                }
            }
        }

        return res;
    }

    // 从 grid[x][y] 的位置开始, 进行 floodfill
    // 保证 [x, y] 合法, 且 grid[x][y] 是没有被访问过的陆地
    private void floodfill(char[][] grid, int startx, int starty) {
        visited[startx][starty] = true;
        for (int i = 0; i < 4; i++) {
            int newx = startx + dir[i][0];
            int newy = starty + dir[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') floodfill(grid, newx, newy);
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
