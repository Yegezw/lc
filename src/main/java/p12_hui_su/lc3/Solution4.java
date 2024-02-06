package p12_hui_su.lc3;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/generate-parentheses/description/">22. 括号生成</a>
 */
@SuppressWarnings("all")
public class Solution4 {

    private StringBuilder track;
    private final List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        track = new StringBuilder();
        res.clear();

        backtrack(0, 0, n);
        return res;
    }

    // 已有 left 个左括号和 right 个右括号
    private void backtrack(int left, int right, int n) {
        if (left == n && right == n) {
            res.add(track.toString());
            return;
        }

        // 合法括号组合的子串: 左括号的数量 >= 右括号的数量
        if (left < right) return;
        // 最多 n 个左括号, n 个右括号
        if (left > n || right > n) return;

        track.append('(');
        backtrack(left + 1, right, n);
        track.deleteCharAt(track.length() - 1);

        track.append(')');
        backtrack(left, right + 1, n);
        track.deleteCharAt(track.length() - 1);
    }
}
