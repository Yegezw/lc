package p2_arr.presum;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-immutable/description/">303. 区域和检索 - 数组不可变</a>
 */
public class NumArray {

    private final int[] sum; // sum[i] 代表 arr[0 ... i - 1] 的和

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) sum[i] = sum[i - 1] + nums[i - 1];
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
