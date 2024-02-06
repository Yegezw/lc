package p13_tan_xin.lc1;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/meeting-rooms-ii/">253. 会议室 II</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    public int minMeetingRooms(int[][] meetings) {
        int n = meetings.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < meetings.length; i++) {
            begin[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);

        int res = 0;

        int count = 0;
        int bi = 0, ei = 0;
        while (bi < n && ei < n) {
            // 注意 begin[bi] == end[ei] 时先绿点
            if (begin[bi] < end[ei]) {
                count++;
                bi++;
            } else {
                count--;
                ei++;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}
