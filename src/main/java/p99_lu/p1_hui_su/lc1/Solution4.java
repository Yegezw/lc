package p99_lu.p1_hui_su.lc1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations-ii/description/">47. 全排列 II</a>
 */
@SuppressWarnings("all")
public class Solution4 {

    private boolean[] used;
    private final LinkedList<Integer> track = new LinkedList<>();
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        res.clear();
        track.clear();

        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);

        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // 固定相同元素在排列中的相对位置: 如果前面的相邻相等元素没有用过, 则跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            track.addLast(nums[i]);
            used[i] = true;

            backtrack(nums);

            track.removeLast();
            used[i] = false;
        }
    }
}
