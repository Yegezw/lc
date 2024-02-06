package p12_hui_su.lc2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets-ii/description/">90. 子集 II</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    private final LinkedList<Integer> track = new LinkedList<>();
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.clear();
        track.clear();

        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        // 每个节点的路径都是一个子集
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            track.addLast(nums[i]);

            backtrack(nums, i + 1);

            track.removeLast();
        }
    }
}
