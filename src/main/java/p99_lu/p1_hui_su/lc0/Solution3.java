package p99_lu.p1_hui_su.lc0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combinations/description/">77. 组合</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    LinkedList<Integer> track = new LinkedList<>(); // 路径
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        track.clear();

        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int end, int k) {
        // 到达叶子节点, 将路径装入结果列表
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 当前的选择列表为 [start ... end], 路径为 track
        // track.size() == k 时结束, 因此当前 track 中有 k - track.size() 个空位
        // 选择列表的大小 >= track 的空位个数, 即 end - start + 1 >= k - track.size()
        for (int i = start; i <= end - (k - track.size() - 1); i++) {
            track.addLast(i);              // 做选择

            backtrack(i + 1, end, k); // 进入下一层回溯树

            track.removeLast();            // 取消选择
        }
    }
}
