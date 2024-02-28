package p5_stack.lc2_monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/remove-k-digits/description/">402. 移掉 K 位数字</a>
     */
    public String removeKdigits(String num, int k) {
        int n = num.length();
        char[] chars = num.toCharArray();

        // deque 存储的是 <= chars[i] 的元素
        Deque<Character> deque = new ArrayDeque<>(); // 单调栈: [小 -> 大
        for (int i = 0; i < n; i++) {
            char c = chars[i];

            while (!deque.isEmpty() && deque.getLast() > c && k > 0) {
                deque.removeLast();
                k--;
            }

            deque.addLast(c);
        }

        while (k > 0) {
            deque.removeLast();
            k--;
        }

        while (!deque.isEmpty() && deque.getFirst() == '0') deque.removeFirst(); // 删除 3 位: 1001239153 -> 0012153 
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) sb.append(deque.removeFirst());
        return sb.length() == 0 ? "0" : sb.toString();                           // 删除 2 位: 1001 -> 00 -> 空
    }

    /**
     * <a href="https://leetcode.cn/problems/create-maximum-number/description/">321. 拼接最大数</a>
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        int min; // 从 nums1 中最少选多少位
        int max; // 从 nums1 中最多选多少位
        if (k > n) min = k - n;
        else min = 0;
        if (k > m) max = m;
        else max = k;

        int[] res = new int[k];
        for (int i = min; i <= max; i++) {
            int x = i;     // 从 nums1 中选 x 位
            int y = k - i; // 从 nums2 中选 y 位
            int[] arr1 = maxSubsequence(nums1, x);
            int[] arr2 = maxSubsequence(nums2, y);
            int[] merge = merge(arr1, arr2);
            res = getMax(res, merge);
        }

        return res;
    }

    private int[] maxSubsequence(int[] arr, int k) {
        int n = arr.length;
        int del = n - k;

        // stack 存储的是 >= arr[i] 的元素
        Deque<Integer> stack = new ArrayDeque<>(); // 单调栈: [大 -> 小
        for (int i = 0; i < n; i++) {
            int num = arr[i];

            while (!stack.isEmpty() && stack.peek() < num && del > 0) {
                stack.pop();
                del--;
            }

            stack.push(num);
        }

        while (del > 0) {
            stack.pop();
            del--;
        }

        int[] res = new int[k];
        int i = k - 1;
        while (!stack.isEmpty()) res[i--] = stack.pop();
        return res;
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int p1 = 0;
        int p2 = 0;

        int[] res = new int[m + n];
        int i = 0;

        while (p1 < m && p2 < n) {
            if (compare(arr1, p1, arr2, p2) > 0) res[i++] = arr1[p1++];
            else res[i++] = arr2[p2++];
        }
        while (p1 < m) res[i++] = arr1[p1++];
        while (p2 < n) res[i++] = arr2[p2++];

        return res;
    }

    // [6, 7] √     [5]
    // [6, 0, 4]    [5, 9] √
    private int compare(int[] arr1, int p1, int[] arr2, int p2) {
        int m = arr1.length;
        int n = arr2.length;
        while (p1 < m && p2 < n) {
            if (arr1[p1] > arr2[p2]) return 1;
            if (arr1[p1] < arr2[p2]) return -1;
            p1++;
            p2++;
        }
        if (p1 >= m && p2 >= n) return 0; // p1 p2 都越界
        if (p1 < m) return 1;             // p2 越界
        return -1;                        // p1 越界
    }

    private int[] getMax(int[] arr1, int[] arr2) {
        int n = arr1.length;
        for (int i = 0; i < n; i++) {
            if (arr1[i] > arr2[i]) return arr1;
            if (arr1[i] < arr2[i]) return arr2;
        }
        return arr1;
    }
}
