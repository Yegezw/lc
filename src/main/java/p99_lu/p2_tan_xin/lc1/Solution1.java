package p99_lu.p2_tan_xin.lc1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class Solution1 {

    /**
     * <a href="https://leetcode.cn/problems/remove-covered-intervals/description/">1288. 删除被覆盖区间</a>
     */
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length <= 1) return intervals.length;

        // start 升序 end 降序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            else return Integer.compare(o2[1], o1[1]);
        });

        int count = 0;
        int end = 0;
        for (int[] interval : intervals) {
            if (interval[1] > end) {
                count++;
                end = interval[1];
            }
        }

        return count;
    }

    /**
     * <a href="https://leetcode.cn/problems/merge-intervals/description/">56. 合并区间</a>
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // start 升序
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = list.get(list.size() - 1);
            if (cur[0] <= last[1]) last[1] = Math.max(last[1], cur[1]); // 区间覆盖 -> 合并
            else list.add(cur);                                         // 新的区间 -> 添加到 list
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/interval-list-intersections/description/">986. 区间列表的交集</a>
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < firstList.length && p2 < secondList.length) {
            int[] a = firstList[p1];
            int[] b = secondList[p2];

            int l = Math.max(a[0], b[0]);
            int r = Math.min(a[1], b[1]);
            if (l <= r) list.add(new int[]{l, r}); // 存在交集

            if (a[1] < b[1]) p1++;
            else p2++;
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
