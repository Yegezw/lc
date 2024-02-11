package p2_arr.lc8_rand;

import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/shuffle-an-array/description/">384. 打乱数组</a>
 */
public class Solution4 {

    private final int[] nums;
    private final Random random;

    public Solution4(int[] nums) {
        this.nums = nums.clone();
        random = new Random();
    }

    public int[] reset() {
        return nums.clone();
    }

    /**
     * 从后向前决定排列中的每个元素
     */
    public int[] shuffle1() {
        int[] data = nums.clone();
        for (int i = data.length - 1; i >= 0; i--) {
            // random[0 ... i]
            int j = random.nextInt(i + 1);
            swap(data, i, j);
        }
        return data;
    }

    /**
     * 从前向后决定排列中的每个元素
     */
    public int[] shuffle2() {
        int[] data = nums.clone();
        for (int i = 0; i < data.length; i++) {
            // random[i ... data.length - 1]
            int j = i + random.nextInt(data.length - i);
            swap(data, i, j);
        }
        return data;
    }

    private void swap(int[] arr, int a, int b) {
        int k = arr[a];
        arr[a] = arr[b];
        arr[b] = k;
    }
}
