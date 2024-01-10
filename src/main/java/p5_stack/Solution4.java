package p5_stack;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("all")
public class Solution4 {

    /**
     * <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram/description/">84. 柱状图中最大的矩形</a>
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];  // 左边第一个 < heights[i] 的元素的索引
        int[] right = new int[n]; // 右边第一个 < heights[i] 的元素的索引

        Deque<Integer> stack;

        // stack 存储的是 < heights[i] 的元素的索引
        stack = new ArrayDeque<>(); // 单调栈: [小 -> 大
        for (int i = 0; i < n; i++) {
            int height = heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] >= height) stack.pop();

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // stack 存储的是 < heights[i] 的元素的索引
        stack = new ArrayDeque<>(); // 单调栈: 大 <- 小]
        for (int i = n - 1; i >= 0; i--) {
            int height = heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] >= height) stack.pop();

            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int l = left[i];
            int r = right[i];
            max = Math.max(max, height * (r - l - 1));
        }

        return max;
    }

    /**
     * <a href="https://leetcode.cn/problems/trapping-rain-water/description/">42. 接雨水</a>
     */
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int l_max = 0; // 左边最高的柱子 [0 ... l]
        int r_max = 0; // 右边最高的柱子 [r ... n - 1]

        // 当 l == r 时处于最高的柱子, 不会形成雨水
        int res = 0;
        while (l < r) {
            l_max = Math.max(l_max, height[l]);
            r_max = Math.max(r_max, height[r]);

            // res += Math.min(l_max, r_max) - height[i]
            if (l_max < r_max) {
                res += l_max - height[l];
                l++;
            } else {
                res += r_max - height[r];
                r--;
            }
        }

        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/container-with-most-water/description/">11. 盛最多水的容器</a>
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        // 当 l == r 时不会形成容器
        int max = 0;
        while (l < r) {
            int curArea = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, curArea);

            if (height[l] < height[r]) l++;
            else r--;
        }

        return max;
    }
}
