package p2_arr.binary;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class Solution3 {

    /**
     * <a href="https://leetcode.cn/problems/search-a-2d-matrix/description/">74. 搜索二维矩阵</a>
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;    // 行
        int n = matrix[0].length; // 列

        int l = 0;
        int r = m * n - 1;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (get(matrix, mid) == target) return true;
            if (get(matrix, mid) < target) l = mid + 1;
            else r = mid - 1;
        }

        return false;
    }

    // 通过一维索引访问二维数组中的元素
    private int get(int[][] matrix, int index) {
        int n = matrix[0].length; // 列
        int x = index / n;
        int y = index % n;
        return matrix[x][y];
    }

    /**
     * <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii/description/">240. 搜索二维矩阵 II</a>
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;    // 行
        int n = matrix[0].length; // 列

        // 右上角 [x][y] = [0][n - 1]
        // x++ 向下走增加
        // y-- 向左走减小
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] < target) x++;
            else y--;
        }

        return false;
    }

    /**
     * <a href="https://leetcode.cn/problems/find-k-closest-elements/description/">658. 找到 K 个最接近的元素</a>
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> res = new LinkedList<>();

        int r = ceil(arr, x);
        int l = r - 1;
        for (int i = 0; i < k; i++) {
            if (l >= 0 && r < arr.length) {
                if (x - arr[l] <= arr[r] - x) res.addFirst(arr[l--]);
                else res.addLast(arr[r++]);
            }
            else if (l >= 0) res.addFirst(arr[l--]);
            else res.addLast(arr[r++]);
        }

        return res;
    }

    // 返回 >= target 的最左边的索引
    private int ceil(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        int mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }

        return r;
    }

    /**
     * <a href="https://leetcode.cn/problems/find-peak-element/description/">162. 寻找峰值</a>
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;

        int l = 0;
        int r = nums.length - 1;
        int mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }

        return l;
    }

    /**
     * <a href="https://leetcode.cn/problems/peak-index-in-a-mountain-array/description/">852. 山脉数组的峰顶索引</a>
     */
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid + 1]) r = mid;
            else l = mid + 1;
        }

        return l;
    }
}
