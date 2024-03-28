package p14_dp.lc2_subsequence.lc1;

import java.util.Arrays;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/">300. 最长递增子序列</a>
     */
    public int lengthOfLIS1(int[] nums) {
        // memo[i] = nums[0 ... i] 选择数字 nums[i] 可以获得的最长上升子序列的长度
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            // 求解 memo[i]
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j]) memo[i] = Math.max(memo[i], 1 + memo[j]);
            }
            maxLen = Math.max(maxLen, memo[i]);
        }

        return maxLen;
    }

    // dp 输出路径
    public int lengthOfLIS2(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        // prev[i] = 以 i 为结尾的 LIS 的上一个元素的索引
        int[] prev = new int[nums.length];

        int maxLen = 1;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            // 求解 memo[i] 和 prev[i]
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j] && 1 + memo[j] > memo[i]) {
                    memo[i] = 1 + memo[j];
                    prev[i] = j;
                }
            }

            if (memo[i] > maxLen) {
                maxLen = memo[i];
                end = i;
            }
        }

        // 输出路径
        int[] arr = new int[maxLen];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = nums[end];
            end = prev[end];
        }
        System.out.println(Arrays.toString(arr)); // 输出最长上升子序列

        return maxLen;
    }

    // 耐心排序输出路径
    public int lengthOfLIS3(int[] nums) {
        // piles 中的元素是递增的
        int[] piles = new int[nums.length];

        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // 从 piles[0 ... size - 1] 中查找 >= num 的最小值
            int l = 0;
            int r = size;
            while (l < r) {
                int mid = (l + r) / 2;
                if (piles[mid] >= num) r = mid;
                else l = mid + 1;
            }
            if (r == size) size++;

            piles[r] = num;
        }

        int[] arr = Arrays.copyOf(piles, size);
        System.out.println(Arrays.toString(arr)); // 输出最长上升子序列 TODO 这里是错误的
        return size;
    }

    /**
     * <a href="https://leetcode.cn/problems/russian-doll-envelopes/description/">354. 俄罗斯套娃信封问题</a>
     */
    public int maxEnvelopes(int[][] envelopes) {
        // 按宽度升序排列, 如果宽度一样, 则按高度降序排列
        Arrays.sort(envelopes, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);

        // 对高度数组寻找 LIS
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        return lengthOfLIS3(heights);
    }
}
