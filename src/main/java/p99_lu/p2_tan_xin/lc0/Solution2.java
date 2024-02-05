package p99_lu.p2_tan_xin.lc0;

import java.util.Arrays;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * <a href="https://leetcode.cn/problems/non-overlapping-intervals/description/">435. 无重叠区间</a>
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // 按 end 升序排序
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        // 至少有一个区间不相交
        int count = 1;
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= end) {
                // 找到下一个不相交的区间了
                count++;
                end = interval[1];
            }
        }

        return intervals.length - count;
    }

    /**
     * <a href="https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description/">452. 用最少数量的箭引爆气球</a>
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // 按 end 升序排序
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        // 至少有一个区间不相交
        int count = 1;
        int end = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if (start > end) {
                // 找到下一个不相交的区间了
                count++;
                end = point[1];
            }
        }

        return count;
    }
}
