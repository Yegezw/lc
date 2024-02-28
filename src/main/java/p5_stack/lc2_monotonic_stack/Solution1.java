package p5_stack.lc2_monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

@SuppressWarnings("all")
public class Solution1 {

    // 单调栈技巧
    // res[i] 代表: 从位置 i 往右看, 第一个 > nums[i] 的元素
    private int[] rightFirstBig(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // stack 存储 > nums[i] 的元素
        Deque<Integer> stack = new ArrayDeque<>(); // 单调栈: 小 <- 大]
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];

            while (!stack.isEmpty() && stack.peek() <= num) stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(num);
        }

        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/next-greater-element-i/description/">496. 下一个更大元素 I</a>
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // stack 存储 > nums2[i] 的元素
        Deque<Integer> stack = new ArrayDeque<>(); // 单调栈: 小 <- 大]
        for (int i = n - 1; i >= 0; i--) {
            int num = nums2[i];

            while (!stack.isEmpty() && stack.peek() <= num) stack.pop();
            map.put(num, stack.isEmpty() ? -1 : stack.peek());

            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) res[i] = map.get(nums1[i]);
        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/next-greater-element-ii/description/">503. 下一个更大元素 II</a>
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // stack 存储 > nums[i] 的元素
        Deque<Integer> stack = new ArrayDeque<>(); // 单调栈: 小 <- 大]
        for (int i = n + n - 1; i >= 0; i--) {
            int num = nums[i % n];

            while (!stack.isEmpty() && stack.peek() <= num) stack.pop();
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(num);
        }

        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/daily-temperatures/description/">739. 每日温度</a>
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        // stack 存储 > nums[i] 的元素的索引
        Deque<Integer> stack = new ArrayDeque<>(); // 单调栈: 小 <- 大]
        for (int i = n - 1; i >= 0; i--) {
            int num = temperatures[i];

            while (!stack.isEmpty() && temperatures[stack.peek()] <= num) stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            stack.push(i);
        }

        return res;
    }
}
