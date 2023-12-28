package p2_arr.diff;

@SuppressWarnings("all")
public class Solution {

    /**
     * <a href="https://leetcode.cn/problems/range-addition/description/">370. 区间加法</a>
     */
    int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference df = new Difference(nums);

        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
        }

        return df.result();
    }

    /**
     * <a href="https://leetcode.cn/problems/corporate-flight-bookings/">1109. 航班预订统计</a>
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference df = new Difference(nums);

        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            df.increment(i, j, val);
        }

        return df.result();
    }

    /**
     * <a href="https://leetcode.cn/problems/car-pooling/description/">1094. 拼车</a>
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001]; // 站台 [0 ... 1000]
        Difference df = new Difference(nums);

        for (int[] trip : trips) {
            int i = trip[1];     // 第 trip[1] 站乘客上车
            int j = trip[2] - 1; // 第 trip[2] 站乘客已经下车
            int val = trip[0];   // 乘客数量
            df.increment(i, j, val);
        }

        int[] res = df.result();
        for (int i : res) {
            if (i > capacity) return false;
        }
        return true;
    }
}
