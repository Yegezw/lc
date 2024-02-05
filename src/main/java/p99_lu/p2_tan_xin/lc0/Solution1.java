package p99_lu.p2_tan_xin.lc0;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/assign-cookies/description/">455. 分发饼干</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s); // 饼干
        Arrays.sort(g); // 小朋友

        int res = 0;
        int si = s.length - 1; // 最大的饼干
        int gi = g.length - 1; // 最贪心的小朋友

        while (si >= 0 && gi >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                si--;
                gi--;
            } else gi--;
        }

        return res;
    }
}
