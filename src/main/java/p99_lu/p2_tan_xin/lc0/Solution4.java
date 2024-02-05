package p99_lu.p2_tan_xin.lc0;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/video-stitching/description/">1024. 视频拼接</a>
 */
@SuppressWarnings("all")
public class Solution4 {

    public int videoStitching(int[][] clips, int time) {
        if (time == 0) return 0;

        // start 升序 end 降序
        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            else return Integer.compare(o2[1], o1[1]);
        });

        int count = 0; // 记录选择的短视频个数

        int curEnd = 0;
        int nextEnd = 0;
        int i = 0;
        int n = clips.length;
        while (i < n && clips[i][0] <= curEnd) {
            // 贪心选择能够覆盖 curEnd 的下一个视频片段
            while (i < n && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }

            // 找到下一个视频, 更新 curEnd
            curEnd = nextEnd;
            count++;

            // 已经可以拼出区间 [0 ... time]
            if (curEnd >= time) return count;
        }

        return -1; // 无法连续拼出区间 [0 ... time]
    }
}
