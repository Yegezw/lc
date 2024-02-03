package p99_lu.p1_hui_su.lc2;

/**
 * <a href="https://leetcode.cn/problems/sudoku-solver/description/">37. 解数独</a>
 */
@SuppressWarnings("all")
public class Solution4 {

    private final boolean[][] row = new boolean[9][10];
    private final boolean[][] col = new boolean[9][10];
    private final boolean[][] block = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                char c = board[x][y];
                if (c != '.') {
                    row[x][c - '0'] = true;
                    col[y][c - '0'] = true;
                    block[x / 3 * 3 + y / 3][c - '0'] = true;
                }
            }
        }

        for (int i = 0; i < 81; i++) {
            if (board[i / 9][i % 9] == '.') {
                if (backtrack(board, i)) return;
                else throw new RuntimeException("board is not solution!");
            }
        }
    }

    private boolean backtrack(char[][] board, int pos) {
        if (pos == 81) return true;

        int next = pos + 1;
        for (; next < 81; next++) {
            if (board[next / 9][next % 9] == '.') break;
        }

        // 给 board[x][y] 填充数字 i
        int x = pos / 9;
        int y = pos % 9;
        for (int i = 1; i <= 9; i++) {
            if (!row[x][i] && !col[y][i] && !block[x / 3 * 3 + y / 3][i]) {
                board[x][y] = (char) ('0' + i);
                row[x][i] = true;
                col[y][i] = true;
                block[x / 3 * 3 + y / 3][i] = true;

                if (backtrack(board, next)) return true;

                board[x][y] = '.';
                row[x][i] = false;
                col[y][i] = false;
                block[x / 3 * 3 + y / 3][i] = false;
            }
        }

        return false;
    }
}
