package p14_dp.lc4_game.lc1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/triangle/description/">120. 三角形最小路径和</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        memo = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            memo.add(new HashMap<>());
        }

        int res = Integer.MAX_VALUE;
        int width = triangle.get(size - 1).size();
        for (int i = width - 1; i >= 0; i--) {
            res = Math.min(res, dp(triangle, size - 1, i));
        }
        return res;
    }

    private List<Map<Integer, Integer>> memo; // memo[x][y]

    // 返回 triangle[0][0] 到 triangle[x][y] 的最小路径和
    private int dp(List<List<Integer>> triangle, int x, int y) {
        if (y < 0 || y >= triangle.get(x).size()) return Integer.MAX_VALUE;
        if (x == 0 && y == 0) return triangle.get(0).get(0);

        if (!memo.get(x).containsKey(y)) {
            int res = triangle.get(x).get(y) + Math.min(
                    dp(triangle, x - 1, y),
                    dp(triangle, x - 1, y - 1)
            );
            memo.get(x).put(y, res);
        }

        return memo.get(x).get(y);
    }
}
