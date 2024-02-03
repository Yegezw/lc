package p99_lu.p1_hui_su.lc1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/description/">78. 子集</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    private final LinkedList<Integer> track = new LinkedList<>();
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        track.clear();
        res.clear();

        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        // 每个节点的路径都是一个子集
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);

            backtrack(nums, i + 1);

            track.removeLast();
        }
    }
}
