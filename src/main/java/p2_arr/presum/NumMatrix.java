package p2_arr.presum;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-2d-immutable/description/">304. 二维区域和检索 - 矩阵不可变</a>
 */
public class NumMatrix {

    private final int[][] presum; // presum[x][y] = sum([0][0], [x - 1][y - 1])

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;    // 行
        int n = matrix[0].length; // 列

        presum = new int[m + 1][n + 1];
        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                presum[x][y] = presum[x][y - 1] + presum[x - 1][y] - presum[x - 1][y - 1] + matrix[x - 1][y - 1];
            }
        }
    }

    public int sumRegion(int x1, int y1, int x2, int y2) {
        return presum[x2 + 1][y2 + 1] - presum[x2 + 1][y1] - presum[x1][y2 + 1] + presum[x1][y1];
    }
}
