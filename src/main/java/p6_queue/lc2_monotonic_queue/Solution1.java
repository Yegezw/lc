package p6_queue.lc2_monotonic_queue;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/sliding-window-maximum/">239. 滑动窗口最大值</a>
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        // deque 存储的是索引, 队首为 [i - k + 1 ... i] 的最大值
        Deque<Integer> deque = new ArrayDeque<>(); // 单调队列: 大 -> 小
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!deque.isEmpty() && nums[deque.getLast()] <= num) deque.removeLast();
            deque.addLast(i);

            if (i >= k - 1) {
                res[index++] = nums[deque.getFirst()];
                if (deque.getFirst() <= i - k + 1) deque.removeFirst();
            }
        }

        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/description/">862. 和至少为 K 的最短子数组</a>
     */
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] presum = new long[n + 1]; // presum[i] = sum[0 ... i - 1]
        for (int i = 1; i < presum.length; i++) presum[i] = presum[i - 1] + nums[i - 1];

        int res = n + 1; // 假如 presum[r] - presum[l] >= k, 则 res = r - l

        // deque 存储的是索引, 队首为 [0 ... i] 的最小值
        Deque<Integer> deque = new ArrayDeque<>(); // 单调队列: 小 -> 大
        for (int i = 0; i <= n; i++) {
            long sum = presum[i];
            while (!deque.isEmpty() && presum[deque.getLast()] >= sum) deque.removeLast();
            deque.addLast(i);

            while (!deque.isEmpty() && sum - presum[deque.getFirst()] >= k) {
                res = Math.min(res, i - deque.removeFirst());
            }
        }

        return res == n + 1 ? -1 : res;
    }
}
