package p99_lu.p1_hui_su.lc1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum/description/">39. 组合总和</a>
 */
@SuppressWarnings("all")
public class Solution5 {

    private int trackSum = 0;
    private final LinkedList<Integer> track = new LinkedList<>();
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res.clear();
        track.clear();
        trackSum = 0;

        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target) return;

        for (int i = start; i < candidates.length; i++) {
            track.addLast(candidates[i]);
            trackSum += candidates[i];

            backtrack(candidates, i, target); // 注意

            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
