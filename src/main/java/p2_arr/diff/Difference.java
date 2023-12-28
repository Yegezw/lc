package p2_arr.diff;

/**
 * 差分数组
 */
public class Difference {

    private final int[] diff; // diff[i] 代表 nums[i - 1] 与 nums[i] 之差

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * 向 nums 区间 [i ... j] 增加 val(可以是负数)
     */
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) diff[j + 1] -= val;
    }

    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
