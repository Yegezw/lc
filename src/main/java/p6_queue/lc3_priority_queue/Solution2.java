package p6_queue.lc3_priority_queue;

import java.util.PriorityQueue;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/">215. 数组中的第 K 个最大元素</a>
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.remove();
        }
        return minHeap.peek();
    }

    /**
     * <a href="https://leetcode.cn/problems/smallest-k-lcci/description/">面试题 17.14. 最小 K 个数</a>
     */
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : arr) {
            maxHeap.add(i);
            if (maxHeap.size() > k) maxHeap.remove();
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = maxHeap.remove();
        return res;
    }
}
