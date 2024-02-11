package p2_arr.lc4_order;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/rotate-image/description/">48. 旋转图像</a>
     * <p>将二维矩阵原地顺时针旋转 90 度
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 沿 \ 对角线, 镜像对称二维矩阵
        for (int x = 0; x < n; x++) {
            for (int y = x; y < n; y++) {
                // swap(matrix[x][y], matrix[y][x])
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
            }
        }

        // 反转二维矩阵的每一行
        for (int[] row : matrix) reverse(row);
    }

    /**
     * 将二维矩阵原地逆时针旋转 90 度
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;

        // 沿 / 对角线, 镜像对称二维矩阵
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n - x; y++) {
                // swap(matrix[x][y], matrix[n - 1 - y][n - 1 - x])
                int temp = matrix[x][y];
                matrix[x][y] = matrix[n - 1 - y][n - 1 - x];
                matrix[n - 1 - y][n - 1 - x] = temp;
            }
        }

        // 反转二维矩阵的每一行
        for (int[] row : matrix) reverse(row);
    }

    private void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}