package p6_queue.pq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/description/">373. 查找和最小的 K 对数字</a>
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // minHeap 存储三元组 (nums1[i], nums[index], index)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (o1, o2) -> (o1[0] + o1[1]) - (o2[0] + o2[1])
        );
        for (int i = 0; i < nums1.length; i++) {
            minHeap.add(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!minHeap.isEmpty() && k > 0) {
            k--;

            int[] cur = minHeap.remove();
            res.add(new ArrayList<>(Arrays.asList(cur[0], cur[1])));

            int nextIndex = cur[2] + 1;
            if (nextIndex < nums2.length) minHeap.add(new int[]{cur[0], nums2[nextIndex], nextIndex});
        }

        return res;
    }


    /**
     * <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/description/">378. 有序矩阵中第 K 小的元素</a>
     */
    public int kthSmallest(int[][] matrix, int k) {
        // minHeap 存储二元组 (matrix[i][j], i, j)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < matrix.length; i++) {
            minHeap.add(new int[]{matrix[i][0], i, 0});
        }

        int res = -1;
        while (!minHeap.isEmpty() && k > 0) {
            k--;

            int[] cur = minHeap.remove();
            res = cur[0];

            int i = cur[1];
            int j = cur[2];
            if (j + 1 < matrix[i].length) minHeap.add(new int[]{matrix[i][j + 1], i, j + 1});
        }

        return res;
    }
}
