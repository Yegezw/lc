package p12_hui_su.lc3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/restore-ip-addresses/description/">93. 复原 IP 地址</a>
 */
@SuppressWarnings("all")
public class Solution1 {

    private final LinkedList<String> track = new LinkedList<>();
    private final List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        track.clear();
        res.clear();

        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int start) {
        // s 遍历完成
        if (start == s.length()) {
            if (track.size() == 4) res.add(String.join(".", track));
            return;
        }
        // s 未遍历完成
        if (track.size() == 4) return;

        // s[start ... end]
        for (int end = start; end < s.length(); end++) {
            if (end - start + 1 > 3) break;
            if (!isValid(s, start, end)) continue;

            track.addLast(s.substring(start, end + 1));

            backtrack(s, end + 1);

            track.removeLast();
        }
    }

    private boolean isValid(String s, int l, int r) {
        int len = r - l + 1;

        // len == 1
        if (len == 1) return true;

        // len == 2
        if (len == 2) {
            if (s.charAt(l) == '0') return false;
            else return true;
        }

        // len == 3
        if (s.charAt(l) == '0') return false;
        if (Integer.parseInt(s.substring(l, l + len)) > 255) return false;
        else return true;
    }
}
