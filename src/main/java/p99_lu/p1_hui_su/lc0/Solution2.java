package p99_lu.p1_hui_su.lc0;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/permutations/description/">46. 全排列</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    private final List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res.clear();
        if (nums == null || nums.length == 0) return res;

        used = new boolean[nums.length];
        Arrays.fill(used, false);

        LinkedList<Integer> track = new LinkedList<>(); // 路径
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        // 到达叶子节点, 将路径装入结果列表
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;  // 排除不合法的选择

            track.add(nums[i]);     // 做选择
            used[i] = true;
            backtrack(nums, track); // 进入下一层回溯树

            track.removeLast();     // 取消选择
            used[i] = false;
        }
    }
}
