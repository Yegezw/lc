package p12_hui_su.lc3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/description/">131. 分割回文串</a>
 */
@SuppressWarnings("all")
public class Solution2 {

    private final LinkedList<String> track = new LinkedList<>();
    private final List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        track.clear();
        res.clear();

        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int start) {
        // s 遍历完成
        if (start == s.length()) {
            res.add(new LinkedList<>(track));
            return;
        }

        // s[start ... end]
        for (int end = start; end < s.length(); end++) {
            if (!isValid(s, start, end)) continue;

            track.addLast(s.substring(start, end + 1));

            backtrack(s, end + 1);

            track.removeLast();
        }
    }

    private boolean isValid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
