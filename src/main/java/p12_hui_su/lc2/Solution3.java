package p12_hui_su.lc2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/description/">40. 组合总和 II</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    private int trackSum = 0;
    private final LinkedList<Integer> track = new LinkedList<>();
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();
        track.clear();
        trackSum = 0;

        Arrays.sort(candidates);
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
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            track.addLast(candidates[i]);
            trackSum += candidates[i];

            backtrack(candidates, i + 1, target);

            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
