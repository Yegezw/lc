package p2_arr.lc7_binary;

import java.util.Arrays;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/koko-eating-bananas/description/">875. 爱吃香蕉的珂珂</a>
     */
    public int minEatingSpeed(int[] piles, int h) {
        int speedL = 1;
        int speedR = Arrays.stream(piles).max().getAsInt();
        int speedMid;

        // [speedL ... speedR] 代表吃香蕉的速度, times = getEatingTime(speed)
        // 二分搜索 times <= h 最大的 times 对应 speed
        // 每次循环开始时: speedL 还没看, speedR 可能是解, 因此当 speedL == speedR 时, speedR 就是解
        while (speedL < speedR) {
            speedMid = speedL + (speedR - speedL) / 2;
            int times = getEatingTime(piles, speedMid);
            if (times <= h) speedR = speedMid;
            else speedL = speedMid + 1;
        }

        return speedR;
    }

    private int getEatingTime(int[] piles, int speed) {
        int times = 0;
        for (int pile : piles) times += pile / speed + (pile % speed != 0 ? 1 : 0);
        return times;
    }

    /**
     * <a href="https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/description/">1011. 在 D 天内送达包裹的能力</a>
     */
    public int shipWithinDays(int[] weights, int days) {
        int capacityL = Arrays.stream(weights).max().getAsInt();
        int capacityR = Arrays.stream(weights).sum();
        int capacityMid;

        // [capacityL ... capacityR] 代表运载能力, times = getShipTime(capacity)
        // 二分搜索 times <= days 最大的 time 对应 capacity
        // 每次循环开始时: capacityL 还没看, capacityR 可能是解, 因此当 capacityL == capacityR 时, capacityR 就是解
        while (capacityL < capacityR) {
            capacityMid = capacityL + (capacityR - capacityL) / 2;
            int times = getShipTime(weights, capacityMid);
            if (times <= days) capacityR = capacityMid;
            else capacityL = capacityMid + 1;
        }

        return capacityR;
    }

    private int getShipTime(int[] weights, int capacity) {
        int times = 0;
        int hasCapacity = 0;
        for (int weight : weights) {
            if (hasCapacity + weight <= capacity) hasCapacity += weight;
            else {
                times++;
                hasCapacity = weight;
            }
        }
        return times + 1;
    }

    /**
     * <a href="https://leetcode.cn/problems/split-array-largest-sum/description/">410. 分割数组的最大值</a>
     */
    public int splitArray(int[] nums, int k) {
        int sumL = Arrays.stream(nums).max().getAsInt();
        int sumR = Arrays.stream(nums).sum();
        int sumMid;

        // [sumL ... sumR] 代表子数组和, count = getSplitCount(sum)
        // 二分搜索 count <= k 最大的 count 对应 sum
        // 每次循环开始时: sumL 还没看, sumR 可能是解, 因此当 sumL == sumR 时, sumR 就是解
        while (sumL < sumR) {
            sumMid = sumL + (sumR - sumL) / 2;
            int count = getSplitCount(nums, sumMid);
            if (count <= k) sumR = sumMid;
            else sumL = sumMid + 1;
        }

        return sumR;
    }

    private int getSplitCount(int[] nums, int sum) {
        int count = 0;
        int hasSum = 0;
        for (int num : nums) {
            if (hasSum + num <= sum) hasSum += num;
            else {
                count++;
                hasSum = num;
            }
        }
        return count + 1;
    }
}
