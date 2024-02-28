package p6_queue.lc2_monotonic_queue;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/">1438. 绝对差不超过限制的最长连续子数组</a>
     */
    public int longestSubarray(int[] nums, int limit) {
        int l = 0, r = -1; // [l ... r] 为滑动窗口
        Deque<Integer> min = new ArrayDeque<>(); // 单调队列: 小 -> 大, 存储的是索引, 队首为 [l ... r] 的最小值
        Deque<Integer> max = new ArrayDeque<>(); // 单调队列: 大 -> 小, 存储的是索引, 队首为 [l ... r] 的最大值
        int res = 0;

        while (l < nums.length) {
            if (r + 1 < nums.length && (min.isEmpty() || nums[max.getFirst()] - nums[min.getFirst()] <= limit)) {
                r++;
                int num = nums[r];

                while (!min.isEmpty() && nums[min.getLast()] >= num) min.removeLast();
                min.addLast(r);

                while (!max.isEmpty() && nums[max.getLast()] <= num) max.removeLast();
                max.addLast(r);
            } else {
                l++;
                if (min.getFirst() < l) min.removeFirst();
                if (max.getFirst() < l) max.removeFirst();
            }

            if (!min.isEmpty() && nums[max.getFirst()] - nums[min.getFirst()] <= limit) res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
