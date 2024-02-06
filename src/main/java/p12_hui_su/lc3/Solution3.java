package p12_hui_su.lc3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/word-break-ii/description/">140. 单词拆分 II</a>
 */
@SuppressWarnings("all")
public class Solution3 {

    private StringBuilder track;
    private final List<String> res = new ArrayList<>();
    private HashSet<String> set;

    public List<String> wordBreak(String s, List<String> wordDict) {
        res.clear();
        track = new StringBuilder();

        set = new HashSet<>(wordDict);
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int start) {
        // s 遍历完成
        if (start == s.length()) {
            res.add(track.toString().trim());
            return;
        }

        // s[start ... end]
        for (int end = start; end < s.length(); end++) {
            String cur = s.substring(start, end + 1);
            if (set.contains(cur)) {
                track.append(cur).append(" ");

                backtrack(s, end + 1);

                track.delete(track.length() - cur.length() - 1, track.length());
            }
        }
    }
}
