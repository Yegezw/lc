package p99_lu.p1_hui_su.lc0;

/**
 * <a href="https://leetcode.cn/problems/word-search/description/">79. 单词搜索</a>
 */
@SuppressWarnings("all")
public class Solution4 {

    // 上右下左
    private int dir[][] = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        // 遍历起始位置 [x, y]
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (searchWord(board, word, 0, x, y)) return true;
            }
        }

        return false;
    }

    // 从 board[startx][starty] 开始, 寻找 word[index ... word.length)
    private boolean searchWord(char[][] board, String word, int index, int startx, int starty) {
        if (index == word.length() - 1) return board[startx][starty] == word.charAt(index);

        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;  // 做选择

            // 从 [startx, starty] 出发, 向四个方向寻找
            for (int i = 0; i < 4; i++) {
                int newx = startx + dir[i][0];
                int newy = starty + dir[i][1];
                if (inArea(newx, newy) && !visited[newx][newy] && searchWord(board, word, index + 1, newx, newy))
                    return true;
            }

            visited[startx][starty] = false; // 取消选择
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
