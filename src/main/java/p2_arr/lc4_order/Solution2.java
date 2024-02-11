package p2_arr.lc4_order;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/spiral-matrix/description/">54. 螺旋矩阵</a>
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // l   r
        // 1 2 3 t
        // 4 5 6
        // 7 8 9 b
        int m = matrix.length;    // 行
        int n = matrix[0].length; // 列
        int count = m * n;

        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;

        List<Integer> res = new ArrayList<>();
        while (true) {
            if (res.size() == count) break;
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);    // 向右遍历
            top++;

            if (res.size() == count) break;
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);  // 向下遍历
            right--;

            if (res.size() == count) break;
            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]); // 向左遍历
            bottom--;

            if (res.size() == count) break;
            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);   // 向上遍历
            left++;
        }

        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/spiral-matrix-ii/description/">59. 螺旋矩阵 II</a>
     */
    public int[][] generateMatrix(int n) {
        // l   r
        // 1 2 3 t
        // 4 5 6
        // 7 8 9 b
        int[][] arr = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;

        while (true) {
            if (num > n * n) break;
            for (int i = left; i <= right; i++) arr[top][i] = num++;    // 向右填充
            top++;

            if (num > n * n) break;
            for (int i = top; i <= bottom; i++) arr[i][right] = num++;  // 向下填充
            right--;

            if (num > n * n) break;
            for (int i = right; i >= left; i--) arr[bottom][i] = num++; // 向左填充
            bottom--;

            if (num > n * n) break;
            for (int i = bottom; i >= top; i--) arr[i][left] = num++;   // 向上填充
            left++;
        }

        return arr;
    }
}
