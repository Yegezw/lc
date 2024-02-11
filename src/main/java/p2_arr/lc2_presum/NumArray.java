package p2_arr.lc2_presum;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-immutable/description/">303. 区域和检索 - 数组不可变</a>
 */
public class NumArray {

    private final int[] presum; // presum[i] 代表 arr[0 ... i - 1] 的和

    public NumArray(int[] nums) {
        presum = new int[nums.length + 1];
        presum[0] = 0;
        for (int i = 1; i < presum.length; i++) presum[i] = presum[i - 1] + nums[i - 1];
    }

    public int sumRange(int left, int right) {
        return presum[right + 1] - presum[left];
    }
}
